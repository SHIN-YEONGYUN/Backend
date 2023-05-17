<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="el2.jsp" >
아이디<input type=text name="id" ><br>
암호<input type=password name="pw" ><br>
점심메뉴
<select name="lunch" multiple>
	<option value="한식" SELECTED >한식</option>
	<option value="중식">증식</option>
	<option value="일식">일식</option>
	<option value="양식">양식</option>
	<option value="동남아식">동남아식</option>
</select>
<input type=submit value="주문"> 
</form>
</body>
</html>