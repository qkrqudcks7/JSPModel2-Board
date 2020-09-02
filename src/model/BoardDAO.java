package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	Connection c;
	PreparedStatement p;
	ResultSet r;
	
	public void getC() {
		try {
			Context i=new InitialContext();
			Context e=(Context) i.lookup("java:comp/env");
			DataSource ds=(DataSource) e.lookup("jdbc/pool");
			c=ds.getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getAllCount() {
		getC();
		int count=0;
		try {
			String sql="select count(*) from board";
			p=c.prepareStatement(sql);
			r=p.executeQuery();
			if(r.next()) {
				count=r.getInt(1);
			}
			c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public Vector<BoardBean> getAllBoard(int startRow, int endRow){
		Vector<BoardBean> v = new Vector<>();
		getC();
		try {
			String sql="select * from (select A.* ,Rownum Rnum from (select * from board order by ref desc,re_step asc)A) where Rnum>=? and Rnum<=? ";
			p=c.prepareStatement(sql);
			p.setInt(1, startRow);
			p.setInt(2, endRow);
			r=p.executeQuery();
			while(r.next()) {
				BoardBean bean= new BoardBean();
				bean.setNum(r.getInt(1));
				bean.setWriter(r.getString(2));
				bean.setEmail(r.getString(3));
				bean.setSubject(r.getString(4));
				bean.setPassword(r.getString(5));
				bean.setReg_date(r.getDate(6).toString());
				bean.setRef(r.getInt(7));
				bean.setRe_step(r.getInt(8));
				bean.setRe_level(r.getInt(9));
				bean.setReadcount(r.getInt(10));
				bean.setContent(r.getString(11));
				v.add(bean);
			}
			c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	public void insertBoard(BoardBean bean) {
		getC();
		int ref=0;
		int re_step=1;
		int re_level=1;
		try {
			
			String refsql="select max(ref) from board";
			p=c.prepareStatement(refsql);
			r=p.executeQuery();
			if(r.next()) {
				ref=r.getInt(1)+1;
			}
			String sql="insert into board values(board_seq.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
			p=c.prepareStatement(sql);
			p.setString(1, bean.getWriter());
			p.setString(2, bean.getEmail());
			p.setString(3, bean.getSubject());
			p.setString(4, bean.getPassword());
			p.setInt(5, ref);
			p.setInt(6, re_step);
			p.setInt(7, re_level);
			p.setString(8, bean.getContent());
			p.executeUpdate();
			c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public BoardBean getOneBoard(int num) {
		BoardBean bean= new BoardBean();
		getC();
		try {
			String readsql="update board set readcount=readcount+1 where num=?";
			p=c.prepareStatement(readsql);
			p.setInt(1, num);
			p.executeUpdate();
			
			String sql="select * from board where num=?";
			p=c.prepareStatement(sql);
			p.setInt(1, num);
			r=p.executeQuery();
			if(r.next()) {
				bean.setNum(r.getInt(1));
				bean.setWriter(r.getString(2));
				bean.setEmail(r.getString(3));
				bean.setSubject(r.getString(4));
				bean.setPassword(r.getString(5));
				bean.setReg_date(r.getDate(6).toString());
				bean.setRef(r.getInt(7));
				bean.setRe_step(r.getInt(8));
				bean.setRe_level(r.getInt(9));
				bean.setReadcount(r.getInt(10));
				bean.setContent(r.getString(11));
			}
			c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	public void reInsertBoard(BoardBean bean) {
		getC();
		int ref=bean.getRef();
		int re_step=bean.getRe_step();
		int re_level=bean.getRe_level();
		try {
			String levelsql="update board set re_level=re_level+1 where ref=? and re_level>?";
			p=c.prepareStatement(levelsql);
			p.setInt(1, ref);
			p.setInt(2, re_level);
			p.executeUpdate();
			
			String sql="insert into board values(board_seq.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
			p=c.prepareStatement(sql);
			p.setString(1, bean.getWriter());
			p.setString(2, bean.getEmail());
			p.setString(3, bean.getSubject());
			p.setString(4, bean.getPassword());
			p.setInt(5, ref);
			p.setInt(6, re_step+1);
			p.setInt(7, re_level+1);
			p.setString(8, bean.getContent());
			p.executeUpdate();
			c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public BoardBean getOneUpdate(int num) {
		BoardBean bean= new BoardBean();
		getC();
		try {
			
			String sql="select * from board where num=?";
			p=c.prepareStatement(sql);
			p.setInt(1, num);
			r=p.executeQuery();
			if(r.next()) {
				BoardBean b=new BoardBean();
				bean.setNum(r.getInt(1));
				bean.setWriter(r.getString(2));
				bean.setEmail(r.getString(3));
				bean.setSubject(r.getString(4));
				bean.setPassword(r.getString(5));
				bean.setReg_date(r.getDate(6).toString());
				bean.setRef(r.getInt(7));
				bean.setRe_step(r.getInt(8));
				bean.setRe_level(r.getInt(9));
				bean.setReadcount(r.getInt(10));
				bean.setContent(r.getString(11));
			}
			c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	public void Update(int num,String subject,String content) {
		getC();
		try {
			String sql="update board set subject=?,content=? where num=?";
			p=c.prepareStatement(sql);
			p.setString(1, subject);
			p.setString(2, content);
			p.setInt(3, num);
			p.executeUpdate();
			c.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(int num) {
		getC();
		try {
			String sql="delete from board where id=?";
			p=c.prepareStatement(sql);
			p.setInt(1, num);
			p.executeUpdate();
			c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
