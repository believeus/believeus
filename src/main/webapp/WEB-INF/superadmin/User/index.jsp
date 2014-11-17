<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/superadmin/common.css" rel="stylesheet" />
<link href="/css/superadmin//new_admin.css" rel="stylesheet" type="text/css"/>
<link href="/css/alertBox/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<!-- begin :分页css -->
<link href="/css/pagination/pagination.css" rel="stylesheet" type="text/css" media="screen" />
<!-- end :分页css -->

<style type="text/css">
.selectAll,.InvertSelection,.notSelectAll,.style_a {
	background: #DDEFFF;
	color: #039;
	padding: 3px 10px 3px 10px;
	border: none;
	font-size: 13px;
	cursor: pointer
}
</style>
<title>查看所有用户</title>
</head>
<body>
	<div class="org_header xiangdui">
		  <div class="org_map l"></div>
		  <div class="usr_info r">你好： <a href="#">${sessionAdmin.adminName}</a> | <a href="/adminLogout.html">赶紧退出</a></div>
	</div>
	<div class="clear"></div>
	<h1 class="w-95p">用户管理</h1>
	<h3 class="nav w-95p"><a href="#" class="on">搜索</a></h3>
	
	<div class="tab w-95p m-auto m-t-10 b-bottom p-b-10 lh-30">
		<form action="/adminAccurateSearchUser.html" method="post">
			用户名：<input type="text" name="nickName" class="txt" /> 
			Email：<input type="text" name="nickName" class="txt" /> 
			性别：<input type="radio" name="sex" value="男" /> 男 
				<input type="radio" name="sex" value="女" />女 
			状态：
			<select name="status">
					<option value="0">正常</option>
					<option value="1">封禁</option>
			</select> 
			<input type="submit" name="submit_search" value="搜索" class="btn" />
		</form>
	</div>
	<!-- 分页的显示区 -->
	<form action="" method="post" id="myForm"> 
	<div id="Searchresult">
	<!-- 分页的显示区 -->
	<c:forEach items="${studentList}" var="user">
		<ul class="piclist w-95p" style="display:inline" id="useInfo">
			<li>
				<div>
					<a href=""><img src="/${user.headImg}" /></a>
				</div>
				<div>
					<input type="checkbox" name="choose" value='${user.id},${user.status},/adminUserStatus.html' />
					<a href="">${user.nickName}</a>
					(${user.sex })<br />
					 <c:if test="${user.applyStatus  eq 3}">
						<span><font color="red">believeus管理员</font></span>
					 </c:if>
				</div>
				<div> 
					<a href="javascript:new Submit('myForm','/adminViewUser-uid-${user.id}.html').submit();">查看</a>
					<a href="javascript:;" name="ban_button" stuId='${user.id}' ustatus='${user.status}' url='/adminUserStatus.html' >
					<c:choose>
						<c:when test="${user.status eq 0}"><font color="#15A230">正常</font></c:when>
						<c:otherwise><font color="red">封禁</font></c:otherwise>
					</c:choose>
					</a> 
					<a href="javascript:;" name="confirm_button" url="/adminDeleteUser-uid-${user.id}-currentPage=${currentPage}.html">删除
					</a>
				</div>
			</li>
		</ul>
	</c:forEach>
	</div>
	 </form>
	<div class="clear"></div>

	<div class="w-95p m-auto">
		<div class="l">
			<input  type="button" class="selectAll" value="全选"/>
			<input  type="button"  class="InvertSelection" value="反选"/>
			<input  type="button" class="notSelectAll" value="全不选"/>
			<a href="javascript:;" class="style_a" name="normal">批量正常</a> 
			<a href="javascript:;" class="style_a" name="ban" >批量封禁</a>
			<a href="javascript:;" class="style_a" name="recommend" >批量推荐</a> 
			<a href="javascript:;" class="style_a" name="delect" >批量删除</a>
			<a href="adminMail.html" class="style_a">群发邮件</a>
		</div>
		<!-- begin Name:wuqiwei Date:2013-4-13 分页标签 -->
				<div id="content" style="margin-left: 300px;">
					<div id="Pagination" class="pagination" />
					<br style="clear:both;" />
				</div> 
		<!-- end Name:wuqiwei Date:2013-4-13 分页标签 -->
	</div>
	
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/common/Submit.class.js"></script>
<script src="/js/alertBox/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="/js/alertBox/jquery.alerts.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/BelieveusAjax.js"></script>
<script type="text/javascript" src="/js/user/BelieveusCheckStatus.js"></script>
<script type="text/javascript" src="/js/common/SelectCheckBox.js"></script>
<script type="text/javascript" src="/js/common/bgmouseover.js"></script> 
<script type="text/javascript" src="/js/user/BatchProcess.js"></script>
<!-- begin Name:wuqiwei  data:2013-4-13  分页js -->
	<script type="text/javascript" src="/js/pagination/jquery.pagination.js"></script>
	<script type="text/javascript" src="/js/pagination/Believeuspagiation.js"></script>
	<!-- Begin Name:wuqiwei Date:2013-4-14 23:36:36 局部刷新删除游戏 -->
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
	<script type="text/javascript">
		$(function(){
			var count="${totalCount}";
			var countPerPage=15;
			if(count>countPerPage){
				var believeusPagiation=new BelieveusPagiation('Searchresult','/adminUser',countPerPage,count,"html");
				believeusPagiation.pagiation();
			}
		});
	</script>
	<!-- end Name:wuqiwei  data:2013-4-13  分页js -->
<script type="text/javascript">
$(document).ready(function() {
		new BGmouseOver('useInfo','li').changeColor();
		new Select('choose','selectAll','InvertSelection','notSelectAll').click();
		new BatchProcessDelect('delect','/adminBatchProcessDelect','myForm');
		new BatchProcessNormalOrBan('normal','/adminBatchProcessNormal.html', 'ban_button');
		new BatchProcessNormalOrBan('ban','/adminBatchProcessBan.html','ban_button');
	});
	</script>
</body>
</html>