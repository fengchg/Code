<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<title></title>
		<base href="<%=basePath%>" />
		<link rel="stylesheet" type="text/css"
			href="css/css_default/style.css" />
	</head>
	<body style="margin: 0">
		<table width="100%" height="101" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="100%" class="TopHead">
					<table width="100%" height="100" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td width="590"></td>
							<td width="300px">
								<table width="300px" border="0" cellpadding="0" cellspacing="0"
									class="TopBottomText">
									<tr>
										<td align="right" style="padding-right: 10px">
											<img src="css/css_default/img/dian.gif" />
										</td>
										<td width="270px">
											欢迎您：${user.userName}&nbsp;&nbsp; [
											<a href="userAction!exit.action" target="_parent"
												style="color: #666666">退出</a>]
										</td>
									</tr>
									<tr>
										<td colspan="2" style="padding-left: 77px; padding-top: 10px">
											<ws:property
												value="@org.hi.framework.security.context.UserContextHelper@getOrgName()" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<div style="background-color: #ffffff; height: 3px; font-size: 1px"></div>
	</body>
</html>