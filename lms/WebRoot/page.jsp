<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="bottitle">
	<input type="hidden" id="rowNum" name="page.rowNum"
		value="${page.rowNum}" />
	<input type="hidden" id="totalPages" name="page.totalPages"
		value="${page.totalPages}" />
	<input type="hidden" id="currentPage" name="page.currentPage"
		value="${page.currentPage}" />
	<!--如果没有记录，则提示没有记录-->
	<TABLE id="table" border="0" cellSpacing="0" cellPadding="0">
		<TR>
			<TD width="50%" class="tdlistcontent" valign="middle">
				共
				<c:out value="${page.totalPages }" />
				页 每页
				<SELECT id="rowNumSel" onchange="javascript:query('selectRowNum')">
					<option id="five" value="5">
						5
					</option>
					<option id="ten" value="10">
						10
					</option>
					<option id="twenty" value="20">
						20
					</option>
				</SELECT>
				条
			</TD>
			<td class="tdlistcontent" id="left_border" width="50%" align="right"
				valign="middle">
				<div class="go"></div>
				<div class="viciao">
					<a href='javascript:query("first")' class='other'>首页</a>
					<a href='javascript:query("pre")' class='other'>上一页</a>
					<a href='javascript:query("next")' class='other'>下一页</a>
					<a href='javascript:query("last")' class='other'>末页</a>
				</div>
			</td>
		</TR>
	</TABLE>
</div>
