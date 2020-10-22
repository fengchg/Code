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
		<link rel="stylesheet" href="jquery_themes/base/jquery.ui.all.css"
			type="text/css" />
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/global.js"></script>
		<script src="jquery_ui/jquery.ui.core.js" type="text/javascript"></script>
		<script src="jquery_ui/jquery.ui.widget.js" type="text/javascript"></script>
		<script src="jquery_ui/jquery.ui.datepicker.js" type="text/javascript"></script>
		<script src="jquery_ui/i18n/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
		<script type="text/javascript" type="text/javascript">
			$(document).ready(function() {
				$.datepicker.regional['zh-CN'] = {  
					dateFormat : 'yy-mm-dd', //日期格式  
					showAnim : 'fadeIn', //显示效果 slide |  scale | fadeIn  
					showButtonPanel : true, //显示按钮面板  
					currentText : '今天',
					closeText : '完成',
					closeText:'关闭',
					prevText:'前一月',
					nextText:'后一月', 
					dayNamesMin : [ '日', '一', '二', '三', '四', '五', '六' ],
					monthNames : [ '1月', '2月', '3月', '4月', '5月', '6月',
							'7月', '8月', '9月', '10月', '11月', '12月' ]
				};
				$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
				$("#datepicker").datepicker({changeYear:true});
			});
		</script>

		<script type="text/javascript">
			function execute(op, tip) {
				if (confirm(tip)) {
					location.href = op;
				}
			}
		</script>

	</head>
	<body>
		<form name="form" method="post" action="bookAction!query.action">
			<div class="consoleLabel">图书列表</div>
			<div class="mainbg">
				<div id="headtitle">
					<div id="pagemenu">
						<ul>
							<li>
								<a href="bookAction!addForInput.action">新增</a>
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
										图书分类：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<select name="book.bookType.id">
											<option value="0">
												--请选择--
											</option>
											<c:forEach items="${bookTypes }" var="bookType">
												<option value="${bookType.id }" <c:if test="${bookType.id==book.bookType.id}">selected</c:if>>
													${bookType.name}
												</option>
											</c:forEach>
										</select>
									</td>
									<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
										书名：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input name="book.bookName" value="${book.bookName }" />
									</td>
								</tr>
								<tr>
									<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
										作者名：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input name="book.author" value="${book.author}" />
									</td>
									<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
										出版时间：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input id="datepicker" name="book.publishDate_date" value="${book.publishDate_date}" readonly="readonly" />
									</td>
								</tr>
								<tr>
									<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
										编号：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input name="book.code" value="${book.code}" />
									</td>
									<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
										出版社：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input name="book.publisher" value="${book.publisher}" />
									</td>
								</tr>
							</table>
						</FIELDSET>
					</div>
					<TABLE cellSpacing="0" cellPadding="0" id="table" align="center"
						border="0">
						<TBODY>
							<tr class=''>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									分类
								</th>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									书名
								</th>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									作者
								</th>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									出版时间
								</th>
								<th id='title_title' width='16%'
									onclick="javascript:orderContent('foreignGuests','title','asc')">
									出版社
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
										<c:out value="${book.bookName}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${book.author}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${book.publishDate_date}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${book.publisher}"></c:out>
									</td>
									<td style="text-align: center">
										<a href="bookAction!view.action?book.id=${book.id}"
											class="list_link">查看</a>&nbsp;
										<a href="bookAction!updateForInput.action?book.id=${book.id}"
											class="list_link">修改</a>&nbsp;
										<a
											href="javascript:if(confirm('确定要删除吗?')){location.href='bookAction!delete.action?book.id=${book.id}'}"
											class="list_link">删除</a>&nbsp;
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
