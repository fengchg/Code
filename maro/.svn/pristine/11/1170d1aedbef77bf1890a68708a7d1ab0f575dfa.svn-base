<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<link rel="stylesheet" type="text/css" href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript" src="webpage/com/maro/manager/dishes/dishes/js/materialSelect.js"></script>
<script type="text/javascript">

    function clickClassificaTtion(id){
    	 var queryParams = $('#maroMaterialClassList').datagrid('options').queryParams
    	if(id!=0){
    	 	queryParams.classificationId = id;
    	}else{
    		queryParams.classificationId = null;
    	}
    	$("#maroMaterialClassList").datagrid("reload");
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
<div class="easyui-layout" style="width:1000px;height:500px;">
    <div data-options="region:'west',split:true" title="原料分类" style="width:200px;">
        <ul id="" class="ztree66" >
            <li onclick="clickClassificaTtion(0)">全部</li>
         <c:forEach items="${ificationList}" var="e" varStatus="index">
           <li onclick="clickClassificaTtion('${e.id}')">${e.classificationName}</li>
         </c:forEach>
          
        </ul>
    </div>
    <div data-options="region:'center'">
        <t:datagrid checkbox="true" singleSelect="true" name="maroMaterialClassList" title="原料表" actionUrl="maroMaterialClassController.do?datagrid"
                    fit="true" fitColumns="true" idField="id" queryMode="group" sortName="createDate" sortOrder="desc">
       
	   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="原料名称"  field="materialName" query="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="原料编码"  field="coding" query="true"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="原料类型"  field="type"  query="true"  queryMode="single"  dictionary="maro_material_type"  width="120"></t:dgCol>
	   <t:dgCol title="原料分类"  field="classificationId"  query="true"  queryMode="single"  dictionary="maro_material_classification,id,classification_name"  width="120"></t:dgCol>
	   <t:dgCol title="计价单位"  field="denominatedUnit"  queryMode="single"  dictionary="maro_unit_name"  width="120"></t:dgCol>
	   <t:dgCol title="采购价"  field="purchasingPrice"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="创建来源"  field="createSource" hidden="true"  queryMode="single"  width="120"></t:dgCol>
	  </t:datagrid>
    </div>
</div>