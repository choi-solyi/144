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
import com.sy.dto.MDDTO;
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
		sql.append(" values(null, ?, ?,	?, 	now(), 0, ?) ");
		//조회수-제목-내용-날짜-카테고리-댓글수,조회수
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBcategory());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getId());

			pstmt.executeUpdate();		

		}finally {
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}

		}
	}
	//상세보기
	public JGBoardDTO detail(Connection conn, int bno) throws SQLException {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select bno, bcategory, btitle, bcontent, bwritedate, bhit, jb.id, us.nick  	");
		sql.append(" from jgboard as jb join userinfo as us on jb.id = us.id			");
		sql.append(" where bno = ? 														");
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
				dto.setId(rs.getString("id"));
				dto.setNick(rs.getString("nick"));
				
				
			}
			System.out.println("dto-detail-test : " + dto.getBcontent());
			

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
		sql.append(" values(NULL, ?, now(), ?, ?) ");

		try {
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, rdto.getRcontent());
			pstmt.setInt(2, bno);
			pstmt.setString(3, rdto.getId());
			
			pstmt.executeUpdate();
			
		}finally {
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}
		}
	}
	//댓글 리스트 보기
	public List<JGRepBoardDTO> ListRep(Connection conn, int bno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select repno, rcontent, rwritedate, bno, jr.id, us.nick 	 ");
		sql.append(" from jgrepboard as jr join userinfo as us	on jr.id = us.id					 ");
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
				dto.setNick(rs.getString("nick"));
		
				list.add(dto);
			}
			
		}finally {
			if( rs!=null ) try { rs.close(); } catch(SQLException e) {}

		}
		return list;

	}
	public int getTotalCount(Connection conn, String search) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) from jgboard ");
		
		if(!search.equals("")) {
			sql.append("  where btitle like ? or bcontent like ?  ");
		}
		
		int totalCount = 0;
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			if(!search.equals("")) {
				pstmt.setString(1, search);
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}
		return totalCount;
	}
	
	
	
	public List<JGBoardDTO> list(Connection conn, int startRow, int endRow, String search) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select bno, btitle, bcontent, bwritedate, bcategory, bhit, jb.id, us.nick 	");
		sql.append(" from jgboard as jb join userinfo as us on jb.id = us.id					");
		
		if(!search.equals("")) {
			sql.append("  where btitle like ? or bcontent like ?  ");
		}
			
		sql.append(" order by bno desc  limit ? , 10												");

		ResultSet rs = null;
		List<JGBoardDTO> list = new ArrayList<>();
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				) {
		
			if(!search.equals("")) {
				pstmt.setString(1, "%"+search+"%");
				pstmt.setString(2, "%"+search+"%");
				pstmt.setInt(3, startRow-1);

			}else {
				pstmt.setInt(1, startRow-1);
				
			}
			
	
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
				dto.setNick(rs.getString("nick"));
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
/*	public int login(Connection conn, String id, String pw) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select pw,line			");
		sql.append(" from userinfo 			");
		sql.append(" where id = ?			");
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			
			rs = pstmt.executeQuery();
			if(rs.next()) { //값이 있다면
				System.out.println("값이 있습니다");
				System.out.println(rs.getString(2));
				System.out.println("2번째 값입니다.");
				
				String line = rs.getString(2);
				
				if(rs.getString(1).equals(pw)) { //값이 있고 비밀번호가 있다면
					System.out.println("비밀번호가 일치 합니다.");
					if(line.equals("top")) {
						System.out.println("탑입니다");
						return 1;
					}else if(line.equals("jg")) {
						System.out.println("정글입니다.");
						return 2;
					}else if(line.equals("mid")) {
						System.out.println("미드입니다.");
						return 3;
					}else if(line.equals("ad")) {
						System.out.println("원딜입니다.");
						return 4;
					}else if(line.equals("sup")) {
						System.out.println("서폿입니다");
						return 5;
					}else if(line.equals("cal")) {
						System.out.println("캘린더입니다");
						return 6;
					}		
			}
			}else {
				return 0;
			}
			
		}finally {
			if( rs!=null ) try { rs.close(); } catch(SQLException e) {}
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}

		}
		return -2;
	}*/
	public MDDTO getMdDetail(Connection conn, int mdcode) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select mdcode, mdname, price, img ");
		sql.append(" from md where mdcode= ? ");
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MDDTO mddto = new MDDTO();
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, mdcode);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mddto.setMdcode(rs.getInt("mdcode"));
				mddto.setMdname(rs.getString("mdname"));
				mddto.setPrice(rs.getInt("price"));
				mddto.setImg(rs.getString("img"));
			}
		}finally {
			if( rs!=null ) try { rs.close(); } catch(SQLException e) {}
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}
		}
		
		return mddto;
	}
	public JGBoardDTO  prev(Connection conn, int bno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select bno, btitle, us.nick, bhit from jgboard as jg join userinfo as us on jg.id = us.id  ");
		sql.append(" where bno = ( select max(bno) from jgboard where bno < ? ) ");
		
/*		sql.append(" select bno, btitle, us.nick, bhit from jgboard as jg join userinfo as us ");
		sql.append(" where bno in ( (select bno from jgboard where bno < ? order by bno desc limit 1), ");
		sql.append(" (select bno from jgboard where bno > ? order by bno limit 1)) ");*/
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		JGBoardDTO dto = new JGBoardDTO();
				
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bno);
			System.out.println("원래 bno값"+bno);
			rs = pstmt.executeQuery();
			System.out.println("rs::::::::::::::" + rs);
			
			if(rs.next()) {
				
				System.out.println("바뀐 bno 값" + rs.getInt("bno"));
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setNick(rs.getString("nick"));
				dto.setBhit(rs.getInt("bhit"));
				
				System.out.println(rs.getInt("bno"));
				System.out.println(rs.getString("btitle"));
			}
		}finally {
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}

		}
		
		return dto;
	}
	public JGBoardDTO next(Connection conn, int bno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select bno, btitle, us.nick, bhit from jgboard as jg join userinfo as us on jg.id = us.id ");
		sql.append(" where bno = ( select min(bno) from jgboard where bno > ? )");
		
/*		sql.append(" select bno, btitle, us.nick, bhit from jgboard as jg join userinfo as us ");
		sql.append(" where bno in ( (select bno from jgboard where bno < ? order by bno desc limit 1), ");
		sql.append(" (select bno from jgboard where bno > ? order by bno limit 1)) ");*/
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		JGBoardDTO dto = new JGBoardDTO();
				
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			System.out.println("rs::::::::::::::" + rs);
			
			if(rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setNick(rs.getString("nick"));
				dto.setBhit(rs.getInt("bhit"));
				
				System.out.println(rs.getInt("bno"));
				System.out.println(rs.getString("btitle"));
			}
			System.out.println("--------------sdfafsadfsdfsdafasfdsf----------------");
		}finally {
			if( pstmt!=null ) try { pstmt.close(); } catch(SQLException e) {}

		}
		
		return dto;
	}
}
