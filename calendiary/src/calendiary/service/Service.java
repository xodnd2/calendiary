package calendiary.service;

import java.util.ArrayList;

import calendiary.dao.CalendiaryDAO;
import calendiary.vo.PrMemo;
import calendiary.vo.PrWrite;
import calendiary.vo.PuMemo;
import calendiary.vo.PuWrite;

public class Service {
	private static Service service = new Service() {};
	private Service() {}
	private CalendiaryDAO dao = CalendiaryDAO.getInstance();
	public static Service getInstance()
	{
		return service;
	}
	public String login(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(id, pwd);
	}
	
	public boolean register(String id, String pwd, String name, String major) {
		// TODO Auto-generated method stub
		return dao.register(id,pwd,name,major);
	}
	public boolean check(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.check(id,pwd);
	}
	//PR
	public void prMemo(String id, String memo, String date) {
		// TODO Auto-generated method stub
		dao.prMemo(id,memo,date);
	}
	public ArrayList<PrMemo> prMemoList(String id, String date) {
		// TODO Auto-generated method stub
		return dao.prMemoList(id, date);
	}
	public void prWrite(String id, String title, String content, String date) {
		// TODO Auto-generated method stub
		dao.prWrite(id,title,content,date);
	}
	public void removePrMemo(String id, String wTime) {
		// TODO Auto-generated method stub
		dao.removePrMemo(id,wTime);
	}
	public ArrayList<PrWrite> prWriteList(String id, String date) {
		// TODO Auto-generated method stub
		return dao.prWriteList(id, date);
	}
	public PrWrite intoPrWrite(String id, String wTime) {
		// TODO Auto-generated method stub
		return dao.intoPrWrite(id,wTime);
	}
	public void removePrWrite(String id, String wTime) {
		// TODO Auto-generated method stub
		dao.removePrWrite(id, wTime);
	}
	//PU
	public ArrayList<PuMemo> puMemoList(String date, String major) {
		// TODO Auto-generated method stub
		return dao.puMemoList(date,major);
	}
	public ArrayList<PuWrite> puWriteList(String date, String major) {
		// TODO Auto-generated method stub
		return dao.puWriteList(date,major);
	}
	public void puMemo(String id, String memo, String date, String major) {
		// TODO Auto-generated method stub
		dao.puMemo(id,memo,date,major);
	}
	public void puWrite(String id, String title, String content, String date, String major) {
		// TODO Auto-generated method stub
		dao.puWrite(id,title,content,date,major);
	}
	public void removePuMemo(String id, String wTime) {
		// TODO Auto-generated method stub
		dao.removePuMemo(id,wTime);
	}
	public void removePuWrite(String id, String wTime) {
		// TODO Auto-generated method stub
		dao.removePuWrite(id, wTime);
	}
	public PuWrite intoPuWrite(String id, String wTime) {
		// TODO Auto-generated method stub
		return dao.intoPuWrite(id,wTime);
	}
	public void changePwd(String pwd, String id) {
		// TODO Auto-generated method stub
		dao.changePwd(pwd,id);
	}
	public void changeName(String name, String id) {
		// TODO Auto-generated method stub
		dao.changeName(name,id);
	}
	public void changeMajor(String major, String id) {
		// TODO Auto-generated method stub
		dao.changeMajor(major,id);
	}
	public ArrayList<PuMemo> puCalMemoList(String sendDay, String major) {
		// TODO Auto-generated method stub
		return dao.puCalMemoList(sendDay,major);
	}
	public ArrayList<PrMemo> prCalMemoList(String sendDay, String id) {
		// TODO Auto-generated method stub
		return dao.prCalMemoList(sendDay,id);
	}
	public void removeMember(String id) {
		// TODO Auto-generated method stub
		dao.removeMember(id);
	}
}
