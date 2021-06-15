package calendiary.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;

public class LoginController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String major = null;
		String msg = null;
		Service s = Service.getInstance();
		major = s.login(id,pwd);
		String path = null;
		if(major != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("major", major);
			path = "/menu.jsp";
		} else
		{
			path ="/login.jsp";
			msg = "LF";	
		}
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, path);
	}
}
