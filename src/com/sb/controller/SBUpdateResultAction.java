package com.sb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sb.dto.SUPBoardDTO;
import com.sb.service.SUPBoardService;

public class SBUpdateResultAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		String btitle = request.getParameter("btitle");
		
		String bcontent = request.getParameter("bcontent");
		String bcategory = request.getParameter("bcategory");
		
		
		SUPBoardService service = SUPBoardService.sbGetBoardService();
		SUPBoardDTO dto = new SUPBoardDTO();
	
		dto.setBno(bno);
		dto.setBcategory(bcategory);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		
		
		service.sbUpdate(dto);
		HttpSession session = request.getSession();
		request.setAttribute("dto", dto);
	
		ForwardAction f= new ForwardAction();
		f.setForward(false);
		f.setUrl("sbdetail.do?bno="+bno);
		
		return f;
	}
	
	
}
