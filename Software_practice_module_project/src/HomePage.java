import java.util.Scanner;
public class HomePage {
    
    public static void main(String [] args){
    
    	//dbconnect.dbconnect();
    	
        Scanner scanner = new Scanner(System.in);
        // Display the menu
        System.out.println("Welcome to Football Fans Portal");
        System.out.println("Selection of the options");
        System.out.println("1\t Login");
        System.out.println("2\t Calendar");
        System.out.println("3\t Tournament");
        System.out.println("4\t Offers");
        System.out.println("5\t News ");
        System.out.println("6\t Teams ");

        System.out.println("Please enter your choice:");
        
        //Get user's choice
        int choice=scanner.nextInt();
         
        //Display the title of the chosen module
        switch (choice) {
            case 1: log_in.method1();
	                break;
            case 2: System.out.println("Calendar");
                    break;
            case 3: System.out.println("Tournament"); 
                    break;
            case 4: PrintCalendar.method1(); 
                     break;
            case 5: System.out.println("News"); 
                     break;
            default: System.out.println("Invalid choice");
            
            scanner.close();
        }//end of switch
    }//end of the main method
}//end of class
