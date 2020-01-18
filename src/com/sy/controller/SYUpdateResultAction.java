package com.sy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.dao.JGBoardDAO;
import com.sy.dto.JGBoardDTO;
import com.sy.service.JGBoardService;

public class SYUpdateResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		request.setCharacterEncoding("utf-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String bcategory = request.getParameter("bcategory");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		System.out.println("bno :  " +bno);
		
		JGBoardService service = JGBoardService.getService();
		JGBoardDTO dto = new JGBoardDTO();
		
		dto.setBno(bno);
		dto.setBcategory(bcategory);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		

		service.update(dto,bno);
		
		ForwardAction f = new ForwardAction();
		
		f.setForward(false);
	//	f.setUrl("main.jsp?page=jg_board/jgdetail.jsp?bno=" + bno);
		f.setUrl("jgdetail.do?bno="+bno);
		return f;
	}

}
