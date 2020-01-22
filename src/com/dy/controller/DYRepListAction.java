package com.dy.controller;

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

import com.dy.dto.DYRepBoardDTO;
import com.dy.service.DYBoardService;

/**
 * Servlet implementation class DYRepListAction
 */
@WebServlet("/dyreplist.do")
public class DYRepListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DYRepListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request,response);
	}

	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int bno =Integer.parseInt( request.getParameter("bno"));
		DYBoardService service = DYBoardService.getservice();
		List<DYRepBoardDTO> list = service.dyreplist(bno);
		
		JSONArray arr = new JSONArray();
		
		System.out.println("arr : "+ arr);
		
		for(DYRepBoardDTO dto : list) {
			
			JSONObject o = new JSONObject();
			o.put("repno", dto.getRepno());
			o.put("rcontent",dto.getRcontent());
			o.put("id", dto.getId());
			o.put("rwritedate", dto.getRwritedate());
			o.put("bno", dto.getBno());
			o.put("nick", dto.getNick());
			arr.add(o);
			
		}
		out.print(arr);
	}
	
}
