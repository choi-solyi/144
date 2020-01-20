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
}
