package com.eb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.CalBoardDAO;
import com.eb.dto.CalBoardDTO;
import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class EBUpdateAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		
		CalBoardService service=CalBoardService.getService();
		CalBoardDTO dto=service.detail(bno);
		request.setAttribute("dto", dto);
		
		ForwardAction forward=new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/main.jsp?page=calBoard/CALUpdate.jsp");
		return forward;
	}

}
