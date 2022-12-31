<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  	<div>
  		<div Style="background-image:url(images/main_locbg.gif);height:32px">
			&nbsp;&nbsp;&nbsp;<img src="images/pointer.gif" align="middle">
			当前位置：后台管理>当前用户
		</div>
  		<div>
			<table width="100%" height="50%">
				<tr>
					<td width="15%"></td>
					<td>用户姓名:${sessionScope.user.loginname }</td>
				</tr>
				<tr>
					<td width="15%"></td>
					<td>用户状态:
					<c:if test="${sessionScope.user.status==1 }">未审核</c:if>
					<c:if test="${sessionScope.user.status==2 }">已审核</c:if></td>
				</tr>
				<tr>
					<td width="15%"></td>
					<td>创建时间:
					<fmt:formatDate value="${sessionScope.user.createdate }" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
			</table>
		</div>
  	</div>
  </body>
 </html>