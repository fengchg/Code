<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	</head>
	<body>
		<form name="form" id="personalForm" theme="simple" action="bookAction!update.action" method="post">
			<input type="hidden" name="book.id" value="${book.id}"/>
			<div class="consoleLabel">修改图书</div>
			<!-- mainbg begin -->
			<div class="mainbg">
				<!-- headtitle begin -->
				<div id="headtitle">
					<!-- pagemenu begin -->
					<FONT color="red">&nbsp;&nbsp;</FONT>
				</div>
				<FIELDSET>
					<LEGEND>
						【修改图书】
					</LEGEND>
					<table id="table" cellspacing="0" cellpadding="0" align="center">
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								图书分类：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<select name="book.bookType.id">
									<option value="">--请选择--</option>
									<c:forEach items="${bookTypes }" var="bt">
										<option value="${bt.id }" <c:if test="${book.bookType.id == bt.id}">selected</c:if> >${bt.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								书名：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.bookName" value="${book.bookName }"/>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								作者名：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.author" value="${book.author}"/>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								出版时间：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.publishDate_date" value="${book.publishDate_str}"/>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								编号：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.code" value="${book.code}"/>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								出版社：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.publisher" value="${book.publisher}"/>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								总页数：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.pageNum" value="${book.pageNum}"/>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								备注：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<textarea cols="80" rows="5" name="book.remark">${book.remark}</textarea>
							</td>
						</tr>
					</table>
				</FIELDSET>
				<!-- headtitle begin -->
				<div id="headtitle">
					<!-- pagemenu begin -->
					<div class="footer">
						<ul class="footer_1">
							<li>
								<a href="javascript:document.form.submit()">保 存 </a>
							</li>
							<li>
								<a href="javascript:history.back()">返回</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>