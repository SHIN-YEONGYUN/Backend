package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
@WebServlet("/logindb")//http://localost:8081/servlettest/logindb
public class LoginDBServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String result = null;
		//request.setCharacterEncoding("utf-8");//요청파라미터한글
		//id, pw 전달받아서
		String id = request.getParameter("id");// name=id
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");
		if(role.equals("user")) {
		// c_member테이블  id존재, pw 일치하면 로그인성공
		// c_member테이블  id존재, pw 불일치하면 암호를 확인하세요
		// c_member테이블  id 미존재 회원가입부터 하세요
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id, Integer.parseInt(pw));
		
		if(dto.getMemberid() == null) {
			result = "<h1 style='color:red'>회원가입부터 하세요"
					+ "<a href='insertform_db.html'> 회원가입하러 가기 </a></h1>"; 
		}
		else {
			if(dto != null && dto.getPw() != 0) {
				result = "<h1 style='color:green'>로그인성공</h1>";
			}
			else {
				result = "<h1 style='color:red'>암호 확인하세요"
						+ "<a href='loginform_db.html'> 로그인하러 가기 </a></h1>";
			}
		}
		}// if - user
		else{// admin
			//관리자
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> list = dao.getNonPagingMember();
			//table태그로 브라우저 출력
			result = "<table border=3>";

			for(MemberDTO dto : list)	{
				result +="<tr><td>" + dto.getMemberid() + "</td><td>" + dto.getName() +"</td><td>" 
			+ dto.getEmail() + "</td><td>" + dto.getPhone() + "</td></tr>";
			}
			result +="</table>";
			
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("전송한 아이디= " + id );
		o.println("전송한 암호= " + pw );	
		o.println(result);	

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



