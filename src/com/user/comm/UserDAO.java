package com.user.comm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private static UserDAO dao = new UserDAO();
	public static UserDAO getDAO() {
		return dao;
	}
	private UserDAO() {};




	public int login(Connection conn, String id, String pw) throws SQLException {
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
				System.out.println(pw);
				System.out.println(rs.getString(1));
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
	}
	public void join(Connection conn, UserDTO dto) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into userinfo(id, nick, name, pw, salt, line, tel) values ");
		sql.append("                     (?, ?, ?, ?, ?, ?, ?)                        ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getNick());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPw());
			pstmt.setString(5, dto.getSalt());
			pstmt.setString(6, dto.getLine());
			pstmt.setString(7, dto.getTel());
			pstmt.executeUpdate();
		}
	}
	
	public String getSalt(Connection conn, String id) throws SQLException{
		String salt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select salt from userinfo where id = ? ");
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			salt = rs.getString(1);
		}
		return salt;
	}
	public UserDTO userinfo(Connection conn, String ssid) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select id, nick, name, line, tel, cp ");
		sql.append(" from userinfo ");
		sql.append(" where id = ? ");
		ResultSet rs = null;
		
		UserDTO dto = new UserDTO();
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, ssid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String ddd = rs.getString("id");
				System.out.println(ddd);
				
				dto.setId(ddd);
				dto.setName(rs.getString("name"));
				dto.setNick(rs.getString("nick"));
				dto.setLine(rs.getString("line"));
				dto.setTel(rs.getString("tel"));
				dto.setCp(rs.getInt("cp"));
				

				System.out.println("get mypage 3333");
				System.out.println(ssid);
				System.out.println("get mypage 4444");
				
			}
		}finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
		}
		return dto;
	}
	public void payment(Connection conn, String id, int price) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" update userinfo ");
		sql.append(" set cp = cp - ?  ");
		sql.append(" where id = ? ");
		
		
		UserDTO dto = new UserDTO();
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setInt(1, price);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}
	}
}
