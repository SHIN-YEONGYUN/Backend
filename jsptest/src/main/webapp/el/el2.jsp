<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--요청파라미터 입력 객체 - param / paramValues --%>
<h1>${param.id } 회원님의 암호는 ${param.pw }입니다.</h1>
<h1> 주문 목록입니다. </h1>
${paramValues.lunch[0] } , 
${!empty paramValues.lunch[1]?  paramValues.lunch[1] : "선택없음"} , 
${paramValues.lunch[2] } , 
${paramValues.lunch[3] } , 
${paramValues.lunch[4] }

<!-- jsp -- request, session, application - 자바객체 공유 -->
<!-- el -- requestScope, sessionScope, applicationScope - 자바객체 공유 -->
</body>
</html>