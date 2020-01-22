package com.dy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.service.DYBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class DYRepDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int repno = Integer.parseInt(request.getParameter("repno"));
		
		DYBoardService service = DYBoardService.getservice();
		service.dyrepdelete(repno);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("dydetail.do");
		
		return forward;
	}

}
