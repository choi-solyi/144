package com.jw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jw.BoardDTO.JWRepBoardDTO;
import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JWAddRepAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String bno = request.getParameter("bno");
		String rcontent = request.getParameter("rcontent");
		
		JWRepBoardDTO dto = new JWRepBoardDTO();
		dto.setId(id);
		dto.setBno(Integer.parseInt(bno));
		dto.setRcontent(rcontent);
		
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("JWdetail.do?bno="+bno);
		
		JWBoardService service = JWBoardService.getBoardService();
		
		service.adAddRep(dto);
		
		return f;
	}

}
