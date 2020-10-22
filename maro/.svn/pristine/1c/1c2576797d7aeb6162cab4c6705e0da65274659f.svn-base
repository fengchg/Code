<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>菜肴表</title>
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
		<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
		<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
		<script src = "webpage/com/maro/manager/common/js/common.js"></script>	
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
 <div id="test">
  <span style="display: none;">
    	<span id="sysCompanyCodeHtml">
      		<t:dictSelect field="sysCompanyCode" type="list" datatype="*" dictTable="maro_shop" dictField="id" dictText="name" defaultVal="${maroDishesPage.sysCompanyCode}" hasLabel="false"  title="所属门店"></t:dictSelect>
   	  		<span class="Validform_checktip"></span>
	  		<label class="Validform_label" style="display: none;">所属门店</label>
	 	</span>
   </span>
 
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroDishesController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${maroDishesPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" style="width: 8%;">
				<label class="Validform_label">所属门店:</label>
			</td>
			<td class="value" style="width: 25%;">
			  <c:if test="${userName == 'true'}">
				<input type="radio" name="r" id="" value="0" checked="checked" onclick="onRadio(0,1)">全部 &nbsp;&nbsp;&nbsp;
			    <input type="radio" name="r" id="" value="1" onclick="onRadio(1,1)">门店&nbsp;&nbsp;&nbsp;
				<span id="sysCompanyCode_copy"></span>
			  </c:if>
			  <c:if test="${userName == 'false'}">
			    <input type="text" id="" class="inputxt" readonly="readonly" value="${maroShop.name}">
			    <input type="hidden" class="inputxt" name="sysCompanyCode" id="sysCompanyCode" value="${maroShop.id}">
        		<%-- <t:dictSelect readonly="readonly" field="sysCompanyCode" type="list" datatype="*" dictTable="maro_shop" dictField="id" dictText="name" defaultVal="${departId}" hasLabel="false"  title="所属门店"></t:dictSelect> --%>
    		  </c:if>
			</td>
			<td align="right" style="width: 8%;">
				<label class="Validform_label">编码:</label>
			</td>
			<td class="value" style="width: 20%;">
				<input id="coding" name="coding" onblur="checkCoding(this,'add','${userName}')" maxlength="4" datatype="/^[0-9]{4,4}$/" type="text" style="width: 150px" class="inputxt"/>
				<span class="Validform_checktip"> 
                    	编码范围在4位/数字
                </span>
				<label class="Validform_label" style="display: none;">编码</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">菜品名称:</label>
			</td>
			<td class="value">
		     	 <input id="dishesName" name="dishesName" datatype="*" type="text" style="width: 150px" class="inputxt" onKeyUp="query(0,'')"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">菜品名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">拼音码:</label>
			</td>
			<td class="value">
			   <!--
		     	 <input id="pinyinCode" name="pinyinCode" datatype="/^[a-zA-Z]+$/" type="text" style="width: 150px" class="inputxt"   />
		       -->
		     	 <select name="pinyinCode" id="pinyinCode"></select>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">拼音码</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">制作方式:</label>
			</td>
			<td class="value">
		     	<t:dictSelect field="makeWay" type="checkbox"  typeGroupCode="maro_make_way"  defaultVal="001" hasLabel="false"  title="制作方式" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">制作方式</label>
			</td>
			<td align="right">
				<label class="Validform_label">类型:</label>
			</td>
			<td class="value">
				<!-- <t:dictSelect field="type" type="list" datatype="*" readonly="readonly" typeGroupCode="maro_dis_type"  defaultVal="ordinary" hasLabel="false"  title="类型" ></t:dictSelect> --> 
				<input id="type2" name="type2" datatype="*" readonly="true" type="text" style="width: 150px" class="inputxt" value="普通" />
				<input id="type" name="type" datatype="*" readonly="true" type="hidden" style="width: 150px" class="inputxt" value="ordinary" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">类型</label>
			</td>
		</tr>
		<tr>
			 <td align="right">
				<label class="Validform_label">菜品分类:</label>
			</td>
			<td class="value">
		     	 <t:dictSelect field="dishesClassification" datatype="*" type="list" dictTable="maro_dishes_classification" dictField="id" dictText="classification_name" defaultVal="${maroDishesPage.dishesClassification}" hasLabel="false"  title="菜品分类" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">菜品分类</label>
			</td>
			<td align="right">
				<label class="Validform_label">单位:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="unit" type="list" datatype="*"  typeGroupCode="maro_unit_name"  defaultVal="jin" hasLabel="false"  title="单位" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">单位</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">口味分类:</label>
			</td>
			<td class="value">
		     	<t:dictSelect field="tasteCassification" type="list"  datatype="*" typeGroupCode="maro_taste_cassification"  defaultVal="not_spicy" hasLabel="false"  title="口味分类" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">口味分类</label>
			</td>
			<td align="right">
				<label class="Validform_label">销售价格:</label>
			</td>
			<td class="value">
				<input id="salesPrice" name="salesPrice" class="keyup" datatype="d" type="text" style="width: 150px" class="inputxt" keydown="keyupSalesPrice()"  />
				<label class="Validform_label" style="display: none;">销售价格</label>
			</td>
			
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">标签:</label>
			</td>
			<td class="value" colspan="3" height="30">
		     	<t:dictSelect field="theLabel" type="checkbox"   typeGroupCode="maro_the_Label"  defaultVal="" hasLabel="false"  title="标签" ></t:dictSelect>    
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">是否要打荷:</label>
			</td>
			<td class="value" colspan="3" height="30">
		     	<t:dictSelect field="accomplish" type="radio"   typeGroupCode="sf_01"  defaultVal="0" hasLabel="false"   title="打荷" datatype="*" ></t:dictSelect>    
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">图片:</label>
			</td>
			<td class="value" colspan="3">
				<jsp:include page= "/webpage/com/maro/manager/common/jsp/upload.jsp">
					<jsp:param name= "name" value= "picture"/>
					<jsp:param name= "value" value= ""/>
					<jsp:param name= "multiple" value= "multiple"/>
				</jsp:include> 
			</td>
		</tr>
	
		<tr>
			<td align="right">
				<label class="Validform_label">描述:</label>
			</td>
			<td class="value" colspan="3">
				  <textarea id="describes" style="width:80%; height: 50px;" class="inputxt" rows="6" name="describes"   ></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">描述</label>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value" colspan="3">
				  <textarea id="noteId" style="width:80%; height: 50px;" class="inputxt" rows="6" name="noteId"   ></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">描述</label>
			</td>
		</tr>
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="maroDishesController.do?maroDishesSpecificationsList&id=${maroDishesPage.id}" icon="icon-search" title="规格" id="maroDishesSpecifications"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_maroDishesSpecifications_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				 <!--  <td align="left">
					  	<input name="maroDishesSpecificationsList[#index#].maroDishesId" maxlength="32" datatype="* type="text" class="inputxt"  style="width:120px;"   />
					  <label class="Validform_label" style="display: none;">菜品id</label>
				  </td> -->
				  <td align="left">
					  	<input name="maroDishesSpecificationsList[#index#].specificationsCode" datatype="n1-1" maxlength="32" type="text" class="inputxt" value="#index#" style="width:120px;" />
					  <label class="Validform_label" style="display: none;">规格码</label>
				  </td>
				  <td align="left" class="specificationsName">
							<t:dictSelect id="specificationsName" field="maroDishesSpecificationsList[#index#].name" datatype="*" type="list"  onChange="onClicksCode(this)"  typeGroupCode="maro_specifications"  defaultVal="" hasLabel="false"  title="规格名称"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">规格名称</label>
				  </td>
				  <td align="left">
					  	<input name="maroDishesSpecificationsList[#index#].unitPrice" maxlength="32" onkeyup="upperCase(this)" type="text" class="inputxt unitPrice"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"   />
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="maroDishesSpecificationsList[#index#].ordershow" maxlength="32" type="text" class="inputxt" value="#index#"  style="width:120px;"  datatype="n"   />
					  <label class="Validform_label" style="display: none;">排序</label>
				  </td>
				  <td align="left">
							<t:dictSelect id="memberDiscount#index#" onChange="memberDiscountWay(#index#)" datatype="*" field="maroDishesSpecificationsList[#index#].memberDiscount" type="list"    typeGroupCode="maro_member_discoun"  defaultVal="" hasLabel="false"  title="会员折扣方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">会员折扣方式</label>
				  </td>
				  <td align="left">
					  	<input id="discountWay#index#" name="maroDishesSpecificationsList[#index#].discountWay" maxlength="32" type="text" class="inputxt"  style="width:120px;"  readonly="readonly" />
					  <label class="Validform_label" style="display: none;">另设会员价时用</label>
				  </td>
			</tr>
		 </tbody>
		</table>
	</div>
 </body>
 <script src = "webpage/com/maro/manager/dishes/dishes/maroDishes.js"></script>
  <script src = "webpage/com/maro/manager/dishes/dishes/js/pinying.js"></script>
  	<script type="text/javascript">
  		function jeecgFormFileCallBack(data){
  			if (data.success == true) {
				uploadFile(data);
			} else {
				if (data.responseText == '' || data.responseText == undefined) {
					$.messager.alert('错误', data.msg);
					$.Hidemsg();
				} else {
					try {
						var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
						$.messager.alert('错误', emsg);
						$.Hidemsg();
					} catch(ex) {
						$.messager.alert('错误', data.responseText + '');
					}
				}
				return false;
			}
			if (!neibuClickFlag) {
				var win = frameElement.api.opener;
				win.reloadTable();
			}
  		}
  		function upload() {
				$('#picture').uploadify('upload', '*');
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
				$('#picture').uploadify('cancel', '*');
		}
		function uploadFile(data){
			if(!$("input[name='id']").val()){
				if(data.obj!=null && data.obj!='undefined'){
					$("input[name='id']").val(data.obj.id);
				}
			}
			if($(".uploadify-queue-item").length>0){
				upload();
			}else{
				if (neibuClickFlag){
					alert(data.msg);
					neibuClickFlag = false;
				}else {
					var win = frameElement.api.opener;
					win.reloadTable();
					win.tip(data.msg);
					frameElement.api.close();
				}
			}
		}
  	</script>
	