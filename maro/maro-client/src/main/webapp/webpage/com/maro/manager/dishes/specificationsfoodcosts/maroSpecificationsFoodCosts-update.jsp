<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>规格成本</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroSpecificationsFoodCostsController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroSpecificationsFoodCostsPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								规格属性id:
							</label>
						</td>
						<td class="value">
						    <input id="specificationsId" name="specificationsId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSpecificationsFoodCostsPage.specificationsId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">规格属性id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								原料名称:
							</label>
						</td>
						<td class="value">
						    <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSpecificationsFoodCostsPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原料名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								原料分类:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="materialClassification" type="list"  typeGroupCode="maro_material_class"   defaultVal="${maroSpecificationsFoodCostsPage.materialClassification}" hasLabel="false"  title="原料分类" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原料分类</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建来源:
							</label>
						</td>
						<td class="value">
						    <input id="createSource" name="createSource" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSpecificationsFoodCostsPage.createSource}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建来源</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								消耗数量:
							</label>
						</td>
						<td class="value">
						    <input id="consumptionQuantity" name="consumptionQuantity" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${maroSpecificationsFoodCostsPage.consumptionQuantity}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">消耗数量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								单位:
							</label>
						</td>
						<td class="value">
						    <input id="unit" name="unit" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSpecificationsFoodCostsPage.unit}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/dishes/specificationsfoodcosts/maroSpecificationsFoodCosts.js"></script>		
