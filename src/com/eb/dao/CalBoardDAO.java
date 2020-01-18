package com.eb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eb.dto.CalBoardDTO;

public class CalBoardDAO {

	private static CalBoardDAO dao = new CalBoardDAO();

	public static CalBoardDAO getCalBoardDAO() {
		return dao;
	}

	private CalBoardDAO() {};

	public List<CalBoardDTO> List(Connection conn) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("   select            ");
		sql.append("          bno        ");
		sql.append("        , bcaldate   ");
		sql.append("        , btitle     ");
		sql.append("        , bhit       ");
		sql.append("        , bup        ");
		sql.append("   from calboard     ");
		List<CalBoardDTO> list = new ArrayList<CalBoardDTO>();
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
			ResultSet rs = pstmt.executeQuery();
				) {
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
		sql.append(" select *              ");
		sql.append(" from calboard         ");
		sql.append(" where bno = ?         ");
		CalBoardDTO dto = new CalBoardDTO();
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 	
		) {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBcaldate(rs.getString("bcaldate"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setBup(rs.getInt("bup"));
			}
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return dto;
	}

	public void Insert(Connection conn, CalBoardDTO dto) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into calboard(         ");
		sql.append("                bno            ");
		sql.append("              , btitle         ");
		sql.append("              , bcaldate       ");
		sql.append("              , bcontent       ");
		sql.append("              , id)            ");
		sql.append("  values( null ,? ,? ,? ,? )   ");
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBcaldate());
			pstmt.setString(4, dto.getId());
			pstmt.executeUpdate();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
	}

}
