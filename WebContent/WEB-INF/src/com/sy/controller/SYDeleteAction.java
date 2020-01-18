package com.sy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.service.JGBoardService;

public class SYDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		int bno = Integer.parseInt(request.getParameter("bno"));
		
		JGBoardService service = JGBoardService.getService();
		service.delete(bno);
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("jglist.do");
		
		
		return f;
	}

}
