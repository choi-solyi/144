package com.mw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mw.dto.MWBoardDTO;
import com.mw.dto.MWRepBoardDTO;
import com.mw.dto.MWUpBoardDTO;
import com.mysql.cj.protocol.Resultset;

public class MWBoardDAO {
	private static MWBoardDAO dao = new MWBoardDAO();
	private MWBoardDAO() {
		
	}
	public static MWBoardDAO getDAO() {
		
		return dao;
	}
	public List<MWBoardDTO> mwBoardSelect(Connection conn, String search, String searchtxt, int startrow, int pagepercount) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select r1.* from (                           ");
		sql.append(" select                                       ");
		sql.append("         bno                                  ");
		sql.append("        ,bcategory                            ");
		sql.append("        ,btitle                               ");
		sql.append("        ,u.nick                               ");
		sql.append("        ,t.id                                 ");
		sql.append("        ,bcontent                             ");
		sql.append("        ,date_format(sysdate(), '%Y-%m-%d') as bwritedate    ");
		sql.append("        ,bhit                                 ");
		sql.append("        ,bup                                  ");
		sql.append("        from topboard as t join userinfo as u on t.id=u.id   ");
		if(!(search.equals("")) && !(search.equals(""))) {
			if(search.equals("btitle")) {
				sql.append("  where btitle like ? ");
			}
			else if(search.equals("nick")) {
				sql.append("  where u.nick like ? ");
			}
			else if(search.equals("bcontent")) {
				sql.append("  where bcontent like ? ");
			}
		}
		sql.append("        order by bno desc                     ");
		sql.append("        ) r1 limit ? offset ?                  ");
		System.out.println(startrow);
		System.out.println(pagepercount);
		List<MWBoardDTO> list = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			if(!(search.equals("")) && !(searchtxt.equals(""))) {
				pstmt.setString(1, "%"+searchtxt+"%");
				pstmt.setInt(2, pagepercount);
				pstmt.setInt(3, startrow);
				System.out.println("이상작동");
			}
			else {
				pstmt.setInt(1, pagepercount);
				pstmt.setInt(2, startrow);
				System.out.println("작동중");
			}
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MWBoardDTO dto = new MWBoardDTO();
				
				dto.setBno(rs.getInt("bno"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setId(rs.getString("id"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setBup(rs.getInt("bup"));
				dto.setNick(rs.getString("nick"));
				
				list.add(dto);
				
			}
			
		}
		return list;
	}
	
	public List<MWUpBoardDTO> mwBoardUpSelect(Connection conn) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select r1.* from (                           ");
		sql.append(" select                                       ");
		sql.append("         bno                                  ");
		sql.append("        ,bcategory                            ");
		sql.append("        ,btitle                               ");
		sql.append("        ,u.nick                               ");
		sql.append("        ,t.id                                 ");
		sql.append("        ,bcontent                             ");
		sql.append("        ,date_format(sysdate(), '%Y-%m-%d') as bwritedate    ");
		sql.append("        ,bhit                                 ");
		sql.append("        ,bup                                  ");
		sql.append("        from topboard as t join userinfo as u on t.id=u.id   ");
		sql.append("        where bup > 5                          ");
		sql.append("        order by bup desc                      ");
		sql.append("        ) r1 limit 3 offset 0                  ");
		List<MWUpBoardDTO> uplist = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MWUpBoardDTO dto = new MWUpBoardDTO();
				
				dto.setBno(rs.getInt("bno"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setId(rs.getString("id"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setBup(rs.getInt("bup"));
				dto.setNick(rs.getString("nick"));
				
				uplist.add(dto);
				
			}
			
		}
		return uplist;
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
		sql.append("       ,t.id                                      ");
		sql.append("       ,u.nick                                    ");
		sql.append("       ,bwritedate                                ");
		sql.append("       ,bhit                                      ");
		sql.append("       ,bup                                       ");
		sql.append("       ,bcategory                                 ");
		sql.append("       ,btitle                                    ");
		sql.append("       ,bcontent                                  ");
		sql.append("        from topboard as t join userinfo as u on t.id=u.id   ");
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
				dto.setNick(rs.getString("nick"));
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
		sql.append("          ,bcontent = ?                      ");
		sql.append("           where bno = ?                     ");
		try{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcategory());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setInt(4, dto.getBno());
			pstmt.executeUpdate();
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
			if(search.equals("btitle")) {
				sql.append("  where btitle like ? ");
			}
			else if(search.equals("id")) {
				sql.append("  where id like ? ");
			}
			else if(search.equals("bcontent")) {
				sql.append("  where bcontent like ? ");
			}
		}
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			if(!(search.equals("")) && !(search.equals(""))) {
				pstmt.setString(1, "%"+searchtxt+"%");
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
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
	public void addRep(Connection conn, MWRepBoardDTO rdto) throws SQLException{
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append("  insert into toprepboard(                            ");
		sql.append("                      rcontent                       ");
		sql.append("                      ,rwritedate                     ");
		sql.append("                      ,bno                            ");
		sql.append("                      ,id                             ");
		sql.append("     ) values( ?, sysdate(), ?, ? )                   ");
		
		try {
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, rdto.getRcontent());
			pstmt.setInt(2, rdto.getBno());
			pstmt.setString(3, rdto.getNick());
			
			pstmt.executeUpdate();
		}
		finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		
	}
	public List<MWRepBoardDTO> repDetailList(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		
		sql.append(" select                                              ");
		sql.append("            repno                                    ");
		sql.append("           ,rcontent                                 ");
		sql.append("           ,rwritedate                               ");
		sql.append("           ,bno                                      ");
		sql.append("           ,t.id                                     ");
		sql.append("           ,u.nick                                   ");
		sql.append("           from toprepboard as t join userinfo as u on t.id=u.id ");
		sql.append("           where bno =?                              ");
		sql.append("           order by repno asc                        ");
		
		List<MWRepBoardDTO> list= new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MWRepBoardDTO dto = new MWRepBoardDTO();
				dto.setRcontent(rs.getString("rcontent"));
				dto.setRwritedate(rs.getString("rwritedate"));
				dto.setBno(rs.getInt("bno"));
				dto.setNick(rs.getString("nick"));
				dto.setRepno(rs.getInt("repno"));
				dto.setId(rs.getString("id"));
				
				list.add(dto);
			}
			
		}
		finally {
			
		}
		return list;
	}
	public void repDelete(Connection conn, int repno, int bno) throws SQLException {
		
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		sql.append(" delete from toprepboard           ");
		sql.append(" where repno = ?                     ");
		System.out.println(repno+"하하하하하하");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, repno);
			pstmt.executeUpdate();
		}
		finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {};
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
		}
		
	}
	
}
