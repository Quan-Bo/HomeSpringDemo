<%@page import="com.Bean.UserBean"%>
<%@ page language="java" import="java.util.*,com.Dao.UserDao"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<UserBean> list=UserDao.get_AllUser();
	String error=(String)request.getAttribute("error");
	if(error==null){
	    error="";
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="public/CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="public/CSS/ShowUser.css">
</head>

<body>
	<div class="div_main_background">
		<!-- 透明区域 -->
		<div class="div_min">
			<center>
			<span><%=error%></span>
				<table class="table table-hover table-bordered tb table-striped">
					<caption>显示数据</caption>
					<thead>
						<tr>
							<th>film_id</th>
							<th>title</th>
							<th>description</th>
							<th>name</th>
							<th>编辑</th>
							<th>删除</th>

						</tr>
					</thead>
					<tbody>
						<%for(UserBean user:list){ %>
						<tr>
							<td><%=user.getFilm_id() %></td>
							<td><%=user.getTitle()%></td>
							<td><%=user.getDescription()%></td>
							<td><%=user.getName()%></td>
							<td><a href="UpdateUserServlet?flag=1&id=<%=user.getFilm_id()%>">编辑</a></td>
							<td><a href="DeleteUserServlet?id=<%=user.getFilm_id()%>">删除</a></td>
						</tr>
						<%}%>
					</tbody>
				</table>
			</center>
		</div>
	</div>
</body>
</html>
