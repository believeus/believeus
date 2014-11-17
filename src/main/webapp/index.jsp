<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>免费自由开源共享www.believeus.cn</title>
<meta name="Keywords" content="医疗" />
<meta name="description" content="believeus让医疗变得更开源，更免费，更自由，更共享" />
<link rel="stylesheet" href="/css/alertBox/jquery.alerts.css"/>
<!-- Begin Name:wuqiwei Date:2013-07-27 AddReason:导航css -->
<link href="/css/navigation/common.css" rel="stylesheet" type="text/css" media="all" />
<!-- End Name:wuqiwei Date:2013-07-27 AddReason:导航css -->

<!-- Begin Name:wuqiwei Date:2013-07-27 AddReason:注册登录css -->
<link rel="stylesheet" href="/css/login/login.css" type="text/css"></link>
<!-- End Name:wuqiwei Date:2013-07-27 AddReason:注册登录css -->
</head>
<body id="main">
<!--start main-->
<div class="wrapper">
 <div class="main">
    <div class="maincontent">
    	<div>
    		<a href="http://www.believeus.cn"><img src="/images/signpic/logo.png"/></a>
    		<img src="images/signpic/barna.png" />
    	<!-- Begin Name:wuqiwei Date:2013-07-26 ModifyReason:抽取登录和注册页面 -->
    	</div>
    		<!-- 登录和注册页面 -->
    		<jsp:include page="/jsp/common/login.jsp" />
     	</div>
     	<!-- Begin Name:wuqiwei Date:2013-07-26 ModifyReason:抽取登录和注册页面 -->
      <div class="topblock">
      	<!-- Begin Name:wuqiwei Date:2013-07-27 ModifyReason:抽取导航 -->
        <jsp:include page="/jsp/common/navigation.jsp" flush="true" />
        <!-- Begin Name:wuqiwei Date:2013-07-27 ModifyReason:抽取导航 -->
        <div class="background">
  			<img src="images/signpic/ListBackground.png"/>
  			<iframe frameborder="0" name="mainBox" style="position: absolute; left: 215px;top:6px;width: 885px;height:1485px;" src="/bowen.html"></iframe>
       </div>
      </div>
      <!--end topblock -->
     
      <div class="cl"></div>
    </div>
    <div>
    </div>
 </div>
<!--end main-->
<script  type="text/javascript"  src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/alertBox/jquery.ui.draggable.js"></script>

<!-- Begin Name:wuqiwei Date:2013-07-27 AddReason:登录和注册页面js -->
<script type="text/javascript" src="/js/alertBox/jquery.alerts.js"></script>
<script type="text/javascript" src="/js/login/login.js"></script>
<script type="text/javascript" src="/js/login/CheckingReg.js"></script>
<script type="text/javascript" src="/js/BelieveusAjax.js"></script>
<!-- End Name:wuqiwei Date:2013-07-27 AddReason:登录和注册页面js -->

<!-- Begin Name:wuqiwei Date:2013-07-27 AddReason:导航js -->
<script type="text/javascript" src="/js/topMenu.js"></script>
<!-- Begin Name:wuqiwei Date:2013-07-27 AddReason:导航js -->
<!-- begin Name:wuqiwei Date:2013:4-26 20:42 AddReason:移除session范围中验证码的值 -->
<c:remove var="SessionValidateCode"  scope="session"/>
<!-- begin Name:wuqiwei Date:2013:4-26 20:42 AddReason:移除session范围中验证码的值 -->
</body>
</html>
