package calendiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;
import calendiary.vo.PrWrite;

public class RemovePrWriteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String wTime = request.getParameter("wTime");
		String key = request.getParameter("key");
		String path = null;
		
		if(key.equals("r")) {
			Service s = Service.getInstance();
			s.removePrWrite(id,wTime);
			path = "/prDay.do";
		}else if(key.equals("f")) {
			Service s = Service.getInstance();
			PrWrite prWrite = s.intoPrWrite(id,wTime);
			String content = prWrite.getContent();
			content = content.replace("<br>","\r\n");
			prWrite.setContent(content);
			request.setAttribute("prWrite", prWrite);
			path = "/prWrite.jsp";
				
			s.removePrWrite(id,wTime);
		}	
		
		HttpUtil.forward(request, response, path);
	}
}
