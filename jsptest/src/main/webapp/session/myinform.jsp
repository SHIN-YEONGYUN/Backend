<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원님의 정보는 다음과 같습니다. </h1>
<% 
 MemberDTO dto =(MemberDTO)session.getAttribute("myinform");
%>
<h3>아이디 : <%=dto.getMemberid() %></h3>
<h3>이름 : <%=dto.getName() %></h3>
<h3>이메일 : <%=dto.getEmail()%></h3>
<h3>폰 : <%=dto.getPhone() %></h3>
<h3>가입일 : <%=dto.getRegtime()%></h3>
</body>
</html>