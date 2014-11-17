	$("[name=ban_button]").click(function() {
		var obj = $(this);
		var believeusJson = {
			'url' : obj.attr('url'),
			'data' : 'ustatus='+obj.attr("ustatus")+'&uid='+obj.attr('stuId')+'',
			'error' : function() {
				alert("系统出错,请重新点击！");
			},
			'complete' : function() {

			},
			'success' : function(result) {
				obj.text(result.value);
				if(result.value=="封禁"){
					obj.attr("ustatus",1);
					obj.css("color","red");
				}else{
					obj.attr("ustatus",0);
					obj.css("color","#15A230");
				}
			}
		};
		jConfirm('确定要改变状态吗?', 'Confirmation Dialog', function(result) {
			if (result == true) {
				BelieveusAjax(believeusJson);
			}
		});
	});