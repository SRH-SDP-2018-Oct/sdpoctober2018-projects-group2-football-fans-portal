import java.sql.*;
import java.util.Scanner;

public class dbconnect {

	public static Scanner scanner = new Scanner(System.in);
	
	public static Scanner getScanner() {
		return scanner;
	}

	public static void setScanner(Scanner scanner) {
		dbconnect.scanner = scanner;
	}

	public static Connection dbconnect() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgre", "postgres", "1234");
		return con;
	}
}

