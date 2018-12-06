
public class queries {

	public static String logInQuery = "SELECT user_name, password " + "FROM user_details";
	
	public static String insertSelectQuery = "SELECT match_details_id, score \r\n"+ "FROM match_details";

	public static String insertQuery = "insert into match_details(match_details_id, score) values(?,?)";

	public static String getLogInQuery() {
		return logInQuery;
	}
	public static String getInsertSelectQuery() {
		return insertSelectQuery;
	}
	public static String getInsertQuery() {
		return insertQuery;
	}

}


