package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// 1. http://localhost:8081/servlettest/FirstServlet 요청 
// 2. 서블릿 실행(서버) - 클라이언트 응답 전송 브라우저 출력
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	
	
	@Override
	public void destroy() {
		System.out.println("--destroy 호출--");//서버내(이클립스 콘솔)에서 출력
	}

	@Override
	public void init() throws ServletException {
		System.out.println("--init 호출(수정)--");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("--doGet 호출--");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello Servlet </h1>");//클라이언트(브라우저)로 출력
	}

}


