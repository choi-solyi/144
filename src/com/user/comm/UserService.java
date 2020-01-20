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
	}
}
