import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class topics {
	public static void method1(int team) {
		try {
			Connection dbConnection = dbconnect.dbconnect();
			String query = queries.getTeamTopicQuery();
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setInt(1, team);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String element1 = resultSet.getString("sub_topic_name");
				System.out.println(element1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
