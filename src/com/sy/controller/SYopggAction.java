package com.sy.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class SYopggAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String sname= request.getParameter("summoner");
		String summoner = URLEncoder.encode(sname,"utf-8");
		//

		
		//
		request.setAttribute("summoner", summoner);
		
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("main.jsp?page=jg_board/opgg.jsp?summoner="+summoner);

		return f;
	}

}
