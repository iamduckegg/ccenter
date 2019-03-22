<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css?v=20190305">
	<style type="text/css">
        .layui-table-cell {
            height: auto;
            line-height: 22px;
        }
    </style>
	
	<title>工单列表</title>
</head>
<body class="layui-layout-body" >
<div class="layui-layout layui-layout-admin orderTable">
  <div class="layui-header" style="height: 55px;">
  	<div class="layui-logo">呼叫中心</div>
  </div>
  <div class="layui-form"  style="height: 40px; margin-top: 2px;">
  	  <div class="layui-inline" style="margin-top: 5px;">
	    <div class="layui-input-inline" style="width: 200px;">
	      <input type="text" id="ticketNum" required lay-verify="required" placeholder="工单编号" autocomplete="off" class="layui-input"> 
	    </div>
	    <div class="layui-input-inline" style="width: 200px;">
	      <input type="text" id="subject" required lay-verify="required" placeholder="标题" autocomplete="off" class="layui-input"> 
	    </div>
	    <div class="layui-input-inline" style="width: 200px;">
	      <input type="text" id="carNumber" required lay-verify="required" placeholder="车牌号" autocomplete="off" class="layui-input"> 
	    </div>
	    <div class="layui-input-inline" style="width: 200px;">
	      <input type="text" id="clientName" required lay-verify="required" placeholder="公司名称" autocomplete="off" class="layui-input"> 
	    </div>
	    <div class="layui-input-inline" style="width: 200px;">
		    <select id="faultType" lay-verify="">
			  	<option value="">故障类型</option>
				<option value="158032" >刹车故障</option>
				<option value="158035">挂不上挡</option>
				<option value="158038">充不上电，仪表盘黑屏</option>
				<option value="158041">没有前进挡和倒退挡</option>
				<option value="164011">车辆异常抖动</option>
				<option value="164014">车辆电机不转</option>
				<option value="164017">慢充线报高温</option>
				<option value="164020">车辆行驶途中断电</option>
				<option value="158044">其它</option>
			</select>     
	    </div>
	    <div class="layui-input-inline" style="width: 200px;">
		    <select id="ticketStatus" lay-verify="">
			  	<option value="">工单状态</option>
				<option value="1" >新建</option>
				<option value="2">已开启</option>
				<option value="3">待回应</option>
				<option value="4">已解决</option>
				<option value="5">自动关闭</option>
				<option value="6">手动关闭</option>
			</select>     
	    </div>
	  </div>
	  <div class="layui-inline" style="margin-top: 5px;">
	    <div class="layui-input-inline" style="width: 200px;">
		    <select id="priorityLevel" lay-verify="">
			  	<option value="">工单优先级</option>
				<option value="1" >低</option>
				<option value="2">正常</option>
				<option value="3">高</option>
				<option value="4">紧急</option>
			</select>     
	    </div>
	    <div class="layui-input-inline" style="width: 200px;">
		    <select id="ticketTemplateId" lay-verify="">
			  	<option value="">工单模板</option>
				<option value="2">默认</option>
				<option value="3">我要用车</option>
				<option value="4">我要投诉</option>
				<option value="5">我要报修</option>
				<option value="6">维修工单(内部)</option>
				<option value="7">销售工单(内部)</option>
				<option value="8">回访工单(内部)</option>
				<option value="10">我要买车</option>
				<option value="11">运维工单(内部)</option>
				<option value="13">绿城一修</option>
			</select>     
	    </div>
	    <div class="layui-input-inline">
		  <input type="text" class="layui-input" id="startDate" style="width: 194px;" placeholder="开始报修日期">
		</div>
		<span>~</span>
	    <div class="layui-input-inline">
		  <input type="text" class="layui-input" id="endDate" style="width: 194px;" placeholder="结束报修日期">
		</div>
	  	<div class="layui-btn" data-type="reload" style="margin-left: 58px;">搜索</div>
	  	<div class="layui-btn" id="cleanSearch" style="">清空</div>
	  </div>
	  <div class="">
	  	<table lay-filter="order" id="call_order"></table>  
	  </div>
	  <script type="text/html" id="toolbarDemo">
		<div class="layui-btn-container">
    		<div class="layui-btn" lay-event="export">导出</div>
  		</div>	
	  </script >
  	</div>
  </div>
  <div class="layui-footer" style="left: 0" >
  </div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js?v=20140829"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js?v=20140829"></script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="view" >查看</a>
</script>
<script>
layui.use(['form','table','laypage','laydate'], function(){
	var table = layui.table;
	var laypage = layui.laypage;
	var form = layui.form;
	var laydate = layui.laydate;
	
	//监听行工具事件
	table.on('tool(order)', function(obj){
		var ticketId = obj.data.ticketId;
		debugger;
		if(obj.event=="view"){
			layer.open({
			  type: 2,
			  title: '工单预览',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['780px', '90%'],
			  content: './detail?ticketId='+ticketId
			});
		}
	});
	
	//头工具事件
	table.on('toolbar(order)', function(obj){
		var checkStatus = table.checkStatus(obj.config.id);
		var data = checkStatus.data;
		if(obj.event=="export"){
			table.exportFile(obj.config.id, data);
		}
	});
	
	//第一个实例
	table.render({
		elem: '#call_order'
		,height: 500
		,url: './list' // 数据接口
		,page: true
		,limit: 10
		,limits:[10,100]
		,data:[{},{}]
		,toolbar: true
		,defaultToolbar:['filter']
		,cols: [[ //表头
		     {type: 'checkbox', fixed: 'left'}
			,{field: 'ticketNum', title: '工单编号', width:190}
			,{field: 'ticketStatus', title: '工单状态', width:100 , templet: getStatus }
			,{field: 'subject', title: '标题', width:120 }
			,{field: 'faultDescribe', title: '工单描述', width:200}
			,{field: 'clientName', title: '公司名称', width:120}
			,{field: 'phone', title: '联系方式', width:130}
			,{field: 'servicerName', title: '客服', width:140}
			,{field: 'priorityLevel', title: '优先级', width:80 , templet: getLevel }
			,{field: 'carNumber', title: '车牌号', width:135}
			,{field: 'callDate', title: '报修日期', width:120}
			,{field: 'finishDate', title: '修复日期', width:120}
			,{field: 'faultSite', title: '故障地点', width:160}
			,{field: 'faultType', title: '故障类型', width:100}
			,{field: 'control', title: '操作', width:100, toolbar: '#barDemo'}
		]]
		,id:"reload"
	});
	
	//搜索按钮
	var $ = layui.$, active = {
	        reload: function(){
	        	var ticketNum = $("#ticketNum");
	        	var subject= $("#subject");
	        	var faultType = $("#faultType");
	        	var carNumber = $("#carNumber");
	        	var ticketStatus = $("#ticketStatus");
	        	var priorityLevel = $("#priorityLevel");
	        	var ticketTemplateId = $("#ticketTemplateId");
	        	var startDate = $("#startDate");
	        	var endDate = $("#endDate");
	        	var clientName = $("#clientName");
	        	
	            table.reload('reload', {
	                page: {
	                    curr: 1 //重新从第 1 页开始
	                  }
	                ,where: {
	                	 ticketNum: ticketNum.val()
	                	,subject: subject.val()
	                	,faultType: faultType.val()
	                	,carNumber: carNumber.val()
	                	,ticketStatus: ticketStatus.val()
	                	,priorityLevel: priorityLevel.val()
	                	,ticketTemplateId: ticketTemplateId.val()
	                	,startDate: startDate.val()
	                	,endDate: endDate.val()
	                	,clientName: clientName.val()
	                }
	            });
	        }
	    };
	
	//搜索按钮点击事件
	$('.orderTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
	
	//搜索条件清空
	$("#cleanSearch").click( function () { 
		$("#ticketNum").val("");
		$("#subject").val("");
		$("#faultType").val("");
		$("#carNumber").val("");
		$("#ticketStatus").val("");
    	$("#priorityLevel").val("");
    	$("#ticketTemplateId").val("");
    	$("#startDate").val("");
    	$("#endDate").val("");
    	$("#clientName").val("");
		form.render();
	});
	
	  //执行一个laydate实例
	laydate.render({
	    elem: '#startDate' //指定元素
	});
	  //执行一个laydate实例
	laydate.render({
	    elem: '#endDate' //指定元素
	});
	
});

//表格中工单状态
function getStatus(data){
	if(data.ticketStatus==1){
		return "新建";
	} else if(data.ticketStatus==2){
		return "已开启";
	} else if(data.ticketStatus==3){
		return "待回应";
	} else if(data.ticketStatus==4){
		return "已解决";
	} else if(data.ticketStatus==5){
		return "自动关闭";
	} else if(data.ticketStatus==6){
		return "手动关闭";
	} else {
		return "";
	}
}
//表格中优先级
function getLevel(data){
	if(data.priorityLevel==1){
		return "低";
	} else if(data.priorityLevel==2){
		return "正常";
	} else if(data.priorityLevel==3){
		return "高";
	} else if(data.priorityLevel==4){
		return "紧急";
	} else {
		return "";
	}
}

</script>
</html>