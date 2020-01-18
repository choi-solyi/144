package com.sy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.dto.JGBoardDTO;
import com.sy.service.JGBoardService;

public class SYInsertResultAciton implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		
		String btitle = request.getParameter("btitle");
		String bcategory = request.getParameter("bcategory");
		String bcontent = request.getParameter("bcontent");
	
		JGBoardDTO dto = new JGBoardDTO();
		
		dto.setBtitle(btitle);
		dto.setBcategory(bcategory);
		dto.setBcontent(bcontent);
		
		JGBoardService service = JGBoardService.getService();
		service.insert(dto);
		
			
		ForwardAction f = new ForwardAction();
		
		f.setForward(false);
		f.setUrl("jglist.do");
		
		return f;
	}

}
