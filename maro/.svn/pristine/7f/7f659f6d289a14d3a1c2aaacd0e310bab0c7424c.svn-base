<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>maro_client_reserve</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  function checkTime(obj){
      var reserveTime=$(obj).val();
      if(reserveTime!=""){
          	var date=new Date();
			var year=date.getFullYear();
			var month=(date.getMonth()+1)>=10?(date.getMonth()+1):"0"+(date.getMonth()+1);
			var day=date.getDate()>=10?date.getDate():"0"+date.getDate();
			var ymd=year+"-"+month+"-"+day;
			if(reserveTime<ymd){
                alertTip("结束时间不能小于开始时间","提示");
                $(obj).val("");
			}else{
                selectShop(obj);
			}
	  }
  }
  //选择店铺后进行弹出框选择该店铺的未预定的座位信息
  function selectShop(obj){
		var shopId=$("#restaurantId").val();//店铺
		var reserveTime=$("#reserveTime").val();//预定时间
		var period=$("#period").val();//时段
		var personNumber=$("#personNumber").val();//就餐人数
		if(shopId==""||reserveTime==""||period==""||personNumber==""){
			console.info(shopId);
			console.info(reserveTime);
			console.info(period);
			console.info(personNumber);
			$("#destSeatId").combobox({data:[]});
			$("#destSeatId").combobox("clear");
			return;
		}
		$("#destSeatId").combobox("reload","maroClientReserveController.do?listSeat&shopId="+shopId+"&reserveTime="+reserveTime+"&period="+period+"&personNumber="+personNumber);
		$("#destSeatId").combobox("clear");
  }
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="maroClientReserveController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${maroClientReservePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							店铺:
						</label>
					</td>
					<td class="value">
						<t:dictSelect id="restaurantId" datatype="*" field="restaurantId" type="list"  dictTable="maro_shop" dictField="id" dictText="name" dictCondition="${dictCondition}" hasLabel="false"  title="店铺" onChange="selectShop(this)"></t:dictSelect>
				     	<!--  <input id="shopId" name="shopId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">店铺</label>
					</td>
						
					<td align="right">
						<label class="Validform_label">
							预定时间:
						</label>
					</td>
					<td class="value">
				     	<input id="reserveTime" name="reserveTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" datatype="*" ignore="checked" onchange="checkTime(this)"/>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">预定时间</label>
					</td>
				<tr>		
					<td align="right">
						<label class="Validform_label">
							时段:
						</label>
					</td>
					<td class="value">
						<t:dictSelect id="period" field="period" type="list" datatype="*"  typeGroupCode="maro_period"  hasLabel="false"  title="时段" onChange="selectShop(this)"></t:dictSelect>
				     	<!-- <input id="period" name="period" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" /> -->
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">时段</label>
					</td>	
						
					<td align="right">
						<label class="Validform_label">
							预计到来时间:
						</label>
					</td>
					<td class="value">
				     	<input id="planComeTime" name="planComeTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'HH:mm:ss'})"  datatype="*" ignore="checked" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">预计到来时间</label>
					</td>	
				<tr>		
					<td align="right">
						<label class="Validform_label">
							就餐人数:
						</label>
					</td>
					<td class="value">
				     	<input id="personNumber" name="personNumber" type="text" style="width: 150px" class="inputxt"  datatype="n" ignore="checked" onchange="selectShop(this)"/>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">就餐人数</label>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							桌位:
						</label>
					</td>
					<td class="value">
				     	<input id="destSeatId" class="easyui-combobox" style="width: 157px" name="destSeatId"  data-options="valueField:'id',textField:'text'" />  
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">桌位</label>
					</td>
				<tr>		
					<td align="right">
						<label class="Validform_label">
							手机号码:
						</label>
					</td>
					<td class="value">
				     	<input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  datatype="/^[0-9]*$/" ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">手机号码</label>
					</td>
						
					<td align="right">
						<label class="Validform_label">
							顾客姓名:
						</label>
					</td>
					<td class="value">
				     	<input id="customerName" name="customerName" type="text" style="width: 150px" datatype="*" class="inputxt"  ignore="checked" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">顾客姓名</label>
					</td>
				<tr>	
					<td align="right">
						<label class="Validform_label">
							订金:
						</label>
					</td>
					<td class="value">
				     	<input id="deposit" name="deposit" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">订金</label>
					</td>
					
					<td align="right">
						<label class="Validform_label">
							订单类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="type" name="type" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单类型</label>
					</td>	
				<tr>	
					<td align="right">
						<label class="Validform_label">
							内容:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea id="content" style="width:455px;" class="inputxt" rows="6" name="content"  ignore="ignore" ></textarea>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">内容</label>
					</td>
					
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/maro/manager/shop/reserve/maroClientReserve.js"></script>		
