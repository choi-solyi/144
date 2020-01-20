package com.jw.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;

import com.jw.BoardDAO.JWBoardDAO;
import com.jw.BoardDTO.JWBoardDTO;
import com.lol.comm.DBConn;

public class JWBoardService {
	private static JWBoardService service = new JWBoardService();
	private JWBoardService() {}
	static public JWBoardService getBoardService() {
		return service;
	}

	public List<JWBoardDTO> List(int startrow, int endrow, String search, String searchtxt) {
		DBConn DBC = DBConn.getDB();
		JWBoardDAO dao = JWBoardDAO.getBoardDAO();
		Connection conn = null; 
		List<JWBoardDTO> list = new ArrayList<>();
		try {
			conn = DBC.getConn();
			list = dao.List(conn, startrow, endrow, search, searchtxt);
		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {} 
		}
		return list;
	}

	public void Insert(JWBoardDTO dto) {
		DBConn DBC = DBConn.getDB();
		JWBoardDAO dao = JWBoardDAO.getBoardDAO();
		Connection conn = null; 
		try {
			conn = DBC.getConn();
			conn.setAutoCommit(false);
			dao.Insert(conn, dto);
			conn.commit();
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try{conn.rollback();} catch(SQLException rollback) {System.out.println(rollback);}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
	public JWBoardDTO Detail(String bno) {
		DBConn DBC = DBConn.getDB();
		JWBoardDTO dto = new JWBoardDTO();
		JWBoardDAO dao = JWBoardDAO.getBoardDAO();
		Connection conn = null;
		try {
			conn = DBC.getConn();
			conn.setAutoCommit(false);
			dto = dao.Detail(conn, bno);
			conn.commit();
		}catch(SQLException | NamingException e)
		{
			System.out.println(e);
			try{conn.rollback();} catch(SQLException rollback) {System.out.println(rollback);}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return dto;
	}
	public void Delete(String bno) {
		DBConn DBC = DBConn.getDB();
		JWBoardDAO dao = JWBoardDAO.getBoardDAO();
		Connection conn = null;
		try {
			conn = DBC.getConn();
			conn.setAutoCommit(false);
			dao.Delete(conn, bno);
			conn.commit();
		}catch(SQLException | NamingException e) 
		{
			System.out.println(e);
			try{conn.rollback();} catch(SQLException rollback) {System.out.println(rollback);}
		}finally {
			if(conn!=null) try{conn.close();} catch(SQLException e) {}
		}
	}
	public void Update(JWBoardDTO dto) {
		DBConn DBC = DBConn.getDB();
		JWBoardDAO dao = JWBoardDAO.getBoardDAO();
		Connection conn = null;
		try {
			conn = DBC.getConn();
			conn.setAutoCommit(false);
			dao.Update(conn, dto);
			conn.commit();
		}catch(SQLException | NamingException e) 
		{
			System.out.println(e);
			try{conn.rollback();} catch(SQLException rollback) {System.out.println(rollback);}
		}finally {
			if(conn!=null) try{conn.close();} catch(SQLException e) {}
		}
	}
	public int Totalcount(String search, String searchtxt) {
		int Totalcount = 0;
		DBConn DBC = DBConn.getDB();
		JWBoardDAO dao = JWBoardDAO.getBoardDAO();
		Connection conn = null;
		try {
			conn = DBC.getConn();
			Totalcount = dao.Totalcount(conn, search, searchtxt);
		}catch(SQLException | NamingException e) 
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try{conn.close();} catch(SQLException e) {}
		}
		return Totalcount;
	}
	public void Uphit(String bno) {
		DBConn DBC = DBConn.getDB();
		JWBoardDAO dao = JWBoardDAO.getBoardDAO();
		Connection conn = null;
		try {
			conn=DBC.getConn();
			conn.setAutoCommit(false);
			dao.Uphit(conn, bno);
			conn.commit();
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try{conn.rollback();}catch(SQLException rollback) {}
		}finally {
			if(conn!=null) try{conn.close();} catch(SQLException e) {}
		}
	}
}
