import java.sql.*;

public class DBconect {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qwerty");
		if (con != null) {
			System.out.println("DATABASE CONNECTED..");
		}
	}
}		
