<%@page import="java.util.HashMap"%>
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
<% String array [] = {"red","black","white","green","blue"}; 
  pageContext.setAttribute("colors", array);
%>
<h1 style="color:${colors[0]}">${colors[0]}</h1>

<jsp:useBean id="list" class="java.util.ArrayList"  scope="request"/>
<jsp:useBean id="dto" class="dto.MemberDTO" />
<jsp:setProperty name="dto" property="*" />

<%
list.add(new MemberDTO("MEM1", "회원1", 1111, "01011111111", "one@multi.com","2023-05-17 12:34:56")); 
list.add(new MemberDTO("MEM2", "회원2", 1111, "01011111111", "one@multi.com","2023-05-17 12:34:56"));
list.add(new MemberDTO("MEM3", "회원3", 1111, "01011111111", "one@multi.com","2023-05-17 12:34:56"));
list.add(new MemberDTO("MEM4", "회원4", 1111, "01011111111", "one@multi.com","2023-05-17 12:34:56"));
list.add(new MemberDTO("MEM5", "회원5", 1111, "01011111111", "one@multi.com","2023-05-17 12:34:56"));
%>
${list.get(0).memberid } : ${list[0].memberid } <br>
${list.get(0).name } : ${list[0].name } <br>
${list.get(0).phone } : ${list[0].phone } <br>
${list.get(0).email } : ${list[0].email } <br>
${list.get(0).regtime } : ${list[0].regtime } <br>

<%
HashMap<String, String> map = new HashMap();
map.put("빨강", "red");
map.put("주황", "orange");
map.put("노랑", "yellow");
map.put("초록", "green");
map.put("파랑", "blue");
map.put("남색", "navy");
map.put("보라", "purple");
map.put("black", "검정");
pageContext.setAttribute("colormap", map);
%>

${colormap["빨강"] }<br>
${colormap.black }<br>
${colormap["검정"] }<br>
</body>
</html>





