import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
		Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
		return dbConnection;
	}

//ahora tiene que ser comparando con todos los string dentro de un array list
//ArrayList.contains("StringToBeChecked"); is to be used
	public static void logInCheck(String passwordInput, String usernameInput) {
		try {
			Connection dbConnection = dbconnect();
	    Statement statement = dbConnection.createStatement();
		String query = "SELECT user_name, password "
				+ "FROM creator";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
		    String user_name = resultSet.getString("user_name");
		    String password = resultSet.getString("password");
		    System.out.println(user_name+","+password);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (passwordInput.equals("1") && (usernameInput.equals("1"))) {
			System.out.println("NICE");
		} else {
			System.out.println("Fail");
		}
	}

}
