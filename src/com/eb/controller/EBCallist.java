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

import com.eb.dto.CalBoardDTO;
import com.eb.service.CalBoardService;
import com.mysql.cj.xdevapi.JsonArray;

/**
 * Servlet implementation class EBCallist
 */
@WebServlet("/EBCallist.do")
public class EBCallist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EBCallist() {
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
		CalBoardService service = CalBoardService.getService();
		List<CalBoardDTO> list =  service.callistall();
		
		JSONArray arr = new JSONArray();
		for(CalBoardDTO index : list)
		{
			JSONObject o = new JSONObject();
			o.put("bno", index.getBno());
			o.put("btitle", index.getBtitle());
			o.put("bcaldate", index.getBcaldate());
			arr.add(o);
		}
		response.setContentType("apllication/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(arr);
		System.out.println("  ");
		System.out.println("  ");System.out.println("  ");
		System.out.println(arr);
	}
}

