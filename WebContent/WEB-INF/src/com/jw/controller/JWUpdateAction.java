package com.jw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jw.BoardDTO.JWBoardDTO;
import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sun.xml.internal.bind.v2.TODO;

public class JWUpdateAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("main.jsp?page=adboard/adupdate.jsp");
		
		String bno = request.getParameter("bno");
		JWBoardService service = JWBoardService.getBoardService();
		JWBoardDTO dto = service.Detail(bno);
		
		request.setAttribute("dto", dto);
		
		return f;
	}
}
