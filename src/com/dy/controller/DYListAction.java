package com.dy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.comm.DYAction;
import com.dy.comm.DYForwardAction;
import com.dy.dto.DYBoardDTO;
import com.dy.service.DYBoardService;

public class DYListAction implements DYAction {

	@Override
	public DYForwardAction dyexecute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//session check (template project 참고)
		
		DYBoardService service = DYBoardService.getservice(); 
		
		List<DYBoardDTO> list = service.dylist();
		
		System.out.println(list);
		
		request.setAttribute("list", list);
		
		DYForwardAction forward = new DYForwardAction();
		forward.setForward(true); //forward로 값을 넘긴다.
		//forward.setUrl("/WEB-INF/dyboard/list.jsp");
		forward.setUrl("main.jsp?page=dyboard/list.jsp");
		
		return forward;
	}

}
