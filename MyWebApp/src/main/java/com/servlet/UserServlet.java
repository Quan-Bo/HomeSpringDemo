package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.UserBean;
import com.Dao.UserDao;



public class UserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if (username==""||username==null) {
			req.setAttribute("flag", "用户名不能为空");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		if (password==""||password==null) {
			req.setAttribute("username",username);
			req.setAttribute("flag", "密码不能为空");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		UserBean user=UserDao.get_User(username);
		if (user.getPassword()==""||user.getPassword()==null) {
			req.setAttribute("username",username);
			req.setAttribute("flag", "用户名不存在");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else if(password.equals(user.getPassword())){
			req.getRequestDispatcher("MyJsp.jsp").forward(req, resp);
		}else{
			req.setAttribute("username",username);
			req.setAttribute("flag", "密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
