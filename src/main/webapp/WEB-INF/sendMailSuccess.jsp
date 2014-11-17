<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> 发送邮箱成功。</title>
  </head>
  <body>
   <div style="position:absolute; width: 500px;height: 400px;left: 450px;top: 130px;border-color: pink">
   <font size="40px" color="green" >亲...</font><br>
   验证邮件已发到你的邮箱<font  color="green" >${registerName}</font>了。<br>
   请48小时内登录邮箱验证，点击邮件中的连接地址即可。<br>
   <font size="4px"><a href="https://mail.qq.com/cgi-bin/loginpage">点击立即登录邮箱验证</a></font>。<br/>
   <br>
   <br>
    <br>
    还没有找到验证邮件？<br/>
    1,请确认邮件是否被你提供的邮件系统自动拦截。<br>
    2,或别误认为垃圾邮件了。<br/>
    3,如果你确定邮箱地址正确，可以请求<font size="4px">
    <a href="http://www.believeus.cn:8080/SendMailAction.html">再次发送确认信</a></font>。<br>
    <br>
    <br>
   <font size="4px"> ^_^&nbsp;&nbsp;感谢亲的注册。</font><br>
   </div>
  </body>
</html>
