<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>MyEclipse Sample Report Access Webpage</title>
    <script src = "webpage/com/maro/manager/common/js/echarts.min.js"></script>
</head>

<body style="text-align: center">

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div style="width: 100%;height:100%;">
    <div id="main" style="width: 100%;height:95%;"></div>
    <form action="reportController.do?materialUseInfo" method="post">
        <label>选择日期：</label><input id="startTime" name="startTime" type="date" value="${startTime}"/><label>~</label><input id="endTime" name="endTime" type="date" value="${endTime}"/><input style="margin-left: 20px" type="submit" value="查询"/>
    </form>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    option = {
        title : {
            text: '原料消耗一览',
            left:"center"
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['实际消耗','预计消耗'],
            top:30
        },
        toolbox: {
            show : true,
            feature : {
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data:[<c:forEach items='${result}' varStatus='status' var='item' ><c:if test='${item.threshold}'>{
                    value: '${item.name}',
                    textStyle: {
                        fontSize: 20,
                        color: 'red'
                    }}</c:if><c:if test='${!item.threshold}'>"${item.name}"</c:if><c:if test='${!status.last}'>,</c:if></c:forEach>]
                /*data : [{
                    value: '周一',
                    textStyle: {
                        fontSize: 20,
                        color: 'red'
                    }},'2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']*/
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'实际消耗',
                type:'bar',
                itemStyle: {normal: {color:'blue'}},
                data:[<c:forEach items='${result}' varStatus='status' var='item' >"${item.realnum}"<c:if test='${!status.last}'>,</c:if></c:forEach>]
                /*data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]*/
            },
            {
                name:'预计消耗',
                type:'bar',
                itemStyle: {normal: {color:'green'}},
                data:[<c:forEach items='${result}' varStatus='status' var='item' >"${item.plannum}"<c:if test='${!status.last}'>,</c:if></c:forEach>]
                /*data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]*/
            }
        ]
    };
    myChart.setOption(option);

    function materialUseInfo() {
        var  startTime=$("#startTime").val();
        var  endTime=$("#endTime").val();
        alert(startTime +"   "+endTime);
    }
</script>
</body>
</html>
