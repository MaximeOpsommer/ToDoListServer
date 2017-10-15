package car.tp4.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLRequestHandler {
	
	public static ResultSet executeQuery(String query) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite::resource:todolist.db");
			st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
	        /*try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }*/
	    }
		
		return rs;
	}

}
