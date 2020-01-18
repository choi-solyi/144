package com.sb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

import com.sb.dto.SUPRepBoardDTO;
import com.sb.service.SUPBoardService;

public class SBAddRepAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		String rcontent = request.getParameter("rcontent");
		String id = request.getParameter("id");
		
		SUPRepBoardDTO rdto = new SUPRepBoardDTO();
		
		rdto.setBno(bno);
		rdto.setRcontent(rcontent);
		rdto.setId(id);
		
		
		
		SUPBoardService service = SUPBoardService.sbGetBoardService();
		
		service.sbRepAdd(rdto);
		
		ForwardAction f = new ForwardAction();
		
		f.setForward(false);
		f.setUrl("sbdetail.do?bno="+bno);
		
		return f;
	}
	
	
	
}
