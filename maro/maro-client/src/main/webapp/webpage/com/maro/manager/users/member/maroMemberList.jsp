<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroMemberList" checkbox="true" pagination="true" fitColumns="true" title="会员表" actionUrl="maroMemberController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  dictionary="t_s_depart,id,departname"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属门店"  field="shopId" query="true"  queryMode="single"  dictionary="maro_shop,id,name"  width="120"></t:dgCol>
   <t:dgCol title="会员姓名"  field="name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="会员性别"  field="sex"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="会员电话"  field="phone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入会日期"  field="createTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="余额"  field="balance"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="删除标志"  field="deleteFlag"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="state"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="卡号"  field="card"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="maroMemberController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="maroMemberController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="maroMemberController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="maroMemberController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroMemberController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/users/member/maroMemberList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroMemberController.do?upload', "maroMemberList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroMemberController.do?exportXls","maroMemberList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroMemberController.do?exportXlsByT","maroMemberList");
}

 </script>