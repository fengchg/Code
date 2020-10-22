<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,ztree"></t:base>
<head>
    <title>服务订单详情</title>
</head>
<body >
<t:formvalid formid="formobj" layout="div" dialog="true" styleClass="scroll='overflow-y:auto'">
    <input id="id" name="id" type="hidden" value="${depart.id }">
    <fieldset class="step">
        <div class="form">
            <label class="Validform_label"> 服务订单号: </label>
                ${maroClientServerorderDTO.maroClientServerorderVO.code}
        </div>
        <div class="form">
            <label class="Validform_label"> 所属店铺: </label>
                ${maroClientServerorderDTO.maroClientServerorderVO.restaurantName}
        </div>
        <div class="form">
            <label class="Validform_label"> 座位号: </label>
                ${maroClientServerorderDTO.maroClientServerorderVO.seatName}
        </div>
        <div class="form">
            <label class="Validform_label"> 订单金额: </label>
                ${maroClientServerorderDTO.maroClientServerorderVO.amount}
        </div>
        <div class="form">
            <label class="Validform_label">用餐人数: </label>
                ${maroClientServerorderDTO.maroClientServerorderVO.personNumber}
        </div>
        <div class="form">
            <label class="Validform_label"> 服务员: </label>
                ${maroClientServerorderDTO.maroClientServerorderVO.waiterName}
        </div>
        <div class="form">
            <table width="100%">
                <caption style="text-align: left;font-weight: bold;font-size: 14px">点餐记录</caption>
                <thead>
                <tr>
                    <td>菜名</td>
                    <td>数量</td>
                    <td>单价</td>
                    <td>折扣</td>
                    <td>总价</td>
                    <td>状态</td>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="bean" items="${maroClientServerorderDTO.maroClientFoodOrderVOs}">
                    <tr>
                        <td>${bean.foodName}</td>
                        <td>${bean.quantity}(${bean.unitName})</td>
                        <td>${bean.price}</td>
                        <td>${bean.discount}</td>
                        <td>${bean.totalPrice}</td>
                        <td>${bean.statusString}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="form">
            <table width="100%">
                <caption style="text-align: left;font-weight: bold;font-size: 14px">桌位更换记录</caption>
                <thead>
                <tr>
                    <td>源桌位</td>
                    <td>操作</td>
                    <td>目标桌位</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="bean" items="${maroClientServerorderDTO.maroClientSeatchangeVOs}">
                    <tr>
                        <td>${bean.srcSeatName}</td>
                        <td>${bean.typeString}</td>
                        <td>${bean.destSeatName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="form">
            <table width="100%">
                <caption style="text-align: left;font-weight: bold;font-size: 14px">服务订单日志记录</caption>
                <thead>
                <tr>
                    <td>时间</td>
                    <td>类型</td>
                    <td>说明</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="bean" items="${maroClientServerorderDTO.maroClientServerorderlogVOs}">
                    <tr>
                        <td>${bean.happenTimeString}</td>
                        <td>${bean.typeString}</td>
                        <td>${bean.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="form">
            <table width="100%">
                <caption style="text-align: left;font-weight: bold;font-size: 14px">支付记录</caption>
                <thead>
                <tr>
                    <td>时间</td>
                    <td>支付类型</td>
                    <td>支付终端</td>
                    <td>支付金额</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="bean" items="${maroClientServerorderDTO.maroClientPayedVOs}">
                    <tr>
                        <td>${bean.payTimeString}</td>
                        <td>${bean.payTypeString}</td>
                        <td>${bean.payTerminalString}</td>
                        <td>${bean.amount}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </fieldset>
</t:formvalid>


</body>
</html>