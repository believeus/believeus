<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="pagebox">
	<c:set var="divpage" value="${pager.pageUrl}"/>
	<c:if test="${pager.hasFirst}">
		<span><a title="第一页" href="${divpage}=1">&laquo; 第一页</a></span>
		<span class="break">...</span>
	</c:if>
	<c:if test="${pager.hasPrevious}">
		<span><a title="上一页" href="${divpage}=${pager.currentPage-1}">&lt; 上一页</a></span>
	</c:if>
	<c:forEach items="${pager.prePages}"  var="looppage">
		<span><a title="跳到第${looppag1e}页" href="${divpage}=${looppage}">${looppage}</a></span>
	</c:forEach>
	<c:if test="${pager.hasCurrent}">
		<span><b>${pager.currentPage}</b></span>
	</c:if>
	<c:forEach items="${pager.postPages}"  var="looppage">
		<span><a title="跳到第${looppage}页" href="${divpage}=${looppage}">${looppage}</a></span>
	</c:forEach>
	<c:if test="${pager.hasNext}">
		<span><a title="下一页" href="${divpage}=${pager.currentPage+1}">下一页 &gt;</a></span>
	</c:if>
	<c:if test="${pager.hasLast}">
		<span class="break">...</span>
		<span><a title="最后页" href="${divpage}=${pager.totalPages}">最后页 &raquo;</a></span>
	</c:if>
</div>
