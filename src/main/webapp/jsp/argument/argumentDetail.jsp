<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.believeus.cn/jstl/date" prefix="date"%>
<%@ taglib uri="http://www.believeus.cn/jstl/html" prefix="html" %>
<head>
<link href="/css/superadmin/common.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中医医案</title>
</head>

<body>
		<h5 class="w-95p">
		</h5>	
		<div class="w-95p  p-10 m-auto lh-30 m-t-10">
			<ul>
				  <li><b>中医之争模块</b></li>
				  <li><b>编辑时间</b> <date:date value="${argument.editDate }" parttern="yyyy-MM-dd HH:mm:ss E"/></li>
				  <li><b>发布人</b>${argument.author }</li>
				  <li><b>博文标题</b>
				  		${argument.title}
				  </li>
				  <li><b>博文内容</b>	<span style="position: relative;left: 550px;"><a href="javascript:history.go(-1);" style="color: green; font-size: 15px;">返回</a></span>
				  <div style="width:80%; height:auto; clear:both; background:#f5f5f5; border:3px solid #CCC;padding:20px; overflow:hidden">					  	
						<p><html:html num="${fn:length(argument.content) }" value="${argument.content}"/></p>
				  </div>
				  </li>	
			</ul>
		</div>		
		<div class="clear"></div>
		
<script  type="text/javascript" src="/js/jquery.min.js"></script>
</body>
</html>