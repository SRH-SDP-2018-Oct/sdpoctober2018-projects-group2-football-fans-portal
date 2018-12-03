import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class Insertando {

	public static void main(String[] args) {
		
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
		
		System.out.println("Please type your name");
		user_detail_1Input = scanner.nextLine();
		System.out.println("Please type your lastname");
		user_detail_2Input = scanner.nextLine();
		System.out.println("Please type your user_name");
		user_detail_3Input = scanner.nextLine();
		System.out.println("Please type your email");
		user_detail_4Input = scanner.nextLine();
		System.out.println("Please type your birthday");
		user_detail_5Input = scanner.nextLine();
		System.out.println("Please type your country");
		user_detail_6Input = scanner.nextLine();
		System.out.println("Please type your city");
		user_detail_7Input = scanner.nextLine();
		System.out.println("Please type your favorite football team");
		user_detail_8Input = scanner.nextLine();
		System.out.println("Please type your cellphone number");
		user_detail_9Input = scanner.nextLine();
		System.out.println("Please type your pasword");
		user_detail_10Input = scanner.nextLine();
		try {
			Connection dbConnection = dbconnect();

			String query = "SELECT id,name,lastname,user_name,email,birthday,country,city,favorite_football_team,cell_phone_number,pasword\r\n"
					+ "FROM user_register";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			int count = 1;
			while (resultSet.next()) {
				int user_detail_0 = resultSet.getInt("id");
				String user_detail_1 = resultSet.getString("name");
				String user_detail_2 = resultSet.getString("lastname");
				String user_detail_3 = resultSet.getString("user_name");
				String user_detail_4 = resultSet.getString("email");
				String user_detail_5 = resultSet.getString("birthday");
				String user_detail_6 = resultSet.getString("country");
				String user_detail_7 = resultSet.getString("city");
				String user_detail_8 = resultSet.getString("favorite_football_team");
				String user_detail_9 = resultSet.getString("cell_phone_number");
				String user_detail_10 = resultSet.getString("pasword");
				System.out.println("Enhorabuena");
				/*System.out.println(user_detail_0 + "," + user_detail_1+ "," + user_detail_2 + "," + user_detail_3 + "," + user_detail_4 + ","
						+ user_detail_5 + "," + user_detail_6 + "," + user_detail_7 + "," + user_detail_8 + ","
						+ user_detail_9 + ","
						+ user_detail_10);*/
				count++;
			}
			query = "insert into user_register (id,name,lastname,user_name,email,birthday,country,city,"
					+ "favorite_football_team,cell_phone_number,pasword)" + "values(?,?,?,?,?,?,?,?,?,?,?)";
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
			/*System.out.println(id + "," + user_detail_1Input+ "," + user_detail_2Input + "," + user_detail_3Input + "," + user_detail_4Input + ","
					+ user_detail_5Input + "," + user_detail_6Input + "," + user_detail_7Input + "," + user_detail_8Input + ","
					+ user_detail_9Input + ","
					+ user_detail_10Input);*/
			statement.executeUpdate();

			statement.close();
			dbConnection.close();
			scanner.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection dbconnect() throws SQLException {
		Connection dbConnection = DriverManager
				.getConnection("jdbc:postgresql://localhost:5433/company?allowMultiQueries=true", "postgres", "qwerty");
		return dbConnection;
	}

}
