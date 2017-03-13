package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.Bean.UserBean;
import com.Dao.UserDao;




public class UpdateUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String flag=request.getParameter("flag");
	    if (flag.equals("1")) {
		    int film_id=Integer.valueOf(request.getParameter("id")); 
	    	HttpSession session=request.getSession();
	    	session.setAttribute("user_id", film_id);
			UserBean userBean=UserDao.get_userbyids(film_id);
			request.setAttribute("user", userBean);
			request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
		}
	}

}
