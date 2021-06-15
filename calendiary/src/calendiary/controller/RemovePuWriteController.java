package calendiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;
import calendiary.vo.PuWrite;

public class RemovePuWriteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String wTime = request.getParameter("wTime");
		String ownId = request.getParameter("ownId");
		String key = request.getParameter("key");
		String path = null;
		
		if(key.equals("r")) {
			if(id.equals(ownId))
			{
				Service s = Service.getInstance();
				s.removePuWrite(id,wTime);
				path = "/puDay.do";
			} else {
				request.setAttribute("msg", "F");
				path = "/intoPuWrite.do?ownId"+ownId+"&wTime="+wTime;
			}
		} else if(key.equals("f")) {
			if(id.equals(ownId))
			{
				Service s = Service.getInstance();
				PuWrite puWrite = s.intoPuWrite(id,wTime);
				String content = puWrite.getContent();
				content = content.replace("<br>","\r\n");
				puWrite.setContent(content);
				request.setAttribute("puWrite", puWrite);
				path = "/puWrite.jsp";
				
				s.removePuWrite(id,wTime);
			} else {
				request.setAttribute("msg", "F");
				path = "/intoPuWrite.do?ownId"+ownId+"&wTime="+wTime;
			}
		}		
		HttpUtil.forward(request, response, path);
	}

}
