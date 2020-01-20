package com.jw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jw.BoardDTO.JWBoardDTO;
import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class JWInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("JWlist.do");
		
		
		// 파일 업로드
		String uploadpath = request.getServletContext()
				.getRealPath("/adboard/upload"); //WebContent > upload, 업로드 할경로
		int filesize = 1024*1024*10; // 10MB
		MultipartRequest muti = new MultipartRequest(request, uploadpath, 
				filesize, "utf-8", new DefaultFileRenamePolicy());
		String bimg = muti.getFilesystemName("bimg"); //

		String btitle = muti.getParameter("btitle");
		String bcategory = muti.getParameter("bcategory");
		String bcontent = muti.getParameter("bcontent");
		System.out.println(btitle);
		System.out.println(bcategory);
		System.out.println(bimg);
		System.out.println(bcontent);
		JWBoardDTO dto = new JWBoardDTO(); 
		
		dto.setBtitle(btitle);
		dto.setBcategory(bcategory);
		dto.setBimg(bimg);
		dto.setBcontent(bcontent);
		
		JWBoardService service = JWBoardService.getBoardService();
		service.Insert(dto);
		
		return f;
	}
}
