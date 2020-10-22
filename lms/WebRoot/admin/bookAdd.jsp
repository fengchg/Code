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
	</head>
	<body>
		<form name="form" id="personalForm" theme="simple"
			action="bookAction!add.action" method="post">
			<div class="consoleLabel">新增图书</div>
			<!-- mainbg begin -->
			<div class="mainbg">
				<!-- headtitle begin -->
				<div id="headtitle">
					<!-- pagemenu begin -->
					<FONT color="red">&nbsp;&nbsp;</FONT>
				</div>
				<FIELDSET>
					<LEGEND>
						【新增图书】
					</LEGEND>
					<table id="table" cellspacing="0" cellpadding="0" align="center">
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								图书分类：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<select name="book.bookType.id">
									<c:forEach items="${bookTypes}" var="bookType">
										<option value="${bookType.id }">
											${bookType.name}
										</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								书名：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.bookName" />
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								作者名：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.author" />
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								出版日期：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input id="datepicker" name="book.publishDate_date" readonly="readonly" />
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								编号：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.code" />
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								出版社：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.publisher" />
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								总页数：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<input name="book.pageNum" />
							</td>
						</tr>
						<tr>
							<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
								备注：
							</td>
							<td class='list' colspan=3 rowspan=1>
								<textarea cols="80" rows="5" name="book.remark"></textarea>
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