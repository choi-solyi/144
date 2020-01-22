package com.eb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eb.dto.CalSubBoardDTO;
import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class EBAddRepAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		String rcontent=request.getParameter("rcontent");
		CalSubBoardDTO dto=new CalSubBoardDTO();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		dto.setId(id);
		dto.setBno(bno);
		dto.setRcontent(rcontent);
		CalBoardService service=CalBoardService.getService();
		service.AddRep(dto);
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("EBdetail.do?bno="+bno);
		return f;
		
	
	}

}
