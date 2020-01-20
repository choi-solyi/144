package com.mw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.mw.service.MWBoardService;

public class MWDelete implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		MWBoardService service = MWBoardService.getService();
		service.mwDelete(no);
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("toplist.do");
		
		return f;
	}

}
