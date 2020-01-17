package com.sy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;

import com.lol.comm.DBConn;
import com.sy.dao.JGBoardDAO;
import com.sy.dto.JGBoardDTO;
import com.sy.dto.JGRepBoardDTO;

public class JGBoardService {
	private static JGBoardService service = new JGBoardService();
	public static JGBoardService getService() {
		return service;
	}
	private JGBoardService() {}
	public List<JGBoardDTO> list(int startRow, int endRow){
		DBConn db = DBConn.getDB();
		
		Connection conn = null;
		List<JGBoardDTO> list = null;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			
			list = dao.list(conn, startRow, endRow);	
			System.out.println("servicelist:" + list);
			
			conn.commit();
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		System.out.println(list+"4444444444444444");
		return list;
	}
	
	public void insert(JGBoardDTO dto) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			dao.insert(conn, dto);
			
			conn.commit();
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(SQLException e2) {}
		}finally {
			if( conn!=null ) try{ conn.close(); } catch(SQLException e) {}
		}
	}
	public JGBoardDTO detail(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		JGBoardDTO dto = new JGBoardDTO();
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			dto = dao.detail(conn, bno);
			
			dao.upHit(conn, bno);
			
			conn.commit();
			
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(SQLException e2) {}
		}finally {
			if( conn!=null ) try{ conn.close(); } catch(SQLException e) {}
		}

		return dto;
	}
	 
	//return °ª ¾ø¾îµÎ´ï
	public JGBoardDTO update(JGBoardDTO dto, int bno) {

		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			dao.update(conn, bno, dto);
			
			conn.commit();
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(Exception e2) {}
		}finally {
			if( conn!=null ) try{ conn.close(); } catch(SQLException e) {}
		}
		
		return dto;
	}
	public void delete(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			dao.delete(conn, bno);
			
			conn.commit();
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(Exception e2) {}
		}finally {
			if( conn!=null ) try{ conn.close(); } catch(SQLException e) {}
		}
		
	}
	//´ñ±Û Ãß°¡
	public void addRep(int bno, JGRepBoardDTO rdto) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			dao.addRep(conn, bno, rdto);
			
			conn.commit();
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(Exception e2) {}
		}finally {
			if( conn!=null ) try{ conn.close(); } catch(SQLException e) {}
		}
	}
	public List<JGRepBoardDTO> listReq(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		List<JGRepBoardDTO> list = new ArrayList<>();
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			list = dao.ListRep(conn, bno);
			
			conn.commit();
			
		}catch(NamingException|SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return list;
	}
	public int totalCount() {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		int totalCount = 0;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			
			totalCount = dao.getTotalCount(conn);
			conn.commit();
			
		}catch(NamingException|SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return totalCount;
		
	}
}
