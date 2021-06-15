package calendiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;

public class CheckController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");		
		String pwd = request.getParameter("pwd");
		String path = null;
		
		Service s = Service.getInstance();
		boolean result = s.check(id,pwd);
		if(result == true) {
			path = "/memberFix.jsp";
		} else {
			String msg = "F";
			request.setAttribute("msg",msg);
			path = "/check.jsp";
		}
		
		HttpUtil.forward(request, response, path);
	}
}
