package com.user.comm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.lol.comm.DBConn;
import com.sy.dao.JGBoardDAO;

public class UserService {
	private static UserService service = new UserService();
	public static UserService getService() {
		return service;
	}
	private UserService() {}

	public int login(String id, String pw) {
		DBConn db = DBConn.getDB();
		Connection conn = null;

		int result = 0;
		try {
			conn = db.getConn();
			conn.setAutoCommit(false);

			UserDAO dao = UserDAO.getDAO();
			result = dao.login(conn, id,pw);

			conn.commit();

		}catch(NamingException|SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}		

		return result;
	}

	//회원가입
	public void join(UserDTO dto) {
		UserDAO dao = UserDAO.getDAO();
		DBConn DBC = DBConn.getDB();
		Connection conn = null;
		try {
			conn=DBC.getConn();
			conn.setAutoCommit(false);
			dao.join(conn,dto);
			conn.commit();
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try{conn.rollback();}catch(SQLException rollback) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
	
	//salt 가져오기
	public String getSalt(String id) {
		String salt = null;
		UserDAO dao = UserDAO.getDAO();
		DBConn DBC = DBConn.getDB();
		Connection conn = null;
		try {
			conn=DBC.getConn();
			salt = dao.getSalt(conn,id);
		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}	
		return salt;
	}
	public UserDTO userinfo(String ssid) {
		UserDAO dao = UserDAO.getDAO();
		DBConn DBC = DBConn.getDB();
		Connection conn = null;
		
		UserDTO dto = new UserDTO();
		try {
			conn=DBC.getConn();
			conn.setAutoCommit(false);
			
			dto = dao.userinfo(conn, ssid);

			System.out.println("get mypage 2222222");
			conn.commit();
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try{conn.rollback();}catch(SQLException rollback) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
		
		return dto;
	}
}
