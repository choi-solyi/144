package com.sb.controller;

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

import com.sb.dto.SUPRepBoardDTO;
import com.sb.service.SUPBoardService;

/**
 * Servlet implementation class SBDetailRepAction
 */
@WebServlet("/sbdetailrep.do")
public class SBDetailRepAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SBDetailRepAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}
	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int bno = Integer.parseInt(request.getParameter("bno"));
		SUPBoardService service= SUPBoardService.sbGetBoardService();
		List<SUPRepBoardDTO> list = service.sbDetailRep(bno);
		
		
		JSONArray arr= new JSONArray();
		
		for(SUPRepBoardDTO rdto:list) {
			
			JSONObject o= new JSONObject();
			o.put("repno", rdto.getRepno());
			o.put("rcontent", rdto.getRcontent());
			o.put("id", rdto.getId());
			o.put("rwritedate", rdto.getRwritedate());
			o.put("bno", rdto.getBno());
			arr.add(o);
		}
		out.print(arr);
		
		
	}
	
	
}