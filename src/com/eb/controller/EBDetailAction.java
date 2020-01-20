package com.eb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dto.CalBoardDTO;
import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class EBDetailAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String n=request.getParameter("bno");
		int bno=1;
		
		if(n!=null && !n.equals(""))
			bno=Integer.parseInt(n);
		
		
		CalBoardService service=CalBoardService.getService();
		service.uphit(bno);
		CalBoardDTO dto=service.detail(bno);
		request.setAttribute("dto", dto);
		
		ForwardAction forward=new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/main.jsp?page=calBoard/CALDetail.jsp");
		
		return forward;
	}

}
