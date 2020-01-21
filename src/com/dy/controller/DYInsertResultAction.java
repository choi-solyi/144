package com.dy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.dto.DYBoardDTO;
import com.dy.service.DYBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class DYInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = (String)request.getParameter("id");
		String bcategory = (String)request.getParameter("bcategory");
		String btitle = (String)request.getParameter("btitle");
		String bcontent = (String)request.getParameter("bcontent");
		
		DYBoardDTO dto = new DYBoardDTO();
		
		System.out.println("bcategory : " +bcategory);
		System.out.println("id : " + id);
		dto.setId(id);
		dto.setBcategory(bcategory);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		
		DYBoardService service = DYBoardService.getservice();
		service.dyinsert(dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("dylist.do");
		
		
		return forward;
	}

}
