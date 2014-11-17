/*begin name:wuhuanrong date:2013-04-10 表单提交公共类*/
var Submit = function(formId, url) {
	this.submit = function() {
		$("#" + formId).attr("action", url).submit();
	};
};