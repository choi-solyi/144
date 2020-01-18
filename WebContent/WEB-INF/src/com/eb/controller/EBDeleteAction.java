package com.eb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class EBDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		CalBoardService service=CalBoardService.getService();
		service.Delete(bno);

		ForwardAction forward=new ForwardAction();
		forward.setForward(false);
		forward.setUrl("EBlist.do");
		
		return forward;
	}

}
