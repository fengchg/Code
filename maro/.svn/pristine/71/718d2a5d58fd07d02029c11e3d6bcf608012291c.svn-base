<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="maroOperatingStatementList" checkbox="true" pagination="true" fitColumns="false" title="营业报表" actionUrl="maroOperatingStatementController.do?datagrid" idField="id" fit="true" queryMode="group">
            <t:dgCol title="主键"  field="id" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建人名称"  field="createName" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"	 queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新人名称"  field="updateName" hidden="true" queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="更新人登录名称"  field="updateBy" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="所属部门"  field="sysOrgCode" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="所属公司"  field="sysCompanyCode" hidden="true" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="名称"  field="name" queryMode="single"  width="290"></t:dgCol>
            <t:dgCol title="简称"  field="code" queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="路径"  field="url" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="方式"  field="run" queryMode="single" width="120"></t:dgCol>
            <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
            <t:dgDelOpt title="删除" url="maroOperatingStatementController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
            <t:dgFunOpt funname="openStatement(id,name,code)" title="查看" urlclass="ace_button" urlfont="fa-edit" urlStyle="background-color:#21b9bb;"></t:dgFunOpt>
            <t:dgToolBar title="录入" icon="icon-add" url="maroOperatingStatementController.do?goAdd" funname="add"></t:dgToolBar>
            <t:dgToolBar title="编辑" icon="icon-edit" url="maroOperatingStatementController.do?goUpdate" funname="update"></t:dgToolBar>
            <t:dgToolBar title="批量删除"  icon="icon-remove" url="maroOperatingStatementController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
            <t:dgToolBar title="查看" icon="icon-search" url="maroOperatingStatementController.do?goUpdate" funname="detail"></t:dgToolBar>
            <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
            <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
            <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
        </t:datagrid>
    </div>
</div>
<script src = "webpage/com/maro/manager/operatingstatement/maroOperatingStatementList.js"></script>
<script type="text/javascript">

    $(document).ready(function(){
    });
    
	var url = "<%=path%>/birtController.do?demo"; // "http://193.112.42.207:8091/birt/frameset?__report=";
    function openStatement(id,name,code,num){
 		addOneTab(name, url + "&code="+code);
	}



    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'maroOperatingStatementController.do?upload', "maroOperatingStatementList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("maroOperatingStatementController.do?exportXls","maroOperatingStatementList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("maroOperatingStatementController.do?exportXlsByT","maroOperatingStatementList");
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