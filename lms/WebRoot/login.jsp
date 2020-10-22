<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>用户登录</title>
	</head>

	<body>
		<%--<div id="head"></div>
		<div class="maintitle">用户登录</div>
		<div class="mainbg">
		<center>
			<form action="userAction!login.action" method="post"> 
				用户名:<input name="user.userName"/><br/>
				密&nbsp;&nbsp;码:<input name="user.password" type="password"/><br/>
				<input value="登录" type="submit"/><input type="reset">&nbsp;&nbsp;没有用户名？&nbsp;<a href="register.jsp">注册</a>
			</form>	
		</center>
		</div>
		--%>
		<center>
			<form action="userAction!login.action" method="post" name="form"> 
			<div style="width: 1000px;height: 650px;background-image: url(images/loginbg.png)">
				<table style="width: 100%;height: 100%" cellpadding="0" cellspacing="0">
					<tr height="40%">
						<td colspan="3"></td>
					</tr>
					<tr height="33%">
						<td width="32%"></td>
						<td>
							<table style="text-align: center;" width="100%" height="100%" cellpadding="0" cellspacing="0">
								<tr height="10%">
									<td colspan="3"></td>
								</tr>
								<tr height="15%">
									<td width="40%" rowspan="2" colspan="1"></td>
									<td width="45%">
										<input style="font-size:large;width: 180px;height: 28px" name="user.userName"/>
									</td>
									<td width="18%"></td>
								</tr>
								<tr height="15%">
									<td>
										<input style="font-size:large; width: 180px;height: 27px" name="user.password" type="password""/>
									</td>
									<td></td>
								</tr>
								<tr height="11%">
									<td colspan="3"></td>
								</tr>
								<tr height="15%">
									<td colspan="3" width="37%">
										<table width="100%" height="100%" cellpadding="0" cellspacing="0">
											<tr>
												<td width="57%"><a href="register.jsp" style="color: white;">注册</a></td>
												<td width="28%" onclick="document.form.submit()" style="cursor: pointer;">&nbsp;</td>
												<td width="15%"></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr height="20%">
									<td colspan="3"></td>
								</tr>
							</table>
						</td>
						<td width="28%"></td>
					</tr>
					<tr height="27%">
						<td colspan="3"></td>
					</tr>
				</table>
			</div>
			</form>
		</center>
	</body>
</html>
