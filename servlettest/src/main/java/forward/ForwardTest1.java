package forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForwardTest1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청데이터
		String id = request.getParameter("id");
		//대문자변경 처리 - 응답
		request.setAttribute("upperid", id.toUpperCase());
		//추가 처리
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.getNonPagingMember();
		request.setAttribute("memberlist", list);
		
		//응답 구현하더라도 forward 삭제(무시)-이동
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>ForwardTest1 클래스입니다.</h1>");
		out.println("<h1>입력하신 파라미터는 " + id + "</h1>");	
		
		//응답 FowardTest2 이동 
		RequestDispatcher rd = request.getRequestDispatcher("/forward2");
		rd.forward(request, response);

		ServletContext context = request.getServletContext();
		System.out.println(context.getInitParameter("test"));
	}

}
