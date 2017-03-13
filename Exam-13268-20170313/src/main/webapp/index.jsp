<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			String error=(String)request.getAttribute("falgErrot");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'AddUser.jsp' starting page</title>

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
		<span><% %></span>
		<div class="div_min">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="login.jsp">用户登录</a></li>
				<li><a href="ShowUser.jsp">列 表 显 示 </a></li>
				<li><a href="AddUser.jsp">新增界面</a></li>
				</ul>
		</div>  
  </div>
</body>
</html>
