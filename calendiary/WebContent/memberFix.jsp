<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css">
<style type="text/css">

#fix {
	border : solid;
	width : 30%;
	height : 350px;
	margin : 200px auto;
	background-color: white;
}
</style>
<script type="text/javascript">
	function check() {
	    if (confirm("회원 탈퇴 하시겠습니까?")) {
	        document.location.href="removeMember.do";
	    } else {
	        alert("취소하였습니다.");
	        document.location.href="memberFix.jsp";
	    }
	}
</script>
</head>
<body>
<div id = "top">
	<h1>캘린 다이어리</h1>
</div>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null && msg.equals("RF"))
{%>
	<script type="text/javascript">alert("비밀번호를 다시 확인해주세요.");</script>
<%}
%>
<div id = "fix">
	<h1>회원 정보 수정</h1>
	<form action="memberFix.do" method = "post">
		아이디(변경 불가) : <input type = "text" readonly value="${id }"><br>
		<input type = "button" onclick="check()" value="회원 탈퇴"><br>
		<p>공백인 부분은 변경되지 않습니다.</p>
		<input type = "password" name = "pwd" placeholder="새로운 비밀번호(20자 이내)" maxlength="12"><br>
		<input type = "password" name = "pwdR" placeholder="비밀번호 확인" maxlength="12"><br>
		<input type = "text" name = "name" placeholder="변경할 이름(10자 이내)" maxlength="20"><br>
		<label for = "major">학과</label>
		<select name = "major">
			<option value = "0">변경사항없음</option>
			<option value = "컴퓨터과학과">컴퓨터과학과</option>
			<option value = "태권도학과">태권도학과</option>
			<option value = "유도학과">유도학과</option>
		</select><br>
		<input type = "submit" value = "변경"><br>
		또는 <a href = "menu.jsp"> 메뉴</a>
	</form>
</div>
</body>
</html>