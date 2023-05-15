package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		
		System.out.println("연결성공");
//sql  전송-sql 결과...
		con.close();
		System.out.println("연결해제성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 등록 여부를 확인하세요");
		}
		catch(SQLException e) {
			System.out.println("DB 연결 정보를 확인하세요");
		}finally {
			try {
				con.close();//파일close,소켓close
			}catch(SQLException e) {}
			System.out.println("연결해제성공");
		}
	}

}
