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
    
    <title>My JSP 'user_select.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  	function a(){
  		var msg = "您真的确定要删除吗？\n\n请确认！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
  	}
  	window.onload = function() {
		var x = document.getElementsByName("ids");
		var qx = document.getElementById("qx");
		qx.onclick = function() {          
			for (var i = 0; i < x.length; i++) {
				x[i].checked = this.checked;
			}
		}
		for (var i = 0; i < x.length; i++) {
			x[i].onclick = function() {
				var number = 0;
				for (var j = 0; j < x.length; j++) {
					if (x[j].checked) {
						number++;
					}
				}
				document.getElementById("qx").checked = (x.length == number);
			}
		}
	}
	function f(pn){
		document.getElementById("pageNow").value=pn;
		document.getElementById("f1").submit();
	}
  </script>
  <body>
  	<div Style="background-image:url(images/main_locbg.gif);height:32px">
		&nbsp;&nbsp;&nbsp;<img src="images/pointer.gif" align="middle">
		当前位置：员工管理>员工查询
	</div>
    <form id="f1" action="selectEmployee" method="post">
    	<table border="0" cellspacing="0" cellpadding="0" width="100%" height="50px">
        	<tr>
        		<td><input type="hidden" name="pageNow" id="pageNow">
          		职位：
          		<select name="job_id">
          			<option value="">请选择职位</option>
          			<c:forEach items="${jobList}" var="job">
          				<option value="${job.id}" <c:if test="${requestScope.employee.job_id==job.id }">selected</c:if>>${job.name }</option>
          			</c:forEach>
          		</select></td>
          		<td>姓名：<input type="text" name="name" value="${requestScope.employee.name }"></td>
          		<td>身份证号码：<input type="text" name="card_id" value="${requestScope.employee.card_id }"></td>
        	</tr>
        	<tr>
        		<td>性别：
        		<select name="sex">
          			<option value="">请选择性别</option>
          			<option value="1" <c:if test="${requestScope.employee.sex==1 }">selected</c:if>>男</option>
          			<option value="2" <c:if test="${requestScope.employee.sex==2 }">selected</c:if>>女</option>
          		</select></td>
          		<td>手机：<input type="text" name="phone" value="${requestScope.employee.phone }"></td>
          		<td>所属部门：
				<select name="dept_id">
          			<option value="">请选择部门</option>
          			<c:forEach items="${deptList}" var="dept">
          				<option value="${dept.id}" <c:if test="${requestScope.employee.dept_id==dept.id }">selected</c:if>>${dept.name }</option>
          			</c:forEach>
          		</select>
          		<input type="submit" value="搜索"></td>
        	</tr>
		</table>
    </form>
    <form action="deleteEmployees" method="post">
	<table border="1" cellspacing="0" cellpadding="0" width="100%">
		<tr align="center" height="30px">
			<td>
				全选<input type="checkbox" id="qx" onclick="checkAll(this)"/>
				<input type="submit" value="删除" onclick="javascript:return confirm('确认删除这些员工吗？');"/>
			</td>
			<td>姓名</td>
			<td>性别</td>
			<td>手机号码</td>
			<td>邮箱</td>
			<td>职位</td>
			<td>学历</td>
			<td>身份证号码</td>
			<td>部门</td>
			<td>联系地址</td>
			<td>建档日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.employeeList}" var="el">
			<tr align="center" height="30px">
				<td><input type="checkbox" name="ids" value="${el.id }"/></td>
				<td>${el.name }</td>
				<td><c:if test="${el.sex==0 }">其他</c:if>
				<c:if test="${el.sex==1 }">男</c:if>
				<c:if test="${el.sex==2 }">女</c:if></td>
				<td>${el.phone }</td>
				<td>${el.email }</td>
				<td>${el.job.name }</td>
				<td>${el.education }</td>
				<td>${el.card_id }</td>
				<td>${el.dept.name }</td>
				<td>${el.address }</td>
				<td><fmt:formatDate value="${el.create_date }" pattern="yyyy年MM月dd日 hh:mm:ss"/></td>
				<td>
					<a href="updateEmployeeView?id=${el.id}">修改</a>&nbsp;&nbsp;&nbsp;
					<a href="deleteEmployee?id=${el.id}" onclick="javascript:return a();">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</form>
	<table border="1" cellspacing="0" cellpadding="0" width="80%">
		<tr align="center">
			<td><a <c:if test="${requestScope.pm.hasFirst }"> href="javascript:f(1);" </c:if>
				<c:if test="${requestScope.pm.hasFirst==false }"> onclick="javascript:return alert('已经是首页');" </c:if>>首页</a></td>
			<td><a <c:if test="${requestScope.pm.hasPre }"> href="javascript:f(${requestScope.pm.pageNow-1 });" </c:if>
				<c:if test="${requestScope.pm.hasPre==false }"> onclick="javascript:return alert('已经是首页,没有上一页');" </c:if>>上一页</a></td>
			<td><a <c:if test="${requestScope.pm.hasNext }"> href="javascript:f(${requestScope.pm.pageNow+1 });" </c:if>
				<c:if test="${requestScope.pm.hasNext==false }"> onclick="javascript:return alert('已经是尾页,没有下一页');" </c:if>>下一页</a></td>
			<td><a <c:if test="${requestScope.pm.hasLast }"> href="javascript:f(${requestScope.pm.totalPage });"</c:if>
				<c:if test="${requestScope.pm.hasLast==false }"> onclick="javascript:return alert('已经是尾页');"</c:if>>尾页</a></td>
			<td><c:forEach begin="1" end="${requestScope.pm.totalPage}" var="i"><a href="javascript:f(${i })">&nbsp;${i }</a></c:forEach></td>
		</tr>
	</table>
  </body>
</html>
