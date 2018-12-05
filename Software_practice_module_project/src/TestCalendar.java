import java.util.Scanner;

public class TestCalendar {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        // Display the menu
	        System.out.println("Welcome to the match calendar");
	        System.out.println("Selection of the options");
	        System.out.println("1\t World Cup");
	        System.out.println("2\t Liberators Cup");
	        System.out.println("3\t UEFA champions league");
	        System.out.println("4\t UEFA Europa League");
	        System.out.println("5\t America Cup ");

	        System.out.println("Please enter your choice:");
	        
	        //Get user's choice
	        int choice=in.nextInt();
	         
	        //Display the title of the chosen module
	        switch (choice) {
	            case 1: System.out.println("The matches of the world cup (Qatar): \nGrupo A"
	            		+ "\nDate: 01.06.2022 \nTime: 10:00 am *** Germany vs Brazil"
	            		+ "\nTime: 17:00 am *** Paraguay vs Argentinien \nTime: 14:00 am *** Spain vs Holland"
	            		+ "\nDate: 03.06.2022 \nTime: 10:00 am *** India vs France"); 
		                break;
	            case 2: System.out.println("Calendar");
	                    break;
	            case 3: System.out.println("Tournament"); 
	                    break;
	            case 4: System.out.println("Offers"); 
	                     break;
	            case 5: System.out.println("News"); 
	                     break;
	            default: System.out.println("Invalid choice");
	        }//end of switch
	    }//end of the main method
	}//end of class

	