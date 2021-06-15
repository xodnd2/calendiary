<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/layout.css">
<style type="text/css">

#login {
	border : solid;
	width : 30%;
	height : 210px;
	margin : 200px auto;
	background-color: white;
}
</style>
</head>
<body>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null && msg.equals("RS"))
{%>
	<script type="text/javascript">alert("회원가입에 성공하셨습니다.");</script>
<%} else if(msg != null && msg.equals("RF"))
{%>
<script type="text/javascript">alert("동일한 아이디가 존재합니다.");</script>
<%} else if(msg != null && msg.equals("LF"))
{%>
<script type="text/javascript">alert("회원 정보가 일치하지 않습니다.");</script>
<%} else if(msg != null && msg.equals("RMS"))
{%>
<script type="text/javascript">alert("회원 탈퇴 완료되었습니다.");</script>
<%} else if(msg != null && msg.equals("LOS"))
{%>
<script type="text/javascript">alert("로그아웃 되었습니다.");</script>
<%}
%> 
<div id = "top">
	<h1>캘린 다이어리</h1>
</div>
<div id = "login">
	<h2>로그인</h2>
		<form action="login.do" method = "post">
			<ul>
				<li><input type = "text" name = "id" placeholder="아이디 입력" autofocus required></li>
				<li><input type = "password" name = "pwd" placeholder="패스워드 입력" required></li>
				<li><input type = "submit" value = "확인"></li>
			</ul>
		</form>
	또는 <a href = "register.jsp">회원가입</a>
</div>
</body>
</html>