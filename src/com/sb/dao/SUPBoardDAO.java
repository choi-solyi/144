package com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sb.dto.SUPBoardDTO;
import com.sb.dto.SUPRepBoardDTO;

public class SUPBoardDAO {
	private static SUPBoardDAO instance = new SUPBoardDAO();
	
	private SUPBoardDAO() {
		
	}
	
	public static SUPBoardDAO sbGetBoardDAO() {
		return instance;
		
	}
	
	public List<SUPBoardDTO> sbList(Connection conn, int startrow, int endrow, String search, String txtsearch) throws SQLException{
		
		StringBuilder sql =new StringBuilder();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<SUPBoardDTO> list =new ArrayList<SUPBoardDTO>();
		sql.append(" select * from supboard ");
		if(!search.equals("") && !txtsearch.equals(""))
		{
		  if(search.equals("btitle"))
			 sql.append("                where btitle  like ?      ");
		  else if(search.equals("bcontent"))
			 sql.append("                where bcontent like ?       ");
		  else if(search.equals("id"))
			 sql.append("                where id like  ?       ");
		  
		}
		sql.append(" order by bno desc ");
		sql.append(" limit ?,10 ");
		
		
		
		try {
			
			pstmt= conn.prepareStatement(sql.toString());
			if(!search.equals("") && !txtsearch.equals("")) 
			{
				pstmt.setString(1, "%"+txtsearch+"%");
				pstmt.setInt(2, startrow-1);
				
			}
			else {
				
				pstmt.setInt(1, startrow-1);
			}
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				SUPBoardDTO dto = new SUPBoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
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

	public int sbGetCount(Connection conn, String search, String txtsearch) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select  count(*)        ");
		sql.append(" from  supboard             ");
		if(!search.equals("")  && !txtsearch.equals("") )
		{
			if(search.equals("btitle"))
				sql.append(" where btitle like    ?   ");
			else if(search.equals("bcontent"))
				sql.append(" where bcontent like  ?   ");
			else if(search.equals("id"))
				sql.append(" where id like   ?   ");
		}

		ResultSet rs=null;
		int count=0;
		try(
				PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				) {
			if(!search.equals("")&& !txtsearch.equals(""))
			{
				pstmt.setString(1, "%"+txtsearch+"%");    
			}
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}

		} finally {
			if(rs!=null) try { rs.close();} catch(SQLException e) {}
		}
		return count;
	}

	public void sbAddRep(Connection conn, SUPRepBoardDTO rdto) throws SQLException {
		
		StringBuilder sql= new StringBuilder();
		sql.append(" insert into suprepboard(repno,rcontent,id,rwritedate,bno) ");
		sql.append(" values(null,?,?,now(),?) ");
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, rdto.getRcontent());
			pstmt.setString(2, rdto.getId());
			pstmt.setInt(3, rdto.getBno());
			
			pstmt.executeUpdate();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		
	}

}
