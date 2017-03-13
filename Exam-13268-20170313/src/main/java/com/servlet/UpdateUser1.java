package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.UserBean;
import com.Dao.UserDao;

public class UpdateUser1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean user=new UserBean();
    	HttpSession session=request.getSession();
    	System.out.println(2);
    	user.setFilm_id(Integer.valueOf(session.getAttribute("user_id").toString()));
    	user.setTitle(request.getParameter("title"));
    	user.setDescription(request.getParameter("description"));
    	System.out.println(3);
    	user.setLanguage_id(Integer.valueOf( request.getParameter("language")));
    	Boolean tmp=UserDao.UpdateUser(user);
    	System.out.println(tmp);
    	if (tmp) {
    		request.getRequestDispatcher("ShowUser.jsp").forward(request, response);
		}
    	else{
    		request.getRequestDispatcher("UpdateUserServlet?flag=1&id="+session.getAttribute("user_id")).forward(request, response);
    	}
	}
	
}
