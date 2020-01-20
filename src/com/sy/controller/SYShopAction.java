package com.sy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.dto.MDDTO;
import com.sy.service.JGBoardService;

public class SYShopAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int mdcode = Integer.parseInt(request.getParameter("mdcode"));
		System.out.println(mdcode);
		System.out.println("위가 받아온값 ");
		
		JGBoardService service  = JGBoardService.getService();
		
		
		MDDTO mddto =  service.getMdDetail(mdcode);
	
		System.out.println("mddto 값 유무 " + mddto);
		
//		f.setForward(false);
//		f.setUrl("shopdetail.do?mdcode="+mdcode);
		request.setAttribute("mddto", mddto);

		ForwardAction f = new ForwardAction();
		
		f.setForward(true);
		f.setUrl("main.jsp?page=jg_board/shopdetail.jsp?mdcode="+mdcode);
		
		
		return f;
	}

}
