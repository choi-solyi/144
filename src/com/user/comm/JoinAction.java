package com.user.comm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JoinAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("index.jsp");
		request.getParameter("id");
		request.getParameter("pw");
		request.getParameter("nick");
		request.getParameter("name");
		request.getParameter("tel");
		request.getParameter("line");
		
	
		return f;
	}

}
