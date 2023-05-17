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
	String id = request.getParameter("id");
	String filename = "";
	String[] menu = null;
	if (id != null) {
		if (id.equals("admin") || id.equals("administrator") || id.equals("superuser")) {
			filename = "admin.jsp";
			menu = new String[4];
			menu[0] = "회원가입";
			menu[1] = "상품구입";
			menu[2] = "결제";
			menu[3] = "장바구니조회";
			request.setAttribute("menu", menu);
			
		} else {
			filename = "user.jsp";
		}
	} else {
		filename = "none.jsp";
	}
	%>
	<jsp:forward page="<%=filename%>" />
</body>
</html>