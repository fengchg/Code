<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addMaroSetmealDishesBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delMaroSetmealDishesBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addMaroSetmealDishesBtn').bind('click', function(){   
 		 var tr =  $("#add_maroSetmealDishes_table_template tr").clone();
	 	 $("#add_maroSetmealDishes_table").append(tr);
	 	 resetTrNum('add_maroSetmealDishes_table');
	 	 return false;
    });  
	$('#delMaroSetmealDishesBtn').bind('click', function(){   
      	$("#add_maroSetmealDishes_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_maroSetmealDishes_table'); 
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
	<a id="addMaroSetmealDishesBtn" href="#">添加</a> <a id="delMaroSetmealDishesBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="maroSetmealDishes_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						类型名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						是否可重复
				  </td>
	</tr>
	<tbody id="add_maroSetmealDishes_table">
	<c:if test="${fn:length(maroSetmealDishesList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="maroSetmealDishesList[0].id" type="hidden"/>
					<input name="maroSetmealDishesList[0].createName" type="hidden"/>
					<input name="maroSetmealDishesList[0].createBy" type="hidden"/>
					<input name="maroSetmealDishesList[0].createDate" type="hidden"/>
					<input name="maroSetmealDishesList[0].updateName" type="hidden"/>
					<input name="maroSetmealDishesList[0].updateBy" type="hidden"/>
					<input name="maroSetmealDishesList[0].updateDate" type="hidden"/>
					<input name="maroSetmealDishesList[0].sysOrgCode" type="hidden"/>
					<input name="maroSetmealDishesList[0].sysCompanyCode" type="hidden"/>
					<input name="maroSetmealDishesList[0].setmealId" type="hidden">
					
				  <td align="left">
					  <input name="maroSetmealDishesList[0].className" type="text" class="inputxt" datatype="*">
					  <label class="Validform_label" style="display: none;">类型名称</label>
					</td>
				  <td align="left">
				  	  <t:dictSelect field="maroSetmealDishesList[0].isRepetition" type="list" typeGroupCode="sf_01"  defaultVal="" hasLabel="false"  title="是否可重复" datatype="*"></t:dictSelect>
					  <!-- <input name="maroSetmealDishesList[0].isRepetition" type="text" class="inputxt" >-->
					  <label class="Validform_label" style="display: none;">是否可重复</label>
					</td>

   			</tr>
	</c:if>
	<c:if test="${fn:length(maroSetmealDishesList)  > 0 }">
		<c:forEach items="${maroSetmealDishesList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="maroSetmealDishesList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="maroSetmealDishesList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="maroSetmealDishesList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="maroSetmealDishesList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="maroSetmealDishesList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="maroSetmealDishesList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="maroSetmealDishesList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="maroSetmealDishesList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="maroSetmealDishesList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
					  	<input name="maroSetmealDishesList[${stuts.index }].setmealId" maxlength="32" type="hidden" value="${poVal.setmealId }"/>
				   <td align="left">
					  	<input name="maroSetmealDishesList[${stuts.index }].className" type="text" class="inputxt"  value="${poVal.className }"/>
					  <label class="Validform_label" style="display: none;">类型名称</label>
				   </td>
				   <td align="left">
				   <t:dictSelect field="maroSetmealDishesList[${stuts.index }].isRepetition" type="list" typeGroupCode="sf_01"  defaultVal="${poVal.isRepetition}" hasLabel="false"  title="是否可重复" datatype="*"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">是否可重复</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
