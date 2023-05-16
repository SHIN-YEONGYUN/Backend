package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 //  http://http://localhost:8081/servlettest/login?id=xxx&pw=xxxx
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");//요청파라미터한글
		//id, pw 전달받아서
		String id = request.getParameter("id");// name=id
		String pw = request.getParameter("pw");
		String subject[] = request.getParameterValues("subject");//1-4 선택
		
		// id=servlet pw=1234 인 경우에만 로그인성공 처리
		String result = null;
		if(id.equalsIgnoreCase("servlet")  && pw.equals("1234") ) {
			result = "로그인성공---";
		}
		else {
			result = "로그인실패---";
		}
		String subjectresult = "";
		for(String one : subject) {
			subjectresult += one + ", ";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("전송한 아이디= " + id );
		o.println("전송한 암호= " + pw );	
		o.println("전송한 과목들 = " + subjectresult);
		o.println("로그인여부= " +  result);	

	}

}






