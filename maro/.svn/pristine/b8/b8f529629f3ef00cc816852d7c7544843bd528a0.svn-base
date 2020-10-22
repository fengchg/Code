<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>菜肴分类</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroDishesClassificationController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${maroDishesClassificationPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								分类名称:
							</label>
						</td>
						<td class="value">
						    <input id="classificationName" datatype="*" name="classificationName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroDishesClassificationPage.classificationName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分类名称</label>
						</td>
					</tr>
					 <tr>
						<td align="right">
							<label class="Validform_label">
								类别号:
							</label>
						</td>
						<td class="value">
						    <input id="classificationCode" maxlength="2" datatype="/^[0-9]{2,2}$/" name="classificationCode" type="text" style="width: 150px" class="inputxt" value='${maroDishesClassificationPage.classificationCode}'/>
							<span class="Validform_checktip">输入两个数字</span>
							<label class="Validform_label" style="display: none;">code</label>
						</td>
					</tr>
					<%-- <tr>
						<td align="right">
							<label class="Validform_label">
								排序:
							</label>
						</td>
						<td class="value">
						    <input id="showOrder" name="showOrder" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${maroDishesClassificationPage.showOrder}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">排序</label>
						</td>
					</tr> --%>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/dishes/dishesclassification/maroDishesClassification.js"></script>		
