<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.believeus.cn/jstl/html" prefix="html" %>
<c:forEach items="${bowenList }" var="bowen" varStatus="s">
	<c:if test="${s.count ne 1 }">
		<c:if test="${s.count%3 ==1 }">
			<c:set var="top" value="${top+1 }"/>
		</c:if>
	</c:if>
	<c:set var="index" value="${s.index}"/>
    <div>
	  <div style="position:absolute; left:${260+((s.index mod 3)*280)}px;top: ${top*350+70 }px;">
		<div><img src="images/signpic/videobg.png" /></div>
		<div style="top:-245px; position: relative; left: 50px; ">
		  <a href="/bowenDetail-bid-${bowen.id}.html" style="color: red;">
			<html:html value="${bowen.title }" num="8"></html:html>
		  </a>
		</div>
		<div style="top: -240px; position: relative; left: 30px; font-size: 14px; width: 180px; height: 20px;"><a> <html:html value="${bowen.content }" num="100"/></a></div>
	  </div>
  </div>
</c:forEach>