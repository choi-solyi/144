package com.jw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jw.BoardDTO.JWBoardDTO;
import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JWInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("JWlist.do");
		
		String btitle = request.getParameter("btitle");
		String bcategory = request.getParameter("bcategory");
		String bimg = request.getParameter("bimg");
		String bcontent = request.getParameter("bcontent");
		System.out.println(btitle);
		System.out.println(bcategory);
		System.out.println(bimg);
		System.out.println(bcontent);
		
		JWBoardDTO dto = new JWBoardDTO(); 
		
		dto.setBtitle(btitle);
		dto.setBcategory(bcategory);
		dto.setBimg(bimg);
		dto.setBcontent(bcontent);
		
		JWBoardService service = JWBoardService.getBoardService();
		service.Insert(dto);
		
		return f;
	}

}
