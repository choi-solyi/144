package com.dy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.comm.DYAction;
import com.dy.comm.DYForwardAction;

public class DYInsertAction implements DYAction {

	@Override
	public DYForwardAction dyexecute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DYForwardAction forward = new DYForwardAction();
		forward.setForward(true);
		forward.setUrl("main.jsp?page=dyboard/insert.jsp");
		
		return forward;
	}

}
