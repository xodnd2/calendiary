package calendiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calendiary.service.Service;

public class RegisterController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String msg = null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwdR = request.getParameter("pwdR");
		if(!pwd.equals(pwdR))
		{
			msg = "RF";
			request.setAttribute("msg", msg);
			HttpUtil.forward(request, response, "/register.jsp");
		} else {
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		Service s = Service.getInstance();
		boolean result = s.register(id,pwd,name,major);
		
		if(result)
		{
			msg = "RS";
		} else
		{
			msg = "RF";
		}
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/login.jsp");
		}
	}
}
