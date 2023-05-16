<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    buffer="8kb" autoFlush="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>총버퍼크기:<%= out.getBufferSize() %></h3>
<h1>자바문장 실행 결과와 html 태그를 모아서</h1>
<h1>응답 내용으로 만들고 서버 내부 버퍼에 저장합니다. (아직 전송 전)-한번에 전송</h1>
<%= Integer.parseInt(request.getParameter("name")) %>
<h1>예외 발생시 취소합니다.</h1>
<h1>버퍼를 비워내보자</h1>
<% out.flush(); %>
<h3>남은 버퍼크기:<%= out.getRemaining() %></h3>
</body>
</html>