<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<link rel="stylesheet" type="text/css"
	href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript"
	src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript"
	src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>

<script type="text/javascript">
	function clickClassificaTtion(id) {
		var queryParams = $('#maroDishesList').datagrid('options').queryParams
		if (id != 0) {
			queryParams.dishesClassification = id;
		} else {
			queryParams.dishesClassification = null;
		}
		$("#maroDishesList").datagrid("reload");
	}

	//选择
	function saveTask() {

		var v = $("input[type='checkbox']:checked");

		//var w = $(v).parents("td").prev().find(".datagrid-cell-rownumber").html();
		var w = $(v).parents("tr").attr("datagrid-row-index");

		//菜肴id
		var id = $(".datagrid-view2").find("tr[datagrid-row-index='" + (w) + "']").find("td[field='id']").find("div").html();
		//菜肴名称
		var dishesName = $(".datagrid-view2").find("tr[datagrid-row-index='" + (w) + "']").find("td[field='dishesName']").find("div").html();
		//菜肴规格id
		var specificationId = $(".datagrid-view2").find("tr[datagrid-row-index='" + (w) + "']").find("td[field='specificationId']").find("div").html();
		//菜肴规格名称
		var specificationsName = $(".datagrid-view2").find("tr[datagrid-row-index='" + (w) + "']").find("td[field='specificationsName']").find("div").html();
		//菜肴单位
		var unit = $(".datagrid-view2").find("tr[datagrid-row-index='" + (w) + "']").find("td[field='unit']").find("div").html();
		
		var mycars = new Array()
		mycars[0] = id;
		mycars[1] = dishesName;
		mycars[2] = specificationId;
		mycars[3] = specificationsName;
		mycars[4] = unit;

		return mycars;
	}
</script>
<style>
ul li {
	display: block;
	width: 90%;
	height: 24px;
	line-height: 24px;
	text-indent: 20px;
	cursor: pointer;
}

ul li:hover {
	background-color: #ccc;
}
</style>
<div class="easyui-layout" style="width: 911px; height: 500px;">
	<div data-options="region:'west',split:true" title="菜肴分类"
		style="width: 100px;">
		<ul id="" class="ztree66">
			<li onclick="clickClassificaTtion(0)">全部</li>
			<c:forEach items="${mdcList}" var="e" varStatus="index">
				<li onclick="clickClassificaTtion('${e.id}')">${e.classificationName}</li>
			</c:forEach>

		</ul>
	</div>
	<div data-options="region:'center'" style="width: 100%;">


		
  <t:datagrid name="maroDishesList" checkbox="true" singleSelect="true"  fitColumns="true" title="菜肴列表" actionUrl="maroMaterialClassController.do?dishesSelectDatagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   
   <t:dgCol title="所属门店"  field="sysCompanyCode" query="true" replace="${replace}" queryMode="single"  dictionary="maro_shop,id,name"  width="120"></t:dgCol>
   
   <t:dgCol title="编码"  field="coding"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="菜品名称"  field="dishesName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="拼音码"  field="pinyinCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  query="true"  queryMode="single"  dictionary="maro_dis_type"  width="120"></t:dgCol>
   <t:dgCol title="规格"  field="specificationsName" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="规格id"  field="specificationId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit" dictionary="maro_unit_name"  width="120"></t:dgCol>
   <t:dgCol title="原料分类"  field="classificationId" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="菜品分类"  field="dishesClassification"  query="true"  queryMode="single"  dictionary="maro_dishes_classification,id,classification_name"  width="120"></t:dgCol>
   
   
  </t:datagrid>



	</div>
</div>