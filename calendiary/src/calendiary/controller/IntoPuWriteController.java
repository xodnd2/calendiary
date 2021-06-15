package calendiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calendiary.service.Service;
import calendiary.vo.PuWrite;

public class IntoPuWriteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ownId = request.getParameter("ownId");
		String wTime = request.getParameter("wTime");
		String msg = (String)request.getAttribute("msg");
		
		Service s = Service.getInstance();
		PuWrite puWrite = s.intoPuWrite(ownId,wTime);
		
		request.setAttribute("puWrite", puWrite);
		request.setAttribute("wTime", wTime);
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/intoPuWrite.jsp");
	}

}
