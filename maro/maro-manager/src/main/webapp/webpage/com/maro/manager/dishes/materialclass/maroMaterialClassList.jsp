<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroMaterialClassList" checkbox="true" fitColumns="true" title="原料表" actionUrl="maroMaterialClassController.do?datagrid" idField="id" fit="true" queryMode="group" sortName="createDate" sortOrder="desc">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="原料名称"  field="materialName" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="原料编码"  field="coding" query="true" queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="原料类型"  field="type"  query="true"  queryMode="single"  dictionary="maro_material_type"  width="120"></t:dgCol>
   <t:dgCol title="原料单位"  field="denominatedUnitName"  queryMode="single"   width="120"></t:dgCol>
    
   <t:dgCol title="采购价"  field="purchasingPrice"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="原料分类"  field="classificationId"  query="true"  queryMode="single"  dictionary="maro_material_classification,id,classification_name"  width="120"></t:dgCol>
   <t:dgCol title="创建来源"  field="createSource" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="maroMaterialClassController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="maroMaterialClassController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="maroMaterialClassController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="maroMaterialClassController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroMaterialClassController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/dishes/materialclass/maroMaterialClassList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroMaterialClassController.do?upload', "maroMaterialClassList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroMaterialClassController.do?exportXls","maroMaterialClassList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroMaterialClassController.do?exportXlsByT","maroMaterialClassList");
}
 </script>