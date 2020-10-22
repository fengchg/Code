<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroPurchaseDetailList" checkbox="true" pagination="true" fitColumns="true" title="入库管理" actionUrl="maroPurchaseDetailController.do?datagrid&purchaseId=${purchaseId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  hidden="true" formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  hidden="true" formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购id"  field="purchaseId"  hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原料"  field="materialClassId"  dictionary="maro_material_class,id,material_name" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="计划商品单价"  field="planPrice"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="计划商品数量"  field="planNumber"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="计划总价"  field="planTotalPrice"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际单价"  field="price"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际数量"  field="number"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际总价"  field="totalPrice"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否入库"  field="isInStore"  dictionary="maro_is_in" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="仓库"  field="storeId"  dictionary="maro_shop_store,id,name" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="入库时间"  field="inStoreTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="删除标志"  field="deleteFlag"  hidden="true" queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt show="hidden" title="删除" url="maroPurchaseDetailController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <t:dgToolBar show="hidden" title="称重入库" icon="icon-edit" url="maroPurchaseDetailController.do?goUpdate" funname="canPutInStore"></t:dgToolBar>
   <%-- <t:dgToolBar show="hidden" title="录入" icon="icon-add" url="maroPurchaseDetailController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="编辑" icon="icon-edit" url="maroPurchaseDetailController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="批量删除"  icon="icon-remove" url="maroPurchaseDetailController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="maroPurchaseDetailController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/maro/manager/store/purchasedetail/maroPurchaseDetailList.js"></script>		
 <script src = "webpage/com/maro/manager/common/js/common.js"></script>	
 <script type="text/javascript">
 $(document).ready(function(){
 });
 //点击称重入库
 function canPutInStore(a,b,c){
	 var selections=$("#maroPurchaseDetailList").datagrid("getSelections");//选中行
	if(selections.length==0){
		showMeg("未选择行！");
	}else if(selections.length>1){
		showMeg("不能选择多行！");
	}else{
		var id=selections[0].id;
		$.ajax({
	   		url:"maroPurchaseDetailController.do?canPutInStore",
	   		data:{
	   			purchaseDetailId:id
	   		},
	   		dataType:"json",
	   		success:function(result){
	   			if(result.success){
 					update(a,b,c);
	   			}else{
	   				showMeg(result.msg);
	   			}
	   		}
	   	});
	}
	 
	 
 	
 }
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'maroPurchaseDetailController.do?upload', "maroPurchaseDetailList");
}

//导出
function ExportXls() {
	JeecgExcelExport("maroPurchaseDetailController.do?exportXls","maroPurchaseDetailList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("maroPurchaseDetailController.do?exportXlsByT","maroPurchaseDetailList");
}

 </script>