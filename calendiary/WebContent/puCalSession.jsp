<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Calendar today = Calendar.getInstance();
		String yearNow = ""+today.get(Calendar.YEAR);
		String monthNow = ""+(today.get(Calendar.MONTH)+1);
		String dayNow = ""+today.get(Calendar.DAY_OF_MONTH);
		
		String year = ""+today.get(Calendar.YEAR);
		String month = ""+(today.get(Calendar.MONTH)+1);
		
		session.setAttribute("yearNow", yearNow);
		session.setAttribute("monthNow", monthNow);
		session.setAttribute("dayNow", dayNow);
		
		session.setAttribute("year", year);
		session.setAttribute("month", month);
		
		response.sendRedirect("puCal.do");
	%>
</body>
</html>