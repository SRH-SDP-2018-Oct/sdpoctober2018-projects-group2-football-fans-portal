import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertComments {

	public static void method() {

		Scanner scanner = new Scanner(System.in);
		
		String comentario;
	
		System.out.println("\nTo add comment add the id again: ");
		int id_subtopics = Integer.parseInt(scanner.nextLine());
		
		System.out.println("\nMy comment is: ");
		comentario = scanner.nextLine();
		
		try {
			Connection dbConnection = dbconnect.dbconnect();

			String query = "SELECT id_comentario,comentario,id_subtopics\n"
					+ "FROM comentarios_subtopics";
			
			PreparedStatement statement = dbConnection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			int count = 1;
			while (resultSet.next()) {
				//System.out.println(id_comentario+ "," + comentario1 + "," + id_subtopics);
				
				count++;
				
			}
			
			query = "insert into comentarios_subtopics (id_comentario,comentario,id_subtopics)" + "values(?,?,?)";
			statement = dbConnection.prepareStatement(query);
			int id_comentario=count;
			statement.setInt(1, id_comentario);
			statement.setString(2, comentario);
			statement.setInt(3, id_subtopics);

			statement.executeUpdate();

			statement.close();
			dbConnection.close();
			scanner.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}