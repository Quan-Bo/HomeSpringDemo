package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.UserBean;
import com.Dao.UserDao;


public class AddUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean user=new UserBean();
		user.setTitle(request.getParameter("title"));
		user.setDescription(request.getParameter("description"));
		user.setLanguage_id(Integer.valueOf(request.getParameter("language")));
		Boolean flag=UserDao.Add_User(user);
		System.out.println(flag);
	}

}
