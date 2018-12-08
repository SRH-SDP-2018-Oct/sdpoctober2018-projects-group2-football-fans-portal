import java.sql.*;

public class dbconnect {

	public static Connection dbconnect() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "");
		return con;
	}
}

