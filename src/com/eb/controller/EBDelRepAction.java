package com.eb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class EBDelRepAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		int repno=Integer.parseInt(request.getParameter("repno"));
		CalBoardService service=CalBoardService.getService();
		
		service.DelRep(repno);
		ForwardAction f=new ForwardAction();
		f.setForward(false);
		f.setUrl("EBdetail.do?bno="+bno);
		
		
		
		
		return f;
	}

}
