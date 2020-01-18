package com.eb.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.CalBoardDAO;
import com.eb.dto.CalBoardDTO;
import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class EBInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String btitle=request.getParameter("btitle");
		String bcaldate=request.getParameter("bcaldate");
		String bcontent=request.getParameter("bcontent");
	
		CalBoardService service=CalBoardService.getService();
		CalBoardDTO dto=new CalBoardDTO();
		dto.setBtitle(btitle);
		dto.setBcaldate(bcaldate);
		dto.setBcontent(bcontent);
		service.Insert(dto);
	
		ForwardAction forward=new ForwardAction();
		forward.setForward(false);
		forward.setUrl("EBlist.do");
		
		return forward;
	}

}
