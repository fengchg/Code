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
			action="userAction!updatePassWDbySelf.action" method="post">
			<div class="consoleLabel">修改密码</div>
			<!-- mainbg begin -->
			<div class="mainbg">
				<!-- headtitle begin -->
				<div id="headtitle">
					<!-- pagemenu begin -->
					<FONT color="red">&nbsp;&nbsp;</FONT>
				</div>
				<FIELDSET>
					<LEGEND>
						【修改密码】
					</LEGEND>
					<table id="table" cellspacing="0" cellpadding="0" align="center">
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								旧密码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="oldPass" type="password"/>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								新密码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="newPass" type="password"/>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								确认密码：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="repass" type="password"/>
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