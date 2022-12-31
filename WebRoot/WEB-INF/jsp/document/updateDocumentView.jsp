<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		当前位置：下载中心>文档修改
	</div>
	<form:form action="updateDocument" method="post" commandName="document" enctype="multipart/form-data">
	<table align="center">
		<tr>
			<td height="100px"></td>
			<td><form:hidden path="id"/></td>
		</tr>
    	<tr>
    		<td>文档标题：</td>
    		<td><form:input path="title"/></td>
    	</tr>
    	<tr>
    		<td>文档描述：</td>
    		<td><form:textarea path="remark" rows="5" cols="80"/></td>
    	</tr>
    	<tr>
    		<td>选择文件：</td>
    		<td><input type="hidden" value="${document.filename }" name="f"/>原文件：${document.filename }&nbsp;&nbsp;&nbsp;<input type="file" name="file"/></td>
    	</tr>
    	<tr>
          <td colspan="2" align="center"><input type="submit">&nbsp;&nbsp;<input type="reset"></td>
        </tr>
    </table>
	</form:form>
  </body>
</html>
