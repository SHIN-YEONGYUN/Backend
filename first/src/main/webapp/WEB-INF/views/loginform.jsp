<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인폼</h1>
<!--http://localhost:8071/first/loginform --컨트,롤러 - loginform.jsp   -->
<% %>
<form action="login" method="post">
아이디<input type=text name="memberid" ><br>
암호<input type=password name="pw" ><br>
<input type=submit value="로그인" >
</form>
</body>
</html>