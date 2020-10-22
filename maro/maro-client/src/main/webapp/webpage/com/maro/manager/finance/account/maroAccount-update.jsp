<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>账户表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroAccountController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroAccountPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								店铺:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="shopId" type="list"  dictTable="maro_shop" dictField="id" dictText="name"   defaultVal="${maroAccountPage.shopId}" hasLabel="false"  title="店铺id" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">店铺</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								账号:
							</label>
						</td>
						<td class="value">
						    <input id="accountNumber" name="accountNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroAccountPage.accountNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">账号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								账户姓名:
							</label>
						</td>
						<td class="value">
						    <input id="accountName" name="accountName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroAccountPage.accountName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">账户姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								身份证号码:
							</label>
						</td>
						<td class="value">
						    <input id="identityCard" name="identityCard" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroAccountPage.identityCard}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								账户性别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="accountSex" type="list"  datatype="n"  typeGroupCode="sex"   defaultVal="${maroAccountPage.accountSex}" hasLabel="false"  title="账户性别" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">账户性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								账户余额:
							</label>
						</td>
						<td class="value">
						    <input id="balance" name="balance" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroAccountPage.balance}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">账户余额</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/finance/account/maroAccount.js"></script>		
