<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>规格价格</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroSpecificationsPriceController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroSpecificationsPricePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								机构id:
							</label>
						</td>
						<td class="value">
						    <input id="dpeartId" name="dpeartId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSpecificationsPricePage.dpeartId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">机构id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								店铺id:
							</label>
						</td>
						<td class="value">
						    <input id="shopId" name="shopId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSpecificationsPricePage.shopId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">店铺id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								规格id:
							</label>
						</td>
						<td class="value">
						    <input id="specificationsId" name="specificationsId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSpecificationsPricePage.specificationsId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">规格id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								价格:
							</label>
						</td>
						<td class="value">
						    <input id="price" name="price" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSpecificationsPricePage.price}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">价格</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/dishes/specificationsprice/maroSpecificationsPrice.js"></script>		
