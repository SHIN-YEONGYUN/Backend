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

${id = param.id }
${param.pw }

<% 
MemberDAO dao = new MemberDAO();
MemberDTO dto = dao.getMember
(request.getParameter("id"), Integer.parseInt(request.getParameter("pw")));
%>

<h1>수정폼</h1>
<form action="updateresult.jsp" >
아이디(수정불가) <input type=text name="memberid" value="<%=dto.getMemberid() %>" readonly >
암호(수정불가)  <input type=password name="pw" value="<%=dto.getPw() %>" readonly >
이름 <input type=text name="name" value="<%=dto.getName() %>"  >
폰 <input type=text name="phone" value="<%=dto.getPhone() %>"  >
이메일 <input type=text name="email" value="<%=dto.getEmail() %>"  >
<input type=submit value="수정">
</form>



</body>
</html>