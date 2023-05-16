package first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/my")
public class ThirdServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");//한글인코딩
		PrintWriter out = resp.getWriter();//브라우저출력용객체생성
		out.println("<h1>third servlet 실행 </h1>");//출력내용 생성
		out.println("<p>third servlet 실행 </p>");//출력내용 생성
	}
	
}
