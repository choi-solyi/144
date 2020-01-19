package com.sb.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.lol.comm.DBConn;
import com.sb.dao.SUPBoardDAO;
import com.sb.dto.SUPBoardDTO;
import com.sb.dto.SUPRepBoardDTO;


public class SUPBoardService {
	private static SUPBoardService instance = new SUPBoardService();
	
	private SUPBoardService() {
		
		
		
	}
	
	public static SUPBoardService sbGetBoardService() {
		
		return instance;
		
	}
	
	public List<SUPBoardDTO> sbList(int startrow, int endrow, String search, String txtsearch){
		DBConn db = DBConn.getDB();
		Connection conn=null;
		List<SUPBoardDTO> list = null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			list=dao.sbList(conn,startrow, endrow,search, txtsearch);
			
			conn.commit();
			
		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return list;
	}

	public void sbInsert(SUPBoardDTO dto) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		
		
		
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			dao.sbInsert(conn,dto);
			
			conn.commit();
			
			
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
			
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
	}

	public SUPBoardDTO sbDetail(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		SUPBoardDTO dto = null;
		try {
			conn= db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			dto=dao.sbDetail(conn,bno);
			dao.sbUpHit(conn, bno);
			conn.commit();
			
		}catch(SQLException| NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return dto;
	}

	public void sbDelete(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		try {
			conn= db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			dao.sbDelete(conn,bno);
			
			conn.commit();
			
		}catch(SQLException| NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
		
	}

	public void sbUpdate(SUPBoardDTO dto) {
		DBConn db = DBConn.getDB();
		Connection conn=null;
		
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			dao.sbUpdate(conn,dto);
			
			conn.commit();
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	
		
	}

	public int sbGetCount(String search, String txtsearch) {
		DBConn  db=   DBConn.getDB();
	    Connection conn=null;
	    int count=0;
	    try {
	    	  conn=db.getConn();
	    	  conn.setAutoCommit(false);
	    	  SUPBoardDAO dao=SUPBoardDAO.sbGetBoardDAO();
	    	  count=dao.sbGetCount(conn, search, txtsearch);
	    	  conn.commit();
	    }catch(NamingException|SQLException e)
	    {
	    	System.out.println(e);
	       try {conn.rollback();} catch(Exception e2) {}
	    }finally {
	    	if(conn!=null) try { conn.close();} catch(SQLException e) {}
	    }
	    return count;
	}

	public void sbRepAdd(SUPRepBoardDTO rdto) {
		DBConn db = DBConn.getDB();
		Connection conn=null;
		
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			dao.sbRepAdd(conn,rdto);
			
			conn.commit();
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}

	public List<SUPRepBoardDTO> sbDetailRep(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn=null;
		List<SUPRepBoardDTO> list = null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao= SUPBoardDAO.sbGetBoardDAO();
			list=dao.sbDetailRep(conn,bno);
			
			conn.commit();
			
		}catch(SQLException | NamingException e) {
			System.out.println();
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return list;
	}

	public void sbDeleteRep(int repno, int bno) {
		DBConn db = DBConn.getDB();
		Connection conn=null;
		
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao= SUPBoardDAO.sbGetBoardDAO();
			dao.sbDeleteRep(conn,repno,bno);
			conn.commit();
			
		}catch(SQLException | NamingException e) {
			
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
	}
		
	


	
	
}
