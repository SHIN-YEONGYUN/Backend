<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> <%=request.getParameter("title") %> 메뉴 </h1>
<ul>
	<li> <a href='/jsptest/include/loginform.jsp'>로그인메뉴</a> </li>
	<li> <a href='boardlist.jsp'>게시판리스트메뉴</a> </li>
</ul>
<jsp:include page="/include/footer.jsp" >
 <jsp:param name="imagename"  value="/html/images/android.jpg"  />
</jsp:include>
</body>
</html>

