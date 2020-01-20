package com.mw.controller;

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

import com.mw.service.MWBoardService;
import com.mw.dto.MWRepBoardDTO;


/**
 * Servlet implementation class MWRepDetailAction
 */
@WebServlet("/repdetail.do")
public class MWRepDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MWRepDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request,response);
	}
	
	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		int no = Integer.parseInt(request.getParameter("no"));
		MWBoardService service= MWBoardService.getService();
		List<MWRepBoardDTO> list=service.repDetail(no);
		
		
		JSONArray arr= new JSONArray();
		
		for(MWRepBoardDTO dto:list) {
			
			JSONObject o= new JSONObject();
			o.put("repno", dto.getRepno());
			o.put("rcontent", dto.getRcontent());
			o.put("rwritedate", dto.getRwritedate());
			o.put("nick", dto.getNick());
			o.put("bno", dto.getBno());
			arr.add(o);
		}
		out.print(arr);
		
	}

}
