<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- http://localhost:8071/first/ajaxstart -->
<script src="resources/js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#ajaxbtn").on('click', function(){
		$.ajax( {
			url : 'ajaxlogin',
			data : {'memberid' : $("#memberid").val() , 'pw' : $("#pw").val()} ,
			type : 'get',
			dataType : 'json',
			success : function(response){ // response = { "loginresult" : "로그인성공"}
				//alert(response.loginresult);
			if(response.loginresult == '로그인성공'){
				$("#result").css("color", "green");
			}
			else{
				$("#result").css("color", "red");
			}
			$("#result").html("<h3>" + response.loginresult + "</h3>");
			} ,
			error:function(request, status , e){
				alert("코드=" + request.status +"\n" + "메시지=" + request.responseText +"\n" + "error="+e);
			}
		} );//ajax 
	});//on
	
	$("#ajaxbtn2").on('click', function(){//내정보조회요청
		$.ajax( {
			url : 'ajaxmypage',
			data : {'memberid' : $("#memberid").val() , 'pw' : $("#pw").val()} ,
			type : 'post',
			dataType : 'json',
			success : function(response){ 
				// response = {"memberid":"ajax","name":"박정보","pw":1234,"phone":"010-2222-3333","email":"jung@a.com","regtime":"2023-05-26"}
				$("#result").html("<h3>" + response.memberid + "</h3>");
				$("#result").append("<h3>" + response.name + "</h3>");
				$("#result").append("<h3>" + response.phone + "</h3>");
				$("#result").append("<h3>" + response.email + "</h3>");
				$("#result").append("<h3>" + response.regtime + "</h3>");
			} ,
			error:function(request, status , e){
				alert("코드=" + request.status +"\n" + "메시지=" + request.responseText +"\n" + "error="+e);
			}
		} );//ajax 
	});//on
	
	$("#ajaxbtn3").on('click', function(){//모든회원정보
		$.ajax( {
			url : 'ajaxlist',
			type : 'get',
			dataType : 'json',
			success : function(response){ 
				/* response = 
				{"memberid":"ajax","name":"박정보","pw":1234,"phone":"010-2222-3333","email":"jung@a.com","regtime":"2023-05-26"}
				*/
				for(let  i=0; i < response.length; i++){
					$("#result").append("<h3><a id='a' href=''>" + response[i].memberid  + "</a></h3>");
					//$("#result").append("<h3>" + response[i].name + "</h3>");
					//$("#result").append("<h3>" + response[i].phone + "</h3>");
					//$("#result").append("<h3>" + response[i].email + "</h3>");
					//$("#result").append("<h3>" + response[i].regtime + "</h3><hr>");
				}
			} ,
			error:function(request, status , e){
				alert("코드=" + request.status +"\n" + "메시지=" + request.responseText +"\n" + "error="+e);
			}
		} );//ajax 
	});//on
	
	// 이벤트 ajax 동작 태그가 html 최초 생성 태그가 아니고 추가 태그
	// $("부모").on('','추가 태그', function(){})
	// http://localhost:8071/first/getpw/ajax5
	$("#result").on('click', "a", function(e){//클릭회원암호
		e.preventDefault();
		alert("클릭확인");
		$.ajax( {
			url : 'getpw/' + $(this).text(),
			type : 'get',
			data : {'memberid' : $(this).text()},
			dataType : 'json',
			success : function(response){ 
				$("#result").html(response.pw);
			} ,
			error:function(request, status , e){
				alert("코드=" + request.status +"\n" + "메시지=" + request.responseText +"\n" + "error="+e);
			}
		} );//ajax 
	});//on
	
	$("#uploadbtn").on('click', function(e){//파일업로드
		e.preventDefault();
		let data = new FormData($("#uploadForm")[0]);
		$.ajax( {
			url : 'ajaxupload',
			type : 'post',
			data : data,
			encType:"multipart/form-data",
			ProcessData : false,//name1=value1 전송x
			contentType : false,//request.setContentType("text/html;charset=xxxx")
			dataType : 'json',
			success : function(response){ 
				$("#fileresult").html(response.uploadresult);
			} ,
			error:function(request, status , e){
				alert("코드=" + request.status +"\n" + "메시지=" + request.responseText +"\n" + "error="+e);
			}
		} );//ajax 
	});//on
	
});//ready
</script>

<h1>로그인</h1>
<form action="ajaxlogin" method="get">
아이디<input type=text name="memberid" id="memberid"><br>
암호<input type=password name="pw" id="pw"><br>
<!-- <input type=submit value="nonajax로그인" > -->
<input type=button value="ajax로그인" id="ajaxbtn">
<input type=button value="ajax내정보조회" id="ajaxbtn2">
<input type=button value="모든회원조회" id="ajaxbtn3">
</form>

<div id="result"></div>

<h1>파일 업로드 폼</h1>
<form  id="uploadForm">
 파일선택 : <input type=file name="uploadfile">
 <input id="uploadbtn" type=button value="파일업로드">
 </form>
 <div id="fileresult">파일업로드결과 전용</div>
</body>
</html>
