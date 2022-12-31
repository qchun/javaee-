<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		当前位置：用户管理>用户修改
	</div>
	<form action="updateUser" method="post">
	<table align="center">
		<tr>
			<td height="100px"></td>
			<td><input type="hidden" name="id" value="${requestScope.user.id}"></td>
		</tr>
    	<tr>
    		<td>登入名：</td>
    		<td><input type="text" name="loginname" value="${requestScope.user.loginname}"></td>
    	</tr>
    	<tr>
    		<td>密码：</td>
    		<td><input type="password" name="password" value="${requestScope.user.password}"></td>
    	</tr>
    	<tr>
    		<td>状态：</td>
    		<td>
				<input type="radio" name="status" value="1" <c:if test="${requestScope.user.status==1 }">checked="checked"</c:if>>未审核</input>
    			<input type="radio" name="status" value="2" <c:if test="${requestScope.user.status==2 }">checked="checked"</c:if>>已审核</input>
          	</td>
    	</tr>
    	<tr>
    		<td>用户名：</td>
    		<td><input type="text" name="username" value="${requestScope.user.username}"></td>
    	</tr>
    	<tr>
          <td colspan="2" align="center"><input type="submit">&nbsp;&nbsp;<input type="reset"></td>
        </tr>
    </table>
	</form>
  </body>
</html>
