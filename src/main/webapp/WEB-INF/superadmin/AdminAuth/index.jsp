<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>权限设置管理</title>
<link href="/css/superadmin/new_admin.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<div class="control">
<a title="前进" onclick="history.go(-1);">&lt;</a>
<a title="后退" onclick="history.go(1);">&gt;</a>
</div>
<div class="org_header xiangdui"> <a href="#" class="l"><font style="font-size:30px; color:#999; font-family:'微软雅黑'">权限设置管理</font></a>
  <div class="org_map l"></div>
  <ul class="top_menu juedui">
    <li class="on"><a href="" target="org_main_box">管理员管理</a></li>
    <li><a href="comment_list.html" target="org_main_box">权限管理</a></li>
  </ul>
  <div class="usr_info r">你好：<a href="">${sessionAdmin.adminName}</a> | <a href="/adminLogout.html">紧急退出</a></div>
</div>
<script type="text/javascript" src="/AdminAuth/AdminAuth.nocache.js"></script>
<div class="clear"></div>

<script>
function changeHeight()
{
   var bHeight = $(window).height();
   var toHeight = bHeight-85;
   $(".org_main").css({"height":toHeight+"px"});	
   $("#org_main_box").css({"height":toHeight+"px"});
}
function changemenu(obj)
{
	var n=$(".top_menu li").index($(obj));
   	$(".top_menu li").removeClass("on");
	$(".top_menu li").eq(n).addClass("on");
}
$(function(){
   	changeHeight();
	$(window).resize(function(){changeHeight();});
	$(".top_menu li").click(function(){changemenu(this);});
});
</script>
</body>
</html>
