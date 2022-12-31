<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
  body {
    background-image: url("images/bj.jpg");
	background-repeat: no-repeat;
	width:100%;
  	height:100%;
  	position:fixed;
  	background-size:100% 100%;
}
  </style>
  <body>
    <form name="f1" id="f1" action="" method="post">
      <table border="0" align="center">
      	<tr height="300px"></tr>
      	<tr style=color:red><td>${msg}</td></tr>
        <tr>
          <td>登入名:</td>
          <td><input type="text" name="loginname"></td>
        </tr>
        <tr>
          <td>密码:</td>
          <td><input type="password" name="password"></td>
        </tr> 
        <tr>
          <td colspan="2" align="center"><input type="submit"></td>
        </tr>
      </table>
    </form>
  </body>
</html>
