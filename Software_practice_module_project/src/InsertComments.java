import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertComments {

	public static void method1(int sub_topic_id) {

		Scanner scanner = dbconnect.getScanner();
		System.out.println("To add comment write 1 and to return to Team list write 2");
		int choice = scanner.nextInt();
		if (choice == 1) {
			try {
				Connection dbConnection = dbconnect.dbconnect();
				String query = queries.getSelectCommentQuery();
				PreparedStatement statement = dbConnection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery();
				int count = 1;
				while (resultSet.next()) {
					count++;
				}
				System.out.println("Please write your comment");
				Scanner scannerC = new Scanner(System.in);
				String comment = scannerC.nextLine();
				query = queries.getInsertCommentQuery();
				statement = dbConnection.prepareStatement(query);
				int comment_id = count;
				statement.setInt(1, comment_id);
				statement.setInt(2, sub_topic_id);
				statement.setString(3, comment);
				statement.executeUpdate();
				statement.close();
				dbConnection.close();
				scannerC.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (choice == 2) {
			team_page.method1();
		} else {
			System.out.println("Wrong choice");
		}

	}
}