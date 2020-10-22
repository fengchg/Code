<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>maro_purchase_detail</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroPurchaseDetailController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${maroPurchaseDetailPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建人名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建人登录名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人登录名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建日期:
						</label>
					</td>
					<td class="value">
							   <input id="createDate" name="createDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							更新人名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							更新人登录名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="updateBy" name="updateBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人登录名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							更新日期:
						</label>
					</td>
					<td class="value">
							   <input id="updateDate" name="updateDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新日期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							所属部门:
						</label>
					</td>
					<td class="value">
					     	 <input id="sysOrgCode" name="sysOrgCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属部门</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							所属公司:
						</label>
					</td>
					<td class="value">
					     	 <input id="sysCompanyCode" name="sysCompanyCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属公司</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							流程状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="bpmStatus" name="bpmStatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">流程状态</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							采购id:
						</label>
					</td>
					<td class="value">
					     	 <input id="purchaseId" name="purchaseId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">采购id</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							原料id:
						</label>
					</td>
					<td class="value">
					     	 <input id="materialClassId" name="materialClassId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原料id</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							计划商品单价:
						</label>
					</td>
					<td class="value">
					     	 <input id="planPrice" name="planPrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计划商品单价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							计划商品数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="planNumber" name="planNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计划商品数量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							计划总价:
						</label>
					</td>
					<td class="value">
					     	 <input id="planTotalPrice" name="planTotalPrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计划总价</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							实际单价:
						</label>
					</td>
					<td class="value">
					     	 <input id="price" name="price" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际单价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							实际数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="number" name="number" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际数量</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							实际总价:
						</label>
					</td>
					<td class="value">
					     	 <input id="totalPrice" name="totalPrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际总价</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							是否入库:
						</label>
					</td>
					<td class="value">
					     	 <input id="isInStore" name="isInStore" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否入库</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							仓库id:
						</label>
					</td>
					<td class="value">
					     	 <input id="storeId" name="storeId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仓库id</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							入库时间:
						</label>
					</td>
					<td class="value">
							   <input id="inStoreTime" name="inStoreTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入库时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							删除标志:
						</label>
					</td>
					<td class="value">
					     	 <input id="deleteFlag" name="deleteFlag" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">删除标志</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/store/purchasedetail/maroPurchaseDetail.js"></script>		
