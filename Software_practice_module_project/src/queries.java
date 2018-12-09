
public class queries {

	public static String insertQuery = "insert into match_details(match_details_id, score) values(?,?)";

	public static String insertSelectQuery = "SELECT match_details_id, score \r\n" + "FROM match_details";

	public static String logInQuery = "SELECT user_name, password " + "FROM user_details";
	
	public static String subTopicQuery="SELECT * FROM subtopics";
	
	public static String matchQuery="select m.match_place, t.team_name,md.score, m.match_day\r\n" + 
			"	from match as m\r\n" + 
			"	left join match_details as md\r\n" + 
			"	on m.match_id = md.match_id\r\n" + 
			"	join team as t\r\n" + 
			"	on t.team_id = md.team_id\r\n" + 
			"	where m.match_month = ? and m.match_year = ?";


	public static String teamTopicQuery = "SELECT sub_topic_name FROM sub_topic where team_id = ?";

	public static String selectTeamQuery = "SELECT team_name FROM team";

	public static String teamMatchQuery="select m.match_day, m.match_month, m.match_year \r\n" + 
			"	from match as m\r\n" + 
			"	left join match_details as md\r\n" + 
			"	on m.match_id = md.match_id\r\n" + 
			"	join team as t\r\n" + 
			"	on t.team_id = md.team_id\r\n" +
			"	where md.team_id = ?";
	
	public static String getSubTopicQuery() {
	return subTopicQuery;
	}
	
	public static String getTeamTopicQuery() {
	return teamTopicQuery;
	}
		public static String getTeamMatchQuery() {
		return teamMatchQuery;
	}

	public static String getMatchQuery() {
		return matchQuery;
	}

	public static String getSelectTeamQuery() {
		return selectTeamQuery;
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
