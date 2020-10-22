<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addMaroPurchaseDetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delMaroPurchaseDetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addMaroPurchaseDetailBtn').bind('click', function(){   
 		 var tr =  $("#add_maroPurchaseDetail_table_template tr").clone();
	 	 $("#add_maroPurchaseDetail_table").append(tr);
	 	 resetTrNum('add_maroPurchaseDetail_table');
	 	 return false;
    });  
	$('#delMaroPurchaseDetailBtn').bind('click', function(){   
      	$("#add_maroPurchaseDetail_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_maroPurchaseDetail_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
  	//mine
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
    				$(obj).parent().parent().find("label[flag='planNumUnit']").html(result.obj.denominatedUnitName);
    				var planPrice=result.obj.purchasingPrice;
    				$(obj).parent().parent().find("input[flag='planPrice']").val(planPrice);
    				var planNum=$(obj).parent().parent().find("input[flag='planNum']").val();
    				$(obj).parent().parent().find("input[flag='planTotalPrice']").val(1000000000*Number(planNum)*Number(planPrice)/1000000000);
    				getPlanTotalPrice(obj);
    			}else{
    				showMeg(result.msg);
    			}
    		}
    	});
    }
    //改变数量后的触发事件
    function afterChangeNum(obj){
    	var planNum=$(obj).val();
    	var planPrice=$(obj).parent().parent().find("input[flag='planPrice']").val();
    	$(obj).parent().parent().find("input[flag='planTotalPrice']").val(1000000000*Number(planNum)*Number(planPrice)/1000000000);
    	getPlanTotalPrice(obj);
    }
    //改变单价后的触发事件
    function afterChangePrice(obj){
    	var planPrice=$(obj).val();
    	var planNum=$(obj).parent().parent().find("input[flag='planNum']").val();
    	$(obj).parent().parent().find("input[flag='planTotalPrice']").val(1000000000*Number(planNum)*Number(planPrice)/1000000000);
    	getPlanTotalPrice(obj);
    }
    //获取预算单价
    function getPlanTotalPrice(obj){
    	var totalPrive=new Number(0);
    	$(obj).parent().parent().parent().find("input[flag='planTotalPrice']").each(
    		function(){
    			totalPrive=totalPrive+Number($(this).val());
    		}
    	);
    	$("#budget").val(totalPrive);
    }
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addMaroPurchaseDetailBtn" href="#">添加</a> <a id="delMaroPurchaseDetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="maroPurchaseDetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 150px;">
						原料
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 150px;">
						计划商品单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 150px;">
						计划商品数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 150px;">
						计划总价
				  </td>
	</tr>
	<tbody id="add_maroPurchaseDetail_table">
	<c:if test="${fn:length(maroPurchaseDetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="maroPurchaseDetailList[0].id" type="hidden"/>
					<input name="maroPurchaseDetailList[0].createName" type="hidden"/>
					<input name="maroPurchaseDetailList[0].createBy" type="hidden"/>
					<input name="maroPurchaseDetailList[0].createDate" type="hidden"/>
					<input name="maroPurchaseDetailList[0].updateName" type="hidden"/>
					<input name="maroPurchaseDetailList[0].updateBy" type="hidden"/>
					<input name="maroPurchaseDetailList[0].updateDate" type="hidden"/>
					<input name="maroPurchaseDetailList[0].sysOrgCode" type="hidden"/>
					<input name="maroPurchaseDetailList[0].sysCompanyCode" type="hidden"/>
					<input name="maroPurchaseDetailList[0].bpmStatus" type="hidden"/>
					<input name="maroPurchaseDetailList[0].purchaseId" type="hidden"/>
				   <td align="left">
							<%--<t:dictSelect field="maroPurchaseDetailList[0].materialClassId" type="list"  datatype="*"   dictTable="maro_material_class" dictField="id" dictText="material_name" hasLabel="false"  title="原料id" onChange="afterSelectClass(this)"></t:dictSelect>--%>
								<input type="text" class="inputxt"  style="width:120px;"    value="" readonly="readonly" onclick="openMaterialselect(this,0)"/>
								<input type="hidden" class="materialclassId" name="maroPurchaseDetailList[0].materialClassId" style="width:120px;" value="" readonly="readonly" onChange="afterSelectClass(this)"/>
								<label class="Validform_label" style="display: none;">原料</label>
					</td>
				  <td align="left">
					  	<input name="maroPurchaseDetailList[0].planPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  onkeyup="afterChangePrice(this)" flag="planPrice"><label>元</label>
					  <label class="Validform_label" style="display: none;">计划商品单价</label>
					</td>
				  <td align="left">
					  	<input name="maroPurchaseDetailList[0].planNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" onkeyup="afterChangeNum(this)" flag="planNum"><label flag="planNumUnit"></label>
					  <label class="Validform_label" style="display: none;">计划商品数量</label>
					</td>
				  <td align="left">
					  	<input name="maroPurchaseDetailList[0].planTotalPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" flag="planTotalPrice">
					  <label class="Validform_label" style="display: none;">计划总价</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(maroPurchaseDetailList)  > 0 }">
		<c:forEach items="${maroPurchaseDetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="maroPurchaseDetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
						<input name="maroPurchaseDetailList[${stuts.index }].purchaseId" type="hidden" value="${poVal.purchaseId }"/>
				   <td align="left">
							<%--<t:dictSelect field="maroPurchaseDetailList[${stuts.index }].materialClassId" type="list"  datatype="*"   dictTable="maro_material_class" dictField="id" dictText="material_name"  defaultVal="${poVal.materialClassId }" hasLabel="false"  title="原料id" onChange="afterSelectClass(this)"></t:dictSelect>--%>
								<input type="text" class="inputxt"  style="width:120px;" value="${poVal.materialName}" readonly="readonly" onclick="openMaterialselect(this,${stuts.index})"/>
								<input type="hidden" class="materialclassId" name="maroPurchaseDetailList[${stuts.index }].materialClassId" style="width:120px;" value="${poVal.materialClassId}" readonly="readonly" onChange="afterSelectClass(this)"/>
					  <label class="Validform_label" style="display: none;">原料</label>
				   </td>
				   <td align="left">
					  	<input name="maroPurchaseDetailList[${stuts.index }].planPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.planPrice }"  onkeyup="afterChangePrice(this)" flag="planPrice"/><label>元</label>
					  <label class="Validform_label" style="display: none;">计划商品单价</label>
				   </td>
				   <td align="left">
					  	<input name="maroPurchaseDetailList[${stuts.index }].planNumber" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.planNumber }" onkeyup="afterChangeNum(this)"  flag="planNum"/><label flag="planNumUnit"></label>
					  <label class="Validform_label" style="display: none;">计划商品数量</label>
				   </td>
				   <td align="left">
					  	<input name="maroPurchaseDetailList[${stuts.index }].planTotalPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.planTotalPrice }" flag="planTotalPrice"/>
					  <label class="Validform_label" style="display: none;">计划总价</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
