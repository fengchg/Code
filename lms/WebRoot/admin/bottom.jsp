<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="../css/css_default/foot.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form name="loginForm" method="post" action="/casv1/business/login.do">
<input type="hidden" name="actionType" value="loginoff"/>
<div id="foot">	
	<div id="right"><a href="#" target="_blank"></a>&nbsp;&nbsp;<font color="red">&nbsp;</font>&nbsp;&nbsp;图书管理系统<a href="#"></a>&nbsp;&nbsp;</div>
	<!--<div id="img"><a href="#"  target="_blank"></a></div>
--></div>
</form>

</body>
</html>
