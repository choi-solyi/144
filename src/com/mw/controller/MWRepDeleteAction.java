package com.mw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.mw.service.MWBoardService;

public class MWRepDeleteAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int repno = Integer.parseInt(request.getParameter("repno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		MWBoardService service = MWBoardService.getService();
		service.repDelete(repno, bno);
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("/main.jsp?page=topboard/topdetail.do?no="+bno);
		
		return f;
	}

}
