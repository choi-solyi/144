package com.sy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.service.JGBoardService;

public class SearchAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sname = request.getParameter("summoner");
		
		
		JGBoardService service = JGBoardService.getService();
		service.history(sname);
		
		ForwardAction f = new ForwardAction();
		
		f.setForward(true);
		f.setUrl(url);
		return null;
	}

}
