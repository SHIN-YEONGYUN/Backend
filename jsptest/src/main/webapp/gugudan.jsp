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
<h1>구구단</h1>
<%
int start = Integer.parseInt(request.getParameter("start"));
int end = Integer.parseInt(request.getParameter("end"));
%>
<%--
<%
for(int i = 1; i <=9; i++){
%>
	<tr>
	<%for(int dan=2; dan <=9; dan++){
	%>
		<td style="border:2px solid blue"><%= dan + "*" + i + "=" +dan*i %></td> 
	<%}%>
	</tr>
<%}%>
 --%>

<!-- 구구단 출력은 post만 제한  --> 
<%
if(request.getMethod().equals("POST") ){
	out.println("<table style='border:2px solid blue'>");
	for(int i = 1; i <=9; i++){
		out.println("<tr>");
		for(int dan= start ; dan <= end; dan++){
			out.println
			("<td style='border:2px solid blue'>"
			 + dan + "*" + i + "=" +dan*i + "</td>");
		}
		out.println("</tr>");
	}
	out.println("</table>");
}
%>

<%! 
int multiply(int i, int j, PageContext pc) throws Exception {
	pc.getOut().println(i*j);//15
	return i*j;
}
%>

메소드호출:<%=multiply(3,5, pageContext) %><br>
요청방식:<%=request.getMethod() %>


</body>
</html>