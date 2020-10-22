<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>原料表</title>
    <style>
  .ui-button {
  	  display: inline-block;
	  padding: 2px 2px;
	  margin-bottom: 0;
	  font-size: 8px;
	  font-weight: normal;
	  line-height: 1.42857143;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
      touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
	  background-image: none;
	  border: 1px solid transparent;
	  border-radius: 4px;
  }
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });

 </script>
 </head>
 <body style="overflow-x: hidden;">
 
    <span style="display: none;">
    <span id="scatteredCode">
 		拆零单位：<t:dictSelect field="scattered" type="list" datatype="*"  extendJson="{style:'display:black'}" typeGroupCode="maro_ordinary_unit"  defaultVal="${maroMaterialClassPage.scattered}" hasLabel="false"  title="拆零单位" ></t:dictSelect>
		拆零数量：<input type="text" name="scatteredNumber" datatype="n"  id="scatteredNumber" value=""/>
	</span>
	</span>
 
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroMaterialClassController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${maroMaterialClassPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" style="width:8%;">
				<label class="Validform_label">原料名称:</label>
			</td>
			<td class="value" style="width:70%;">
		     	 <input id="materialName" name="materialName" datatype="*" type="text" style="width: 150px" class="inputxt"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">原料名称</label>
			</td>
			<td align="right" style="width:8%;">
				<label class="Validform_label">原料编码:</label>
			</td>
			<td class="value" style="width:15%;">
		     	 <input id="coding" name="coding" onblur="checkCoding(this,'add')" type="text" style="width: 150px" class="inputxt" datatype="/^[0-9a-zA-Z]+$/" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">原料编码</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">原料类型:</label>
			</td>
			<td class="value">
			    <t:dictSelect field="type" type="list" datatype="*" id="material_type" onChange="changeType(this)" typeGroupCode="maro_material_type"  defaultVal="1" hasLabel="false"  title="原料类型" ></t:dictSelect>     
				<span id="scatteredSpan"></span>
			</td>
			<td align="right">
				<label class="Validform_label">原料分类:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="classificationId" type="list" datatype="*" dictTable="maro_material_classification" dictField="id" dictText="classification_name"  defaultVal="${maroMaterialClassPage.classificationId}" hasLabel="false"  title="原料分类" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">原料分类</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">原料单位:</label>
			</td>
			<td class="value denominatedUnitClass">
				<t:dictSelect field="denominatedUnit" type="list" datatype="*" typeGroupCode="maro_ordinary_unit"  defaultVal="copyofthe" hasLabel="false"  title="普通单位" ></t:dictSelect>     
			</td>
			<td align="right">
				<label class="Validform_label">采购价:</label>
			</td>
			<td class="value">
		     	 <input id="purchasingPrice" name="purchasingPrice" datatype="d" type="text" style="width: 150px" class="inputxt" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购价</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="maroMaterialClassController.do?maroSpecificationsFoodCostsList&id=${maroMaterialClassPage.id}" icon="icon-search" title="规格成本" id="maroSpecificationsFoodCosts"></t:tab>
				</t:tabs>
			</div>
 </t:formvalid>
 
 <div style="display: none;">
 <span class="maro_ordinary_unit">
 	<t:dictSelect field="denominatedUnit" type="list" datatype="*"  typeGroupCode="maro_ordinary_unit"  defaultVal="" hasLabel="false"  title="普通单位" ></t:dictSelect>
 </span>
 <span class="maro_weighing_unit">
 	<t:dictSelect field="denominatedUnit" type="list" datatype="*"  typeGroupCode="maro_weighing_unit"  defaultVal="" hasLabel="false"  title="称重单位" ></t:dictSelect>
 </span>
 <span class="maro_scattered_unit">
 	<t:dictSelect field="denominatedUnit" type="list" datatype="*"  typeGroupCode="maro_ordinary_unit"  defaultVal="" hasLabel="false"  title="拆零单位" ></t:dictSelect>
 </span>
 </div>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_maroSpecificationsFoodCosts_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
			 <td align="left">
			        <input type="text" class="inputxt"  style="width:120px;"    value="" readonly="readonly" onclick="openDishesSelect(this,#index#)"/>
					<input type="hidden" class="inputxt dishesId"  style="width:120px;"    value="" readonly="readonly"/>
					  <label class="Validform_label" style="display: none;">菜肴id</label>
				  </td>
				  <td align="left">
					   <input type="text" class="inputxt specificationsName#index#" value="" readonly="readonly">
					    <input type="hidden" class="inputxt specificationsId#index#" name="maroSpecificationsFoodCostsList[#index#].specificationsId" value="" readonly="readonly">
					  <label class="Validform_label" style="display: none;">规格属性id</label>
				  </td>
				  <td align="left">
					  	<input name="maroSpecificationsFoodCostsList[#index#].consumptionQuantity" type="text" class="inputxt"  style="width:120px;"  datatype="d"   />
					  <label class="Validform_label" style="display: none;">消耗数量</label>
				  </td>
				 <td align="left">
						<input type="text" class="inputxt unit#index#" value="" readonly="readonly">
					</td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/maro/manager/dishes/materialclass/js/dishesSelect.js"></script>
 <script src = "webpage/com/maro/manager/dishes/materialclass/maroMaterialClass.js"></script>	
	