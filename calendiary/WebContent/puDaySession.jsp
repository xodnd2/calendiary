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
		String _month = (String)session.getAttribute("month");
		String _day = request.getParameter("day");
		
		if(Integer.parseInt(_month) <10) {
			_month = "0"+_month;
		} 
		if(Integer.parseInt(_day) <10) {
			_day = "0"+_day;
		} 
		session.setAttribute("_month", _month);
		session.setAttribute("_day", _day);

		response.sendRedirect("puDay.do");
	%>
</body>
</html>