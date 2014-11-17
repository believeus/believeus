<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>

<c:choose>
    		<c:when test="${SessionUser eq null}">
     			<div  style="position: absolute;right:300px;top: 90px;">
     		  		<a  href="javascript:showBg('login');" onmouseover="this.style.color='orange',this.style.cursor='hand'"  onmouseout="this.style.color='red'" ><font color="red" size="3" >[ 登陆]</font></a>
     			</div>
     	  </c:when>
     	  <c:otherwise>
     	  		<div  style="position: absolute;right:335px;top: 90px;">
     		  		你好:<a  href="javascript:;" onmouseover="this.style.color='orange',this.style.cursor='hand'"  onmouseout="this.style.color='red'" ><font color="green" size="4" >${SessionUser.nickName}</font></a>
     			</div>
     	  </c:otherwise>
     	</c:choose>
     		<div style="position: absolute;right:150px;top: 90px;">
     		<c:choose>
     			<c:when test="${SessionUser eq null}">
     				 <a  href="javascript:showBg('reg');" onmouseover="this.style.color='orange',this.style.cursor='hand'"  onmouseout="this.style.color='red'" ><font color="red" size="3"  >[ 注册 ]</font></a>
     			</c:when>
     			<c:otherwise>
     				<a href="/logout-uid-${SessionUser.id}.html" onmouseover="this.style.color='orange',this.style.cursor='hand'"  onmouseout="this.style.color='red'" ><font color="red" size="3"  >[ 退出 ]</font></a>
   					  <c:choose>
   					  	<c:when test="${SessionUser.applyStatus==1}">
   					  		<a href="/submitApplyAdmin-uid-${SessionUser.id}.html">
   					  			<font color="red" size="3" id="applyAdmin">[申请成为管理员]</font>
   					  		</a>	
   					  	</c:when>
   					  	<c:when test="${SessionUser.applyStatus==2}">
   					  		<a href="javascript:;">
   					  			<font color="red" size="3">[申请提交待审核]</font>
   					  		</a>	
   					  	</c:when>
   					  	<c:when test="${SessionUser.applyStatus==3}">
   					  		<a href="http://www.believeus.cn/admin.html" target="_blank">
   					  			<font color="red" size="3">[管理员后台登录]</font>
   					  		</a>
   					  	</c:when>
   					  </c:choose>
     			</c:otherwise>
     		</c:choose>
     		
     		</div>
        <!-- 遮罩背景 -->
     <div id="fullbg">
        <div id="dialog">
	        <p class="close"><a href="" onclick="closeBg();">关闭</a></p>
	        <div>
	        <!-- 将 method=post 就不会报错 does not contain handler parameter named 'act' -->
	        	<html:form action="/login.do" method="post" >
					<div  id="regOrLogin" align="center" style="margin-bottom: 0px; font-size: 15px; color: green;"></div>
					<div style="margin-left: 22px;" id="nickName">
	        				<font style="color: green;font-size: 20px; ">昵称</font>
	        				<input id="nickName"  name="nickName" type="text" maxlength="10" style="width: 230px;height: 35px;margin-left: 38px;font-size: 20px;"/>
	        		</div>
	        		<div style="margin-left: 15px; margin-top: 5px;">
	        				<font style="color: green;font-size: 20px; ">Email</font>
	        				<input id="email"  name="email" type="text"  style="width: 230px;height: 35px;margin-left: 35px;font-size: 20px;"/>
	        				<font id="emailResult"></font>
	        		</div>
	        		<div style="margin-top: 5px;">
	        				<font style="color: green;font-size: 20px; margin-left: 15px; ">输入密码</font>
	        				<input id="userPwd"  name="userPwd" type="password"  style="width: 230px;height: 35px;margin-left: 5px;font-size: 20px;"/>
	        				<input id="userPwd_txt"  name="userPwd_txt" type="text"  style="width: 230px;height: 35px;margin-left: 5px;font-size: 20px;"/>
	        		</div>
	        		<div style="margin-top: 5px;" id="pwd2">
	        			<font style="color: green;font-size: 20px; margin-left: 15px; ">确定密码</font>
	        			<input id="confirmPwd"  name="confirmPwd" type="password"  style="width: 230px;height: 35px;margin-left: 5px;font-size: 20px;"/>
	        			<input id="confirmPwd_txt"  name="confirmPwd_txt" type="text"  style="width: 230px;height: 35px;margin-left: 5px;font-size: 20px;"/>
	        		</div>
	        		<div style=" margin-top: 5px;">
	        			<font style="color: green;font-size: 20px; margin-left: 15px;">验证码</font>
	        			<input name="checkCode"  id="checkCode" type="text" style="width: 100px;height: 30px;margin-left: 25px; font-size: 20px; "/><img id="validataCode" src="validataCode.do"/>
	        			<span id="validateResult"></span>
	        		</div>	
	        	   <div style="margin-top: 5px; margin-left:250px; ">
	        	   		<input type="submit" id="enter" value="注册" style="width: 85px;height: 30px; "/>
	        	   </div>
	        	</html:form>
	        </div>
      </div>
</div>

