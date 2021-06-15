package calendiary.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;
import calendiary.vo.PuMemo;
import calendiary.vo.PuWrite;

public class PuDayController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String major = (String)session.getAttribute("major");
		String year = (String)session.getAttribute("year");
		String _month = (String)session.getAttribute("_month");
		String _day = (String)session.getAttribute("_day");
		String msg = (String)request.getAttribute("msg");
	
		String date = year+_month+_day;
		
		Service s = Service.getInstance();
		ArrayList<PuMemo> puMemos= s.puMemoList(date,major);
		ArrayList<PuWrite> puWrites= s.puWriteList(date,major);
		
		request.setAttribute("puMemos", puMemos);
		request.setAttribute("puWrites", puWrites);
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/puDay.jsp");
	}
}
