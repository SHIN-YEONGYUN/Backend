<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
오류발생파일명=<%=request.getAttribute("file")%>
클라이언트 출력 오류메시지=<%=request.getAttribute("errormsg")%>
<h1><%=exception%></h1>
<h1><%=exception.getMessage() %></h1>
</body>
</html>