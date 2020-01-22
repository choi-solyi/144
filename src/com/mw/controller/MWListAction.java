package com.mw.controller;

import java.io.IOException;
import java.util.List;

import javax.activation.ActivationDataFlavor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.mw.dto.MWBoardDTO;
import com.mw.service.MWBoardService;

public class MWListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int currpage = 1;
		String curr = request.getParameter("curr");
		if(curr!=null) {
			currpage = Integer.parseInt(curr);
		}
		
		String search = request.getParameter("search");
		String searchtxt = request.getParameter("searchtxt");
		
		System.out.println("AAA"+search);
		System.out.println("AAA"+searchtxt);
		
		if(search == null) {
			search = "";
		}
		if(searchtxt == null) {
			searchtxt = "";
		}
			
		MWBoardService service = MWBoardService.getService();
		
		int totalcount = service.getCount(search, searchtxt);
		int pagepercount = 5;
		int totalpage = (int)Math.ceil((float)totalcount/pagepercount);
		int startrow = (currpage-1)*pagepercount;
				
		int blockcount = 5;
		int startblock = (currpage-1)/blockcount*blockcount+1;
		int endblock = startblock+blockcount-1;
		if(endblock>totalpage) {
			endblock=totalpage;
		}
		
		List<MWBoardDTO> list = service.mwList(search, searchtxt, startrow, pagepercount);
		request.setAttribute("list", list);
		request.setAttribute("currpage", currpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("search", search);
		request.setAttribute("searchtxt", searchtxt);
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("/main.jsp?page=topboard/toplist.jsp");
		return f;
	}

}
