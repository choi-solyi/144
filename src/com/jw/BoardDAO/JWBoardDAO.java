package com.jw.BoardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jw.BoardDTO.JWBoardDTO;
import com.jw.BoardDTO.JWRepBoardDTO;

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
		sql.append(" select a.*, u.nick from adboard a ");
		sql.append(" join userinfo u on a.id = u.id    ");
		if(!(search.equals(""))&&!(searchtxt.equals("")))
		{
			if(search.equals("btitle"))
				sql.append(" where btitle like ? ");
			else if(search.equals("bcontent"))
				sql.append(" where bcontent like ? ");
			else if(search.equals("nick"))
				sql.append(" where nick like ? ");
		}
		sql.append(" order by bno desc        ");
		sql.append(" limit ?, ?               ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			if(!(search.equals(""))&&!(searchtxt.equals("")))
			{
				pstmt.setString(1, "%"+searchtxt+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			}else {
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			}
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
				dto.setNick(rs.getString("nick"));
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
		sql.append("        , 0, ?, ?) ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBcategory());
			pstmt.setString(4, dto.getBimg());
			pstmt.setString(5, dto.getId());
			pstmt.executeUpdate();
		}
	}

	public JWBoardDTO Detail(Connection conn, String bno) throws SQLException
	{
		JWBoardDTO dto = new JWBoardDTO();
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		sql.append(" select a.*, u.nick from adboard a ");
		sql.append(" join userinfo u on a.id = u.id    ");
		sql.append("   where bno = ?                   ");

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
				dto.setNick(rs.getString("nick"));
			}
		}
		System.out.println("Detail : "+dto);
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
		System.out.println("Update : "+dto);
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
		sql.append(" select count(*) from adboard a    ");
		sql.append(" join userinfo u on a.id = u.id    ");
		if(!(search.equals(""))&&!(searchtxt.equals("")))
		{
			if(search.equals("btitle"))
				sql.append(" where btitle like ? ");
			else if(search.equals("bcontent"))
				sql.append(" where bcontent like ? ");
			else if(search.equals("nick"))
				sql.append(" where nick like ? ");
		}
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
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
		System.out.println("Totalcount : "+Totalcount);
		return Totalcount;
	}
	
	public void Uphit(Connection conn, String bno) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append(" update adboard                    ");
		sql.append("   set   bhit = bhit+1             ");
		sql.append("   where bno  = ?                  ");
			try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
				pstmt.setInt(1, Integer.parseInt(bno));
				pstmt.executeUpdate();
			}
	}
	
	public List<JWRepBoardDTO> adListRep(Connection conn, String bno) throws SQLException{
		List<JWRepBoardDTO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		sql.append(" select r.*, u.nick from adrepboard r ");
		sql.append(" join userinfo u on r.id = u.id       ");
		sql.append(" where bno = ?                        ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				JWRepBoardDTO dto = new JWRepBoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setId(rs.getString("id"));
				dto.setNick(rs.getString("nick"));
				dto.setRcontent(rs.getString("rcontent"));
				dto.setRepno(rs.getInt("repno"));
				dto.setRwritedate(rs.getString("rwritedate"));
				list.add(dto);
				System.out.println("listRep : "+dto);
			}
		}
		return list;
	}
	
	public void adAddRep(Connection conn, JWRepBoardDTO dto) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into adrepboard values(      ");
		sql.append("   null, ?, now(), ?, ?        )     ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, dto.getRcontent());
			pstmt.setInt(2, dto.getBno());
			pstmt.setString(3, dto.getId());
			pstmt.executeUpdate();
		}
	}
	public void adDelRep(Connection conn, String repno) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from adrepboard             ");
		sql.append("   where repno   =  ?               ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, repno);
			pstmt.executeUpdate();
		}
	}
	public void adUpRep(Connection conn, String bno) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append(" update adboard set bup = bup+1     ");
		sql.append("   where bno     =  ?               ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, bno);
			pstmt.executeUpdate();
		}
	}
	
	public List<JWBoardDTO> repcount(Connection conn, List<JWBoardDTO> list, int startrow,
			int endrow, String search, String searchtxt) {
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		
		sql.append(" select count(r.bno) from adrepboard r          ");
		sql.append(" right join adboard b on r.bno = b.bno          ");
		if(!(search.equals(""))&&!(searchtxt.equals("")))
		{
			if(search.equals("btitle"))
				sql.append(" where btitle like ? ");
			else if(search.equals("bcontent"))
				sql.append(" where bcontent like ? ");
			else if(search.equals("id"))
				sql.append(" where id like ? ");
		}
		sql.append(" group by b.bno             ");
		sql.append(" order by b.bno desc        ");
		sql.append(" limit ?, ?               ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			if(!(search.equals(""))&&!(searchtxt.equals("")))
			{
				pstmt.setString(1, "%"+searchtxt+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			}else {
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			}
			rs = pstmt.executeQuery();

			for(JWBoardDTO index : list)
			{
				rs.next();
				index.setRepcount(rs.getInt(1));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}finally { 
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		System.out.println(list);
		return list;
	};
}
