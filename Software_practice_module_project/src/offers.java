package football;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class offers {
	
	public static void main(String[] args)
	{
	
		//Display the offers
		System.out.println("Offers on below mentioned Football accessories");
		System.out.println("Shirts");
		System.out.println("Football backpacks");
		System.out.println("Caps");	
		System.out.println("Football gloves");
		System.out.println("Beanie");
		System.out.println("Football snood");
		System.out.println("Football shoes");
		System.out.println("Football");
		System.out.println("Soccer shin guards");
	    	
        try 
        {
			Connection dbConnection = dbconnect.dbconnect();

        	            System.out.println("Offers on football accessories");
        
        	            System.out.println("Connected to PostgreSQL database!");
        	
        	            Statement statement = dbConnection.createStatement();
        	
        	            System.out.println("Reading offers records...");
        	
        	            System.out.printf("%-30.30s %-30.30s%n","accessory", "price in euros");
        	
        	            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.offers");
        	
        	            while (resultSet.next()) {
        	
        	                System.out.printf("%-30.30s %-30.30s%n", resultSet.getString("accessory"), resultSet.getString("price in euros"));
   
        	            }
        	
        	        } catch (SQLException e) {
        	
        	            System.out.println("Connection failure.");
        	
        	            e.printStackTrace();
        	        }			
    
	}
}
