<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
<!-- 	<style media="print">
    @page {
        size: auto;
        margin-top: 10mm;
    }
    </style> -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css?v=20140829">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/detail.css?v=20140829">
	<title>中城物流客户报修单</title>
</head>
<body>
	<div class="layui-btn layui-btn-primary" style="margin-top: 10px;margin-left: 685px;" id="" onclick="doPrint()">打印 </div>
	<!--startprint-->
	<div align="center" id="printPart">
	<div>
		<table class="title">
			<tr>
				<td><div ><img class="logo" src="${pageContext.request.contextPath}/static/img/title.png" /></div></td>
				<td colspan="2"><h2>中城物流客户报修单</h2></td>
			</tr>
			<tr>
				<td></td>
				<td><span class="num" >单证编号：${basic.ticketNum }</span></td>
			</tr>
		</table>
	</div>
	<div>
		<table class="basic" >
			<tr>
				<th>客户名</th>
				<td>${basic.clientName }</td>
				<th>联系电话</th>
				<td>${basic.phone }</td>
				<th>车牌号</th>
				<td class="omit">${basic.carNumber }</td>
			</tr>
			<tr>
				<th>车型</th>
				<td class="omit">${basic.carType }</td>
				<th>行驶里程</th>
				<td>${!empty basic.mileage ? basic.mileage.concat("km") : "" }</td>
				<th>车架号</th>
				<td>${basic.vin }</td>
			</tr>
			<tr>
				<th>报修时间</th>
				<td>${basic.callDate }</td>
				<th>故障类型</th>
				<td>${basic.faultType }</td>
				<th>故障地点</th>
				<td>${basic.faultSite }</td>
			</tr>
			<tr>
				<th>故障描述</th>
				<td colspan="5"><span class="left">${basic.faultDescribe }</span></td>
			</tr>
			<tr>
				<th>客户要求</th>
				<td colspan="5"><span class="left">${basic.clientClaim }</span></td>
			</tr>
			<tr>
				<th>处理结果</th>
				<td colspan="5"><span class="left">${basic.disposeResult }</span></td>
			</tr>
	  </table>
	</div>
	<div>
		<table class="top">
			<tr>
				<th>派单人</th>
				<td>${basic.servicerUserId }</td>
				<th>派修时间</th>
				<td>${basic.beginRepairDate }</td>
				<th>修复时间</th>
				<td>${basic.finishRepairDate }</td>
			</tr>
			<tr>
				<th>维修人员</th>
				<td>${basic.repairUserName }</td>
				<th>维修地点</th>
				<td>${basic.repairSite }</td>
				<th>维修单位</th>
				<td>${basic.repairCompany }</td>
			</tr>
			<tr>
				<th>故障检测</th>
				<td colspan="5"><span class="left">${basic.faultDetection }</span></td>
			</tr>
		</table>		
	</div>
	<div>
		<table class="body">
			<tr>
				<td colspan="9" class="body_title">救援明细</td>
			</tr>
			<tr>
				<th rowspan="4" class="body_th_rs"><p>救援费用</p>
			    <p>详单</p></th>
				<th>类别</th>
				<th>起始点</th>
				<th>终点</th>
				<th>公里数</th>
				<th>单价</th>
				<th>其他费用</th>
				<th>金额</th>
				<th>备注</th>
			</tr>
			<tr>
				<td>${rescues.size()>0 ? rescues.get(0).rescueType : "" }</td>
				<td>${rescues.size()>0 ? rescues.get(0).rescueSite : "" }</td>
				<td>${rescues.size()>0 ? rescues.get(0).rescueEnd : "" }</td>
				<td>${rescues.size()>0 ? rescues.get(0).kilometre : "" }</td>
				<td>${rescues.size()>0 ? rescues.get(0).unitPrice : "" }</td>
				<td>${rescues.size()>0 ? rescues.get(0).otherCost : "" }</td>
				<td>${rescues.size()>0 ? rescues.get(0).amount : "" }</td>
				<td>${rescues.size()>0 ? rescues.get(0).remark : "" }</td>
			</tr>
			<tr>
				<td>${rescues.size()>1 ? rescues.get(1).rescueType : "" }</td>
				<td>${rescues.size()>1 ? rescues.get(1).rescueSite : "" }</td>
				<td>${rescues.size()>1 ? rescues.get(1).rescueEnd : "" }</td>
				<td>${rescues.size()>1 ? rescues.get(1).kilometre : "" }</td>
				<td>${rescues.size()>1 ? rescues.get(1).unitPrice : "" }</td>
				<td>${rescues.size()>1 ? rescues.get(1).otherCost : "" }</td>
				<td>${rescues.size()>1 ? rescues.get(1).amount : "" }</td>
				<td>${rescues.size()>1 ? rescues.get(1).remark : "" }</td>
			</tr>
			<tr>
				<td>${rescues.size()>2 ? rescues.get(2).rescueType : "" }</td>
				<td>${rescues.size()>2 ? rescues.get(2).rescueSite : "" }</td>
				<td>${rescues.size()>2 ? rescues.get(2).rescueEnd : "" }</td>
				<td>${rescues.size()>2 ? rescues.get(2).kilometre : "" }</td>
				<td>${rescues.size()>2 ? rescues.get(2).unitPrice : "" }</td>
				<td>${rescues.size()>2 ? rescues.get(2).otherCost : "" }</td>
				<td>${rescues.size()>2 ? rescues.get(2).amount : "" }</td>
				<td>${rescues.size()>2 ? rescues.get(2).remark : "" }</td>
			</tr>
			<tr>
				<td colspan="7">救援费用合计：</td>
				<td colspan="2">￥${rescueSum }</td>
			</tr>
			<tr>
				<td colspan="9" class="body_title">维修明细</td>
			</tr>
			<tr>
				<th rowspan="${repairCount+1 }" class="body_th_rs">维修详单</th>
				<th>配件名称</th>
				<th>单价</th>
				<th>数量</th>
				<th>金额</th>
				<th>工时费</th>
				<th>合计</th>
				<th>是否三包</th>
				<th>备注</th>

			</tr>
			<tr>
				<td>${repairOne.size()>0 ? repairOne.get(0).partsName 	 : "" }</td>
				<td>${repairOne.size()>0 ? repairOne.get(0).unitPrice 	 : "" }</td>
				<td>${repairOne.size()>0 ? repairOne.get(0).partsNumber  : "" }</td>
				<td>${repairOne.size()>0 ? repairOne.get(0).partsAmount  : "" }</td>
				<td>${repairOne.size()>0 ? repairOne.get(0).manHourPrice : "" }</td>
				<td>${repairOne.size()>0 ? repairOne.get(0).amount 		 : "" }</td>
				<td>${repairOne.size()>0 ? repairOne.get(0).isFreeRepair : "" }</td>
				<td>${repairOne.size()>0 ? repairOne.get(0).remark 		 : "" }</td>
			</tr>
			<tr>
				<td>${repairOne.size()>1 ? repairOne.get(1).partsName 	 : "" }</td>
				<td>${repairOne.size()>1 ? repairOne.get(1).unitPrice 	 : "" }</td>
				<td>${repairOne.size()>1 ? repairOne.get(1).partsNumber  : "" }</td>
				<td>${repairOne.size()>1 ? repairOne.get(1).partsAmount  : "" }</td>
				<td>${repairOne.size()>1 ? repairOne.get(1).manHourPrice : "" }</td>
				<td>${repairOne.size()>1 ? repairOne.get(1).amount 		 : "" }</td>
				<td>${repairOne.size()>1 ? repairOne.get(1).isFreeRepair : "" }</td>
				<td>${repairOne.size()>1 ? repairOne.get(1).remark 		 : "" }</td>
			</tr>
			<tr>
				<td>${repairOne.size()>2 ? repairOne.get(2).partsName 	 : "" }</td>
				<td>${repairOne.size()>2 ? repairOne.get(2).unitPrice 	 : "" }</td>
				<td>${repairOne.size()>2 ? repairOne.get(2).partsNumber  : "" }</td>
				<td>${repairOne.size()>2 ? repairOne.get(2).partsAmount  : "" }</td>
				<td>${repairOne.size()>2 ? repairOne.get(2).manHourPrice : "" }</td>
				<td>${repairOne.size()>2 ? repairOne.get(2).amount 		 : "" }</td>
				<td>${repairOne.size()>2 ? repairOne.get(2).isFreeRepair : "" }</td>
				<td>${repairOne.size()>2 ? repairOne.get(2).remark 		 : "" }</td>
			</tr>
			<tr>
				<td>${repairOne.size()>3 ? repairOne.get(3).partsName 	 : "" }</td>
				<td>${repairOne.size()>3 ? repairOne.get(3).unitPrice 	 : "" }</td>
				<td>${repairOne.size()>3 ? repairOne.get(3).partsNumber  : "" }</td>
				<td>${repairOne.size()>3 ? repairOne.get(3).partsAmount  : "" }</td>
				<td>${repairOne.size()>3 ? repairOne.get(3).manHourPrice : "" }</td>
				<td>${repairOne.size()>3 ? repairOne.get(3).amount 		 : "" }</td>
				<td>${repairOne.size()>3 ? repairOne.get(3).isFreeRepair : "" }</td>
				<td>${repairOne.size()>3 ? repairOne.get(3).remark 		 : "" }</td>
			</tr>
			<tr>
				<td>${repairOne.size()>4 ? repairOne.get(4).partsName 	 : "" }</td>
				<td>${repairOne.size()>4 ? repairOne.get(4).unitPrice 	 : "" }</td>
				<td>${repairOne.size()>4 ? repairOne.get(4).partsNumber  : "" }</td>
				<td>${repairOne.size()>4 ? repairOne.get(4).partsAmount  : "" }</td>
				<td>${repairOne.size()>4 ? repairOne.get(4).manHourPrice : "" }</td>
				<td>${repairOne.size()>4 ? repairOne.get(4).amount 		 : "" }</td>
				<td>${repairOne.size()>4 ? repairOne.get(4).isFreeRepair : "" }</td>
				<td>${repairOne.size()>4 ? repairOne.get(4).remark 		 : "" }</td>
			</tr>
			<tr>
				<td>${repairOne.size()>5 ? repairOne.get(5).partsName 	 : "" }</td>
				<td>${repairOne.size()>5 ? repairOne.get(5).unitPrice 	 : "" }</td>
				<td>${repairOne.size()>5 ? repairOne.get(5).partsNumber  : "" }</td>
				<td>${repairOne.size()>5 ? repairOne.get(5).partsAmount  : "" }</td>
				<td>${repairOne.size()>5 ? repairOne.get(5).manHourPrice : "" }</td>
				<td>${repairOne.size()>5 ? repairOne.get(5).amount 		 : "" }</td>
				<td>${repairOne.size()>5 ? repairOne.get(5).isFreeRepair : "" }</td>
				<td>${repairOne.size()>5 ? repairOne.get(5).remark 		 : "" }</td>
			</tr>
			<tr>
				<td>${repairOne.size()>6 ? repairOne.get(6).partsName 	 : "" }</td>
				<td>${repairOne.size()>6 ? repairOne.get(6).unitPrice 	 : "" }</td>
				<td>${repairOne.size()>6 ? repairOne.get(6).partsNumber  : "" }</td>
				<td>${repairOne.size()>6 ? repairOne.get(6).partsAmount  : "" }</td>
				<td>${repairOne.size()>6 ? repairOne.get(6).manHourPrice : "" }</td>
				<td>${repairOne.size()>6 ? repairOne.get(6).amount 		 : "" }</td>
				<td>${repairOne.size()>6 ? repairOne.get(6).isFreeRepair : "" }</td>
				<td>${repairOne.size()>6 ? repairOne.get(6).remark 		 : "" }</td>
			</tr>
			<tr>
				<td>${repairOne.size()>7? repairOne.get(7).partsName 	: "" }</td>
				<td>${repairOne.size()>7? repairOne.get(7).unitPrice 	: "" }</td>
				<td>${repairOne.size()>7? repairOne.get(7).partsNumber  : "" }</td>
				<td>${repairOne.size()>7? repairOne.get(7).partsAmount  : "" }</td>
				<td>${repairOne.size()>7? repairOne.get(7).manHourPrice : "" }</td>
				<td>${repairOne.size()>7? repairOne.get(7).amount 		: "" }</td>
				<td>${repairOne.size()>7? repairOne.get(7).isFreeRepair : "" }</td>
				<td>${repairOne.size()>7? repairOne.get(7).remark 		: "" }</td>
			</tr>
			<c:forEach var="item" items="${repairTwo }">
				<tr>
					<td class="item">${item.partsName 	}</td>
					<td class="item">${item.unitPrice 	}</td>
					<td class="item">${item.partsNumber  }</td>
					<td class="item">${item.partsAmount  }</td>
					<td class="item">${item.manHourPrice }</td>
					<td class="item">${item.amount 		}</td>
					<td class="item">${item.isFreeRepair }</td>
					<td class="item">${item.remark 		}</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="sum" colspan="6">维修金额合计：</td>
				<td class="sum" colspan="3">￥${repairSum }</td>
			</tr>
			<tr>
				<td class="sum" colspan="6">费用总计：</td>
				<td class="sum" colspan="3">￥${allSum }</td>
			</tr>
		</table>
	</div>
	<div>
		<table class="foot">
			<tr>
				<th>服务评价</th>
				<td>${basic.opinion }</td>
				<th>客户签字</th>
				<td></td>
				<th>维修人签字</th>
				<td></td>
			</tr>
			<tr>
				<th>验收结果</th>
				<td>${basic.checkResult }</td>
				<th>验收人签字</th>
				<td></td>
				<th>厂家签字</th>
				<td></td>
			</tr>
		</table>
	</div>
	</div>
	<!--endprint-->
	<div style="height:10px;"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js?v=20140829"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js?v=20140829"></script>
<script>
$(function(){
	$('#printBtn123').on('click', function(){
		//$("#printBtn").css("display","none");
		//alert();
		window.document.body.innerHTML=window.document.getElementById("").innerHTML;
		window.print();
		//$("#printBtn").css("display","");
	});
	
})
function doPrint(){
	if (!!window.ActiveXObject || "ActiveXObject" in window) {
	    remove_ie_header_and_footer();
	}
	bdhtml=window.document.body.innerHTML;
	sprnstr="<!--startprint-->"; //开始打印标识字符串有17个字符
	eprnstr="<!--endprint-->"; //结束打印标识字符串
	prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); //从开始打印标识之后的内容
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
	window.document.body.innerHTML=prnhtml; //把需要打印的指定内容赋给body.innerHTML
	window.print(); //调用浏览器的打印功能打印指定区域
	window.document.body.innerHTML=bdhtml; // 最后还原页面
}

function remove_ie_header_and_footer() {
    var hkey_root, hkey_path, hkey_key;
    hkey_path = "HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
    try {
        var RegWsh = new ActiveXObject("WScript.Shell");
        RegWsh.RegWrite(hkey_path + "header", "");
        RegWsh.RegWrite(hkey_path + "footer", "");
    } catch (e) {}
}
</script>
</html>