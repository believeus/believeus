
  var BelieveusAjax=function (believeusJson){
      $.ajax({  
                    url : believeusJson.url,
                   // Begin Name:wuqiwei Data:2013-4-1 经测试post方式有后台获取不到数据，故而改用get方式
                    type:"get",
                   // End Name:wuqiwei Data:2013-4-1 经测试post方式有后台获取不到数据，故而改用get方式
                    data: believeusJson.data,
                    cache : false,
                    contentType: 'application/json',
                    dataType : "json",
                    error:function(){ // 返回值或服务器报错调用这个方法
                       believeusJson.error();
                    },
                    complete : function(){  // 和服务器完成通之后调用这个方法
                        believeusJson.complete();
                    },
                    success:function(result){ // 服务器成功返回数据,此处才能接收服务器的数据
                    /* Begin Name:wuhuanrong Data:2013-10-28 
                       BugRepire:这里返回的是一个json对象，比如：{"value":"data"};
                       要获取值的时候是：result.value 得到的结果才是：data
                    */
                       believeusJson.success(result);
                    /*End Name:wuqiwei Data:2013-4-1 
                      BugRepire:这里返回的是一个json对象，比如：{"value":"data"};
                      要获取值的时候是：result.value 得到的结果才是：data
                    */
                    }  
                });
};