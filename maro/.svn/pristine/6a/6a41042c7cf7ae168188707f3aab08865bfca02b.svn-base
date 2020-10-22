<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:datagrid name="departUserList" title="common.operation"
            actionUrl="departController.do?userDatagrid&departid=${departid}" fit="true" fitColumns="true" idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="common.username" sortable="false" width="100" field="userName" query="true"></t:dgCol>
	<t:dgCol title="common.real.name" field="realName" width="100" query="true"></t:dgCol>
	<t:dgCol title="common.status" sortable="true" width="50" field="status" replace="common.active_1,common.inactive_0,super.admin_-1"></t:dgCol>
	<t:dgCol title="common.operation" field="opt" width="100"></t:dgCol>
</t:datagrid>
