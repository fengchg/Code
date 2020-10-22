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
    <c:if test="${!empty setmealDishesList}">
    <c:forEach items="${setmealDishesList}" var="ds" varStatus="index">
    <t:formvalid formid="formobj${ds.id}" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroSetmealController.do?doAddDishesSelect">
        <div class="navBox">
            <ul>
                <li>
                   <input type="hidden" class="specificationsId" name="setmealDishesId" value="${ds.id}">
                    	<h2 class="obtain" style="height: 32px; line-height:30px;text-align: left;color: #000;font-size: 16px;font-weight: bold;text-indent: 25px;">
                    	${ds.className}
                    	<span>
                    	  <input type="text" class="beginNum${ds.id}" name="beginNum" datatype="n" readonly style="width:50px;" value="${ds.beginNum!=null?ds.beginNum:1}"> 
                    	选 <input type="text" class="selectNum${ds.id}" name="selectNum" datatype="n" onblur="ifSize(this,'${ds.id}')" style="width:50px;" value="${ds.selectNum!=null?ds.selectNum:1}"  onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
                    	</span>
                    	<span class="shouqi_zhangkai_${ds.id}" onclick="obtf('${ds.id}')" style="float: right;margin-right: 26px;color:#0000FF;text-decoration:underline;">收起</span>
                    	</h2>
                    	<div class="secondary secondary${ds.id}" style="height: 100%;">
                        <table style="width: 100%;" id="foodCostsTable${ds.id}" class="guigechenfen">
                        	<thead>
                        	  <tr style="height: 42px;line-height: 42px;">
                        		<th>菜品</th>
                        		<th>规格</th>
                        		<th>数量</th>
                        		<th>单位</th>
                        		<th>
                        		  <a href="javascript:void(0)" class="ace_button" id="addMaroDishesSpecificationsBtn" style="color:#FFF;" onclick="addSelectTr(this,'${ds.id}')">+添加成分</a>
                        		  <a href="javascript:void(0)" class="ace_button" id="" style="color:#FFF;background-color:#1a7bb9;" onclick="submitForm('${ds.id}')">保存</a>
                        		</th>
                        	  </tr>
                        	</thead>
                        	<tbody id="add_maroDishesSpecifications_table${ds.id}">
                        	<c:if test="${empty ds.setmealDishesSelectList}">
                        	  <tr style="height: 42px;line-height: 42px;">
                        		<td>
                        		  <input id="materialclassName0" type="text" datatype="*" onclick="openDishesSelect(this,0)" readonly="readonly">
                        		</td>
                        		<td>
                        		  <input type="text" class="inputxt specificationsName0" value="" readonly="readonly">
					              <input type="hidden" class="inputxt specificationsId0" name="setmealDishesSelect[0].specificationsId" value="" readonly="readonly">
                        		</td>
                        		<td><input id="consumptionQuantity" datatype="n" name="setmealDishesSelect[0].dishesNum" type="text" style="width: 100px" class="inputxt" value=""/></td>
                        	    <td><input id="unit0" readonly="readonly" type="text" style="width: 100px;" class="inputxt unit0" value=""/></td>
                        		<td><a href="javascript:void(0)" class="ace_button" style="background-color:#ec4758;" onclick="delSelectTr(this,'${dsSfc.id}')"><span class="sfc_del">删除(未保存)</span></a></td>
                        	  </tr>
                        	  </c:if>
                        	  <c:if test="${!empty ds.setmealDishesSelectList}">
                              <c:forEach items="${ds.setmealDishesSelectList}" var="dsSfc" varStatus="dsIndex">
                                <tr style="height: 42px;line-height: 42px;">
                        		  <td>
                        		    <input id="materialclassName${dsIndex.index}" type="text" datatype="*" onclick="openDishesSelect(this,${dsIndex.index})" value="${dsSfc.dishesName}" readonly="readonly">
                        		  </td>
                        		  <td>
                        		    <input type="text" class="inputxt specificationsName${dsIndex.index}" value="${dsSfc.specificationsName}" readonly="readonly">
					                <input type="hidden" class="inputxt specificationsId${dsIndex.index}" name="setmealDishesSelect[${dsIndex.index}].specificationsId" value="${dsSfc.specificationsId}" readonly="readonly">
                        		  </td>
                        		  <td><input id="consumptionQuantity" datatype="n" name="setmealDishesSelect[${dsIndex.index}].dishesNum" type="text" style="width: 100px" class="inputxt" value="${dsSfc.dishesNum}" onblur="delDishes('${ds.id}',${dsIndex.index})"/></td>
                        	      <td><input id="unit${dsIndex.index}" readonly="readonly" type="text" style="width: 100px;" class="inputxt unit${dsIndex.index}" value="${dsSfc.dishesUnit}"/></td>
                        		  <td><a href="javascript:void(0)" class="ace_button del_dishes_${dsIndex.index}" style="background-color:#ec4758;" onclick="delSelectTr(this,'${dsSfc.id}')"><span class="sfc_del">删除</span></a></td>
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
	  		  <input id="materialclassName#index#" type="text" datatype="*" onclick="openDishesSelect(this,#index#)" readonly="readonly">
	  		</td>
	  		<td>
	  			<input type="text" class="inputxt specificationsName#index#" value="" readonly="readonly">
				<input type="hidden" class="inputxt specificationsId#index#" name="setmealDishesSelect[#index#].specificationsId" value="" readonly="readonly">
	  		</td>
	  		<td><input id="consumptionQuantity" datatype="n" name="setmealDishesSelect[#index#].dishesNum" type="text" style="width: 100px" class="inputxt" value="" onblur="delDishes(#index#)"/></td>
	  		<td><input id="unit0" readonly="readonly" type="text" style="width: 100px;" class="inputxt unit#index#" value=""/></td>
	  		<td><a href="javascript:void(0)" class="ace_button del_dishes_#index#" style="background-color:#ec4758;" onclick="delSelectTr(this)"><span class="sfc_del">删除(未保存)</span></a></td>
       </tr>
    </tbody>
	</table>
	
 <script type="text/javascript" src="webpage/com/maro/manager/dishes/dishes/js/menu.js"></script>
 <script src = "webpage/com/maro/manager/dishes/setmeal/maroSetmeal.js"></script>
</body>