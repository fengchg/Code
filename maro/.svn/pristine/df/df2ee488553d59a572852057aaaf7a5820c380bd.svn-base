<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>maro_purchase_detail</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript">
        //编写自定义JS代码
        //生成标签码
        function makeLabelCode(){
            $.ajax({
                url:"utilController.do?makeLableCode",
                data:{},
                dataType:"json",
                success:function(result){
                    if(result.success){
                        $("#labelCode").val(result.obj);
                    }else{
                        showMeg(result.msg);
                    }
                }
            });
        }
        //改变价格后出发函数
        function afterChangePrice(obj){
            var price=$(obj).val();
            var num=$("#number").val();
            $("#totalPrice").val(1000000000*Number(num)*Number(price)/1000000000);
        }
        //改变数量后出发函数
        function afterChangeNum(obj){
            var num=$(obj).val();
            var price=$("#price").val();
            $("#totalPrice").val(1000000000*Number(num)*Number(price)/1000000000);
        }
        $(function() {// 初始化
            var t=$("#number").val();
            $("#number").val("").focus().val(t);
            var spaceNum=-1;
            var str="";
            document.getElementById('number').addEventListener('input',function(e){
                var data=e.data;
                if(data==" "){
                    spaceNum++;
                }
                if(spaceNum==1){
                    $("#number").val("");
                    spaceNum=-1;
                }

                /*if ( !(e.clipboardData && e.clipboardData.items) ) {
                    return;
                }
                for (var i = 0, len = e.clipboardData.items.length; i < len; i++) {
                    var item = e.clipboardData.items[i];
                    if (item.kind === "string") {
                        item.getAsString(function (str) {
                            $("#number").val(str);
                        })
                    }
                }*/
            });
        });
    </script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroPurchaseDetailController.do?doUpdate&shopId=${shopId}" >
    <input id="id" name="id" type="hidden" value="${maroPurchaseDetailPage.id }"/>
    <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr style="display: none">
            <td align="right">
                <label class="Validform_label">
                    创建人名称:
                </label>
            </td>
            <td class="value">
                <input id="createName" name="createName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.createName}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">创建人名称</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    创建人登录名称:
                </label>
            </td>
            <td class="value">
                <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.createBy}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">创建人登录名称</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    创建日期:
                </label>
            </td>
            <td class="value">
                <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${maroPurchaseDetailPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">创建日期</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    更新人名称:
                </label>
            </td>
            <td class="value">
                <input id="updateName" name="updateName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.updateName}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">更新人名称</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    更新人登录名称:
                </label>
            </td>
            <td class="value">
                <input id="updateBy" name="updateBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.updateBy}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">更新人登录名称</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    更新日期:
                </label>
            </td>
            <td class="value">
                <input id="updateDate" name="updateDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${maroPurchaseDetailPage.updateDate}' type="date" pattern="yyyy-MM-dd"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">更新日期</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    所属部门:
                </label>
            </td>
            <td class="value">
                <input id="sysOrgCode" name="sysOrgCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.sysOrgCode}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">所属部门</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    所属公司:
                </label>
            </td>
            <td class="value">
                <input id="sysCompanyCode" name="sysCompanyCode" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.sysCompanyCode}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">所属公司</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    流程状态:
                </label>
            </td>
            <td class="value">
                <input id="bpmStatus" name="bpmStatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.bpmStatus}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">流程状态</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    采购id:
                </label>
            </td>
            <td class="value">
                <input id="purchaseId" name="purchaseId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.purchaseId}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">采购id</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    计划商品单价:
                </label>
            </td>
            <td class="value">
                <input id="planPrice" name="planPrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.planPrice}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">计划商品单价</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    计划商品数量:
                </label>
            </td>
            <td class="value">
                <input id="planNumber" name="planNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.planNumber}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">计划商品数量</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    计划总价:
                </label>
            </td>
            <td class="value">
                <input id="planTotalPrice" name="planTotalPrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.planTotalPrice}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">计划总价</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    是否入库:
                </label>
            </td>
            <td class="value">
                <input id="isInStore" name="isInStore" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${maroPurchaseDetailPage.isInStore}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">是否入库</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    入库时间:
                </label>
            </td>
            <td class="value">
                <input id="inStoreTime" name="inStoreTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${maroPurchaseDetailPage.inStoreTime}' type="date" pattern="yyyy-MM-dd"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">入库时间</label>
            </td>
            <td align="right">
                <label class="Validform_label">
                    删除标志:
                </label>
            </td>
            <td class="value">
                <input id="deleteFlag" name="deleteFlag" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${maroPurchaseDetailPage.deleteFlag}'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">删除标志</label>
            </td>
        </tr>

        <tr>
            <td align="right">
                <label class="Validform_label">
                    原料:
                </label>
            </td>
            <td class="value">
                <input name="materialClassId" value="${maroPurchaseDetailPage.materialClassId}" type="hidden"/>
                <t:dictSelect field="materialClassId" type="list" readonly="readonly" datatype="s" dictTable="maro_material_class" dictField="id" dictText="material_name" defaultVal="${maroPurchaseDetailPage.materialClassId}" hasLabel="false"  title="原料"></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">原料</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    实际单价:
                </label>
            </td>
            <td class="value">
                <input id="price" name="price" type="text" style="width: 150px" class="inputxt" onkeyup="afterChangePrice(this)"  datatype="*" ignore="checked"  value='${maroPurchaseDetailPage.planPrice}'/><label>元${priceType}</label>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">实际单价</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    实际数量:
                </label>
            </td>
            <td class="value">
                <input id="number" name="number" type="text" style="width: 150px" class="inputxt" onkeyup="afterChangeNum(this)" datatype="*" ignore="checked"  value='${maroPurchaseDetailPage.planNumber}'/><label>${priceType}</label>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">实际数量</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    实际总价:
                </label>
            </td>
            <td class="value">
                <input id="totalPrice" name="totalPrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${maroPurchaseDetailPage.planTotalPrice}'/><label>元</label>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">实际总价</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    标签码:
                </label>
            </td>
            <td class="value">
                <input id="labelCode"  readonly="readonly" name="labelCode" type="text" style="width: 150px" class="inputxt" value="${coding}" <%-- datatype="*" ignore="checked"--%>/>
                <a class="easyui-linkbutton" iconCls="icon-search" onclick="makeLabelCode.bak()">打印标签码</a>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">标签码</label>
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="Validform_label">
                    选择仓库:
                </label>
            </td>
            <td class="value">
                <t:dictSelect field="storeId" type="list"  datatype="s" dictTable="maro_shop_store" dictField="id" dictText="name"  dictCondition="${storeCondition}" defaultVal="${maroPurchaseDetailPage.storeId}" hasLabel="false"  title="仓库"></t:dictSelect>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">仓库id</label>
            </td>

        </tr>
    </table>
</t:formvalid>
</body>
<script src = "webpage/com/maro/manager/store/purchasedetail/maroPurchaseDetail.js"></script>
