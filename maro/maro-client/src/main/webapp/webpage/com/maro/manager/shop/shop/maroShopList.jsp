<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroShopList" checkbox="true" fitColumns="true" title="店铺表" actionUrl="maroShopController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="所属机构"  field="departId"  queryMode="single" dictionary="t_s_depart,id,departname" width="120"></t:dgCol>
   <t:dgCol title="设备编号"  field="equipmentNumber"  hidden="true"  queryMode="single" width="120"></t:dgCol>
   <t:dgCol title="店铺编号"  field="number"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺类型"  field="type"  hidden="true" queryMode="single"  dictionary="maro_shop_type"  width="120"></t:dgCol>
   <t:dgCol title="店铺所属地区"  field="area"  queryMode="single" dictionary="maro_area" width="120"></t:dgCol>
   <t:dgCol title="店铺位置"  field="position"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺经度"  field="la"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺维度"  field="lo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺名称"  field="name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺电话"  field="phone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺邮箱"  field="mail"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="开业时间"  field="openTime"  hidden="true"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="营业时间"  field="workTime"  hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺介绍"  field="introduce"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="店铺图片"  field="picture"  queryMode="single"  image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="营业执照等"  field="shopInfo"  queryMode="single"  image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="人均消费"  field="perConsume"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="删除标志" hidden="true"  field="deleteFlag"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
      
   <t:dgFunOpt show="hidden" funname="doDel(id)"  title="删除" urlclass="ace_button" urlfont="fa-trash-o" urlStyle="background-color:#e42d60;"></t:dgFunOpt>
   
   <t:dgToolBar show="hidden" title="录入" icon="icon-add" url="maroShopController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="编辑" icon="icon-edit" url="maroShopController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="批量删除"  icon="icon-remove" url="maroShopController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroShopController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/shop/shop/maroShopList.js"></script>		
 <script type="text/javascript">
 
 function doDel(id){
 
 	layer.open({
			title:"确认删除",
			content:"删除该店铺会把店铺下所属的菜肴也删除，确定删除该记录吗",
			icon:7,
			shade: true?0.3:0,
			yes:function(index){
				$.post("maroShopController.do?doDel",{id:id},function(result){
    				location.reload();
				});
				
			},
			btn:['确定','取消'],
			btn2:function(index){
				layer.close(index);
			}
		});
 
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroShopController.do?upload', "maroShopList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroShopController.do?exportXls","maroShopList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroShopController.do?exportXlsByT","maroShopList");
}
 </script>