import java.sql.*;
import java.util.Scanner;

public class ShowSubtopicsComments
{
  public static void method() {
    try
    {
    	Connection dbConnection = dbconnect.dbconnect();
      	System.out.println("\nSee subtopic comments with id:");
    	Scanner scanner = new Scanner(System.in);
    	int id = Integer.parseInt(scanner.nextLine());
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM comentarios_subtopics where id_subtopics = ?";

      // create the java statement
      PreparedStatement st = dbConnection.prepareStatement(query);
      
      // execute the query, and get a java resultset
	  st.setInt(1,id);
      ResultSet rs = st.executeQuery();
      
      // iterate through the java resultset
      while (rs.next())
      {
        int id_subtopics = rs.getInt("id_subtopics");
        String comentario = rs.getString("comentario");
       
		// print the results
        System.out.format("%s, %s\n", id_subtopics, comentario);
      }
      st.close();
    }
   
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}