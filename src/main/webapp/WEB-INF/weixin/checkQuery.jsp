<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html> 
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="yes" name="apple-touch-fullscreen">
    <meta name="format-detection" content="telephone=no" />
    <meta content="email=no" name="format-detection" />
    <meta name="x5-fullscreen" content="true">
    <link rel="stylesheet" href="<%=basePath%>source/weixin/css/style.css">
    <!--<script src="../<%=basePath%>source/weixin/js/fontsize.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/fontsize2.js"></script>
    <!--<script src="http://g.tbcdn.cn/mtb/lib-flexible/0.3.4/??flexible_css.js,flexible.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/jquery-1.8.3.min.js"></script>
    <script src="<%=basePath%>source/weixin/js/functions.js"></script>
    <!--日期文件-->
    <link rel="stylesheet" href="<%=basePath%>source/weixin/css/lCalendar.css">
    <script src="<%=basePath%>source/weixin/js/lCalendar.min.js"></script>
    <!--消除点击延迟-->
	<script src="<%=basePath%>source/weixin/js/fastclick.js"></script>
   <script>
    if ('addEventListener' in document) {
        document.addEventListener('DOMContentLoaded', function() {
            FastClick.attach(document.body);
        }, false);
    }
	</script>
    <title>检验查询</title>
</head>
<body class="Reg">
<div class="wrap">
    <header>
        <img src="<%=basePath%>source/weixin/img/logo.png">
        <span>台州市第一人民医院</span>
    </header> 
    <div class="iq-tip">仅限查询30天内的检验数据</div> 
    <c:if test="${v_list==null }">
     <div class="iq-tip">暂无检验数据</div> 
    </c:if>
    <div class="IQ">     
  	<c:forEach items="${v_list }" var="list"> 
  	<div class="iq-date"><span>检测时间：<fmt:formatDate value="${list.reporttime }" pattern="yyyy-MM-dd HH:mm"/>  </span></div> 
        <div class="item"> 
            <div class="title"> ${list.testinfo }</div> 
            <div class="iq-info">
                <div class="iq-class clear">
                    <div class="iq-class-son1">名称</div>
                    <div class="iq-class-son2">参考范围</div>
                    <div class="iq-class-son3">结果</div>
                </div>
                <ul>
                	<c:forEach var="map" items="${c_map[list.sampleno]}">    
		                      <li class="iq-class clear"> 
		                        <div class="iq-class-son1">${map.itemname }<br><p>单位：${map.itemunit }</p></div>
		                        <div class="iq-class-son3">${map.normalrange }</div>
		                        <div class="iq-class-son3">${map.testresult }</div>
		                    </li>
 						</c:forEach>  
                </ul>
            </div>
            <div class="btn-more hidden">点击展开</div>
        </div>
        </c:forEach>
          

    </div>
</div>
<script>
$(function () {
    $(".iq-info").each(function () {
        if($(this).height()>375){
            $(this).addClass("maxhei");
            $(this).next(".btn-more").removeClass("hidden");
        }
    })
    $(document).on("touchend",".btn-more",function () {
        $(this).prev(".iq-info").toggleClass("maxhei");
        /*$(this).text("点击收缩");*/
       /* $(this).toggle("nomal", function(){  $(this).text()=="点击展开" ?  $(this).show().text("点击收缩"): $(this).show().text("点击展开");})*/
        if($(this).text()=='点击展开'){
            $(this).text("点击收缩");
        }
        else{
            $(this).text("点击展开")
        }
        /*$(this).text("点击收缩").show();*/
    })
})
</script>
</body>
</html>