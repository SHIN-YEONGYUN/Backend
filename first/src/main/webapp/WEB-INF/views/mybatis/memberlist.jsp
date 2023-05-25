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
<form action="membersearchlist">
<select name="item">
<option>이름 검색</option>
<option>이메일 검색</option>
<option>번호 검색</option>
<option>아이디 검색</option>
</select>
검색어 : <input type=text name="searchword">
<input type="submit" value=검색요청>
</form>
<c:if test="${!empty membercount }">
<h1>검색된 회원 수는 ${membercount } 명입니다. </h1>
</c:if>
<h1>검색된 회원 정보를 가져옵니다. </h1>
<c:forEach items= "${memberlist }" var="dto" varStatus="vs">
<%-- ${vs.first }
${vs.last }
${vs.count }
${vs.index } --%>
<%-- <c:if test="${!vs.last }"> --%>
<h3>${dto}</h3>
<%-- </c:if> --%>
</c:forEach>
</body>
</html>