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
		
	<script type="text/javascript">
		function execute(op,tip){
			if(confirm(tip)){
				location.href=op;	
			}
		}
	</script>
			
	</head>
	<body>
		<form name="form" method="post" action="userAction!query.action">
			<!-- 操作值为1，代表登录 -->
			<input name="operate" type="hidden" value="2"/>
			<div class="consoleLabel">用户列表</div>
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
										用户名：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<input name="user.userName" value="<c:out value='${user.userName }'/>"/>
									</td>
									<td class='tdrowhead' colspan=1 rowspan=1 width='15%'>
										性别：
									</td>
									<td class='list' colspan=3 rowspan=1>
										<select name="user.userExp.gender">
											<option value="">--请选择--</option>
											<option value="男" <c:if test="${user.userExp.gender == '男' }">selected</c:if> >男</option>
											<option value="女"  <c:if test="${user.userExp.gender == '女' }">selected</c:if> >女</option>
										</select>
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
									用户名
								</th>
								<th id='title_attn' width='16%'
									onclick="javascript:orderContent('foreignGuests','attn','asc')">
									住址
								</th>
								<th id='title_attn' width='16%'
									onclick="javascript:orderContent('foreignGuests','attn','asc')">
									性别
								</th>
								<th id='title_attn' width='16%'
									onclick="javascript:orderContent('foreignGuests','attn','asc')">
									身份证号码
								</th>
								<th id='title_attn' width='20%'
									onclick="javascript:orderContent('foreignGuests','attn','asc')">
									操作
								</th>
								<th id='title_attn' width='20%'
									onclick="javascript:orderContent('foreignGuests','attn','asc')">
									状态
								</th>
							</tr>
							<c:forEach items="${users }" var="user" varStatus="st">
								<tr class='a9t' onMouseOver="this.className='a9t-center'" onMouseOut="this.className='a9t'">
									<td style="text-align: center">
										<c:out value="${user.userName}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${user.userExp.address}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${user.userExp.gender}"></c:out>
									</td>
									<td style="text-align: center">
										<c:out value="${user.userExp.code}"></c:out>
									</td>
									<td style="text-align: center;">
										<font color='<c:if test="${user.status==1 }">red</c:if>'>
											<c:out value="${user.statusDescription}"></c:out>
										</font>
									</td>
									<td style="text-align: center">
										<c:choose>
											<c:when test="${user.status == 0}">
												<a href="javascript:execute('userAction!disEnable.action?user.id=${user.id}','确定要停用吗?')" class="list_link">停用</a>&nbsp;
											</c:when>
											<c:otherwise>
												<a href="javascript:execute('userAction!enable.action?user.id=${user.id}','确定要启用吗?')" class="list_link">启用</a>&nbsp;
											</c:otherwise>
										</c:choose>
										<a href="javascript:execute('userAction!delete.action?user.id=${user.id}','确定要删除吗?')" class="list_link">删除</a>&nbsp;
										<a href="userAction!view.action?user.id=${user.id}" class="list_link">查看</a>&nbsp;
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
