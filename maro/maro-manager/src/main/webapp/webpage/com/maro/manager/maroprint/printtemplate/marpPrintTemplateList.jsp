<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="marpPrintTemplateList" checkbox="true" pagination="true" fitColumns="false" title="打印" actionUrl="marpPrintTemplateController.do?datagrid" idField="id" fit="true" queryMode="group">
            <t:dgCol title="主键"  field="id"  hidden="true"	 queryMode="single"  width="120"></t:dgCol>
           
            <t:dgCol title="名称"  field="name"  queryMode="single" width="120"></t:dgCol>
           
            <t:dgCol title="打印机"  field="url" query="false" queryMode="single"  dictionary="maro_printer,ID,PRINTER_NAME"  width="120"></t:dgCol>

            <t:dgToolBar title="编辑" icon="icon-edit" url="marpPrintTemplateController.do?goUpdate" funname="update"></t:dgToolBar>

            <t:dgToolBar title="查看" icon="icon-search" url="marpPrintTemplateController.do?goUpdate" funname="detail"></t:dgToolBar>
            <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
        </t:datagrid>
    </div>
</div>
<!--
  <t:dgCol title="code"  field="code" queryMode="single" width="190"></t:dgCol>
 <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
 <t:dgDelOpt title="删除" url="marpPrintTemplateController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
 <t:dgToolBar title="录入" icon="icon-add" url="marpPrintTemplateController.do?goAdd" funname="add"></t:dgToolBar>
 <t:dgToolBar title="批量删除"  icon="icon-remove" url="marpPrintTemplateController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
-->
<script src = "webpage/com/maro/manager/maroprint/printtemplate/marpPrintTemplateList.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    });
    
    var url = '<%=basePath%>';
    
     //打开tab窗口
 	function addbytab(code){
		$.post(url+"/PrintController.do?printData",{'type':code},function(result){
	 		var dataObj=JSON.parse(result);//转换为json对象 
			var obj = dataObj.obj;
		});
 	}



    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'marpPrintTemplateController.do?upload', "marpPrintTemplateList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("marpPrintTemplateController.do?exportXls","marpPrintTemplateList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("marpPrintTemplateController.do?exportXlsByT","marpPrintTemplateList");
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