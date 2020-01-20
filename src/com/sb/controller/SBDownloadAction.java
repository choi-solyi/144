package com.sb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class SBDownloadAction
 */
@WebServlet("/sbdownload.do")
public class SBDownloadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SBDownloadAction() {
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
		HttpSession session = request.getSession();	
		
		
		String f=(String)session.getAttribute("file");
		String folder=request.getServletContext().getRealPath("supBoard/upload");
		String filepath=folder+"/"+f;
		
		System.out.println(f);
		System.out.println(folder);
		System.out.println(filepath);
		
		FileInputStream fileInputStream=null;
		try {
			File file = new File(filepath);
			byte b[] = new byte[4000];
			response.reset();
			response.setContentType("application/octet-stream");
			String encoding = new String(f.getBytes("utf-8"),"8859_1");
			response.setHeader("Content-Disposition", "attachment;filename="+encoding);
			
			if(file.isFile()) {
				fileInputStream = new FileInputStream(filepath);
				ServletOutputStream servletOutputStream= response.getOutputStream();
				int readNum;
				while( (readNum=fileInputStream.read(b,0,b.length)) != -1 ) {
					servletOutputStream.write(b,0,readNum);
				}
			}
		}catch(IOException e) {
			System.out.println(e);
		}finally {
			if(fileInputStream!=null) {
				try {fileInputStream.close();} catch(IOException e) {}
			}
		}
		
	}
		
		
		
}


