<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath %>" />
		<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
		<link href="css/jquery.ennui.contentslider.css" rel="stylesheet"
			type="text/css" media="screen,projection" />
	</head>
	<body>
		操作失败!原因:由于权限不足，请联系网站的管理员!
	</body>
</html>