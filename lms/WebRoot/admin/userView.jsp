<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>" />
		<link rel="stylesheet" type="text/css" href="css/css_default/style.css" />
		<link href="css/css_default/css.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<form name="personalForm" id="personalForm" theme="simple" method="post">
			<div class="consoleLabel">用户信息详情</div>
			<!-- mainbg begin -->
			<div class="mainbg">
				<!-- headtitle begin -->
				<div id="headtitle">
					<!-- pagemenu begin -->
					<FONT color="red">&nbsp;&nbsp;</FONT>
				</div>
				<FIELDSET>
					<LEGEND>
						【用户信息详情】
					</LEGEND>
					<table id="table" cellspacing="0" cellpadding="0" align="center">
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								用户名：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<c:out value="${user.userName}"></c:out>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								性别：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<c:out value="${user.userExp.gender }"></c:out>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								年龄：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<c:out value="${user.userExp.age}"></c:out>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								住址：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<c:out value="${user.userExp.address}"></c:out>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								电话号码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<c:out value="${user.userExp.phoneNumber}"></c:out>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								身份证号码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<c:out value="${user.userExp.code}"></c:out>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								邮箱：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<c:out value="${user.userExp.email}"></c:out>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								备注：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<c:out value="${user.userExp.remark}"></c:out>
							</td>
						</tr>
					</table>
				</FIELDSET>
				<!-- headtitle begin -->
				<div id="headtitle">
					<!-- pagemenu begin -->
					<div class="footer">
						<ul class="footer_1">
							<li>
								<a href="javascript:history.back()">返回</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>