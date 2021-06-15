package calendiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calendiary.service.Service;

public class MemberFixController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String msg = null;
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pwd = request.getParameter("pwd");
		String pwdR = request.getParameter("pwdR");
		if(!pwd.equals(pwdR))
		{
			msg = "RF";
			request.setAttribute("msg", msg);
			HttpUtil.forward(request, response, "/memberFix.jsp");
		} else {
		String name = request.getParameter("name");
		String major = request.getParameter("major");	
		if(!pwd.equals("")) {
			Service s = Service.getInstance();
			s.changePwd(pwd,id);
		}
		if(!name.equals(""))
		{
			Service s = Service.getInstance();
			s.changeName(name,id);
		}if(!major.equals("0"))
		{
			Service s = Service.getInstance();
			s.changeMajor(major,id);
			session.setAttribute("major", major);
		}
		HttpUtil.forward(request, response, "/menu.jsp");
		}
	}
}
