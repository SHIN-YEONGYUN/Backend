<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dto2" class="dto.MemberDTO" scope="session" />

<h1>회원정보를 생성했습니다(beanrequest2.jsp). 확인해 볼까요?</h1>
아이디 = <jsp:getProperty property="memberid" name="dto2"/><br>
이름 = <jsp:getProperty property="name" name="dto2"/><br>
이메일 = <jsp:getProperty property="email" name="dto2"/><br>
암호 = <jsp:getProperty property="pw" name="dto2"/><br>
폰번호 = <jsp:getProperty property="phone" name="dto2"/><br>
가입일 = <jsp:getProperty property="regtime" name="dto2"/><br>

</body>
</html>


<!-- if(request.getAttribute("dto2") == null{
   MemberDTO dto2 = new dto.MemberDTO();
   request.setAttribute("dto2", dto2);
}
else{
request.getAttribute("dto2") ;
}
 -->