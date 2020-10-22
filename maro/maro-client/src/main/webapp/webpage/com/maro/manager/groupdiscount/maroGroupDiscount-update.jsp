<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>团购优惠券</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroGroupDiscountController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroGroupDiscountPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								店铺:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="shopId" type="list"  dictTable="maro_shop" dictField="id" dictText="name"   defaultVal="${maroGroupDiscountPage.shopId}" hasLabel="false"  title="店铺id" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">店铺</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								优惠券名称:
							</label>
						</td>
						<td class="value">
						    <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="checked"  value='${maroGroupDiscountPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">优惠券名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								折扣金额:
							</label>
						</td>
						<td class="value">
						    <input id="discountMoney" name="discountMoney" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${maroGroupDiscountPage.discountMoney}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">折扣金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否启用:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="isEnable" type="list"  typeGroupCode="sf_yn"   defaultVal="${maroGroupDiscountPage.isEnable}" hasLabel="false"  title="是否启用" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否启用</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="remark" style="width:150px;" class="inputxt" rows="6" name="remark"  ignore="ignore" >${maroGroupDiscountPage.remark}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/groupdiscount/maroGroupDiscount.js"></script>
