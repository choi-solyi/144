package com.mw.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.mw.dto.MWBoardDTO;
import com.mw.service.MWBoardService;

public class MWUpdateResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		MWBoardDTO dto = new MWBoardDTO();
		dto.setBno(no);
		dto.setBtitle(title);
		dto.setId(id);
		dto.setBcontent(content);
		
		MWBoardService service = MWBoardService.getService();
		service.mwUpdate(dto);
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("/main.jsp?page=topboard/toplist.do");
		
		return f;
	}

}
