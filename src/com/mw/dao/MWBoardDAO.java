package com.mw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mw.dto.MWBoardDTO;

public class MWBoardDAO {
	private static MWBoardDAO dao = new MWBoardDAO();
	private MWBoardDAO() {
		
	}
	public static MWBoardDAO getDAO() {
		
		return dao;
	}
	public List<MWBoardDTO> mwBoardSelect(Connection conn, String search, String searchtxt, int startrow, int endrow) throws SQLException {
		StringBuilder sql = new StringBuilder();
//		sql.append(" select r1.* from (                           ");
		sql.append(" select                                       ");
		sql.append("         bno                                  ");
		sql.append("        ,bcategory                            ");
		sql.append("        ,btitle                               ");
		sql.append("        ,id                                   ");
		sql.append("        ,bcontent                             ");
		sql.append("        ,bwritedate                           ");
		sql.append("        ,bhit                                 ");
		sql.append("        ,bup                                  ");
		sql.append("        from topboard                         ");
//		sql.append("        ) r1 limit 3 offset 0                  ");
		
		/*if(!(search.equals("")) && !(search.equals(""))) {
			if(search.equals("title")) {
				sql.append("  where btitle like = ? ");
			}
			else if(search.equals("id")) {
				sql.append("  where id like = ? ");
			}
			else if(search.equals("bcontent")) {
				sql.append("  where bcontent like = ? ");
			}
		}*/
		
		List<MWBoardDTO> list = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			) {
/*			pstmt.setInt(1, endrow);
			pstmt.setInt(2, startrow);*/
			System.out.println(startrow);
			System.out.println(endrow);
			/*if(!(search.equals("")) && !(searchtxt.equals(""))) {
				pstmt.setInt(1, endrow);
				pstmt.setInt(2, startrow-1);
				pstmt.setString(3, "%"+search+"%");
			}
			else {
				pstmt.setInt(1, endrow);
				pstmt.setInt(2, startrow-1);
			}*/
			
			while(rs.next()) {
				MWBoardDTO dto = new MWBoardDTO();
				
				dto.setBno(rs.getInt("bno"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setId(rs.getString("id"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setBup(rs.getInt("bup"));
				
				list.add(dto);
				
			}
			
		}
		return list;
	}
	public void mwInsert(Connection conn, MWBoardDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into topboard(                           ");
		sql.append("                    bcategory                    ");
		sql.append("                    ,btitle                      ");
		sql.append("                    ,id                          ");
		sql.append("                    ,bcontent                    ");
		sql.append("                    ,bwritedate                  ");
		sql.append("                    ,bhit                        ");
		sql.append("                    ,bup                         ");
		sql.append("  )                                              ");
		sql.append("    values ( ?, ?, ?, ?, sysdate(), 0, 0 )       ");
		
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBcategory());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getBcontent());
			System.out.println(dto.getBcategory());
			pstmt.executeUpdate();
		}
		finally {
			if(pstmt!=null) try{pstmt.close();} catch(SQLException e) {}
		}
		
	}
	public MWBoardDTO mwDetail(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select bno                                     ");
		sql.append("       ,id                                     ");
		sql.append("       ,bwritedate                                ");
		sql.append("       ,bhit                                      ");
		sql.append("       ,bup                                       ");
		sql.append("       ,bcategory                                 ");
		sql.append("       ,btitle                                    ");
		sql.append("       ,bcontent                                  ");
		sql.append("       from topboard                              ");
		sql.append("       where bno = ?                              ");
		
		ResultSet rs = null;
		MWBoardDTO dto = new MWBoardDTO();
		
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setId(rs.getString("id"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setBup(rs.getInt("bup"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
			}
		}
		finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(rs!=null) try { rs.close();} catch(SQLException e) {}
		}
		
		return dto;
	}
	public void mwUpdate(Connection conn, MWBoardDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" update topboard                              ");
		sql.append(" set                                          ");
		sql.append("           btitle = ?                        ");
		sql.append("          ,bcategory = ?                     ");
		sql.append("          ,id = ?                         ");
		sql.append("          ,bcontent = ?                      ");
		sql.append("           where bno = ?                     ");
		try{
			pstmt = conn.prepareStatement(sql.toString());
			
		}
		finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
	}
	public void mwDelete(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from topboard                ");
		sql.append(" where bno = ?                       ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
		finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		
	}
	public int mwCount(Connection conn, String search, String searchtxt) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql =  new StringBuilder();
		ResultSet rs = null;
		sql.append("  select count(*)                     ");
		sql.append("         from topboard                ");
		if(!(search.equals("")) && !(search.equals(""))) {
			if(search.equals("title")) {
				sql.append("  where btitle like = ? ");
			}
			else if(search.equals("id")) {
				sql.append("  where id like = ? ");
			}
			else if(search.equals("bcontent")) {
				sql.append("  where bcontent like = ? ");
			}
		}
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(!(search.equals("")) && !(searchtxt.equals(""))) {
				pstmt.setString(1, "%"+searchtxt+"%");
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);//첫번째 자료 받기
			}
		}
		finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {};
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
		}
		
		return count;
	}
	
	public void mwHit(Connection conn, int no) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("    update topboard                     ");
		sql.append("    set bhit = ifnull(bhit, 0)+1        ");
		sql.append("    where bno = ?                      ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	public void mwUp(Connection conn, int no) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("    update topboard                     ");
		sql.append("    set bup = ifnull(bup, 0)+1        ");
		sql.append("    where bno = ?                      ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
}
