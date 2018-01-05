<%@ page language="java"
	import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String parentcode=request.getParameter("parentcode");		
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
  
<footer class="main-footer">
  <div class="pull-right hidden-xs">
    <b>Version</b> 1.0.6
  </div>
  <strong>Copyright &copy; 2016-2020 <a href="javascript:void(0)">台州市第一人民医院</a>.</strong> All rights
  reserved.
  
</footer> 
		<div id="pop" style="display:none;">
			<div id="popHead">
			<a id="popClose" title="关闭">关闭</a>
			<h2 style="margin-top: 0px">温馨提示</h2>
			</div>
			<div id="popContent">
			<dl>
				<dt id="popTitle"><a href="#"  >这里是参数</a></dt>
				<dd id="popIntro">这里是内容简介</dd>
			</dl>
			<p id="popMore"><a href="#"  >查看 »</a></p>
			</div>
		</div>
<!-- jQuery 2.2.3 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="<%=basePath%>js/jquery-ui.min.js"></script> 
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.6 --> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/bootstrap/js/bootstrap.min.js"></script>
	<!-- 时间控件 -->    
	<script src="<%=basePath%>js/moment.min.js"></script> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- 虚拟滚动条 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- 延迟点击 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->  
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/app.min.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/pages/dashboard.js"></script>
	
		<script type="text/javascript" src="<%=basePath%>js/jquery/drag/yanue.pop.js"></script>
	<script type="text/javascript">
	
	 setInterval("ecache()",10000);//10秒钟
	       function ecache()
	       { 
	    	   $.ajax({
	   	 		url:"<%=basePath%>weixin/attendance/ReCache.html",
	   	 		type: 'post',
	   	 		dataType:"json",
	   	 		success:function(res){  
	   	 			if(res!=null){
			   	 		showPop(res);
	   	 			}
	   	 		}
	   	 	}); 
	        }
	 function  showPop(res){
		 var pop=new Pop("您有一条新的预约信息！",
					"<%=basePath%>backstage/reservation/show.html",
					res.username+"预约了《"+res.name+"》,电话为"+res.phone+"，请尽快前去处理！");
	 }
	</script>
	