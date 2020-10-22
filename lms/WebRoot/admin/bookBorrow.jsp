<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>" />
		<link rel="stylesheet" type="text/css" href="css/css_default/style.css" />
		<link href="css/css_default/css.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/global.js"></script>

		<script type="text/javascript">
	function execute(op, tip) {
		if (confirm(tip)) {
			location.href = op;
		}
	}
	function doBorrow(bookId){
		var userId = $("#userSelect").val();
		if(userId == ""){
			alert("请选择用户");
			return false;
		}
		var action = document.form.action;
		document.form.action = "borrowAction!borrow.action?borrowInfo.book.id="+bookId;
		document.form.submit();
		document.form.action = action;
	}
</script>

	</head>
	<body>
		<form name="form" method="post" action="borrowAction!borrowList.action">
			<div id="mydialog"  style="width: 95%;height: 95%; display: none;z-index: 1;position: absolute;">
				<div style="background-color:#ffffff; height:35%;width:40%;margin-left: 320px;margin-top:120px;text-align: center;border: 1px solid #F499BC;">
					<div style="height:20%; background-color: #F499BC;text-align: center;line-height:30px;font-weight: bold;font-size: 14px;color: #ffffff">选择用户</div>
					<div style="width:80%;height: 50%;text-align: center;line-height: normal; ">
						请选择用户:&nbsp;&nbsp;
						<select id="userSelect" name="borrowInfo.user.id">
							<option value = "">--请选择--</option>
							<c:forEach items="${users}" var="user">
								<option value="${user.id}">${user.userExp.realName}-${user.userExp.gender}-${user.userExp.address}-${user.userExp.code}</option>
							</c:forEach>
						</select>
					</div>
					<div style="text-align: center;">
						<input type="button" value="确定" onclick="var name=$('#userSelect').find('option:selected').text();$('#userlink').text(name);$('#mydialog').fadeOut('slow');"/>
						<input type="button" value="取消" onclick="$('#mydialog').fadeOut('slow');"/>
					</div>
				</div>
			</div>
			<div class="consoleLabel">可借阅列表</div>
			<div class="mainbg">
				<div id="headtitle">
					<div id="pagemenu">
						<ul>
							<li>
								<a href="javascript:document.form.submit()">查 询</a>
							</li>
						</ul>
					</div>
				</div>
				<div id="listContent">
					<div>
						<FIELDSET>
							<LEGEND>
								搜索条件
							</LEGEND>
							<table id="table" cellspacing="0" cellpadding="0" align="center">
								<tr>
									<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
										书名：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input name="borrowInfo.book.bookName" value="${borrowInfo.book.bookName }" />
									</td>
									<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
										编号：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input name="borrowInfo.book.code" value="${borrowInfo.book.code}" />
									</td>
								</tr>
							</table>
						</FIELDSET>
					</div>
					<TABLE cellSpacing="0" cellPadding="0" id="table" align="center"
						border="0">
						<TBODY>
							<tr class=''>
								<th id='title_title' width='13%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									分类
								</th>
								<th id='title_title' width='13%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									编号
								</th>
								<th id='title_title' width='13%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									书名
								</th>
								<th id='title_title' width='13%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									作者
								</th>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									出版时间
								</th>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									选择用户
								</th>
								<th id='title_attn' width='20%'
									onclick="javascript:orderContent('foreignGuests','attn','asc')">
									操作
								</th>
							</tr>
							<c:forEach items="${books}" var="book" varStatus="st">
								<tr class='a9t' onMouseOver="this.className='a9t-center'"
									onMouseOut="this.className='a9t'">
									<td style="text-align: center">
										<c:out value="${book.bookType.name}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${book.code}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${book.bookName}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${book.author}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${book.publishDate_date}"></c:out>
									</td>
									<td style="text-align: center">
										<a href="javascript:void(0)" onclick="$('#mydialog').fadeIn('slow');" id="userlink">--请选择--</a>
									</td>
									<td style="text-align: center">
										<a href="javascript:void(0)"
											class="list_link" onclick="if(confirm('确定要借阅吗?')){doBorrow(${book.id})}">借阅</a>&nbsp;
									</td>
								</tr>
							</c:forEach>
						</TBODY>
					</TABLE>
				</div>
				<%@include file="/page.jsp"%>
			</div>
		</form>
	</body>
</html>
