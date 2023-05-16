<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>

<img src="<%=request.getParameter("imagename") %>" width=50 height=50 >
<p> 연락처 - 이메일로 문의하세요</p>
<p> 오시는 길 - 서울시 강남구 역삼동 멀티캠퍼스</p>
<p><%=request.getParameter("title") %></p>
<hr>
</body>
</html>