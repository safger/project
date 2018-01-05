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
	<style type="text/css">
		a{
			text-decoration: none;
		}
	</style> 
   <script>
  /*   if ('addEventListener' in document) {
        document.addEventListener('DOMContentLoaded', function() {
            FastClick.attach(document.body);
        }, false);
    } */
	</script>
    <title>我的信息</title>
</head>
<body class="Reg">
<div class="wrap">
    <header>
        <img src="<%=basePath%>source/weixin/img/logo.png">
        <span>台州市第一人民医院</span>
    </header>
    <div class="mI">
    	<div class="myinfo">
        	<div class="mytitle">${my.name }</div>
            <div class="myinfolist">
            	<ul>
                    <li>手机号：${my.phone }</li>
                    <li>身份证：${my.idcard }</li>
                </ul>
            </div>
             <a href="<%=basePath %>weixin/guser/showUserUpdate.html?userid=${my.fuid}" class="myedit">编辑</a>
        </div>
        <a href="javascript:add()"   class="add-btn">+ 新增就诊人</a>
        <div class="miblock"></div>
        <div class="otherinfo">
            <c:forEach items="${child_list }" var="list">
            	<div class="otherlist">
	            	<div class="othertitle clear">
	                    <span class="">${list.name }</span>
	                    <span>${list.phone }</span>
	                </div>
	                <div class="otherinfolist">
	                    <ul>
	                        <li>出生日期：<fmt:formatDate value="${list.birthday }" pattern="yyyy-MM-dd"/></li>
	                        <li>身份证：${list.idcard }</li>
	                    </ul> 
	                </div>
	               <div class="otherbtn">
	                  <a  href="<%=basePath %>weixin/guser/showUserUpdate.html?userid=${list.fuid}&parentid=${my.fuid}" class="">编辑</a>
	                   <a  href="javascript:del('${list.fuid }')"  class="">删除</a>
	               </div> 
	            </div>   
        	</c:forEach> 
        </div>
    </div>
</div>
<script type="text/javascript">
 
function add(){
	window.location.href="<%=basePath %>weixin/guser/showUserUpdate.html?parentid=${my.fuid}";
	
}
function del(id){
	if(window.confirm('你确定要删除吗？')){
		window.location.href="<%=basePath %>weixin/guser/delUser.html?id="+id; 
     } 
}
</script>
</body>
</html>