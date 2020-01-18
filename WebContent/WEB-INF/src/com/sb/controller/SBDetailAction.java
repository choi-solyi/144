package com.sb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sb.dto.SUPBoardDTO;
import com.sb.service.SUPBoardService;

public class SBDetailAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bno= (Integer.parseInt(request.getParameter("bno")));
		
		SUPBoardService service= SUPBoardService.sbGetBoardService();
		SUPBoardDTO dto = new SUPBoardDTO();
		
	
		dto= service.sbDetail(bno);
		
		request.setAttribute("dto", dto);
		
		
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("main.jsp?page=supBoard/supdetail.jsp");
		
		
		return f;
	}
	
	
	
}
