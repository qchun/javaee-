<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUserView.jsp' starting page</title>
    
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
  <div Style="background-image:url(images/main_locbg.gif);height:32px">
		&nbsp;&nbsp;&nbsp;<img src="images/pointer.gif" align="middle">
		当前位置：职位管理>添加职位
	</div>
	<form action="addJob" method="post">
	<table align="center">
		<tr><td height="100px"></td></tr>
    	<tr>
    		<td>职位：</td>
    		<td><input type="text" name="name"></td>
    	</tr>
    	<tr>
    		<td>备注：</td>
    		<td><input type="text" name="remark"></td>
    	</tr>
    	<tr>
          <td colspan="2" align="center"><input type="submit">&nbsp;&nbsp;<input type="reset"></td>
        </tr>
    </table>
	</form>
  </body>
</html>