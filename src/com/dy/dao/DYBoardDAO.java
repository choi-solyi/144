package com.dy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dy.dto.DYBoardDTO;

public class DYBoardDAO {

	private static DYBoardDAO instance= new DYBoardDAO();
	public static DYBoardDAO getdao() {
		return instance;
	}
	private DYBoardDAO () {}

	public List<DYBoardDTO> dylist(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select         bno                     ");
		sql.append("               ,btitle                  ");
		sql.append("               ,bwritedate              ");
		sql.append("               ,bcategory               ");
		sql.append("               ,bhit                    ");
		sql.append("               ,nick                    ");
		sql.append(" from midboard join userinfo            ");
		sql.append(" on midboard.id = userinfo.id           ");
		
		List<DYBoardDTO> list = new ArrayList<DYBoardDTO>();
		
		try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			) 
		{
			
			while(rs.next())
			{
				DYBoardDTO dto = new DYBoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBwritedate(rs.getString("bwritedate"));
				dto.setBcategory(rs.getString("bcategory"));
				dto.setBhit(rs.getInt("bhit"));
				dto.setNick(rs.getString("nick"));
				
				list.add(dto);
				
			}
			
		}
		
		return list;
	}
	
	
	
}
