<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroShopStoreList" checkbox="false" pagination="true" fitColumns="true" title="店铺库存表1对多" actionUrl="maroShopStoreController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属店铺"  field="shopId"  dictionary="maro_shop,id,name,${dictCondition}"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓库名称"  field="name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="删除状态"  field="deleteFlag"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt show="hidden" title="删除" url="maroShopStoreController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgFunOpt funname="showStoreGoodsInfo(id)"  title="库存信息" urlclass="ace_button" urlfont="fa-user" urlStyle="background-color:#337ab7;"></t:dgFunOpt>
   <t:dgToolBar show="hidden" title="录入" icon="icon-add" url="maroShopStoreController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="编辑" icon="icon-edit" url="maroShopStoreController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="批量删除"  icon="icon-remove" url="maroShopStoreController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroShopStoreController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/store/shopstore/maroShopStoreList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
function showStoreGoodsInfo(id){
	addOneTab("库存信息", "maroStoreGoodsController.do?list&storeId="+id);
}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroShopStoreController.do?upload', "maroShopStoreList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroShopStoreController.do?exportXls","maroShopStoreList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroShopStoreController.do?exportXlsByT","maroShopStoreList");
}

 </script>