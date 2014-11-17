<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.believeus.cn/jstl/html" prefix="html" %>

<!-- begin Name:wuqiwei Date:2013-4-13 这是自定义的标签库，使用来将long类型转换成时间的 -->
<%@ taglib uri="http://www.believeus.cn/jstl/date" prefix="date"%>
<!-- end Name:wuqiwei Date:2013-4-13 这是自定义的标签库，使用来将long类型转换成时间的 -->
<head>

<title>中医医案管理</title>
<link href="/css/superadmin/new_admin.css" rel="stylesheet" type="text/css" />
<link href="/css/alertBox/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />

<!-- begin :分页css -->
<link href="/css/pagination/pagination.css" rel="stylesheet" type="text/css" media="screen" />
<!-- end :分页css -->
</head>
<body>
	<table class="tableborder">
		<tr>
			<td colspan="10" style="text-align:left; text-indent:1em">
				<form id="alertform" name="alertform" method="post" action="">
					<font style="color: green; font-size: 20px;">文章搜索：</font> 标题:<span>
					<input type="text" size=13 name="title" /></span> 内容:<span>
					<input type="text" name="content" /></span> 发布人:<span>
					<input type="text" name="issueName" /></span> 状态:
					<span>
						<select id="status" name="status">
							<option value="">全部</option>
							<option value="0">正常</option>
							<option value="1">封禁</option>
						</select> 
					</span> 
					<span>
						<input type="submit" id="submit" value="提交" /> <input type="reset" id="reset" value="重置" />
					</span>
				</form>
			</td>
		</tr>
	</table>
	<form action="" method="post">
	<!-- 分页的显示区 -->
	<div id="Searchresult">
	<!-- 分页的显示区 -->
	 	<table class="tableborder" border="0" id="tbody">
	 		<tr class=header>
			<td colspan="11" style="text-align:left;">
			<a href="/adminNewArgumentView.jhtml"><font style="font-size: 15px;">新建文章</font></a>
				<span class="r">搜索结果：<b></b>个
			</span> <span><a href="">全部文章信息</a><b>${argumentCount}</b>个 <a href="">封禁</a><b>2000</b>个
			</span></td>
		</tr>
		<tr>
			<th>文章编号</th>
			<th>标题</th>
			<th>发布人</th>
			<th>文章内容</th>
			<th>发布时间</th>
			<th>状态</th>
			<th>编辑</th>
		</tr>
			<c:forEach items="${argumentList}" var="argument" varStatus="status">
			<!-- Begin Name:wuqiwei Date 2013-4-17 21:10:13 addReason:奇偶行变色 -->
				<c:choose>
					<c:when test="${(status.index % 2) eq 0 }">
						<c:set var="backgroundColor" value="#E6E6E6"/>
					</c:when>
					<c:otherwise>
						<c:set var="backgroundColor" value="#FFFFFF"/>
					</c:otherwise>
				</c:choose>
				<!-- Begin Name:wuqiwei Date 2013-4-17 21:10:13 addReason:奇偶行变色 -->
				<tr id="_Item_Index_1" align="left" style="max-height: 50px; background-color: ${backgroundColor}">
					<td style="text-align: left;width: 80px;"> 
						<input type="checkbox" name="infoIds" value="${argument.id}" />
						<label>${argument.id}</label>
					</td>
					<td style="text-align: left; max-width: 50px;">
							<a title="${argument.title}" href="">${argument.title }</a>
					</td>
					<td>
						${argument.author }
					</td>
					<td style="max-width: 100px; text-align:left; max-height: 50px;">
						<a href="/adminBowenDetail-Jid-${argument.id}.html" >
							<html:html num="45" value="${argument.content }"></html:html>
						</a>
					</td>
					<td style="max-width: 60px; text-align: left; text-align:justify;">

						<!-- begin Name:wuqiwei Date:2013-4-13 这是自定义的标签库，使用来将long类型转换成时间的 -->
						<date:date value="${argument.editDate }" parttern="yyyy-MM-dd HH:mm:ss E" />
						<!-- begin Name:wuqiwei Date:2013-4-13 这是自定义的标签库，使用来将long类型转换成时间的 -->
					</td>
					<td id="baz1Item877">
						<c:choose>
							<c:when test="${argument.status eq 0 }"><font color="green">正常</font></c:when>
							<c:when test="${argument.status eq 1 }"><font color="red">封禁</font></c:when>
							<c:when test="${argument.status eq 2 }"><font color="yellow">推荐</font></c:when>
						</c:choose>
					</td>
					<td>
						<a href="/adminArgumentEdit-id-${argument.id}-currpage-${currentPage}.jhtml">编辑</a>|
						<a name="confirm_button" style="cursor: pointer; color: red;" url="/adminDeleteArgument-id-${argument.id}-currPage-${currentPage}.jhtml">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	<table>
		<tr>
			<td colspan="10">
				<form id="opsform" name="opsform" action="" method="post">
					<input type="button" class="selectAll" value="全选" />
					<input type="button" class="InvertSelection" value="反选" />
					<input type="button" class="notSelectAll" value="全不选" /> 
					<input type="button" onclick="adminOpsMul(3)" value="批量设置正常" /> 
					<input type="button" onclick="adminOpsMul(4)" value="批量封禁" /> 
					<input type="button" onclick="adminOpsMul(5)" value="批量删除" />
				</form>
			</td>
			<td>
				<!-- begin Name:wuqiwei Date:2013-4-13 分页标签 -->
				<div id="content" style="margin-left: 300px;">
					<div id="Pagination" class="pagination" />
					<br style="clear:both;" />
				</div> <!-- end Name:wuqiwei Date:2013-4-13 分页标签 -->
			</td>
		</tr>
	</table>
	<script type="text/javascript" src="/js/jquery.min.js"></script>
	
	<!-- begin Name:wuhuanrong Date:2013-4-13 全选，反选和全不选 -->
	<script type="text/javascript" src="/js/common/SelectCheckBox.js"></script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					// 第一个参数：统一名字的复选框的名字
					// 第二个参数：全选框的按钮名字
					// 第三个参数：反选框按钮的名字
					// 第四个参数：全不选框按钮名字
					new Select('infoIds', 'selectAll', 'InvertSelection','notSelectAll').click();
				});
	</script>
	<!-- end Name:wuhuanrong Date:2013-4-13 全选，反选和全不选 -->

	<!-- begin Name:wuqiwei  data:2013-4-13  分页js -->
	<script type="text/javascript" src="/js/pagination/jquery.pagination.js"></script>
	<script type="text/javascript" src="/js/pagination/Believeuspagiation.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var count="${argumentCount}";
			var countPerPage=12;
			if(count>countPerPage){
				var believeusPagiation=new BelieveusPagiation('Searchresult','/adminSubArgumentAjaxList',countPerPage,count,"jhtml");
				believeusPagiation.pagiation();
			}
		});
	</script>
	<!-- end Name:wuqiwei  data:2013-4-13  分页js -->

	<!-- Begin Name:wuqiwei Date:2013-4-14 23:35:00 鼠标移动单元格背景变色 -->
	<script type="text/javascript" src="/js/common/bgmouseover.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	    var bgmouseOver=new BGmouseOver('tbody','tr');
		   bgmouseOver.changeColor();
	});
	</script>
	<!-- Begin Name:wuqiwei Date:2013-4-14 23:35:00 鼠标移动单元格背景变色 -->

	<!-- Begin Name:wuqiwei Date:2013-4-14 23:36:36 局部刷新删除游戏 -->
	<!-- Begin Name:wuqiwei Date:2013-4-14:23:32:18 提示框 -->
	<script src="/js/alertBox/jquery.ui.draggable.js" type="text/javascript"></script>
	<script src="/js/alertBox/jquery.alerts.js" type="text/javascript"></script>
	<!-- End Name:wuqiwei Date:2013-4-14:23:32:18 提示框 -->
	<script type="text/javascript" src="/js/common/BelieveusAjaxCrud.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		// 第一个参数为显示内容的容器id
		// 第二个参数为你点击哪个html标签触发的请求  该按钮必须含有 url="请求地址"的属性
		// 例如 <span name="delete" url="xxxx.do"/>
		var ajaxCrud=new BelieveusAjaxCrud('Searchresult','confirm_button');
		ajaxCrud.deleteData();
	});
	</script>
	<!-- end Name:wuqiwei Date:2013-4-14 23:36:36 局部刷新删除游戏 -->
</body>
</html>
