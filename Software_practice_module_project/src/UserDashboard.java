package football;

import java.util.Scanner;

public class UserDashboard {
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
        // Displaying the menu
        System.out.println("Welcome to your profile");
        System.out.println("1-Profile posts");
        System.out.println("2-Recent activity");	//including comments from other users		
        System.out.println("3-User Information");
        System.out.println("4-User Topics"); 	//new discussion topics created by user
        System.out.println("5-Likes/Comments on Postings");
        System.out.println("6-User Groups");	//discussion topics of other people that user is following
        System.out.println("7-Fan shop");		//shows the accessories liked/added in users cart
        
        System.out.println("Please enter your choice:");
        
        //Get user's choice
        int choice=scanner.nextInt();
         
        //Display the title of the chosen module
        switch (choice) {
            case 1: System.out.println("Profile posts"); 
	                break;
            case 2: System.out.println("Recent Activity");
                    break;
            case 3: System.out.println("User Information"); 
                    break;
            case 4: System.out.println("User Topics"); 
                    break;
            case 5: System.out.println("Likes/Comments on Postings"); 
                    break;
            case 6: System.out.println("User Groups");
            		break;
            case 7: System.out.println("Fan shop");
            		break;
                     
            default: System.out.println("Invalid choice");
       
        }	//end of switch
        scanner.close();
	}

}
