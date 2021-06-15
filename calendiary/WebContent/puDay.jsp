<%@page import="calendiary.vo.PuWrite"%>
<%@page import="calendiary.vo.PuMemo"%>
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
	<form action="puMemo.do" method = "post">
		<input id = "text" type = "text" name = "memo" placeholder="메모를 입력해주세요.">
		<input type = "submit" value = "등록">
	</form>
	<%
	String msg = (String)request.getAttribute("msg");
	if(msg != null && msg.equals("F")){
		%><script type="text/javascript">alert("본인만 삭제 가능합니다.");</script><%
	}
	
	ArrayList<PuMemo> puMemos = (ArrayList<PuMemo>)request.getAttribute("puMemos");
	ArrayList<PuWrite> puWrites = (ArrayList<PuWrite>)request.getAttribute("puWrites");
	
	if(puMemos.size() != 0){%>
	<table id = "memos"><%
	for(int i = 0 ;i<puMemos.size();i++)
		{
			PuMemo puMemo = puMemos.get(i);
	%>
		<tr>
		<td><%=puMemo.getPuMemo()%>(<%=puMemo.getName() %>)</td>
		<td><a href="removePuMemo.do?ownId=<%=puMemo.getId() %>&wTime=<%=puMemo.getWTime()%>">삭제</a></td>
		</tr>
		<%
	}
	%></table><%} %>
	<h2>글 목록</h2>
	<%if(puWrites.size() != 0){%>
	<table><%
	for(int i = 0 ;i<puWrites.size();i++)
		{
			PuWrite puWrite = puWrites.get(i);
	%>
		<tr>
		<td><a href = "intoPuWrite.do?ownId=<%=puWrite.getId()%>&wTime=<%=puWrite.getWTime()%>">
		<%=puWrite.getPuTitle()%></a>(<%=puWrite.getWTime()%>,<%=puWrite.getName()%>)</td>
		</tr>
		<%
	}
	%></table><%} %>
	<a href = "puWrite.jsp">글 작성</a>
	또는 <a href = "puCal.do">캘린더로</a>
</body>
</html>