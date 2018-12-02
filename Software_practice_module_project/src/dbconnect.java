import java.sql.*;

public class dbconnect {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "qwerty");
		if (con != null) {
			System.out.println("DATABASE CONNECTED..");
		}
	}
}

