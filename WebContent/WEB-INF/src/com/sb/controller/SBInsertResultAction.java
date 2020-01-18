package com.sb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sb.dto.SUPBoardDTO;
import com.sb.service.SUPBoardService;

public class SBInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
//		int filesize = 1024*1024*10;
//		String uploadpath= request.getServletContext().getRealPath("upload");
//		
//		
//		MultipartRequest mul = new MultipartRequest(request, )
		String bcategory=request.getParameter("bcategory");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		
		
		SUPBoardService service = SUPBoardService.sbGetBoardService();
		
		SUPBoardDTO dto = new SUPBoardDTO();
		dto.setBcategory(bcategory);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		
		service.sbInsert(dto);
		
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("sblist.do");
		
		return f;
	}
	
	
}
