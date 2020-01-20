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

public class SBInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int filesize = 1024*1024*10;
		String uploadpath= request.getServletContext().getRealPath("/supBoard/upload");
		
		
		MultipartRequest mul = new MultipartRequest(request,uploadpath,filesize,"utf-8",new DefaultFileRenamePolicy());
		String bcategory=mul.getParameter("bcategory");
		String btitle=mul.getParameter("btitle");
		String bcontent=mul.getParameter("bcontent");
		String id = mul.getParameter("id");
		String file = mul.getFilesystemName("bimg");
		
		
		
		SUPBoardService service = SUPBoardService.sbGetBoardService();
		
		SUPBoardDTO dto = new SUPBoardDTO();
		dto.setBcategory(bcategory);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		dto.setId(id);
		dto.setBimg(file);
		
		service.sbInsert(dto);
		
		
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("sblist.do");
		
		return f;
	}
	
	
}
