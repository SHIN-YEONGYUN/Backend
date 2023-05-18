<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery/js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<!-- 1. jsp변수를  el 변수 변환 _ 2가지 -->
<% String id = "jstl1"; int pw = 1234; %>
<% pageContext.setAttribute("elid", id); %>
<h3> 1. jsp 변수를 el변수로 변환 (pageContext) = ${elid }</h3>

<c:set var="id" value="<%=id %>" />
<c:set var="pw" value="1234" />
<h3>2. jstl태그를 통한 변환 = ${id += " 회원님"}</h3>


<!-- 1. el 변수를 jsp 변수로 변환 -->
${id = param.id }
<%
 id = (String)pageContext.getAttribute("id");
%>
<h3>el - jsp로 변환 = <%=id %></h3>

<c:set var="clientip"  value="${pageContext.request.remoteAddr }" />
<c:set var="clientfile"  value="${pageContext.request.requestURI }" />

<h3>클라이언트IP= ${clientip }</h3>
<h3>클라이언트요청파일= ${clientfile }</h3>

<c:remove var="clientip" />
<c:remove var="clientfile" />

<h3>클라이언트요청파일= ${clientfile }</h3>

<c:if test="${!empty clientip}">
	<h3>클라이언트IP= ${clientip }</h3>
</c:if>
<c:if test="${empty clientip}">
	<h3>클라이언트IP 삭제되었습니다.</h3>
</c:if>

<!-- el 표현 + jsp 표현 가능 -->
<c:if test="<%=10>5 %>">
<h3>그렇다</h3>
</c:if>

<!-- jstl과 el
jstl1.jsp?num1=100&num2=200
2개입력받아서 합계 200 이상이면 최상급니다 출력
               100 이상 ~ 200 미만 중급입니다
               100 미만 중하위급입니다 
 -->
<!--  if 블록 -->
<c:set var="sum" value="${param.num1 + param.num2 }" />
<c:if test="${sum >= 200 }">
<h3>최상급니다</h3>
</c:if>
<c:if test="${sum >= 100 && sum < 200}">
<h3>중급니다</h3>
</c:if>
<c:if test="${sum < 100}">
<h3>중하위급니다</h3>
</c:if>

<!-- switch-case 블록 -->
<c:choose>
	<c:when test="${sum >= 200 }">
		<h3>최상급니다</h3>
	</c:when>
	<c:when test="${sum >= 100}">
		<h3>중급니다</h3>
	</c:when>
	<c:when test="${sum >= 0}">
		<h3>중하위급니다</h3>
	</c:when>	
	<c:otherwise>
		<h3> 등급을 처리할 수 없습니다.</h3>
	</c:otherwise>
</c:choose>



</body>
</html>