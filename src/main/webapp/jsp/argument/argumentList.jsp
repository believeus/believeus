<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.believeus.cn/jstl/html" prefix="html" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- begin :分页css -->
<link href="/css/pagination/pagination.css" rel="stylesheet" type="text/css" media="screen" />
<!-- end :分页css -->

<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>中西之争列表</title>
</head>
<body>
<div>
<div style="position: absolute;width: 1000px;height:1400px;right: 120px;" id="Searchresult">
<c:forEach items="${argumentList }" var="argument" varStatus="s">
<!-- Begin Name:wuqiwei Date:2013-08-14 AddReason:该逻辑是用来对内容框的每行三列的显示 -->
	<c:if test="${s.count ne 1 }">
		<c:if test="${s.count%3 ==1 }">
			<c:set var="top" value="${top+1 }"/>
		</c:if>
	</c:if>
	<c:set var="index" value="${s.index}"/>
<!-- End Name:wuqiwei Date:2013-08-14 AddReason:该逻辑是用来对内容框的每行三列的显示 -->
    <div>
	  <div style="position:absolute; left:${260+((s.index mod 3)*280)}px;top: ${top*350+70 }px;">
		<div><img src="images/signpic/videobg.png" /></div>
		<div style="top:-245px; position: relative; left: 50px; "><a href="/argumentDetail-id-${argument.id}.jhtml" style="color: red;"><html:html value="${argument.title}" num="8"/></a></div>
		<div style="top: -240px; position: relative; left: 30px; font-size: 14px; width: 180px; height: 20px;"><a> <html:html value="${argument.content }" num="100"/></a></div>
	  </div>
  </div>
</c:forEach>  
</div>
<!-- begin Name:wuqiwei Date:2013-08-09 分页标签 -->
<c:if test=""></c:if>
 <div id="content" style="position: relative; top: ${top*350+360 }px; margin-left: 600px">
	<div id="Pagination" class="pagination"/>
		<br style="clear:both;" />
 </div> 
</div>
<!-- end Name:wuqiwei Date:2013-08-09 分页标签 -->
	<!-- begin Name:wuqiwei  data:2013-4-13  分页js -->
	<script type="text/javascript" src="/js/jquery.min.js"></script>
	<script type="text/javascript" src="/js/pagination/jquery.pagination.js"></script>
	<script type="text/javascript" src="/js/pagination/Believeuspagiation.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var count="${argumentCount}";
			var countPerPage=12;
			if(count>countPerPage){
				var believeusPagiation=new BelieveusPagiation('Searchresult','/subArgumentAjaxList',countPerPage,count,"jhtml");
				believeusPagiation.pagiation();
			}
		});
	</script>
	<!-- end Name:wuqiwei  data:2013-4-13  分页js -->
</body>
</html>