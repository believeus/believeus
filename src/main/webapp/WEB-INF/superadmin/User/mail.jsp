<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<link href="/css/superadmin/common.css" rel="stylesheet" />
<script type="text/javascript" src="/ueditor/editor_config.js"></script>
<script type="text/javascript" src="/ueditor/editor_all.js"></script>
<link rel="stylesheet" href="/ueditor/themes/default/css/ueditor.css" />
<title>群发邮件</title>
</head>

<body>
	<h1 class="w-95p">用户管理</h1>
	<h3 class="nav w-95p">
		<a href="#" class="on">简单搜索</a><a href="#">精确搜索</a>
	</h3>

	<div class="tab w-95p m-auto m-t-10 b-bottom p-b-10 lh-30">
		<form action="" method="post">
			用户名：<input type="text" name="" class="txt" /> <input type="button"
				name="" value="搜索" class="btn" />
		</form>
	</div>

	<div class="tab w-95p m-auto m-t-10 b-bottom p-b-10 lh-30">
		<form action="" method="post">
			用户id：<input type="text" name="" class="txt" /> 用户名：<input
				type="text" name="" class="txt" /> 性别：<input type="radio"
				name="sex" value="0" /> 男 <input type="radio" name="sex" value="1" />
			女 年龄：<select name=""><option value="">0-18</option>
				<option value="">19-25</option>
				<option value="">26-35</option>
				<option value="">36-45</option>
				<option value="">45以上</option></select> <br />学校：<input type="text" name=""
				class="txt" /> <br />省份：<select name=""></select> 城市：<select
				name=""></select> 状态：<select name=""><option value="">正常</option>
				<option value="">封禁</option>
				<option value="">推荐</option></select> 最后登录IP：<input type="text" name=""
				class="txt" /> 积分高于:<input type="text" size=4 class="txt" /> 积分低于:<input
				type="text" size=4 class="txt" /> <br /> <input type="button"
				name="" value="搜索" class="btn" />
		</form>
	</div>

	<h5 class="w-95p">
		<span class="r"><a href="javascript:;"
			onclick="history.go(-1);">&lt;&lt;返回</a></span>发送邮件
	</h5>

	<div class="w-95p  p-10 m-auto lh-30 m-t-10">
		<ul>
			<li><b>收件人</b><input type="radio" value="" name="" /> 全部 <input
				type="radio" checked="checked" value="" name="" /> 指定收件人 <br />
			<input type="text" class="txt" name="" style="width:90%" /></li>
			<li><b>邮件标题</b> <br />
			<input type="text" class="txt" name="" style="width:90%" /></li>
			<li><b>邮件内容</b> 使用模版<input type="radio" value="" name="" /> 是 <input
				type="radio" checked="checked" value="" name="" /> 否 <select
				name=""><option value="">邀请信</option>
					<option value="">激活信</option>
					<option value="">找回密码</option>
					<option value="">节日祝福</option></select> <a href="#">编辑模版</a> <br />
			<textarea id="editor" class="area w-90p h-300" name=""></textarea></li>
			<li><input type="button" name="" value="发送邮件" class="btn" /> <a
				href="#">去我的企业邮局</a> 查看发送的邮件</li>

		</ul>
	</div>

	<div class="clear"></div>
	<script type="text/javascript">
		var editor = new baidu.editor.ui.Editor();
		editor.render("editor");
	</script>
	<script>
		function changeTabById(n) {
			$(".nav a").removeClass("on");
			$(".nav a").eq(n).addClass("on");
			$(".tab").hide();
			$(".tab").eq(n).show();
		};
		function changeTab(obj) {
			var num = $(".nav a").index($(obj));
			changeTabById(num);
		};
		$(function() {
			$(".nav a").click(function() {
				changeTab(this);
			});
			changeTabById(0);
		});
	</script>
</body>
</html>