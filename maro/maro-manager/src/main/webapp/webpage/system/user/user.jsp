<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户信息</title>
<t:base type="jquery,easyui,tools"></t:base>
    <script>
<%-- //        update-start--Author:zhangguoming  Date:20140826 for：将combobox修改为combotree
        function setOrgIds() {
//            var orgIds = $("#orgSelect").combobox("getValues");
            var orgIds = $("#orgSelect").combotree("getValues");
            $("#orgIds").val(orgIds);
        }
        $(function() {
            $("#orgSelect").combotree({
                onChange: function(n, o) {
                    if($("#orgSelect").combotree("getValues") != "") {
                        $("#orgSelect option").eq(1).attr("selected", true);
                    } else {
                        $("#orgSelect option").eq(1).attr("selected", false);
                    }
                }
            });
            $("#orgSelect").combobox("setValues", ${orgIdList});
            $("#orgSelect").combotree("setValues", ${orgIdList});
        }); --%>

		var roleCodes = '${roleCodes}';

		function openDepartmentSelect() {
			$.dialog.setting.zIndex = getzIndex(); 
			var orgIds = $("#orgIds").val();

			$.dialog({content: 'url:departController.do?departSelect&orgIds='+orgIds, zIndex: getzIndex(), title: '组织机构列表', lock: true, width: '400px', height: '350px', opacity: 0.4, button: [
			   {name: '<t:mutiLang langKey="common.confirm"/>', callback: callbackDepartmentSelect, focus: true},
			   {name: '<t:mutiLang langKey="common.cancel"/>', callback: function (){}}
		   ]}).zindex();
			
			//当选择机构时就需要重新清空工号
			$("#empNo").val("");
			
		}
			
		function callbackDepartmentSelect() {
			  var iframe = this.iframe.contentWindow;
			  var treeObj = iframe.$.fn.zTree.getZTreeObj("departSelect");
			  var nodes = treeObj.getCheckedNodes(true);
			  if(nodes.length>0){
			  var ids='',names='';
			  for(i=0;i<nodes.length;i++){
			     var node = nodes[i];
			     ids += node.id+',';
			    names += node.name+',';
			 }
			 $('#departname').val(names);
			 $('#departname').blur();		
			 $('#orgIds').val(ids);		
			}
		}
		
		function callbackClean(){
			$('#departname').val('');
			 $('#orgIds').val('');	
		}
		
		function setOrgIds() {}
		$(function(){
			$("#departname").prev().hide();
		});
		
		
		
		//编码失去焦点时
		function checkEmpNo(th){
			var roleCodes2 = roleCodes.split(",");
			var orgIds =  $('#orgIds').val();

			for(var i=0;i<roleCodes2.length;i++){
				if(roleCodes2[i] == 'maro_admin' || roleCodes2[i] == 'admin'){
					if(orgIds == ''){
						$(th).val("");
		    			$(th).addClass("Validform_error");
		    			$(".empNo").addClass("Validform_wrong");
		    			$(".empNo").html("您需要先选择组织机构才能输入工号");
		    			
		    			$("#departname").addClass("Validform_error");
		    			$(".departname").addClass("Validform_wrong");
		    			$(".departname").html("请填写组织机构！");
					}	
				}
			} 
		
			var c1 = $(th).val();
			var c2 = $("#empNo2").val();
			if(c1 == c2){return;}
		
			if(c1!=""){
				$.post("userController.do?checkEmpNo",{empNo:c1,orgIds:orgIds},function(result){
		    		var jsondata = $.parseJSON(result);
		    		if(jsondata.obj >= 1){
		    			//alertTip("编号 " + c1 + " 已存在,请重新输入");
		    			$(th).val("");
		    			$(th).addClass("Validform_error");
		    			$(".empNo").addClass("Validform_wrong");
		    			$(".empNo").html("编号 " + c1 + " 已存在,请重新输入");
		    		}else{
		    			$(th).removeClass("Validform_error");
		    			$(".empNo").removeClass("Validform_wrong");
		    			$(".empNo").html("通过信息验证！");
		    		}
				});
			}
			
			
		}
		
    </script>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="muserController.do?msaveUser" beforeSubmit="setOrgIds">
	<input id="id" name="id" type="hidden" value="${user.id }"/>
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label">  <t:mutiLang langKey="common.empno"/>:  </label>
            </td>
			<td class="value" width="85%">
                    <input id="empNo" class="inputxt" name="empNo" onblur="checkEmpNo(this)" maxlength="4" value="${user.empNo }" datatype="n4-4" />
                    <input type="hidden" id="empNo2" class="inputxt" value="${user.empNo }" />
                    <span class="Validform_checktip empNo"> 
                    	工号范围在4位数字
                    </span>
            </td>
		</tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label">  <t:mutiLang langKey="common.username"/>:  </label>
            </td>
			<td class="value" width="85%">
                <c:if test="${user.id!=null }"> ${user.userName } </c:if>
                <c:if test="${user.id==null }">
                    <input id="userName" class="inputxt" name="userName" validType="t_s_base_user,userName,id" value="${user.userName }" datatype="s2-20" />
                    <span class="Validform_checktip"> <t:mutiLang langKey="username.rang2to20"/></span>
                </c:if>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.real.name"/>: </label></td>
			<td class="value" width="10%">
                <input id="realName" class="inputxt" name="realName" value="${user.realName }" datatype="s2-10"/>
                <span class="Validform_checktip"><t:mutiLang langKey="fill.realname"/></span>
            </td>
		</tr>
		<c:if test="${user.id==null }">
			<tr>
				<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.password"/>: </label></td>
				<td class="value">
                    <input type="password" class="inputxt" value="" name="password" plugin="passwordStrength" datatype="*8-18" errormsg="" />
                    <span class="passwordStrength" style="display: none;">
                        <span><t:mutiLang langKey="common.weak"/></span>
                        <span><t:mutiLang langKey="common.middle"/></span>
                        <span class="last"><t:mutiLang langKey="common.strong"/></span>
                    </span>
                    <span class="Validform_checktip"> 
                    	<!-- <t:mutiLang langKey="password.rang6to18"/> -->
                   		 密码至少8个字符,最多18个字符
                    </span>
                </td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.repeat.password"/>: </label></td>
				<td class="value">
                    <input id="repassword" class="inputxt" type="password" value="${user.password}" recheck="password" datatype="*6-18" errormsg="两次输入的密码不一致！"/>
                    <span class="Validform_checktip"><t:mutiLang langKey="common.repeat.password"/></span>
                </td>
			</tr>
		</c:if>
		<tr>
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.department"/>: </label></td>
			<td class="value">
			 	<%--  这是旧版本的代码，下拉框的形式  --%>
                <%--<select class="easyui-combobox" data-options="multiple:true, editable: false" id="orgSelect" datatype="*">--%>
                <%-- <select select="width:150px;" class="easyui-combotree" data-options="url:'departController.do?getOrgTree', multiple:false, cascadeCheck:false"
                        id="orgSelect" name="orgSelect" datatype="select1">
                    <c:forEach items="${departList}" var="depart">
                        <option value="${depart.id}" <c:if test="${depart.id == tsDepart.id}">selected="selected"</c:if>>${depart.departname}</option>
                    </c:forEach>
                </select>
                <input id="orgIds" name="orgIds" type="hidden">
                <span class="Validform_checktip"><t:mutiLang langKey="please.select.department"/></span> --%>
                
                
                <%--  这是最新版本的代码，弹出层的形式  --%>
                <input id="departname" name="departname" type="text" readonly="readonly" class="inputxt" datatype="*" value="${departname}"/>
                <input id="orgIds" name="orgIds" type="hidden" value="${orgIds}"/>
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" id="departSearch" onclick="openDepartmentSelect()">选择</a>
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" id="departRedo" onclick="callbackClean()">清空</a>
                <span class="Validform_checktip departname"><t:mutiLang langKey="please.muti.department"/></span> 
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.role"/>: </label></td>
			<td class="value" nowrap>
                <input id="roleid" name="roleid" type="hidden" value="${id}"/>
                <input name="roleName" id="roleName" class="inputxt" value="${roleName }" readonly="readonly" datatype="*" />
                <t:choose hiddenName="roleid" hiddenid="id" textname="roleName" url="userController.do?roles" name="roleList" icon="icon-search" title="common.role.list" isclear="true" isInit="true"></t:choose>
                <span class="Validform_checktip"><t:mutiLang langKey="role.muti.select"/></span>
            </td>
		</tr>
		<tr>
			<td align="right" nowrap><label class="Validform_label">  <t:mutiLang langKey="common.phone"/>: </label></td>
			<td class="value">
                <input class="inputxt" name="mobilePhone" value="${user.mobilePhone}" datatype="m" errormsg="手机号码不正确" ignore="ignore"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.tel"/>: </label></td>
			<td class="value">
                <input class="inputxt" name="officePhone" value="${user.officePhone}" datatype="n" errormsg="办公室电话不正确" ignore="ignore"/>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.common.mail"/>: </label></td>
			<td class="value">
                <input class="inputxt" name="email" value="${user.email}"  validType="t_s_user,email,id" datatype="/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/" errormsg="邮箱格式不正确!"  ignore="ignore" />
                <span class="Validform_checktip"></span>
            </td>
		</tr>
        <tr>
            <td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.common.dev"/>: </label></td>
            <td class="value">

                <t:dictSelect id="devFlag" field="devFlag" typeGroupCode="dev_flag" hasLabel="false" defaultVal="${user.devFlag==null?'0':(user.devFlag)}" type="radio"></t:dictSelect>
                <span class="Validform_checktip"></span>
            </td>
        </tr>
	</table>
</t:formvalid>
</body>