<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
    <!--消除点击延迟-->
    <script src="<%=basePath%>source/weixin/js/fastclick.js"></script>
    <script>
        if ('addEventListener' in document) {
            document.addEventListener('DOMContentLoaded', function() {
                FastClick.attach(document.body);
            }, false);
        }
    </script>
    <title>门诊类目</title>
      <style type="text/css">
    a{ text-decoration:none; }
    </style>
</head>
<body class="Reg">
<div class="wrap">
    <div class="RC">
        <header>
            <img src="<%=basePath%>source/weixin/img/logo.png">
            <span>台州市第一人民医院</span>
        </header>
        <div class="rc-banner">
            <img src="<%=basePath%>source/weixin/img/rc-banner.jpg">
        </div>
        <div class="RC-con">
            <!--<a class="norbtn">普通门诊</a>
            <a class="specbtn">专家门诊</a>-->
            <h1 class="RC-title">温馨提示：</h1>
            <div class="RC-item clear">
                <p class="RC-tip">
                    1、我院采取实名制预约挂号，请准确填写您的基本信息。<br>
                    2、身份证信息与就诊信息不符者，无法获取预约的号源。<br>
                    3、儿童预约挂号，填写户口本上的身份证号，监护人手机号码，便于联络。<br>
                    4、新生儿没有身份证的，请到人工窗口预约。<br>
                </p>
                <p class="RC-call">预约电话：<a href="tel:0576-84016923">0576-84016923</a></p>
            </div>
            <h1 class="RC-title">分类选择：</h1>
            <div class="RC-item clear">
                <ul class="RC-rm">
                    <li class="clear">
                         <a href="<%=basePath %>weixin/guser/showKs.html?weixinid=${weixinid}&zjmz=0" class="left">普通门诊</a>
          				  <a  href="<%=basePath %>weixin/guser/showKs.html?weixinid=${weixinid}&zjmz=1" class="right">专家门诊</a>
                    </li>
                    <li class="clear">
                        <a href="<%=basePath %>weixin/guser/showKs.html?weixinid=${weixinid}&zjmz=3" class="left">特需门诊</a>
                        <a href="<%=basePath %>weixin/guser/showKs.html?weixinid=${weixinid}&zjmz=4" class="right">节假日门诊</a>
                    </li>
                </ul> 
            </div>
        </div>
    </div>
</div>

</body>
</html>