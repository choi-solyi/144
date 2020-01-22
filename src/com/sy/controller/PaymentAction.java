package com.sy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.dto.MDDTO;
import com.user.comm.UserDAO;
import com.user.comm.UserDTO;
import com.user.comm.UserService;

public class PaymentAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String img = request.getParameter("img");
		int mdcode = Integer.parseInt(request.getParameter("mdcode"));
		String mdname = request.getParameter("mdname");
		int price = Integer.parseInt(request.getParameter("price"));
				
		
		
		System.out.println("payment 1111111");
		System.out.println(mdcode);
		System.out.println(mdname);
		System.out.println(price);
		System.out.println(id);
		System.out.println("img + " +  img);
		System.out.println("payment 1111111");

		
		//기존 cp값 받아오기
		UserService service = UserService.getService();
		UserDTO dto1 = new UserDTO();
		
		dto1 = service.userinfo(id);
		
		System.out.println("payment 11111 getCP" + dto1.getCp());
		//구매후 cp값 받아오기
		UserDTO dto2 = new UserDTO();

		dto2 = service.payment(id, mdcode, mdname, price);
		
		
		System.out.println("dto2 getCP" + dto2.getCp());
		
		ForwardAction f = new ForwardAction();
		
		
		request.setAttribute("dto1", dto1);
		
		request.setAttribute("img", img);
		request.setAttribute("mdcode", mdcode);
		request.setAttribute("mdname", mdname);
		request.setAttribute("price", price);
		request.setAttribute("dto2", dto2);
		
		f.setForward(true);
		f.setUrl("main.jsp?page=jg_board/payment.jsp");
		
		return f;
	}

}
