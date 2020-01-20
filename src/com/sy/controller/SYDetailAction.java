package com.sy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.dto.JGBoardDTO;
import com.sy.service.JGBoardService;

public class SYDetailAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		JGBoardService service = JGBoardService.getService();
		JGBoardDTO dto = service.detail(bno);
		
		request.setAttribute("dto", dto);
		
		///////////
		JGBoardDTO predto = new JGBoardDTO();
		predto = service.prev(bno);
		System.out.println(predto + "action predto");
		request.setAttribute("predto", predto);
		
		/////////////
		JGBoardDTO nexdto = new JGBoardDTO();
		nexdto = service.next(bno);
		System.out.println(nexdto + "action nexdto");
				
		request.setAttribute("nexdto", nexdto);
		
		///////////
		
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		
		f.setUrl("main.jsp?page=jg_board/jgdetail.jsp");

		return f;
	}

}
