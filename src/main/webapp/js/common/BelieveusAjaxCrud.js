// 第一个参数为显示内容的容器id
// 第二个参数为你点击哪个html标签触发的请求  该按钮必须含有 url="请求地址"的属性
// 例如 <span name="delete" url="xxxx.do"/>
var BelieveusAjaxCrud=function(ContentId,HtmlTagName){
    // 删除数据
    this.deleteData=function(){
    	//绑定新添加的对象添加cliik
        $("[name="+HtmlTagName+"]").live("click",function(){
             var obj=this;
            jConfirm('确定要删除吗?', 'Confirmation Dialog', function(result) {
                if (result == true) {
                    var url=$(obj).attr("url");
                    // 去掉前面的 斜杆/
                     // 添加一个time参数就是防止load用缓存的数据而不去访问action
                    url=url.substring(url.indexOf('/')+1)+"?time="+new Date().getTime();
                    // 清空容器中的数据
                    $("#"+ContentId).empty();
                     // 加载内容到制定的容器中
                    $("#"+ContentId).load(url);
                }
            });
        });
    };
};