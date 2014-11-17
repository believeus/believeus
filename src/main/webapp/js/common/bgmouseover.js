//页面背景移动变色，可公共使用。
var BGmouseOver=function(parentId,childId){
    BGmouseOver.color;
	this.parentId=parentId;
    this.childId=childId;
	this.changeColor=function(){
		var obj="#"+this.parentId+" "+this.childId;
		  //鼠标移入该行和鼠标移除该行的事件
        // live 可以为新生成的元素绑定事件
        $(obj).live("mouseover",function(){
            BGmouseOver.color=$(this).css("background-color");
            $(this).css("background-color","#EEEEEE");
        });
         // live 可以为新生成的元素绑定事件
        // 移出变为原来的颜色
        $(obj).live("mouseout",function(){
              $(this).css("background-color",BGmouseOver.color);
        });
	};
	//表格的奇偶行变色。
    this.evenOddChangeColor=function(){
        var even="#"+this.parentId+" "+this.childId+":even";
        var odd="#"+this.parentId+" "+this.childId+":odd";
        $(even).css("background","#E6E6E6");
        $(odd).css("background","#FFFFFF");
    };

};