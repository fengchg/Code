<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addMaroDishesSpecificationsBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delMaroDishesSpecificationsBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addMaroDishesSpecificationsBtn').bind('click', function(){
	
		 var t01 = $("#maroDishesSpecifications_table tr").length;
		 
		 if(t01 <= 10){
		 	
		 	$(".ordershow").val(t01);
		 
 		 	var tr =  $("#add_maroDishesSpecifications_table_template tr").clone();
	 	 	$("#add_maroDishesSpecifications_table").append(tr);
	 	 	resetTrNum('add_maroDishesSpecifications_table');
	 	 	
	 	 	var addTr = $("#add_maroDishesSpecifications_table_template tr");
	 	 	var ddd = $(addTr).find(".ordershow").removeClass("ordershow");
	 	 	
	 	 	return false;
	 	 }else{
	 	 	tip_old("规格最大只能添加 10 条");
	 	 }
    });  
	$('#delMaroDishesSpecificationsBtn').bind('click', function(){   
      	$("#add_maroDishesSpecifications_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_maroDishesSpecifications_table'); 
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
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addMaroDishesSpecificationsBtn" href="#">添加</a> <a id="delMaroDishesSpecificationsBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="maroDishesSpecifications_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				<!--   <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						菜品id
				  </td> -->
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						规格码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						规格名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						排序
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						会员折扣方式
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						另设会员价时用
				  </td>
	</tr>
	<tbody id="add_maroDishesSpecifications_table">
	<c:if test="${fn:length(maroDishesSpecificationsList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="maroDishesSpecificationsList[0].id" type="hidden"/>
					<input name="maroDishesSpecificationsList[0].createName" type="hidden"/>
					<input name="maroDishesSpecificationsList[0].createBy" type="hidden"/>
					<input name="maroDishesSpecificationsList[0].createDate" type="hidden"/>
					<input name="maroDishesSpecificationsList[0].updateName" type="hidden"/>
					<input name="maroDishesSpecificationsList[0].updateBy" type="hidden"/>
					<input name="maroDishesSpecificationsList[0].updateDate" type="hidden"/>
					<input name="maroDishesSpecificationsList[0].sysOrgCode" type="hidden"/>
					<input name="maroDishesSpecificationsList[0].sysCompanyCode" type="hidden"/>
				 <!--  <td align="left">
					  	<input name="maroDishesSpecificationsList[0].maroDishesId" maxlength="32" type="text" class="inputxt"  style="width:120px;"   >
					  <label class="Validform_label" style="display: none;">菜品id</label>
					</td> -->
				  <td align="left">
					  	<input name="maroDishesSpecificationsList[0].specificationsCode" maxlength="32" type="text" class="inputxt"  style="width:120px;" value="0"  datatype="n1-1" title="规格码">
					  <label class="Validform_label" style="display: none;">规格码</label>
					</td>
				  <td align="left" class="specificationsName">
							<t:dictSelect id="specificationsName" field="maroDishesSpecificationsList[0].name"  onChange="onClicksCode(this)" type="list" datatype="*"  typeGroupCode="maro_specifications"  defaultVal="0" hasLabel="false"  title="规格名称"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">规格名称</label>
					</td>
				  <td align="left">
					  	<input name="maroDishesSpecificationsList[0].unitPrice" maxlength="32" onkeyup="upperCase(this)" type="text" class="inputxt unitPrice"  style="width:120px;" datatype="/^(-?\d+)(\.\d+)?$/"  >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="maroDishesSpecificationsList[0].ordershow" maxlength="32" type="text" class="inputxt"  style="width:120px;" datatype="n"  value="0">
					  <label class="Validform_label" style="display: none;">排序</label>
					</td>
				  <td align="left">
							<t:dictSelect id="memberDiscount0" onChange="memberDiscountWay(0)" field="maroDishesSpecificationsList[0].memberDiscount" type="list" datatype="*"  typeGroupCode="maro_member_discoun"  defaultVal="0" hasLabel="false"  title="会员折扣方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">会员折扣方式</label>
					</td>
				  <td align="left">
					  	<input id="discountWay0" name="maroDishesSpecificationsList[0].discountWay" maxlength="32" type="text" class="inputxt"  style="width:120px;" readonly="readonly" >
					  <label class="Validform_label" style="display: none;">另设会员价时用</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(maroDishesSpecificationsList)  > 0 }">
		<c:forEach items="${maroDishesSpecificationsList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="maroDishesSpecificationsList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="maroDishesSpecificationsList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="maroDishesSpecificationsList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="maroDishesSpecificationsList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="maroDishesSpecificationsList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="maroDishesSpecificationsList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="maroDishesSpecificationsList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="maroDishesSpecificationsList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="maroDishesSpecificationsList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
				  <%--  <td align="left">
					  	<input name="maroDishesSpecificationsList[${stuts.index }].maroDishesId" maxlength="32" type="text" class="inputxt"  style="width:120px;"    value="${poVal.maroDishesId }"/>
					  <label class="Validform_label" style="display: none;">菜品id</label>
				   </td> --%>
				   <td align="left">
					  	<input name="maroDishesSpecificationsList[${stuts.index }].specificationsCode" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n1-1"  value="${poVal.specificationsCode }"/>
					  <label class="Validform_label" style="display: none;">规格码</label>
				   </td>
				   <td align="left" class="specificationsName">
							<t:dictSelect id="specificationsName" field="maroDishesSpecificationsList[${stuts.index }].name" onChange="onClicksCode(this)" type="list"   typeGroupCode="maro_specifications"  defaultVal="${poVal.name }" datatype="*" hasLabel="false"  title="规格名称"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">规格名称</label>
				   </td>
				   <td align="left">
					  	<input name="maroDishesSpecificationsList[${stuts.index }].unitPrice" onkeyup="upperCase(this)" maxlength="32" type="text" class="inputxt unitPrice"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/" value="${poVal.unitPrice }"/>
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="maroDishesSpecificationsList[${stuts.index }].ordershow" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  value="${poVal.ordershow }"/>
					  <label class="Validform_label" style="display: none;">排序</label>
				   </td>
				   <td align="left">
							<t:dictSelect id="memberDiscount${stuts.index}" onChange="memberDiscountWay(${stuts.index})" datatype="*" field="maroDishesSpecificationsList[${stuts.index }].memberDiscount" type="list"   typeGroupCode="maro_member_discoun"  defaultVal="${poVal.memberDiscount }" hasLabel="false"  title="会员折扣方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">会员折扣方式</label>
				   </td>
				   <td align="left">
					  	<input id="discountWay${stuts.index}" name="maroDishesSpecificationsList[${stuts.index }].discountWay" maxlength="32" type="text" class="inputxt"  style="width:120px;" ${poVal.memberDiscount!=2?'readonly':''}   value="${poVal.discountWay }"/>
					  <label class="Validform_label" style="display: none;">另设会员价时用</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
