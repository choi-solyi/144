package com.dy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import com.lol.comm.DBConn;
import com.dy.dao.DYBoardDAO;
import com.dy.dto.DYBoardDTO;

public class DYBoardService {

	private static DYBoardService service = new DYBoardService();
	public static DYBoardService getservice() {
		return service;
	}
	private DYBoardService () {}

	
	public List<DYBoardDTO> dylist() {
		// TODO Auto-generated method stub
		
		DBConn dbconn = DBConn.getDB();
		Connection conn= null;
		List<DYBoardDTO> list =null;
		
		try {
			conn=dbconn.getConn();
			conn.setAutoCommit(false);
			
			DYBoardDAO dao = DYBoardDAO.getdao();
			list = dao.dylist(conn);
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
			dao.dyupdate(conn,dto);
			
			conn.commit();
		}catch(NamingException | SQLException e) {
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
	}
	
	
}

