<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link href="../css/css_default/foot.css" rel="stylesheet" type="text/css" />
<META Name="keywords" Content="企业人事管理系统">
    <META Name="description" Content="企业人事管理系统">
<title>企业人事管理系统</title>


</head>
<body>
<form name="loginForm" method="post" action="/casv1/business/login.do">
<input type="hidden" name="actionType" value="loginoff"/>
<div id="foot">	
	<!--<div id="left">
			<table>
				<tr>
					<td>&nbsp;&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
					<td id="tt"><font id="curNum11">&nbsp;</font></td>
				</tr>
			</table>	
				
	</div>-->
	<div id="right"><a href="#" target="_blank"></a>&nbsp;&nbsp;<font color="red">&nbsp;</font>&nbsp;&nbsp;实习管理系统<a href="#"></a>&nbsp;&nbsp;</div>
	<!--<div id="img"><a href="#"  target="_blank"></a></div>
--></div>
</form>

</body>
</html>
