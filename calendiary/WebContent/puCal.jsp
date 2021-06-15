<%@page import="java.awt.print.Printable"%>
<%@page import="calendiary.vo.PuMemo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공용 캘린더</title>
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/p_Cal.css">
</head>
<body>
	<h2>
	<input class = "nextButton" type="button" onclick="location.href='puCal.do?i=m'" value="이전 달">
	${year}년 ${month}월 캘린더
	<input class = "nextButton" type="button" onclick="location.href='puCal.do?i=p'" value="다음 달">
	<input id = "menuButton" type="button" onclick="location.href='menu.jsp'" value = "메뉴">
	</h2>
	<%
		ArrayList<PuMemo> puMemos = (ArrayList<PuMemo>)request.getAttribute("puMemos");
		String year= (String)session.getAttribute("year");
		String month = (String)session.getAttribute("month");				
		
		String yearNow = (String)session.getAttribute("yearNow");
		String monthNow = (String)session.getAttribute("monthNow");
		String dayNow = (String)session.getAttribute("dayNow");
		int fD = (int)request.getAttribute("firstDay");
		int day = 1;
		
		if(month.equals("1")||month.equals("3")||month.equals("5")||month.equals("7")||month.equals("8")||month.equals("10")||month.equals("12"))
		{switch(fD) {
			case 1: case 2: case 3: case 4: case 5: %>
			<table>
			<tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr><tr>
			<%
				for(int i = 0; i<5 ;i++)
				{
					if (i==0)
					{ for(int t = 0; t<fD-1 ;t++)
						{%><td id = "blank"></td><%}
						for(int k = fD; k<8 ;k++)
						{ 
							if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
							<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
							<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
							</ul></td>
						<%} else {
							%>
							<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
							<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
							</ul></td>
						<%}
						}	
						%>
						</tr>
					<%
					}else {
					%>
					<tr>
					<%
					for(int j = 0;j<7 && day<= 31;j++,day++)
					{
						if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
							<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
							<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
							</ul></td>
						<%} else { %>
							<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
							<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
							</ul></td>
						<%
						}
					}
					%>
					</tr>
					<%
				}
			}
			%>
			</table>
		<%
			break;
			case 6: case 7: %>
			<table>
			<tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr><tr>
			<%
				for(int i = 0; i<6 ;i++)
				{
					if (i==0)
					{ for(int t = 0; t<fD-1 ;t++)
						{%><td id = "blank"></td><%}
						for(int k = fD; k<8 ;k++)
						{ 
							if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
							<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
							<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
							</ul></td>
						<%} else {
							%>
							<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
							<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
							</ul></td>
						<%}
						}	
						%>
						</tr>
					<%
					} else {
					%>
					<tr>
					<%
					for(int j = 0;j<7 && day<= 31;j++,day++)
					{
						if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
							<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
							<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
							</ul></td>
						<%} else { %>
							<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
							<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
							</ul></td>
						<%
						}
					}
					%>
					</tr>
					<%
				}
			}
			%>
			</table>
		<%
			break;
			}
		} else if(month.equals("4")||month.equals("6")||month.equals("9")||month.equals("11"))
		{switch(fD) {
		case 1: case 2: case 3: case 4: case 5: case 6:%>
		<table>
		<tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr><tr>
		<%
			for(int i = 0; i<5 ;i++)
			{
				if (i==0)
				{ for(int t = 0; t<fD-1 ;t++)
					{%><td id = "blank"></td><%}
					for(int k = fD; k<8 ;k++)
					{ 
						if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
						<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
						<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
						</ul></td>
					<%} else {
						%>
						<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
						<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
						</ul></td>
					<%}
					}	
					%>
					</tr>
				<%
				}else {
				%>
				<tr>
				<%
				for(int j = 0;j<7 && day<= 30;j++,day++)
				{
					if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
						<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
						<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
						</ul></td>
					<%} else { %>
						<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
						<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
						</ul></td>
					<%
					}
				}
				%>
				</tr>
				<%
			}
		}
		%>
		</table>
	<%
		break;
		case 7: %>
		<table>
		<tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr><tr>
		<%
			for(int i = 0; i<6 ;i++)
			{
				if (i==0)
				{ for(int t = 0; t<fD-1 ;t++)
					{%><td id = "blank"></td><%}
					for(int k = fD; k<8 ;k++)
					{ 
						if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
						<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
						<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
						</ul></td>
					<%} else {
						%>
						<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
						<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
						</ul></td>
					<%}
					}	
					%>
					</tr>
				<%
				} else {
				%>
				<tr>
				<%
				for(int j = 0;j<7 && day<= 30;j++,day++)
				{
					if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
						<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
						<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
						</ul></td>
					<%} else { %>
						<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
						<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
						</ul></td>
					<%
					}
				}
				%>
				</tr>
				<%
			}
		}
		%>
		</table>
	<%
		break;
		}
	} else if(month.equals("2") && Integer.parseInt(year) % 400 != 0 && Integer.parseInt(year) % 4 == 0)
	{switch(fD) {
	case 1: case 2: case 3: case 4: case 5: case 6: case 7: %>
	<table>
	<tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr><tr>
	<%
		for(int i = 0; i<5 ;i++)
		{
			if (i==0)
			{ for(int t = 0; t<fD-1 ;t++)
				{%><td id = "blank"></td><%}
				for(int k = fD; k<8 ;k++)
				{ 
					if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
					<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
					<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
						</ul></td>
				<%} else {
					%>
					<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
					<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
						</ul></td>
				<%}
				}	
				%>
				</tr>
			<%
			} else {
			%>
			<tr>
			<%
			for(int j = 0;j<7 && day<= 29;j++,day++)
			{
				if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
					<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
					<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
						</ul></td>
				<%} else { %>
					<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
					<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
					</ul></td>
				<%
				}
			}
			%>
			</tr>
			<%
		}
	}
	%>
	</table>
<%
	break;
	}
} else 
{switch(fD) {
case 1:  %>
<table>
<tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr><tr>
<%
	for(int i = 0; i<4 ;i++)
	{
		if (i==0)
		{ for(int t = 0; t<fD-1 ;t++)
			{%><td id = "blank"></td><%}
			for(int k = fD; k<8 ;k++)
			{ 
				if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
				<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
				<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
					</ul></td>
			<%} else {
				%>
				<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
				<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
					</ul></td>
			<%}
			}	
			%>
			</tr>
		<%
		}else {
		%>
		<tr>
		<%
		for(int j = 0;j<7 && day<= 28;j++,day++)
		{
			if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
				<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
				<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
					</ul></td>
			<%} else { %>
				<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
				<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
					</ul></td>
			<%
			}
		}
		%>
		</tr>
		<%
	}
}
%>
</table>
<%
break;
case 2: case 3: case 4: case 5: case 6: case 7: %>
<table>
<tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr><tr>
<%
	for(int i = 0; i<5 ;i++)
	{
		if (i==0)
		{ for(int t = 0; t<fD-1 ;t++)
			{%><td id = "blank"></td><%}
			for(int k = fD; k<8 ;k++)
			{ 
				if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
				<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
				<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
					</ul></td>
			<%} else {
				%>
				<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
				<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}day++;%>
					</ul></td>
			<%}
			}	
			%>
			</tr>
		<%
		} else {
		%>
		<tr>
		<%
		for(int j = 0;j<7 && day<= 28;j++,day++)
		{
			if(yearNow.equals(year) && monthNow.equals(month) && dayNow.equals(""+day)){%>
				<td id = "today"><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
				<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
					</ul></td>
			<%} else { %>
				<td><a href="puDaySession.jsp?day=<%=day %>"><%=day %></a>
				<ul><%for(int p = 0; p<puMemos.size() ;p++) {
								PuMemo puMemo = puMemos.get(p);
								if(Integer.parseInt(puMemo.getDay())==day){
									%><li><%="-"+puMemo.getPuMemo() %></li>
								<%}
							}%>
					</ul></td>
			<%
			}
		}
		%>
		</tr>
		<%
	}
}
%>
</table>
<%
break;
}
}
%>

</body>
</html>