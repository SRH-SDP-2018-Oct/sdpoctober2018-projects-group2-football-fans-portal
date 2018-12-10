package commentTrial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class dynamicjasper_prg {

	public static Connection db_con() throws SQLException{
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "manasaraju");
		return con;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
						Connection con=db_con(); 
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("select team, tournament, goals,shots_pg,possession,pass,aerials_won,rating from report");
			
			FastReportBuilder drb = new FastReportBuilder();
		
			DynamicReport dr = drb.addColumn("Team", "team", String.class.getName(), 30)
			.addColumn("Tournament", "tournament", String.class.getName(), 30)
			.addColumn("Goals", "goals", String.class.getName(), 50)
			.addColumn("Shots_pg", "shots_pg", String.class.getName(), 50)
			.addColumn("Possession", "possession", String.class.getName(), 50)
			.addColumn("Pass", "pass", String.class.getName(), 50)
			.addColumn("Aerials_won", "aerials_won", String.class.getName(), 50)
			.addColumn("Rating", "rating", String.class.getName(), 50)
			 .setTitle("Football Report").setSubtitle("This report was generated at " + new Date())
			 .setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();
			JRResultSetDataSource resultsetdatasource = new JRResultSetDataSource(rs); // Convert Resultset to Jasper Resultset
			JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), resultsetdatasource);
			JasperViewer.viewReport(jp); // finally display the report report
			}
			catch(Exception ex) {
			System.out.println(ex);
			}
	}

}
