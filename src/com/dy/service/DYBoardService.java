package com.dy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import com.lol.comm.DBConn;
import com.dy.dao.DYBoardDAO;
import com.dy.dto.DYBoardDTO;
import com.dy.dto.DYRepBoardDTO;

public class DYBoardService {

	private static DYBoardService service = new DYBoardService();
	public static DYBoardService getservice() {
		return service;
	}
	private DYBoardService () {}

	
	public List<DYBoardDTO> dylist(int startrow, int endrow, String search, String txtsearch) {
		// TODO Auto-generated method stub
		
		DBConn dbconn = DBConn.getDB();
		Connection conn= null;
		List<DYBoardDTO> list =null;
		
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			list = dao.dylist(conn,startrow,endrow,search,txtsearch);
			System.out.println(list);
			conn.commit();
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return list;
	}
	public void dyinsert(DYBoardDTO dto) {
		// TODO Auto-generated method stub
		
		DBConn dbconn= DBConn.getDB();
		Connection conn= null;
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			dao.dyinsert(conn,dto);
			
			conn.commit();
		}catch(NamingException | SQLException e) {
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
	}
	public DYBoardDTO dydetail(int bno) {
		// TODO Auto-generated method stub
		
		DBConn dbconn = DBConn.getDB();
		Connection conn=null;
		
		DYBoardDTO dto= null;
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			dto = dao.dydetail(conn,bno);
			dao.dyhitup(conn,bno);
			
			conn.commit();		
		}catch(NamingException | SQLException e) {
			System.out.println(e);
			try{conn.rollback();}catch(SQLException e2) {}
			
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}  
		}
		
		return dto;
	}
	public void dydelete(int bno) {
		// TODO Auto-generated method stub
		
		DBConn dbconn = DBConn.getDB();
		Connection conn=null;
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			dao.dydelete(conn,bno);
			
			conn.commit();
		}catch(NamingException | SQLException e) {
			System.out.println(e);
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
	}
	public void dyupdate(DYBoardDTO dto) {
		// TODO Auto-generated method stub
		DBConn dbconn = DBConn.getDB();
		Connection conn=null;
		
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			dao.dyupdate(conn, dto);
			
			conn.commit();
		}catch(NamingException | SQLException e) {
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
	}
	public int dygetCount(String search, String txtsearch) {
		// TODO Auto-generated method stub
		
		DBConn dbconn = DBConn.getDB();
		Connection conn=null;
		int totalcount =0;
		
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			totalcount = dao.dygetCount(conn, search, txtsearch);
			
			conn.commit();
		}catch(NamingException | SQLException e) {
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return totalcount;
	}
	public void dyrepinsert(DYRepBoardDTO dto) {
		// TODO Auto-generated method stub
		
		DBConn dbconn = DBConn.getDB();
		Connection conn=null;
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			dao.dyrepinsert(conn,dto);
			
			conn.commit();
		}catch(NamingException | SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
	}
	public List<DYRepBoardDTO> dyreplist(int bno) {
		// TODO Auto-generated method stub
		DBConn dbconn = DBConn.getDB();
		Connection conn=null;
		
		List<DYRepBoardDTO> list =null;
		
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			 list = dao.dyreplist(conn,bno);
			
			conn.commit();
		}catch(NamingException | SQLException e) {
			System.out.println(e);
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return list;
	}
	public void dyrepdelete(int repno) {
		// TODO Auto-generated method stub
		DBConn dbconn = DBConn.getDB();
		Connection conn = null;
		
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			dao.dyrepdelete(conn,repno);
			
			conn.commit();
		}catch(NamingException | SQLException e){
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
	}
	
	
	
	
}

