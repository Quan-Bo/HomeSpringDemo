package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		Boolean result=UserDao.get_login(username);
		HttpSession session=request.getSession();
		if (result) {
			session.setAttribute("username", username);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			session.setAttribute("username",null);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
