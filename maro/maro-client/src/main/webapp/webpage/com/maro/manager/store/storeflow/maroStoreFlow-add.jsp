<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>流水表</title>
	<t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<script type="text/javascript">
        //编写自定义JS代码
        //生成标签码
        function makeLabelCode(){
            $.ajax({
                url:"utilController.do?makeLableCode",
                data:{},
                dataType:"json",
                success:function(result){
                    if(result.success){
                        $("#labelCode").val(result.obj);
                    }else{
                        showMeg(result.msg);
                    }
                }
            });
        }
        //改变价格后出发函数
        function afterChangePrice(obj){
            var price=$(obj).val();
            var num=$("#number").val();
            $("#totalPrice").val(1000000000*Number(num)*Number(price)/1000000000);
        }
        //改变数量后出发函数
        function afterChangeNum(obj){
            var num=$(obj).val();
            var price=$("#price").val();
            $("#totalPrice").val(1000000000*Number(num)*Number(price)/1000000000);
        }
        //通过原料id查询原料的详细信息并赋值给table
        function afterSelectClass(obj){
            var materialClassId=$(obj).val();
            $.ajax({
                url:"maroPurchaseController.do?getMaterialClassInfoById",
                data:{
                    materialClassId:materialClassId
                },
                dataType:"json",
                success:function(result){
                    if(result.success){
                        $("label[flag='numUnit']").html(result.obj.denominatedUnitName);
                        $("#price").val(result.obj.purchasingPrice);
                        $("#labelCode").val(result.obj.coding);
                    }else{
                        showMeg(result.msg);
                    }
                }
            });
        }
        //打开原料查询页面
        function openMaterialselect(th){
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
                    $(th).val(saveState[1]);
                    $(th).next().val(saveState[0]);
                    $(th).next().trigger("onchange");//触发onchange事件
                    return true;
                },
                cancelVal: '关闭',
                cancel: true /*为true等价于function(){}*/
            });

        }
	</script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroStoreFlowController.do?doAdd&comeFrom=add" >
	<input id="id" name="id" type="hidden" value="${maroStoreFlowPage.id }"/>
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">

		<tr>
			<td align="right">
				<label class="Validform_label">
					入库店铺:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="shopId" type="list" datatype="*" dictTable="maro_shop" dictField="id" dictText="name"  dictCondition="${shopIdCondition}" defaultVal="${shopId}" hasLabel="false"  title="入库店铺"></t:dictSelect>
				<!-- <input id="shopId" name="shopId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">店铺id</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					入库原料:
				</label>
			</td>
			<td class="value">
					<%--<t:dictSelect field="goodsId" type="list" datatype="*" dictTable="maro_material_class" dictField="id" dictText="material_name" hasLabel="false"  title="入库原料" onChange="afterSelectClass(this)"></t:dictSelect>--%>
				<!-- <input id="goodsId" name="goodsId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
				<input type="text" class="inputxt"  style="width:150px;"    value="" readonly="readonly" onclick="openMaterialselect(this)"/>
				<input type="hidden" class="materialclassId" name="goodsId" style="width:120px;" value="" readonly="readonly" onChange="afterSelectClass(this)"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入库原料</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					数量:
				</label>
			</td>
			<td class="value">
				<input id="number" name="number" type="text"  onkeyup="afterChangeNum(this)" style="width: 150px" class="inputxt" datatype="/^\d+(\.\d+)?$/" ignore="checked" /><label flag="numUnit"></label>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">数量</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					价格:
				</label>
			</td>
			<td class="value">
				<input id="price" name="price" type="text" onkeyup="afterChangePrice(this)" style="width: 150px" class="inputxt" datatype="/^\d+(\.\d+)?$/" ignore="checked" /><label>元</label>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">价格</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					总价:
				</label>
			</td>
			<td class="value">
				<input id="totalPrice" name="totalPrice" type="text" style="width: 150px" class="inputxt"  datatype="/^\d+(\.\d+)?$/" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">总价</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					仓库:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="storeId" type="list" datatype="*" dictTable="maro_shop_store" dictField="id" dictText="name"  dictCondition="${storeCondition}" hasLabel="false"  title="仓库"></t:dictSelect>
				<!-- <input id="storeId" name="storeId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">仓库</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					标签码:
				</label>
			</td>
			<td class="value">
				<input id="labelCode"  readonly="readonly" name="labelCode" type="text" style="width: 150px" class="inputxt"/>
				<a class="easyui-linkbutton" iconCls="icon-search" onclick="makeLabelCode.bak()">打印标签码</a>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">标签码</label>
			</td>
		</tr>
		<tr style="display: none">
			<td align="right">
				<label class="Validform_label">
					出入库类型:
				</label>
			</td>
			<td class="value">
				<input id="type" name="type" type="text" style="width: 150px" class="inputxt" value="${in_or_out}" datatype="n"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">出入库类型</label>
			</td>
		</tr>


	</table>
</t:formvalid>
</body>
<script src = "webpage/com/maro/manager/store/storeflow/maroStoreFlow.js"></script>
<script src = "webpage/com/maro/manager/common/js/common.js"></script>
