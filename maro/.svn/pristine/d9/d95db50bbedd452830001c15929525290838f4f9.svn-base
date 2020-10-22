<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>打印</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body> 
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="marpPrintTemplateController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${marpPrintTemplatePage.id }"/>
		<input id="createName" name="createName" type="hidden" value="${marpPrintTemplatePage.createName }"/>
		<input id="createBy" name="createBy" type="hidden" value="${marpPrintTemplatePage.createBy }"/>
		<input id="createDate" name="createDate" type="hidden" value="${marpPrintTemplatePage.createDate }"/>
		<input id="updateName" name="updateName" type="hidden" value="${marpPrintTemplatePage.updateName }"/>
		<input id="updateBy" name="updateBy" type="hidden" value="${marpPrintTemplatePage.updateBy }"/>
		<input id="updateDate" name="updateDate" type="hidden" value="${marpPrintTemplatePage.updateDate }"/>
		<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${marpPrintTemplatePage.sysOrgCode }"/>
		<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${marpPrintTemplatePage.sysCompanyCode }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							名称:
						</label>
					</td>
					<td class="value">

					     	 <input id="name" name="name" type="text" class="inputxt" 
								
						
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							code:
						</label>
					</td>
					<td class="value">

					     	 <input id="code" name="code" type="text" class="inputxt" 
								
						
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">code</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							打印机:
						</label>
					</td>
					<td class="value">
					     	<t:dictSelect field="url" type="list" dictTable="maro_printer" dictField="ID" dictText="PRINTER_NAME" hasLabel="false"  title="打印机"></t:dictSelect>
							<span class="classificationCode_show Validform_checktip">选择一个打印机</span>
							<label class="Validform_label" style="display: none;">打印机</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/maroprint/printtemplate/marpPrintTemplate.js"></script>		
