package com.eb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eb.dao.CalBoardDAO;
import com.eb.dto.CalBoardDTO;
import com.eb.service.CalBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EBInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		
		
		
		//파일 업로드
		String uploadpath = request.getServletContext().getRealPath("/calBoard/calupload");
		System.out.println(uploadpath);
		int filesize = 1024*1024*10;
		MultipartRequest muti = new MultipartRequest(request, uploadpath, filesize, "utf-8", new DefaultFileRenamePolicy());
		String uploadfile = muti.getFilesystemName("uploadfile"); // 
		
		String btitle=muti.getParameter("btitle");
		String bcaldate=muti.getParameter("bcaldate");
		String bcontent=muti.getParameter("bcontent");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
	
		CalBoardService service=CalBoardService.getService();
		CalBoardDTO dto=new CalBoardDTO();
		dto.setBimg(uploadfile);
		dto.setBtitle(btitle);
		dto.setBcaldate(bcaldate);
		dto.setBcontent(bcontent);
		dto.setId(id);
		

		
		service.Insert(dto);
	
		ForwardAction forward=new ForwardAction();
		forward.setForward(false);
		forward.setUrl("EBlist.do");
		
		return forward;
	}

}
