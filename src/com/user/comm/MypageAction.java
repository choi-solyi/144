package com.user.comm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.mysql.cj.Session;

public class MypageAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ssid = request.getParameter("id");
		

		System.out.println(ssid);
		System.out.println("get mypage 1111111");
		//ssid �� id , nick �� ��������
		
		UserDTO dto = new UserDTO();
		
		UserService service = UserService.getService();
		dto = service.userinfo(ssid);		
		
		//�� ������..
		
		request.setAttribute("dto", dto);
		
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("main.jsp?page=mypage.jsp");

		
		return f;
		
		
	}

}
