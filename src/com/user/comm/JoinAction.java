package com.user.comm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JoinAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		f.setForward(false);
		f.setUrl("index.jsp");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String line = request.getParameter("line");
		
		String salt = SHA.generateSalt();
		pw = SHA.getEncrypt(pw, salt);
		System.out.println(salt);
		System.out.println(pw);
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setNick(nick);
		dto.setName(name);
		dto.setTel(tel);
		dto.setLine(line);
		
		UserService service = UserService.getService();
		//service.join(dto);
		
		return f;
	}

}
