package calendiary.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> map = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map = new HashMap<String, Controller>();
		map.put("/login.do",new LoginController());
		map.put("/register.do",new RegisterController());
		map.put("/check.do",new CheckController());
		map.put("/memberFix.do",new MemberFixController());
		map.put("/removeMember.do",new RemoveMemberController());
		
		map.put("/puCal.do",new PuCalController());
		map.put("/puDay.do",new PuDayController());
		map.put("/puMemo.do",new PuMemoController());
		map.put("/puWrite.do",new PuWriteController());
		map.put("/removePuMemo.do",new RemovePuMemoController());
		map.put("/intoPuWrite.do",new IntoPuWriteController());
		map.put("/removePuWrite.do",new RemovePuWriteController());
		
		map.put("/prCal.do",new PrCalController());
		map.put("/prDay.do",new PrDayController());
		map.put("/prMemo.do",new PrMemoController());
		map.put("/prWrite.do",new PrWriteController());
		map.put("/removePrMemo.do",new RemovePrMemoController());
		map.put("/intoPrWrite.do",new IntoPrWriteController());
		map.put("/removePrWrite.do",new RemovePrWriteController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Controller cont = map.get(path);
		cont.execute(req, resp);
	}
}
