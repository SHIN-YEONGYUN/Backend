<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- id, pw 입력받아서 c_member테이블 해당 id , pw 확인 
- MemberDTO 객체로 생성하여 브라우저 종료 이후에 저장(동일 서버 동일 컨텍스트 파일들끼리)
// 서버 방문자수 카운트 - application
// 내로그인 정보 - session
// 요청-forward 된 파일들 - request
-->

<%
String id = request.getParameter("id");
int pw = Integer.parseInt(request.getParameter("pw"));

MemberDAO dao = new MemberDAO();
MemberDTO dto = dao.getMember(id, pw);

application.setAttribute("myinform", dto);
%>

</body>
</html>