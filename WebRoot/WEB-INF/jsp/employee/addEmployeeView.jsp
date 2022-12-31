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
		当前位置：员工管理>添加员工
	</div>
	<form action="addEmployee" method="post">
	<table align="center">
		<tr><td height="100px"></td></tr>
    	<tr>
    		<td>姓名：<input type="text" name="name"></td>
    		<td>身份证号：<input type="text" name="card_id"></td>
    	</tr>
    	<tr>
    		<td>性别：
    			<select name="sex">
    				<option value="0">其他</option>
          			<option value="1">男</option>
          			<option value="2">女</option>
          		</select></td>
    		<td>职位：
    			<select name="job_id">
          			<option value="">请选择职位</option>
          			<c:forEach items="${jobList}" var="job">
          				<option value="${job.id}">${job.name }</option>
          			</c:forEach>
          		</select></td>
    	</tr>
    	<tr>
    		<td>学历：<input type="text" name="education"></td>
    		<td>邮箱：<input type="text" name="email"></td>
    	</tr>
    	<tr>
    		<td>手机：<input type="text" name="phone"></td>
    		<td>电话：<input type="text" name="tel"></td>
    	</tr>
    	<tr>
    		<td>政治面貌：<input type="text" name="party"></td>
    		<td>QQ：<input type="text" name="qq_num"></td>
    	</tr>
    	<tr>
    		<td>联系地址：<input type="text" name="address"></td>
    		<td>邮政编码：<input type="text" name="post_code"></td>
    	</tr>
    	<tr>
    		<td>出生日期：<input type="date" name="birthday"></td>
    		<td>民族：<input type="text" name="race"></td>
    	</tr>
    	<tr>
    		<td>所学专业：<input type="text" name="speciality"></td>
    		<td>爱好：<input type="text" name="hobby"></td>
    	</tr>
    	<tr>
    		<td>备注：<input type="text" name="remark"></td>
    		<td>所属部门：
    			<select name="dept_id">
          			<option value="">请选择部门</option>
          			<c:forEach items="${deptList}" var="dept">
          				<option value="${dept.id}">${dept.name }</option>
          			</c:forEach>
          		</select></td>
    	</tr>
    	<tr>
          <td colspan="2" align="center"><input type="submit">&nbsp;&nbsp;<input type="reset"></td>
        </tr>
    </table>
	</form>
  </body>
</html>
