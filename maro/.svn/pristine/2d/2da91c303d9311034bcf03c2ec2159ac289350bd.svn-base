<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid singleSelect="true" name="maroDishesList" checkbox="true" fitColumns="true" title="菜肴表" sortName="createDate" sortOrder="desc" actionUrl="maroDishesController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  hidden="true" formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>

   <t:dgCol title="所属门店"  field="sysCompanyCode" query="true" replace="${replace}" queryMode="single"  dictionary="maro_shop,id,name"  width="120"></t:dgCol>
   
   <t:dgCol title="编码"  field="coding" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="菜品名称"  field="dishesName"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="拼音码"  field="pinyinCode"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  query="false"  queryMode="single"  dictionary="maro_dis_type"  width="120"></t:dgCol>
   <t:dgCol title="成本价格"  field="costPrice" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="网售"  field="netSales"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="外卖"  field="takeOut"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预订"  field="booking"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建来源"  field="createSource" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="describes" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="图片"  field="picture" hidden="true"  queryMode="group"  image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="库存"  field="inventory" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit"  query="false"  queryMode="single"  dictionary="maro_unit_name"  width="120"></t:dgCol>
   <t:dgCol title="规格属性"  field="specificationsId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="noteId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原料分类"  field="classificationId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="菜品分类"  field="dishesClassification"  query="true"  queryMode="single"  dictionary="maro_dishes_classification,id,classification_name"  width="120"></t:dgCol>
   <t:dgCol title="口味分类"  field="tasteCassification" queryMode="group" dictionary="maro_taste_cassification" width="120"></t:dgCol>
   <t:dgCol title="制作方式"  field="makeWay" queryMode="group" dictionary="maro_make_way" width="120"></t:dgCol>
   
    <t:dgCol title="tf" hidden="true" field="tf" width="120"></t:dgCol>
   
   <t:dgCol title="操作" field="opt" width="300"></t:dgCol>
   
   <t:dgDelOpt title="删除" url="maroDishesController.do?doDel&id={id}" exp="tf#eq#t" urlclass="ace_button" urlfont="fa-trash-o" urlStyle="background-color:#c11d1d;"/>
   <t:dgFunOpt funname="addbytab(dishesName,id)" exp="tf#eq#t"  title="成本卡" urlclass="ace_button" urlfont="fa-eur" urlStyle="background-color:#09614f;"></t:dgFunOpt>
   <t:dgFunOpt funname="addPrice(dishesName,id,sysCompanyCode)"  title="价格" urlclass="ace_button" urlfont="fa-yen" urlStyle="background-color:#337ab7;"></t:dgFunOpt>
   <t:dgFunOpt funname="openUpdate(id)" title="编辑" exp="tf#eq#t" urlclass="ace_button" urlfont="fa-edit" urlStyle="background-color:#21b9bb;"></t:dgFunOpt>
   
   <t:dgToolBar title="录入" icon="icon-add" url="maroDishesController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="删除" icon="icon-remove" url="maroDishesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroDishesController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/dishes/dishes/maroDishesList.js"></script>		
 <script type="text/javascript">
 
 
 //打开tab窗口
 function addbytab(tab,id){
	 
	 //opensearchdwin(tab+"[规格]", "maroDishesController.do?goGetSpecificationsList&maroDishesId="+id, 500, 500);
	 
	 //模态窗口
	 //createwindow('审核入职', 'maroDishesController.do?goGetSpecificationsList&maroDishesId=' + id,420,280);
	 //TAB窗口
	 addOneTab(tab+"[规格]", "maroDishesController.do?goGetSpecificationsList&maroDishesId="+id);
 }
 
 function addPrice(tab,id,sysCompanyCode){
	 addOneTab(tab+"[价格]", "maroDishesController.do?goGetSpecificationsPirceList&maroDishesId="+id+"&sysCompanyCode="+sysCompanyCode);
 }
 
 function openUpdate(id){
 	createwindow('编辑', "maroDishesController.do?goUpdate&id=" + id,$(window).width(),$(window).height());
 }
 

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroDishesController.do?upload', "maroDishesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroDishesController.do?exportXls","maroDishesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroDishesController.do?exportXlsByT","maroDishesList");
}
 </script>