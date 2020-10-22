<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input name="${param.name}" value="${param.value}" type="hidden">
<div style="float: left">
	<c:forTokens items="${param.value}" delims=";" var="item">
		<div style="float: left;padding-right: 8px">
			<div imagePath='<c:out value="${item}"/>' style="background-image: url('<c:out value="${item}"/>');background-size:100% 100%;width:60px;height:60px">
				<div style="float: right">
					<span style="font-size: 20px;background-color: #919A9E;cursor: pointer;" onclick="myremovemulti(this<c:if test="${param.multiple != 'multiple'}">,true</c:if>)">&nbsp;×&nbsp;</span>
				</div>
			</div>
			<div style="background-color:red;height:2px;width: 60px;"></div>
		</div>
	</c:forTokens>
</div>
<div style="float: left;line-height: 60px">
	<input type="file" onchange="myuploadmulti(this<c:if test="${param.multiple != 'multiple'}">,true</c:if>)" style="display:none" <c:if test="${param.multiple == 'multiple'}">multiple="multiple"</c:if> accept="image/gif,image/jpeg,image/png,image/jpg,image/bmp"/>
	<c:choose>
		<c:when test="${(param.multiple != 'multiple')&&(fn:length(param.value)>0)}">
			<a class="easyui-linkbutton" iconCls="icon-search" data-options="disabled:true" onclick="$(this).parent().find('input[type=\'file\']').trigger('click')">浏览</a>
		</c:when>
		<c:otherwise>
			<a class="easyui-linkbutton" iconCls="icon-search" onclick="$(this).parent().find('input[type=\'file\']').trigger('click')">浏览</a>
		</c:otherwise>
	</c:choose>
</div>
