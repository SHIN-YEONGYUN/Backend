package calc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int num1_int=0;
		int num2_int=0;
		String num1 = request.getParameter("num1");
		if(num1 != null && num1 != "") {
			num1_int = Integer.parseInt(num1);			
		}
		String num2 = request.getParameter("num2");
		if(num2 != null && num2 != "") {
			num2_int = Integer.parseInt(num2);			
		}
		String op = request.getParameter("operator");

		String result = num1 + op + num2 + "=";
		if (op.equals("+")) {
			result += (num1_int + num2_int);
		} else if (op.equals("-")) {
			result += (num1_int - num2_int);
		} else if (op.equals("*")) {
			result += (num1_int * num2_int);
		} else if (op.equals("/") && num2_int != 0) {
			result += (num1_int / num2_int);
		}

		out.println(result);
	}

}
