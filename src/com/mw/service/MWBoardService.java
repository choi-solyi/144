package com.mw.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;

import com.mw.dto.MWBoardDTO;
import com.mw.dto.MWRepBoardDTO;
import com.mw.dto.MWUpBoardDTO;

import oracle.jdbc.driver.DBConversion;

import com.lol.comm.DBConn;
import com.mw.dao.MWBoardDAO;

public class MWBoardService {

	private static MWBoardService service = new MWBoardService();
	private MWBoardService() {
		
	}
	
	public static MWBoardService getService() {
		
		return service;
	}

	public List<MWBoardDTO> mwList(String search, String searchtxt, int startrow, int pagepercount) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		List<MWBoardDTO> list = new ArrayList<>();
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			
			list = dao.mwBoardSelect(conn, search, searchtxt, startrow, pagepercount);
						
			conn.commit();
		}
		catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}
		finally {
			if(conn!=null) try{conn.close();} catch(Exception e) {}

		}
		
		return list;
	}
	
	public List<MWUpBoardDTO> upMwList() {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		List<MWUpBoardDTO> uplist = new ArrayList<>();
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			
			uplist = dao.mwBoardUpSelect(conn);
						
			conn.commit();
		}
		catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}
		finally {
			if(conn!=null) try{conn.close();} catch(Exception e) {}

		}
		
		return uplist;
	}

	public void mwInsert(MWBoardDTO dto) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			dao.mwInsert(conn, dto);
			
			conn.commit();
		}
		catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}
		finally {
			if(conn!=null) try{conn.close();} catch(Exception e) {}
			
		}
		
	}

	public MWBoardDTO mwDetail(int no) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		MWBoardDTO dto = null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			
			dao.mwHit(conn, no);
			dto = dao.mwDetail(conn, no);
			
			
			conn.commit();
		}
		catch(NamingException | SQLException e){
			System.out.println(e);
			try {conn.rollback();} catch(SQLException e2) {}
		}
		finally {
			if(conn!=null) try { conn.close();} catch(SQLException e){}
		}
		return dto;
	}
	
	public MWBoardDTO mwUp(int no) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		MWBoardDTO dto = null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			
			dao.mwUp(conn, no);
			dto = dao.mwDetail(conn, no);
			
			conn.commit();
			
		}
		catch(NamingException | SQLException e){
			System.out.println(e);
			try {conn.rollback();} catch(SQLException e2) {}
		}
		finally {
			if(conn!=null) try { conn.close();} catch(SQLException e){}
		}
		return dto;
		
	}

	public void mwUpdate(MWBoardDTO dto) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			dao.mwUpdate(conn, dto);
			conn.commit();
		}
		catch(NamingException | SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}

	public void mwDelete(int no) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			dao.mwDelete(conn, no);
			
			conn.commit();
		}
		catch(NamingException | SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(SQLException e2) {}
		}
		finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}

	public int getCount(String search, String searchtxt) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		int count = 0;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			count = dao.mwCount(conn, search, searchtxt);
			System.out.println("COUNT!!!: "+count);
			conn.commit();
		}
		catch(NamingException | SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(SQLException e2) {};
		}
		finally {
			if(conn!=null) try{conn.close();} catch(Exception e) {}

		}
		
		return count;
	}

	public void addRep(MWRepBoardDTO rdto) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			dao.addRep(conn, rdto);
			System.out.println(rdto.getBno());
			conn.commit();
			
		}
		catch(NamingException | SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}

	public List<MWRepBoardDTO> repDetail(int no) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		List<MWRepBoardDTO> list = null;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			list = dao.repDetailList(conn, no);
			
			conn.commit();
		}
		catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}
		finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return list;
	}

	public void repDelete(int repno, int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);
			MWBoardDAO dao = MWBoardDAO.getDAO();
			dao.repDelete(conn, repno, bno);
			
			conn.commit();
		}
		catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}
		finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}

	

	

	
}
