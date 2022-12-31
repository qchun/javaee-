<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		当前位置：职位管理>职位查询
	</div>
    <form id="f1" action="selectJob" method="post">
    	<table border="0" cellspacing="0" cellpadding="0" width="80%" height="50px">
        	<tr>
        		<td><input type="hidden" name="pageNow" id="pageNow"></td>
          		<td>职位:<input type="text" name="name" value="${requestScope.job.name }">
          		<input type="submit" value="搜索"></td>
        	</tr>
		</table>
    </form>
    <form action="deleteJobs" method="post">
	<table border="1" cellspacing="0" cellpadding="0" width="80%">
		<tr align="center" height="30px">
			<td>
				全选<input type="checkbox" id="qx" onclick="checkAll(this)"/>
				<input type="submit" value="删除" onclick="javascript:return confirm('确认删除这些职位吗？');"/>
			</td>
			<td>职位</td>
			<td>remark</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.jobList}" var="jl">
			<tr align="center" height="30px">
				<td><input type="checkbox" name="ids" value="${jl.id }"/></td>
				<td>${jl.name }</td>
				<td>${jl.remark }</td>
				<td>
					<a href="updateJobView?id=${jl.id}">修改</a>&nbsp;&nbsp;&nbsp;
					<a href="deleteJob?id=${jl.id}" onclick="javascript:return a();">删除</a>
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
