<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addMaroShopSeatBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delMaroShopSeatBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addMaroShopSeatBtn').bind('click', function(){   
 		 var tr =  $("#add_maroShopSeat_table_template tr").clone();
	 	 $("#add_maroShopSeat_table").append(tr);
	 	 resetTrNum('add_maroShopSeat_table');
	 	 return false;
    });  
	$('#delMaroShopSeatBtn').bind('click', function(){   
      	$("#add_maroShopSeat_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_maroShopSeat_table'); 
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
    $('#flowInfo').linkbutton({   
	    iconCls: 'icon-search'  
	});
	$('#flowInfo').bind('click', function(){  
		var length=$("#add_maroShopSeat_table").find("input:checked").length;  
		if(length==0){
			showMeg("请选择一个");
		}else if(length>1){
			showMeg("不能选择多个");
		}else{
			var index=$("#add_maroShopSeat_table").find("input:checked").parent().parent().find("div[name='xh']").html();
			var flowid=$("#add_maroShopSeat_table").find("input:checked").parent().parent().find("input[name='maroShopSeatList["+(Number(index)-1)+"].lateOperatinId']").val();
			if(flowid==""){
				showMeg("无相关流水信息！");
			}else{
				alert("....");
			}
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addMaroShopSeatBtn" href="#">添加</a> <a id="delMaroShopSeatBtn" href="#">删除</a> <a id="flowInfo" href="#">最近流水信息</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="maroShopSeat_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <!-- <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						主键id
				  </td> -->
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						座位名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						座位类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						座位号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						座位标准人数
				  </td>
				  <!-- <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						最近流水id
				  </td> -->
				  <!-- <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						删除标志
				  </td> -->
	</tr>
	<tbody id="add_maroShopSeat_table">
	<c:if test="${fn:length(maroShopSeatList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="maroShopSeatList[0].id" type="hidden"/>
					<input name="maroShopSeatList[0].createName" type="hidden"/>
					<input name="maroShopSeatList[0].createBy" type="hidden"/>
					<input name="maroShopSeatList[0].createDate" type="hidden"/>
					<input name="maroShopSeatList[0].updateName" type="hidden"/>
					<input name="maroShopSeatList[0].updateBy" type="hidden"/>
					<input name="maroShopSeatList[0].updateDate" type="hidden"/>
					<input name="maroShopSeatList[0].sysOrgCode" type="hidden"/>
					<input name="maroShopSeatList[0].sysCompanyCode" type="hidden"/>
					<input name="maroShopSeatList[0].bpmStatus" type="hidden"/>
				  <!-- <td align="left">
					  	<input name="maroShopSeatList[0].shopId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">主键id</label>
					</td> -->
				  <td align="left">
					  	<input name="maroShopSeatList[0].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"   datatype="/^.{1,10}$/" ignore="checked" >
					  <label class="Validform_label" style="display: none;">座位名称</label>
					</td>
				  <td align="left">
							<t:dictSelect field="maroShopSeatList[0].type" type="list"  datatype="n"   typeGroupCode="maro_seat_type"  defaultVal="${maroShopSeatPage.type}" hasLabel="false"  title="座位类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">座位类型</label>
					</td>
				  <td align="left">
					  	<input name="maroShopSeatList[0].flag" flag="flag"  onblur="checkSeatFlagRepeat(this)" maxlength="32" type="text" class="inputxt"  style="width:120px;" datatype="/^[0-9]{1,4}$/" ignore="checked" >
					  <label class="Validform_label" style="display: none;">座位号</label>
					</td>
				  <td align="left">
					  	<input name="maroShopSeatList[0].number" maxlength="2" type="text" class="inputxt"  style="width:120px;"  datatype="/^[0-9]*$/" ignore="checked" >
					  <label class="Validform_label" style="display: none;">座位标准人数</label>
					</td>
				  <td align="left" style="display:none">
					  	<input name="maroShopSeatList[0].lateOperatinId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">最近流水id</label>
					</td>
				  <!-- <td align="left">
					  	<input name="maroShopSeatList[0].deleteFlag" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">删除标志</label>
					</td> -->
   			</tr>
	</c:if>
	<c:if test="${fn:length(maroShopSeatList)  > 0 }">
		<c:forEach items="${maroShopSeatList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="maroShopSeatList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="maroShopSeatList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="maroShopSeatList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="maroShopSeatList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="maroShopSeatList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="maroShopSeatList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="maroShopSeatList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="maroShopSeatList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="maroShopSeatList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="maroShopSeatList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
				   <%-- <td align="left">
					  	<input name="maroShopSeatList[${stuts.index }].shopId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.shopId }"/>
					  <label class="Validform_label" style="display: none;">主键id</label>
				   </td> --%>
				   <td align="left">
					  	<input name="maroShopSeatList[${stuts.index }].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"   datatype="/^.{1,10}$/" ignore="checked"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">座位名称</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="maroShopSeatList[${stuts.index }].type" type="list"  datatype="n"   typeGroupCode="maro_seat_type"  defaultVal="${poVal.type }" hasLabel="false"  title="座位类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">座位类型</label>
				   </td>
				   <td align="left">
					  	<input name="maroShopSeatList[${stuts.index }].flag" flag="flag"  onblur="checkSeatFlagRepeat(this)" maxlength="32" type="text" class="inputxt"  style="width:120px;" datatype="/^[0-9]{1,4}$/" ignore="checked"  value="${poVal.flag }"/>
					  <label class="Validform_label" style="display: none;">座位号</label>
				   </td>
				   <td align="left">
					  	<input name="maroShopSeatList[${stuts.index }].number" maxlength="2" type="text" class="inputxt"  style="width:120px;"  datatype="/^[0-9]*$/" ignore="checked"  value="${poVal.number }"/>
					  <label class="Validform_label" style="display: none;">座位标准人数</label>
				   </td>
				   <td align="left" style="display:none">
					  	<input name="maroShopSeatList[${stuts.index }].lateOperatinId" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.lateOperatinId }"/>
					  <label class="Validform_label" style="display: none;">最近流水id</label>
				   </td>
				  <%--  <td align="left">
					  	<input name="maroShopSeatList[${stuts.index }].deleteFlag" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore"  value="${poVal.deleteFlag }"/>
					  <label class="Validform_label" style="display: none;">删除标志</label>
				   </td> --%>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
