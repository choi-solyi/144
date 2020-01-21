package com.eb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eb.dto.CalBoardDTO;
import com.eb.dto.CalSubBoardDTO;
import com.lol.comm.DBConn;

public class CalBoardDAO {

	private static CalBoardDAO dao = new CalBoardDAO();

	public static CalBoardDAO getCalBoardDAO() {
		return dao;
	}

	private CalBoardDAO() {
	};

	public List<CalBoardDTO> List(Connection conn, int startrow, int endrow, String search, String searchtxt)
			throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("   select            ");
		sql.append("          bno        ");
		sql.append("        , bcaldate   ");
		sql.append("        , btitle     ");
		sql.append("        , bhit       ");
		sql.append("        , bup        ");
		sql.append("   from calboard     ");
		if (!(search.equals("")) && !(searchtxt.equals(""))) {
			if (search.equals("btitle"))
				sql.append(" where btitle like ? ");
			else if (search.equals("bcontent"))
				sql.append(" where bcontent like ? ");
		}
		sql.append(" ORDER BY bno DESC   ");
		sql.append("   limit ?, ?        ");
		ResultSet rs = null;
		List<CalBoardDTO> list = new ArrayList<CalBoardDTO>();
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			if (!(search.equals("")) && !(searchtxt.equals(""))) {
				pstmt.setString(1, "%" + searchtxt + "%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			} else {
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CalBoardDTO dto = new CalBoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBcaldate(rs.getString("bcaldate"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setBup(rs.getInt("bup"));
				list.add(dto);
			}
		}
		return list;
	}

	public CalBoardDTO Detail(Connection conn, int bno) throws SQLException {
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select *                         ");
		sql.append(" from calboard b join userinfo u  ");
		sql.append(" on b.id = u.id                   ");
		sql.append(" where b.bno = ?                  ");
		CalBoardDTO dto = new CalBoardDTO();
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBcaldate(rs.getString("bcaldate"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setBup(rs.getInt("bup"));
				dto.setBimg(rs.getString("bimg"));
				dto.setId(rs.getString("id"));
				dto.setBcontent(rs.getString("bcontent"));
			}
		} finally {	if (rs != null) try {rs.close();} catch (SQLException e) {}
		}
		return dto;
	}

	public void Insert(Connection conn, CalBoardDTO dto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into calboard(         ");
		sql.append("                bno            ");
		sql.append("              , btitle         ");
		sql.append("              , bcaldate       ");
		sql.append("              , bcontent       ");
		sql.append("              , bimg           ");
		sql.append("              , bhit           ");
		sql.append("              , id)            ");
		sql.append("  values( null ,? ,? ,? ,? ,0 ,? )   ");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcaldate());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBimg());
			pstmt.setString(5, dto.getId());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				try {pstmt.close();} catch (SQLException e) {}
		}
	}

	public void Delete(Connection conn, int bno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("    delete from calboard      ");
		sql.append("    where bno = ?             ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		}
	}

	public void Update(Connection conn, CalBoardDTO dto) throws SQLException  {
		StringBuilder sql = new StringBuilder();
		sql.append(" update calboard set                ");
		sql.append("	       btitle = ?               ");
		sql.append("         , bcaldate = ?             ");
		sql.append("	     , bcontent = ?             ");
		sql.append("  where bno = ?                     ");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcaldate());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setInt(4, dto.getBno());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				try {pstmt.close();} catch (SQLException e) {}
		}
	}

	public int getTotalCount(Connection conn, String search, String searchtxt) throws SQLException {
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		sql.append(" select count(*) from calboard   ");
		if (!(search.equals("")) && !(searchtxt.equals(""))) {
			if (search.equals("btitle"))
				sql.append(" where btitle like ? ");
			else if (search.equals("bcontent"))
				sql.append(" where bcontent like ? ");
		}
		int totalcount = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			if (!(search.equals("")) && !(searchtxt.equals(""))) {
				pstmt.setString(1, "%" + searchtxt + "%");
			}
			rs = pstmt.executeQuery();
			rs.next();
			totalcount = rs.getInt(1);
		}
		return totalcount;
	}

	public void Uphit(Connection conn, int bno) throws SQLException{
		StringBuilder sql=new StringBuilder();
		sql.append(" update calboard set          ");
		sql.append("   bhit = bhit+1              ");
		sql.append("   where  bno=?               ");
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());){
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();		
		}
	}

	public List<CalSubBoardDTO> SubDetail(Connection conn, int bno) throws SQLException  {
		StringBuilder sql=new StringBuilder();
		List<CalSubBoardDTO> list=new ArrayList<>();
		System.out.println(bno);
		sql.append(" select * from  calrepboard c   ");
		sql.append(" join userinfo u                ");
		sql.append(" on c.id = u.id                 ");
		sql.append(" where bno = ?                  ");
		ResultSet rs=null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());){
			pstmt.setInt(1, bno);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				CalSubBoardDTO dto=new CalSubBoardDTO();
				dto.setRepno(rs.getInt("repno"));
				dto.setRcontent(rs.getString("rcontent"));
				dto.setRwritedate(rs.getString("rwritedate"));
				dto.setId(rs.getString("id"));
				dto.setBno(rs.getInt("bno"));
				list.add(dto);
			}
		}
		return list;
	}

	public void CalAddRep(Connection conn, CalSubBoardDTO dto) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" insert  into  calrepboard  (repno     ");
		sql.append("                          , rcontent   ");
		sql.append("                          , rwritedate ");
		sql.append("                          , bno        ");
		sql.append("                          , id)        ");
		sql.append(" values (null, ?, now() ,? ,? )        ");
		PreparedStatement pstmt = null;
		try {
		pstmt=conn.prepareStatement(sql.toString());
		pstmt.setString(1, dto.getRcontent());
		pstmt.setInt(2, dto.getBno());
		pstmt.setString(3, dto.getId());
		pstmt.executeUpdate();
		}finally {
			if (pstmt != null)
				try {pstmt.close();} catch (SQLException e) {}
		}
	}

	public void DelRep(Connection conn, int repno) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" delete from calrepboard ");
		sql.append(" where repno = ?           ");
		try (
		PreparedStatement pstmt=conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, repno);
			pstmt.executeUpdate();
		}
	}
}
