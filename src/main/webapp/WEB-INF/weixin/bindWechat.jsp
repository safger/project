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
</head>
<body class="Reg">
<div class="wrap">
    <header>
        <img src="<%=basePath%>source/weixin/img/logo.png">
        <span>台州市第一人民医院</span>
    </header>
    <div class="bd">
        <div class="bdimg"><img src="<%=basePath%>source/weixin/img/wechat.jpg" ></div>
       
        <c:if test="${isBind==1 }">
         <h1>您已经绑定微信</h1>
        <p>取消绑定微信后，您每次都将需要输入身份证和姓名进行登录</p>
       	 <div onclick="bind('qx')" class="btn">取消绑定</div>
        </c:if>	
         <c:if test="${isBind==0 }">
          <h1>您还没有绑定微信</h1>
        <p>绑定微信后，您每次将不用进行登录操作</p>
       	 <div onclick="bind('bd')" class="btn">绑定</div>
        </c:if>	
         <div onclick="re()" style="margin-top: 10px" class="btn">返回</div>
    </div>
</div> 
<script type="text/javascript">
function bind(type){
	
	window.location.href="<%=basePath %>weixin/guser/bindWx.html?weixinid=${weixinid}&type="+type;
}
function re(){
	window.location.href="<%=basePath %>weixin/guser/index.html";
}
</script>
</body>
</html>