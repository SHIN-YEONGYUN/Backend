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
<%= session.isNew() %>
<%= session.getId() %>

<%
String id = request.getParameter("id");
int pw = Integer.parseInt(request.getParameter("pw"));

MemberDAO dao = new MemberDAO();
MemberDTO dto = dao.getMember(id, pw);

session.setAttribute("myinform", dto);
%>
<a href="myinform.jsp">내정보 보러가기</a>
<a href="logout.jsp">로그아웃 가기</a>
</body>
</html>