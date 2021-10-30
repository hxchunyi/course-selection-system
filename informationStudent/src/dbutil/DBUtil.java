package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	private static Connection conn;
	private static Statement stat;
	private static ResultSet rs;
	
	private static void getStatement()
	{		
        try {
        	Class.forName("com.mysql.jdbc.Driver");
    		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infor_student?characterEncoding=UTF-8", "root", "123456");
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static int update(String sql) 
	{
		try {	
			getStatement();
	    	int rs = stat.executeUpdate(sql); 
	    	
	    	return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static ResultSet query(String sql)
	{
		try {
			getStatement();			
			rs = stat.executeQuery(sql);
			
			
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close()
	{
		try {
			if(rs != null)
				rs.close();
			if(stat != null)
				stat.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
