<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<link rel="stylesheet" type="text/css" href="view/css/img.css">
<script type="text/javascript">

</script>

  </head>
<%
String tmp=(String)request.getAttribute("tmp");
String tmpString="";
if(tmp=="0"){
tmpString="下载失败";
}
else if(tmp=="1"){
tmpString="下载成功";
}else{
tmpString="";
}
 %>
  <body>
    <form action="ShowImgManager" method="post" accept-charset="utf-8">
	<div id="main">
		<div id="img">
			<img src="view/picture/1.jpg" alt="萌妹" name="img1a">
		</div>
		<br>
			<span id="span1"><input type="submit" value="下载"></span>
			<br>
		<br>
		<span><%=tmpString%></span>
		</div>
		
		
	</form>
  </body>
</html>
