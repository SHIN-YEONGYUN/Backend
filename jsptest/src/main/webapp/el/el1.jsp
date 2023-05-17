<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 변수종류/연산자/내장객체 / 객체 -->
${ 100 }
${ true }
${ 3.14 }
${'표현언어' }
<h1> el 연산자 </h1>
<h3>${100 + 3.14 }</h3>
<h3>${null + 3.14 }</h3><!--  null 은 산술연산자 0 자동변환, 출력시 공백 자동변환 -->
<h3>${100 += "표현언어" }</h3>
<h3>${"el=" += "표현언어" }</h3>
<h3>${"이십" == "이십" }</h3>
<h3>${"이십".equals("이십") }</h3> <%-- ${true/false} --%>
<h3>${"EXPRESSION".toLowerCase() }</h3> 

<h3>${10>5  && 10<100} </h3>
<h3>${!(10>5)} </h3>

<h3>\${ 10 > 5 }의 결과는 ${ 10 > 5 }</h3>

<h3>el name = ${!empty param.name ? param.name : "파라미터미입력"} </h3>
</body>
</html>

