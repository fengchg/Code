<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>流水表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  	//编写自定义JS代码
  	//根据店铺id和标签码获取该标签对应的原料库存信息
  	function getMaterialInfo(){
  		var labelCode=$("#labelCode").val();
  		if(labelCode=="") return;
  		$.ajax({
			url:"maroStoreFlowController.do?getMaterialInfo",
			data:{
				labelCode:labelCode,
				shopId:'${shopId}'
			},
			dataType:"json",
			success:function(result){
				if(result.success){
					$("#shopId").val(result.obj.shopid);
					$("#shopIdString").val(result.obj.shopname);
					$("#goodsId").val(result.obj.goodsid);
					$("#goodsIdString").val(result.obj.materialname);
					$("#storeId").val(result.obj.storeid);
					$("#storeIdString").val(result.obj.storename);
					$("#price").val(result.obj.price);
					$("label[flag='numUnit']").html(result.obj.unitstring);
					$("label[flag='maxNumber']").html("	库存最大数量为："+result.obj.number);
					$("#number").attr("maxNumber",result.obj.number);
				}else{
					showMeg(result.msg);
				}
			}
		});
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
    			}else{
    				showMeg(result.msg);
    			}
    		}
    	});
    }
    function enter(e){
  	    if(e.keyCode==13){
            getMaterialInfo();
		}
	}
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroStoreFlowController.do?doAdd&comeFrom=out" >
					<input id="id" name="id" type="hidden" value="${maroStoreFlowPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							标签码:
						</label>
					</td>
					<td class="value">
					     	 <input id="labelCode" name="labelCode" type="text" style="width: 150px" class="inputxt" onkeyup="enter(event)"/>
					     	 <a class="easyui-linkbutton" iconCls="icon-search" onclick="getMaterialInfo()">查找</a>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">标签码</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出库店铺:
						</label>
					</td>
					<td class="value">
					     	<input id="shopId" name="shopId" type="hidden"/>
					     	<input id="shopIdString" type="text" readonly="readonly" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出库</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出库原料:
						</label>
					</td>
					<td class="value">
					     	<input id="goodsId" name="goodsId"  type="hidden"/>
					     	<input id="goodsIdString" type="text" readonly="readonly" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出库原料</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数量:
						</label>
					</td>
					<td class="value">
					     	<input id="number" name="number" type="text"  onkeyup="afterChangeNum(this)" style="width: 150px" class="inputxt" datatype="/^\d+(\.\d+)?$/" ignore="checked" /><label flag="numUnit"></label><label flag="maxNumber"></label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数量</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							仓库:
						</label>
					</td>
					<td class="value">
					     	<input id="storeId" name="storeId" type="hidden"/>
					     	<input id="storeIdString" type="text" readonly="readonly" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仓库</label>
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
