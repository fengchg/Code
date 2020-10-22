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
				<a href="userAction!viewBySelf.action" class="title" target="mainFrame">个人信息</a>
			</li>
			<li>
				<a href="user/updatePassword.jsp" class="title" target="mainFrame">修改密码</a>
			</li>
			<li>
				<a href="borrowAction!canBeBrwBookList.action" class="title" target="mainFrame">可借阅图书列表</a>
			</li>
			<li>
				<a href="userAction!myBookBorrowInfo.action" class="title" target="mainFrame">借阅查看</a>
			</li>
		</ul>
	</body>
</html>
