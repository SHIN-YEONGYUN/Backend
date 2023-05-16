package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginjs")
public class LoginJSServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//id, pw 전달받아서
		String id = request.getParameter("id");// name=id
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");//admin / user 중 1개
		
		// id=servlet pw=1234 인 경우에만 로그인성공 처리
		String result = null;
		if(id.equalsIgnoreCase("servlet")  && pw.equals("1234") ) {
			result = "로그인성공";
		}
		else {
			result = "로그인실패";
		}

		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("전송한 아이디= " + id );
		o.println("전송한 암호= " + pw );	
		o.println("시스템사용자역할= " + role );
		o.println("로그인여부= " +  result);	

	}

}







/* 
 * 		System.out.println(getClientIpAddr(request));
 *  
 *  * public static String getClientIpAddr(HttpServletRequest request) { String ip
 * = request.getHeader("X-Forwarded-For");
 * 
 * if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { ip =
 * request.getHeader("Proxy-Client-IP"); } if(ip == null || ip.length() == 0 ||
 * "unknown".equalsIgnoreCase(ip)) { ip =
 * request.getHeader("WL-Proxy-Client-IP"); } if(ip == null || ip.length() == 0
 * || "unknown".equalsIgnoreCase(ip)) { ip =
 * request.getHeader("HTTP_CLIENT_IP"); } if(ip == null || ip.length() == 0 ||
 * "unknown".equalsIgnoreCase(ip)) { ip =
 * request.getHeader("HTTP_X_FORWARDED_FOR"); } if(ip == null || ip.length() ==
 * 0 || "unknown".equalsIgnoreCase(ip)) { ip = request.getRemoteAddr(); }
 * 
 * return ip; }
 */
