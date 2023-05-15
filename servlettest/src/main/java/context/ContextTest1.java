package context;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContextTest1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		
		System.out.println(context.getServerInfo());
		
		System.out.println(context.getEffectiveMajorVersion());
		
		System.out.println(context.getEffectiveMinorVersion());
		
		System.out.println(context.getContextPath());
		
		
		context.setAttribute("shate","context1에서 보냅니다.");
		System.out.println(context.getInitParameter("test"));
	}
}
