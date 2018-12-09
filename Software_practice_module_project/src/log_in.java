import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class log_in {
	
	public static void method1() {
	
		Scanner scanner = dbconnect.getScanner();
		String usernameInput;
		String passwordInput;
		System.out.println("Please type username");
		usernameInput = scanner.nextLine();
		System.out.println("Please type password");
		passwordInput = scanner.nextLine();
		logInCheck(usernameInput, passwordInput);
		HomePage.method1();
}

	public static boolean logInCheck(String usernameInput, String passwordInput) {
		try {
			Connection dbConnection = dbconnect.dbconnect();
			boolean status_log;
			Statement statement = dbConnection.createStatement();
			String query= queries.getLogInQuery();
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
					System.out.println("NICE");
					status_log = true;
					return status_log;
				}
			}
			System.out.println("wrong");
			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}


