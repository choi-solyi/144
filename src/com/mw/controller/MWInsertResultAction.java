package com.mw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.mw.dao.MWBoardDAO;
import com.mw.dto.MWBoardDTO;
import com.mw.service.MWBoardService;

public class MWInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		
		MWBoardService service = MWBoardService.getService();
		MWBoardDTO dto = new MWBoardDTO();
		dto.setBtitle(title);
		dto.setBcategory(category);
		dto.setId(id);
		dto.setBcontent(content);
		service.mwInsert(dto);
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("toplist.do");
		
		return f;
	}

}
