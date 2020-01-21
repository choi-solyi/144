package com.jw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jw.BoardDTO.JWRepBoardDTO;
import com.jw.service.JWBoardService;

/**
 * Servlet implementation class adListRep
 */
@WebServlet("/JWreplist.do")
public class JWListRepAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JWListRepAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno = request.getParameter("bno");
		JWBoardService service = JWBoardService.getBoardService();
		List<JWRepBoardDTO> list = service.adListRep(bno);
		JSONArray arr = new JSONArray();
		
		for(JWRepBoardDTO dto : list)
		{
			JSONObject o = new JSONObject();
			o.put("bno", dto.getBno());
			o.put("id", dto.getId());
			o.put("nick", dto.getNick());
			o.put("rcontent", dto.getRcontent());
			o.put("repno", dto.getRepno());
			o.put("rwritedate", dto.getRwritedate());
			arr.add(o);
		}
		response.setContentType("apllication/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(arr);
	}
}
