package calendiary.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;
import calendiary.vo.PrMemo;

public class PrCalController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String year = (String)session.getAttribute("year");
		String month = (String)session.getAttribute("month");
		
		String i = request.getParameter("i");
		if(i != null)
		{
			if(i.equals("m")) {
				if(Integer.parseInt(month) == 1)
				{
					year = ""+(Integer.parseInt(year)-1);
					month = "12";
				}
				else 
					month = ""+(Integer.parseInt(month)-1);
			} else if(i.equals("p")) {
				if(Integer.parseInt(month) == 12) 
				{
					year = ""+(Integer.parseInt(year)+1);
					month = "1";
				}
				else 
					month = ""+(Integer.parseInt(month)+1);
			}
		}
		String firstDay = null;
		String sendDay = null;
		if(Integer.parseInt(month)<10) {
			firstDay = year+"0"+month+"01";
			sendDay =	year+"0"+month+"__";
		}	
		else {
			firstDay = year+month+"01";
			sendDay =	year+month+"__";
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		try {
			date = dateFormat.parse(firstDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		session.setAttribute("year",year);
		session.setAttribute("month", month);
		request.setAttribute("firstDay", calendar.get(Calendar.DAY_OF_WEEK));
		
		//메모 목록 가져오기
		Service s = Service.getInstance();
		ArrayList<PrMemo> prMemos = s.prCalMemoList(sendDay,id);
		request.setAttribute("prMemos", prMemos);
		HttpUtil.forward(request, response, "/prCal.jsp");
	}
}
