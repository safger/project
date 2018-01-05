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
    <!--<script src="../<%=basePath%>source/weixin/js/fontsize.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/fontsize2.js"></script>
    <!--<script src="http://g.tbcdn.cn/mtb/lib-flexible/0.3.4/??flexible_css.js,flexible.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/jquery-1.8.3.min.js"></script>
    <script src="<%=basePath%>source/weixin/js/functions.js"></script>
    <!--日期文件-->
    <link rel="stylesheet" href="<%=basePath%>source/weixin/css/lCalendar.css">
    <script src="<%=basePath%>source/weixin/js/lCalendar.min.js"></script>
    <!--弹窗-->
    <link rel="stylesheet"   src="<%=basePath%>source/weixin/js.need/layer.css">
    <script src="<%=basePath%>source/weixin/js/layer.js"></script>
    <!--消除点击延迟-->
	<script src="<%=basePath%>source/weixin/js/fastclick.js"></script>
  <script>
    if ('addEventListener' in document) {
        document.addEventListener('DOMContentLoaded', function() {
            FastClick.attach(document.body);
        }, false);
    }
	</script> 
    <title>填写预约</title>
</head>
<body class="Reg">
    <div class="wrap">
        <header>
            <img src="<%=basePath%>source/weixin/img/logo.png">
            <span>台州市第一人民医院</span>
        </header>
        <div class="yyf yyfundo">
            <div class="yyf-title">门诊信息</div>
            <div class="yyf-form">
                <ul>
                    <li class="clear">
                        <div class="yyf-class">就诊医院：</div>
                        <div class="yyf-con">台州市第一人民医院</div>
                    </li>
                    <li class="clear">
                        <div class="yyf-class">就诊医生：</div>
                        <div class="yyf-con">${msYspbMx.ygxm }</div>
                    </li>
                    <li class="clear">
                        <div class="yyf-class">就诊科室：</div>
                        <div class="yyf-con">${msYspbMx.ksmc }</div>
                    </li>

                    <li class="clear">
                        <div class="yyf-class">就诊日期：</div>
                        <div class="yyf-con"><fmt:formatDate value="${msYspbMx.gzrq }" pattern="yyyy-MM-dd"/></div>
                    </li>
                     <li class="clear">
                        <div class="yyf-class">就诊地址:：</div>
                        <div class="yyf-con">${msYspbMx.ksdd }</div>
                    </li>
                     <li class="clear">
                        <div class="yyf-class">就诊序号:：</div>
                        <div id="jzxh" class="yyf-con">${msYspbMx.jzxh }</div>
                    </li> 
                </ul>
            </div>
        </div>
       <form action="<%=basePath%>weixin/guser/reservation.html" method="post" id="myform">
        <div class="yyf yyfdo">
            <div class="yyf-title">请选择</div>
            <div class="yyf-form"> 
                <ul> 
                    <li class="clear">
                        <div class="yyf-class"><i style="margin-right: 5px;color: red;">*</i>就诊时间：</div>
                        <div class="yyf-ipt">
                            <select name="serviceHours" style="max-width: 100%">
                            	<c:forEach items="${ms_yspb }" var="list">
                            	<option jzxh="${list.jzxh }">${list.jzsj }</option>
                            	</c:forEach> 
                            </select> 

                        </div>
                    </li>
                    <li class="clear yyfpeople">
                        <div class="yyf-class"><i style="margin-right: 5px;color: red;">*</i>就诊人：</div>
                        <div class="yyf-ipt"> <span id="br">请选择就诊人</span>
                       	 <input type="hidden"  name="userid"  value="">
                        </div>
                    </li>
                </ul>
            </div>
        </div>
            <div class="btn">
                <input type="submit"  value="提交"> 
                    <input type="hidden" name="weixinid"  value="${weixinid}" />
                   <input type="hidden" name="serviceDay"  value="<fmt:formatDate value="${msYspbMx.gzrq }" pattern="yyyy-MM-dd"/>" />
                   <input type="hidden" name="department"  value="${msYspbMx.ksmc }" />
                   <input type="hidden" name="departmentcode"  value="${msYspbMx.ksdm }" />
                   <input type="hidden" name="doctor"  value="${msYspbMx.ygxm }" />
                   <input type="hidden" name="doctorcode"  value="${msYspbMx.ysdm }" /> 
                   <input type="hidden" name="zblb"  value="${msYspbMx.zblb }" /> 
                    <input type="hidden" name="jzaddress"  value="${msYspbMx.ksdd }" /> 
                     <input type="hidden" name="jzxh"  value="${msYspbMx.jzxh }" /> 
            </div>
        </form>

        <div class="dialog dia-chos hidden">
           <div class="diawrap">
               <div class="diaChtitle">就诊人</div>
               <div class="diaInfo">
                   <ul>	
                   	<c:forEach items="${g_list }" var="list" >
                   	 <li class="clear" onclick="chang('${list.fuid }','${list.name }')">
                           <div class="hspp">${list.name }</div>
                           <div class="hstel">${list.phone }</div>
                       </li>
                   	</c:forEach>
                   </ul>
               </div>
           </div>
        </div>
    </div>
     
<script>
$(function () {
    var content=$(".dialog").html() 
    $(".yyfpeople").on("touchend",function () {
        layer.open({
            content: content
            ,btn: ['取消', '确定']
            ,yes: function(index){
                layer.close(index);
            },
            no: function(index){
                layer.close(index);
            }
        });
        return false
    })

    $(document).on("touchend",".diaInfo li",function () {
        $(this).addClass("active").siblings("li").removeClass("active");
    })
    var checkSubmitFlg = false; 
    $("#myform").submit(function (e){
    	if(checkSubmitFlg ==true){ 
    		return false;  
    	} 
    	var t=true;
    	var userid=$("input[name='userid']").val();
    	if(userid==null||userid.length==0){
    		alert("请选择就诊病人");
    		 t=false;; 
    	}  
    	if(t){  
    		checkSubmitFlg =true; 
	    	return true;  
    	}else{ 
    		return false;   
    	}
    });
    
    $("select[name='serviceHours']").change(function (){
    	var jzxh=$(this).find("option:selected").attr("jzxh")
    	$("#jzxh").html(jzxh); 
    	$("input[name='jzxh']").val(jzxh);
    }) 
})
function chang(userid,username){
	$("#br").html(username);  
	$("input[name='username']").val(username);
	$("input[name='userid']").val(userid);
}
 
</script>

</body>
</html>