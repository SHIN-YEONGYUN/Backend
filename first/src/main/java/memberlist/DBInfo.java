package memberlist;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBInfo {
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://127.0.0.1:3306/empdb";	
	public static final String account = "emp";	
	public static final String password = "emp";	
	
	public static void main(String[] args) {
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("연결성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

