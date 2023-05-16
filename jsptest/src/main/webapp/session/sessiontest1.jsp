<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.isNew() %><br>
<%=session.getId() %><br>
<!-- id, pw 입력받아서 c_member테이블 해당 id , pw 확인 
- session에 id 정보들 MemberDTO 객체로 생성하여 저장 이후에
내정보보러가기 링크
-->

<%
String id = request.getParameter("id");
int pw = Integer.parseInt(request.getParameter("pw"));

MemberDAO dao = new MemberDAO();
MemberDTO dto = dao.getMember(id, pw);

session.setAttribute("myinform", dto);
%>
<a href="myinform.jsp">내정보 보러 가기</a>
<a href="logout.jsp">로그아웃하러 가기</a>
</body>
</html>