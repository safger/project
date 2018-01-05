<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link rel="stylesheet" href="<%=basePath%>source/weixin/css/style.css">
<!--日期文件-->
<link rel="stylesheet"
	href="<%=basePath%>source/weixin/css/lCalendar.css">

</head>
<body class="Reg bg1">
	<div class="wrap">
		<header>
			<img src="<%=basePath%>source/weixin/img/logo.png"> <span>台州市第一人民医院</span>
		</header>
		<form method="get" id="myform" name="myform"
			action="<%=basePath%>weixin/guser/reg.html">
			<div class="content">
				<div style="color: red;">请认真填写姓名与身份证。如果姓名和身份证不符合，将无法预约</div>
				<!-- class="rg-tip" -->
				<div class="rg">
					<ul class="list">
						<li class="LipicCer"><label><i>*</i>身份证</label><input
							type="text" placeholder="请认真填写，身份证错误预约将无效" name="idcard"
							class="infos" /></li>
						<li><label><i>*</i>姓名</label><input id="name" type="text"
							name="name" placeholder="请输入姓名" value=""></li>
							<!-- <li class="verifyimg"><label><i>*</i>图形验证码</label><input style="calc(100% - 120px)" 
							type="text" id="vertify" class="infos vertify"  placeholder="填写正确的图形验证码后才能发送短信验证" /><a style="width:  120px"
							class="verimg"><img style="width: 120px;height: 30px" 
								onclick="createCodeImg()" id="imgcode" src=""> </a></li> -->
						<li class="Liphone"><label><i>*</i>手机号码</label><input 
							type="number" id="phone"   class="infos phonenum"
							placeholder="请输入手机" /> <a style="width:  120px" class="send1 undone">发送验证码</a></li>
						<li><label><i>*</i>手机验证码</label><input id="Verification"
							type="number" maxlength="6" autocomplete="off" placeholder=""
							name="verification" value=""></li>

						<input type="hidden" name="weixinid"
							t="${sessionScope.gweixinid }" value="${weixinid }" id="weixinid" />
						<input  type="hidden"   name="vcode"  value=""  />

						<!-- 	<li style="font-size: 14px;color: red;">注册功能正在维护中，暂时无法注册 </li>    -->

					</ul>
					<div class="submit">
						<div onclick="sub()" class="rgbtn">注册</div>
					</div>
				</div>
			</div>
		</form>
		<dtv id="er" class="txterror"></dtv>
	</div>

	<script src="<%=basePath%>source/weixin/js/jquery-1.8.3.min.js"></script>
	<script src="<%=basePath%>source/weixin/js/fontsize2.js"></script>
	<script src="<%=basePath%>source/weixin/js/functions.js"></script>
	<script src="<%=basePath%>js/layer/layer.js"></script>
	<script>
		/*输入位数验证*/
		NumVerify(".phonenum", ".send1")
		///*验证码倒计时*/
		CountDown(".phonenum", ".send1");

		$(function() {
			
			//createCodeImg();
			
			var error='${error}';
			if(error.length>0){ 
				$("#er").html(error); 
				$("#er").css("display","block");
			}
		})
		
		 
		   //图片验证码
    function createCodeImg(){ 
    	 $("#imgcode").attr("src",""); 
    	var weixinid='${weixinid }'; 
    	if(weixinid.length==0){ 
    		layer.msg("个人信息获取失败，请关闭页面重试！");
			return;
    	} 
        $.ajax({
    		url:"<%=basePath%>/weixin/guser/VaildateImg.html",
    		data:{"weixinid":weixinid},
    		dataType:"text",  
    		method:"post", 
    		success:function(res){
    			if(res=='error'){
    				layer.msg("个人信息获取失败，请关闭页面重试！");
    				$(".txterror").html("个人信息获取失败，请关闭页面重新打开！");
    	    		$(".txterror").css("display","block");
    				return;
    			}
    			 $("#imgcode").attr("src","<%=basePath%>"+res+"?date="+new Date().getTime());
    		}
    	});
    }
    function vi(){
    	var t=true;
    	var name=$("#name").val();
    	if(name==null||name.length==0){
    		$(".txterror").html("请输入姓名");
    		$(".txterror").css("display","block");
    		t=false;
    		return;
    	}
    	/*   var Verification=$("#Verification").val();
    	if(Verification==null||Verification.length==0){
    		$(".txterror").html("请输入验证码");
    		$(".txterror").css("display","block");
    		t=false; 
    		return;
    	}   */
    	var phone=$("#phone").val();
    	if(phone==null||phone.length==0){
    		$(".txterror").html("请输入手机");
    		$(".txterror").css("display","block");
    		t=false;
    		return;
    	}
    	var idcard=$("input[name='idcard']").val();
    	if(idcard==null||idcard.length==0){
    		$(".txterror").html("请输入身份证");
    		$(".txterror").css("display","block");
    		t=false;
    		return;
    	}
    	//身份证正则表达式(15位)     
    	//身份证正则表达式(15位)      /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;    
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
    var checkSubmitFlg = false; 
    function sub(){
    	if(!vi()){ 
    		return;
    	}  
    	if(checkSubmitFlg ==true){ 
    		return;  
    	}  
    	checkSubmitFlg =true; 
    	var weixinid='${weixinid }'; 
    	if(weixinid.length==0){ 
    		$("#er").html("个人信息获取失败，请关闭页面重试！"); 
			$("#er").css("display","block");
    		layer.msg("个人信息获取失败，请关闭页面重试！");
			return;
    	}  
    	var phone=$("#phone").val(); 
    	$("input[name='vcode']").val(phone);
    	$("#myform").attr("action","<%=basePath%>weixin/guser/reg.html?phone="+phone);
    	$("#myform").submit();
     
    }
	</script> 

</body>
</html>