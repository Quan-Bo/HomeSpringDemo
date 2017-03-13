package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

	public MyFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String servletPath=req.getServletPath();
		HttpSession session=req.getSession();
		String username=(String) session.getAttribute("username");
		if (username!=null&&(servletPath.equals("index.jsp"))||(servletPath.equals("login.jsp"))) {
			chain.doFilter(request, response);
		}else{
			req.setAttribute("falgErrot", "尚未登陆");
			req.getRequestDispatcher("login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException { 
	}

}
