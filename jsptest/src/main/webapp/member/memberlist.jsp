<%@page import="java.util.ArrayList"%>
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
<%-- ${requestScope.memberlist  } --%>
<% ArrayList<MemberDTO> list = 
(ArrayList<MemberDTO>)request.getAttribute("memberlist") ; 
for(MemberDTO dto : list){
	out.println("<p>" + dto + "</p>");
}
%>



</body>
</html>