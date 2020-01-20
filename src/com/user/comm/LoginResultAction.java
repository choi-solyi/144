package com.user.comm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;
import com.sy.service.JGBoardService;

public class LoginResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		
		UserService service = UserService.getService();
		

		int result = service.login(id,pw);
		
		ForwardAction f = new ForwardAction();
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(60*5); //5min.
			f.setForward(true);
			f.setUrl("toplist.do");
					
		}else if(result ==2){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(60*5); //5min.

			System.out.println(session.getAttribute("id"));
			
			f.setForward(true);
			f.setUrl("jglist.do");
		}else if(result ==3){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(60*5); //5min.
			
			f.setForward(true);
			f.setUrl("dylist.do");
		}else if(result ==4){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(60*5); //5min.
			
			f.setForward(true);
			f.setUrl("JWlist.do");
		}else if(result ==5){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(60*5); //5min.
			
			f.setForward(true);
			f.setUrl("sblist.do");
		}else if(result ==6){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(60*5); //5min.
			
			f.setForward(true);
			f.setUrl("EBlist.do");
		}else{
			f.setForward(false);
			f.setUrl("index.jsp");
		}
		return f;
	}

}
