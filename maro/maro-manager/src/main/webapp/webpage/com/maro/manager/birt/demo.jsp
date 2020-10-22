<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="height:93%;">
<head>
	<title>测试报表</title>
	<t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<script>
        <!-- 设置默认时间为当前时间 -->
        $(document).ready(function(){
            $("#begintime").val(getCurrentMonthFirst().pattern("yyyyMMdd"));
            $("#endtime").val(new Date().pattern("yyyyMMdd"));
            initPage();
        });
        function initPage()
        {
            var vifrmBirt = document.getElementById("ifrmBirt");
            vifrmBirt.src='frameset?__report=${code}.rptdesign&shopId=${shopId}&s='+$("#begintime").val()+'&e='+$("#endtime").val();
        }
        //当前月的第一天
        function getCurrentMonthFirst(){
            var date=new Date();
            date.setDate(1);
            return date;
        }
	</script>
	<style>
		td{font-size:12px;}
	</style>
</head>
<body style="height:100%;">
<table width="100%" style="height:100%;">
	<tr>
		<td height="30" align="center">
			<table align="left"><tr>
				<td width="80" align="right">时间：</td><td width="210"><input type="text" name="begintime" id="begintime" style="width: 150px; height: 24px;" class="Wdate" onFocus="WdatePicker({maxDate:new Date(),dateFmt:'yyyyMMdd',autoPickDate:true,readOnly:true})"> 零时</td>
				<td width="80">  至  </td><td width="210"><input type="text" name="endtime" id="endtime" style="width: 150px; height: 24px;" class="Wdate" onFocus="WdatePicker({maxDate:new Date(),dateFmt:'yyyyMMdd',autoPickDate:true,readOnly:true})"> 零时</td>
				<td width="50" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="initPage()">查询</a></td>
			</tr></table>
		</td>
	</tr>
	<tr>
		<td style="height : 100%" align="left" >
			<iframe id="ifrmBirt" frameborder="0" height="100%" width="100%" scrolling="no" marginheight="0" marginwidth="0" src=""></iframe>
		</td>
	</tr>
</table>
</body>
</html>