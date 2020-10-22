<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
 <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="maroPurchaseList" checkbox="true" fitColumns="true" title="采购主表" actionUrl="maroPurchaseController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属店铺"  field="shopId" dictionary="maro_shop,id,name" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="采购编号"  field="code"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="采购操作人"  field="optionUserId"  dictionary="t_s_base_user,id,realname" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审批人"  field="approveUserId"  dictionary="t_s_base_user,id,realname" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计划采购开始时间"  field="planStartTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际采购开始时间"  field="startTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="计划采购结束时间"  field="planEndTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际采购结束时间"  field="endTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="支付方式"  field="payType"  queryMode="single"  dictionary="maro_pay_type"  width="120"></t:dgCol>
   <t:dgCol title="预算"  field="budget"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="决算"  field="actualBudget"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="提交状态"  field="submitFlag" query="true"  queryMode="single"  dictionary="maro_submit_type" width="120"></t:dgCol>
   <t:dgCol title="审批状态"  field="approveState"  query="true" queryMode="single"  dictionary="maro_approve_type" width="120"></t:dgCol>
   <t:dgCol title="删除标志" hidden="true"  field="deleteFlag"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"  roleCanSee="cgspy"></t:dgCol>
   <t:dgDelOpt show="hidden" title="删除" url="maroPurchaseController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o" roleCanSee="cgspy"/>
   <t:dgToolBar show="hidden" title="录入" icon="icon-add" url="maroPurchaseController.do?goAdd" funname="add" width="100%" height="100%" roleCanSee="cgy,cgspy"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="编辑" icon="icon-edit" url="maroPurchaseController.do?goUpdate" funname="update" width="100%" height="100%" roleCanSee="cgy,cgspy"></t:dgToolBar>
   <%--<t:dgToolBar show="hidden" title="批量删除"  icon="icon-remove" url="maroPurchaseController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="maroPurchaseController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <%--<t:dgToolBar show="hidden" title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
   <t:dgToolBar show="hidden" title="申请采购" icon="icon-putout" funname="submitApprove" roleCanSee="cgy"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="查看历史消耗" icon="icon-putout" funname="historyInfo" roleCanSee="cgspy"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="审批通过" icon="icon-putout" funname="approvePass" roleCanSee="cgspy"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="审批不通过" icon="icon-putout" funname="approveNotPass" roleCanSee="cgspy"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="完成采购" icon="icon-putout" funname="finishPurchase" roleCanSee="cgy"></t:dgToolBar>
   <t:dgToolBar show="hidden" title="采购入库" icon="icon-putout" funname="putInStore" roleCanSee="cgy"></t:dgToolBar>
  </t:datagrid>
 </div>
</div>
<script src = "webpage/com/maro/manager/common/js/common.js"></script>
<script src = "webpage/com/maro/manager/store/purchase/maroPurchaseList.js"></script>
<script type="text/javascript">

    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'maroPurchaseController.do?upload', "maroPurchaseList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("maroPurchaseController.do?exportXls","maroPurchaseList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("maroPurchaseController.do?exportXlsByT","maroPurchaseList");
    }
    //mine
    //采购申请
    function submitApprove(){
        var selections=$("#maroPurchaseList").datagrid("getSelections");//选中行
        console.info(selections);
        if(selections.length==0){
            showMeg("未选择行！");
        }else{
            var ids="";
            for(var i=0;i<selections.length;i++){
                if(i==selections.length-1){
                    ids=ids+selections[i].id;
                }else{
                    ids=ids+selections[i].id+",";
                }
            }
            $.ajax({
                url:"maroPurchaseController.do?submitApprove",
                data:{
                    purchaseIds:ids
                },
                dataType:"json",
                success:function(result){
                    if(result.success){
                        showMeg(result.msg);
                        //重新加载数据
                        $('#maroPurchaseList').datagrid('reload');
                    }else{
                        showMeg(result.msg);
                    }
                }
            });
        }
    }
    //审批通过
    function approvePass(){
        var selections=$("#maroPurchaseList").datagrid("getSelections");//选中行
        console.info(selections);
        if(selections.length==0){
            showMeg("未选择行！");
        }else{
            var ids="";
            for(var i=0;i<selections.length;i++){
                if(i==selections.length-1){
                    ids=ids+selections[i].id;
                }else{
                    ids=ids+selections[i].id+",";
                }
            }
            $.ajax({
                url:"maroPurchaseController.do?approvePass",
                data:{
                    purchaseIds:ids
                },
                dataType:"json",
                success:function(result){
                    if(result.success){
                        showMeg(result.msg);
                        //重新加载数据
                        $('#maroPurchaseList').datagrid('reload');
                    }else{
                        showMeg(result.msg);
                    }
                }
            });
        }
    }
    //审批不通过
    function approveNotPass(){
        var selections=$("#maroPurchaseList").datagrid("getSelections");//选中行
        console.info(selections);
        if(selections.length==0){
            showMeg("未选择行！");
        }else{
            var ids="";
            for(var i=0;i<selections.length;i++){
                if(i==selections.length-1){
                    ids=ids+selections[i].id;
                }else{
                    ids=ids+selections[i].id+",";
                }
            }
            $.ajax({
                url:"maroPurchaseController.do?approveNotPass",
                data:{
                    purchaseIds:ids
                },
                dataType:"json",
                success:function(result){
                    if(result.success){
                        showMeg(result.msg);
                        //重新加载数据
                        $('#maroPurchaseList').datagrid('reload');
                    }else{
                        showMeg(result.msg);
                    }
                }
            });
        }
    }
    //完成采购
    function finishPurchase(){
        var selections=$("#maroPurchaseList").datagrid("getSelections");//选中行
        if(selections.length==0){
            showMeg("未选择行！");
        }else if(selections.length>1){
            showMeg("不能选择多行！");
        }else{
            var id=selections[0].id;
            $.ajax({
                url:"maroPurchaseController.do?finishPurchase",
                data:{
                    purchaseId:id
                },
                dataType:"json",
                success:function(result){
                    if(result.success){
                        showMeg(result.msg);
                        $('#maroPurchaseList').datagrid('reload');
                    }else{
                        showMeg(result.msg);
                    }
                }
            });
        }
    }
    //采购入库
    function putInStore(){
        var selections=$("#maroPurchaseList").datagrid("getSelections");//选中行
        if(selections.length==0){
            showMeg("未选择行！");
        }else if(selections.length>1){
            showMeg("不能选择多行！");
        }else{
            var id=selections[0].id;
            $.ajax({
                url:"maroPurchaseController.do?canPutInStore",
                data:{
                    purchaseId:id
                },
                dataType:"json",
                success:function(result){
                    if(result.success){
                        //采购入库操作
                        addOneTab("入库管理","maroPurchaseDetailController.do?list&purchaseId="+id);//打开弹出框
                    }else{
                        showMeg(result.msg);
                    }
                }
            });
        }
    }
    //查看历史原料消耗
    function historyInfo(){
        var selections=$("#maroPurchaseList").datagrid("getSelections");//选中行
        if(selections.length==0){
            showMeg("未选择行！");
        }else if(selections.length>1){
            showMeg("不能选择多行！");
        }else {
            var id = selections[0].id;
            var shopId=selections[0].shopId;
            $.dialog({
                content: 'url:reportController.do?materialHistoryUseInfo&purchaseId='+id+"&shopId="+shopId,
                lock : true,
                zIndex: getzIndex(),
                width:850,
                height:650,
                title:'原料列表',
                opacity : 0.3,
                cache:false,
                okVal: '确认',
                ok: function(){
                    return true;
                },
                cancelVal: '关闭',
                cancel: true /*为true等价于function(){}*/
            });
        }
    }
</script>