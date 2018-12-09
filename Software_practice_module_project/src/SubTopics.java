import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SubTopics {

	public static void main(String[] args) {
		
		Scanner scanner = dbconnect.getScanner();
		String user_subtopic;		
		System.out.println("Please type your new sub topic: ");
		user_subtopic = scanner.nextLine();
		
		try {
			Connection dbConnection = dbconnect();

			String query = "SELECT id_subtopic,user_subtopic\r\n"
					+ "FROM subtopic";
			PreparedStatement statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			int count = 1;
			while (resultSet.next()) {
				int id_subtopic = resultSet.getInt("id_subtopic");
				String user_subtopic1= resultSet.getString("user_subtopic");
				
				System.out.println(id_subtopic + "," + user_subtopic1);
				count++;
			}
			query = "insert into subtopic (id_subtopic,user_subtopic)" + "values(?,?)";
			statement = dbConnection.prepareStatement(query);
			int id_subtopic=count;
			statement.setInt(1, id_subtopic);
			statement.setString(2, user_subtopic);

			statement.executeUpdate();

			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//ver para hacer una sola conexion de BD
	public static Connection dbconnect() throws SQLException {
		Connection dbConnection = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/company?allowMultiQueries=true", "postgres", "");
		return dbConnection;
	}


}
