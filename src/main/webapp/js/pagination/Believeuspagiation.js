// 第一个参数elementId：是html标签的id
// 第二个参数url：请求服务器的url 不能以/开头,并且url必须形如xxxx-pageId-([0-9]+).html 但是
// 作为参数的时候只要写xxx就可以了！
//count_per_page 每页显示的个数
// totalCount 代表总条数 初始化页数标签个数
// 最矛盾的地方是该pageselectCallback(page_index, jq)页面加载一次的时候，这个方法会默认的调用
// 也就是说当点击屌丝笑话管理的时候执行了一次action
//页面加载完的时候$('#Searchresult').load(url);又去执行了一次action
// 解决办法：
//定义index变量并且当点击第二页或第三页的时候index++;
//这样当第一次点击屌丝笑话的时候$('#Searchresult').load(url);
// 就不会被执行。之后点击第一页的时候if(index>0)方法就会被执行
var index = 0;
var BelieveusPagiation = function(elementId,url,count_per_page, totalCount,stuffix) {
    this.pagiation=function() {
                    var optInit = {
                        // 当执行 $("#Pagination").pagination(totalCount, optInit);
                        // 该callback方法会被执行，当下一页或上一页该方法也会被执行
                        // 该方法的第一参数是当前点击的页数
                        callback :  function(page_index, jq) {
                                            // url=adminTucaoJokeList
                                            // 拼接之后adminTucaoJokeList-pageId-([0-9]+).html
                                            // 添加一个time参数就是防止load用缓存的数据而不去访问action
                                           url=url+"-pageId-"+(page_index + 1)+"."+stuffix+"?time="+new Date().getTime();
                                           // 当不是第一次点击的时候该法行会被调用
                                           if (index > 0) {
                                                 // 该方法加载之后会放入缓存之中，下次读取的url不会再次从后台取数据
                                                 $("#"+elementId).load(url);
                                            }
                                            // 当第一次点击不是第一页的时候该方法会被调用
                                            else if (page_index > 0) {
                                                  index++;
                                                  $("#"+elementId).load(url);
                                                  window.scrollTo(0,document.body.scrollHeight);
                                             }
                                             // 截取字符串 xxxx-pageId-([0-9]+).html 截取的结果为 xxxx
                                              url=url.substring(0,url.indexOf('-'));
                                              return false;
                                          },    
                         items_per_page : count_per_page,
                         prev_text : "&lt;",// 这是前一页的< 号
                         next_text : "&gt;"// 这是后一页的>号
                    };
                    // 第一个参数代表共有多少条数据
                    $("#Pagination").pagination(totalCount, optInit);
                };
};