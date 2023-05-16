package session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class BankServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if(session.getAttribute("sessionid") != null) {
			session.setMaxInactiveInterval(60*5);
			out.println
			("<h3>" + session.getAttribute("sessionid") + " 고객님 인증되셨습니다."
				+	"인증 시간은 5분간 지속됩니다.</h3>");
		}
		else {
			out.println("<h3><a href='loginsession?id=sessiontest&pw=1234'>로그인</a> 하지 않으면 회원 정보를 보여줄 수 없습니다.</h3>");

		}
	}

}
