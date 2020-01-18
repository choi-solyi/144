package com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sb.dto.SUPBoardDTO;

public class SUPBoardDAO {
	private static SUPBoardDAO instance = new SUPBoardDAO();
	
	private SUPBoardDAO() {
		
	}
	
	public static SUPBoardDAO sbGetBoardDAO() {
		return instance;
		
	}
	
	public List<SUPBoardDTO> sbList(Connection conn) throws SQLException{
		
		StringBuilder sql =new StringBuilder();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<SUPBoardDTO> list =new ArrayList<SUPBoardDTO>();
		sql.append(" select bno,bcategory,btitle,id,bwritedate,bhit ");
		sql.append(" from supboard ");
		sql.append(" order by bno desc ");
		
		try {
			pstmt= conn.prepareStatement(sql.toString());
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				SUPBoardDTO dto = new SUPBoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setId(rs.getString("id"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBhit(rs.getInt("bhit"));
			
				list.add(dto);
			}
			
			
		}finally{
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			
		}
		return list;
		
	}

	public void sbInsert(Connection conn, SUPBoardDTO dto) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		PreparedStatement pstmt = null;
		sql.append(" insert into supboard(bno,bcategory,btitle,bcontent,id,bwritedate,bimg,bhit) ");
		sql.append(" values( null,?,?,?,'general',now(),'aa.jpg',0 ) ");
		
		
		
		try {
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBcategory());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			
			
			pstmt.executeUpdate();
			
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		
		
	}

	public SUPBoardDTO sbDetail(Connection conn, int bno) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		sql.append(" select id,bwritedate,bhit,bcategory,btitle,bcontent,bimg,bno ");
		sql.append(" from supboard ");
		sql.append(" where bno=? ");
		SUPBoardDTO dto = new SUPBoardDTO();
		
		try {
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bno);
			
		 	rs=pstmt.executeQuery();
		 	
		 	if(rs.next()) {
		 		dto.setId(rs.getString("id"));
		 		dto.setBwritedate(rs.getString("bwritedate"));
		 		dto.setBhit(rs.getInt("bhit"));
		 		dto.setBcategory(rs.getString("bcategory"));
		 		dto.setBtitle(rs.getString("btitle"));
		 		dto.setBcontent(rs.getString("bcontent"));
		 		dto.setBimg(rs.getString("bimg"));
		 		dto.setBno(rs.getInt("bno"));
		 	}
			
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			
		}
		
		
		return dto;
	}

	public void sbDelete(Connection conn, int bno) throws SQLException {
		PreparedStatement pstmt=null;
		StringBuilder sql= new StringBuilder();
		sql.append(" delete from ");
		sql.append(" supboard ");
		sql.append(" where bno=? ");
		
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		
	}

	public void sbUpdate(Connection conn, SUPBoardDTO dto) throws SQLException{
		PreparedStatement pstmt =null;
		StringBuilder sql = new StringBuilder();
		sql.append(" update supboard set ");
		sql.append(" bcategory=?,btitle=?,bcontent=?,bimg=? ");
		sql.append(" where bno=? ");
		
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBcategory());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBimg());
			pstmt.setInt(5, dto.getBno());
			
			
			pstmt.executeUpdate();
			
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
	}
	public void sbUpHit(Connection conn, int bno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" update supboard ");
		sql.append(" set bhit = IFNULL(bhit, 0) + 1 ");
		sql.append(" where bno = ? ");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		}
	}
	
}
