<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dto" class="dto.MemberDTO"  />
<jsp:setProperty name="dto" property="*"  />
<%--
${dto.memberid }<br>
${dto.name }<br>
${dto.email}<br>
${dto.phone }<br>
 --%>

<jsp:useBean id="dao" class="dao.MemberDAO"  />
<% dao.updateMember_jsp(dto);%>

<% ArrayList<MemberDTO> list = dao.getNonPagingMember(); 
	request.setAttribute("memberlist", list);
%>

<jsp:forward page="memberlist.jsp" />




</body>
</html>