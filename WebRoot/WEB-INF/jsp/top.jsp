<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div Style="background-image:url(images/topbg.gif)">
  	<img src="images/top_logo.gif" align="left">
  	<div align="right" style="height:75%">
  		<img src="images/top_home.gif"><a href="right" target="main">网站首页</a>&nbsp;
  		<img src="images/top_exit.gif"><a href="login?method=Logout" target="index">注销退出</a>&nbsp;&nbsp;&nbsp;
  	</div>
  	<div align="center" style="height:30%">
  		<img src="images/StatBar_admin.gif">当前用户【${sessionScope.user.loginname }（${sessionScope.user.username }）】
  	</div>
  </div>
  </body>
</html>
