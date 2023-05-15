package login;

import java.io.IOException;
import java.io.PrintWriter;

import dao.MemberDAO;
import dto.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 html url = "/servlettest/logindb"
 --http://localost:8081/servlettest/logindb
 /
 * */
@WebServlet("/insertdb")//http://localost:8081/servlettest/logindb
public class InsertDBServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");//요청파라미터한글
		String id = request.getParameter("id");// name=id
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
	
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id, name, Integer.parseInt(pw), phone, email,  "now()");
		// id, phone 조회 먼저 (rs.next() - false)
		dao.insertMember(dto);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("<h1><a href='loginform_db.html'> 로그인</a></h1>");

	}

}


/*
 *		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		
		System.out.println("연결성공");
		//SQL전송
		String sql = "select * from c_member where memberid=?";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setString(1, id);
		ResultSet rs = pt.executeQuery();
		//c_member테이블- memberid (primary key - 중복x, null x) 
		// 1개레코드 또는 0개레코드
		if(rs.next() == true) {// 조회 1레코드이동  존재하면
			int dbpw = rs.getInt("pw");
			System.out.println(dbpw == Integer.parseInt(pw));
			if(dbpw == Integer.parseInt(pw) ) {
				result = "<h1 style='color:green'>로그인성공</h1>";
			}// inner if end
			else {
				result = "<h1 style='color:red'>암호 확인하세요</h1>";
			}
		}//outer if end
		else { // 조회 1레코드이동  미존재하면
			result = "<h1 style='color:red'>회원가입부터 하세요</h1>"; 
		}
		con.close();
		System.out.println("연결해제성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		 */



