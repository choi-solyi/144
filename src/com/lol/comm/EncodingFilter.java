package com.lol.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*.do")
public class EncodingFilter implements Filter{

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
         throws IOException, ServletException {
   
      request.setCharacterEncoding("utf-8");
      filter.doFilter(request, response);

   }
}