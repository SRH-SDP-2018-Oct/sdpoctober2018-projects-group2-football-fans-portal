
public class queries {

	public static String logInQuery = "SELECT user_name, password " + "FROM user_details";

	public static String insertSelectQuery = "SELECT match_details_id, score \r\n" + "FROM match_details";

	public static String insertQuery = "insert into match_details(match_details_id, score) values(?,?)";

	public static String matchQuery="select m.match_place, t.team_name,md.score, m.match_day\r\n" + 
			"	from match as m\r\n" + 
			"	left join match_details as md\r\n" + 
			"	on m.match_id = md.match_id\r\n" + 
			"	join team as t\r\n" + 
			"	on t.team_id = md.team_id\r\n" + 
			"	where m.match_month = ? and m.match_year = ?";

	public static String getMatchQuery() {
		return matchQuery;
	}

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
