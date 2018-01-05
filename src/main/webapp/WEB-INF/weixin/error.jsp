<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <link rel="stylesheet" href="<%=basePath%>source/weixin/css/style.min.css">
    <!--<script src="../<%=basePath%>source/weixin/js/fontsize.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/fontsize2.js"></script>
    <!--<script src="http://g.tbcdn.cn/mtb/lib-flexible/0.3.4/??flexible_css.js,flexible.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/jquery-1.8.3.min.js"></script>
    <script src="<%=basePath%>source/weixin/js/functions.js"></script>
    <!--日期文件-->
    <link rel="stylesheet" href="<%=basePath%>source/weixin/css/lCalendar.css">
    <script src="<%=basePath%>source/weixin/js/lCalendar.min.js"></script>
    <title>联系我们</title>
</head>
<body class="Reg">
<div class="wrap">
    <header>
        <img src="<%=basePath%>source/weixin/img/logo.png">
        <span>台州市第一人民医院</span>
    </header> 
    <div class="error">
        <div class="banner"><img src="<%=basePath%>source/weixin/img/id-banner.jpg"> </div>
        <div class="er-img"><img src="<%=basePath%>source/weixin/img/tanhao.jpg"> </div>
        <p class="er-p">${error }</p>
    </div>
     <%-- <a class="er-back" href="<%=basePath%>weixin/guser/index.html?weixinid=${weixinid}">返回</a>   --%>
</div>
</body>
</html>
