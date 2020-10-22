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
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="marpPrintTemplateController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${marpPrintTemplatePage.id }">
					
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								名称:
							</label>
						</td>
						<td class="value">
						    <input id="name"  disabled="disabled" name="name" type="text" style="width: 150px" class="inputxt" value='${marpPrintTemplatePage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
					</tr>
					<!-- <tr>
						<td align="right">
							<label class="Validform_label">
								code:
							</label>
						</td>
						<td class="value">
						     <input id="code" name="code" type="text" style="width: 150px" class="inputxt" value='${marpPrintTemplatePage.code}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">code</label>
						</td>
					</tr> -->
					<tr>
					<td align="right">
						<label class="Validform_label">
							打印机:
						</label>
					</td>
					<td class="value">
					     	<t:dictSelect field="url" type="list" dictTable="maro_printer" dictField="ID" dictText="PRINTER_NAME" hasLabel="false" dictCondition="where SYS_COMPANY_CODE='${shopId}'" defaultVal="${marpPrintTemplatePage.url}"  title="打印机"></t:dictSelect>
							<input id="code" name="code" type="hidden" style="width: 150px" class="inputxt" value='${marpPrintTemplatePage.code}'>
							<span class="classificationCode_show Validform_checktip">选择一个打印机</span>
							<label class="Validform_label" style="display: none;">打印机</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/maroprint/printtemplate/marpPrintTemplate.js"></script>		
