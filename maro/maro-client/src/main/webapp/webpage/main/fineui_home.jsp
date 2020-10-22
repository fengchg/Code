<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--360浏览器优先以webkit内核解析-->
    <title>船舶运行管控中心</title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="plug-in-ui/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/animate.css" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/style.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="plug-in/themes/fineui/main/iconfont.css">
	
	<script src="plug-in/jquery/jquery-1.8.3.min.js"></script>
	<script src="plug-in/JShare/highcharts.js"></script>
	<script language="JavaScript"> 
		
		var url = '<%=basePath%>';
	
		//应收金额
		var receivable_amount = [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 516.4, 194.1, 95.6, 54.4,49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 516.4, 194.1, 95.6, 54.4];
		//实收金额
		var collected_amount = [23.9, 62.5, 106.4, 129.2, 144.0, 136.0, 135.6, 148.5, 356.4, 194.1, 55.6, 54.4,49.9, 21.5, 66.4, 129.2, 144.0, 16.0, 135.6, 148.5, 256.4, 194.1, 95.6, 54.4];
		
		//应收金额
		//var receivable_amount;
		//实收金额
		//var collected_amount;
		
		$(document).ready(function() {
			
			//alert(url);
			/*$.post(url+"/maroSetmealController.do?getStatisticalTurnover",{},function(result){
				//console.info(result);
				//var parsedJson = jQuery.parseJSON(results.obj); 
				var dataObj=JSON.parse(result);//转换为json对象 
				var obj = dataObj.obj;
				//console.info(obj);
				
				$(".today").html(obj.today);
				$(".this_week").html(obj.this_week);
				$(".this_month").html(obj.this_month);
				
				receivable_amount = obj.receivable_amount;
				collected_amount = obj.collected_amount;
				
				businessVolume();
				turnoverHistogram();
				
			});*/

			$(".today").html("319678.94");
				$(".this_week").html("548796.58");
				$(".this_month").html("986573.88");
		businessVolume();
		turnoverHistogram();
		  
		  
		});
		
		//营业额
		function businessVolume(){
			var chart = {
			  type: 'column'
		   };
		   var title = {
			  text: '2018-08-09'   
		   };
		   var subtitle = {
			  text: ''  
		   };
		   var xAxis = {
			  categories: ['00','01','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18','19','20','21','22','23'],
			  crosshair: true
		   };
		   var yAxis = {
			  min: 0,
			  title: {
				 text: '金额(元)'         
			  }      
		   };
		   var tooltip = {
			  headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			  pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
				 '<td style="padding:0"><b>{point.y:.1f} (元)</b></td></tr>',
			  footerFormat: '</table>',
			  shared: true,
			  useHTML: true
		   };
		   var plotOptions = {
			  column: {
				 pointPadding: 0.2,
				 borderWidth: 0
			  }
		   };  
		   var credits = {
			  enabled: false
		   };
		   
		   var series= [{
				name: '应收金额',
					data: receivable_amount
				},{
				name: '实收金额',
					data: collected_amount
				}];     
			  
		   var json = {};   
		   json.chart = chart; 
		   json.title = title;   
		   json.subtitle = subtitle; 
		   json.tooltip = tooltip;
		   json.xAxis = xAxis;
		   json.yAxis = yAxis;  
		   json.series = series;
		   json.plotOptions = plotOptions;  
		   json.credits = credits;
		   $('#container').highcharts(json);
		}
		
		//营业额-柱状图
		function turnoverHistogram(){
			var chart = {
			   plotBackgroundColor: null,
			   plotBorderWidth: null,
			   plotShadow: false
		   };
		   var title = {
			  text: ' '   
		   };      
		   var tooltip = {
			  pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		   };
		   var plotOptions = {
			  pie: {
				 allowPointSelect: true,
				 cursor: 'pointer',
				 dataLabels: {
					enabled: true,
					format: '<b>{point.name}%</b>: {point.percentage:.1f} %',
					style: {
					   color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					}
				 }
			  }
		   };
		   var series= [{
			  type: 'pie',
			  name: '实收占比',
			  data: [
				 ['鸿鹤鲜锅兔小份',0.7],
				 ['爆款2-3人套餐',26.8],
				 ['鸿鹤鲜锅兔大份',12.8,],
				 ['麻辣兔头',8.5],
				 ['香卤兔头',6.2],
				 ['鸿鹤冷吃兔*250g*',45.7]
			  ]
		   }];     
			  
		   var json = {};   
		   json.chart = chart; 
		   json.title = title;     
		   json.tooltip = tooltip;  
		   json.series = series;
		   json.plotOptions = plotOptions;
		   $('#container_left_pie').highcharts(json);  
		}
		
		</script>
	<!--
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	-->

    <style type="text/css">
	.gray-bg{
		background-color: #e9ecf3;
	}
	.col-sm-2 {
	    width: 10%;
		padding-left: 5px;
		padding-right: 5px;
		float: left;
	}
	.p-lg{
		padding:0px 0px 10px 0px;
	}
	.widget{
		margin-top: 0px;
	}
	.iconfont{
		font-size: 30px;
		color: white;
	}
	h2 {
        font-size: 19px;
    }
    .echart_div{
    	height:240px;width:100%;
    }
	.ibtn{
		cursor: pointer;
	}
	.flot-chart{
		height:400px;
	}
   /*  .top-navigation .wrapper.wrapper-content{padding:20px 5px !important;}
	.container {
    	 width:99% !important; margin:10px;
    	 padding-right: 1px !important;
    	 padding-left: 1px !important;
	}
	.color_red{color:#e55555;} */
    </style>
</head>
 <body class="gray-bg">
        
</body>
</html>