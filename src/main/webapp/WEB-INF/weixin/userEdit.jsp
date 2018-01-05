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
<body class="Reg bg1">
    <div class="wrap">
        <header>
            <img src="<%=basePath%>source/weixin/img/logo.png">
            <span>台州市第一人民医院</span>
        </header>
        <form method="get" id="myform" action="<%=basePath %>weixin/guser/updateUser.html">
        <div class="content">
            <div class="rg">
                <ul class="list">
                 <li class="LipicCer"><label>身份证</label><input type="text" name="idcard" class="infos" value="${my.idcard }" placeholder="请认真正确填写，否则将无法挂号" /></li>
                    <li><label>姓名</label><input id="name" type="text" name="name" placeholder=""  value="${my.name }"></li>
                  <%--   <li><label>用户性别</label><input id="man" name="sex" type="radio"  value="1" class="sexinp" checked><label for="man" class="sexlabel">男</label> <input id="women"  name="sex"type="radio"  value="2" class="sexinp"><label for="women" class="sexlabel">女</label></li>
                    <li><label>出生日期</label><input type="text" id="Date"  name="birthday" value="<fmt:formatDate value="${my.birthday }" pattern="yyyy-MM-dd"/>" class="data" /></li> --%>
                    <li class="Liphone"><label>手机号码</label><input type="number" name="phone" class="infos phonenum" placeholder="" value="${my.phone }" /></li>
                    
                </ul> 
                	<input type="hidden" value="${my.fuid }" name="fuid" />
                	<input type="hidden" value="${parentid }" name="parentid" /> 
                <div class="submit"><input type="button" onclick="sub()" value="保存" class="rgbtn"></div>
            </div> 
        </div> 
        </form>
        <dtv id="er" class="txterror"></dtv>
    </div>
<script>
    /*输入位数验证*/
    NumVerify(".phonenum",".send1")
    /*验证码倒计时*/
    CountDown(".phonenum",".send1");

    $(function () {
        /*日期插件调用*/
      /*   var calendar = new lCalendar();
        calendar.init({
            'trigger': '#Date',
            'type': 'date',
        });
        $("#Date").focus(function(){
            document.activeElement.blur();
        }); */
        $("input[name='sex']").each(function (){ 
        	if($(this).val()=='${my.sex }'){
        		$(this).attr("checked","checked");
        	}
        }) 
        
        var error='${error}';
		if(error.length>0){
			$("#er").html(error); 
			$("#er").css("display","block");
		}
    })
    
    function vi(){
    	var t=true;
    	var name=$("#name").val();
    	if(name==null||name.length==0){
    		$(".txterror").html("请输入姓名");
    		$(".txterror").css("display","block");
    		t=false;
    		return;
    	}
    	/* var birthday=$("input[name='birthday']").val();
    	if(birthday==null||birthday.length==0){
    		$(".txterror").html("请输入出生日期");
    		$(".txterror").css("display","block");
    		t=false;
    		return;
    	} */ 
    	 var phone = $("input[name='phone']").val();
    	    if(!(/^1[34578]\d{9}$/.test(phone))){ 
    	    	$(".txterror").html("手机号码格式错误");
        		$(".txterror").css("display","block");
    	        return false; 
    	    }  
    	var idcard=$("input[name='idcard']").val();
    	if(idcard==null||idcard.length==0){
    		$(".txterror").html("请输入身份证");
    		$(".txterror").css("display","block");
    		t=false;
    		return;
    	}
    	//身份证正则表达式(15位)    
    	var isIDCard1=/^[1-9](\d{16}|\d{13})[0-9xX]$/;
    	  //身份证正则表达式(18位)    
    	var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
    	if(isIDCard1.test(idcard)||isIDCard2.test(idcard)){
    	}else{
    		$(".txterror").html("请输入正确身份证");
    		$(".txterror").css("display","block");
    		t=false;
    		return;
    	}
     
    	return t;
    }
    
    function sub(){
    	if(!vi()){
    		return;
    	}
    	$("#myform").submit();
    }
</script>

</body>
</html>