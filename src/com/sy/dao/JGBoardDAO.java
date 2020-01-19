package com.sy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.sy.dto.JGBoardDTO;
import com.sy.dto.JGRepBoardDTO;
import com.user.comm.UserDTO;

public class JGBoardDAO {
	private static JGBoardDAO dao = new JGBoardDAO();
	public static JGBoardDAO getDAO(){
		return dao;
	}
	private JGBoardDAO() {}



	// 목록보기ddddddddddddddddddddddddddddddddddddddddd
/*	public List<JGBoardDTO> list(Connection conn, int startRow, int endRow, String search) throws SQLException {

		System.out.println("test dao");

		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		<!-- 글번호-카테-제목[count]-닉네임-작성일-조회수 -->

		sql.append(" select bno, bcategory, btitle, bwritedate, bhit ");
		sql.append(" from jgboard 													  ");
		sql.append(" order by bno desc ");
		if(!search.equals("")) {
			sql.append(" where concat(btitle, bcontent) regexp #?#");
			
		}

		List<JGBoardDTO> list = new ArrayList<JGBoardDTO>();
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql.toString());
			
			if(!search.equals("")) {
				pstmt.setString(1, search);
			}

			
			
			rs = pstmt.executeQuery();

			System.out.println("pstmt : " + pstmt);
			System.out.println("rs : " + rs);

			while(rs.next()) {
				JGBoardDTO dto = new JGBoardDTO();
				//글번호-카테-제목[count]-닉네임-작성일-조회수
				dto.setBno(rs.getInt("bno"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBhit(rs.getInt("bhit"));

				System.out.println("dto + title" + dto.getBtitle());
				list.add(dto);
				System.out.println("dto" + dto);
			}
		}finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
		}
		return list;
	}*/
	//글쓰기
	public void insert(Connection conn, JGBoardDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		sql.append(" insert into jgboard(bno, bcategory, btitle, bcontent, bwritedate, 	bhit, id) ");
		sql.append(" values(null, ?, ?,	?, 	now(), 0, 'challenger') ");
		//조회수-제목-내용-날짜-카테고리-댓글수,조회수
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBcategory());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());

			pstmt.executeUpdate();		

		}finally {
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}

		}
	}
	//상세보기
	public JGBoardDTO detail(Connection conn, int bno) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select bno, bcategory, btitle, bcontent, bwritedate, bhit, id  				");
		sql.append(" from jgboard																	");
		sql.append(" where bno = ? 																	");
		ResultSet rs =null;

		JGBoardDTO dto = new JGBoardDTO();

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBhit(rs.getInt("bhit"));
				
				
			}
			System.out.println("dto-detail-tes : t" + dto.getBcontent());
			

		}finally {
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}
		}

		return dto;
	}
	//수정
	public void update(Connection conn, int bno, JGBoardDTO dto)  throws SQLException  {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		sql.append(" update jgboard									");
		sql.append(" set bcategory = ? , btitle = ? , bcontent = ?  ");
		sql.append(" where bno = ? 									");

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBcategory());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setInt(4, bno);

			pstmt.executeUpdate();

		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
	}
	//삭제
	public void delete(Connection conn, int bno) throws SQLException {
		PreparedStatement  pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from jgboard  ");
		sql.append(" where bno = ? ");

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bno);

			pstmt.executeUpdate();

		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
	}
	//조회수 증가
	public void upHit(Connection conn, int bno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" update jgboard ");
		sql.append(" set bhit = IFNULL(bhit, 0) + 1 ");
		sql.append(" where bno = ? ");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		}
	}
	//댓글 추가
	public void addRep(Connection conn, int bno, JGRepBoardDTO rdto) throws SQLException {
		PreparedStatement pstmt=null;
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into jgrepboard(repno, rcontent, rwritedate, bno, id) ");
		sql.append(" values(NULL, ?, now(), ?, 'challenger') ");

		try {
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, rdto.getRcontent());
			pstmt.setInt(2, bno);
			
			pstmt.executeUpdate();
			
		}finally {
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}
		}
	}
	//댓글 리스트 보기
	public List<JGRepBoardDTO> ListRep(Connection conn, int bno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select repno, rcontent, rwritedate, bno, id	 ");
		sql.append(" from jgrepboard						 ");
		sql.append(" where bno = ?					 ");
		sql.append(" order by repno desc ");
		ResultSet rs=  null;
		List<JGRepBoardDTO> list = new ArrayList<>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JGRepBoardDTO dto = new JGRepBoardDTO();
				
				dto.setRepno(rs.getInt("repno"));
				dto.setRcontent(rs.getString("rcontent"));
				dto.setRwritedate(rs.getString("rwritedate"));
				dto.setBno(bno);
				dto.setId(rs.getString("id"));
		
				list.add(dto);
			}
			
		}finally {
			if( rs!=null ) try { rs.close(); } catch(SQLException e) {}

		}
		return list;

	}
	public int getTotalCount(Connection conn, String search) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) from jgboard ");/*
		sql.append(" where concat(btitle, bcontent) regexp #?# ");*/
		int totalCount = 0;
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
	/*		if(!search.equals("")) {
				pstmt.setString(1, search);
			}
	*/		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}
		return totalCount;
	}
	
	
	
	public List<JGBoardDTO> list(Connection conn, int startRow, int endRow, String search) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from jgboard   ");
		
		sql.append("  order by bno desc  limit ? , ?");

		ResultSet rs = null;
		List<JGBoardDTO> list = new ArrayList<>();
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				) {
		
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, 10);
	
			rs = pstmt.executeQuery();
			System.out.println("rs" + rs);
			while(rs.next()) {
				JGBoardDTO dto = new JGBoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setId(rs.getString("id"));
				list.add(dto);
				
				System.out.println("dao-bno: "+ rs.getInt("bno"));
				System.out.println("dao-btitle: "+ rs.getString("btitle"));
			}
		
		}finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
		}
		return list;
	}
	public void delRep(Connection conn, int repno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from jgrepboard ");
		sql.append(" where repno=? 	");
		
		PreparedStatement pstmt = null;
		System.out.println("3333333333333333333333"+repno);

			try {
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, repno);
				

			int r=	pstmt.executeUpdate();
			System.out.println("r==="+r);
			}finally {
				if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}

			
		}
		
	}
	public int login(Connection conn, String id, String pw) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select pw			 	");
		sql.append(" from userinfo 			");
		sql.append(" where id = ?			");
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rs.getString(1).equals(pw);
				return 1;
			}else {
				return 0;
			}
			
		}finally {
			if( rs!=null ) try { rs.close(); } catch(SQLException e) {}
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}

		}
	}
}
