package com.jw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		
		// 파일 업로드 input=file 시작
		String uploadpath = request.getServletContext()
				.getRealPath("/adboard/upload"); //WebContent > upload, 업로드 할경로
		int filesize = 1024*1024*10; // 10MB
		MultipartRequest muti = new MultipartRequest(request, uploadpath, 
				filesize, "utf-8", new DefaultFileRenamePolicy());
		String bimg = muti.getFilesystemName("bimg"); //
		//
		
		// 세션
		HttpSession session =request.getSession();
		String id =(String)session.getAttribute("id");
		// form 태그 값
		String btitle = muti.getParameter("btitle");
		String bcategory = muti.getParameter("bcategory");
		String bcontent = muti.getParameter("bcontent");
		
		//input=file 끝
		
		
		
		/*HttpSession session =request.getSession();
		String id =(String)session.getAttribute("id");
		// form 태그 값
		String btitle = request.getParameter("btitle");
		String bcategory = request.getParameter("bcategory");
		String bcontent = request.getParameter("bcontent");
		String bimg = null;
		System.out.println(btitle);
		System.out.println(bcategory);
		System.out.println(bimg);
		System.out.println(bcontent);
		*/
		
		JWBoardDTO dto = new JWBoardDTO(); 
		dto.setId(id);
		dto.setBtitle(btitle);
		dto.setBcategory(bcategory);
		dto.setBimg(bimg);
		dto.setBcontent(bcontent);
		
		JWBoardService service = JWBoardService.getBoardService();
		service.Insert(dto);
		
		return f;
	}
}
