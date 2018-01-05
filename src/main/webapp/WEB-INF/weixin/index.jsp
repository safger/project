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
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />	 
    <title>台州市第一人民医院微信预约挂号</title>
   <link rel="stylesheet" href="<%=basePath%>source/weixin/css/style.min.css">
    <!--<script src="../<%=basePath%>source/weixin/js/fontsize.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/fontsize2.js"></script>
    <!--<script src="http://g.tbcdn.cn/mtb/lib-flexible/0.3.4/??flexible_css.js,flexible.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/jquery-1.8.3.min.js"></script>
    <script src="<%=basePath%>source/weixin/js/functions.js"></script>
    <!--日期文件-->
    <link rel="stylesheet" href="<%=basePath%>source/weixin/css/lCalendar.css">
    <script src="<%=basePath%>source/weixin/js/lCalendar.min.js"></script>
    <style type="text/css">
    a{ text-decoration:none; }
    </style>
</head>
<body class="Reg">
<div class="wrap wrap2">
    <div class="idwrap">
        <div class="idhead"> 
         <!--   <div class="new-old-tip">您还未登录您还未登录您还未登录您还未登录您还</div> -->
            <img srcset="<%=basePath%>source/weixin/img/logo2.png">
            <div class="idtip">
            	<c:choose>
				   <c:when test="${sessionScope.guserid==null}">   
				   	  您还未登录，请先<a  style=" text-decoration:none;" href="<%=basePath %>weixin/guser/showLogin.html?weixinid=${weixinid}">登录</a>或<a  style=" text-decoration:none;" href="<%=basePath %>weixin/guser/showReg.html?weixinid=${weixinid}">注册</a>
				   </c:when>   
				   <c:otherwise>  
				  		 祝您健康，${sessionScope.gusername}！ 点击<a style=" text-decoration:none;" href="<%=basePath %>weixin/guser/loginOut.html?weixinid=${weixinid}">退出登录</a>
				   </c:otherwise>
				</c:choose>
            </div>
        </div>

        <div class="iditem"> 
            <div class="idleft">
           	 <a class="block" href="<%=basePath %>weixin/guser/showKsCh.html?weixinid=${weixinid}">
                   <div class="idleftcon">
                     <div><img src="<%=basePath%>source/weixin/img/yuyue.jpg"></div>
                    <h1>预约挂号</h1>
                    <p>台州市一医快速预约挂号</p>
                 <p> 预约电话： 0576-84016923 </p>  
                   
                   </div>
               </a>
            </div>
            <div class="idright">
				<div class="id-chaxun">
                	<a href="<%=basePath %>weixin/checkQuery/queryType.html?weixinid=${weixinid}" class="block">
                        <div class="center">
                            <div class="cxtitle"><img src="<%=basePath%>source/weixin/img/chaxun.jpg"><span>检验查询</span></div>
                            <p>台州市一医快速检验查询结果</p>
                        </div>
                    </a>
                </div>
                <div class="borbtm clear">
                	<div class="id-box">
                	<a href="<%=basePath %>weixin/guser/showUserInfo.html?weixinid=${weixinid}" class="block">
                        <div class="center">
                            <img src="<%=basePath%>source/weixin/img/user.jpg">
                            <h1>我的信息</h1>
                   		</div>
                     </a>
            	</div>
                <div class="id-box borleft ">
                	<a class="block"  href="<%=basePath %>weixin/guser/showBwx.html?weixinid=${weixinid}">
                        <div class="center">
                            <img src="<%=basePath%>source/weixin/img/bangd.jpg">
                            <h1>绑定微信</h1>
                   		</div>
                     </a> 
            	</div>
                </div> 
                <div class="clear borbtm">
                	<div class="id-box"> 
                	<a  href="<%=basePath %>weixin/guser/showContactus.html?weixinid=${weixinid}" class="block">
                        <div class="center">
                            <img src="<%=basePath%>source/weixin/img/link.jpg">
                            <h1>联系我们</h1>
                   		</div>
                     </a>
            	</div>
                <div class="id-box borleft"> 
                	<a class="block" href="<%=basePath %>weixin/guser/showMyReservation.html?weixinid=${weixinid}">
                        <div class="center">
                            <img src="<%=basePath%>source/weixin/img/my.jpg">
                            <h1>我的预约</h1>
                   		</div>
                     </a> 
            	</div>
                </div>
            </div>
            
        </div>
    </div>
</div>

</body>

 
</html>
