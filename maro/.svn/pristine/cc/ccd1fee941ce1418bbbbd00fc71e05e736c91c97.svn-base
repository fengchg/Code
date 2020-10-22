<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>打印机</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroPrinterController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroPrinterPage.id }">
					<input id="createName" name="createName" type="hidden" value="${maroPrinterPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${maroPrinterPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${maroPrinterPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${maroPrinterPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${maroPrinterPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${maroPrinterPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${maroPrinterPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${maroPrinterPage.sysCompanyCode }">
					<input id="printerStandby1" name="printerStandby1" type="hidden" value="${maroPrinterPage.printerStandby1 }">
					<input id="printerStandby2" name="printerStandby2" type="hidden" value="${maroPrinterPage.printerStandby2 }">
					<input id="printerStandby3" name="printerStandby3" type="hidden" value="${maroPrinterPage.printerStandby3 }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">IP地址:</label>
			</td>
			<td class="value">
		     	<input id="printerIp" name="printerIp" type="text" style="width: 150px" class="inputxt"  datatype="*" onblur="examinePrinterIp(this,'update')" value='${maroPrinterPage.printerIp}'>
		     	<input id="printerIp2" type="hidden" value='${maroPrinterPage.printerIp}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">IP地址</label>
			</td>
			<td align="right">
				<label class="Validform_label">端口:</label>
			</td>
			<td class="value">
		     	 <input id="printerPort" name="printerPort" type="text" style="width: 150px" class="inputxt" datatype="*" value='${maroPrinterPage.printerPort}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">端口</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">名称:</label>
			</td>
			<td class="value">
		     	 <input id="printerName" name="printerName" type="text" style="width: 150px" class="inputxt"  datatype="*" value='${maroPrinterPage.printerName}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">位置:</label>
			</td>
			<td class="value">
		     	 <input id="printerLocation" name="printerLocation" type="text" style="width: 150px" class="inputxt" 
				ignore="ignore"
		     	 value='${maroPrinterPage.printerLocation}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">位置</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="maroPrinterController.do?maroPrinterClassificationList&id=${maroPrinterPage.id}" icon="icon-search" title="菜肴分类打印IP" id="maroPrinterClassification"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_maroPrinterClassification_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
			 <td align="left" class="specificationsName">
			 	<t:dictSelect id="specificationsName" field="maroPrinterClassificationList[#index#].classificationId" datatype="*" type="list" dictTable="maro_dishes_classification" dictField="id" dictText="classification_name" defaultVal="" onChange="onClicksCode(this)" hasLabel="false"  title="菜品分类" ></t:dictSelect>
				<label class="Validform_label" style="display: none;">菜肴分类</label>
			 </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/maro/manager/maroprint/maroprinter/maroPrinter.js"></script>	
