<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroDishesDiscountList" checkbox="true" fitColumns="true" title="菜品打折" actionUrl="maroDishesDiscountController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="打折名称"  field="discountName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="打折详情"  field="discountDetail"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="打折方式"  field="discountWay"  queryMode="single"  dictionary="maro_discountWay" width="120"></t:dgCol>
   <t:dgCol title="打折类型"  field="discountType"  queryMode="single"  dictionary="maro_discountType" width="120"></t:dgCol>
   <t:dgCol title="开始日期"  field="startWeek"  queryMode="single"  dictionary="maro_week" width="120"></t:dgCol>
   <t:dgCol title="结束日期"  field="endWeek"  queryMode="single"  dictionary="maro_week" width="120"></t:dgCol>
   <t:dgCol title="开始日期"  field="startTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结束日期"  field="endTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="打折数"  field="discountNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否启用"  field="isEnable"  queryMode="single"  dictionary="sf_yn"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="maroDishesDiscountController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="maroDishesDiscountController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="maroDishesDiscountController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="maroDishesDiscountController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroDishesDiscountController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/discount/maroDishesDiscountList.js"></script>
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroDishesDiscountController.do?upload', "maroDishesDiscountList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroDishesDiscountController.do?exportXls","maroDishesDiscountList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroDishesDiscountController.do?exportXlsByT","maroDishesDiscountList");
}
 </script>