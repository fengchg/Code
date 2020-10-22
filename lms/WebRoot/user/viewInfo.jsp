<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	</head>
	<body>
		<form name="form" id="personalForm" theme="simple"
			action="userAction!updateUserInfoBySelf.action" method="post">
			<input type="hidden" value="${user.id}" name="user.id">
			<div class="consoleLabel">个人信息</div>
			<!-- mainbg begin -->
			<div class="mainbg">
				<!-- headtitle begin -->
				<div id="headtitle">
					<!-- pagemenu begin -->
					<FONT color="red">&nbsp;&nbsp;</FONT>
				</div>
				<FIELDSET>
					<LEGEND>
						个人信息
					</LEGEND>
					<table id="table" cellspacing="0" cellpadding="0" align="center">
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								用户名：
							</td>
							<td class='list' colspan=3 rowspan=1>
								${user.userName}
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								真实姓名：
							</td>
							<td class='list' colspan=3 rowspan=1>
								${user.userExp.realName}
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								性别：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="gender" type="radio" value="男" readonly="readonly" <c:if test="${user.userExp.gender=='男'}">checked="checked"</c:if> />男
								<input name="gender" type="radio" value="女" readonly="readonly" <c:if test="${user.userExp.gender=='女'}">checked="checked"</c:if> />女
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								年龄：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<select name="user.userExp.age">
									<option value="">--请选择--</option>
									<c:forEach begin="10" end="99" step="1" varStatus="s">
										<option value="${s.index}" <c:if test="${s.index == user.userExp.age}">selected</c:if> >${s.index}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								身份证号码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								${user.userExp.code}
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								家庭住址：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userExp.address" value="${user.userExp.address}"/>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								电话号码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userExp.phoneNumber" value="${user.userExp.phoneNumber}" />
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								邮箱：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="user.userExp.email" value="${user.userExp.email}" />
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								个人备注：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<textarea cols="80" rows="5" name="user.userExp.remark">${user.userExp.remark}</textarea>
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
								<a href="javascript:document.form.submit()">修改</a>
							</li>
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