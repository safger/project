<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
     <style type="text/css">
    a{ text-decoration:none; }
    </style>
    <script src="<%=basePath%>source/weixin/js/lCalendar.min.js"></script>
</head>
<body class="Reg bg1">
<div class="wrap">
    <header>
        <img src="<%=basePath%>source/weixin/img/logo.png">
        <span>台州市第一人民医院</span>
    </header>
   	<div class="logintop"></div>
    <div class="lgform">
		<form action="<%=basePath %>weixin/guser/login.html" method="get">
        	<div class="ipt">
            	<input type="text" placeholder="请输入身份证" name="idcard"  class="idcard"/>
            </div>
            <div class="ipt">
            	<input type="text" placeholder="请输入姓名" name="name"  class="name"/>
            	<input type="hidden"  name="weixinid"   value="${weixinid }" />
            </div> 
            <div class="lgbtn btn">
            	<input type="submit"  value="登录">
            </div>  
        </form> 
        <a href="<%=basePath %>weixin/guser/showReg.html?weixinid=${weixinid}" class="lgrg btn">注册</a>
    </div>
    
    <dtv id="er" class="txterror"  ></dtv>
</div>


</body>

<script type="text/javascript">
var error='${error}';
if(error.length>0){
	$("#er").html(error);  
	$("#er").css("display","block"); 
	
}
</script>
</html>
