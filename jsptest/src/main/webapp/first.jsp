<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String testvar = "테스트용 변수입니다";%>
	<%!void test() {
	System.out.println(testvar);
}%>
	<%
	test();
	%>
	<%
String id = request.getParameter("id");
Date now = new Date();
%>
	<h1><%=id%>회원님
		<%=now%>
		시각에 로그인하셨습니다.
	</h1>
	<%="java"%>
	<br>
	<%
	out.println("java");
	%><br>

	<input type=text name="id" value="<%=id%>">
	<button>전송</button>
</body>
</html>