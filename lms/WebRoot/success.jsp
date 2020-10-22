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
    <link href="css/css_default/layout.css" rel="stylesheet" type="text/css" />
    <link href="css/css_default/css.css" rel="stylesheet" type="text/css" />
    <link href="css/css_default/foot.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="maintitle">操作成功</div>
			<div>操作成功</div>
<%--		<div>页面将于<span id="m"></span>秒后跳转到主页</div>--%>
		<div><a href="javascript:history.back()">点击这里返回</a></div>
	</body>
</html>