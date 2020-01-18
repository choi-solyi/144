package com.eb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.CalBoardDAO;
import com.eb.dto.CalBoardDTO;
import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class EBListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; chartset=utf-8");

		CalBoardService service=CalBoardService.getService();
		List<CalBoardDTO> list=service.list();
		
		request.setAttribute("list", list);
	
		ForwardAction forward=new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/main.jsp?page=calBoard/CALList.jsp");
	
		return forward;
	}

}
