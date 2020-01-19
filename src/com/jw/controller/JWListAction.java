package com.jw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jw.BoardDTO.JWBoardDTO;
import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JWListAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		JWBoardService service = JWBoardService.getBoardService();
		
		String search = request.getParameter("search");
		String searchtxt = request.getParameter("searchtxt");

		if(search==null)
			search="";
		if(searchtxt==null)
			searchtxt="";
	
		String curr = request.getParameter("curr");
		int currpage = 1;
		if(curr!=null && !curr.equals(""))
			currpage = Integer.parseInt(curr);
		
		int totalcount = service.Totalcount(search, searchtxt);
		int pagesize = 5;
		int startrow = (currpage-1)*pagesize;
		int endrow = startrow+pagesize-1;
		if(endrow>totalcount)
			endrow=totalcount;
		
		int pagecount = (int)Math.ceil((float)totalcount/pagesize);
		int pageblock = 5;
		int startpage = (currpage-1)/pageblock*pageblock+1;
		int endpage = startpage+pageblock-1;
		if(endpage>pagecount)
			endpage=pagecount;
		System.out.println(pagecount);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("pageblock", pageblock);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("search",search);
		request.setAttribute("searchtxt",searchtxt);
		List<JWBoardDTO> list = service.List(startrow, pagesize, search, searchtxt);
		request.setAttribute("list", list);
		
		f.setForward(true);
		f.setUrl("main.jsp?page=adboard/adlist.jsp");
		return f;
	}
}

/*JSONArray arr = new JSONArray();
for(JWBoardDTO item : list)
{
	JSONObject o = new JSONObject();
	o.put("bno", item.getBno());
	o.put("btitle", item.getBtitle());
	o.put("bcontent", item.getBcontent());
	o.put("bwritedate", item.getBwritedate());
	o.put("bcategory", item.getBcategory());
	o.put("bhit", item.getBhit());
	o.put("bup", item.getBup());
	o.put("bimg", item.getBimg());
	o.put("id", item.getId());
	arr.add(o);
}
request.setAttribute("arr", arr);*/