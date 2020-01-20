package com.eb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.CalBoardDAO;
import com.eb.dto.CalBoardDTO;
import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class EBListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currpage = 1;
		String curr = request.getParameter("curr");
		String search = request.getParameter("search");
		String searchtxt = request.getParameter("searchtxt");
	      if(search==null)
	    	  search="";
	      if(searchtxt==null)
	    	  searchtxt="";
		if (curr != null)
			currpage = Integer.parseInt(curr);

		CalBoardService service = CalBoardService.getService();
		int pagepersize = 10;
		int totalcount = service.Totalcount(search, searchtxt);
		int totalpage = (int) Math.ceil((float) totalcount / pagepersize);
		System.out.println(totalcount);
		int startrow = (currpage - 1) * pagepersize;
		int endrow = startrow + pagepersize - 1;
		if (endrow > totalcount)
			endrow = totalcount;

		int pageblocksize = 5;
		int startblock = (currpage - 1) / pageblocksize * pageblocksize + 1;
		int endblock = startblock + pageblocksize - 1;
		if (endblock > totalpage)
			endblock = totalpage;

		List<CalBoardDTO> list = service.list(startrow, pagepersize, search, searchtxt);

		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		request.setAttribute("search", search);
		request.setAttribute("searchtxt", searchtxt);

		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/main.jsp?page=calBoard/CALList.jsp");

		return forward;
	}

}
