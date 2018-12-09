import java.sql.*;
import java.util.Scanner;

public class ShowSubtopicsComments {
	public static void method(int id) {
		try {
			Connection dbConnection = dbconnect.dbconnect();
			String query = queries.getCommentQuery();
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int comment_id = resultSet.getInt("comment_id");
				String comment = resultSet.getString("comment");
				System.out.println(comment_id+":"+comment);
			}
			statement.close();
		}

		catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}