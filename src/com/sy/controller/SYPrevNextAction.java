package com.sy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.dto.JGBoardDTO;
import com.sy.service.JGBoardService;

public class SYPrevNextAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bno = Integer.parseInt(request.getParameter("bno"));
		
		JGBoardService service = JGBoardService.getService();
		JGBoardDTO[] arr = new JGBoardDTO[2];
		arr = service.prev(bno);
		
		
		System.out.println(arr + "action arr");
		ForwardAction f = new ForwardAction();
		
		
		request.setAttribute("arr", arr);
/*		
		f.setForward(false);
		f.setUrl("jgdetail.do");*/
		
		f.setForward(true);
		
		f.setUrl("main.jsp?page=jg_board/jgdetail.jsp");

		
		return f;
	}

}
