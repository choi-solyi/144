package com.sb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sb.dto.SUPBoardDTO;
import com.sb.service.SUPBoardService;

public class SBListAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		SUPBoardService service = SUPBoardService.sbGetBoardService();
		List<SUPBoardDTO> list = service.sbList();
		
		request.setAttribute("list", list);
		
		
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("main.jsp?page=supBoard/list.jsp");
		
		return f;
	}
	
	
}
