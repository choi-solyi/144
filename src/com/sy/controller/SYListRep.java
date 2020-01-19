package com.sy.controller;

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

import com.mysql.cj.Session;
import com.sy.dto.JGRepBoardDTO;
import com.sy.service.JGBoardService;

/**
 * Servlet implementation class SYListRep
 */
@WebServlet("/listreq.do")
public class SYListRep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SYListRep() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);


	}
	private void doReq(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("---------------------------------------------"+bno);
		
		JGBoardService service = JGBoardService.getService();
		List<JGRepBoardDTO> list = service.listReq(bno);
		
		JSONArray arr = new JSONArray();

		for(JGRepBoardDTO dto :list) {
			JSONObject o = new JSONObject();
			
			o.put("repno" ,dto.getRepno());
			o.put("rcontent", dto.getRcontent());
			o.put("rwritedate", dto.getRwritedate());
			o.put("bno", dto.getBno());
			o.put("id", dto.getId());
			o.put("nick", dto.getNick());
			
			arr.add(o);
			
		}
		out.print(arr);
	}


}
