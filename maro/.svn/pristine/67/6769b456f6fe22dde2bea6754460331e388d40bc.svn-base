<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="marpPrintTemplateList" checkbox="true" pagination="true" fitColumns="false" title="打印" actionUrl="marpPrintTemplateController.do?datagrid" idField="id" fit="true" queryMode="group">
            <t:dgCol title="主键"  field="id"  hidden="true"	 queryMode="single"  width="120"></t:dgCol>
           
            <t:dgCol title="名称"  field="name"  queryMode="single" width="120"></t:dgCol>
           
            <t:dgCol title="打印机"  field="url" query="false" queryMode="single"  dictionary="maro_printer,ID,PRINTER_NAME"  width="120"></t:dgCol>

            <t:dgToolBar title="查看" icon="icon-search" url="marpPrintTemplateController.do?goUpdate" funname="detail"></t:dgToolBar>
            <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
        </t:datagrid>
    </div>
</div>
<script src = "webpage/com/maro/manager/maroprint/printtemplate/marpPrintTemplateList.js"></script>
