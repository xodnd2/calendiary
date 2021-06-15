<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴</title>
<link rel="stylesheet" href="css/layout.css">
<style type="text/css">
section {
	margin-top: 150px;
}
input{
	box-sizing : border-box;
	width : 25%;
	height : 400px;
	float : left;
	font-size: 25px;
	border-radius: 20%;
	box-shadow:1px 1px 7px 1px #222;
}
#A{
	background: #F2EA79;
}
#B{
	background: #F2BF27;
}
#C{
	background: #F2AC29;
}
#D{
	background: #BFBDB8;
}
</style>
</head>
<body>
<div id = "top">
	<h1>캘린 다이어리</h1>
</div>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null && msg.equals("RF"))
{%>
	<script type="text/javascript">alert("비밀번호 재확인 실패");</script>
<%}
%>
<section>
	<input id = "A" type = "button" onclick="location.href='check.jsp'" value= "회원 정보 수정">
	<input id = "B" type = "button" onclick="location.href='puCalSession.jsp'" value= "${major } 공용 캘린더">
	<input id = "C" type = "button" onclick="location.href='prCalSession.jsp'" value= "개인 캘린더">
	<input id = "D" type = "button" onclick="location.href='logout.jsp'" value= "로그아웃">
</section>
</body>
</html>