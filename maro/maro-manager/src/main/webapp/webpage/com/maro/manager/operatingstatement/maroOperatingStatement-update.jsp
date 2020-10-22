<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>营业报表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroOperatingStatementController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroOperatingStatementPage.id }">
					<input id="createName" name="createName" type="hidden" value="${maroOperatingStatementPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${maroOperatingStatementPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${maroOperatingStatementPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${maroOperatingStatementPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${maroOperatingStatementPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${maroOperatingStatementPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${maroOperatingStatementPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${maroOperatingStatementPage.sysCompanyCode }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${maroOperatingStatementPage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
					</tr>
					<tr>
					<td align="right">
						<label class="Validform_label">
							简称:
						</label>
					</td>
					<td class="value">

					     	 <input id="code" name="code" type="text" class="inputxt" ignore="ignore" value='${maroOperatingStatementPage.code}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">简称</label>
						</td>
				</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								路径:
							</label>
						</td>
						<td class="value">
						     	 <input id="url" name="url" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${maroOperatingStatementPage.url}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">路径</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								方式:
							</label>
						</td>
						<td class="value">
						     	 <input id="run" name="run" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${maroOperatingStatementPage.run}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">方式</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/operatingstatement/maroOperatingStatement.js"></script>		
