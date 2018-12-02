import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class insert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cosa1Input;
		String cosa2Input;
		System.out.println("Please type cosa1");
		cosa1Input = scanner.nextLine();
		System.out.println("Please type cosa2");
		cosa2Input = scanner.nextLine();
		try {
			Connection dbConnection = dbconnect();
			
			String query = "insert into company(id, cosa1, cosa2)	values('1',?,?)";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			
			statement.setString(1,cosa1Input);
			statement.setString(2,cosa2Input);
			statement.executeUpdate();
			query = "SELECT id, cosa1, cosa2 \r\n"
					+ "FROM company";
			System.out.println(query);
			statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int c1 = resultSet.getInt("id");
				String c2 = resultSet.getString("cosa1");
				String c3 = resultSet.getString("cosa2");
				System.out.println(c1+","+c2+","+c3);
			}
			
			statement.close();
			dbConnection.close();
			scanner.close();
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}

	public static Connection dbconnect() throws SQLException {
		Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?allowMultiQueries=true", "postgres",
				"1234");
		return dbConnection;
	}

}
