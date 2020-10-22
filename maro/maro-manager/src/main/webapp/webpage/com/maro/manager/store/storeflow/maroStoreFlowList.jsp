<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroStoreFlowList" checkbox="false" pagination="true" fitColumns="true" title="流水表" actionUrl="maroStoreFlowController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="店铺"  field="shopId"  dictionary="maro_shop,id,name" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原料"  field="goodsId"  dictionary="maro_material_class,id,material_name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际数量"  field="number"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际价格"  field="price"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际总价"  field="totalPrice"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓库"  field="storeId"  dictionary="maro_shop_store,id,name" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="标签码"  field="labelCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="出入库类型"  field="type" query="true"  dictionary="maro_out_in_store" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="删除标志"  field="deleteFlag"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar show="hidden" title="入库" icon="icon-put" url="maroStoreFlowController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="出库" icon="icon-putout" url="maroStoreFlowController.do?goOut" funname="add"></t:dgToolBar>
   <t:dgCol title="操作" field="opt" width="100" roleCanSee="cgspy"></t:dgCol>
   <t:dgDelOpt show="hidden" title="删除" url="maroStoreFlowController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o" roleCanSee="cgspy"/>
   <%--  <t:dgToolBar show="hidden" title="录入" icon="icon-add" url="maroStoreFlowController.do?goAdd" funname="add"></t:dgToolBar>
    <t:dgToolBar show="hidden" title="编辑" icon="icon-edit" url="maroStoreFlowController.do?goUpdate" funname="update"></t:dgToolBar>
    <t:dgToolBar show="hidden" title="批量删除"  icon="icon-remove" url="maroStoreFlowController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
    <t:dgToolBar title="查看" icon="icon-search" url="maroStoreFlowController.do?goUpdate" funname="detail"></t:dgToolBar>
    <t:dgToolBar show="hidden" title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar show="hidden" title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
    <t:dgToolBar show="hidden" title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/store/storeflow/maroStoreFlowList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroStoreFlowController.do?upload', "maroStoreFlowList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroStoreFlowController.do?exportXls","maroStoreFlowList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroStoreFlowController.do?exportXlsByT","maroStoreFlowList");
}

 </script>