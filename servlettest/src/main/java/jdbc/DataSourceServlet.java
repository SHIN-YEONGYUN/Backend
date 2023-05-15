package jdbc;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DataSourceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //connectionpool 미사용
		try {
/*		Class.forName(DBInfo.driver);
		
		long starttime = System.currentTimeMillis();
		for(int i = 1; i <=5000; i++) {
			Connection con = DriverManager.getConnection
					(DBInfo.url, DBInfo.account, DBInfo.password);//생성
			System.out.println(i + " 번째 mysql db 연결 성공");
			con.close();//삭제
		}
		long endtime = System.currentTimeMillis();
		System.out.println((endtime - starttime) + "(1/1000초단위) 소요");
		//27869(1/1000초단위) 소요-27초
*/
	//	connectionpool 사용
		Context context = new InitialContext();//context.xml 설정내용 객체
		Context envContext = (Context)context.lookup("java:/comp/env");//자바연관설정 찾아라 객체
		DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
		
		long starttime = System.currentTimeMillis();
		for(int i = 1; i <=5000; i++) {
			Connection con = ds.getConnection();//connection 로부터 미리생성 빌려온다
			System.out.println(i + " 번째 datasource로부터 연결 성공");

			con.close();//connectionpool 반납
		}
		long endtime = System.currentTimeMillis();
		System.out.println((endtime - starttime) + "(1/1000초단위) 소요");
		}catch(Exception e) {}
	}

}
