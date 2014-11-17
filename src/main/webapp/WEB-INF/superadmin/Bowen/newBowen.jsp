<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<link href="/css/superadmin/common.css" rel="stylesheet" type="text/css"/>
<title>新建/编辑博文</title>
</head>
<body>
	<h5 class="w-95p">新建/编辑博文</h5>
	<div class="w-95p  p-10 m-auto lh-30 m-t-10">
	<form id="bowenform" method="post" action="/adminSaveNewBowen.html">
		<input type="hidden" name="Jid" value="${Jid}"/>
		<input type="hidden" name="refererURL" value="${refererURL}"/>
		<ul>
			<li><b>名称</b> <input type="text" class="txt" name="title" value="${bowen.title}"/></li>
		</ul>
		<ul class="limb">
			<li><b>博文内容</b> <textarea name="editorValue" id="editbowen">${bowen.content }</textarea>
		</li>
		</ul>
			<ul id="addbox"></ul>
		<ul>
			<li><input type="submit" value="确定" class="btn" /></li>
		</ul>
	</form>
	</div>
	<div class="clear"></div>
	<script type="text/javascript" src="/ueditor/editor_config.js"></script>
	<script type="text/javascript" src="/ueditor/editor_all.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
    	var editor = new UE.ui.Editor();
     	editor.render("editbowen");
	});
	</script> 
</body>
</html>
