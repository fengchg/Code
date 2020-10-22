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
	<script src="webpage/main/JShare/highcharts.js"></script>
	<script language="JavaScript"> 
		
		var url = '<%=basePath%>';
		//var url= "http://app.tuxingtianxia.com.cn/maro";
		
		//标识 1天  2月  年
		var tyn = 1;
		
		
		var myDate = new Date();
		//获取当前年
		var year=myDate.getFullYear();
		//获取当前月
		var month=myDate.getMonth()+1;
		//获取当前日
		var date=myDate.getDate(); 
		var h=myDate.getHours();       //获取当前小时数(0-23)
		var m=myDate.getMinutes();     //获取当前分钟数(0-59)
		var s=myDate.getSeconds();  

		var now=year+'-'+p(month)+"-"+p(date);//+" "+p(h)+':'+p(m)+":"+p(s);
		
		function p(s) {
			return s < 10 ? '0' + s: s;
		}
	
		//时间数组
		//var dataArray = ['00','01','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18','19','20','21','22','23']
		//应收金额
		//var receivable_amount = [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 516.4, 194.1, 95.6, 54.4,49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 516.4, 194.1, 95.6, 54.4];
		//实收金额
		//var collected_amount = [23.9, 62.5, 106.4, 129.2, 144.0, 136.0, 135.6, 148.5, 356.4, 194.1, 55.6, 54.4,49.9, 21.5, 66.4, 129.2, 144.0, 16.0, 135.6, 148.5, 256.4, 194.1, 95.6, 54.4];
		
		//时间数组
		var dataArray;
		//应收金额
		var receivable_amount;
		//实收金额
		var collected_amount;
		////饼图
		var peiCollectedAmount;
		//初始化的table
		var peiList = "";
		//全部的list
		var peiListAll = "";
		
		$(document).ready(function() {
			getStatisticalTurnover(1);
		});
		
		
		//柱状图-点击天月年
		function getYmdDateHistogram(ymd){
			$.post(url+"/maroHomePageStatementController.do?getYmdDateHistogram",{'ymd':ymd,'tynData':now},function(resultPage){
				var dataObj=JSON.parse(resultPage);//转换为json对象 
				var obj = dataObj.obj;
				
				//时间
				dataArray = obj.hour;
				//柱状图 -- 应收
				receivable_amount = obj.receivable_amount;
				collected_amount = obj.collected_amount;
				
				businessVolume();
			});
		}
		
		//初始化
		function getStatisticalTurnover(ymd){
			$(".business_date").html(now);
			//alert(url);
			$.post(url+"/maroHomePageStatementController.do?getStatisticalTurnover",{'ymd':ymd,'tynData':now},function(resultPage){
				//console.info(resultPage);
				//var parsedJson = jQuery.parseJSON(resultPage.obj); 
				var dataObj=JSON.parse(resultPage);//转换为json对象 
				var obj = dataObj.obj;
				//console.info(obj);
				
				if(obj == null){
					return;
				}
				
				$(".shopName").html(obj.shopName);
				//今日营业额
				$(".today").html(obj.today);
				//本周营业额
				$(".this_week").html(obj.this_week);
				//本月营业额
				$(".this_month").html(obj.this_month);
				
				//时间
				dataArray = obj.hour;
				//柱状图 -- 应收
				receivable_amount = obj.receivable_amount;
				collected_amount = obj.collected_amount;
				
				//饼图
				var arr=new Array();
				$.each(obj.peiCollectedAmount,function(key,values){
					var a=[key,values];
					arr.push(a);
				});					 
				peiCollectedAmount = arr;

				//list
				$(".peiList").html("");
				$.each(obj.peiList,function(index,item){
					peiList += "<tr>";
					if(index % 2 == 0){
						peiList += "<td><span class=\"label label-warning\">"+item.dishes_name+"</span></td>";
					}else{
						peiList += "<td><span class=\"label label-primary\">"+item.dishes_name+"</span></td>";
					}
					peiList += "<td class=\"text-navy\">"+item.frequency_quantity+"</td>";
					peiList += "<td class=\"text-navy\">"+item.frequency_amount+"</td>";
					peiList += "<td class=\"text-navy\">"+item.paid_in_proportion+"%</td>";
					peiList += "</tr>";
				});
				
				peiList += "<tr>";
				peiList += "	<td><span class=\"label\"><a href=\"javascript:void(0)\" onclick=\"openPeiList()\">查看全部</a></span></td>";
				peiList += "	<td class=\"text-navy\"></td>";
				peiList += "	<td class=\"text-navy\"></td>";
				peiList += "	<td class=\"text-navy\"></td>";
				peiList += "</tr>";
				
				$(".peiList").html(peiList);
				
				businessVolume();
				turnoverHistogram();
				
			});
		}
		
		//点击 天月年
		function getYearMonthDay(ymd){
			if(ymd == 3){
				$('.datey').addClass("active");
				$('.datem').removeClass("active");
				$('.dated').removeClass("active");
				now=year;
			}else if(ymd == 2){
				$('.datey').removeClass("active");
				$('.datem').addClass("active");
				$('.dated').removeClass("active");
				now=year+'-'+p(month);
			}else if(ymd == 1){
				$('.datey').removeClass("active");
				$('.datem').removeClass("active");
				$('.dated').addClass("active");
				now=year+'-'+p(month)+"-"+p(date);
			}
			
			getYmdDateHistogram(ymd);
			tyn = ymd;
			
			$(".business_date").html(now);
		}
		
		//显示全部的列表比率
		function openPeiList(){
			$.post(url+"/maroHomePageStatementController.do?getPeiList",{},function(resultPage){
				var dataObj=JSON.parse(resultPage);//转换为json对象 
				var obj = dataObj.obj;
				$.each(obj,function(index,item){
					peiListAll += "<tr>";
					if(index % 2 == 0){
						peiListAll += "<td><span class=\"label label-warning\">"+item.dishes_name+"</span></td>";
					}else{
						peiListAll += "<td><span class=\"label label-primary\">"+item.dishes_name+"</span></td>";
					}
					peiListAll += "<td class=\"text-navy\">"+item.frequency_quantity+"</td>";
					peiListAll += "<td class=\"text-navy\">"+item.frequency_amount+"</td>";
					peiListAll += "<td class=\"text-navy\">"+item.paid_in_proportion+"%</td>";
					peiListAll += "</tr>";
				});
				$(".peiList").html("");
				$(".peiList").html(peiListAll);
			});
		}
		
		//营业额 -柱状图
		function businessVolume(){
			var chart = {
			  type: 'column'
		   };
		   var title = {
			  text: ''   
		   };
		   var subtitle = {
			  text: ''  
		   };
		   var xAxis = {
			  categories: dataArray,
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
		
		//营业额-饼图
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
			  data: peiCollectedAmount
		   }];     
			  
		   var json = {};   
		   json.chart = chart; 
		   json.title = title;     
		   json.tooltip = tooltip;  
		   json.series = series;
		   json.plotOptions = plotOptions;
		   $('#container_left_pie').highcharts(json);  
		}
		
		//时间  1上  2下  
		function tynoOnclike(m){
			
			$(".business_date").html("");
			if(tyn == 1){
				if(m == 1){//上一天
					getPrevDay();
				}else if(m == 2){ //下一天
					getNextDay();
				}
			}else if(tyn == 2){
				if(m == 1){//  上一月
					getPreMonth();
				}else if(m == 2){ //下一月
					getNextMonth();
				}
			}else if(tyn == 3){
				if(m == 1){//  上一年
					getPerYear();
				}else if(m == 2){ //下一年
					getNextYear();
				}
				
			}
			
			getYmdDateHistogram(tyn);
			
			$(".business_date").html(now);
			//console.info(now);
			
		}
		
		//获取指定时间的前一天
		function getPrevDay() {
			var year = now.substring(0,4);
			var month = now.substring(5,7);
			var day = now.substring(8,10);
			var today=new Date(year, month-1 ,day);
			var yesterday_milliseconds=today.getTime()-1000*60*60*24;
			var yesterday=new Date();
			yesterday.setTime(yesterday_milliseconds);
			var strYear=yesterday.getFullYear();
			var strDay=yesterday.getDate();
			var strMonth=yesterday.getMonth()+1;
			if(strMonth<10) {
				strMonth="0"+strMonth;
			}
			if(strDay<10) {
				strDay="0"+strDay;
			}
			var rd = strYear+"-"+strMonth+"-"+strDay;
			now = rd;
			return rd;
		}
		
		//获取指定时间的后一天
		function getNextDay(){
			str = new Date(now);
			str = +str + 1000*60*60*24;
			str = new Date(str);
			var y=str.getFullYear();
			var m= str.getMonth()+1;
			var d= str.getDate() ;
			if(m<10) {
				m="0"+m;
			}
			if(d<10) {
				d="0"+d;
			}
			var rd = y+'-'+m+'-'+d;  
			now = rd;
			return rd;            
		}
		
		
		/**
         * 获取上一个月
         *
         * @date 格式为yyyy-mm-dd的日期，如：2014-01-25
         */
		 function getPreMonth() {
            var arr = now.split('-');
            var year = arr[0]; //获取当前日期的年份
            var month = arr[1]; //获取当前日期的月份
            var day = arr[2]; //获取当前日期的日
            var days = new Date(year, month, 0);
            days = days.getDate(); //获取当前日期中月的天数
            var year2 = year;
            var month2 = parseInt(month) - 1;
            if (month2 == 0) {
                year2 = parseInt(year2) - 1;
                month2 = 12;
            }
            var day2 = day;
            var days2 = new Date(year2, month2, 0);
            days2 = days2.getDate();
            if (day2 > days2) {
                day2 = days2;
            }
            if (month2 < 10) {
                month2 = '0' + month2;
            }
            var t2 = year2 + '-' + month2;// + '-' + day2;
			now = t2;
            return t2;
        }
        
        /**
         * 获取下一个月
         *
         * @date 格式为yyyy-mm-dd的日期，如：2014-01-25
         */        
        function getNextMonth() {
            var arr = now.split('-');
            var year = arr[0]; //获取当前日期的年份
            var month = arr[1]; //获取当前日期的月份
            var day = arr[2]; //获取当前日期的日
            var days = new Date(year, month, 0);
            days = days.getDate(); //获取当前日期中的月的天数
            var year2 = year;
            var month2 = parseInt(month) + 1;
            if (month2 == 13) {
                year2 = parseInt(year2) + 1;
                month2 = 1;
            }
            var day2 = day;
            var days2 = new Date(year2, month2, 0);
            days2 = days2.getDate();
            if (day2 > days2) {
                day2 = days2;
            }
            if (month2 < 10) {
                month2 = '0' + month2;
            }
        
            var t2 = year2 + '-' + month2;// + '-' + day2;
			now = t2;
            return t2;
        }
		
		//获取上一年
		function getPerYear(){
			var year2 =  parseInt(now) - 1;
			now = year2;
			return year2;
		}
		
		
		//获取下一年
		function getNextYear(){
			var year2 =  parseInt(now) + 1;
			now = year2;
			return year2;
		}
        
        //测试        
        //alert(getPreMonth("2014-01-25"));
        //alert(getNextMonth("2014-12-25"));
		
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
        <div class="wrapper wrapper-content">
           
			<div class="row">
				 <div class="col-sm-3">
					<div class="ibox float-e-margins" style="height:130px;">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5 class="shopName"></h5>
								<div class="ibox-tools">
									<a class="collapse-link">
										<i class="fa fa-chevron-up"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content">
								<h1>&nbsp;</h1>
							</div>
						</div>
					</div>
				 </div>
				 
				  <div class="col-sm-3">
					<div class="ibox float-e-margins" style="height:130px;">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5><i class="fa fa-bar-chart" style="color:#016CDF;"></i> &nbsp; 今日营业额（元）</h5>
								<div class="ibox-tools">
									<a class="collapse-link">
										<i class="fa fa-chevron-up"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content">
								<h1 class="today"></h1>
							</div>
						</div>
					</div>
				 </div>
				 
				  <div class="col-sm-3">
					<div class="ibox float-e-margins" style="height:130px;">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5><i class="fa fa-bar-chart" style="color:#016CDF;"></i> &nbsp; 本周营业额（元）</h5>
								<div class="ibox-tools">
									<a class="collapse-link">
										<i class="fa fa-chevron-up"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content">
								<h1 class="this_week"></h1>
							</div>
						</div>
					</div>
				 </div>
				 
				  <div class="col-sm-3">
					<div class="ibox float-e-margins" style="height:130px;">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5><i class="fa fa-bar-chart" style="color:#016CDF;"></i> &nbsp; 本月营业额（元）</h5>
								<div class="ibox-tools">
									<a class="collapse-link">
										<i class="fa fa-chevron-up"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content">
								<h1 class="this_month"></h1>
							</div>
						</div>
					</div>
				 </div>
			</div>
			
			<div class="row">
				 <div class="col-sm-12" style="width:100%;height:600px;">
					<div class="ibox float-e-margins" style="height:130px;">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>营业额</h5>
								<div class="pull-left" style="text-indent:5px;margin-top: -6px;">
									<div class="btn-group">
										<i class="fa fa-toggle-left" style="color:#016CDF;font-size:28px;" onclick="tynoOnclike(1)"></i>&nbsp;&nbsp;
											<span class="business_date" style="font-size: 18px;"></span>
										&nbsp;<i class="fa fa-toggle-right" style="color:#016CDF;font-size:28px;"  onclick="tynoOnclike(2)"></i>
									</div>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<button type="button" class="btn dated btn-xs btn-white active" onclick="getYearMonthDay(1)">天</button>
										<button type="button" class="btn datem btn-xs btn-white" onclick="getYearMonthDay(2)">月</button>
										<button type="button" class="btn datey btn-xs btn-white" onclick="getYearMonthDay(3)">年</button>
									</div>
								</div>
							</div>
							<div class="ibox-content">
								<div id="container" style="width:100%; height: 500px; margin: 0 auto"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				 <div class="col-sm-12" style="width:100%;height:600px;">
					<div class="ibox float-e-margins" style="height:130px;">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>菜品（堂食）</h5>
							</div>
							<div class="ibox-content" style="height: 540px;">
								<div class="">
									<div class="dishes_left_pie" style="float:left;width:48%;">
										<div id="container_left_pie" style="width: 650px; height: 500px; margin: 0 auto"></div>
									</div>
									<div class="dishes_right_list" style="float:right;width:48%;height:500px;overflow-y:auto;">
										<table class="table table-hover no-margins">
											<thead>
												<tr>
													<th>菜品名称</th>
													<th>消费笔数</th>
													<th>消费总金额</th>
													<th>实收占比</th>

												</tr>
											</thead>
											<tbody class="peiList"> 
												<tr>
													<td><span class="label label-warning"></span></td>
													<td class="text-navy"></td>
													<td class="text-navy"></td>
													<td class="text-navy"></td>
												</tr>
												<tr>
													<td><span class="label label-primary"></span></td>
													<td class="text-navy"></td>
													<td class="text-navy"></td>
													<td class="text-navy"></td>
												</tr>
												<tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
            
            <div class="wrapper wrapper-content">
   
</div>

<!-- 全局js -->
<!-- <script src="plug-in-ui/hplus/js/jquery.min.js?v=2.1.4"></script> 
<script src="plug-in-ui/hplus/js/bootstrap.min.js?v=3.3.6"></script> -->
<!-- 自定义js 
<script src="plug-in-ui/hplus/js/content.js"></script>-->
<script type="text/javascript" src="plug-in/echart/echarts.min.js"></script>
<script>

</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->
</body>
</html>