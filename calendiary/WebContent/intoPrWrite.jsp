<%@page import="calendiary.vo.PrWrite"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/intoP_Write.css">
</head>
<div id = "top">
	<h1>캘린 다이어리</h1>
</div>
<%
PrWrite prWrite = (PrWrite)request.getAttribute("prWrite");
String wTime = (String)request.getAttribute("wTime");
%>
<body>
<h1>${year }/${_month }/${_day }</h1>
<h2><%=prWrite.getPrTitle() %></h2>
작성시간: <%=wTime %><br><hr>
<div id = "content"><%=prWrite.getContent() %></div><br>
<a href="removePrWrite.do?wTime=<%=wTime%>">삭제</a>
또는 <a href="removePrWrite.do?wTime=<%=wTime%>&key=f">수정</a>
또는 <a href="prDay.do">전으로</a>
</body>
</html>