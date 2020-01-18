package com.jw.BoardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jw.BoardDTO.JWBoardDTO;

public class JWBoardDAO {
	private static JWBoardDAO dao = new JWBoardDAO();
	static public JWBoardDAO getBoardDAO() {
		return dao;
	}
	private JWBoardDAO() {}
	
	public List<JWBoardDTO> List(Connection conn) throws SQLException{	
		List<JWBoardDTO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		sql.append(" select * from adboard ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				JWBoardDTO dto = new JWBoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setBup(rs.getInt("bup"));
				dto.setBimg(rs.getString("bimg"));
				dto.setId(rs.getString("id"));
				list.add(dto);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public void Insert(Connection conn, JWBoardDTO dto) throws SQLException 
	{	StringBuilder sql = new StringBuilder();
		sql.append(" insert into adboard     ");
		sql.append(" values(null, ?, ?       ");
		sql.append("        , now(), ?, 0    ");
		sql.append("        , 0, ?,'master') ");
			try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
				pstmt.setString(1, dto.getBtitle());
				pstmt.setString(2, dto.getBcontent());
				pstmt.setString(3, dto.getBcategory());
				pstmt.setString(4, dto.getBimg());
				pstmt.executeUpdate();
			}
	};
}
