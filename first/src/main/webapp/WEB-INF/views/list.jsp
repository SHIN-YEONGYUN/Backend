<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%  ArrayList<String> list = (ArrayList<String>)request.getAttribute("list"); 
for(String one : list){
	out.println("<h1>" + one + "</h1>");
}
%>

<hr>
<c:forEach items="${list}" var="data" >
  <H1 style="color:blue">${data }</H1>
</c:forEach>
</body>
</html>
<!-- sts3-jdk11+tomcat9  -- jstl 1.2 -->
<!-- 이클립스-jdk17+tomcat10.1  -- jstl 2.0(패키지명 변경-동일 기능) -->

