<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroSpecialOfferList" checkbox="false" pagination="true" fitColumns="true" title="店铺优惠活动" actionUrl="maroSpecialOfferController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺"  field="shopId"  dictionary="maro_shop,id,name" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="活动名称"  field="name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="活动备注"  field="remark"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="买的菜品"  field="buyDishesId"  dictionary="maro_dishes,id,dishes_name" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="买的数量"  field="buyNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="送的菜品"  field="freeDishesId"  dictionary="maro_dishes,id,dishes_name" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="送的数量"  field="freeNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否累加"  field="isAdd"  queryMode="single"  dictionary="sf_yn"  width="120"></t:dgCol>
   <t:dgCol title="是否启用"  field="isEnable"  queryMode="single"  dictionary="sf_yn"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="maroSpecialOfferController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="maroSpecialOfferController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="maroSpecialOfferController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="maroSpecialOfferController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroSpecialOfferController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/specialoffer/maroSpecialOfferList.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroSpecialOfferController.do?upload', "maroSpecialOfferList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroSpecialOfferController.do?exportXls","maroSpecialOfferList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroSpecialOfferController.do?exportXlsByT","maroSpecialOfferList");
}

 </script>