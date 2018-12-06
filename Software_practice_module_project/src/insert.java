import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class insert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score;
		System.out.println("Please type score");
		score = Integer.parseInt(scanner.nextLine());
		try {
			Connection dbConnection = dbconnect();
			
<<<<<<< HEAD
			String query = "SELECT id, cosa1, cosa2 \r\n"
					+ "FROM company";
=======
			String query = queries.getInsertSelectQuery();
>>>>>>> branch 'master' of https://github.com/SRH-SDP-2018-Oct/sdpoctober2018-projects-group2-football-fans-portal.git
			PreparedStatement statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			int count = 1;
			while (resultSet.next()) {
<<<<<<< HEAD
				int c1 = resultSet.getInt("id");
				String c2 = resultSet.getString("cosa1");
				String c3 = resultSet.getString("cosa2");
				System.out.println(c1+","+c2+","+c3);
=======
				int c1 = resultSet.getInt("match_details_id");
				int c2 = resultSet.getInt("score");
				System.out.println(c1+","+c2);
>>>>>>> branch 'master' of https://github.com/SRH-SDP-2018-Oct/sdpoctober2018-projects-group2-football-fans-portal.git
				count++;
			}
<<<<<<< HEAD
			query = "insert into company(id, cosa1, cosa2)	values(?,?,?)";
			statement = dbConnection.prepareStatement(query);
			int id = count;
			statement.setInt(1,id);
			statement.setString(2,cosa1Input);
			statement.setString(3,cosa2Input);
			System.out.println(query);
=======
			query = queries.getInsertQuery();
			statement = dbConnection.prepareStatement(query);
			int id = count;
			statement.setInt(1,id);
			statement.setInt(2,score);
>>>>>>> branch 'master' of https://github.com/SRH-SDP-2018-Oct/sdpoctober2018-projects-group2-football-fans-portal.git
			statement.executeUpdate();
			
			statement.close();
			dbConnection.close();
			scanner.close();
		} catch (SQLException e) {
			e.printStackTrace();
	}
}
	public static Connection dbconnect() throws SQLException {
<<<<<<< HEAD
		Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company?allowMultiQueries=true", "postgres",
				"");
=======
		Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgre?allowMultiQueries=true", "postgres",
				"1234");
>>>>>>> branch 'master' of https://github.com/SRH-SDP-2018-Oct/sdpoctober2018-projects-group2-football-fans-portal.git
		return dbConnection;
	}

}


