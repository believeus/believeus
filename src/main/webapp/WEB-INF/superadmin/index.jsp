<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Believeus管理系统</title>
<script  type="text/javascript" src="/js/jquery.min.js"></script>
<style>
html{ overflow-y:hidden}
body{ margin:0; padding:0; text-align:center}
h1{ width:100%; text-align:center;  margin-top:20px; margin-bottom:20px;}
h1 a{font-size:26px; color:#333; font-family:"微软雅黑"; text-decoration:none; font-weight:normal;}
h1 a b{font-size:30px; font-family:Arial, Helvetica, sans-serif; color:#06C;}
.leftbar{ width:12%; height:auto; background:#f5f5f5; border-right:1px solid #ddd; overflow:auto}
.main{ width:87%;}
.l{ float:left}
.r{ float:right}
.nav{ width:100%;height:700px; margin:0; padding:0; text-align:center}
.nav li{ list-style:none; line-height:25px; font-size:12px; }
.nav li a{ font-family:"宋体";text-decoration:none; color:#666; width:100%; height:25px; display:block}
.nav li a.on,.nav li a:hover{ background:#E6F2FF; color:#06C}
</style>
</head>
<body>

<div class="leftbar l">
<h1><a href="http://www.believeus.cn/" target="_blank"><b>Believeus</b></a><br/></h1>
<h3 style="margin-right:60px; margin-top:-20px;">后台管理</h3>
<ul class="nav" id="navbar">
  <li><a id="AdminSummary" href="/adminSummary.html" target="mainbox">后台信息概要</a></li>
  <li><a id="AdminAuth" href="/adminAuth.jhtml" target="mainbox">权限设置管理</a></li>  
  <li><a id="AdminUser" href="/adminUser.html" target="mainbox">用户模块管理</a></li>  
  <li><a id="AdminBowen" href="/adminBowenList.html" target="mainbox">中医博文管理</a></li>
  <li><a id="AdminCases" href="/adminCasesIndex.jhtml" target="mainbox">中医医案管理</a></li>
  <li><a id="AdminYaoShan" href="/adminYaoShanIndex.jhtml" target="mainbox">中医药膳管理</a></li>
  <li><a id="AdminArgument" href="/adminArgumentIndex.jhtml" target="mainbox">中西之争管理</a></li>
</ul>
</div>
<div class="main r">
<iframe src="/adminWelcom.html" name="mainbox" width="100%" height="680px" frameborder="0" scrolling="auto"></iframe> 
</div>
</body>
</html>
