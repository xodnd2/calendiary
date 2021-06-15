package calendiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;

public class RemovePrMemoController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String wTime = request.getParameter("wTime");
		
		Service s = Service.getInstance();
		s.removePrMemo(id,wTime);
		
		HttpUtil.forward(request, response, "/prDay.do");
	}
}
