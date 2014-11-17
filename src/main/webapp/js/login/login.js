    //显示灰色 jQuery 遮罩层
    function showBg(obj) {
    	// 清空表单数据
    	$("#email").val("");
    	$("#userPwd").val("");
    	$("#confirmPwd").val("");
    	$("#checkCode").val("");
    	// 登录
    	if(obj=="login"){
    		$("#regOrLogin").text("紧急登录").css("font-size","20px");
            $("#enter").val("登录");
            $("#nickName").hide();
            $("#pwd2").hide();
    		$("#confirmPwd").hide();
            // 在struts 的<html:form action="/login.do" name="">标签中 name 的值就是在
            //<action path="/login" name="studentCommonForm" parameter="act"/> 中的值
            // 既 name 的属性值是 studentCommonForm
            // 这句话的意思是根据名字取得表单对象
    		$("[name='studentCommonForm']").attr("action","login.html");
    	//注册
    	}else{
    		$("#regOrLogin").text("紧急注册").css("font-size","20px");
    		$("#confirmPwd").show();
             $("#enter").val("注册");
            // 在struts 的<html:form action="/login.do" name="">标签中 name 的值就是在
            //<action path="/login" name="studentCommonForm" parameter="act"/> 中的值
            // 既 name 的属性值是 studentCommonForm
            // 这句话的意思是根据名字取得表单对象
    		$("[name='studentCommonForm']").attr("action","/register.html");
    	}
        var bh = $("body").height();
        var bw = $("body").width();
        $("#fullbg").css({
            height:bh,
            width:bw,
            display:"block"
        });
        $("#dialog").show();
    }
    //关闭灰色 jQuery 遮罩
    function closeBg() {
        $("#fullbg,#dialog").hide();
    }
