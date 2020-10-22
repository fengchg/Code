<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addMaroPrinterClassificationBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delMaroPrinterClassificationBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addMaroPrinterClassificationBtn').bind('click', function(){   
 		 var tr =  $("#add_maroPrinterClassification_table_template tr").clone();
	 	 $("#add_maroPrinterClassification_table").append(tr);
	 	 resetTrNum('add_maroPrinterClassification_table');
	 	 return false;
    });  
	$('#delMaroPrinterClassificationBtn').bind('click', function(){   
      	$("#add_maroPrinterClassification_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_maroPrinterClassification_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#maroPrinterClassification_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addMaroPrinterClassificationBtn" href="#">添加</a> <a id="delMaroPrinterClassificationBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="maroPrinterClassification_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
		<td align="left" bgcolor="#EEEEEE" style="width: 126px;">菜肴分类</td>
	</tr>
	<tbody id="add_maroPrinterClassification_table">
	<c:if test="${fn:length(maroPrinterClassificationList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
				<td align="left" class="specificationsName">
					<t:dictSelect id="specificationsName" field="maroPrinterClassificationList[0].classificationId" datatype="*" type="list" dictTable="maro_dishes_classification" dictField="id" dictText="classification_name" defaultVal="" onChange="onClicksCode(this)" hasLabel="false"  title="菜品分类" ></t:dictSelect>     
					<label class="Validform_label" style="display: none;">菜肴分类</label>
				</td>
   			</tr>
	</c:if>	
	<c:if test="${fn:length(maroPrinterClassificationList)  > 0 }">
		<c:forEach items="${maroPrinterClassificationList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
				<input name="maroPrinterClassificationList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				<td align="left" class="specificationsName">
					<t:dictSelect id="specificationsName" field="maroPrinterClassificationList[${stuts.index }].classificationId" datatype="*" type="list" dictTable="maro_dishes_classification" dictField="id" dictText="classification_name" defaultVal="${poVal.classificationId }" onChange="onClicksCode(this)" hasLabel="false"  title="菜品分类" ></t:dictSelect>
					<label class="Validform_label" style="display: none;">菜肴分类</label>
				</td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
