package session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginSessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		/* 1>브라우저 열고 최초 요청시  세션객체 생성-리턴 (저장정보 없다)
		 * or 2> 브라우저 열고 세션 생성 상태- 2번째 요청시 - 생성되어있는 세션 리턴(저장정보 있는 상태)
		 * */
		HttpSession session = request.getSession();
		
		System.out.println(session.isNew());
		System.out.println(session.getId());
		System.out.println(session.getMaxInactiveInterval());//초
		
		
		// id=sessinotest 이고 pw=1234 이면 세션에 로그인아이디 저장
		//member 테이블에서 로그인사용자 확인 상태 가정
		if(id != null && pw != null) {
			if(id.equalsIgnoreCase("sessionTest") && pw.equals("1234")) {
				// 세션 id 저장
				/* 브라우저 열고 최초 /loginsession 요청시  세션객체 생성-리턴 (저장정보 없다)*/
				session.setAttribute("sessionid", id);
			}
		}
		//response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (session.getAttribute("sessionid") != null) {
		out.println("<h1> 사용 가능한 메뉴는 다음과 같습니다</h1>");
		out.println("<h1> <a href='bank'>은행앱 가기 </h1>");
		out.println("<h1> <a href='mypage'>내정보 보러가기 </h1>");
		out.println("<h1> <a href='logout'>로그아웃하러 가기</h1>");
		}
		else {
			out.println("<h1>로그인한 적이 없습니다. </h1>");
		}
	}

}

//http://localhost:8081/servlettest/loginsession?id=sessiontest&pw=1234