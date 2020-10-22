<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>统统同步表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroMqSynchronousController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${maroMqSynchronousPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司ID:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="departId" type="list"  dictTable="t_s_depart" dictField="id" dictText="departname"  defaultVal="${maroMqSynchronousPage.departId}" hasLabel="false"  title="公司ID" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司ID</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司CODE:
						</label>
					</td>
					<td class="value">
					     	 <input id="departCode" name="departCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司CODE</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							操作类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="operationType" name="operationType" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">操作类型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							操作方法:
						</label>
					</td>
					<td class="value">
					     	 <input id="operationMethod" name="operationMethod" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">操作方法</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数据表:
						</label>
					</td>
					<td class="value">
					     	 <input id="dataTable" name="dataTable" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数据表</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/synchronous/maroMqSynchronous.js"></script>		
