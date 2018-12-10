package football;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class offers {
	
	public static void main(String[] args)
	{
	
		//Display the offers
		System.out.println("Offers on below mentioned Football accessories");
		System.out.println("1-Shirts");
		System.out.println("2-Football backpacks");
		System.out.println("3-Caps");	
		System.out.println("4-Football gloves");
		System.out.println("5-Beanie");
		System.out.println("6-Football snood");
		System.out.println("7-Football shoes");
		System.out.println("8-Football");
		System.out.println("9-Soccer shin guards");
	    	
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "12345")) 
        {
    
        	            System.out.println("Offers on football accessories");
        
        	            System.out.println("Connected to PostgreSQL database!");
        	
        	            Statement statement = connection.createStatement();
        	
        	            System.out.println("Reading offers records...");
        	
        	            System.out.printf("%-30.30s  %-30.30s%n", "Accessories", "Price");
        	
        	            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.offers");
        	
        	            while (resultSet.next()) {
        	
        	                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("accessories"), resultSet.getString("price"));
   
        	            }
        	
        	        } catch (SQLException e) {
        	
        	            System.out.println("Connection failure.");
        	
        	            e.printStackTrace();
        	        }			
    
	}
}
