package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;

@SuppressWarnings("serial")
public class ShowImgServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
//		String imagePath = request.getSession().getServletContext().getRealPath("/")+"view\\picture\\1.jpg";	
//	   boolean flag=UserDao.clone_img(imagePath);
		String imgUrl="http://localhost:8080/MyWebApp/view/picture/1.jpg";
	  boolean flag=UserDao.downLoad(imgUrl);
	  if (flag) {
		 request.setAttribute("tmp", "1");
	   }else{
		   request.setAttribute("tmp","0");
	   }
	  request.getRequestDispatcher("MyJsp.jsp").forward(request, response);
	}
}
