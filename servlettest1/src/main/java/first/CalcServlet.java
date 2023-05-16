package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청-요청파라미터 분석(유효한 데이터인지 검증)
		//요청파라미터이름 없으면 null( operator=+&su2=100 )
		//요청파라미터이름 있는데 값은 없으면 '' (su1=&operator=+&su2=100 )
		int su1_int=0 , su2_int=0 ;
		String su1 = request.getParameter("su1");
		if(su1 != null && su1 != "") {
		 su1_int = Integer.parseInt(su1);
		}
		String su2 = request.getParameter("su2");
		if(su2 != null && su2 != "") {
		 su2_int = Integer.parseInt(su2);
		}
		String op = request.getParameter("operator");
		
		//처리
		String result = su1 + op + su2 + "=" ;
		if(op.equals("+")) {
			result += su1_int + su2_int ;
		}
		else if(op.equals("-")) {
			result += su1_int - su2_int ;
		}
		else if(op.equals("*")) {
			result += su1_int * su2_int ;
		}
		else if(op.equals("/") && su2_int != 0) {
			result += su1_int / su2_int ;
		}
		
		//응답
		response.setContentType("text/html;charseutf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>" +  result + "</h3>");
	}

}
