<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="maroPrinterList" checkbox="true" pagination="true" fitColumns="false" title="打印机" actionUrl="maroPrinterController.do?datagrid" idField="id" fit="true" queryMode="group">
            <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="IP地址"  field="printerIp"    queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="端口"  field="printerPort"    queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="名称"  field="printerName"    queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="位置"  field="printerLocation"    queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="备用"  field="printerStandby1"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="备用"  field="printerStandby2"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="备用"  field="printerStandby3"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
            <t:dgDelOpt title="删除" url="maroPrinterController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
            <t:dgToolBar title="录入" icon="icon-add" url="maroPrinterController.do?goAdd" funname="add"></t:dgToolBar>
            <t:dgToolBar title="编辑" icon="icon-edit" url="maroPrinterController.do?goUpdate" funname="update"></t:dgToolBar>
            <t:dgToolBar title="批量删除"  icon="icon-remove" url="maroPrinterController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
            <t:dgToolBar title="查看" icon="icon-search" url="maroPrinterController.do?goUpdate" funname="detail"></t:dgToolBar>
            <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
        </t:datagrid>
    </div>
</div>
<script src = "webpage/com/maro/manager/maroprint/maroprinter/maroPrinterList.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    });



    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'maroPrinterController.do?upload', "maroPrinterList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("maroPrinterController.do?exportXls","maroPrinterList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("maroPrinterController.do?exportXlsByT","maroPrinterList");
    }


    function formatImage(value,row,index){
        var href='';
        if(value==null || value.length==0){
            return href;
        }
        var split = value.split(',');
        $(split).each(function(i,val) {
            href += "<img src='" + val + "' width=100 height=50/>&nbsp;&nbsp;";
        });
        return href;
    }

    function formatFile(value,row,index){
        var href='';
        if(value==null || value.length==0){
            return href;
        }
        if(value.indexOf(".jpg")>-1 || value.indexOf(".gif")>-1 || value.indexOf(".png")>-1){
            href+="<img src='"+value+"'/>";
        }else{
            href+="<a href='"+value+"' class='ace_button' target=_blank><u><i class='fa fa-download'></i>点击下载</u></a>";
        }
        return href;
    }

</script>