<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<link href="css/css_default/css.css" rel="stylesheet"
			type="text/css" />
		<link href="css/css_default/menu.css" type="text/css"
			rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/Menu.js"></script>

	</head>

	<body>
		<ul id="Nav">
			<li>
				<a href="userAction!query.action" class="title" target="mainFrame">用户管理</a>
			</li>
			<li>
				<a href="bookTypeAction!query.action" class="title" target="mainFrame">类别管理</a>
			</li>
			<li>
				<a href="bookAction!query.action" class="title" target="mainFrame">图书管理</a>
			</li>
			
			<li ><a href="javascript:void(0)" class="title">借阅管理</a>
	   	    	<ul id="Menu">
					<li style="background-color: rgb(255, 255, 255);"><a href="borrowAction!borrowList.action" target="mainFrame" class="sub">图书借阅</a></li>
					<li style="background-color: rgb(255, 255, 255);"><a href="borrowAction!retAndReBrwList.action" target="mainFrame" class="sub">图书归还</a></li>
					<li style="background-color: rgb(255, 255, 255);"><a href="borrowAction!limitBookBRWList.action" target="mainFrame" class="sub">超期借阅情况</a></li>
		   		</ul>
			</li>
		</ul>
	</body>
</html>
