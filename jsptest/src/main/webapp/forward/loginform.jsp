<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//요청 파라미터 분석
String id = request.getParameter("id");
int pw = Integer.parseInt(request.getParameter("pw"));
//처리
MemberDAO dao = new MemberDAO();
MemberDTO dto = dao.getMember(id, pw);
request.setAttribute("member", dto);

%>
<%="응답무시" %>
<% out.println("이것도 무시"); %>
<jsp:forward page="loginresult.jsp" />


</body>
</html>
<%-- 	<jsp:param name="name"  value="<%=dto.getName()%>" />
	<jsp:param name="email"  value="<%=dto.getEmail()%>" />
	<jsp:param name="phone"  value="<%=dto.getPhone()%>" /> --%>