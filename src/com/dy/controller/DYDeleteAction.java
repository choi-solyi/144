package com.dy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.service.DYBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class DYDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		DYBoardService service = DYBoardService.getservice();
		
		service.dydelete(bno);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("dylist.do");
		
		return forward;
	}

}
