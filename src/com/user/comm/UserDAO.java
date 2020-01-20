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
			if(rs.next()) { //���� �ִٸ�
				System.out.println("���� �ֽ��ϴ�");
				System.out.println(rs.getString(2));
				System.out.println("2��° ���Դϴ�.");
				
				String line = rs.getString(2);
				
				if(rs.getString(1).equals(pw)) { //���� �ְ� ��й�ȣ�� �ִٸ�
					System.out.println("��й�ȣ�� ��ġ �մϴ�.");
					if(line.equals("top")) {
						System.out.println("ž�Դϴ�");
						return 1;
					}else if(line.equals("jg")) {
						System.out.println("�����Դϴ�.");
						return 2;
					}else if(line.equals("mid")) {
						System.out.println("�̵��Դϴ�.");
						return 3;
					}else if(line.equals("ad")) {
						System.out.println("�����Դϴ�.");
						return 4;
					}else if(line.equals("sup")) {
						System.out.println("�����Դϴ�");
						return 5;
					}else if(line.equals("cal")) {
						System.out.println("Ķ�����Դϴ�");
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
