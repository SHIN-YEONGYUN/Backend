<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="sum" value="0" />
<c:forEach begin="1" end="10"   var="num" >
	<h3>${num} 까지의 합계 = ${sum = sum + num}</h3>
</c:forEach>

<% String array [] = {"red","black","white","green","blue"}; 
  //pageContext.setAttribute("colors", array);
%>
<c:set var="colors" value="<%=array %>" />
<c:forEach  items="${colors }"  var="one" >
	<h3 style="color:${one}">${one}</h3>
</c:forEach>

<c:forEach  items="${colors }" varStatus="vs" ><!-- 배열요소상태값미리내장값 -->
<!-- 반복인덱스- vs.index , 반복횟수 - vs.count 
     반복현재요소 - vs.current
     첫번째요소입니까 - vs.first/vs.last - t/f
-->
	<h3 style="color:${vs.current}">${vs.count}번째요소=${vs.current}</h3>
</c:forEach>


<c:forEach items="${colors }" varStatus="st">
	<c:if test="${st.first }">
		<h1>첫번째색상=${st.current }</h1>
	</c:if>
	<c:if test="${st.last }">
		<h1>마지막색상=${st.current }</h1>
	</c:if>
</c:forEach>


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
<table border=3>
	<c:forEach items="${list}" varStatus="vs">
	<tr>
		<td>${vs.current.memberid}</td>
		<td>${vs.current.name}</td>
		<td>${vs.current.email}</td>
		<td>${vs.current.phone}</td>
		<td>${vs.current.regtime}</td>
	</tr>
	</c:forEach>
</table>

<%
HashMap<String, String> map = new HashMap();
map.put("빨강", "red");
map.put("주황", "orange");
map.put("노랑", "yellow");
map.put("초록", "green");
map.put("파랑", "blue");
map.put("남색", "navy");
map.put("보라", "purple");
map.put("검정", "black");
//pageContext.setAttribute("colormap", map);
%>
<c:set var="colormap" value="<%=map %>"  />
<c:forEach items="${colormap }" varStatus="vs" >
  	<h3>한글색상 ${vs.current.key}  = 영문색상${vs.current.value} </h3>
</c:forEach>



</body>
</html>