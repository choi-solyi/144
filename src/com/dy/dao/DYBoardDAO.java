package com.dy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dy.dto.DYBoardDTO;

public class DYBoardDAO {

	private static DYBoardDAO instance= new DYBoardDAO();
	public static DYBoardDAO getdao() {
		return instance;
	}
	private DYBoardDAO () {}

	public List<DYBoardDTO> dylist(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select         bno                                ");
		sql.append("               ,btitle                             ");
		sql.append("               ,bwritedate                         ");
		sql.append("               ,bcategory                          ");
		sql.append("               ,bhit                               ");
		sql.append("               ,u.nick                             ");
		sql.append("               ,m.id                               ");
		sql.append(" from midboard as m join userinfo as u             ");
		sql.append(" on m.id = u.id                    ");
		
		List<DYBoardDTO> list = new ArrayList<DYBoardDTO>();
		
		try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			) 
		{
			
			while(rs.next())
			{
				DYBoardDTO dto = new DYBoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setNick(rs.getString("nick"));
				dto.setId(rs.getString("id"));
				
				list.add(dto);
				
			}
			
		}
		
		return list;
	}
	public void dyinsert(Connection conn, DYBoardDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into midboard ( btitle                 ");
		sql.append("                       ,bcontent               ");
		sql.append("                       ,bcategory              ");
		sql.append("                       ,bwritedate             ");
		sql.append("                       ,bhit                   ");
		sql.append("                       ,bup                    ");
		sql.append("                       ,bimg                   ");
		sql.append("                       ,id )                   ");
		sql.append(" values ( ?, ?, ?, now(), 0, 0, 'null', 'planet') ");
	
		
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3,  dto.getBcategory());
			//pstmt.setString(3, 'img°æ·Î');
			
			pstmt.executeUpdate();
			
		}
		
	}
	public DYBoardDTO dydetail(Connection conn, int bno) throws SQLException {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select u.nick                               ");
		sql.append("       ,bcategory                            ");
		sql.append("       ,btitle                               ");
		sql.append("       ,bhit                                 ");
		sql.append("       ,bcontent                             ");
		sql.append(" from midboard as m join userinfo as u       ");
		sql.append(" on m.id = u.id                              ");
		sql.append(" where bno = ?                               ");
		
		ResultSet rs =null;
		DYBoardDTO dto = new DYBoardDTO();
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
				pstmt.setInt(1, bno);
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					dto.setNick(rs.getString("u.nick"));
					dto.setBcategory(rs.getString("bcategory"));
					dto.setBtitle(rs.getString("btitle"));
					dto.setBhit(rs.getInt("bhit")+1);
					dto.setBcontent(rs.getString("bcontent"));
					
				}
			
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
		}
		
		return dto;
	}
	public void dydelete(Connection conn, int bno) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from midboard     ");
		sql.append(" where bno = ?            ");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) 
		{
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();	
		}
	}
	
	
	
}
