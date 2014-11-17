<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<head>
<title>Believeus后台管理系统</title>
<style>
body{ background:url("/images/global/adminbg.gif") top center no-repeat #fff; text-align:center; margin:0; padding:0; line-height:50px}
.loginbox{ width:400px; height:300px;  text-align:center; font-size:14px; color:#333; margin:0 auto; margin-top:100px}
.logintxt{ width:200px; height:25px; line-height:25px; border:3px solid #ccc; background:#f5f5f5}
.loginbtn{ width:100px; height:30px; background:#00E100; color:#fff; font-size:14px; font-weight:bold; line-height:30px; border:1px solid #06C; padding:0; cursor:pointer; margin-top:10px;margin-left: 170px;}
</style>
</head>
<body>
<div class="loginbox">
	<!--Begin Name:wuqiwei Date:2013-12-17 AddReason:shiro登录之后就不能再次登录除非logout,所以如果验证之后，直接登到管理界面  -->
	<shiro:authenticated>
	  <script type="text/javascript">
	   window.location.href ="http://www.believeus.cn/adminManage.html";
	  </script>
	</shiro:authenticated>
	<!--End  Name:wuqiwei Date:2013-12-17 AddReason:shiro登录之后就不能再次登录除非logout,所以如果验证之后，直接登到管理界面  -->
	<shiro:guest>
	 <div>
		<div style="position: fixed; top: 100px; left:180px; "><label><font style="color: Green;font-size: 30px; font-family: cursive;">BelieveusAdmin</font></label></div>
	   	<div style="position: fixed; top: 150px; left:300px; "><label><font style="color: Green;font-size: 30px; font-family: cursive;">后台管理</font></label></div>
	    <form action="/admin.html" method="post">
	      <label>用户名：</label><input type="text" class="logintxt" name="username"/><br/>
		  <label>密<font style="margin-left:1em"> </font>码：</label><input type="password" name="password" class="logintxt"/><br/>
		  <c:out value="${LoginError }" escapeXml="false"/>
	      <input type="submit" class="loginbtn" value="登录"/>
	   </form>
   	 </div>
	</shiro:guest>
</div>
</body>
</html>
