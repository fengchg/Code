<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,ztree"></t:base>

<t:datagrid name="serverOrderList" title="服务订单流水列表" actionUrl="maroClientServerorderController.do?listServerOrderDO" fitColumns="true"  idField="id" sortName="id" sortOrder="desc" queryMode="group" btnCls="bootstrap">
	<t:dgCol title="common.id" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="服务订单号" field="code" width="200"></t:dgCol>
	<t:dgCol title="所属店铺" field="restaurantName" width="200"></t:dgCol>
	<t:dgCol title="座位号" field="srcSeatCode"></t:dgCol>
	<t:dgCol title="订单金额" field="amount" ></t:dgCol>
	<t:dgCol title="订单状态" field="statusString"></t:dgCol>
	<t:dgCol title="订单日期" field="beginTimeString"></t:dgCol>
	<t:dgCol title="用餐人数" field="personNumber"></t:dgCol>
	<t:dgCol title="服务员" field="waiterName" width="200"></t:dgCol>
	<t:dgCol title="common.operation" field="opt" width="300"></t:dgCol>
	<t:dgFunOpt funname="getServerorderPage(id)" title="订单详情" urlclass="ace_button"  urlfont="fa-user"></t:dgFunOpt>
</t:datagrid>

<script type="text/javascript">

    function getServerorderPage(id) {
        openwindow('服务订单流水详情',"maroClientServerorderController.do?getServerOrderPage&serverOrderId=" + id,'',700,800);
    }

</script>