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
    <table width="100%" height="100%">
    	<tr align="center">
    		<td background="images/left_nav_closed.gif">用户管理</td>
    	</tr>
    	<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="selectUser" target="main">用户查询</a></td>
		</tr>
		<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="addUserView" target="main">添加用户</td>
		</tr>
		<tr align="center">
    		<td background="images/left_nav_closed.gif">部门管理</td>
    	</tr>
    	<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="selectDept" target="main">部门查询</td>
		</tr>
		<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="addDeptView" target="main">添加部门</td>
		</tr>
		<tr align="center">
    		<td background="images/left_nav_closed.gif">职位管理</td>
    	</tr>
    	<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="selectJob" target="main">职位查询</td>
		</tr>
		<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="addJobView" target="main">添加职位</td>
		</tr>
		<tr align="center">
    		<td background="images/left_nav_closed.gif">员工管理</td>
    	</tr>
    	<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="selectEmployee" target="main">员工查询</td>
		</tr>
		<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="addEmployeeView" target="main">添加员工</td>
		</tr>
		<tr align="center">
    		<td background="images/left_nav_closed.gif">公告管理</td>
    	</tr>
    	<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="selectNotice" target="main">公告查询</td>
		</tr>
		<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="addNoticeView" target="main">添加公告</td>
		</tr>
		<tr align="center">
    		<td background="images/left_nav_closed.gif">下载中心</td>
    	</tr>
    	<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="selectDocument" target="main">文档查询</td>
		</tr>
		<tr align="center">
			<td><img src="images/left_nav_arrow.gif"><a href="addDocumentView" target="main">上传文档</td>
		</tr>
    </table>
  </body>
</html>
