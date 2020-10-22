<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroSetmealList" checkbox="true" fitColumns="true" title="套餐" actionUrl="maroSetmealController.do?datagrid2" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="所属门店"  field="sysCompanyCode" query="true" replace="${replace}" queryMode="single"  dictionary="maro_shop,id,name"  width="120"></t:dgCol>
   
   
   <t:dgCol title="套餐名称"  field="dishesName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="快捷码"  field="pinyinCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="套餐类型"  field="setmealType" dictionary="maro_setmeal_form" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="套餐价"  field="packagePrice"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="会员价"  field="memberPrice"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="套餐图片"  field="setmealPicture"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销售状态"  field="marketType"  queryMode="single"  dictionary="maro_setmeal_type"  width="120"></t:dgCol>
   <t:dgCol title="简介"  field="synopsis" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   
   <t:dgDelOpt title="删除" url="maroSetmealController.do?doDel2&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgFunOpt funname="addbytab(dishesName,id)"  title="套餐菜" urlclass="ace_button" urlfont="fa-eur" urlStyle="background-color:#09614f;"></t:dgFunOpt>
   
   
   <t:dgToolBar title="录入" icon="icon-add" url="maroSetmealController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="maroSetmealController.do?goUpdate2" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroSetmealController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/dishes/setmeal/maroSetmealList.js"></script>		
 <script type="text/javascript">
 
  //打开tab窗口
 function addbytab(setmealName,id){
	 
	 //opensearchdwin(tab+"[规格]", "maroDishesController.do?goGetSpecificationsList&maroDishesId="+id, 500, 500);
	 
	 //模态窗口
	 //createwindow('审核入职', 'maroDishesController.do?goGetSpecificationsList&maroDishesId=' + id,420,280);
	 //TAB窗口
	 addOneTab(setmealName+"[规格]", "maroSetmealController.do?setmealDishes&setmealId="+id);
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroSetmealController.do?upload', "maroSetmealList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroSetmealController.do?exportXls","maroSetmealList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroSetmealController.do?exportXlsByT","maroSetmealList");
}
 </script>