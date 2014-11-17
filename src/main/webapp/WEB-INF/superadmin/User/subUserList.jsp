<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
	<!-- 分页的显示区 -->
	<div id="Searchresult">
	<!-- 分页的显示区 -->
    	<form action="" method="post" id="myForm"> 
	<c:forEach items="${studentList}" var="student">
		<ul class="piclist w-95p" style="display:inline" id="useInfo">
			<li>
				<div>
					<a href=""><img src="${student.headImg}" /></a>
				</div>
				<div>
					<input type="checkbox" name="choose" value='${student.id},${student.status},/adminUserStatus.html' />
					<a href="">${student.nickName}</a>
					(${student.sex })<span class="adminpic" title="管理员"></span>
				</div>
				<div>
					<a href="" class="hui">${student.school}</a>
				</div> 
				<div> 
					<a href="javascript:new Submit('myForm','/adminViewUser-uid-${student.id}.html').submit();">查看</a>
					<a href="javascript:;" name="ban_button" stuId='${student.id}' ustatus='${student.status}' url='/adminUserStatus.html' >
						<c:choose>
						<c:when test="${student.status eq 0}"><font color="#15A230">正常</font></c:when>
						<c:otherwise><font color="red">封禁</font></c:otherwise>
					</c:choose>
					</a> 
						<a href="javascript:;" name="confirm_button" url="/adminDeleteUser-uid-${student.id}-currentPage=${currentPage}.html">删除
					</a>
				</div>
			</li>
		</ul>
	</c:forEach>
	</div>
	 </form>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/user/BelieveusCheckStatus.js"></script>
<script type="text/javascript" src="/js/common/SelectCheckBox.js"></script>
<script type="text/javascript" src="/js/user/BatchProcess.js"></script>
  </body>
</html>
