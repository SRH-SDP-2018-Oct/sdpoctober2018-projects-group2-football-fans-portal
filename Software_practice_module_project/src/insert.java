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
			
			String query = "SELECT id, cosa1, cosa2 \r\n"
					+ "FROM company";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			int count = 1;
			while (resultSet.next()) {
				int c1 = resultSet.getInt("id");
				String c2 = resultSet.getString("cosa1");
				String c3 = resultSet.getString("cosa2");
				System.out.println(c1+","+c2+","+c3);
				count++;
			}
			query = "insert into company(id, cosa1, cosa2)	values(?,?,?)";
			statement = dbConnection.prepareStatement(query);
			int id = count;
			statement.setInt(1,id);
			statement.setString(2,cosa1Input);
			statement.setString(3,cosa2Input);
			System.out.println(query);
			statement.executeUpdate();
			
			statement.close();
			dbConnection.close();
			scanner.close();
		} catch (SQLException e) {
			e.printStackTrace();
	}
}
	public static Connection dbconnect() throws SQLException {
		Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company?allowMultiQueries=true", "postgres",
				"");
		return dbConnection;
	}

}


