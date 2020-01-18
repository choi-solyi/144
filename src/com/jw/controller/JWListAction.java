package com.jw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jw.BoardDTO.JWBoardDTO;
import com.jw.service.JWBoardService;
import com.lol.comm.Action;
import com.lol.comm.ForwardAction;

public class JWListAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForwardAction f = new ForwardAction();
		JWBoardService service = JWBoardService.getBoardService();
		List<JWBoardDTO> list = service.List();
		request.setAttribute("list", list);
		
		JSONArray arr = new JSONArray();
		for(JWBoardDTO item : list)
		{
			JSONObject o = new JSONObject();
			o.put("bno", item.getBno());
			o.put("btitle", item.getBtitle());
			o.put("bcontent", item.getBcontent());
			o.put("bwritedate", item.getBwritedate());
			o.put("bcategory", item.getBcategory());
			o.put("bhit", item.getBhit());
			o.put("bup", item.getBup());
			o.put("bimg", item.getBimg());
			o.put("id", item.getId());
			arr.add(o);
		}
		request.setAttribute("arr", arr);
		
		f.setForward(true);
		f.setUrl("main.jsp?page=adboard/adlist.jsp");
		return f;
	}
}
