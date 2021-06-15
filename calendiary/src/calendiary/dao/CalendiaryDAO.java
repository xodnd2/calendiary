package calendiary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import calendiary.vo.PrMemo;
import calendiary.vo.PrWrite;
import calendiary.vo.PuMemo;
import calendiary.vo.PuWrite;


public class CalendiaryDAO {
	private static CalendiaryDAO dao = new CalendiaryDAO();
	public static CalendiaryDAO getInstance() {
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendiary","root","1234");
		} catch (Exception e) {
			System.out.print("MDAO : connect"+e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			} catch(Exception e) {
				System.out.print("Pstmt close error");
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			} catch(Exception e) {
				System.out.print("Conn close error");
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			} catch(Exception e) {
				System.out.print("Rs close error");
			}
		}
		close(conn, pstmt); 
	}
	
	public String login(String id, String pwd) {
		// TODO Auto-generated method stub
		String result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select major from member where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next() )
			{
				result = rs.getString("major");
			}
		} catch(Exception e) {
			System.out.print("Login error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}

	public boolean register(String id, String pwd, String name, String major) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?);");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, major);
			pstmt.executeUpdate();
			result = true;
		} catch(Exception e) {
			System.out.print("Register error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}

	public boolean check(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next() )
			{
				result = true;
			}
		} catch(Exception e) {
			System.out.print("Check error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}

	public void prMemo(String id, String memo, String date) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into prmemo values(?,?,?,now());");
			pstmt.setString(1, id);
			pstmt.setString(2, memo);
			pstmt.setString(3, date);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("prMemo error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public ArrayList<PrMemo> prMemoList(String id, String date) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PrMemo> prMemos = new ArrayList<PrMemo>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select memo,wtime from prmemo where id = ? and date = ? order by wtime desc;");
			pstmt.setString(1, id);
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				PrMemo prMemo = new PrMemo();
				prMemo.setPrMemo(rs.getString("memo"));
				prMemo.setWTime(rs.getString("wtime"));
				prMemos.add(prMemo);
			}
		} catch(Exception e) {
			System.out.print("prMemoList error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return prMemos;
	}

	public void prWrite(String id, String title, String content, String date) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into prwrite values(?,?,?,?,now());");
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, date);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("prWrite error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public void removePrMemo(String id, String wTime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from prmemo where id = ? and wtime = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, wTime);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("removePrMemo error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}
	public ArrayList<PrMemo> prCalMemoList(String sendDay, String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PrMemo> prMemos = new ArrayList<PrMemo>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select memo,date from prmemo where date like ? and id = ? order by wtime desc;");
			pstmt.setString(1, sendDay);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				PrMemo prMemo = new PrMemo();
				prMemo.setPrMemo(rs.getString("memo"));
				prMemo.setDay((rs.getString("date")).substring(6,8));
				prMemos.add(prMemo);
			}
		} catch(Exception e) {
			System.out.print("prCalMemoList error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return prMemos;
	}

	public ArrayList<PrWrite> prWriteList(String id, String date) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PrWrite> prWrites = new ArrayList<PrWrite>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select title,wtime from prwrite where id = ? and date = ? order by wtime desc;");
			pstmt.setString(1, id);
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				PrWrite prWrite = new PrWrite();
				prWrite.setPrTitle(rs.getString("title"));
				prWrite.setWTime(rs.getString("wtime"));
				prWrites.add(prWrite);
			}
		} catch(Exception e) {
			System.out.print("prWriteList error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return prWrites;
	}

	public PrWrite intoPrWrite(String id, String wTime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PrWrite prWrite = new PrWrite();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select title,content from prwrite where id = ? and wtime = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, wTime);
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				prWrite.setPrTitle(rs.getString("title"));
				prWrite.setContent(rs.getString("content"));
			}
		} catch(Exception e) {
			System.out.print("intoPrWrite error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return prWrite;
	}

	public void removePrWrite(String id, String wTime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from prwrite where id = ? and wtime = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, wTime);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("removePrWrite error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}
	//PU
	public ArrayList<PuMemo> puMemoList(String date, String major) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PuMemo> puMemos = new ArrayList<PuMemo>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select a.id,memo,wtime,name from pumemo a,member b where a.id = b.id and date = ? and a.major = ? order by wtime desc;");
			pstmt.setString(1, date);
			pstmt.setString(2, major);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				PuMemo puMemo = new PuMemo();
				puMemo.setId(rs.getString("id"));
				puMemo.setPuMemo(rs.getString("memo"));
				puMemo.setWTime(rs.getString("wtime"));
				puMemo.setName(rs.getString("name"));
				puMemos.add(puMemo);
			}
		} catch(Exception e) {
			System.out.print("puMemoList error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return puMemos;
	}
	public ArrayList<PuMemo> puCalMemoList(String sendDay, String major) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PuMemo> puMemos = new ArrayList<PuMemo>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select memo,date from pumemo where date like ? and major = ? order by wtime desc;");
			pstmt.setString(1, sendDay);
			pstmt.setString(2, major);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				PuMemo puMemo = new PuMemo();
				puMemo.setPuMemo(rs.getString("memo"));
				puMemo.setDay((rs.getString("date")).substring(6, 8));
				puMemos.add(puMemo);
			}
		} catch(Exception e) {
			System.out.print("puCalMemoList error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return puMemos;
	}

	public ArrayList<PuWrite> puWriteList(String date, String major) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PuWrite> puWrites = new ArrayList<PuWrite>();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select title,wtime,name,a.id from puwrite a,member b where a.id = b.id and date = ? and a.major = ? order by wtime desc;");
			pstmt.setString(1, date);
			pstmt.setString(2, major);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				PuWrite puWrite = new PuWrite();
				puWrite.setPuTitle(rs.getString("title"));
				puWrite.setWTime(rs.getString("wtime"));
				puWrite.setName(rs.getString("name"));
				puWrite.setId(rs.getString("id"));
				puWrites.add(puWrite);
			}
		} catch(Exception e) {
			System.out.print("puWriteList error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return puWrites;
	}

	public void puMemo(String id, String memo, String date, String major) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into pumemo values(?,?,?,?,now());");
			pstmt.setString(1, id);
			pstmt.setString(2, major);
			pstmt.setString(3, memo);
			pstmt.setString(4, date);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("puMemo error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public void puWrite(String id, String title, String content, String date, String major) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into puwrite values(?,?,?,?,?,now());");
			pstmt.setString(1, id);
			pstmt.setString(2, major);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, date);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("puWrite error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public void removePuMemo(String id, String wTime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from pumemo where id = ? and wtime = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, wTime);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("removePuMemo error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public void removePuWrite(String id, String wTime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from puwrite where id = ? and wtime = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, wTime);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("removePuWrite error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public PuWrite intoPuWrite(String id, String wTime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PuWrite puWrite = new PuWrite();
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select id,title,content from puwrite where id = ? and wtime = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, wTime);
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				puWrite.setId(rs.getString("id"));
				puWrite.setPuTitle(rs.getString("title"));
				puWrite.setContent(rs.getString("content"));
			}
		} catch(Exception e) {
			System.out.print("intoPuWrite error"+e);
		} finally
		{
			close(conn,pstmt,rs);
		}
		return puWrite;
	}
	//System
	public void changePwd(String pwd, String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("update member set pwd = ? where id = ?;");
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("changePwd error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public void changeName(String name, String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("update member set name = ? where id = ?;");
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("changeName error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public void changeMajor(String major, String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("update member set major = ? where id = ?;");
			pstmt.setString(1, major);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("changeMajor error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}

	public void removeMember(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from member where id = ?;");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("removePrMember error" + e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}
}	
