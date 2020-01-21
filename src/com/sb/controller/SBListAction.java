package com.sb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sb.dto.SUPBoardDTO;
import com.sb.service.SUPBoardService;

public class SBListAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
		
		
		 int currpage=1;
		  String curr=request.getParameter("curr");
		  if(curr!=null)
		  {
			  currpage=Integer.parseInt(curr);
		  }
		  
		  String search=request.getParameter("search");  //title
		  String txtsearch=request.getParameter("txtsearch"); //null
		  if(search==null)    search="";
		  if(txtsearch==null) txtsearch="";
		  SUPBoardService service = SUPBoardService.sbGetBoardService();
		 
		 int totalcount= service.sbGetCount(search, txtsearch); //전체자료
		 int pagepercount=10; // 1페이지에 보여줄 자료
		 int totalpage=(int)Math.ceil((float)totalcount/pagepercount); 
		 int startrow=(currpage-1)*pagepercount+1;
		 int endrow=startrow+pagepercount-1;
		 if(endrow> totalcount) endrow=totalcount;
		 
		 int blockcount=5;
		 int startblock=(currpage-1)/blockcount*blockcount+1;
		 int endblock=startblock+blockcount-1;
		 if(endblock>totalpage) endblock=totalpage;
		 
		 SUPBoardDTO dto = new SUPBoardDTO();
		
		 	
		 
		List<SUPBoardDTO> list = service.sbList(startrow,endrow,search,txtsearch);
		
		
		request.setAttribute("list", list);
		
		 request.setAttribute("currpage", currpage);
		 request.setAttribute("startblock", startblock);
		 request.setAttribute("endblock",endblock);
		 request.setAttribute("totalpage", totalpage);
		 request.setAttribute("search", search);
		 request.setAttribute("txtsearch", txtsearch);
		
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("main.jsp?page=supBoard/suplist.jsp");
		
		return f;
	}
	
	
}
