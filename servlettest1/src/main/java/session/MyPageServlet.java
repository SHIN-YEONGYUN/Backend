package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

class MyPageDTO{
	String id, pw, name, email, phone;

	public MyPageDTO() {}

	public MyPageDTO(String id, String pw, String name, String email, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
}
//http://loalhost:8081/servlettest/mypage?id=xxx*pw=1234
public class MyPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//내정보 객체
		MyPageDTO dto = new MyPageDTO("sessiontest","1234","김길벗","gil@but.com", "010-4567-8900");
		//로그인 확인
		/*2> 브라우저 열고 세션 생성 상태- 2번째 요청시 - 생성되어있는 세션 리턴(저장정보 있는 상태)*/
		HttpSession session = request.getSession();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//로그인한 상태다
		if(session.getAttribute("sessionid") != null) {
			out.println("<h3>내 정보 보기</h3>");
			out.println("<h3>아이디=" + dto.id +"</h3>");
			out.println("<h3>이름=" + dto.name +"</h3>");
			out.println("<h3>이메일=" + dto.email +"</h3>");
			out.println("<h3>폰번호=" + dto.phone +"</h3>");
		}
		else {//로그인안한 상태다
			out.println("<h3><a href='loginsession?id=sessiontest&pw=1234'>로그인</a> 하지 않으면 회원 정보를 보여줄 수 없습니다.</h3>");
		}
		
	}

}












