package Comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class comment {
    public static void main(String[] args)throws SQLException, IOException {
    	
    
    	String dtf=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
         String tf=new SimpleDateFormat("HH:mm:ss").format(new Date());
    
           InputStreamReader r=new InputStreamReader(System.in);    
             BufferedReader br=new BufferedReader(r);     
             
             System.out.println("Enter comment: ");    
             String name=br.readLine();
         
             System.out.println(dtf);    
             System.out.println(tf); 
             
               br.close();  
                 r.close();  
                 
                 Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo","postgres", "manasaraju");
     			if(con!=null) {
     			
     			Statement st=con.createStatement();
     			String insertquery = "insert into comnt values('"+name+ "','"+dtf+"','"+tf+"')";
     				st.executeUpdate(insertquery);
     				
     			}
                
    }

}
