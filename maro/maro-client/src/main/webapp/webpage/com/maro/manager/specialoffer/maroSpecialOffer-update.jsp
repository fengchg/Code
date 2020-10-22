<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>店铺优惠活动</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  //打开原料查询页面
  function openMaterialselect(th,flag){
      $.dialog({
          content: 'url:maroMaterialClassController.do?dishesSelect',
          lock : true,
          zIndex: getzIndex(),
          width:1100,
          height:550,
          title:'菜品列表',
          opacity : 0.3,
          cache:false,
          okVal: '确认',
          ok: function(){
              iframe = this.iframe.contentWindow;
              var saveState = iframe.saveTask();
              console.info(saveState);
              $(th).val(saveState[1]);
              $(th).next().val(saveState[0]);
              if(flag=='free'){
                  $("#freeSpecificationsName").val(saveState[3]);
                  $("#freeSpecificationsId").val(saveState[2]);
              }
              if(flag=='buy'){
                  $("#buySpecificationsName").val(saveState[3]);
                  $("#buySpecificationsId").val(saveState[2]);
              }
              return true;
          },
          cancelVal: '关闭',
          cancel: true /*为true等价于function(){}*/
      });
  }
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroSpecialOfferController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroSpecialOfferPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								店铺:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="shopId" type="list"  datatype="s" dictTable="maro_shop" dictField="id" dictText="name"  dictCondition="${dictCondition}" defaultVal="${maroSpecialOfferPage.shopId}" hasLabel="false"  title="店铺"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">店铺id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								活动名称:
							</label>
						</td>
						<td class="value">
						    <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="checked"  value='${maroSpecialOfferPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								活动备注:
							</label>
						</td>
						<td class="value">
						    <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroSpecialOfferPage.remark}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动备注</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								买的菜品:
							</label>
						</td>
						<td class="value">
							<input type="text" class="inputxt"  style="width:150px;"    value="${buyDishesName}" readonly="readonly" onclick="openMaterialselect(this,'buy')"/>
							<input type="hidden" class="materialclassId" name="buyDishesId" style="width:120px;" value="${maroSpecialOfferPage.buyDishesId}" readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">买的菜品</label>
						</td>
					</tr>

					<tr>
						<td align="right">
							<label class="Validform_label">
								买的菜品规格:
							</label>
						</td>
						<td class="value">
							<input id="buySpecificationsName" type="text" class="inputxt"  style="width:150px;"    value="${buySpecificationsName}" readonly="readonly"/>
							<input id="buySpecificationsId" type="hidden" name="buySpecificationsId" style="width:120px;" value="${maroSpecialOfferPage.buySpecificationsId}" readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">买的菜品规格</label>
						</td>
					</tr>

					<tr>
						<td align="right">
							<label class="Validform_label">
								买的数量:
							</label>
						</td>
						<td class="value">
						    <input id="buyNumber" name="buyNumber" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${maroSpecialOfferPage.buyNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">买的数量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								送的菜品:
							</label>
						</td>
						<td class="value">
							<input type="text" class="inputxt"  style="width:150px;"    value="${freeDishesName}" readonly="readonly" onclick="openMaterialselect(this,'free')"/>
							<input type="hidden" class="materialclassId" name="freeDishesId" style="width:120px;" value="${maroSpecialOfferPage.freeDishesId}" readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">送的菜品</label>
						</td>
					</tr>

					<tr>
						<td align="right">
							<label class="Validform_label">
								买的菜品规格:
							</label>
						</td>
						<td class="value">
							<input id="freeSpecificationsName" type="text" class="inputxt"  style="width:150px;"    value="${freeSpecificationsName}" readonly="readonly"/>
							<input id="freeSpecificationsId" type="hidden" name="freeSpecificationsId" style="width:120px;" value="${maroSpecialOfferPage.freeSpecificationsId}" readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">买的菜品规格</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								送的数量:
							</label>
						</td>
						<td class="value">
						    <input id="freeNumber" name="freeNumber" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${maroSpecialOfferPage.freeNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">送的数量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否累加:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="isAdd" type="list"  typeGroupCode="sf_yn"   defaultVal="${maroSpecialOfferPage.isAdd}" hasLabel="false"  title="是否累加" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否累加</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否启用:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="isEnable" type="list"  typeGroupCode="sf_yn"   defaultVal="${maroSpecialOfferPage.isEnable}" hasLabel="false"  title="是否启用" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否启用</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/specialoffer/maroSpecialOffer.js"></script>