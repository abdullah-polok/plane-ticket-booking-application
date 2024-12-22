import java.util.Scanner;
class TicketBook {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //1. viewing the options
        System.out.println("-----+-----+-----");
        System.out.println("1.Select the flight class              6.view current status of the plane seating arrangement");
        System.out.println("2.Book a seat                          7.View list of seats reserved");
        System.out.println("3.view the booked e-ticket information 8.display the status of the seat");
        System.out.println("4.view lists of all booked seats       9.view a report of the booked seats");
        System.out.println("5.cancel your flight                   10.exist");
       
        //2. asking the user to enter their choice:
        System.out.println("-----+-----+-----");
        System.out.print("Please, Enter your choice: ");
        int choiceNumber = input.nextInt();
        System.out.println("-----+-----+-----");

        switch (choiceNumber){
            case 1:
            
        }

       
       // switch
      
    }
}