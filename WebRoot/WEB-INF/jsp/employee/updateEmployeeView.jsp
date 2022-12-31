<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		当前位置：员工管理>员工修改
	</div>
	<form action="updateEmployee" method="post">
	<table align="center">
		<tr>
			<td height="100px"></td>
			<td><input type="hidden" name="id" value="${requestScope.employee.id}"></td>
		</tr>
    	<tr>
    		<td>姓名：<input type="text" name="name" value="${requestScope.employee.name}"></td>
    		<td>身份证号：<input type="text" name="card_id" value="${requestScope.employee.name}"></td>
    	</tr>
    	<tr>
    		<td>性别：
    			<select name="sex">
    				<option value="0" <c:if test="${requestScope.employee.sex==0 }">selected</c:if>>其他</option>
          			<option value="1" <c:if test="${requestScope.employee.sex==1 }">selected</c:if>>男</option>
          			<option value="2" <c:if test="${requestScope.employee.sex==2 }">selected</c:if>>女</option>
          		</select></td>
    		<td>职位：
    			<select name="job_id">
          			<option value="">请选择职位</option>
          			<c:forEach items="${jobList}" var="job">
          				<option value="${job.id}" <c:if test="${requestScope.employee.job_id==job.id }">selected</c:if>>${job.name }</option>
          			</c:forEach>
          		</select></td>
    	</tr>
    	<tr>
    		<td>学历：<input type="text" name="education" value="${requestScope.employee.name}"></td>
    		<td>邮箱：<input type="text" name="email" value="${requestScope.employee.email}"></td>
    	</tr>
    	<tr>
    		<td>手机：<input type="text" name="phone" value="${requestScope.employee.phone}"></td>
    		<td>电话：<input type="text" name="tel" value="${requestScope.employee.tel}"></td>
    	</tr>
    	<tr>
    		<td>政治面貌：<input type="text" name="party" value="${requestScope.employee.party}"></td>
    		<td>QQ：<input type="text" name="qq_num" value="${requestScope.employee.qq_num}"></td>
    	</tr>
    	<tr>
    		<td>联系地址：<input type="text" name="address" value="${requestScope.employee.address}"></td>
    		<td>邮政编码：<input type="text" name="post_code" value="${requestScope.employee.post_code}"></td>
    	</tr>
    	<tr>
    		<td>出生日期：<input type="date" name="birthday" value="<fmt:formatDate value="${requestScope.employee.birthday}" pattern="yyyy-MM-dd"/>"/></td>
    		<td>民族：<input type="text" name="race" value="${requestScope.employee.race}"></td>
    	</tr>
    	<tr>
    		<td>所学专业：<input type="text" name="speciality" value="${requestScope.employee.speciality}"></td>
    		<td>爱好：<input type="text" name="hobby" value="${requestScope.employee.hobby}"></td>
    	</tr>
    	<tr>
    		<td>备注：<input type="text" name="remark" value="${requestScope.employee.remark}"></td>
    		<td>所属部门：
    			<select name="dept_id">
          			<option value="">请选择部门</option>
          			<c:forEach items="${deptList}" var="dept">
          				<option value="${dept.id}" <c:if test="${requestScope.employee.dept_id==dept.id }">selected</c:if>>${dept.name }</option>
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
