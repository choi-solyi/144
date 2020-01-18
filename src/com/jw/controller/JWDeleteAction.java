package com.jw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JWDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("list.do");
		
		JWBoardService service = JWBoardService.getBoardService();
		
		
		return f;
	}

}
