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
		
		
		int filesize = 1024*1024*10;
		String uploadpath= request.getServletContext().getRealPath("/supBoard/upload");
		
		
		MultipartRequest mul = new MultipartRequest(request,uploadpath,filesize,"utf-8",new DefaultFileRenamePolicy());
		int bno = Integer.parseInt(mul.getParameter("bno"));
		
		String btitle = mul.getParameter("btitle");
		
		String bcontent = mul.getParameter("bcontent");
		String bcategory = mul.getParameter("bcategory");
		String file = mul.getFilesystemName("bimg");
		
		SUPBoardService service = SUPBoardService.sbGetBoardService();
		SUPBoardDTO dto = new SUPBoardDTO();
	
		dto.setBno(bno);
		dto.setBcategory(bcategory);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		dto.setBimg(file);
		
		service.sbUpdate(dto);
		
		request.setAttribute("dto", dto);
	
		ForwardAction f= new ForwardAction();
		f.setForward(false);
		f.setUrl("sbdetail.do?bno="+bno);
		
		return f;
	}
	
	
}
