import java.sql.*;

public class dbconnect {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
		if (con != null) {
			System.out.println("DATABASE CONNECTED..");
		}
	}
}
