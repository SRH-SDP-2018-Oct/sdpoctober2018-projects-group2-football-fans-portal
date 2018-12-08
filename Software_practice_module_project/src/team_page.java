import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class team_page {

	public static void method1() {

		try {
			Connection dbConnection = dbconnect.dbconnect();
			String query = queries.getSelectTeamQuery();
			System.out.println("Enter your selected team ");
			PreparedStatement statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String element1 = resultSet.getString("team_name");
				System.out.println(element1);
			}
			Scanner scanner = new Scanner(System.in);
			int team = scanner.nextInt();
			System.out.println("What do you want to do:\r\n"
					+ "1: List of matches \r\n"
					+ "2: Discussion");
			int option = scanner.nextInt();
			switch(option) {
			case 1: listMatch.method1(team);
            break;
			}
			scanner.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
