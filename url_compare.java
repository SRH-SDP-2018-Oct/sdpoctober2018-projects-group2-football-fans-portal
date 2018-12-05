import java.net.URL;
import java.util.*;  
import javax.activation.*; 
import java.net.MalformedURLException;

public class url_compare 
{
	   public static void main(String [] args)
	   {   
	      try 
	      { 
	    	  URL urlOne = new URL("http://www.espn.com/soccer/schedule");
			  URL urlTwo = new URL("http://www.espn.com/soccer/schedule/");
			  if (urlOne.equals(urlTwo))
			   {
				   
				   
				// add email addresses 
String recipient =reciever@gmail.com;
			      // email ID of Sender
			      String sender = "sender@gmail.com"; 
			  
			      // using host as local host 
			      String host = "127.0.0.1"; 
			  
			      // Getting system properties 
			      Properties properties = System.getProperties(); 
			  
			      // Setting up mail server 
			      properties.setProperty("mail.smtp.host", host); 
			  
			      // creating session object to get properties 
			      Session session = Session.getDefaultInstance(properties);     
			      
	         // MimeMessage object. 
	         MimeMessage message = new MimeMessage(session); 
	  
	         // Set From Field: adding senders email to from field. 
	         message.setFrom(new InternetAddress(sender)); 
	  
	         // Set To Field: adding recipient's email to from field. 
	         message.addRecipients(Message.RecipientType.TO, new InternetAddress(recipients)); 
	  
	         // Set Subject: subject of the email 
	         message.setSubject("Notification"); 
	  
	         // set body of the email. 
	         message.setText("Event schedule changed to (date, time, place)"); 
	  
	         // Send email. 
	         Transport.send(message); 
	         System.out.println("Notifyimg the change in event schedule"); 
			 }
	      } 
	      catch (MalformedURLException ex)  
	      { 
	         ex.printStackTrace(); 
	      } 
	   } 

}
