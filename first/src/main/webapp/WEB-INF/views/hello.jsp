<%@page import="annotation.springmvc.HelloDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<% HelloDTO dto = (HelloDTO)request.getAttribute("model"); %>
<H1><%=dto.getMessage() %></H1>
</body>
</html>