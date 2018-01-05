<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="yes" name="apple-touch-fullscreen">
<meta name="format-detection" content="telephone=no" />
<meta content="email=no" name="format-detection" />
<meta name="x5-fullscreen" content="true">
<link rel="stylesheet"
	href="<%=basePath%>source/weixin/css/style.min.css">
<script src="<%=basePath%>source/weixin/js/fontsize2.js"></script>
<script src="<%=basePath%>source/weixin/js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>source/weixin/js/functions.js"></script>
</head>
<body class="Reg ">
	<div class="wrap">
		<header>
			<img src="<%=basePath%>source/weixin/img/logo.png"> <span>台州市第一人民医院</span>
		</header>
		<div class="yyxq">
			<div class="yyxq-list">
				<ul>
					<li class="clear"><div class="yyxq-class">就诊人:</div>
						<div class="yyxq-con">${greg.username }</div></li>
					<li class="clear"><div class="yyxq-class">联系电话:</div>
						<div class="yyxq-con">${greg.phone }</div></li>
					<li class="clear"><div class="yyxq-class">就诊科室:</div>
						<div class="yyxq-con">${greg.department }</div></li>
					<li class="clear"><div class="yyxq-class">就诊医生:</div>
						<div class="yyxq-con">${greg.doctor }</div></li>
					<li class="clear"><div class="yyxq-class">就诊日期:</div>
						<div class="yyxq-con">
							<fmt:formatDate value="${greg.serviceDay }" pattern="yyyy-MM-dd" />  <span id="week"></span>
						</div></li>
					<li class="clear"><div class="yyxq-class">就诊时间:</div>
						<div class="yyxq-con">${greg.serviceHours }</div></li>
						<li class="clear"><div class="yyxq-class">就诊序号:</div>
						<div class="yyxq-con">${greg.queue }</div></li> 
					<li class="clear"><div class="yyxq-class">就诊地址:</div>
						<div class="yyxq-con">${greg.jzaddress }</div></li>
					<li class="clear"><div class="yyxq-class">申请日期:</div>
						<div class="yyxq-con">
							<fmt:formatDate value="${greg.createdate }"
								pattern="yyyy-MM-dd HH:mm" />
						</div></li>
					<li class="clear"><div class="yyxq-class">预约状态:</div>
						<div class="yyxq-con">
							<c:choose>
								<c:when test="${greg.status!=2 }">    
								   	 预约成功
				 				   </c:when>
								<c:otherwise>
									<span style="color: red;">取消预约</span>
								</c:otherwise>
							</c:choose>
						</div></li>
				</ul>
			</div>
			<c:choose>
				<c:when test="${greg.status!=2&&qx!=1 }"> 
					<div onclick="qx('${greg.fuid }')" class="btn btn-cancle">取消预约</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</body>
<script type="text/javascript">
function qx(id){
	if(window.confirm('您确定要取消预约吗？')){
		window.location.href="<%=basePath%>weixin/guser/cancelReservation.html?id="+ id;
     } 
	}
	
	
var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
var dateStr = '<fmt:formatDate value="${greg.serviceDay }" pattern="yyyy-MM-dd" />'; 
var myDate = new Date(Date.parse(dateStr.replace(/-/g, "/"))); 
$("#week").html(weekDay[myDate.getDay()]);  
</script>
</html>
