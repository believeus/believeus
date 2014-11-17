  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="nav homenav" id="nav">
          <div class="allcate"><a href="">全部视频分类</a></div>
          <ul>
            <li> <a href="" >中医学</a>
              <div class="submenubox disn">
                <div class="subcate">
                  <ul>
                    <li><a href="" >中医基础理论</a></li>
                    <li><a href="" >中医诊断学</a></li>
                    <li><a href="" >中药学</a></li>
                    <li><a href="" >方剂学</a></li>
                    <li><a href="" >十二经絡</a></li>
                    <li><a href="" >四大经典</a></li>
                    <li><a href="" >妇科</a></li>
                    <li><a href="" >杂病</a></li>
                    <li><a href="" >辩证论治</a></li>
                  </ul>
                </div>
                <div class="colright">
                  <div class="featuredbrand">
                    <h3>推荐品牌</h3>
                    <ul>
                      <li><a href="" title="苹果" ><img src="" alt="苹果" /></a></li>
                      <li><a href="" title="联想" ><img src="" alt="联想" /></a></li>
                      <li><a href="" title="惠普" ><img src="" alt="惠普" /></a></li>
                      <li><a href="" title="三星" ><img src="" alt="三星" /></a></li>
                      <li><a href="" title="华硕" ><img src="" alt="华硕" /></a></li>
                      <li><a href="" title="戴尔" ><img src="" alt="戴尔" /></a></li>
                    </ul>
                    <div class="cl"></div>
                  </div>
                  <div class="merchantpromotion">
                    <h3>推荐商家</h3>
                    <div class="txtList">
                      <ul>
                        <li><a href="" title="苹果中国官方网站">苹果中国官方网站</a></li>
                        <li><a href="" title="新蛋商城">新蛋商城</a></li>
                        <li><a href="" title="亚马逊">亚马逊</a></li>
                        <li><a href="" title="当当网">当当网</a></li>
                        <li><a href="" title="易迅网">易迅网</a></li>
                        <li><a href="" title="国美电器">国美电器</a></li>
                      </ul>
                    </div>
                    <div class="cl"></div>
                  </div>
                </div>
                <div class="cl"></div>
              </div>
            </li>
            <li> <a href="" >一天一招</a> </li>
            <li> <a href="" >当代明医</a>
              <div class="submenubox disn">
                <div class="subcate"></div>
                <div class="colright">
                  <div class="featuredbrand">
                    <h3>推荐明医</h3>
                    <ul>
                      <li><a href="" title="苹果" ><img src="" alt="苹果" /></a></li>
                      <li><a href="" title="三星" ><img src="" alt="三星" /></a></li>
                      <li><a href="" title="诺基亚" ><img src="" alt="诺基亚" /></a></li>
                      <li><a href="" title="宏达" ><img src="" alt="宏达" /></a></li>
                      <li><a href="" title="摩托罗拉" ><img src="" alt="摩托罗拉" /></a></li>
                      <li><a href="" title="华为" ><img src="" alt="华为" /></a></li>
                      <li><a href="" title="摩托罗拉" ><img src="" alt="摩托罗拉" /></a></li>
                      <li><a href="" title="华为" ><img src="" alt="华为" /></a></li>
                    </ul>
                    <div class="cl"></div>
                  </div>
                </div>
                <div class="cl"></div>
              </div>
            </li>
            <li> 
            	<a href="/bowen.html" target="mainBox">中医博文</a>
            </li>
            <li> 
            	<a href="/casesIndex.jhtml" target="mainBox">中医医案</a>
            </li>
             <li> 
            	<a href="/yaoShanIndex.jhtml" target="mainBox">中医药膳</a>
            </li>
             <li> 
            	<a href="/argumentIndex.jhtml" target="mainBox">中西之争</a>
            </li>
          </ul>
          <c:if test="${SessionUser ne null }">
          	<c:if test="${SessionUser.applyStatus == 3 }">
          		<div id="notifyBox" style="position:relative;margin-left: 12px;margin-top: 10px;"><script type="text/javascript" src="/Notice/Notice.nocache.js"></script></div>
          	</c:if>
          </c:if>
        </div>
