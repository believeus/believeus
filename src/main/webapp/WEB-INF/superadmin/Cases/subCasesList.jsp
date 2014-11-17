<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- begin Name:wuqiwei Date:2013-08-10 这是自定义的标签库，使用来将去除html标签 -->
<%@ taglib uri="http://www.believeus.cn/jstl/html" prefix="html" %>
<!-- end Name:wuqiwei Date:2013-08-10 这是自定义的标签库，使用来将去除html标签 -->

<!-- begin Name:wuqiwei Date:2013-4-13 这是自定义的标签库，使用来将long类型转换成时间的 -->
<%@ taglib uri="http://www.believeus.cn/jstl/date" prefix="date"%>
<!-- end Name:wuqiwei Date:2013-4-13 这是自定义的标签库，使用来将long类型转换成时间的 -->
	<!-- 分页的显示区 -->
<table class="tableborder" id="tbody">
		<tr class=header>
	<td colspan="11" style="text-align:left;">
	<a href="/adminNewBowenView.html"><font style="font-size: 15px;">新建医案</font></a>
		<span class="r">搜索结果：<b></b>个
	</span> <span><a href="">全部博文信息</a><b>${bowenCount}</b>个 <a href="">封禁</a><b>2000</b>个
	</span></td>
</tr>
<tr>
	<th>医案编号</th>
	<th>标题</th>
	<th>发布人</th>
	<th>医案内容</th>
	<th>发布时间</th>
	<th>状态</th>
	<th>编辑</th>
</tr>
	<c:forEach items="${subCasesList}" var="cases" varStatus="status">
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
				<input type="checkbox" name="infoIds" value="${cases.id}" />
				<label>${cases.id}</label>
			</td>
			<td style="text-align: left; max-width: 50px;">
					<a title="${cases.title}" href="">${cases.title }</a>
			</td>
			<td>
				${cases.author }
			</td>
			<td style="max-width: 100px; text-align:left; max-height: 45px;">
				<a href="/adminCasesDetail-Jid-${cases.id}.html" >
					<html:html num="45" value="${cases.content }"></html:html>
				</a>
			</td>
			<td style="max-width: 60px; text-align: left; text-align:justify;">

				<!-- begin Name:wuqiwei Date:2013-4-13 这是自定义的标签库，使用来将long类型转换成时间的 -->
				<date:date value="${cases.editDate }" parttern="yyyy-MM-dd HH:mm:ss E" />
				<!-- begin Name:wuqiwei Date:2013-4-13 这是自定义的标签库，使用来将long类型转换成时间的 -->
			</td>
			<td id="baz1Item877">
				<c:choose>
					<c:when test="${cases.status eq 0 }"><font color="green">正常</font></c:when>
					<c:when test="${cases.status eq 1 }"><font color="red">封禁</font></c:when>
					<c:when test="${cases.status eq 2 }"><font color="yellow">推荐</font></c:when>
				</c:choose>
			</td>
			<td>
				<a href="/adminCasesEdit-id-${cases.id}-currpage-${currentPage}.jhtml">编辑</a>|
				<a name="confirm_button" style="cursor: pointer; color: red;" url="/adminDeleteCases-id-${cases.id}-currPage-${currentPage}.jhtml">删除</a>
			</td>
		</tr>
		</c:forEach>
</table>
