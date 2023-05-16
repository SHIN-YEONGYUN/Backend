<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%  MemberDTO dto = (MemberDTO)request.getAttribute("member"); 
    if(dto != null){
%>
		<h3>  회원아이디 : <%=request.getParameter("id") %></h3>
		<h3>  회원이름 : <%=dto.getName() %></h3>
		<h3>  회원이메일 : <%=dto.getEmail()%></h3>
		<h3>  회원폰 : <%=dto.getPhone() %></h3>
		<h1>정상 로그인되었습니다. </h1>
<% }
    else{
%>    	
    	<a href="loginform.jsp?id=servlet&pw=1111">  로그인하러 가기 </a>
    	<%-- form /input / submit  클릭  --%>
    	<jsp:forward page="loginform.jsp" >
    	<jsp:param name="id" value="servlet" />
    	<jsp:param name="pw" value="1111" />
    	</jsp:forward>
  <%
  }
  %>
</body>
</html>