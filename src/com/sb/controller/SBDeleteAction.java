package com.sb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sb.service.SUPBoardService;

public class SBDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bno= Integer.parseInt(request.getParameter("bno"));
		
		
		SUPBoardService service = SUPBoardService.sbGetBoardService();
		service.sbDelete(bno);
		
		
		
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("sblist.do");
		return f;
	}
	
	
	
	
	
}
