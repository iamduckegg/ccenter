<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css?v=20190305">

<title>新增客户</title>
</head>
<body class="">
	<div style="padding: 10px 10px 0px 10px;">
		<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/contract/client/save" >
			<!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
			<div class="layui-form-item">
				<label class="layui-form-label">客户姓名</label>
				<div class="layui-input-block">
					<input type="text" name="clientName" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">证件号码</label>
				<div class="layui-input-block">
					<input type="text" name="cardNum" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">客户类型</label>
				<div class="layui-input-block">
					<select name="clientType" lay-filter="aihao">
						<option value="">请选择</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-block">
					<input type="text" name="site" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" style="text-align: center;">
				<div class="layui-btn-container">
					<button class="layui-btn" lay-submit="" lay-filter="save" id="save">保存</button>
					<div class="layui-btn layui-btn-primary" lay-filter="close" id="close">取消</div>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js?v=20190305"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js?v=20190305"></script>
<script>
layui.use([ 'form', 'layedit', 'laydate' ], function() {
	var form = layui.form  
	  ,layer = layui.layer
	  ,laydate = layui.laydate;
	var clientId = '${clientId }'
	debugger;
	//parent 是 JS 自带的全局对象，可用于操作父页面
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	 //保存
	 $('#save').on('click', function(){
		  //监听提交
		  form.on('submit(save)', function(data){
		  	  //parent.$('#ticketNum').text('我被改变了');
			  window.parent.location.reload();
			  parent.layer.close(index);
		  });
	 })
			  
	  $('#close').on('click', function(){
		  parent.layer.close(index);
	  });
});
</script>
</html>