<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath %>" />
		<title>错误页-网站出故障</title>
		<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
		<link href="css/jquery.ennui.contentslider.css" rel="stylesheet" type="text/css" media="screen,projection" />
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript">
			var m = 5;
			var interVal;
			$(document).ready(function(){
				interVal = setInterval("doMinusMillis()",1000);
			});
			function doMinusMillis(){
				if(m != 0){
					var millis = $("#millis");
					m--;
					millis.text(m);
				}else{
					clearInterval(interVal);
					location.href="login.jsp";
				}
			}
		</script>
	</head>
	<body>
		<div style="text-align:center;">
			<div style="text-align:center;font-weight: bold;color: red;">${tip }</div>
			<div style="text-align:center;">页面将在<span id="millis">5</span>秒后返回,您也可以点击<a href="login.jsp">登录页面</a>进行返回</div>
		</div>
	</body>
</html>