<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/layout.css">
<style type="text/css">
#register {
	border : solid;
	width : 30%;
	height : 270px;
	margin : 200px auto;
	background-color: white;
}
</style>
</head>
<body>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null && msg.equals("RF"))
{%>
	<script type="text/javascript">alert("비밀번호를 다시 확인해주세요.");</script>
<%}
%>
<div id = "top">
	<h1>캘린 다이어리</h1>
</div>
<div id = "register">
<h2>회원가입</h2>
	<form action="register.do" method = "post">
		<ul>
			<li><input type = "text" name = "id" placeholder="아이디(12자 이내)" maxlength="12" required></li>
			<li><input type = "password" name = "pwd" placeholder="비밀번호(20자 이내)" maxlength="20" required></li>
			<li><input type = "password" name = "pwdR" placeholder="비밀번호 확인" maxlength="20" required></li>
			<li><input type = "text" name = "name" placeholder="이름(10자 이내)" maxlength="20"required></li>
			<li>
			<label for = "major">학과 선택</label>
				<select name = "major" required>
					<option value = "컴퓨터과학과">컴퓨터과학과</option>
					<option value = "태권도학과">태권도학과</option>
					<option value = "유도학과">유도학과</option>
				</select>
			</li>
			<li><input type = "submit" value = "회원가입"></li>
		</ul>
	</form>
	또는 <a href = "login.jsp">로그인</a>
</div>
</body>
</html>