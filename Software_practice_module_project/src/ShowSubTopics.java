import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowSubTopics {

	public static void method() {
		try {
			Connection dbConnection = dbconnect.dbconnect();
			String query = queries.getSubTopicQuery();
			Statement st = dbConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("Subtopics disponibles\n");
			while (rs.next()) {
				int id_subtopics = rs.getInt("id_subtopics");
				String subtopics = rs.getString("subtopics");
				System.out.format("%s, %s\n", id_subtopics, subtopics);
			}
			st.close();
		}

		catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}
