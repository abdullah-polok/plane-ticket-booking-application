import java.util.Scanner;

class TicketBook {

    static Scanner input = new Scanner(System.in);
    static int totalFare;
    static int status;

    ///Ticket price on each class
    static int economyClass = 100000;
    static int businessClass = 200000;
    static int firstClass = 300000;
    static int roundTrip = 100000;

    /// flight seats allocation depends on classes
    static int[][] firstClassSeats = new int[4][2];
    static int[][] economyClassSeats = new int[10][6];
    static int[][] businessClassSeats = new int[6][4];
    static int[] firstClassSeatNumber = new int[8];
    static int[] economyClassSeatNumber = new int[60];
    static int[] businessClassSeatNumber = new int[24];
    static char theClass;
    static int fare;
    static int ticket;
    static double totalTicketAmount;
    static int universalRow;

    public static void main(String[] args) {
        // 1. viewing the options
        /*
         * but firstly we need an infinite for loop so the options will be shown
         * until exist is chosen
         */
        // displaySeats(seatBluePrint);
        for (;;) {

            System.out.println("-----+-----+-----");
            System.out.println("");
            System.out.println(
                    "1.Select the flight class              6.view current status of the plane seating arrangement");
            System.out.println("2.Book a seat                          7.View list of seats reserved");
            System.out.println("3.view the booked e-ticket information 8.display the status of the seat");
            System.out.println("4.view lists of all booked seats       9.view a report of the booked seats");
            System.out.println("5.cancel your flight                   10.exit");

            System.out.println("");
            // 2. asking the user to enter their choice:
            System.out.println("-----+-----+-----");
            System.out.print("Please, Enter your choice: ");
            int choiceNumber = input.nextInt();
            System.out.println("-----+-----+-----");
            System.out.println("");
            // 3. we are making a switch statement in order to go through the options
            // according to the users choice
            switch (choiceNumber) {

                // case no.1 goes through the classes and their prices
                case 1:
                    // we call the flightClass method because the operations are done in that method
                    flightClasses();
                    break;
                case 2:
                    bookFlightSeats();/// Call book a flight seat function
                    break;
                case 3:
                    viewEticket();///Call view eticket function
                    break;
                case 4:
                    viewAllSeats();
                    break;
                case 5:
                    flightCancellation();
                    break;
                case 8:
                    displaySeatStatus();
                    break;
                case 9:
                    viewReportOfBookedSeats();
                    break;

            }

        }
    }

    // this method is dedicated to case no.1
    public static void flightClasses() {

        // we print the prices for the user to see
        System.out.println("Economy class is 100,000IQD");
        System.out.println("Business class is 200,000IQD");
        System.out.println("First class class is 300,000IQD");
        System.out.println("and additional roundtrip is 100,000IQD");
        System.out.println("-----+-----+-----");
        // here we ask the user to enter their class choice
        System.out.print("Write 'a' for Economy class, write 'b' for business class, or 'c' for first class: ");
        char theClass = input.next().charAt(0);

        // we make if-else statements to differentiate between each class
        if (Character.toLowerCase(theClass) == 'a') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt(); /// Choose for user fare
            if (fare == 1)
                System.out.println("The total price of your flight  is " + economyClass + " IQD");
            else {
                System.out.println("The total price of your flight with additional roundTrip  is " + (economyClass
                        + roundTrip) + " IQD");
            }
        } else if (Character.toLowerCase(theClass) == 'b') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt();
            if (fare == 1)
                System.out.println("The total price of your flight  is " + businessClass + " IQD");
            else {
                System.out.println("The total price of your flight with additional roundTrip  is " + (businessClass
                        + roundTrip) + " IQD");
            }
        } else if (Character.toLowerCase(theClass) == 'c') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt();
            if (fare == 1)
                System.out.println("The total price of your flight  is " + firstClass + " IQD");
            else {
                System.out.println("The total price of your flight with additional roundTrip  is " + (firstClass
                        + roundTrip) + " IQD");
            }

        }

        // if the user tries to write any letter other than the valid ones he/she will
        // get an error
        else {
            System.out.println("invalid letter, try again...");
        }

        System.out.println("");
    }

    /// this method book flight seat
    public static void bookFlightSeats() {
        // we spcify the prices of each class

        // we print the prices for the user to see
        System.out.println("Economy class is 100,000IQD");
        System.out.println("Business class is 200,000IQD");
        System.out.println("First class class is 300,000IQD");
        System.out.println("and additional roundtrip is 100,000IQD");
        System.out.println("-----+-----+-----");
        // here we ask the user to enter their class choice
        System.out.print("Write 'a' for Economy class, write 'b' for business class, or 'c' for first class: ");
        theClass = input.next().charAt(0);

        // we make if-else statements to differentiate between each class
        if (Character.toLowerCase(theClass) == 'a') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            fare = input.nextInt(); /// Choose for user fare

            /// Taking ticket input from user
            System.out.println("Enter number of ticket");
            ticket = input.nextInt();
            /// Check seats are reserved or empty
            checkSeatStatus(economyClassSeats);

            /// Taking seat input from user
            System.out.println("Enter your seat numbers:");
            for (int num = 0; num < ticket; num++) {
                int seat = input.nextInt();
                economyClassSeatNumber[num] = seat; /// Choose seat numbers
            }

            /// Taking row input from user
            System.out.println("Enter your row number for seat");
            universalRow = input.nextInt();

            bookingSeatsProcess(universalRow, economyClassSeatNumber, ticket);
            checkSeatStatus(economyClassSeats);

            if (fare == 1) {
                totalTicketAmount = (economyClass * ticket);
            } else {
                totalTicketAmount = (economyClass + roundTrip) * ticket;
            }

        } else if (Character.toLowerCase(theClass) == 'b') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt();

            /// Taking ticket input from user
            System.out.println("Enter number of ticket");
            int ticket = input.nextInt();
            /// Check seats are reserved or empty
            checkSeatStatus(businessClassSeats);

            /// Taking seat input from user
            System.out.println("Enter your seat numbers:");
            for (int num = 0; num < ticket; num++) {
                int seat = input.nextInt();
                businessClassSeatNumber[num] = seat; /// Choose seat numbers
            }

            /// Taking row input from user
            System.out.println("Enter your row number for seat");
            universalRow = input.nextInt();

            bookingSeatsProcess(universalRow, businessClassSeatNumber, ticket);

            checkSeatStatus(businessClassSeats);

            if (fare == 1) {
                totalTicketAmount = (businessClass * ticket);
            } else {
                totalTicketAmount = (businessClass + roundTrip) * ticket;
            }
        } else if (Character.toLowerCase(theClass) == 'c') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt();
            checkSeatStatus(firstClassSeats);

            /// Taking ticket input from user
            System.out.println("Enter number of ticket");
            int ticket = input.nextInt();
            /// Check seats are reserved or empty
            checkSeatStatus(firstClassSeats);

            /// Taking seat input from user
            System.out.println("Enter your seat numbers:");
            for (int num = 0; num < ticket; num++) {
                int seat = input.nextInt();
                firstClassSeatNumber[num] = seat; /// Choose seat numbers
            }

            /// Taking row input from user
            System.out.println("Enter your row number for seat");
            universalRow = input.nextInt();

            bookingSeatsProcess(universalRow, firstClassSeatNumber, ticket);

            checkSeatStatus(firstClassSeats);

            if (fare == 1) {
                totalTicketAmount = (firstClass * ticket);
            } else {
                totalTicketAmount = (firstClass + roundTrip) * ticket;
            }

        }

        // if the user tries to write any letter other than the valid ones he/she will
        // get an error
        else {
            System.out.println("invalid letter, try again...");
        }

        System.out.println("");
    }

    // this method to display seat layout
    public static void checkSeatStatus(int[][] seats) {
        if (theClass == 'a') {
            int rows = seats.length;
            int columns = seats[0].length;

            System.out.println("Seat Layout:");
            System.out.println("A B C D E F");
            System.out.println("_ _ _ _ _ _");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(seats[i][j] + " "); // display seat status
                }
                System.out.println();
            }
        } else if (theClass == 'b') {
            int rows = seats.length;
            int columns = seats[0].length;

            System.out.println("Seat Layout:");
            System.out.println("A B C D ");
            System.out.println("_ _ _ _ ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(seats[i][j] + " "); // display seat status
                }
                System.out.println();
            }
        } else {
            int rows = seats.length;
            int columns = seats[0].length;

            System.out.println("Seat Layout:");
            System.out.println("A B");
            System.out.println("_ _");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(seats[i][j] + " "); // display seat status
                }
                System.out.println();
            }
        }
    }

    // this method to insert seat numbers seat layout
    public static void bookingSeatsProcess(int userRowNumber, int commonClass[], int tickets) {

        if (theClass == 'a') {
            for (int row = 0; row < tickets; row++) {
                for (int column = 0; column < economyClassSeats[0].length; column++) {

                    ///Check seats number equal to column index number 
                    if (commonClass[row] == column + 1)
                        economyClassSeats[userRowNumber][column] = 1;

                }

            }
        } else if (theClass == 'b') {
            for (int row = 0; row < tickets; row++) {
                for (int column = 0; column < businessClassSeats[0].length; column++) {

                    ///Check seats number equal to column index number 
                    if (commonClass[row] == column + 1)
                        businessClassSeats[userRowNumber][column] = 1;

                }

            }
        } else {
            for (int row = 0; row < tickets; row++) {
                for (int column = 0; column < firstClassSeats[0].length; column++) {

                    ///Check seats number equal to column index number 
                    if (commonClass[row] == column + 1)
                        firstClassSeats[userRowNumber][column] = 1;

                }

            }
        }

    }

    ///this method to display booked e-ticket
    public static void viewEticket() {

        if (Character.toLowerCase(theClass) == 'a') {
            System.out.println("Passenger Information");
            System.out.println("------------------------------");
            System.out.println("Flight Class : Economy");
            System.out.println("");
            System.out.println("Seat Details:");
            System.out.println("------------------------------");
            System.out.println("Number of Tickets Booked: " + ticket);
            System.out.print("Seat Numbers: ");

            for (int i = 0; i < ticket; i++) {
                System.out.print(economyClassSeatNumber[i] + ",");
            }

            System.out.println("");
            System.out.println("");
            System.out.println("Payment Summary:");
            System.out.println("------------------------------");
            System.out.println(
                    "Total Amount Paid :" + totalTicketAmount + " IQD");
        } else if (Character.toLowerCase(theClass) == 'b') {
            System.out.println("Passenger Information");
            System.out.println("------------------------------");
            System.out.println("Flight Class : Business");
            System.out.println("");
            System.out.println("Seat Details:");
            System.out.println("------------------------------");
            System.out.println("Number of Tickets Booked: " + ticket);
            System.out.print("Seat Numbers: ");

            for (int i = 0; i < ticket; i++) {
                System.out.print(businessClassSeatNumber[i] + ",");
            }

            System.out.println("");
            System.out.println("");
            System.out.println("Payment Summary:");
            System.out.println("------------------------------");
            System.out.println(
                    "Total Amount Paid :" + totalTicketAmount + " IQD");
        } else if (Character.toLowerCase(theClass) == 'c') {
            System.out.println("Passenger Information");
            System.out.println("------------------------------");
            System.out.println("Flight Class : First Class");
            System.out.println("");
            System.out.println("Seat Details:");
            System.out.println("------------------------------");
            System.out.println("Number of Tickets Booked: " + ticket);
            System.out.print("Seat Numbers: ");

            for (int i = 0; i < ticket; i++) {
                System.out.print(firstClassSeatNumber[i] + ",");
            }

            System.out.println("");
            System.out.println("");
            System.out.println("Payment Summary:");
            System.out.println("------------------------------");
            System.out.println(
                    "Total Amount Paid :" + totalTicketAmount + " IQD");
        }
    }

    ///this method to display all booked seats ascending or desceding order
    public static void viewAllSeats() {
        if (Character.toLowerCase(theClass) == 'a') {
            System.out.println("Enter 'a' for ascending order or 'b' for descending order booked seat numbers:");
            char orderSeat = input.next().charAt(0);
            if (Character.toLowerCase(theClass) == 'a') {
                System.out.println("Your ascending tickets list:");
                for (int tick = 0; tick < ticket; tick++) {
                    System.out.print(economyClassSeatNumber[tick] + " ");
                }
            } else {
                System.out.println("Your  Descending  tickets list:");
                for (int tick = ticket - 1; tick > 0; tick++) {
                    System.out.print(economyClassSeatNumber[tick] + " ");
                }

            }
        } else if (Character.toLowerCase(theClass) == 'b') {
            System.out.println("Enter 'a' for ascending order or 'b' for descending order booked seat numbers:");
            char orderSeat = input.next().charAt(0);
            if (Character.toLowerCase(theClass) == 'a') {
                System.out.println("Your ascending tickets list:");
                for (int tick = 0; tick < ticket; tick++) {
                    System.out.print(businessClassSeatNumber[tick] + " ");
                }
            } else {
                System.out.println("Your  Descending  tickets list:");
                for (int tick = ticket - 1; tick > 0; tick++) {
                    System.out.print(businessClassSeatNumber[tick] + " ");
                }

            }
        } else {
            System.out.println("Enter 'a' for ascending order or 'b' for descending order booked seat numbers:");
            char orderSeat = input.next().charAt(0);
            if (Character.toLowerCase(theClass) == 'a') {
                System.out.println("Your ascending tickets list:");
                for (int tick = 0; tick < ticket; tick++) {
                    System.out.print(firstClassSeatNumber[tick] + " ");
                }
            } else {
                System.out.println("Your  Descending  tickets list:");
                for (int tick = ticket - 1; tick > 0; tick++) {
                    System.out.print(firstClassSeatNumber[tick] + " ");
                }

            }
        }
        System.out.println("");
    }

    ///this method to cancel flight 
    public static void flightCancellation() {

        System.out.print("Write 'a' for Economy class, write 'b' for business class, or 'c' for first class: ");
        char localtheClass = input.next().charAt(0);

        if (localtheClass == 'a') {

            ///Taking class and cancellation seat numbers from user
            System.out.println("Enter your booked seat number for cancel:");
            int cancelFlight[] = new int[economyClassSeats[0].length];

            for (int count = 0; count < ticket; count++) {
                cancelFlight[count] = input.nextInt();
            }

            ///Insert zero on that seat for cancelling the flight ticket
            for (int row = 0; row < economyClassSeats[0].length; row++) {

                ///Check seats number equal to row index number 
                if (economyClassSeatNumber[row] == cancelFlight[row])
                    economyClassSeats[universalRow][row] = 0;

            }

            ///Deduct 2% from total purchase ticket;
            totalTicketAmount = totalTicketAmount - (totalTicketAmount * 0.2);
            System.out.println("Your total refund amount with 2% deduction is:" + totalTicketAmount);

        } else if (localtheClass == 'b') {
            ///Taking class and cancellation seat numbers from user
            System.out.println("Enter your booked seat number for cancel:");
            int cancelFlight[] = new int[businessClassSeats[0].length];

            for (int count = 0; count < ticket; count++) {
                cancelFlight[count] = input.nextInt();
            }

            ///Insert zero on that seat for cancelling the flight ticket
            for (int row = 0; row < businessClassSeats[0].length; row++) {

                ///Check seats number equal to row index number 
                if (businessClassSeatNumber[row] == cancelFlight[row])
                    businessClassSeats[universalRow][row] = 0;

            }

            ///Deduct 2% from total purchase ticket;
            totalTicketAmount = totalTicketAmount - (totalTicketAmount * 0.2);
            System.out.println("Your total refund amount with 2% deduction is:" + totalTicketAmount);
        } else {
            ///Taking class and cancellation seat numbers from user
            System.out.println("Enter your booked seat number for cancel:");
            int cancelFlight[] = new int[firstClassSeats[0].length];

            for (int count = 0; count < ticket; count++) {
                cancelFlight[count] = input.nextInt();
            }

            ///Insert zero on that seat for cancelling the flight ticket
            for (int row = 0; row < firstClassSeats[0].length; row++) {

                ///Check seats number equal to row index number 
                if (firstClassSeatNumber[row] == cancelFlight[row])
                    firstClassSeats[universalRow][row] = 0;

            }

            ///Deduct 2% from total purchase ticket;
            totalTicketAmount = totalTicketAmount - (totalTicketAmount * 0.2);
            System.out.println("Your total refund amount with 2% deduction is:" + totalTicketAmount);
        }
    }

    ///this method to display seat status
    public static void displaySeatStatus() {
        System.out.print("Enter the flight class ('a' for Economy, 'b' for Business, 'c' for First): ");
        char flightClass = input.next().charAt(0);

        System.out.print("Enter the row number: ");
        int row = input.nextInt();

        System.out.print("Enter the seat number: ");
        int seat = input.nextInt();

        // Check the selected flight class
        if (flightClass == 'a') {
            if (economyClassSeats[row][seat] == 1) {
                System.out.println("The seat is booked.");
            } else {
                System.out.println("The seat is available.");
            }
        } else if (flightClass == 'b') {
            if (businessClassSeats[row][seat] == 1) {
                System.out.println("The seat is booked.");
            } else {
                System.out.println("The seat is available.");
            }
        } else if (flightClass == 'c') {
            if (firstClassSeats[row][seat] == 1) {
                System.out.println("The seat is booked.");
            } else {
                System.out.println("The seat is available.");
            }
        } else {
            System.out.println("Invalid flight class. Please enter 'a', 'b', or 'c'.");
        }
    }

    // this method is viewing the report of the booked seats
    public static void viewReportOfBookedSeats() {
        System.out.println("---- Booked Seats Report ----");

        System.out.println("Economy Class:");
        for (int i = 0; i < economyClassSeats.length; i++) {
            for (int j = 0; j < economyClassSeats[i].length; j++) {
                if (economyClassSeats[i][j] == 1) {
                    System.out.println("Row " + i + ", Seat " + j);
                }
            }
        }

        System.out.println("Business Class:");
        for (int i = 0; i < businessClassSeats.length; i++) {
            for (int j = 0; j < businessClassSeats[i].length; j++) {
                if (businessClassSeats[i][j] == 1) {
                    System.out.println("Row " + i + ", Seat " + j);
                }
            }
        }

        System.out.println("First Class:");
        for (int i = 0; i < firstClassSeats.length; i++) {
            for (int j = 0; j < firstClassSeats[i].length; j++) {
                if (firstClassSeats[i][j] == 1) {
                    System.out.println("Row " + i + ", Seat " + j);
                }
            }
        }
    }

}
