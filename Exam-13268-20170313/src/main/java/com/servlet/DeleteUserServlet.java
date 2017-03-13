package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;


public class DeleteUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		boolean flag=UserDao.deleteUser(id);
		if (flag) {
			request.getRequestDispatcher("ShowUser.jsp").forward(request, response);
		}
		else{
			request.setAttribute("error", "删除失败");
			request.getRequestDispatcher("ShowUser.jsp").forward(request, response);
		}
	}

	

}
