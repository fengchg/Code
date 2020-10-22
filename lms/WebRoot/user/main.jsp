<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=GBK">
    <link rel="shortcut icon" href="../css_default/img/favicon.ico">
	<title>图书管理系统</title>
</head>

	<frameset id="all" rows="105,*" cols="*" frameborder="NO" border="0" framespacing="0">
	
		<frame src="user/top.jsp" name="topFrame" scrolling="NO" noresize/>			
		
		<frameset rows="*" cols="140,*" id="content" framespacing="0" frameborder="NO" border="0">
			<frame src="user/left.jsp" name="leftFrame" scrolling="no" noresize="noresize" /> 	  
		    <frame src="user/viewInfo.jsp" name="mainFrame" scrolling="no" noresize="noresize"/>		   
	  	</frameset>
	  	
	</frameset>
<body >
</body>
</html>
