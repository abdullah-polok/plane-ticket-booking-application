import java.util.Scanner;

class TicketBook {
    static Scanner input = new Scanner(System.in);
    static int totalFare;
    static int status;

    /// flight seats allocation depends on classes
    static int[][] firstClassSeats = new int[2][3];
    static int[][] economyClassSeats = new int[7][3];
    static int[][] businessClassSeats = new int[3][3];
    static int[] firstClassSeatNumber = new int[6];
    static int[] economyClassSeatNumber = new int[21];
    static int[] businessClassSeatNumber = new int[9];

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
                case 2:
                    bookFlightSeats();/// Call book a flight seat function
            }

        }
    }

    // this method is dedicated to case no.1
    public static void flightClasses() {

        // we spcify the prices of each class
        int economyClass = 100000;
        int businessClass = 200000;
        int firstClass = 300000;
        int roundTrip = 100000;

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
        if (theClass == 'a') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt(); /// Choose for user fare
            System.out.println("Enter number of tickets");
            int ticket = input.nextInt();
            if (fare == 1)
                System.out.println("The total price of your flight  is " + economyClass + " IQD");
            else {
                System.out.println("The total price of your flight with additional roundTrip  is " + (economyClass
                        + roundTrip) + " IQD");
            }
        } else if (theClass == 'b') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt();
            if (fare == 1)
                System.out.println("The total price of your flight  is " + businessClass + " IQD");
            else {
                System.out.println("The total price of your flight with additional roundTrip  is " + (businessClass
                        + roundTrip) + " IQD");
            }
        } else if (theClass == 'c') {
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
        int economyClass = 100000;
        int businessClass = 200000;
        int firstClass = 300000;
        int roundTrip = 100000;

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
        if (theClass == 'a') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt(); /// Choose for user fare

            /// Taking ticket input from user
            System.out.println("Enter number of ticket");
            int ticket = input.nextInt();
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
            int row = input.nextInt();

            bookingSeatsProcess(row, economyClassSeatNumber, ticket);

            checkSeatStatus(economyClassSeats);

            if (fare == 1)
                System.out.println("The total price of your flight  is " + economyClass + " IQD");
            else {
                System.out.println("The total price of your flight with additional roundTrip  is " + (economyClass
                        + roundTrip) + " IQD");
            }
        } else if (theClass == 'b') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt();

            /// Taking row input from user
            System.out.println("Enter your row number for seat");
            int row = input.nextInt();

            /// Taking seat input from user
            System.out.println("Enter your seat numbers:");
            int seatNumber = input.nextInt(); /// Choose seat numbers

            checkSeatStatus(businessClassSeats);

            if (fare == 1)
                System.out.println("The total price of your flight  is " + businessClass + " IQD");
            else {
                System.out.println("The total price of your flight with additional roundTrip  is " + (businessClass
                        + roundTrip) + " IQD");
            }
        } else if (theClass == 'c') {
            System.out.println("Choose the type of fare:");
            System.out.println("1.One way\n2.RoundTrip");
            int fare = input.nextInt();
            checkSeatStatus(firstClassSeats);

            /// Taking row input from user
            System.out.println("Enter your row number for seat");
            int row = input.nextInt();

            /// Taking seat input from user
            System.out.println("Enter your seat numbers:");
            int seatNumber = input.nextInt(); /// Choose seat numbers

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

    // this method to display seat layout
    public static void checkSeatStatus(int[][] seats) {
        int rows = seats.length;
        int columns = seats[0].length;

        System.out.println("Seat Layout:");
        System.out.println("1 2 3");
        System.out.println("_ _ _");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(seats[i][j] + " "); // display seat status
            }
            System.out.println();
        }
    }

    // this method to insert seat numbers seat layout
    public static void bookingSeatsProcess(int userRowNumber, int economyClass[], int tickets) {

        for (int row = 0; row < tickets; row++) {
            for (int column = 0; column < economyClassSeats[0].length; column++) {

                ///Check seats number equal to column index number 
                if (economyClass[row] == column + 1)
                    economyClassSeats[userRowNumber][column] = 1;

            }

        }

    }

}
