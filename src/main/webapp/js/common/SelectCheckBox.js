// Name wuhuanrong Date:2013-4-13 完成全选，反选，全不选的功能
var Select = function(checkBox, selectAll, InvertSelection, notSelectAll) {
	this.checkBox = checkBox; // 复选框
	this.selectAll = selectAll; // 全选
	this.InvertSelection = InvertSelection; // 反选
	this.notSelectAll = notSelectAll; // 全不选
	this.click = function() {
		var obj = $("[name='" + this.checkBox + "']");
		$("." + this.selectAll).click(function() { // 全选
			obj.attr("checked", true); // 将该属性改为true
		});
		$("." + this.InvertSelection).click(function() {// 反选
			obj.each(function() {
				if ($(this).attr('checked')) {
					$(this).removeAttr('checked');
				} else {
					$(this).attr('checked', 'true');
				}
			});
		});
		$("." + this.notSelectAll).click(function() {// 全不选
			obj.removeAttr('checked');
		});
	};
};
