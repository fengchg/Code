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
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/global.js"></script>
	</head>
	<body>
		<form name="form" method="post" action="bookTypeAction!query.action">
			<div class="consoleLabel">图书类别列表</div>
			<div class="mainbg">
				<div id="headtitle">
					<div id="pagemenu">
						<ul>
							<li>
								<a href="admin/bookTypeAdd.jsp">新增</a>
							</li>
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
										类型名：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input name="bookType.name" value="<c:out value='${bookType.name }'/>"/>
									</td>
								</tr>
							</table>
						</FIELDSET>
					</div>
					<TABLE cellSpacing="0" cellPadding="0" id="table" align="center" border="0">
						<TBODY>
							<tr class=''>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									类型名
								</th>
								<th id='title_attn' width='16%'
									onclick="javascript:orderContent('foreignGuests','attn','asc')">
									备注
								</th>
								<th id='title_attn' width='20%'
									onclick="javascript:orderContent('foreignGuests','attn','asc')">
									操作
								</th>
							</tr>
							<c:forEach items="${bookTypes }" var="bookType" varStatus="st">
								<tr class='a9t' onMouseOver="this.className='a9t-center'" onMouseOut="this.className='a9t'">
									<td style="text-align: center">
										<c:out value="${bookType.name}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${bookType.remark}"></c:out>
									</td>
									<td style="text-align: center">
										<a href="bookTypeAction!view.action?bookType.id=${bookType.id}" class="list_link">查看</a>&nbsp;
										<a href="bookTypeAction!updateForInput.action?bookType.id=${bookType.id}" class="list_link">修改</a>&nbsp;
										<a href="javascript:if(confirm('确定要删除吗?')){location.href='bookTypeAction!delete.action?bookType.id=${bookType.id}'}" class="list_link">删除</a>&nbsp;
									</td>
								</tr>
							</c:forEach>
						</TBODY>
					</TABLE>
				</div>
				<%@include file="/page.jsp" %>
			</div>
		</form>
	</body>
</html>
