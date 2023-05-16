<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="e.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setAttribute("file", request.getRequestURI()); %>
<% request.setAttribute("errormsg", "숫자입력필요합니다"); %>
<% int num = Integer.parseInt(request.getParameter("num"));%>
<h1>결과=<%= num*num %></h1>
</body>
</html>
