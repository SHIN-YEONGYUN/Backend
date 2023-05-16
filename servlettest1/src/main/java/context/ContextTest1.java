package context;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ContextTest1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		//서버이름
		System.out.println(context.getServerInfo());
		//사용서블릿버전
		System.out.println(context.getEffectiveMajorVersion());
		System.out.println(context.getEffectiveMinorVersion());
		//서블릿실행컨텍스트이름
		System.out.println(context.getContextPath());
		// context.getContextPath()/js/jquery-3.6.1.min.js 파일 존재 실행
		// context.getContextPath()/js/jquery-3.6.1.min.js  복사하여 /b 컨텍스트 파일 붙여넣기
		
		//다른서블릿과 공유 데이터 저장
		context.setAttribute("share","context1에서 보냅니다");
		
		//web.xml로부터 데이터 전달
		System.out.println(context.getInitParameter("test"));
		
	}

}
