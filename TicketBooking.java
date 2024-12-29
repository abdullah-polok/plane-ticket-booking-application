import java.util.Scanner;

class TicketBook {
    static Scanner input = new Scanner(System.in);
    static int totalFare;

    public static void main(String[] args) {
        // 1. viewing the options
        /*
         * but firstly we need an infinite for loop so the options will be shown
         * until exist is chosen
         */
        for (;;) {

            System.out.println("-----+-----+-----");
            System.out.println("");
            System.out.println(
                    "1.Select the flight class              6.view current status of the plane seating arrangement");
            System.out.println("2.Book a seat                          7.View list of seats reserved");
            System.out.println("3.view the booked e-ticket information 8.display the status of the seat");
            System.out.println("4.view lists of all booked seats       9.view a report of the booked seats");
            System.out.println("5.cancel your flight                   10.exist");

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
            int fare = input.nextInt(); ///Choose for user fare 
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
}
