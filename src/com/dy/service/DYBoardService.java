package com.dy.service;

import java.sql.Connection;
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
	
	
}
