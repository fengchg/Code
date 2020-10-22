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

	</head>
	<body>
		<form name="form" method="post" action="borrowAction!canBeBrwBookList.action">
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
								<th id='title_attn' width='20%'
									onclick="javascript:orderContent('foreignGuests','attn','asc')">
									状态
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
										可借阅
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
