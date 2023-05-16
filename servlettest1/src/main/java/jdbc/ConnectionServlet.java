package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		main();
	}

	public void main() {
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		
		System.out.println("연결성공");

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
