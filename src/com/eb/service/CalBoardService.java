package com.eb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.eb.dao.CalBoardDAO;
import com.eb.dto.CalBoardDTO;
import com.lol.comm.DBConn;

public class CalBoardService {
	private static CalBoardService service=new CalBoardService();
	public static CalBoardService getService(){
		return service;
	}
	private CalBoardService() {}
	
	public List<CalBoardDTO> list() {
		DBConn db=DBConn.getDB();
		Connection conn=null;
		List<CalBoardDTO> list=null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
				CalBoardDAO dao=CalBoardDAO.getCalBoardDAO();
				list=dao.List(conn);
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
	
}

	
	
	
	

