package com.eb.controller;

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

import com.eb.dto.CalSubBoardDTO;
import com.eb.service.CalBoardService;
import com.mysql.cj.xdevapi.JsonArray;

/**
 * Servlet implementation class EBDetailRepAction
 */
@WebServlet("/EBrepdetail.do")
public class EBDetailRepAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EBDetailRepAction() {
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
	
	protected void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bno=Integer.parseInt(request.getParameter("bno"));
		CalBoardService service=CalBoardService.getService();
		List<CalSubBoardDTO> list=service.subDetail(bno);
		
		JSONArray arr=new JSONArray();
		for(CalSubBoardDTO dto:list )
		{
			JSONObject o=new JSONObject();
			o.put("repno", dto.getRepno());
			o.put("rcontent", dto.getRcontent());
			o.put("rwritedate", dto.getRwritedate());
			o.put("id", dto.getId());
			o.put("bno", dto.getBno());
			arr.add(o);
		}
		response.setContentType("apllication/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(arr);
	}
}
