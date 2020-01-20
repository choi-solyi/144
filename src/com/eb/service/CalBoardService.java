package com.eb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.eb.dao.CalBoardDAO;
import com.eb.dto.CalBoardDTO;
import com.eb.dto.CalSubBoardDTO;
import com.lol.comm.DBConn;

public class CalBoardService {
	private static CalBoardService service=new CalBoardService();
	public static CalBoardService getService(){
		return service;
	}
	private CalBoardService() {}

	public List<CalBoardDTO> list(int startrow, int endrow, String search, String searchtxt) {
		DBConn db=DBConn.getDB();
		Connection conn=null;
		List<CalBoardDTO> list=null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
			list=dao.List(conn, startrow, endrow, search, searchtxt);
			conn.commit();
		} catch (SQLException | NamingException e) {
			try {conn.rollback();} catch (SQLException e1) {}
			System.out.println(e);
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return list;
	}


	public CalBoardDTO detail(int bno) {
		DBConn db=DBConn.getDB();
		Connection conn=null;
		CalBoardDTO dto=null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
			dto=dao.Detail(conn,bno);
			conn.commit();
		} catch(SQLException | NamingException e) {
			try {conn.rollback();} catch (SQLException e1) {}
			System.out.println(e);
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return dto;
	}

	public void Insert(CalBoardDTO dto) {
		DBConn db=DBConn.getDB();
		Connection conn=null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
			dao.Insert(conn, dto);
			conn.commit();
		} catch (SQLException | NamingException e) {
			try {conn.rollback();} catch (SQLException e1) {}
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}

	public void Delete(int bno) {
		DBConn db=DBConn.getDB();
		Connection conn=null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
			dao.Delete(conn, bno);
			conn.commit();
		}catch(SQLException|NamingException e){
			try {conn.rollback();} catch (SQLException e1) {}
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}

	public void update(CalBoardDTO dto) {
		DBConn db=DBConn.getDB();
		Connection conn=null;
		try{
			conn=db.getConn();
			conn.setAutoCommit(false);
			CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
			dao.Update(conn, dto);
			conn.commit();
		}catch(SQLException|NamingException e) {
			try {conn.rollback();} catch (SQLException e1) {}
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}

	public int Totalcount(String search, String searchtxt) {
		DBConn db=DBConn.getDB();
		Connection conn=null;
		int totalcount=0;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
			totalcount=dao.getTotalCount(conn, search, searchtxt);
			conn.commit();
		}catch(SQLException|NamingException e) {
			try {conn.rollback();} catch (SQLException e1) {}
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return totalcount;
	}
	public void uphit(int bno) {
		DBConn db=DBConn.getDB();
		Connection conn=null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
			dao.Uphit(conn,bno);
			conn.commit();
		}catch(SQLException|NamingException e){
			System.out.println(e);
			try {conn.rollback();} catch (SQLException e1) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
	public List<CalSubBoardDTO> subDetail(int bno) {
		List<CalSubBoardDTO> list=new ArrayList<CalSubBoardDTO>();
		CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
		DBConn db=DBConn.getDB();
		Connection conn=null;
		try {
			conn=db.getConn();
			list=dao.SubDetail(conn, bno);
		}catch(SQLException | NamingException e){
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return list;
	}
	public void AddRep(CalSubBoardDTO dto) {
		CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
		DBConn db=DBConn.getDB();
		Connection conn=null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			dao.CalAddRep(conn, dto);
			conn.commit();
		}catch(SQLException|NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch (SQLException e1) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}



	}
	public void DelRep(int repno) {
		DBConn db=DBConn.getDB();
		Connection conn=null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
			dao.DelRep(conn, repno);
			System.out.println(repno);
			conn.commit();
		}catch(SQLException|NamingException e){
			System.out.println(e);
			try {conn.rollback();} catch (SQLException e1) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
}






