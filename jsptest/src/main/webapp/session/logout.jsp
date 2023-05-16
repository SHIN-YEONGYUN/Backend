<%@page import="dto.MemberDTO"%>
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
<h3>
<%=((MemberDTO)session.getAttribute("myinform")).getMemberid() %> 회원님 로그아웃하셨습니다.
</h3>
<%session.removeAttribute("myinform"); %>
</body>
</html>