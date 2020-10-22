<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>原料阈值配置</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
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
              return true;
          },
          cancelVal: '关闭',
          cancel: true /*为true等价于function(){}*/
      });
  }
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroMaterialThresholdController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroMaterialThresholdPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								原料:
							</label>
						</td>
						<td class="value">
							<input id="materialClassId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" value="${maroMaterialThresholdPage.materialClassIdString}" onclick="openMaterialselect(this)"/>
							<input type="hidden" name="materialClassId" value="${maroMaterialThresholdPage.materialClassId}" readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">原料id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								阈值大小(%):
							</label>
						</td>
						<td class="value">
						    <input id="value" name="value" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroMaterialThresholdPage.value}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">阈值大小</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/materialthreshold/maroMaterialThreshold.js"></script>
