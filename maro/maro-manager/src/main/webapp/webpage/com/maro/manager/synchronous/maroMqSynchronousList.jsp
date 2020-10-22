<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroMqSynchronousList" checkbox="true" pagination="true" fitColumns="true" title="统统同步表" actionUrl="maroMqSynchronousController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司ID"  field="departId"  queryMode="single"  dictionary="t_s_depart,id,departname"  width="120"></t:dgCol>
   <t:dgCol title="公司CODE"  field="departCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作类型"  field="operationType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作方法"  field="operationMethod"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数据表"  field="dataTable"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="表ID"  field="dataTableId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用字段"  field="standbyA"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用字段"  field="standbyB"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用字段"  field="standbyC"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="maroMqSynchronousController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="maroMqSynchronousController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="maroMqSynchronousController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="maroMqSynchronousController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroMqSynchronousController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/synchronous/maroMqSynchronousList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroMqSynchronousController.do?upload', "maroMqSynchronousList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroMqSynchronousController.do?exportXls","maroMqSynchronousList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroMqSynchronousController.do?exportXlsByT","maroMqSynchronousList");
}

 </script>