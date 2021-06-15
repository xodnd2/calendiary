<%@page import="calendiary.vo.PuWrite"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/p_Write.css">
</head>
<body>
<div id = "top">
	<h1>캘린 다이어리</h1>
</div>
<%
PuWrite puWrite = (PuWrite)request.getAttribute("puWrite");

if(puWrite == null){
%>
<h2>다이어리 작성</h2>
	<form action="puWrite.do" method = "post">
		<input type = "text" id = "title" name = "title" placeholder="제목을 입력해주세요.(최대 30자)" maxlength="60" required><br>
		<textarea name ="content" id = "content" placeholder="내용을 입력해주세요.(최대 2000자)" maxlength="4000"></textarea><br>
		<input type = "submit" value = "확인">
		<input type="button" onclick="location.href='puDay.do'" value="취소">
	</form>
<%}
else {%>
<h2>다이어리 수정</h2>
	<form action="puWrite.do?wTime=<%=puWrite.getWTime() %>" method = "post">
		<input type = "text" name = "title" id = "title" value="<%=puWrite.getPuTitle() %>" maxlength="60" required><br>
		<textarea name ="content" id = "content" maxlength="4000"><%=puWrite.getContent() %></textarea><br>
		<input type = "submit" value = "확인">
		<input type="button" onclick="location.href='puDay.do'" value="취소">
	</form>
	<%
	}
%>
</body>
</html>