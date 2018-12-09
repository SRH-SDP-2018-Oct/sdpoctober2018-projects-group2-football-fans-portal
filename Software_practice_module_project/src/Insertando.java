import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class Insertando {

	public static void method1() {

		Scanner scanner = new Scanner(System.in);
		String user_detail_1Input;
		String user_detail_2Input;
		String user_detail_3Input;
		String user_detail_4Input;
		String user_detail_5Input;
		String user_detail_6Input;
		String user_detail_7Input;
		String user_detail_8Input;
		String user_detail_9Input;
		String user_detail_10Input;

		System.out.println("Welcome to User Registration !");

		System.out.println("Please type your user name");
		user_detail_1Input = scanner.nextLine();
		System.out.println("Please type your fullname");
		user_detail_2Input = scanner.nextLine();
		System.out.println("Please type your password");
		user_detail_3Input = scanner.nextLine();
		System.out.println("Please type your gender");
		user_detail_4Input = scanner.nextLine();
		System.out.println("Please type your birthday");
		user_detail_5Input = scanner.nextLine();
		System.out.println("Please type your email");
		user_detail_6Input = scanner.nextLine();
		System.out.println("Please type your mobile number");
		user_detail_7Input = scanner.nextLine();
		System.out.println("Please type your country");
		user_detail_8Input = scanner.nextLine();
		System.out.println("Please type your favorite football team");
		user_detail_9Input = scanner.nextLine();
		System.out.println("Please type your favorite player");
		user_detail_10Input = scanner.nextLine();
		try {
			Connection dbConnection = dbconnect.dbconnect();

			String query = "SELECT user_id,user_name,user_fullname,password,gender,date_of_birth,email,"
					+ "mobile_number,location,fav_team,fav_player\r\n" + "FROM user_details";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			int count = 1;
			while (resultSet.next()) {
				count++;
			}
			query = "insert into user_details (user_id,user_name,user_fullname,password,"
					+ "gender,date_of_birth,email,mobile_number,location,fav_team,fav_player)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			statement = dbConnection.prepareStatement(query);
			int id = count;
			statement.setInt(1, id);
			statement.setString(2, user_detail_1Input);
			statement.setString(3, user_detail_2Input);
			statement.setString(4, user_detail_3Input);
			statement.setString(5, user_detail_4Input);
			statement.setString(6, user_detail_5Input);
			statement.setString(7, user_detail_6Input);
			statement.setString(8, user_detail_7Input);
			statement.setString(9, user_detail_8Input);
			statement.setString(10, user_detail_9Input);
			statement.setString(11, user_detail_10Input);

			statement.executeUpdate();

			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HomePage.method1();
		scanner.close();
	}

}
