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
			
			String query = queries.getInsertSelectQuery();
			PreparedStatement statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			int count = 1;
			while (resultSet.next()) {
				int c1 = resultSet.getInt("match_details_id");
				int c2 = resultSet.getInt("score");
				System.out.println(c1+","+c2);
				count++;
			}
			query = queries.getInsertQuery();
			statement = dbConnection.prepareStatement(query);
			int id = count;
			statement.setInt(1,id);
			statement.setInt(2,score);
			statement.executeUpdate();
			
			statement.close();
			dbConnection.close();
			scanner.close();
		} catch (SQLException e) {
			e.printStackTrace();
	}
}
	public static Connection dbconnect() throws SQLException {
		Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgre?allowMultiQueries=true", "postgres",
				"1234");
		return dbConnection;
	}

}
