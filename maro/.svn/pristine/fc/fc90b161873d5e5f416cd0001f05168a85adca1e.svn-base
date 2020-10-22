<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addMaroSpecificationsFoodCostsBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delMaroSpecificationsFoodCostsBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addMaroSpecificationsFoodCostsBtn').bind('click', function(){   
 		 var tr =  $("#add_maroSpecificationsFoodCosts_table_template tr").clone();
	 	 $("#add_maroSpecificationsFoodCosts_table").append(tr);
	 	 resetTrNum('add_maroSpecificationsFoodCosts_table');
	 	 return false;
    });  
	$('#delMaroSpecificationsFoodCostsBtn').bind('click', function(){   
      	$("#add_maroSpecificationsFoodCosts_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_maroSpecificationsFoodCosts_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });

</script>
 <script src = "webpage/com/maro/manager/dishes/materialclass/js/dishesSelect.js"></script>	
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addMaroSpecificationsFoodCostsBtn" href="#">添加</a> <a id="delMaroSpecificationsFoodCostsBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="maroSpecificationsFoodCosts_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						菜肴名字
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						规格
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						消耗数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单位
				  </td>
	</tr>
	<tbody id="add_maroSpecificationsFoodCosts_table">
	<c:if test="${fn:length(maroSpecificationsFoodCostsList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="maroSpecificationsFoodCostsList[0].id" type="hidden"/>
					<input name="maroSpecificationsFoodCostsList[0].createName" type="hidden"/>
					<input name="maroSpecificationsFoodCostsList[0].createBy" type="hidden"/>
					<input name="maroSpecificationsFoodCostsList[0].createDate" type="hidden"/>
					<input name="maroSpecificationsFoodCostsList[0].updateName" type="hidden"/>
					<input name="maroSpecificationsFoodCostsList[0].updateBy" type="hidden"/>
					<input name="maroSpecificationsFoodCostsList[0].updateDate" type="hidden"/>
					<input name="maroSpecificationsFoodCostsList[0].sysOrgCode" type="hidden"/>
					<input name="maroSpecificationsFoodCostsList[0].materialclassId" type="hidden"/>
					<input name="maroSpecificationsFoodCostsList[0].sysCompanyCode" type="hidden"/>
					<td align="left"> 
				   	  <input type="text" class="inputxt"  style="width:120px;"  value="" readonly="readonly" onclick="openDishesSelect(this,0)"/>
					  <input type="hidden" class="inputxt dishesId"  style="width:120px;"  value="" readonly="readonly"/>
					  <label class="Validform_label" style="display: none;">菜肴id</label>
				   </td>
				  <td align="left">
					    <input type="text" class="inputxt specificationsName0" value="" readonly="readonly">
					    <input type="hidden" class="inputxt specificationsId0" name="maroSpecificationsFoodCostsList[0].specificationsId" value="" readonly="readonly">
					  <label class="Validform_label" style="display: none;">规格属性id</label>
					</td>
				  <td align="left">
					  	<input name="maroSpecificationsFoodCostsList[0].consumptionQuantity" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">消耗数量</label>
					</td>
					<td align="left">
						<input type="text" class="inputxt unit0" value="" readonly="readonly">
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(maroSpecificationsFoodCostsList)  > 0 }">
		<c:forEach items="${maroSpecificationsFoodCostsList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].materialclassId" type="hidden" value="${poVal.materialclassId }"/>
						<input name="maroSpecificationsFoodCostsList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
				   <td align="left">
				      <input type="text" class="inputxt"  style="width:120px;"  value="${poVal.dishesName }" readonly="readonly" onclick="openDishesSelect(this,${stuts.index})"/>
					  <input type="hidden" class="inputxt dishesId"  style="width:120px;"  value="${poVal.dishesId }" readonly="readonly"/>
				   </td>
				   <td align="left">
					  
					    <input type="text" class="inputxt specificationsName${stuts.index}" value="${poVal.specificationsName}" readonly="readonly">
					    <input type="hidden" class="inputxt specificationsId${stuts.index} guigeId" name="maroSpecificationsFoodCostsList[${stuts.index}].specificationsId" value="${poVal.specificationsId}" readonly="readonly">
					  
					  <label class="Validform_label" style="display: none;">规格属性id</label>
				   </td>
				   <td align="left">
					  	<input name="maroSpecificationsFoodCostsList[${stuts.index }].consumptionQuantity" type="text" class="inputxt"  style="width:120px;"  datatype="n"  value="${poVal.consumptionQuantity }"/>
					  <label class="Validform_label" style="display: none;">消耗数量</label>
				   </td>
				   <td align="left">
						<input type="text" class="inputxt unit${stuts.index}" value="${poVal.dishesUnit}" readonly="readonly">
					</td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
