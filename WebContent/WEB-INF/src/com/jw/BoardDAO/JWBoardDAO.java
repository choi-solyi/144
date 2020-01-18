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

	public List<JWBoardDTO> List(Connection conn, int startrow, int endrow, String search, String searchtxt) throws SQLException
	{	
		List<JWBoardDTO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		sql.append(" select * from adboard ");
		if(!(search.equals(""))&&!(searchtxt.equals("")))
		{
			if(search.equals("btitle"))
				sql.append(" where btitle like ? ");
			else if(search.equals("bcontent"))
				sql.append(" where bcontent like ? ");
			else if(search.equals("id"))
				sql.append(" where id like ? ");
		}
		sql.append(" order by bno             ");
		sql.append(" limit ?, ?               ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			if(!(search.equals(""))&&!(searchtxt.equals("")))
			{
				pstmt.setString(1, "%"+searchtxt+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			}
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
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
	{	
		StringBuilder sql = new StringBuilder();
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
	}

	public JWBoardDTO Detail(Connection conn, String bno) throws SQLException
	{
		JWBoardDTO dto = new JWBoardDTO();
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		sql.append(" select * from adboard     ");
		sql.append("   where bno = ?           ");

		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setBup(rs.getInt("bup"));
				dto.setBimg(rs.getString("bimg"));
				dto.setId(rs.getString("id"));
			}
		}
		System.out.println(dto);
		return dto;
	}

	public void Delete(Connection conn, String bno) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from adboard    ");
		sql.append("      where bno = ?     ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, bno);
			pstmt.executeUpdate();
		}
	}

	public void Update(Connection conn, JWBoardDTO dto) throws SQLException
	{
		System.out.println(dto);
		StringBuilder sql = new StringBuilder();
		sql.append(" update adboard          ");
		sql.append("   set btitle    = ?     ");
		sql.append("      ,bcontent  = ?     ");
		sql.append("      ,bcategory = ?     ");
		sql.append("   where bno     = ?     ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBcategory());
			pstmt.setInt(4, dto.getBno());
			pstmt.executeUpdate();
		}
	}
	
	public int Totalcount(Connection conn, String search, String searchtxt) throws SQLException{
		int Totalcount = 0;
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		sql.append(" select count(*) from adboard     ");
		if(!(search.equals(""))&&!(searchtxt.equals("")))
		{
			if(search.equals("btitle"))
				sql.append(" where btitle like ? ");
			else if(search.equals("bcontent"))
				sql.append(" where bcontent like ? ");
			else if(search.equals("id"))
				sql.append(" where id like ? ");
		}
		//sql.append("   where bno = ?           ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			//pstmt.setString(1, bno);
			if(!(search.equals(""))&&!(searchtxt.equals("")))
			{
				pstmt.setString(1, "%"+searchtxt+"%");
			}
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Totalcount = rs.getInt(1);
			}
		}
		System.out.println(Totalcount);
		return Totalcount;
	};
}
