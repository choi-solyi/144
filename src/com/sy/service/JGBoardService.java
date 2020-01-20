package com.sy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;


import com.lol.comm.DBConn;
import com.sy.dao.JGBoardDAO;
import com.sy.dto.JGBoardDTO;
import com.sy.dto.JGRepBoardDTO;
import com.sy.dto.MDDTO;
import com.user.comm.UserDTO;

public class JGBoardService {
	private static JGBoardService service = new JGBoardService();
	public static JGBoardService getService() {
		return service;
	}
	private JGBoardService() {}
	public List<JGBoardDTO> list(int startRow, int endRow, String search){
		DBConn db = DBConn.getDB();
		
		Connection conn = null;
		List<JGBoardDTO> list = null;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			
			list = dao.list(conn, startRow, endRow, search);	
			
			conn.commit();
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
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
	public int totalCount(String search) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		int totalCount = 0;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			
			totalCount = dao.getTotalCount(conn, search);
			conn.commit();
			
		}catch(NamingException|SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return totalCount;
		
	}
	public void delrep(int repno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			dao.delRep(conn, repno);
			System.out.println("22222222222222222222"+repno);

			conn.commit();
			
		}catch(NamingException|SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
	}
/*	public void history(String sname) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
	
			conn.commit();
			
		}catch(NamingException|SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}		
	}*/
	/*public int login(String id, String pw) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		int result = 0;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			result = dao.login(conn, id,pw);
	
			conn.commit();
			
		}catch(NamingException|SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}		
		
		return result;
	}*/
	public MDDTO getMdDetail(int mdcode) {
		DBConn db = DBConn.getDB();
		Connection conn = null;

		MDDTO mddto = new MDDTO();
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			mddto = dao.getMdDetail(conn, mdcode);
			System.out.println("servcie - mddto : " + mddto);
			conn.commit();
			
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(SQLException e2) {}
		}finally {
			if( conn!=null ) try{ conn.close(); } catch(SQLException e) {}
		}

		return mddto;		
	}
	public JGBoardDTO prev(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		JGBoardDTO dto = new JGBoardDTO();

		
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			dto = dao.prev(conn, bno);
			System.out.println(dto + "service arr");

			
			conn.commit();
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(SQLException e2) {}
		}finally {
			if( conn!=null ) try{ conn.close(); } catch(SQLException e) {}
		}
		
		return dto;
		
	}
	public JGBoardDTO next(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		JGBoardDTO dto = new JGBoardDTO();

		
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			
			JGBoardDAO dao = JGBoardDAO.getDAO();
			dto = dao.next(conn, bno);
			System.out.println(dto + "service arr");

			
			conn.commit();
		}catch(NamingException|SQLException e) {
			e.getStackTrace();
			try { conn.rollback(); } catch(SQLException e2) {}
		}finally {
			if( conn!=null ) try{ conn.close(); } catch(SQLException e) {}
		}
		
		return dto;
		
	}
}
