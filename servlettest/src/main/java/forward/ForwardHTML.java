package forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//http://localhost:8081/servlettest/forwardhtml
//loginform_db.html 파일은 반드시 나를 거쳐서 실행
public class ForwardHTML extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id = admin 조사 
		RequestDispatcher rd = request.getRequestDispatcher
				("/WEB-INF/loginform_db.html");
		rd.forward(request, response);
		
	}

}
