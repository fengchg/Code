<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroSpecificationsFoodCostsList" checkbox="true" pagination="true" fitColumns="true" title="规格成本" actionUrl="maroSpecificationsFoodCostsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="规格属性id"  field="specificationsId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="原料名称"  field="name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="原料分类"  field="materialClassification"  query="true"  queryMode="single"  dictionary="maro_material_class"  width="120"></t:dgCol>
   <t:dgCol title="创建来源"  field="createSource"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="消耗数量"  field="consumptionQuantity"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="maroSpecificationsFoodCostsController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="maroSpecificationsFoodCostsController.do?goAdd" funname="add" width="620" height="420"></t:dgToolBar>
   <%-- <t:dgToolBar title="编辑" icon="icon-edit" url="maroSpecificationsFoodCostsController.do?goUpdate" funname="update"></t:dgToolBar> --%>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="maroSpecificationsFoodCostsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <%-- <t:dgToolBar title="查看" icon="icon-search" url="maroSpecificationsFoodCostsController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/dishes/specificationsfoodcosts/maroSpecificationsFoodCostsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroSpecificationsFoodCostsController.do?upload', "maroSpecificationsFoodCostsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroSpecificationsFoodCostsController.do?exportXls","maroSpecificationsFoodCostsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroSpecificationsFoodCostsController.do?exportXlsByT","maroSpecificationsFoodCostsList");
}

 </script>