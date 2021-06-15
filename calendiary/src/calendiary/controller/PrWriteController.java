package calendiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;

public class PrWriteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String year = (String)session.getAttribute("year");
		String _month = (String)session.getAttribute("_month");
		String _day = (String)session.getAttribute("_day");
		
		String id = (String)session.getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		content = content.replace("\r\n","<br>");
		String date = year+_month+_day;
		
		Service s = Service.getInstance();
		s.prWrite(id,title,content,date);
		String path = "/prDay.do";
		HttpUtil.forward(request, response, path);
	}
}
