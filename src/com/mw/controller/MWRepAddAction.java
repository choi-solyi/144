package com.mw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.mw.dto.MWRepBoardDTO;
import com.mw.service.MWBoardService;

public class MWRepAddAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String no = request.getParameter("no");
		String content = request.getParameter("content");
		String nick = request.getParameter("nick");
		
		MWRepBoardDTO rdto = new MWRepBoardDTO();
		rdto.setBno(Integer.parseInt(no));
		rdto.setRcontent(content);
		rdto.setNick(nick);
		
		System.out.println(rdto.getBno());
		
		MWBoardService service = MWBoardService.getService();
		
		service.addRep(rdto);
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("topdetail.do?no="+no);
		
		return f;
	}

}
