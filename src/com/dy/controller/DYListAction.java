package com.dy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.dy.dto.DYBoardDTO;
import com.dy.service.DYBoardService;

public class DYListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int currpage =1;
		String curr = request.getParameter("curr");
		if(curr!=null)
		{
			currpage=Integer.parseInt(curr);
		}
		
		String search = request.getParameter("search");
		String txtsearch = request.getParameter("txtsearch");
		
		if(search==null) search="";
		if(txtsearch==null) txtsearch="";
		
		DYBoardService service = DYBoardService.getservice(); 
		
		int totalcount = service.dygetCount(search,txtsearch);
		
		int pagepercount = 10; 
		int totalpage = (int)Math.ceil((float)totalcount/pagepercount);
		int startrow = (currpage-1)*pagepercount+1;
		int endrow = startrow+pagepercount + 1;
		if(endrow>totalcount)endrow=totalcount;
		
		int blockcount = 5;
		int startblock =((currpage-1)/blockcount)*blockcount+1;
		int endblock =startblock+blockcount-1;
		if(endblock>totalpage) endblock=totalpage;
		
		
		List<DYBoardDTO> list = service.dylist();
		
		System.out.println(list);
		
		request.setAttribute("list", list);
		request.setAttribute("currpage",currpage);
		request.setAttribute("startblock",startblock);
		request.setAttribute("endblock",endblock);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("search",search);
		request.setAttribute("txtsearch",txtsearch);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true); //forward로 값을 넘긴다.
		//forward.setUrl("/WEB-INF/dyboard/list.jsp");
		forward.setUrl("main.jsp?page=dyboard/list.jsp");
		
		return forward;
	}

}
