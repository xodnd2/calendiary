package calendiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;

public class RemovePuMemoController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String wTime = request.getParameter("wTime");
		String ownId = request.getParameter("ownId");
		
		if(id.equals(ownId))
		{
			Service s = Service.getInstance();
			s.removePuMemo(id,wTime);
		} else {
			request.setAttribute("msg", "F");
		}
		
		HttpUtil.forward(request, response, "/puDay.do");
	}

}
