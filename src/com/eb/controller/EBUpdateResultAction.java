package com.eb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.CalBoardDAO;
import com.eb.dto.CalBoardDTO;
import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class EBUpdateResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		String btitle=request.getParameter("btitle");
		String bcaldate=request.getParameter("bcaldate");
		String bcontent=request.getParameter("bcontent");
		
		CalBoardService serviece=CalBoardService.getService();
		CalBoardDTO dto=new CalBoardDTO();
		dto.setBno(bno);
		dto.setBtitle(btitle);
		dto.setBcaldate(bcaldate);
		dto.setBcontent(bcontent);
		serviece.update(dto);
		
		ForwardAction forward=new ForwardAction();
		forward.setForward(false);
		forward.setUrl("EBdetail.do?bno=${dto.bno}");
		return forward;
	}

}
