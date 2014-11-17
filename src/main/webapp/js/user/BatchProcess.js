/*
*第一个参数是 批量删除 按钮的名字。
*第二个参数是 处理批量删除 的url。
*第三个参数是 提交的form表单的名字。
*
*使用方法：
*new BatchProcessDelect('delect','/adminBatchProcessDelect','myForm');
*/
var BatchProcessDelect = function(delect,delectUrl,form) {
	$("[name='" +delect + "']").click(function() {// 获取所有选中的选项的值
				if ($("input:checked").length == 0) {
					jConfirm('请选择至少一项！', 'Confirmation Dialog',function(result) {
								if (result == true) {
									return;
								};
							});
					return;
				}
				var checkedList = new Array();
				$("input:checked").each(function() {
							var name = $(this).val();
							var ch = new Array;
							ch = name.split(",");
							checkedList.push(ch[0]);
						});
				jConfirm('确定要删除吗?', 'Confirmation Dialog', function(result) {
							if (result == true) {
								/*关于
								 * var url = delectUrl+"-uid-"+checkedList + ".html";
								 * 的说明：
								 * 比如 delectUrl 等于："/adminBatchProcessDelect"
								 * 那么加上"-uid-" 就等于："/adminBatchProcessDelect-uid-"
								 * 再比如checkedList 的值是：68,72 
								 * 那么加上checkedList 就等于："/adminBatchProcessDelect-uid-68,72"
								 * 总体这个url会等于："/adminBatchProcessDelect-uid-68,72.html"
								 * 
								 * 示例：当我们在使用的时候url的匹配方式可如下：
								 * /adminBatchProcessDelect-uid-([0-9,]+).html
								 * 通过url重写会变成这样：
								 * /adminBatchProcessDelect.do?act=batchProcessDelect&amp;uid=$1
								 * */
								var url = delectUrl+"-uid-"+checkedList + ".html";
								new Submit(form, url).submit();
							};
						});
			});
};
/*
 * 第一个参数是 批量正常或者批量封禁 的按钮的名字。
 * 第二个参数是 处理批量正常或者批量封禁 的url。
 * 第三个参数是 获得批量正常或者批量封禁 的 id，status 数据的标签名字。
 * 使用方法：
 * new BatchProcessNormalOrBan('normal','/adminBatchProcessNormal.html', 'ban_button');
 * */
var BatchProcessNormalOrBan = function(statusName, url, data) {
	$("[name='" + statusName + "']").click(function() {
		if ($("input:checked").length == 0) {
			jConfirm('请选择至少一项！', 'Confirmation Dialog', function(result) {
						if (result == true) {
							return;
						};
					});
		}
		var userId = new Array();
		var count = 0;
		$("input:checked").each(function() {
			var name = $(this).val();
			var datas = new Array();
			datas = name.split(",");
			userId.push(datas[0]);
			var believeusJson = {
				'url' : url,
				'data' : 'ustatus=' + datas[1] + '&uid=' + datas[0] + '',
				'error' : function() {
					alert("系统出错,请重新点击！");
				},
				'complete' : function() {

				},
				'success' : function(result) {
					/*
					 * $.each($("[name='button']"), function(index, obj) {}
					 * 第一个参数是一个数组。 
					 * function(index,obj) 表示遍历这个数组。 
					 * index 表示第一个脚标。
					 * obj表示的是第一个元素或者是对象。 
					 * obj.name 表示的是获取这个对象的属性。
					 */
					/*
					 * 虽然每次ajax请求成功之后都会调用该方法，但是因为ajax相当于多线程的处理方案，
					 * 所以导致ajax没有处理完之前json数据就会被重新赋值，导致每次的值都是最新的值 
					 * 处理办法将所有的数据保存到数组之中，由count判断sucess回调执行是否是最后一次，
					 * 如果是最后一次，则把这个数组和被选中用户进行比较。
					 */
					count++;
					if (count == userId.length) {
						$.each($("[name='" + data + "']"),function(index, obj) {
									// 要转换成jquery对象
									for (var i = 0; i < userId.length; i++) {
										if ($(obj).attr("stuId") == userId[i]) {
											$(this).text(result);
											if (result == "封禁") {
												$(this).attr("ustatus", 1);
												$(this).css("color", "red");
											} else {
												$(this).attr("ustatus", 0);
												$(this).css("color", "#15A230");
											}
										}
									}
								});
					}
				}
			};
			//循环发送ajax请求。
			new BelieveusAjax(believeusJson);
		});
	});
};