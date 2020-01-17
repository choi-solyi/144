package com.sy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.dto.JGBoardDTO;
import com.sy.service.JGBoardService;

public class SYListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");	
		//그냥 리스트 보기

		JGBoardService service = JGBoardService.getService();
		/*	List<JGBoardDTO> list = service.list();


		request.setAttribute("list", list);*/
		
//////////////Search
		String search = request.getParameter("search");
		if(search==null) search="";
		
		request.setAttribute("search", search);
		


//////////////paging

		//전체 자료수
		int totalCount = service.totalCount();

		//페이지당 갯수
		int sizePerPage = 10;
		int totalPage = (int)Math.ceil((float)totalCount/sizePerPage);

		//현재페이지 계산
		int currPage = 1;
		String curr= request.getParameter("curr");

		if(curr!=null) {
			currPage = Integer.parseInt(curr);
		}


		//row

		int startRow = (currPage - 1) * sizePerPage +1;
		int endRow = startRow + sizePerPage - 1;
		if(endRow > totalCount) {
			endRow = totalCount;
		}

		int pageBlockSize = 5;

		//첫페이지
		int startBlock = ((currPage-1) / pageBlockSize) *pageBlockSize + 1;
		//막페이지
		int endBlock = startBlock + pageBlockSize -1;
		if(endBlock > totalPage) {
			endBlock = totalPage;
		}

		List<JGBoardDTO> list =null;
		list = service.list(startRow, endRow);
		System.out.println(list+"333333333333333333333");
		request.setAttribute("list", list);
		request.setAttribute("currPage", currPage);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
		request.setAttribute("totalPage", totalPage);

	
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		//f.setUrl("/jg_board/list.jsp");

		f.setUrl("main.jsp?page=jg_board/jglist.jsp");
		return f;


	}

}
