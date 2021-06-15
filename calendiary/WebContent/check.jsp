<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/layout.css">
<style type="text/css">
#check {
	border : solid;
	width : 30%;
	height : 190px;
	margin : 200px auto;
	background-color: white;
}
</style>
</head>
<body>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null && msg.equals("F"))
{%>
	<script type="text/javascript">alert("다시 한번 입력해주세요.");</script>
<%}
%>
<div id = "top">
	<h1>캘린 다이어리</h1>
</div>
<div id = "check">
	<h2>회원 정보 수정</h2>
	<form action="check.do" method = "post">
		<ul>
			<li><input type = "password" name = "pwd" placeholder="비밀번호를 입력해주세요." required><br></li>
			<li><input type = "submit" value = "입력"></li>
		</ul>
	</form>
	또는 <a href = "menu.jsp">메뉴</a>
</div>
</body>
</html>