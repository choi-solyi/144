package com.sy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class SYInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		

		
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("main.jsp?page=jg_board/jginsert.jsp");
		
		return f;
	}

}
