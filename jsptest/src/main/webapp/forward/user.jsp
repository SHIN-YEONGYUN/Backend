<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>유저용 메뉴는 다음과 같습니다.</h1>
	<ul>
		<%
		String[] menu = (String[]) request.getAttribute("menu");
		for (String one : menu) {
		%>
		<li><%=one%></li>
		<%
		}
		%>
	</ul>
</body>
</html>