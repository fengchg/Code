<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>点机号</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroMachineNumberController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroMachineNumberPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户:
							</label>
						</td>
						<td class="value">
						    <input id="userid" name="userid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMachineNumberPage.userid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">机号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								设备号:
							</label>
						</td>
						<td class="value">
						    <input id="deviceNumber" name="deviceNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMachineNumberPage.deviceNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">设备号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								工号:
							</label>
						</td>
						<td class="value">
						    <input id="jobNumber" name="jobNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMachineNumberPage.jobNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								密码:
							</label>
						</td>
						<td class="value">
						    <input id="pwd" name="pwd" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMachineNumberPage.pwd}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">密码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							机号:
						</label>
					</td>
					<td class="value">
					     	 <input id="deviceCode" name="deviceCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value='${maroMachineNumberPage.deviceCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">密码</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/machinenumber/maroMachineNumber.js"></script>		
