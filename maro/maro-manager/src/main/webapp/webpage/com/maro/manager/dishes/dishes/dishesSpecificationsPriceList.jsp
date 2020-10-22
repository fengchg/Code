<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>价格列表</title>
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
  function addPrice(specificationsId){
  
  	$.dialog.confirm("是否提交表单", function(){
		 $("#formobj"+specificationsId).submit();
		 
		 $("#foodCostsTable"+specificationsId).find(".sfc_del").each(function(i, n){
		  		$(n).html('');
		  		$(n).css("display","none");
		 });
		 
	}, function(){
		
	});
	
  }
  
  /** 价格 input失去焦点
  *   th 当前
  *   i 下标
  *   dsId 规格id
  *   ${sps.price}  当前价格框里的值
  */
  function checkTypePrice(th,i,dsId,price){
  	
  	  if(price != $(th).val()){
  	  	$(".typePrice_"+dsId+"_"+i).html("未保存");
  	  	$(".typePrice_"+dsId+"_"+i).css("display","inline");
  	  }else{
  	  	$(".typePrice_"+dsId+"_"+i).css("display","none");
  	  }
  }
  </script>
 </head>
 <body>
    
<div id="menu" style="mar">
    <!--显示菜单-->
    <div id="open"  style="margin: 0px auto;">
    <c:if test="${!empty goGetSpecificationsPirceList}">
    <c:forEach items="${goGetSpecificationsPirceList}" var="ds" varStatus="index">
    <t:formvalid formid="formobj${ds.id}" dialog="true" usePlugin="password" layout="table" tiptype="1" action="maroSpecificationsPriceController.do?doAdd2">
        <div class="navBox">
            <ul>
                <li>
                   <input type="hidden" name="specificationsId" value="${ds.id}">
                    	<h2 class="obtain" onclick="obtf('${ds.id}')" style="height: 32px; line-height:30px;text-align: left;color: #000;font-size: 16px;font-weight: bold;text-indent: 25px;">${ds.pageName}[规格]<i class="arrowRot"></i></h2>
                    	<div class="secondary secondary${ds.id}" style="height: 0px;">
                        <table style="width: 100%;" id="foodCostsTable${ds.id}" class="guigechenfen">
                        	<thead>
                        	  <tr  style="height: 42px;line-height: 42px;">
                        		<th>店铺名称</th>
                        		<th>会员折扣方式</th>
                        		<th>价格</th>
                        		<th>
                        		  <a href="javascript:void(0)" class="ace_button" id="" style="color:#FFF;background-color:#1a7bb9;" onclick="addPrice('${ds.id}')">保存</a>
                        		</th>
                        	  </tr>
                        	</thead>
                        	<tbody id="add_maroDishesSpecifications_table${ds.id}">
                           
                            <c:forEach items="${ds.specatinsPriceShow}" var="sps" varStatus="spsIndex">
                              <tr style="height: 42px;line-height: 42px;">
                        		<td>
                        		  <input id="" type="text" datatype="*" readonly="readonly" value="${sps.deprtName}">
                        		  <input id="" type="hidden" datatype="*" name="specificationsPriceList[${spsIndex.index}].shopId" readonly="readonly" value="${sps.deprtId}">
                        		</td>
                        		<td>${ds.pageMemberDiscount}&nbsp;&nbsp;${ds.discountWay}</td>
                        		<td><input id="createSource" onblur="checkTypePrice(this,${spsIndex.index},'${ds.id}',${sps.price})" datatype="d" name="specificationsPriceList[${spsIndex.index}].price" type="text" style="width: 100px" class="inputxt" value="${sps.price}"/></td>
                        		<td class=""><a href="javascript:void(0)" class="ace_button typePrice_${ds.id}_${spsIndex.index} sfc_del" id="" style="color:#FFF;background-color:#ce233b;display:none;" )"></a></td>
                        	  </tr>
                        	</c:forEach>
                            
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
	
<script type="text/javascript" src="webpage/com/maro/manager/dishes/dishes/js/menu.js"></script>
 <script type="text/javascript" src="webpage/com/maro/manager/dishes/dishes/js/dishesSpecifications.js"></script>
</body>
