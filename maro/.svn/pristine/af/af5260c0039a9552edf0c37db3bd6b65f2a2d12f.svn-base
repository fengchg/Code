<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>规格列表</title>
  <style>
table tr td{ 
	border-top:1px solid #DBDDD9; 
	
} 
table{ 
	border:1px solid #DBDDD9; 
	border-top-width:0px; 
} 
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
  
  <link rel="stylesheet" href="webpage/com/maro/manager/dishes/dishes/css/base.css" type="text/css" />
  <link rel="stylesheet" href="webpage/com/maro/manager/dishes/dishes/css/demo.css" type="text/css" />
  <link rel="stylesheet" href="webpage/com/maro/manager/dishes/dishes/css/menu.css" type="text/css" />
  <script type="text/javascript">
	
  </script>
 </head>
 <body>
    
<div id="menu" style="mar">
    <!--显示菜单-->
    <div id="open"  style="margin: 0px auto;">
    <c:if test="${!empty dishesSpecificationsList}">
    <c:forEach items="${dishesSpecificationsList}" var="ds" varStatus="index">
    <t:formvalid formid="formobj${ds.id}" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroSpecificationsFoodCostsController.do?doAdd2">
        <div class="navBox">
            <ul>
                <li>
                   <input type="hidden" class="specificationsId" name="specificationsId" value="${ds.id}">
                    <%-- <c:if test="${index.index == 0}">
                    	<h2 class="obFocus obtain" style="height: 32px;  line-height:30px;text-align: left;">${ds.pageName}<i class="arrowRot"></i></h2>
                    	<div class="secondary" style="height: 2.5078rem;">
                    </c:if> --%>
                    	<h2 class="obtain" onclick="obtf('${ds.id}')" style="height: 32px; line-height:30px;text-align: left;color: #000;font-size: 16px;font-weight: bold;text-indent: 25px;">
                    	${ds.pageName}[规格]
                    	<span class="shouqi_zhangkai_${ds.id}" style="float: right;margin-right: 26px;">收起</span>
                    	</h2>
                    	<div class="secondary secondary${ds.id}" style="height: 100%;">
                        <table style="width: 100%;" id="foodCostsTable${ds.id}" class="guigechenfen">
                        	<thead>
                        	  <tr  style="height: 42px;line-height: 42px;">
                        		<!-- <th>原料分类</th> -->
                        		<th>原料名称</th>
                        		<th>消耗数量</th>
                        		<th>单位</th>
                        		<th>
                        		  <a href="javascript:void(0)" class="ace_button" id="addMaroDishesSpecificationsBtn" style="color:#FFF;" onclick="addTr('${ds.id}')">+添加成分</a>
                        		  <a href="javascript:void(0)" class="ace_button" id="" style="color:#FFF;background-color:#1a7bb9;" onclick="submitForm('${ds.id}')">保存</a>
                        		</th>
                        	  </tr>
                        	</thead>
                        	<tbody id="add_maroDishesSpecifications_table${ds.id}">
                            <c:if test="${empty ds.maroSpecificationsFoodCostsList}">
                        	  <tr style="height: 42px;line-height: 42px;">
                        		<%-- <td><t:dictSelect id="materialClassification" datatype="*" field="foodCosts[0].materialClassification" type="list"  dictTable="maro_material_classification" dictField="id" dictText="classification_name"  hasLabel="false"  title="单位" ></t:dictSelect></td> --%>
                        		<%-- <td><t:dictSelect id="name" datatype="*" field="foodCosts[0].materialclassId" type="list" dictTable="maro_material_class" dictField="id" dictText="material_name" hasLabel="false"  title="单位" ></t:dictSelect></td> --%>
                        		<td>
                        		  <input id="materialclassName0" type="text" datatype="*" onclick="openMaterialselect(this,0)" readonly="readonly">
                        		  <input id="materialclassId0" class="materialclassId" type="hidden" datatype="*" name="foodCosts[0].materialclassId" readonly="readonly">
                        		</td>
                        		<td><input id="consumptionQuantity" datatype="/^\d+(\.\d+)?$/" name="foodCosts[0].consumptionQuantity" type="text" style="width: 100px" class="inputxt" value=""/></td>
                        	    <td><input id="unit0" readonly="readonly" type="text" style="width: 100px;" class="inputxt unit" value=""/></td>
                        		<td><a href="javascript:void(0)" class="ace_button" style="background-color:#ec4758;" onclick="delTr(this,'${dsSfc.id}')"><span class="sfc_del">删除(未保存)</span></a></td>
                        	  </tr>
                            </c:if>
                            <c:if test="${!empty ds.maroSpecificationsFoodCostsList}">
                            <c:forEach items="${ds.maroSpecificationsFoodCostsList}" var="dsSfc" varStatus="dsIndex">
                              <tr style="height: 42px;line-height: 42px;">
                        		<%-- <td><t:dictSelect id="materialClassification" datatype="*" field="foodCosts[${dsIndex.index}].materialClassification" type="list"  dictTable="maro_material_classification" dictField="id" dictText="classification_name"  hasLabel="false"  title="单位"  defaultVal="${dsSfc.materialClassification}"></t:dictSelect></td> --%>
                        		<%-- <td><t:dictSelect id="name" datatype="*" field="foodCosts[${dsIndex.index}].materialclassId" type="list" dictTable="maro_material_class" dictField="id" dictText="material_name"hasLabel="false" defaultVal="${dsSfc.materialclassId}"  title="单位" ></t:dictSelect></td> --%>
                        		<td>
                        		  <input id="materialclassName${dsIndex.index}" type="text" datatype="*" onclick="openMaterialselect(this,${dsIndex.index})" readonly="readonly" value="${dsSfc.materialclassName}">
                        		  <input id="materialclassId${dsIndex.index}" class="materialclassId" type="hidden" datatype="*" name="foodCosts[${dsIndex.index}].materialclassId" readonly="readonly" value="${dsSfc.materialclassId}">
                        		</td>
                        		<td><input id="consumptionQuantity" datatype="*" name="foodCosts[${dsIndex.index}].consumptionQuantity" type="text" style="width: 100px" class="inputxt" value="${dsSfc.consumptionQuantity}"/></td>
                        	  	<td><input id="unit${dsIndex.index}" readonly="readonly" type="text" style="width: 100px;" class="inputxt unit" value="${dsSfc.materialUnitName}"/></td>
                        		<td><a href="javascript:void(0)" class="ace_button" style="background-color:#ec4758;" onclick="delTr(this,'${dsSfc.id}')"><span class="sfc_del">删除</span></a></td>
                        	  </tr>
                        	</c:forEach>
                            </c:if>
                        	</tbody>
                        </table>
                    </div>
                </li>
            </ul>
        </div>
     </t:formvalid>
     </c:forEach> 
     </c:if>
    </div>
</div>



	<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_maroDishesSpecifications_table_template">
	   <tr style="height: 42px;line-height: 42px;">
	  		<td>
	  		  <input id="materialclassName#index#" type="text" datatype="*" onclick="openMaterialselect(this,#index#)" readonly="readonly">
	  		  <input id="materialclassId#index#" class="materialclassId" type="hidden" datatype="*" name="foodCosts[#index#].materialclassId" readonly="readonly">
	  		</td>
	  		<td><input id="consumptionQuantity" datatype="/^\d+(\.\d+)?$/" name="foodCosts[#index#].consumptionQuantity" type="text" style="width: 100px" class="inputxt" value=""/></td>
	  		<td><input id="unit#index#" readonly="readonly" type="text" style="width: 100px;" class="inputxt unit" value=""/></td>
	  		<td><a href="javascript:void(0)" class="ace_button" style="background-color:#ec4758;" onclick="delTr(this)"><span class="sfc_del">删除(未保存)</span></a></td>
       </tr>
    </tbody>
	</table>
	
 <script type="text/javascript" src="webpage/com/maro/manager/dishes/dishes/js/menu.js"></script>
 <script type="text/javascript" src="webpage/com/maro/manager/dishes/dishes/js/dishesSpecifications.js"></script>

</body>
