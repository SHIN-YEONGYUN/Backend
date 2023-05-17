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
<%
// html form 입력 name="" (회원가입) - jsp 요청 - XXDTO (변수명)--> db insert ( 컬럼명)
// 화면 응답<-- dto <--DB SELECT
MemberDTO dto = new MemberDTO();
dto.setMemberid("id");
dto.setPw(1111);
dto.setName("이름");
dto.setEmail("email@a.com");
dto.setPhone("010-1111-2222");
%>

<h1>회원정보를 생성했습니다. 확인해 볼까요?</h1>
<h3><%=dto.getMemberid()%></h3>
<h3><%=dto.getName()%></h3>
<hr>
<jsp:useBean id="dto2" class="dto.MemberDTO"  />
<jsp:setProperty property="*" name="dto2" />

<%-- <jsp:setProperty property="memberid" name="dto2" />
<jsp:setProperty property="pw" name="dto2" />
<jsp:setProperty property="name" name="dto2" />
<jsp:setProperty property="email" name="dto2" />
<jsp:setProperty property="phone" name="dto2" /> --%>

<h1>회원정보를 생성했습니다(빈태그로). 확인해 볼까요?</h1>
아이디 = <jsp:getProperty property="memberid" name="dto2"/><br>
이름 = <jsp:getProperty property="name" name="dto2"/><br>
이메일 = <jsp:getProperty property="email" name="dto2"/><br>
암호 = <jsp:getProperty property="pw" name="dto2"/><br>
폰번호 = <jsp:getProperty property="phone" name="dto2"/><br>
가입일 = <jsp:getProperty property="regtime" name="dto2"/><br>
</body>
</html>



