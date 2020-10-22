<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>采购主表</title>
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
        function checkTime(obj){
            var planStartTime=$("#planStartTime").val();
            var planEndTime=$("#planEndTime").val();
            if(planStartTime!=""&&planEndTime!=""){
                if(planEndTime<=planStartTime){
                    $(obj).val("");
                    alertTip("结束时间不能小于开始时间","提示");
                }
            }
        }
        $(document).ready(function(){
            $('#tt').tabs({
                onSelect:function(title){
                    $('#tt .panel-body').css('width','auto');
                }
            });
            $(".tabs-wrap").css('width','100%');
        });
        //打开原料查询页面
        function openMaterialselect(th,subscript){
            //createwindow('原料列表', 'maroDishesController.do?materialSelect',$(document).width()-100,$(document).height());

            $.dialog({
                content: 'url:maroDishesController.do?materialSelect',
                lock : true,
                zIndex: getzIndex(),
                width:1100,
                height:550,
                title:'原料列表',
                opacity : 0.3,
                cache:false,
                okVal: '确认',
                ok: function(){
                    iframe = this.iframe.contentWindow;
                    var saveState = iframe.saveTask();

                    var isTF = false;
                    $(th).parents("table").find('.materialclassId').each(function(i,n){
                        if($(n).val() == saveState[0]){
                            isTF = true;
                            return false;
                        }
                    });
                    if(isTF){
                        alertTip("列表中已存在 "+saveState[1]+ "原料信息","提示");
                        return false;
                    }

                    $(th).val(saveState[1]);
                    $(th).next().val(saveState[0]);
                    $(th).next().trigger("onchange");//触发onchange事件
                    //$(".specificationsId"+index).val(saveState[2]);
                    //$(".specificationsName"+index).val(saveState[3]);
                    //$(".unit"+index).val(saveState[4]);
                    return true;
                },
                cancelVal: '关闭',
                cancel: true /*为true等价于function(){}*/
            });

        }
	</script>
</head>
<body style="overflow-x: hidden;">
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroPurchaseController.do?doAdd" >
	<input id="id" name="id" type="hidden" value="${maroPurchasePage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">店铺:</label>
			</td>
			<td class="value">
				<t:dictSelect field="shopId" type="list"  datatype="s" dictTable="maro_shop" dictField="id" dictText="name"  dictCondition="${dictCondition}" defaultVal="" hasLabel="false"  title="店铺"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺</label>
			</td>
			<td align="right">
				<label class="Validform_label">采购编号:</label>
			</td>
			<td class="value">
				<input id="code" name="code" type="text" style="width: 150px" class="inputxt"  datatype="*" ignore="checked"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">采购编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">计划采购开始时间:</label>
			</td>
			<td class="value">
				<input id="planStartTime" onchange="checkTime(this)" name="planStartTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计划采购开始时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">计划采购结束时间:</label>
			</td>
			<td class="value">
				<input id="planEndTime" onchange="checkTime(this)" name="planEndTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计划采购结束时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">支付方式:</label>
			</td>
			<td class="value">
				<t:dictSelect field="payType" type="list"  datatype="n"   typeGroupCode="maro_pay_type" hasLabel="false"  title="支付方式" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">支付方式</label>
			</td>
			<td align="right">
				<label class="Validform_label">预算:</label>
			</td>
			<td class="value">
				<input id="budget" name="budget" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /><label>元</label>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">预算</label>
			</td>
		</tr>

	</table>
	<div style="width: auto;height: 200px;">
			<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
		<div style="width:800px;height:1px;"></div>
		<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
			<t:tab href="maroPurchaseController.do?maroPurchaseDetailList&id=${maroPurchasePage.id}" icon="icon-search" title="采购详情表" id="maroPurchaseDetail"></t:tab>
		</t:tabs>
	</div>
</t:formvalid>
<!-- 添加 附表明细 模版 -->
<table style="display:none">
	<tbody id="add_maroPurchaseDetail_table_template">
	<tr>
		<td align="center"><div style="width: 25px;" name="xh"></div></td>
		<td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
		<td align="left">
			<%--<t:dictSelect field="maroPurchaseDetailList[#index#].materialClassId" type="list"  datatype="*"  dictTable="maro_material_class" dictField="id" dictText="material_name"  defaultVal="" hasLabel="false"  title="原料id" onChange="afterSelectClass(this)"></t:dictSelect>--%>
			<input type="text" class="inputxt"  style="width:120px;"    value="" readonly="readonly" onclick="openMaterialselect(this,#index#)"/>
			<input type="hidden" class="materialclassId" name="maroPurchaseDetailList[#index#].materialClassId" style="width:120px;" value="" readonly="readonly" onChange="afterSelectClass(this)"/>
			<label class="Validform_label" style="display: none;">原料</label>
		</td>
		<td align="left">
			<input name="maroPurchaseDetailList[#index#].planPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  onkeyup="afterChangePrice(this)" flag="planPrice"/><label>元</label>
			<label class="Validform_label" style="display: none;">计划商品单价</label>
		</td>
		<td align="left">
			<input name="maroPurchaseDetailList[#index#].planNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" onkeyup="afterChangeNum(this)"  flag="planNum"/><label flag="planNumUnit"></label>
			<label class="Validform_label" style="display: none;">计划商品数量</label>
		</td>
		<td align="left">
			<input name="maroPurchaseDetailList[#index#].planTotalPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" flag="planTotalPrice"/>
			<label class="Validform_label" style="display: none;">计划总价</label>
		</td>
	</tr>
	</tbody>
</table>
</body>
<script src = "webpage/com/maro/manager/store/purchase/maroPurchase.js"></script>
