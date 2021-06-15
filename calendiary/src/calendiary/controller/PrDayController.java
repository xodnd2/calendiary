package calendiary.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;
import calendiary.vo.PrMemo;
import calendiary.vo.PrWrite;

public class PrDayController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String year = (String)session.getAttribute("year");
		String _month = (String)session.getAttribute("_month");
		String _day = (String)session.getAttribute("_day");
	
		String date = year+_month+_day;
		
		Service s = Service.getInstance();
		ArrayList<PrMemo> prMemos= s.prMemoList(id,date);
		ArrayList<PrWrite> prWrites= s.prWriteList(id,date);
		
		request.setAttribute("prMemos", prMemos);
		request.setAttribute("prWrites", prWrites);
		HttpUtil.forward(request, response, "/prDay.jsp");
	}
}
