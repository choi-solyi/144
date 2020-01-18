package com.sy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.service.JGBoardService;

public class SYDelRepAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		int repno = Integer.parseInt(request.getParameter("repno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		JGBoardService service = JGBoardService.getService();
		service.delrep(repno);
		System.out.println("111111111111111111111111"+repno);
		System.out.println("111111111111111111111111"+bno);
		
		ForwardAction f= new ForwardAction();
		f.setForward(false);
		f.setUrl("jgdetail.do?bno="+bno);
		
	/*	f.setForward(true);
		f.setUrl("main.jsp?page=jg_board/jgdetail.jsp?bno="+bno);
*/
		return f;
	}

}
