package com.mw.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.mw.dto.MWBoardDTO;
import com.mw.service.MWBoardService;

public class MWDetailAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		MWBoardService service = MWBoardService.getService();
		MWBoardDTO dto = service.mwDetail(no);
		request.setAttribute("dto", dto);
		
		ForwardAction f = new ForwardAction();
		
		f.setForward(true);
		f.setUrl("/main.jsp?page=topboard/topdetail.jsp");
		
		return f;
	}

}
