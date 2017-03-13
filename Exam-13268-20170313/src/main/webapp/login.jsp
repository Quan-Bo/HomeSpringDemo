<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="./view//bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="view/css/b_login.css">
	<title>后台登录页面</title>
  </head>
<%  
String error = (String)request.getAttribute("flag");
String username=(String)request.getAttribute("username");
if(error==null){
error="";
}
if(username==null){
username="";
}
%> 
  <body>
   <div class="login">
	<div class="loginmain">
		<h2> <label class="col-lg-1 control-label"></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录管理系统</h2>
			<form action="LoginServlet" class="form-horizontal" method="post">
		           <!-- 让表单在一行中显示form-horizontal -->
		             <div class="form-group"></div>
		          <div class="form-group">
		              <label for="username" class="col-lg-1 control-label"></label>
		              <div class="col-lg-4">
		                <input type="text" name="username" id="username" onfocus="ClealText()" class="form-control">
		              </div>              
		          </div>

				  <div class="form-group">
				  <span class="text" id="text"><%=error%></span></div>
				   <div class="form-group"></div>
				   
		           <div class="form-group"></div>
                   <div class="form-group"></div>
                   

		          <div class="form-group">
		            <div class="col-lg-4 col-lg-offset-1">
		                <input type="submit" name="button" value="登录" class="btn btn-danger btn-lg">   
		            </div>
		          </div>
		    </form>

	</div>
	<div class="rightpic">
		<div id="container"></div>
	</div>
</div>
<script src="./view/public/js/jquery-3.1.1.min.js"></script>
<script src="./view/bootstrap/js/bootstrap.min.js"></script>
<script src="./view//public/js/delaunay.js"></script>
<script src="./view//public/js/TweenMax.js"></script>
<script src="view/js/effect.js"></script>
  </body>
</html>
