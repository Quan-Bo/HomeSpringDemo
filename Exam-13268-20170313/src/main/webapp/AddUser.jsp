<%@page import="com.Bean.UserBean"%>
<%@ page language="java" import="java.util.*,com.Dao.UserDao" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
   List<UserBean> list=UserDao.get_lanager();
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
	<link rel="stylesheet" type="text/css" href="public/CSS/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="public/CSS/ShowUser.css">

</head>

<body>
  <div class="div_main_background">
<!-- 透明区域 -->
  <div class="div_min">
    <div class="div_mean">
     <center>
     	 <form role="form" action="AddUserServlet" method="post">
      <div class="form-group div_group">
         <label for="name" class="control-label form_lb_1"> title:</label>
         <input type="text" class="form-control form_ip_1" name="title" placeholder="请输入 title" >
      </div>
      <div class="form-group div_group">
         <label for="name" class="control-label form_lb_1">description:</label>
         <input type="text" class="form-control form_ip_1" name="description" id="name" placeholder="请输入description">
      </div>
        <div class="form-group div_group">
         <label for="name" class="control-label form_lb_1">language:</label>
         <select name="language" class="form-control form_select">
          <%for(UserBean user:list){%>
		   <option value="<%=user.getLanguage_id()%>"><%=user.getName()%></option>
		   <%}%>
		</select> 
      </div>
      <div class="form-group div_group">
      <input type="submit" class="btn btn-danger btn-lg" value="提交">
      <input type="reset" value="重置" class="btn btn-danger btn-lg"
		                style="margin-left:100px;">
      </div>
     </form>
   </center>
    </div>
  </div>
  </div>
</body>
</html>
