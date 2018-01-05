<%@ page language="java" import="java.util.*,com.sn.entity.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<MsYspbMx> t_list=(List<MsYspbMx>)request.getAttribute("t_list");
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
<body class="Reg"> 
<div class="wrap">
    <header>
        <img src="<%=basePath%>source/weixin/img/logo.png">
        <span>台州市第一人民医院</span>
    </header>
    <div class="dc">  
    	<div class="date" style="text-align: center;"> 
    		<c:choose>
				   <c:when test="${firstDate==null}">   
				   	 <span style="font-size: 14px;color: red;width: 100%;left: 1%">该科室无可预约的医生</span>
				   </c:when>   
				   <c:otherwise>  
				  		<input type="text" id="Date" data-lcalendar="${firstDate },${lastDate}"  name="Date"  value="${firstDate }"/><span class="arrow-left"></span><span class="arrow-right"></span>
				   </c:otherwise>
				</c:choose>  
    	</div> 
    	<div class="date2"><p id="week">星期一</p></div>
        <div class="dctable">
        	<table>
       			 <colgroup style="width:20%"></colgroup>
                 <colgroup style="width:25%"></colgroup>
                 <colgroup style="width:20%"></colgroup>
                 <colgroup style="width:15%"></colgroup>
                 <colgroup style="width:20%"></colgroup>
            	<tr>  
                	<th>号源时段</th>
					<th>医生</th>
                    <th>剩余号数</th>
                     <th>费用</th>
                    <th></th>
                </tr> 
                </table>
                <table id="con">
                 <colgroup style="width:20%"></colgroup>
                 <colgroup style="width:25%"></colgroup>
                 <colgroup style="width:20%"></colgroup>
                 <colgroup style="width:15%"></colgroup>
                 <colgroup style="width:20%"></colgroup>
                <c:forEach items="${m_list }" var="list" >
	                <tr>
	                	<td><c:if test="${list.zblb=='1' }">上午</c:if>
			    	 	<c:if test="${list.zblb=='2' }">下午</c:if></td>
	                    <td>
		                    <p>${list.ygxm }</p>
	                        <p class="tb-job">${list.ygjb }</p>
	                    </td>
	                    <td>${list.xzpb } </td>
	                     <td>￥${list.fy } </td>
						<c:choose>
						   <c:when test="${list.xzpb==0 }">    
						   	<td><a href="#" class="lock">预约</a></td>
						   </c:when>
						   <c:otherwise>   
						    <td><a  href="javascript:sub('${list.ysdm }','${list.zblb }')">预约</a></td>
						   </c:otherwise>
						</c:choose>
	                    
	                </tr> 
			    </c:forEach>
            </table>
            <form id="myfrom" method="get" action="<%=basePath %>weixin/guser/showReservation.html"> 
	    		<input type="hidden" name="gzrq" value="">
	    		<input type="hidden" name="ksdm" value="">
	    		<input type="hidden" name="ysdm" value="">
	    		<input type="hidden" name="zblb" value="">
	    		<input type="hidden" name="zfpb" value="0"> 
	    		<input type="hidden" name="yybz" value="0">
	    		<input type="hidden" name="weixinid" value="${weixinid }">
	    		
	    	</form> 
	    	
        </div>
    </div>
</div>

<script>
	$(function() {  
		
		var date=$("#Date").val();
		var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
		var dateStr = date; 
		var myDate = new Date(Date.parse(dateStr.replace(/-/g, "/"))); 
		$("#week").html(weekDay[myDate.getDay()]); 
		
		/*日期插件调用*/
		<c:if test="${firstDate!=null}">
			var calendar = new lCalendar();
			calendar.init({
				'trigger' : '#Date', 
				'type' : 'date'
				 
			}); 
			$("#Date").focus(function() {
				document.activeElement.blur();
			});
			
			$('#Date').bind('input propertychange', function() {  
				var date=$(this).val();
				var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
				var dateStr = date; 
				var myDate = new Date(Date.parse(dateStr.replace(/-/g, "/"))); 
				$("#week").html(weekDay[myDate.getDay()]); 
				$.ajax({
		     		url:"<%=basePath%>weixin/guser/getDoctor.html",
		     		type: 'post',
		     		data:{"date":date,"ksdm":${ksdm}},
		     		dataType:"json",
		     		success:function(res){
		     			$("#con").html("");
		     			if(res!=null&&res.length>0){
		     				var ht="";
		     				for(var a=0;a<res.length;a++){
		     					var sx='上午';
		     					if(res[a].zblb=='2'){
		     						sx='下午';
		     					} 
		     					ht+='<tr>';
		     					ht+='<td>'+sx+'</td>';
		     					ht+='<td>';
		     					ht+='<p>'+res[a].ygxm+'</p>';
		     					ht+='<p class="tb-job">'+res[a].ygjb+'</p>';
		     					ht+='</td>'; 
		     					
		     					ht+='<td>'+res[a].xzpb+'</td>';
		     					ht+='<td>￥'+res[a].fy+'</td>';
		     					if(res[a].xzpb==0){
		     						ht+='<td><a href="#" class="lock">预约</a></td>';
		     					}else{
			     					ht+='<td><a href="javascript:sub('+res[a].ysdm+','+res[a].zblb+')">预约</a></td>';
		     					}
		     					ht+='</tr>';
		     				}
		     				$("#con").html(ht);
		     			}
		     		}
		     	});
			}); 
		</c:if>
		
		
	})
	 function sub(ysdm,zblb){
	  $("input[name='gzrq']").val($("#Date").val());
	  $("input[name='ksdm']").val('${ksdm}');
	  $("input[name='ysdm']").val(ysdm);
	  $("input[name='zblb']").val(zblb);
	  $("#myfrom").submit();
  }
</script>
</body>
</html>
