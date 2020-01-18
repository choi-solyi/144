package com.sy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.dto.JGRepBoardDTO;
import com.sy.service.JGBoardService;

public class SYAddRepAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String rcontent = request.getParameter("rcontent");
/*		String nick = request.getParameter("nick");
*/		
		JGRepBoardDTO rdto = new JGRepBoardDTO();
		
		rdto.setRcontent(rcontent);
		/*rdto.setNick(nick);*/
		
		JGBoardService service = JGBoardService.getService();
		
		service.addRep(bno, rdto);
		
		ForwardAction f = new ForwardAction();
		
		f.setForward(false);
		f.setUrl("jgdetail.do?bno="+bno);
		
		
		//f.setForward(true);
		
		
		//f.setUrl("main.jsp?page=jg_board/jgdetail.jsp");

		/*f.setUrl("main.jsp?page=jg_board/jgdetail.jsp");*/
		
		return f;
	}

}
