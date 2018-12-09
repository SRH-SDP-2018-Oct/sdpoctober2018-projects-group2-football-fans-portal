import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dashboard {
	public static void method1() {
		try {
			Connection dbConnection = dbconnect.dbconnect();
			String query = queries.getDashboardQuery();
			PreparedStatement statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();	
			System.out.println( "team" + "Win"+"  "+"lost"+"  "+"draw"+"  "+"Goals"+"  "+"points");
			while (resultSet.next()) {
				String team= resultSet.getString("team_name");
				int Win = resultSet.getInt("Win");
				int lost = resultSet.getInt("lost");
				int draw = resultSet.getInt("draw");
				int Goals = resultSet.getInt("Goals");
				int points = resultSet.getInt("points");
			
				System.out.println(team + "  " + Win + "  "+ lost +"   "+ draw +"   "+Goals+"   "+points);
			}
			
			}

		catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}
