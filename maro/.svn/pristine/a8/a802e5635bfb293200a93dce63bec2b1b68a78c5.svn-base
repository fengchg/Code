<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>菜品打折</title>
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
  function discountWayChange(obj) {
      var val=$(obj).val();
      if(val==1){//全单打折
          $("#discountDetail").hide();
      }
      if(val==2){//自定义
          $("#discountDetail").show();
      }
  }
  function discountTypeChange(obj) {
      //清空数据
      $.each($("#Week").find("select"), function(i,val){
			$(this).val("");
      });
      $.each($("#Time").find("input"), function(i,val){
          $(this).val("");
      });
	  var val=$(obj).val();
	  if(val==1){//重复
		  $("#Time").hide();
          $("#Week").show();
	  }
	  if(val==2){//不重复
          $("#Week").hide();
          $("#Time").show();
	  }
  }
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroDishesDiscountController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${maroDishesDiscountPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">
					店铺:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="shopId" type="list"  datatype="s" dictTable="maro_shop" dictField="id" dictText="name"  dictCondition="${dictCondition}" defaultVal="" hasLabel="false"  title="店铺"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺id</label>
			</td>
			<td align="right">
				<label class="Validform_label">打折名称:</label>
			</td>
			<td class="value">
		     	 <input id="discountName" name="discountName" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">打折名称</label>
			</td>
		</tr>
		<tr>
			<%--<td align="right">
				<label class="Validform_label">打折详情:</label>
			</td>
			<td class="value">
				<textarea id="discountDetail" style="width:150px;" class="inputxt" rows="6" name="discountDetail"  ignore="ignore" ></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">打折详情</label>
			</td>--%>

			<td align="right">
				<label class="Validform_label">打折方式:</label>
			</td>
			<td class="value">
				<t:dictSelect field="discountWay" type="list"  typeGroupCode="maro_discountWay"  hasLabel="false"  title="打折方式" onChange="discountWayChange(this)"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">打折方式</label>
			</td>
			<td align="right">
				<label class="Validform_label">打折类型:</label>
			</td>
			<td class="value">
				<t:dictSelect field="discountType" type="list"  typeGroupCode="maro_discountType"  hasLabel="false"  title="打折类型" onChange="discountTypeChange(this)"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">打折类型</label>
			</td>
		</tr>
		<tr id="Week" style="display: none">
			<td align="right">
				<label class="Validform_label">开始日期:</label>
			</td>
			<td class="value">
				<t:dictSelect field="startWeek" type="list"  typeGroupCode="maro_week"  hasLabel="false"  title="开始日期"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">开始日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">结束日期:</label>
			</td>
			<td class="value">
				<t:dictSelect field="endWeek" type="list"  typeGroupCode="maro_week"  hasLabel="false"  title="结束日期"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">结束日期</label>
			</td>
		</tr>
		<tr id="Time" style="display: none">
			<td align="right">
				<label class="Validform_label">开始日期:</label>
			</td>
			<td class="value">
				<input id="startTime" name="startTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">开始日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">结束日期:</label>
			</td>
			<td class="value">
				<input id="endTime" name="endTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">结束日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">打折数:</label>
			</td>
			<td class="value">
		     	 <input id="discountNumber" name="discountNumber" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">打折数</label>
			</td>
			<td align="right">
				<label class="Validform_label">是否启用:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="isEnable" type="list"   typeGroupCode="sf_yn"  defaultVal="${maroDishesDiscountPage.isEnable}" hasLabel="false"  title="是否启用" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否启用</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;display: none" id="discountDetail">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="maroDishesDiscountController.do?maroDishesDiscountDetailList&id=${maroDishesDiscountPage.id}" icon="icon-search" title="详细" id="maroDishesDiscountDetail"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_maroDishesDiscountDetail_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  <input type="text" style="width: 120px" class="inputxt"  ignore="ignore" readonly="readonly" onclick="openMaterialselect(this)"/>
					  <input type="hidden" name="maroDishesDiscountDetailList[#index#].dishesId" value="" readonly="readonly"/>
					  <label class="Validform_label" style="display: none;">菜品</label>
				  </td>
					<td align="left">
						<input type="text" style="width: 120px" class="inputxt"  ignore="ignore" readonly="readonly"/>
						<input type="hidden" name="maroDishesDiscountDetailList[#index#].specificationsId" value="" readonly="readonly"/>
						<label class="Validform_label" style="display: none;">菜品规格</label>
					</td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/maro/manager/discount/maroDishesDiscount.js"></script>
	