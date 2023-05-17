<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>출력은 scopetest2.jsp에서</h1>
<%-- <h3>jsp출력(현재페이지에서만)<%=s1 %></h3>
<h3>jsp출력(현재페이지에서만)<%=pageContext.getAttribute("s2") %></h3>
<h3 style="color:red">el출력(현재페이지에서만)${pageScope.s2}</h3> --%>

<h3>jsp출력(include/forward)<%=request.getAttribute("s2") %></h3>
<h3 style="color:red">el출력(include/forward)${requestScope.s2}</h3>

<h3>jsp출력(브라우저내부)<%=session.getAttribute("s2") %></h3>
<h3 style="color:red">el출력(브라우저내부)${sessionScope.s2}</h3>

<h3>jsp출력(동일컨텍스트내부)<%=application.getAttribute("s2") %></h3>
<h3 style="color:red">el출력(동일컨텍스트내부)${applicationScope.s2}</h3>

요청파일 uri (jsp) = <%=request.getRequestURI() %>
요청파일 uri (el) = ${pageContext.request.requestURI } 



<!-- jsp:pageContext.getOut()-->
<!-- el:pageContext....-->
</body>
</html>