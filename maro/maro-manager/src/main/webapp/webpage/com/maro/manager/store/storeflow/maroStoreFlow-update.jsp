<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>流水表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroStoreFlowController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroStoreFlowPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								店铺id:
							</label>
						</td>
						<td class="value">
						    <input id="shopId" name="shopId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroStoreFlowPage.shopId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">店铺id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								原料id:
							</label>
						</td>
						<td class="value">
						    <input id="goodsId" name="goodsId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroStoreFlowPage.goodsId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原料id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实际数量:
							</label>
						</td>
						<td class="value">
						    <input id="number" name="number" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroStoreFlowPage.number}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际数量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实际价格:
							</label>
						</td>
						<td class="value">
						    <input id="price" name="price" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroStoreFlowPage.price}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际价格</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实际总价:
							</label>
						</td>
						<td class="value">
						    <input id="totalPrice" name="totalPrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroStoreFlowPage.totalPrice}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际总价</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								仓库id:
							</label>
						</td>
						<td class="value">
						    <input id="storeId" name="storeId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroStoreFlowPage.storeId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仓库id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								标签码:
							</label>
						</td>
						<td class="value">
						    <input id="labelCode" name="labelCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroStoreFlowPage.labelCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">标签码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								出入库类型:
							</label>
						</td>
						<td class="value">
						    <input id="type" name="type" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${maroStoreFlowPage.type}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出入库类型</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/store/storeflow/maroStoreFlow.js"></script>		
