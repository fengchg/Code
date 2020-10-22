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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroOperatinController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${maroOperatinPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							店铺:
						</label>
					</td>
					<td class="value">
							<t:dictSelect field="shopId" type="list"  datatype="s" dictTable="maro_shop" dictField="id" dictText="name" hasLabel="false"  title="店铺"></t:dictSelect>
					     	<!-- <input id="shopId" name="shopId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">店铺</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收支:
						</label>
					</td>
					<td class="value">
					     	 <input id="money" name="money" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收支</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							服务订单id:
						</label>
					</td>
					<td class="value">
					     	 <input id="serverOrderId" name="serverOrderId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">服务订单id</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							采购单id:
						</label>
					</td>
					<td class="value">
					     	 <input id="purchaseId" name="purchaseId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">采购单id</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否开具发票:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="isInvoice" type="list"  typeGroupCode="sf_yn"  defaultVal="${maroOperatinPage.isInvoice}" hasLabel="false"  title="是否开具发票" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否开具发票</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否入账:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="isBooked" type="list"   typeGroupCode="sf_yn"  defaultVal="${maroOperatinPage.isBooked}" hasLabel="false"  title="是否入账" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否入账</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="createTime" name="createTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:150px;" class="inputxt" rows="6" id="remark" name="remark"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/finance/operatin/maroOperatin.js"></script>		
