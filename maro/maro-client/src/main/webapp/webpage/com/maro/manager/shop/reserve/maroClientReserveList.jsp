<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroClientReserveList" checkbox="true" fitColumns="true" title="预定管理" actionUrl="maroClientReserveController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺"  field="restaurantId"  dictionary="maro_shop,id,name,${dictCondition}"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺名称"  field="restaurantName" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="桌位主键"  field="destSeatId"  dictionary="maro_shop_seat,id,name" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="桌位号"  field="destSeatCode" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="桌位名"  field="destSeatName" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="手机号码"  field="phone"  queryMode="single"  query="true" width="120"></t:dgCol>
   <t:dgCol title="就餐人数"  field="personNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预定时间"  field="reserveTime"  query="true" queryMode="group" formatter="yyyy-MM-dd"  width="120"></t:dgCol>
   <t:dgCol title="订单类型"  field="type"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="订金"  field="deposit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="内容"  field="content"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="时段"  field="period"  dictionary="maro_period" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预计到来时间"  field="planComeTime"  formatter="hh:mm:ss" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt show="hidden" title="删除" url="maroClientReserveController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar show="hidden" title="录入" icon="icon-add" url="maroClientReserveController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="编辑" icon="icon-edit" url="maroClientReserveController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="批量删除"  icon="icon-remove" url="maroClientReserveController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroClientReserveController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/shop/reserve/maroClientReserveList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroClientReserveController.do?upload', "maroClientReserveList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroClientReserveController.do?exportXls","maroClientReserveList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroClientReserveController.do?exportXlsByT","maroClientReserveList");
}

 </script>