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
    <link rel="stylesheet" href="<%=basePath%>source/weixin/css/style.min.css">
    <script src="<%=basePath%>source/weixin/js/fontsize2.js"></script>
    <script src="<%=basePath%>source/weixin/js/jquery-1.8.3.min.js"></script>
    <script src="<%=basePath%>source/weixin/js/functions.js"></script>
</head>
<body class="Reg ">
<div class="wrap">
    <header>
        <img src="<%=basePath%>source/weixin/img/logo.png">
        <span>台州市第一人民医院</span>
    </header>
    <div class="myyy">
        <ul>
        	<c:forEach items="${reg_list }" var="list">
	        	<li class="clear" onclick="rexx('${list.fuid }')">
	                <div class="myyy-name">就诊人：<span>${list.username }</span></div>
	                <div class="myyy-info">
	                    <ul>
	                        <li>就诊医生：${list.doctor }</li>
	                        <li>就诊科室：${list.department }</li>
	                        <li>就诊日期：<fmt:formatDate value="${list.serviceDay }" pattern="yyyy-MM-dd"/></li>
	                        <li>申请日期：<fmt:formatDate value="${list.createdate }" pattern="yyyy-MM-dd HH:mm"/></li>
	                        <li>预约状态：
								<c:choose>
								   <c:when test="${list.status!=2 }">    
								   	 预约成功
								   </c:when>
								   <c:otherwise>   
								   <span style="color: red;">取消预约</span>
								   </c:otherwise>
								</c:choose>
							</li>
	                    </ul>
	                </div>
	                <a class="myyy-a">详情</a>
	            </li>
        	</c:forEach>
             
        </ul>
    </div>
</div>
</body>
<script type="text/javascript">
function rexx(id){
	
	window.location.href="<%=basePath %>weixin/guser/reservationInfo.html?id="+id;
}
</script>
</html>
