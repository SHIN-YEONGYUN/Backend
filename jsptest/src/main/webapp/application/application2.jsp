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
<% MemberDTO dto = (MemberDTO)application.getAttribute("myinform") ; %>
<h1> application 내장객체로부터 정보 공유 </h1>
<h3>아이디 : <%=dto.getMemberid() %></h3>
<h3>이름 : <%=dto.getName() %></h3>
<h3>이메일 : <%=dto.getEmail()%></h3>
<h3>폰 : <%=dto.getPhone() %></h3>
<h3>가입일 : <%=dto.getRegtime()%></h3>
</body>
</html>