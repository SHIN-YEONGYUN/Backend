package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 - 분석 - 처리 - 
		
		//응답 브라우저 전송. -브라우저출력용객체생성
		response.setContentType("text/html;charset=utf-8");//한글인코딩
		PrintWriter out = response.getWriter();//브라우저출력용객체생성
		out.println("<h1>second servlet 실행 </h1>");//출력내용 생성
		out.println("<p>second servlet 실행 </p>");//출력내용 생성
	}

}
