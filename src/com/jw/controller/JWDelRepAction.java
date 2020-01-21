package com.jw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JWDelRepAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String repno = request.getParameter("repno");
		String bno = request.getParameter("bno");
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("JWdetail.do?bno="+bno);
		
		JWBoardService service = JWBoardService.getBoardService();
		
		service.adDelRep(repno);
		
		return f;
	}

}
