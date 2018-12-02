import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class log_in {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String usernameInput;
		String passwordInput;
		System.out.println("Please type username");
		usernameInput = scanner.nextLine();
		System.out.println("Please type password");
		passwordInput = scanner.nextLine();
		logInCheck(usernameInput, passwordInput);
		scanner.close();
	}

	public static Connection dbconnect() throws SQLException {
		Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"1234");
		return dbConnection;
	}

	public static boolean logInCheck(String passwordInput, String usernameInput) {
		try {
			Connection dbConnection = dbconnect();
			boolean status_log;
			Statement statement = dbConnection.createStatement();
			String query = "SELECT user_name, password " + "FROM creator";
			ResultSet resultSet = statement.executeQuery(query);
			ArrayList<ArrayList> array = new ArrayList<ArrayList>();
			ArrayList<String> strings = new ArrayList<String>();
			while (resultSet.next()) {
				String user_name = resultSet.getString("user_name");
				String password = resultSet.getString("password");
				strings.add(user_name);
				strings.add(password);
				array.add(strings);
				if (passwordInput.equals(password) && (usernameInput.equals(user_name))) {
					System.out.println(user_name + "," + password);
					System.out.println("NICE");
					status_log = true;
					return status_log;
				}
			}
			System.out.println("wrong");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
