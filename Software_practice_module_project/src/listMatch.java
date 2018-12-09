import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class listMatch {

	public static void method1(int team) {
		try {
		Connection dbConnection = dbconnect.dbconnect();
		String query = queries.getTeamMatchQuery();
		PreparedStatement statement = dbConnection.prepareStatement(query);
		statement.setInt(1, team);
		ResultSet resultSet = statement.executeQuery();
		System.out.println("Matches");
		while (resultSet.next()) {
			String element1 = resultSet.getString("match_day");
			String element2 = resultSet.getString("match_month");
			String element3 = resultSet.getString("match_year");
			System.out.println("date: " + element1 + "/" + element2 + "/" + element3);

		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}