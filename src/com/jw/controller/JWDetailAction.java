package com.jw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jw.BoardDTO.JWBoardDTO;
import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JWDetailAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			ForwardAction f = new ForwardAction();
			f.setUrl("main.jsp?page=adboard/addetail.jsp");
			f.setForward(true);
			
			String bno = request.getParameter("bno");
			System.out.println("detailAction : "+bno);
			JWBoardService service = JWBoardService.getBoardService();
			JWBoardDTO dto = null;
			service.Uphit(bno);
			dto = service.Detail(bno);
			
			request.setAttribute("dto", dto);
		return f;
	}
}
