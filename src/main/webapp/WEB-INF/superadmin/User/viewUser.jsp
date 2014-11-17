<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.believeus.cn/jstl/date" prefix="date" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<link href="/css/superadmin/common.css" rel="stylesheet" />
<!--Begin name:wuqiwei Date:2013-10-28 21:17:40 AddReason:加入easyui的支持  -->
<script type="text/javascript" src="/js/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.3.4/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.3.4/themes/icon.css"/>
<!--End name:wuqiwei Date:2013-10-28 21:17:40 AddReason:加入easyui的支持  -->
<title>用户信息</title>
</head>

<body>
	<h1 class="w-95p">用户管理</h1>
	<h3 class="nav w-95p">
	</h3>


	<h5 class="w-95p">
		<span class="r"><a href="adminUser.html">&lt;&lt;返回用户列表</a></span>查看用户
	</h5>
	
	<div class="w-95p bg-f5 p-10 m-auto lh-30 m-t-10">
		<form action="/adminApply-uid-${user.id}.html"  method="post">
			<a href="#" class="l"><img class="border w-100 h-100" src="${user.headImg }" /></a>
			<div class="r w-80p">
				<b>用户名：</b>${user.nickName} <br />
				<b>性别：</b>${user.sex } <br />
				<b>注册日期:</b><date:date parttern="yyyy-MM-dd HH:mm:ss" value="${user.regTime}"/><br />
				<b>上次登录时间:</b><date:date parttern="yyyy-MM-dd HH:mm:ss" value="${user.lastLoginTime}"/><br />
				<b>管理员编辑时间:</b><date:date parttern="yyyy-MM-dd HH:mm:ss" value="${user.adminEditDate}"/><br />
				<b>邮箱：</b>${user.email} <a href="/adminMail.html">发邮件</a> <br />
				<b>用户状态：</b> 
				<c:choose>
				  <c:when test="${user.status eq 0}"><font color="#15A230">正常</font></c:when>
				  <c:otherwise><font color="red">封禁</font></c:otherwise>
				</c:choose>
				<br />
				<b>管理员申请状态:</b>
				<c:choose>
					<c:when test="${user.applyStatus eq 0}"><font color="green">一般用户</font></c:when>
					<c:when test="${user.applyStatus eq 1}"><font color="green">推荐成为管理员</font></c:when>
					<c:when test="${user.applyStatus eq 2}"><font color="green">用户提交担任管理员申请</font></c:when>
					<c:when test="${user.applyStatus eq 3}"><font color="green">believeus管理员</font></c:when>
				</c:choose><br />
				<b>管理员申请设置:</b>
				 <select class="easyui-combobox" name="applyStatus" style="width:150px;height:30px;">
				 	<c:choose>
				 		<c:when test="${user.applyStatus == 0}">
				 			<option value="1">推荐成为管理员</option>
				 		</c:when>
				 		<c:when test="${user.applyStatus == 1}">
				 			<option value="0">恢复成普通用户</option>
				 		</c:when>
				 		<c:when test="${user.applyStatus == 2}">
				 			<option value="0">恢复成普通用户</option>				  	
				  			<option value="3">成为believeus管理员</option>
				 		</c:when>
				 		<c:when test="${user.applyStatus == 3}">
				 			<option value="0">恢复成普通用户</option>
				 		</c:when>
				 	</c:choose>
				 </select><br />
				<input type="submit"  value="提交设置" class="btn" />
			</div>
			<div class="clear"></div>
		</form>
	</div>
	<div class="clear"></div>
</body>
</html>