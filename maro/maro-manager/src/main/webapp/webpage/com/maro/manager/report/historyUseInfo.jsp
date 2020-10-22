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
<div id="main" style="width: 800px;height:600px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    option = {
        title: {
            text: '原料消耗采购一览表',
            left:"center"
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#283b56'
                }
            }
        },
        toolbox: {
            show: true,
            feature: {
                dataView: {readOnly: false},
                restore: {},
                saveAsImage: {}
            }
        },
        dataZoom: {
            show: false,
            start: 0,
            end: 100
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: true,
                data:[<c:forEach items='${names}' varStatus='status' var='item' >"${item}"<c:if test='${!status.last}'>,</c:if></c:forEach>]
                /*data:["原料1","原料2","原料3"]*/
            },
            {
                type: 'category',
                boundaryGap: true,
                data:[<c:forEach items='${planNumbers}' varStatus='status' var='item' >${item}<c:if test='${!status.last}'>,</c:if></c:forEach>]
                /*data: [2,5,10]*/
            }
        ],
        yAxis: [
            {
                type: 'value',
                scale: true,
                name: '',
                max: ${max},
                min: 0,
                boundaryGap: [0.2, 0.2]
            },
            {
                type: 'value',
                scale: true,
                name: '',
                max: ${max},
                min: 0,
                boundaryGap: [0.2, 0.2]
            }
        ],
        series: [
            {
                name:'平均消耗',
                type:'bar',
                xAxisIndex: 1,
                yAxisIndex: 1,
                data:[<c:forEach items='${planNumbers}' varStatus='status' var='item' >${item}<c:if test='${!status.last}'>,</c:if></c:forEach>]
                /*data:[2,5,10]*/
            },
            {
                name:'预计采购',
                type:'line',
                data:[<c:forEach items='${useNumbers}' varStatus='status' var='item' >${item}<c:if test='${!status.last}'>,</c:if></c:forEach>]
                /*data:[2.5,4,9]*/
            }
        ]
    };
    myChart.setOption(option);
</script>
</body>
</html>
