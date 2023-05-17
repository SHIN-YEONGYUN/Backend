<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String s1 = "jsp변수"; 
   pageContext.setAttribute("s2", "현재페이지공유");
   request.setAttribute("s2", "요청공유");
   session.setAttribute("s2", "세션공유");
   application.setAttribute("s2", "어플리케이션공유");
   //pageContext > request > session > application 
%>
<jsp:forward page="scopetest2.jsp" />



<h3>jsp출력(현재페이지에서만)<%=s1 %></h3>
<h3>jsp출력(현재페이지에서만)<%=pageContext.getAttribute("s2") %></h3>
<h3 style="color:red">el출력(현재페이지에서만)${pageScope.s2}</h3>

<h3>jsp출력(include/forward)<%=request.getAttribute("s2") %></h3>
<h3 style="color:red">el출력(include/forward)${requestScope.s2}</h3>

<h3>jsp출력(브라우저내부)<%=session.getAttribute("s2") %></h3>
<h3 style="color:red">el출력(브라우저내부)${sessionScope.s2}</h3>

<h3>jsp출력(동일컨텍스트내부)<%=application.getAttribute("s2") %></h3>
<h3 style="color:red">el출력(동일컨텍스트내부)${applicationScope.s2}</h3>


<!--  jsp 변수를 el 사용 -->
<!-- jsp : pageContext(다른 jsp 내장객체 getxxx() ) 
     el : pageContext(다른 emp 내장객체 pageContext.xxxx ) 
 -->
</body>
</html>