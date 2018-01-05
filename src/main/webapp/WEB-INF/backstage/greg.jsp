 
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>云管理 | 管理</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css">
<style>
.ibox-tools {
    display: inline-block;
    float: right;
    margin-top: 0;
    position: relative;
    padding: 0;
}
.ibox-tools a{
    cursor: pointer;
    margin-left: 5px;
} 

.btn-primary {
    background-color: #1ab394;
    border-color: #1ab394;
    color: #FFFFFF;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">

		<jsp:include page="../system/head.jsp" />
		<c:import url="/system/menuData.html"></c:import> 
		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					云管理 <small>管理</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>backstage/index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/greg/show.html">管理</a></li>
					<li class="active">列表</li>
				</ol>
			</section>

			<!-- content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">列表</h3>
								<div class="ibox-tools rboor">
			                    </div>
							</div>
							<!-- /.box-header -->
							<div class="box-body" style="border-style: solid solid none;border-color: #e7eaec;border-width: 1px 0px;">
								<table id="newAttributeTable" class="table table-bordered table-hover" style="width: 100%">
									<thead>
										<tr> 
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="../system/foot.jsp" />
	</div>
	 
	<!-- Modal2 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增</h4>
				</div>
				<form id="editForm">
					<div class="modal-body">
						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputEmail1">fuid </label> <input type="text" class="form-control" id="fuid" name="fuid" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">doctorcode </label> <input type="text" class="form-control" id="doctorcode" name="doctorcode" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">doctor </label> <input type="text" class="form-control" id="doctor" name="doctor" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">userid </label> <input type="text" class="form-control" id="userid" name="userid" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">username </label> <input type="text" class="form-control" id="username" name="username" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">phone </label> <input type="text" class="form-control" id="phone" name="phone" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">address </label> <input type="text" class="form-control" id="address" name="address" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">serviceDay </label> <input type="text" class="form-control" id="serviceDay" name="serviceDay" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">serviceHours </label> <input type="text" class="form-control" id="serviceHours" name="serviceHours" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">createdate </label> <input type="text" class="form-control" id="createdate" name="createdate" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">weixinid </label> <input type="text" class="form-control" id="weixinid" name="weixinid" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">zblb </label> <input type="text" class="form-control" id="zblb" name="zblb" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">department </label> <input type="text" class="form-control" id="department" name="department" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">jzaddress </label> <input type="text" class="form-control" id="jzaddress" name="jzaddress" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">status </label> <input type="text" class="form-control" id="status" name="status" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">queue </label> <input type="text" class="form-control" id="queue" name="queue" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">sex </label> <input type="text" class="form-control" id="sex" name="sex" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">serial </label> <input type="text" class="form-control" id="serial" name="serial" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">departmentcode </label> <input type="text" class="form-control" id="departmentcode" name="departmentcode" placeholder="">
							</div>
						<input type="hidden" id="fuid" name="fuid">
						</div>
					</div> 
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal2 -->

 
	<!-- Modal detail -->
	<div class="modal fade" id="Modal_detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="box-header with-border" style="border-bottom:0px">
						<button type="button" class="close" style="z-index: 1000" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<i class="fa fa-tv"></i>
						<h3 class="box-title">详情</h3>
					</div>
				</div>
				<div class="modal-body">
					<div class="panel-body" style="padding: 0px;font-size: 12px">
						<dl class="dl-horizontal">
							<dt>医生代码</dt>
							<dd id="d_doctorcode"></dd>
							<dt>医生姓名</dt>
							<dd id="d_doctor"></dd>
							<dt>病人姓名</dt>
							<dd id="d_username"></dd>
							<dt>手机</dt>
							<dd id="d_phone"></dd>
							<dt>地址</dt>
							<dd id="d_address"></dd>
							<dt>预约日期</dt>
							<dd id="d_serviceDay"></dd>
							<dt>就诊时间</dt>
							<dd id="d_serviceHours"></dd>
							<dt>微信ID</dt>
							<dd id="d_weixinid"></dd>
							<dt>预约部门</dt>
							<dd id="d_department"></dd>
								<dt>科室代码</dt>
							<dd id="d_departmentcode"></dd>
							<dt>就诊地址</dt>
							<dd id="d_jzaddress"></dd>
							<dt>预约状态</dt>
							<dd id="d_status"></dd>
							<dt>就诊序号</dt>
							<dd id="d_queue"></dd>
							<dt>性别</dt>
							<dd id="d_sex"></dd>
						<dt>申请时间</dt>
							<dd id="d_createdate"></dd>
						</dl>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal detail -->

	<!-- DataTable插件 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- js分页模板 --> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/handlebars-v3.0.1.js"></script>
	<!--定义操作列按钮模板-->
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script> 
	<script src="<%=basePath%>js/layer/layer.js"></script>
	 
	<script id="tpl" type="text/x-handlebars-template">
    <div class="btn-group">
  		<button type="button" class="btn btn-sm btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
   		 操作 <span class="caret"></span>
  		</button>
  		<ul class="dropdown-menu"> 
		{{#each func}}
		<li><a href="#" onclick="{{this.fn}}">{{this.name}}</a></li>
    	{{/each}}
  		</ul>
	</div>
	</script>

	<script>
 $(function() {
	  
	
})
 
 var test;
 var table;
 var editFlag = false;
 
$(function() {

	 var tpl = $("#tpl").html();
    //预编译模板
    var template = Handlebars.compile(tpl);
	 
	 table = $('#newAttributeTable').dataTable( { 
		 "processing": true, 
		 "serverSide": true,
		 "searchable": true,
		 "searching": true,
		 "bAutoWidth" : true, //是否自适应宽度
		 "bFilter" : false,
		 "drawCallback": function( settings ) {
			  
	     },
		 "aaSorting" : [[9, "desc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/greg/getDate.html",
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page()
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
						  { "data": "username",
							"title" : "病人姓名" },
							 { "data": "phone",
								"title" : "病人手机" },
						
						  { "data": "doctor",
								"title" : "预约医生" },
								  { "data": "doctorcode",
									"title" : "医生代码" },
						  { "data": "serviceDay",
								"title" : "预约日期" },
						  { "data": "serviceHours",
								"title" : "就诊时间" },
						  { "data": "department",
								"title" : "预约科室" },
						  { "data": "status",
								"title" : "预约状态" },
								  { "data": "createdate",
									"title" : "申请时间" },
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0,10 ] },   //不排序的列
					{ 
					    "targets": [1],  
					    "render": function (data,type, row,   meta) { 
					    	 if(row.hardwareInfo!=null){
						         return '<a href=javascript:showDetail("'+row.fuid+'")>'+data+'</a>';
					    	 }else{
					    		 return data;  
					    	 }	 
					    }  
					},
					  { 
						  targets: 5,
						  render: function(data,type,row,meta){ 
							  return timeForm(data);
						  } 
					  }, 
					  { 
						  targets: 8,
						  render: function(data,type,row,meta){ 
							  if(data==1){
								  return '<small class="label label-success">预约成功</small>';
							  }else{
								  return '<small class="label label-danger">取消预约</small>';
							  } 
						  } 
					  }, 
					  { 
						  targets: 9,
						  render: function(data,type,row,meta){ 
							  return timeForm1(data);
						  } 
					  }, 
					  {
	                        targets:10, 
	                        render: function (data, type, row,   meta) {
	                            var context =
	                            {
	                            		 func: [
	   	                                     {"name": "查看详情", "fn": "showDetail(\'" + row.fuid + "\')", "type": "info"} 
	   	                                   
	   	                                ]
	                            };
	                            
	                            var html = template(context);
	                            return html;
	                        }
	                    },
                ],
                "language": {
                    "lengthMenu": "_MENU_ 条记录每页",
                    "zeroRecords": "没有找到记录",
                    "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 ,共 _MAX_ 条)",
                    "infoEmpty": "无记录",
                    "infoFiltered": "(从 _MAX_ 条记录过滤)",
                    "paginate": {
                        "previous": "上一页", 
                        "next": "下一页"
                    },
                    "search": " _INPUT_"
                },
                initComplete: function () {     
                }   
     } );
	 
	 $("#save").click(add);
	  
	 $("input[type=search]").attr("placeholder","请输入病人姓名或医生代码");
 })

 	 
 	/**
     * 添加数据
     **/
    function add() {
		if(!vi()){
			return; 
		}
        $.ajax({
            url:"/backstage/greg/edit.html",
            data: $("#editForm").serialize(),
            dataType:"json",
            type:"post",
            success: function (data) {
            	table.api().ajax.reload(null, false); 
                $("#myModal").modal("hide");
                $("#myModalLabel").text("新增");
                clear();
            }
        });
    }

    /**
     *编辑方法
     **/
    function edit(fuid) {
    	$.ajax({
    		url:"<%=basePath%>backstage/greg/getEditData.html",
    		data:{"fuid":fuid},
    		dataType:"json",
    		 type:"post",
    		success:function(res){
    			var s = res.data.greg;
    			editFlag = true;
    	        $("#myModalLabel").text("修改");
    	        $("#fuid").val(s.fuid);
    	        $("#doctorcode").val(s.doctorcode);
    	        $("#doctor").val(s.doctor);
    	        $("#userid").val(s.userid);
    	        $("#username").val(s.username);
    	        $("#phone").val(s.phone);
    	        $("#address").val(s.address);
    	        $("#serviceDay").val(s.serviceDay);
    	        $("#serviceHours").val(s.serviceHours);
    	        $("#createdate").val(s.createdate);
    	        $("#weixinid").val(s.weixinid);
    	        $("#zblb").val(s.zblb);
    	        $("#department").val(s.department);
    	        $("#jzaddress").val(s.jzaddress);
    	        $("#status").val(s.status);
    	        $("#queue").val(s.queue);
    	        $("#sex").val(s.sex);
    	        $("#serial").val(s.serial);
    	        $("#departmentcode").val(s.departmentcode);
     	        $("#myModal").modal("show"); 
    		}
    	});
    }

    /**
     * 字段验证
     */ 
  function vi(){
	  var t=true;
	  if($("input[name='doctorcode']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='doctor']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='userid']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='username']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='phone']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='address']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='serviceDay']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='serviceHours']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='createdate']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='weixinid']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='zblb']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='department']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='jzaddress']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='status']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='queue']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='sex']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='serial']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='departmentcode']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  return t;
    }  
    /**
     * 清除
     */ 
    function clear() {
    	$(".modal-content").find("input").each(function (){
    		$(this).val("");
    	}) 
    	$(".modal-content").find("textarea").each(function (){
    		$(this).val("");
    	})
    	
        editFlag = false;
    }

    /**
     * 删除数据
     * @param name
     */
    function del(fuid) {
    	if (!confirm("确认要删除？")) {
            return;
        }
    	
        $.ajax({
            url: "<%=basePath%>backstage/greg/delete.html",
            data: {
                "fuid": fuid
            }, success: function (data) {
            	table.api().ajax.reload(null, false); 
            }
        });
    }
    
     
    function changeAll(){     
    	if($("#changeAll").is(':checked')){ 
    		$("input[name='_change']").each(function (){
    			$(this).prop("checked","checked");
    		})   
    	}else{  
    		$("input[name='_change']").each(function (){
    			$(this).removeAttr("checked");   
    		}) 
    	}
    }
    
    
    
    function showDetail(fuid){
		$.ajax({
	 		url:"<%=basePath%>backstage/greg/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){
	 			var s = res.data.greg;
	 				$("#d_fuid").html(s.fuid);  
	 				$("#d_doctorcode").html(s.doctorcode);  
	 				$("#d_doctor").html(s.doctor);  
	 				$("#d_username").html(s.username);  
	 				$("#d_phone").html(s.phone);  
	 				$("#d_address").html(s.address);  
	 				$("#d_serviceDay").html(timeForm(s.serviceDay));  
	 				$("#d_serviceHours").html(s.serviceHours);  
	 				$("#d_createdate").html(timeForm1(s.createdate));  
	 				$("#d_weixinid").html(s.weixinid);  
	 				$("#d_zblb").html(s.zblb);  
	 				$("#d_department").html(s.department);  
	 				$("#d_jzaddress").html(s.jzaddress);  
	 				var ss=s.status;
	 				ss=ss==1?"预约成功":"取消预约";
	 				$("#d_status").html(ss);  
	 				$("#d_queue").html(s.queue);  
	 				var sex=s.sex;
	 				sex=sex==1?"男":"女";
	 				$("#d_sex").html(sex);  
	 				$("#d_serial").html(s.serial);  
	 				$("#d_departmentcode").html(s.departmentcode);  
	        	//var cdate = new Date(s.createTime);
	        	//$("#d_createTime").html(cdate.getFullYear()+"-"+(cdate.getMonth()+1)+"-"+cdate.getDate());
	 	        $("#Modal_detail").modal("show");  
	 		}
	 	}); 
	} 
    
    //时间格式化
    function timeForm(date){ 
    	 var bdate = new Date(date);  
    	 var m=bdate.getMinutes().toString(); 
    	 m=m.length==1?"0"+m.toString() :m; 
    	 var h=bdate.getHours().toString(); 
    	 h=h.length==1?"0"+h.toString() :h; 
    	 var s=bdate.getSeconds().toString();  
    	 s=s.length==1?"0"+s.toString() :s;      
    	 var d=bdate.getDate().toString();  
    	 d=d.length==1?"0"+d.toString() :d;    
    	 var mm= (bdate.getMonth()  + 1).toString();  
    	 mm=mm.length==1?"0"+mm.toString() :mm;      
	     bdate = bdate.getFullYear() + "-" + mm + "-" + d;
    	return bdate;
    }
    function timeForm1(date){ 
   	 var bdate = new Date(date);  
   	 var m=bdate.getMinutes().toString(); 
   	 m=m.length==1?"0"+m.toString() :m; 
   	 var h=bdate.getHours().toString(); 
   	 h=h.length==1?"0"+h.toString() :h; 
   	 var s=bdate.getSeconds().toString();  
   	 s=s.length==1?"0"+s.toString() :s;      
   	 var d=bdate.getDate().toString();  
   	 d=d.length==1?"0"+d.toString() :d;    
   	 var mm= (bdate.getMonth()  + 1).toString();  
   	 mm=mm.length==1?"0"+mm.toString() :mm;      
     bdate = bdate.getFullYear() + "-" + mm + "-" + d+ " " +h + ":" + m + ":" + s;
   	return bdate;
   }
	</script>

</body>
</html>
	 
