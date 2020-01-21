package com.dy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.dto.DYRepBoardDTO;
import com.dy.service.DYBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class DYAddRepAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bno =Integer.parseInt(request.getParameter("bno"));
		String id = request.getParameter("repwriter");
		String rcontent = request.getParameter("repcontent");
		
		DYRepBoardDTO dto = new DYRepBoardDTO();
		
		dto.setBno(bno);
		dto.setId(id);
		dto.setRcontent(rcontent);
		
		DYBoardService service = DYBoardService.getservice();
		service.dyrepinsert(dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("dydetail.do?bno="+bno);
		
		return forward;
	}

}
