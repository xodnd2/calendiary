<%@page import="calendiary.vo.PrWrite"%>
<%@page import="calendiary.vo.PrMemo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/p_Day.css">
</head>
<body>
<div id = "top">
	<h1>캘린 다이어리</h1>
</div>
	<h2><${year}/${_month}/${_day}><br>
	캘린더에 메모 남기기</h2>
	<form action="prMemo.do" method = "post">
		<input id = "text" type = "text" name = "memo" placeholder="메모를 입력해주세요.">
		<input type = "submit" value = "등록">
	</form><h2>메모 목록</h2>
	<%
	ArrayList<PrMemo> prMemos = (ArrayList<PrMemo>)request.getAttribute("prMemos");
	ArrayList<PrWrite> prWrites = (ArrayList<PrWrite>)request.getAttribute("prWrites");
	
	if(prMemos.size() != 0){%>
	<table id = "memos"><%
	for(int i = 0 ;i<prMemos.size();i++)
		{
			PrMemo prMemo = prMemos.get(i);
	%>
		<tr>
		<td><%=prMemo.getPrMemo()%></td>
		<td><a href="removePrMemo.do?wTime=<%=prMemo.getWTime()%>">삭제</a></td>
		</tr>
		<%
	}
	%></table><%} %>
	<h2>글 목록</h2>
	<%if(prWrites.size() != 0){%>
	<table><%
	for(int i = 0 ;i<prWrites.size();i++)
		{
			PrWrite prWrite = prWrites.get(i);
	%>
		<tr>
		<td><a href = "intoPrWrite.do?wTime=<%=prWrite.getWTime()%>">
		<%=prWrite.getPrTitle()%></a>(<%=prWrite.getWTime()%>)</td>
		</tr>
		<%
	}
	%></table><%} %>
	<a href = "prWrite.jsp">글 작성</a>
	또는 <a href = "prCal.do">캘린더로</a>
</body>
</html>