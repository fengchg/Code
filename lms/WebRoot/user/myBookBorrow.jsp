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
</script>

	</head>
	<body>
		<form name="form" method="post" action="userAction!myBookBorrowInfo.action">
			<!-- 操作值为1，代表登录 -->
			<div class="consoleLabel">个人历史借阅情况列表</div>
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
										<input name="bookName" value="${bookName }" />
									</td>
									<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
										编号：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input name="code" value="${code}" />
									</td>
								</tr>
							</table>
						</FIELDSET>
					</div>
					<TABLE cellSpacing="0" cellPadding="0" id="table" align="center"
						border="0">
						<TBODY>
							<tr class=''>
								<th id='title_title' width='10%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									书名
								</th>
								<th id='title_title' width='8%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									作者
								</th>
								<th id='title_title' width='13%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									编号
								</th>
								<th id='title_title' width='10%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									借阅用户
								</th>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									借阅时间
								</th>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									规定归还时间
								</th>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									实际归还时间
								</th>
								<th id='title_title' width='10%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									超出天数
								</th>
							</tr>
							<c:forEach items="${borrowInfos}" var="bean" varStatus="st">
								<tr class='a9t' onMouseOver="this.className='a9t-center'"
									onMouseOut="this.className='a9t'">
									<td style="text-align: center">
										<c:out value="${bean.book.bookName}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${bean.book.author}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${bean.book.code}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${bean.user.userExp.realName}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${bean.borrowTime}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${bean.setReturnTime}"></c:out>
									</td>
									<td style="text-align: center">
										<c:choose>
											<c:when test="${bean.returnTime != null}">
												<c:out value="${bean.returnTime}"></c:out>
											</c:when>
											<c:otherwise>--</c:otherwise>
										</c:choose>
									</td>
									<td style="text-align: center">
										<c:if test="${bean.outLimitDays > 0}">
											<font color="#ff0000">
												<c:out value="${bean.outLimitDays}"></c:out>
											</font>
										</c:if>
										<c:if test="${bean.outLimitDays == 0}">
											<c:out value="--"></c:out>
										</c:if>
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
