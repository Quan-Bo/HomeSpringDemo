<%@page import="com.Bean.UserBean"%>
<%@ page language="java" import="java.util.*,com.Dao.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			UserBean user=(UserBean)request.getAttribute("user");
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
	<script type="text/javascript">
	function return_ShowUser() {
	window.history.back(-1);
}
	</script>

</head>

<body>
  <div class="div_main_background">
<!-- 透明区域 -->
  <div class="div_min">
    <div class="div_mean">
     <center>
     	 <form role="form" action="UpdateUser1" method="get">
      <div class="form-group div_group">
         <label for="name" class="control-label form_lb_1"> title:</label>
         <input type="text" class="form-control form_ip_1" name="title" value="<%=user.getTitle()%>">
      </div>
      <div class="form-group div_group">
         <label for="name" class="control-label form_lb_1">description:</label>
         <input type="text" class="form-control form_ip_1" name="description" id="name" value="<%=user.getDescription()%>">
      </div>
        <div class="form-group div_group">
         <label for="name" class="control-label form_lb_1">language:</label>
         <select name="language" class="form-control form_select">
          <%for(UserBean user1:list){
          %>
            
		   <option value="<%=user1.getLanguage_id()%>" 
		   <%if(user1.getLanguage_id()==user.getLanguage_id()) {%>selected = "selected"<%}%> 
		    ><%=user1.getName()%></option>
		   <%}%>
		</select> 
      </div>
      <div class="form-group div_group">
      <input type="submit" class="btn btn-danger btn-lg rg-4" value="提交">
      <button  class="btn btn-danger btn-lg rg-4" onclick="return_ShowUser()">返回</button>
      </div>
     </form>
   </center>
    </div>
  </div>
  </div>
  <script src=".public/JS/Update.js"></script>
</body>
</html>
