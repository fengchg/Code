<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/cmTag" prefix="cm"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!-- HEAD区域-->
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<TITLE></TITLE>

	<!-- CSS引用区域-->
	<link href="css/css_default/css.css" rel="stylesheet" type="text/css" />
	<!-- JAVASCRIPT 区域 -->

</head>
<body>

<!-- Form表单和隐含元素 -->
<form name="foreignGuestsForm" method="post" action="/casv1/business/foreignGuests/foreignGuests.do">
<div class="maintitle">
	出国访问列表
</div>
	<div class="mainbg">
		<div id="headtitle">
			<div id="pagemenu">
				<ul>
				
					<li><a href="javascript:submitForm('add')">新 增</a></li>
					<li><a href="javascript:submitForm('remove')">删 除</a></li>
					<li><a href="javascript:checkListAdd('foreignGuests')">审 核</a></li>
					<li><a href="javascript:submitForm('popSearch')">查 询</a></li>
					<li><a href="javascript:submitForm('popExport')">导 出</a></li>
					
				</ul>	
			</div>
		</div>
	</div>
<div id="listContent">
<span class="bottom_left">
<span class="ListMiddleText"></span>   
</span>
	<TABLE cellSpacing="0" cellPadding="0" id="table" align="center" border="0">
	    <TBODY>
<tr class=''>
	<th width='5%' ><a href='javascript:checkAll()' >全选</a></th>
	<th id='title_title' width='21%' >用户名</th>
	<th id='title_attn' width='21%' >密码</th>
	<th id='title_purposeVisit' width='21%' >邮件</th>
	<TH id='title_checkStatusId' width='21%' >注册日期</TH>
	<TH width='12%' >操作</TH>
</tr>
</TBODY>
	</TABLE>
</div>
  <div id="bottitle">


<!--如果没有记录，则提示没有记录-->

</div>

</form>
</body>
</html>
