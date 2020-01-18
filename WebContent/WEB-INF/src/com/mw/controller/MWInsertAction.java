package com.mw.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class MWInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("/main.jsp?page=topboard/topinsert.jsp");
		return f;
	}

}
