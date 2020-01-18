package com.lol.comm;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns= {"*.do"},initParams= {
      @WebInitParam(name="init", value="WEB-INF/prop.properties")})
public class FrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FrontController() {
        // TODO Auto-generated constructor stub
    }

    HashMap<String, Action> hm = new HashMap<>();
   @Override
   public void init(ServletConfig config) throws ServletException {
      // TODO Auto-generated method stub
      String path = config.getInitParameter("init");
      String propath = config.getServletContext().getRealPath(path);
      Properties properties = new Properties();
      System.out.println("path:"+path);
      System.out.println("propath:"+propath);
      try{
         properties.load(new FileReader(propath));
         Enumeration enu = properties.keys();
         while(enu.hasMoreElements())
         {
            String key = (String)enu.nextElement();
            String value = properties.getProperty(key);
            System.out.println("key:"+key);
            System.out.println("value:"+value);
            Class c = Class.forName(value);
            Action act = (Action)c.newInstance();
            System.out.println("key:"+key);
            System.out.println("act:"+act);
            hm.put(key, act);
         }
      }catch(Exception  e)
      {
         System.out.println(e);
      }
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

   private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      String path = request.getServletPath();
      Action act = null;
      act = hm.get(path);
      System.out.println("path:"+path);
      System.out.println("act:"+act);
      ForwardAction f = act.execute(request, response);
      if(f.isForward())
      {
         RequestDispatcher disp = request.getRequestDispatcher(f.getUrl());
         disp.forward(request, response);
      }else
      {
         response.sendRedirect(f.getUrl());
      }
   }
}