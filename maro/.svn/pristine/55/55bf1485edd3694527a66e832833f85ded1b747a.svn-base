<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>套餐</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroSetmealController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroSetmealPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">套餐名称:</label>
			</td>
			<td class="value">
		     	 <input id="setmealName" name="setmealName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSetmealPage.setmealName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">套餐名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">快捷码:</label>
			</td>
			<td class="value">
		     	 <input id="swiftCode" name="swiftCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSetmealPage.swiftCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">快捷码</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">套餐类型:</label>
			</td>
			<td class="value">
		     	 <!-- <input id="setmealType" name="setmealType" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSetmealPage.setmealType}'/> -->
				 <t:dictSelect field="setmealType" type="list" typeGroupCode="maro_setmeal_form"  defaultVal="${maroSetmealPage.setmealType}" hasLabel="false"  title="简易套餐" datatype="*"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">套餐类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">套餐价:</label>
			</td>
			<td class="value">
		     	 <input id="packagePrice" name="packagePrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSetmealPage.packagePrice}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">套餐价</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">会员价:</label>
			</td>
			<td class="value">
		     	 <input id="memberPrice" name="memberPrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSetmealPage.memberPrice}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">会员价</label>
			</td>
			<td align="right">
				<label class="Validform_label">套餐图片:</label>
			</td>
			<td class="value">
				<jsp:include page= "/webpage/com/maro/manager/common/jsp/upload.jsp">
					<jsp:param name= "name" value= "picture"/>
					<jsp:param name= "value" value= "${maroSetmealPage.setmealPicture}"/>
					<jsp:param name= "multiple" value= "multiple"/>
				</jsp:include> 
		     	<!-- <input id="setmealPicture" name="setmealPicture" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSetmealPage.setmealPicture}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">套餐图片</label> -->
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">销售状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="marketType" type="radio"  datatype="n"   typeGroupCode="maro_setmeal_type"  defaultVal="${maroSetmealPage.marketType}" hasLabel="false"  title="销售状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">销售状态</label>
			</td>
			<td align="right">
				<label class="Validform_label"></label>
			</td>
			<td class="value">
		     	
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">简介:</label>
			</td>
			<td class="value" colspan="3">
		     	 <!-- <input id="synopsis" name="synopsis" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
		     	 <textarea rows="" cols="" name="synopsis" class="inputxt" id="synopsis" style="height: 91px; width: 1037px;">${maroSetmealPage.synopsis}</textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">简介</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="maroSetmealController.do?maroSetmealDishesList&id=${maroSetmealPage.id}" icon="icon-search" title="套餐名称" id="maroSetmealDishes"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_maroSetmealDishes_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				   <td align="left">
					  <input name="maroSetmealDishesList[#index#].className" type="text" class="inputxt" datatype="*">
					  <label class="Validform_label" style="display: none;">类型名称</label>
					</td>
				  <td align="left">
					   <t:dictSelect field="maroSetmealDishesList[#index#].isRepetition" type="list" typeGroupCode="sf_01"  defaultVal="" hasLabel="false"  title="是否可重复" datatype="*"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">是否可重复</label>
					</td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/maro/manager/dishes/setmeal/maroSetmeal.js"></script>	
