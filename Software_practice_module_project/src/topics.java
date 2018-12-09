import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class topics {
	public static int method1(int team) {
		try {
			Scanner scanner = dbconnect.getScanner();
			Connection dbConnection = dbconnect.dbconnect();
			String query = queries.getTeamTopicQuery();
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setInt(1, team);
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Select the subtopic:");
			while (resultSet.next()) {
				String element1 = resultSet.getString("sub_topic_id");
				String element2 = resultSet.getString("sub_topic_name");
				System.out.println(element1+":"+element2);
			}
			int choice = scanner.nextInt();
			return choice;
		} catch (SQLException e) {
			e.printStackTrace();
		return 0;
		}
	}
}
