package com.jw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jw.BoardDTO.JWBoardDTO;
import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JWUpdateresultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bcategory = request.getParameter("bcategory");
		
		JWBoardDTO dto = new JWBoardDTO();
		dto.setBno(bno);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		dto.setBcategory(bcategory);
		
		JWBoardService service = JWBoardService.getBoardService();
		service.Update(dto);
		
		f.setUrl("JWdetail.do?bno="+bno);
		return f;
	}

}
