<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>仓库货物表1对多</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroStoreGoodsController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${maroStoreGoodsPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							所属仓库:
						</label>
					</td>
					<td class="value">
							<t:dictSelect id="storeId" datatype="*" field="storeId" type="list"  dictTable="maro_shop_store" dictField="id" dictText="name" dictCondition="${dictCondition}" hasLabel="false"  title="店铺"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属仓库</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							原料名称:
						</label>
					</td>
					<td class="value">
							<t:dictSelect id="goodsId" datatype="*" field="goodsId" type="list"  dictTable="maro_material_class" dictField="id" dictText="material_name"  hasLabel="false"  title="店铺"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原料名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							原料数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="number" name="number" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原料数量</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/store/storegoods/maroStoreGoods.js"></script>		
