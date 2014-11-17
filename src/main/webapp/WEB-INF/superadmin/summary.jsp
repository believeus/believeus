<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Believeus后台管理系统</title>
<link href="/css/superadmin/common.css" rel="stylesheet" type="text/css"/>
<link href="/css/superadmin//new_admin.css" rel="stylesheet" type="text/css"/>

</head>
<body>
	<div class="org_header xiangdui">
		  <div class="org_map l"></div>
		  <div class="usr_info r">你好： <a href="#">${sessionAdmin.adminName}</a> | <a href="/adminLogout.html">赶紧退出</a></div>
	</div>  
	<div class="clear"></div>  
	<h1 class="w-95p">believeus概要信息<span class="r"></span></h1>
	<div class="w-95p  m-auto lh-30 ">
	<ul>
		<li>笑话管理模块
		<a href="/subadminUser.do?act=searchNewUser&fromdate=1">[最新笑话信息]</a>
		<font class="red">
		<c:choose>
				<c:when test="${newCountNum eq null}">0</c:when>
				<c:otherwise>${newCountNum}</c:otherwise>
		</c:choose> 
		</font>条
		<a href="/subadminUser.do?act=searchUser">[查看所有笑话信息]</a></li>
		<li>用户模块管理
		<a href="/subadminBlog.do?act=searchNewBlog&fromdate=1">[新增用户数量]</a>
		<font class="red">	
		<c:choose>
				<c:when test="${newUserNum eq null}">0</c:when>
				<c:otherwise>${newUserNum}</c:otherwise>
		</c:choose> 
		</font>个
		<a href="/subadminBlog.do?act=searchBlog">[查看所有用户信息]</a></li>
	</ul>
	</div>
	<div class="w-95p p-10 m-auto bg-f5 border">
		<h3>联系方式</h3>
		<ul class="w-95p m-auto">
			<li>
				Believeus管理员 QQ:
				<a href="http://wpa.qq.com/msgrd?V=1&amp;Uin=270421298&amp;Site=www.wiz.cn&amp;Menu=yes" target="blank">
				医巫谷人<img alt="点击这里给我发消息" border="0" src="http://wpa.qq.com/pa?p=1:1058633117:4" />1058633117</a> 
				<a href="http://wpa.qq.com/msgrd?V=1&amp;Uin=270421298&amp;Site=www.wiz.cn&amp;Menu=yes" target="blank">
				逆着光迷人的微笑<img alt="点击这里给我发消息" border="0" src="http://wpa.qq.com/pa?p=1:569009496:4" />569009496</a>
			</li>
		</ul>
	</div>
	<script  type="text/javascript" src="/js/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var today = new Date();	
		var mon = today.getMonth()+1;	
		var day = today.getFullYear()+"年,"+mon+"月,"+today.getDate()+"日&nbsp";
		$("span.r").html(day);
	});
</script>
</body>
</html>