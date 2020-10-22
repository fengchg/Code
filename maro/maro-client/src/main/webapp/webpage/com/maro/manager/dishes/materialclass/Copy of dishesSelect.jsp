<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<link rel="stylesheet" type="text/css" href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>

<script type="text/javascript">

    function clickClassificaTtion(id){
    	 var queryParams = $('#maroDishesList').datagrid('options').queryParams
    	if(id!=0){
    	 	queryParams.dishesClassification = id;
    	}else{
    		queryParams.dishesClassification = null;
    	}
    	$("#maroDishesList").datagrid("reload");
    }
    
   //选择
    function saveTask(){
   
		var v = $("input[type='checkbox']:checked");
			
		var w = $(v).parents("td").prev().find(".datagrid-cell-rownumber").html();

		var id = $(".datagrid-view2").find("tr[datagrid-row-index='"+(w-1)+"']").find("td[field='id']").find("div").html();
		var dishesName = $(".datagrid-view2").find("tr[datagrid-row-index='"+(w-1)+"']").find("td[field='dishesName']").find("div").html();
		
		var mycars=new Array()
		mycars[0]=id;
		mycars[1]=dishesName;

    	return mycars;
    }
</script>
  <style>
  ul li{
  	display: block;
    width: 90%;
    height: 24px;
    line-height: 24px;
    text-indent: 20px;
    cursor:pointer;
  }
  ul li:hover{
  	background-color: #ccc;
  }
  </style>
<div class="easyui-layout" style="width:911px; height:500px;">
    <div data-options="region:'west',split:true" title="菜肴分类" style="width:100px;">
        <ul id="" class="ztree66" >
            <li onclick="clickClassificaTtion(0)">全部</li>
         <c:forEach items="${mdcList}" var="e" varStatus="index">
           <li onclick="clickClassificaTtion('${e.id}')">${e.classificationName}</li>
         </c:forEach>
          
        </ul>
    </div>
    <div data-options="region:'center'" style="width:100%;">
        <t:datagrid name="maroDishesList" checkbox="true" singleSelect="true"  fitColumns="true" title="菜肴列表" actionUrl="maroDishesController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属门店"  field="sysCompanyCode" query="true"  queryMode="single"  dictionary="t_s_depart,id,departname,where or_not_store='Y'"  width="120"></t:dgCol>
   <t:dgCol title="编码"  field="coding"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="菜品名称"  field="dishesName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="拼音码"  field="pinyinCode"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  query="true"  queryMode="single"  dictionary="maro_dis_type"  width="120"></t:dgCol>
   <t:dgCol title="成本价格"  field="costPrice" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="销售价格"  field="salesPrice"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建来源"  field="createSource"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit"  query="true"  dictionary="maro_unit_name"  width="120"></t:dgCol>
   <t:dgCol title="规格属性"  field="specificationsId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原料分类"  field="classificationId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="菜品分类"  field="dishesClassification"  query="true"  queryMode="single"  dictionary="maro_dishes_classification,id,classification_name"  width="120"></t:dgCol>
   
   
  </t:datagrid>
    </div>
</div>