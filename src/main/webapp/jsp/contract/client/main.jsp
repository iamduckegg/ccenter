<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css?v=20190305">
	<style type="text/css">
	
    </style>
	
	<title>客户管理</title>
</head>
<body>
	<div class="layui-form clientTable"  style="height: 40px; margin-top: 2px;">
		<div class="layui-inline" style="margin-top: 5px;">
			<div class="layui-input-inline" style="width: 200px;">
		      <input type="text" id="clientName" required lay-verify="required" placeholder="客户名" autocomplete="off" class="layui-input"> 
		    </div>
			<div class="layui-btn" data-type="reload" style="margin-left: 58px;">搜索</div>
		  	<div class="layui-btn" id="cleanSearch" style="">清空</div>
		</div>
		<div class="">
			<table lay-filter="client_table" id="client_table"></table>  
		</div>
	</div>
	<script type="text/html" id="toolbar">
	<div class="layui-btn-group">
	  <button class="layui-btn" lay-event="add">增加</button>
	  <button class="layui-btn" lay-event="edit">编辑</button>
	  <button class="layui-btn" lay-event="delete">删除</button>
	</div>
	</script>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js?v=20190305"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js?v=20190305"></script>
<script>
layui.use(['form','table','laypage','laydate'], function(){
	var table = layui.table;
	var laypage = layui.laypage;
	var form = layui.form;
	var laydate = layui.laydate;

	//第一个实例
	table.render({
		elem: '#client_table'
		,url: './client/list' // 数据接口
		,height: 484
		,page: true
		,limit: 10
		,limits:[10,100]
		,data:[{},{}]
		,toolbar: "#toolbar"
		,defaultToolbar:['filter']
		,cols: [[ //表头
		     {type: 'checkbox', fixed: 'left'}
			,{type: 'numbers', title: '序号' }
			,{field: 'clientName', title: '客户名', width:120 }
			,{field: 'clientNum', title: '客户编号', width:100 }
			,{field: 'clientType', title: '客户类型', width:100 }
			,{field: 'cardNum', title: '证件号码', width:150 }
			,{field: 'site', title: '地址', width:200 }
			,{field: 'createDate', title: '创建时间', width:170 }
			,{field: 'updateDate', title: '修改时间', width:170 }
		]]
		,id:"reload"
	});
	
	//头工具栏事件
	table.on('toolbar(client_table)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    switch(obj.event){
	      case 'add':
	    	  layer.open({
				  type: 2,
				  title: '新增',
				  shadeClose: false,
				  shade: 0.8,
				  area: ['50%', '330px'],
				  content: './client/toAdd'
				});
	      break;
	      case 'edit':
	    	  var data = checkStatus.data;
	    	  if(data.length==1){
		    	  debugger;
		    	  layer.open({
					  type: 2,
					  title: '修改',
					  shadeClose: false,
					  shade: 0.8,
					  area: ['50%', '330px'],
					  content: './client/toEdit?clientId='+data[0].clientId
					});
	    	  } else if (data.length==0) {
	    		  layer.alert("请选择一条");
	    	  } else {
	    		  layer.alert("只能选择一条");
	    	  }
	      break;
	    };
	});
	
	//搜索按钮
	var $ = layui.$, active = {
	        reload: function(){
	        	var clientName = $("#clientName");
	        	
	            table.reload('reload', {
	                page: {
	                    curr: 1 //重新从第 1 页开始
	                  }
	                ,where: {
	                	clientName: clientName.val()

	                }
	            });
	        }
	    };
	
	//搜索按钮点击事件
	$('.clientTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
	
});

</script>
</html>