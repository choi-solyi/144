package com.dy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dy.dto.DYBoardDTO;
import com.dy.dto.DYRepBoardDTO;

public class DYBoardDAO {

	private static DYBoardDAO instance= new DYBoardDAO();
	public static DYBoardDAO getdao() {
		return instance;
	}
	private DYBoardDAO () {}

	public List<DYBoardDTO> dylist(Connection conn, int startrow, int endrow, String search, String txtsearch) throws SQLException {
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
		
		if(!search.equals("") && !(txtsearch.equals("")))
				{
					if(search.equals("btitle"))
						sql.append(" where btitle like ? ");
					else if(search.equals("bcontent"))
						sql.append(" where bcontent like ? ");
					else if(search.equals("nick"))
						sql.append(" where u.nick like ?  ");
				}
		sql.append(" order by bno desc ");
		sql.append(" limit ?, 5 ");
		
		List<DYBoardDTO> list = new ArrayList<DYBoardDTO>();
		
		
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try{
			pstmt= conn.prepareStatement(sql.toString());
			if(!search.equals("") && !txtsearch.equals(""))
			{
				pstmt.setString(1, "%" + txtsearch + "%");
				pstmt.setInt(2, startrow-1);
			}else {
				pstmt.setInt(1, startrow-1);
			}
			
			rs=pstmt.executeQuery();
			
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
			
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
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
		sql.append(" values ( ?, ?, ?, now(), 0, 0, 'null', ?)     ");
	
		
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3,  dto.getBcategory());
			pstmt.setString(4, dto.getId());
			//pstmt.setString(3, 'img���');
			
			pstmt.executeUpdate();
			
		}
		
	}
	public DYBoardDTO dydetail(Connection conn, int bno) throws SQLException {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select u.nick                                 ");
		sql.append("       ,bcategory                              ");
		sql.append("       ,btitle                                 ");
		sql.append("       ,bhit                                   ");
		sql.append("       ,bcontent                               ");
		sql.append("       ,m.id                                   ");
		sql.append("       ,bno                                    ");
		sql.append(" from midboard as m join userinfo as u         ");
		sql.append(" on m.id = u.id                                ");
		sql.append(" where bno = ?                                 ");
		
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
					dto.setBhit(rs.getInt("bhit"));
					dto.setBcontent(rs.getString("bcontent"));
					dto.setId(rs.getString("id"));
					dto.setBno(rs.getInt("bno"));
					
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
	public void dyhitup(Connection conn, int bno) throws SQLException {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append(" update midboard              ");
		sql.append(" set                          ");
		sql.append("     bhit = ifnull(bhit,0)+1  ");
		sql.append(" where bno = ?                ");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) 
		{
			pstmt.setInt(1,  bno);
			pstmt.executeUpdate();
			
		}
	}
	public void dyupdate(Connection conn, DYBoardDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" update midboard          ");
		sql.append(" set                      ");
		sql.append("        bcategory = ?     ");
		sql.append("       ,btitle = ?        ");
		sql.append("       ,bcontent = ?      ");
		sql.append("       ,bimg = ?          ");
		sql.append(" where bno = ?            ");
		
		
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setString(1, dto.getBcategory());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, "null");
			pstmt.setInt(5, dto.getBno());
			
			pstmt.executeUpdate();
			
		}
	}
	public int dygetCount(Connection conn, String search, String txtsearch) throws SQLException {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*)  ");
		sql.append(" from midboard as m join userinfo as u   ");
		sql.append(" on m.id = u.id                          ");
		
		
		if(!search.equals(" ") && !txtsearch.equals(" "))
		{
			if(search.equals("btitle"))
			{
				sql.append(" where btitle like ?        ");
			}else if(search.equals("bcontent"))
			{
				sql.append(" where bcontent like ?      ");
			}else if(search.equals("nick"))
			{
				sql.append(" where u.nick like ?        ");
			}
		}
		ResultSet rs =null;
		int totalcount =0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) 
		{
			if(!search.equals("") && !txtsearch.equals(""))
			{
				pstmt.setString(1, "%" + txtsearch + "%");
			}
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				totalcount = rs.getInt(1);
			}
			
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
		}
		
		return totalcount;
	}
	public void dyrepinsert(Connection conn,DYRepBoardDTO dto) throws SQLException{
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into midrepboard ( rcontent        ");
		sql.append("                          ,rwritedate      ");
		sql.append("                          ,bno             ");
		sql.append("                          ,id   )          ");
		sql.append(" values ( ?, now(), ?, ? )                 ");
		
		
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, dto.getRcontent());
			pstmt.setInt(2, dto.getBno());
			pstmt.setString(3, dto.getId());
			
			pstmt.executeUpdate();
		}
		
	}
	public List<DYRepBoardDTO> dyreplist(Connection conn, int bno) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement  pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select repno                               ");
		sql.append("       ,rcontent                            ");
		sql.append("       ,m.id                                  ");
		sql.append("       ,rwritedate                          ");
		sql.append("       ,bno                                 ");
		sql.append("       ,u.nick                                ");
		sql.append(" from midrepboard as m join userinfo as u   ");
		sql.append(" on m.id = u.id                             ");
		sql.append(" where bno = ?                              ");
		
		ResultSet rs=null;
		List<DYRepBoardDTO> list = new ArrayList<>();
		
		
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bno);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				DYRepBoardDTO dto = new DYRepBoardDTO();
				
				dto.setRepno(rs.getInt("repno"));
				dto.setRcontent(rs.getString("rcontent"));
				dto.setId(rs.getString("m.id"));
				dto.setRwritedate(rs.getString("rwritedate"));
				dto.setBno(rs.getInt("bno"));
				dto.setNick(rs.getString("u.nick"));
				
				list.add(dto);
			}
			
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		}
		
		return list;
	}
	public void dyrepdelete(Connection conn, int repno) throws SQLException {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from midrepboard ");
		sql.append(" where repno = ?         ");
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setInt(1, repno);
			pstmt.executeUpdate();
		}
		
	}
	
}
