// 当HTML文档加载完毕
$(document).ready(function() {
	$("#userPwd_txt").hide();
	$("#confirmPwd_txt").hide();
	// 刷新注册码
	$("#validataCode").click(function() {
		$("#validataCode").attr("src","validataCode.do?t=" + new Date().getTime());
	});
	// 为email绑定blur方法。
	$("#email").blur(function() {
		// 邮箱的正则表达式
		if ($("#email").val() == "") {
			$("#email").val("邮箱不能为空").css("color", "#99cc33");

		} else if (!(/\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}\b/i.test($("#email").val()))) {
			$("#email").val("格式不正确！请重新输入").css("color", "#99cc33");
		} else {
			var email = $("#email").val();
			$("#emailResult").text("验证中……").css("color", "#EFC467").css(
					"font-size", "12px");
			var believeusJson = {
				'url' : '/checkinfo.html',
				'data' : 'email=' + email,
				'error' : function() {
					jConfirm('系统出错错误,回到主页面?', 'Confirmation Dialog', function(
									result) {
								if (result == true) {
									window.location.reload();
								}
							});
				},
				'complete' : function() {

				},
				'success' : function(result) {
					if (result.email == "yes") {
						if ($("#regOrLogin").text() == "紧急注册") {
							$("#emailResult").text("已被注册").css("color",
									"#ff0000");
						} else {
							$("#emailResult").text("");
						}
						// 该email还没有被注册
					} else {
						if ($("#regOrLogin").text() == "紧急注册") {
							$("#emailResult").text("可以注册").css("color",
									"#ff0000");
						} else {
							$("#emailResult").text("");
							$("#email").val($("#email").val() + "未注册,请注册后登录").css("font-size", "15px").css("color","green");
						}
					}
				}
			};
			if ($("#emailResult").text() != "可以注册") {
				BelieveusAjax(believeusJson);
			}
		}
	});

	// 为email 绑定focus方法
	$("#email").focus(function() {
		// 如果不符合邮箱的正则表达式,清空数据
		if (!(/\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[a-zA-Z]{2,6}\b/.test($("#email").val()))) {
			$("#email").val("");
		}
		if ($("#emailResult").text() == "已被注册") {
			$("#email").val("");
			$("#emailResult").text("");
		}
	});
	$("#userPwd").blur(function() {
				if ($("#userPwd").val() == "") {
					$("#userPwd_txt").show();
					$("#userPwd").hide();
					$("#userPwd_txt").val("请输入密码").css("color", "#99cc33");
				}
			});
	$("#userPwd_txt").focus(function() {
				$("#userPwd_txt").val("");
				$("#userPwd_txt").hide();
				$("#userPwd").show();
			});
	$("#confirmPwd").blur(function() {
				if ($("#confirmPwd").val() == "") {
					$("#confirmPwd_txt").show();
					$("#confirmPwd").hide();
					$("#confirmPwd_txt").val("请输入确定密码").css("color", "#99cc33");
				} else if ($("#confirmPwd").val() != $("#userPwd").val()) {
					$("#confirmPwd").hide();
					$("#confirmPwd").val("");
					$("#confirmPwd_txt").show();
					$("#confirmPwd_txt").val("密码与确定密码不一致").css("color","#99cc33");
				}
			});
	$("#confirmPwd_txt").focus(function() {
				$("#confirmPwd_txt").val("");
				$("#confirmPwd_txt").hide();
				$("#confirmPwd").show();
			});
	// 注册码验证
	$("#enter").click(function() {
		if($("#regOrLogin").text() == "紧急注册"){
			if($("#userPwd").val()!=$("#confirmPwd").val()){
				$("#confirmPwd").hide();
				$("#confirmPwd_txt").show();
				$("#confirmPwd_txt").val("密码与确定密码不一致").css("color","#99cc33");
				return false;
			}
		}
		var validateCode = $("#checkCode").val();
		var validateCodeJson = {
			"url" : "/checkCode.html",
			"data" : "checkCode=" + validateCode,
			"error" : function() {
				jConfirm('系统出错错误,回到主页面?', 'Confirmation Dialog', function(result) {
							if (result == true) {
								window.location.reload();
							}
						});
			},
			"complete" : function() {

			},
			"success" : function(result) {
				// 验证码验证失败
				if (result.value== "error") {
					$("#validateResult").text("验证码有误").css("color", "#E11B1B");
					// 刷新验证码
					$("#validataCode").attr("src","validataCode.do?t=" + new Date().getTime());
                      return false;
					// 验证码验证成功
				} else {
					$("#validateResult").text("");
					// 没有填写邮箱时
					if ($("#email").val() == null || $("#email").val() == "") {
						$("#email").val("邮箱不能为空").css("color", "#99cc33");
						return false;
						// 填写邮箱验证邮箱是否已经注册
					} else {
						var believeusJsonCheckEmail = {
							'url' : '/checkinfo.html',
							'data' : 'email=' + $("#email").val() + "&pwd="+ $("#userPwd").val(),
							'error' : function() {
								jConfirm('系统出错错误,回到主页面?','Confirmation Dialog', function(result) {
                                    if(result==true){
                                        window.location.reload();
                                    }    
								});
							},
							'complete' : function() {
							},
							'success' : function(result) {
								var isEmail = false;
								var isPwd = false;
                                // 邮箱存在
								if (result.email == "yes") {
									// yes 在登录页面表示 该邮箱已经被注册，可以登录
									if ($("#regOrLogin").text() == "紧急登录") {
										$("#emailResult").text("邮箱可以登录").css("color", "#ff0000");
										// isEmail=true 在登录页表示已被注册，可以登录
										isEmail = true;
									}
								 }
								// 邮箱不存在
                               else if(result.email == "no"){
                            	   // 如果在登录页面
									if ($("#regOrLogin").text() == "紧急登录") {
										$("#emailResult").text("");
										$("#email").val($("#email").val()+ "未注册,请注册后登录");
                                        $("#email").css("font-size", "15px").css("color", "green");
                                        // 在登录页面，表示该邮箱不可以登录
										isEmail = false;
									// 如果在注册页面，表明该邮箱可以注册
									}else{
										isEmail = true;
									}
								}
								// 密码错误
								if (result.pwd == "no") {
                                    if ($("#regOrLogin").text() == "紧急登录") {
                                    	$("#userPwd_txt").show();
                    					$("#userPwd").hide();
                    					$("#userPwd_txt").val("不正确密码").css("color", "#99cc33");
                    					// 登录页面，false 代表密码不正确
                    					isPwd=false;
                    					return ;
                                    }else if($("#regOrLogin").text() == "紧急注册"){
                                    	// 注册页面 false 代表新注册的密码
                                    	isPwd=false;
                                    }
								}
								// 密码正确
								else if(result.pwd == "yes"){
									isPwd=true;
								}
								// 提交到登录action
                               if(isEmail==true&&isPwd==true){
                                    $("[name='studentCommonForm']").submit();
                               // 提交到注册action
                               }else if(isEmail==true&&isPwd==false){
                            	   $("[name='studentCommonForm']").attr("action","/register.html").submit();
                               }
							}
						};
						new BelieveusAjax(believeusJsonCheckEmail);
					}
				}
			}
		};
		new BelieveusAjax(validateCodeJson);
		// form 表单 返回值为true可以提交，false不可提交
		return false;
	});
});
