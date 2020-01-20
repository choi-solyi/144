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

public class SYNextAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println(bno +"bno!!!!!!!!!!!");
		
		JGBoardService service = JGBoardService.getService();
		JGBoardDTO nexdto = new JGBoardDTO();
		nexdto = service.next(bno);

		System.out.println(nexdto + "action dto");
		ForwardAction f = new ForwardAction();
				
		request.setAttribute("nexdto", nexdto);
/*		
		f.setForward(false);
		f.setUrl("jgdetail.do");*/
		
/*		f.setForward(true);
		f.setUrl("main.jsp?page=jg_board/jgdetail.jsp");*/
		
		f.setForward(true);
		f.setUrl("main.jsp?page=jg_board/jgdetail.jsp?bno="+bno);
		
		return f;
	}

}
