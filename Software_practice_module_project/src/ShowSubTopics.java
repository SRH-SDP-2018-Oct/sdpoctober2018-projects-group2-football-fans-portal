import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowSubTopics{
	
  public static void method() {
    try{
      
    	Connection dbConnection = dbconnect.dbconnect();
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM subtopics";

      // create the java statement
      Statement st = dbConnection.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
  	System.out.println("Subtopics disponibles\n");
      // iterate through the java resultset
      while (rs.next())
      {
        int id_subtopics = rs.getInt("id_subtopics");
        String subtopics = rs.getString("subtopics");
       
		// print the results
        System.out.format("%s, %s\n", id_subtopics, subtopics);
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