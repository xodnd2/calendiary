<%@page import="calendiary.vo.PuWrite"%>
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
String msg = (String)request.getAttribute("msg");
if(msg != null && msg.equals("F")){
	%><script type="text/javascript">alert("본인만 삭제/수정 가능합니다.");</script><%
}

PuWrite puWrite = (PuWrite)request.getAttribute("puWrite");
String wTime = (String)request.getAttribute("wTime");
%>
<body>
<h1>${year }/${_month }/${_day }</h1>
<h2><%=puWrite.getPuTitle() %></h2>
작성시간: <%=wTime %><br><hr>
<div id = "content"><%=puWrite.getContent() %></div><br>
<a href="removePuWrite.do?ownId=<%=puWrite.getId() %>&wTime=<%=wTime%>&key=r">삭제</a>
또는 <a href="removePuWrite.do?ownId=<%=puWrite.getId() %>&wTime=<%=wTime%>&key=f">수정</a>
또는 <a href="puDay.do">전으로</a>
</body>
</html>