<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>店铺库存表1对多</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroShopStoreController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroShopStorePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								所属店铺:
							</label>
						</td>
						<td class="value">
							<t:dictSelect id="shopId" datatype="*" field="shopId" type="list" defaultVal="${maroShopStorePage.shopId}"  dictTable="maro_shop" dictField="id" dictText="name" dictCondition="${dictCondition}" hasLabel="false"  title="店铺"></t:dictSelect>
						    <%-- <input id="shopId" name="shopId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroShopStorePage.shopId}'/> --%>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属店铺</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								仓库名称:
							</label>
						</td>
						<td class="value">
						    <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroShopStorePage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仓库名称</label>
						</td>
					</tr>
					<%-- <tr>
						<td align="right">
							<label class="Validform_label">
								删除状态:
							</label>
						</td>
						<td class="value">
						    <input id="deleteFlag" name="deleteFlag" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${maroShopStorePage.deleteFlag}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">删除状态</label>
						</td>
					</tr> --%>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/store/shopstore/maroShopStore.js"></script>		
