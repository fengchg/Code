package com.maro.manager.print.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.maro.client.common.constant.enumconstant.FoodPackageTypeEnum;
import com.maro.client.common.constant.enumconstant.FoodTypeEnum;
import com.maro.client.common.util.EnumUtil;
import com.maro.client.common.util.PojoUtil;
import com.maro.client.module.serverorder.pojo.dto.FoodOrderParamsDTO;
import com.maro.client.module.serverorder.pojo.dto.PayParamsDTO;
import com.maro.client.module.serverorder.pojo.dto.SeatchangeParamsDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientPayedDetailVO;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.util.PrintUtil;
import com.maro.manager.print.entity.CallUpShole;
import com.maro.manager.print.entity.ChangeChannel;
import com.maro.manager.print.entity.CombineTable;
import com.maro.manager.print.entity.FlyoutMenu;
import com.maro.manager.print.entity.OrderSubmenu;
import com.maro.manager.print.entity.SettleAccounts;
import com.maro.manager.print.entity.SettleAccountsDishes;
import com.maro.manager.print.entity.ShiftingOfDuty;
import com.maro.manager.print.entity.SingleReturnDishes;
import com.maro.manager.print.entity.SingleUrge;
import com.maro.manager.print.entity.TakeOutSingle;
import com.maro.platform.core.util.DateUtils;

public class PrintMain {
	

	public static void main(String[] args) throws IOException {
		
	}
	
	static {
		//读取src目录下的printer.properties文件
		/*ResourceBundle resource = ResourceBundle.getBundle("printer");
		
		s.getPrinterIp() = resource.getString("s.getPrinterIp()");
		s.getPrinterPort() = Integer.valueOf(resource.getString("s.getPrinterPort()"));
		
		s.getPrinterIp() = resource.getString("s.getPrinterIp()");
		s.getPrinterPort() = Integer.valueOf(resource.getString("s.getPrinterPort()"));*/
		//maroPrinterService.getEntity(MaroPrinterEntity.class,"id");
	}
	
	public static String xmlStrEnd(){
		String xmlStr = "";
		
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		
		xmlStr += "<section><texts>";
		xmlStr += "<text>子煊智慧餐饮软件</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Small</fontSize>";
		xmlStr += "<bold>false</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		
		xmlStr += "<section><texts>";
		xmlStr += "<text>光华北三路164号</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Small</fontSize>";
		xmlStr += "<bold>false</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		
		xmlStr += "<section><texts>";
		xmlStr += "<text>17726461730</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Small</fontSize>";
		xmlStr += "<bold>false</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		return xmlStr;
	}
	
	/**
	 * 结账单*
	 * 预结单*
	 */
	public static boolean printSettleAccounts(SettleAccounts s){
		
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>["+s.getTitleName()+"]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<keyvalue>";
		xmlStr += "<key>桌　名:</key>";
		xmlStr += "<value>["+s.getSeatName()+"]</value>";
		xmlStr += "</keyvalue>";
		xmlStr += "<keyvalue>";
		xmlStr += "<key>人　数:</key>";
		xmlStr += "<value>["+s.getRenShu()+"]</value>";
		xmlStr += "</keyvalue>";
		xmlStr += "<keyvalue><key>账单号:</key>";
		xmlStr += "<value>["+s.getBillNumber()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>开台时间:</key>";
		xmlStr += "<value>["+s.getBeginTime()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>结账时间:</key>";
		xmlStr += "<value>["+s.getSettleTime()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>服务员:</key>";
		xmlStr += "<value>["+s.getWaiter()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>收银员:</key>";
		xmlStr += "<value>["+ifStrNull(s.getCashier())+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>会　员:</key>";
		xmlStr += "<value>["+ifStrNull(s.getMember())+"]</value></keyvalue>";
		xmlStr += "<table>";
		xmlStr += "<cws><cw>20</cw><cw>8</cw><cw>6</cw><cw>8</cw></cws>";
		xmlStr += "<ars><ar>false</ar><ar>true</ar><ar>true</ar><ar>true</ar></ars>";
		xmlStr += "<headers><header>品名</header><header>单价</header><header>数量</header><header>总额</header></headers>";
		xmlStr += "<rows>";
		
		/*for(int j=0;j<s.getDishesList().size();j++){
			xmlStr += "<row><td>["+s.getDishesList().get(j).getClassName()+"]</td> <td></td> <td></td> <td></td></row>";
			for(int i=0;i<s.getDishesList().get(j).getSpsList().size();i++){
				SettleAccountsDishes sd = s.getDishesList().get(j).getSpsList().get(i);
				xmlStr += "<row><td>　"+sd.getDishesName()+"</td>";
				xmlStr += "<td>"+sd.getDishesPrice()+"</td>";
				xmlStr += "<td>"+sd.getShuLiang()+"</td>";
				xmlStr += "<td>"+sd.getTotalMoney()+"</td></row>";
			}
		}*/
		
		Double amountDeceivable = 0.0;
		for(int i=0;i<s.getDishesList().size();i++){
			SettleAccountsDishes sd = s.getDishesList().get(i);
			xmlStr += "<row><td>("+sd.getIsPresentDishes()+")"+sd.getDishesName()+"</td>";
			xmlStr += "<td>"+sd.getDishesPrice()+"</td>";
			xmlStr += "<td>"+sd.getShuLiang()+"</td>";
			xmlStr += "<td>"+sd.getTotalMoney()+"</td></row>";
			if(!sd.getIsPresentDishes().equals("赠品")){
				amountDeceivable = amountDeceivable + Double.valueOf(sd.getTotalMoney());
			}
		}
		
		xmlStr += "</rows></table>";
		
		if(s.getTitleName().equals("结账单")){
			for(int i=0;i<s.getObjects().size();i++){
				MaroClientPayedDetailVO mpd = s.getObjects().get(i);
				xmlStr += "<keyvalue><key>"+mpd.getPayTypeString()+":</key><value>["+mpd.getAmount()+"]</value></keyvalue>";
			}
			xmlStr += "<keyvalue><key>抹　零:</key><value>["+ifStrNull(s.getSmallChange())+"]</value></keyvalue>";
		}
		xmlStr += "<keyvalue><key>服务费:</key><value>["+ifStrNull(s.getServiceCharge())+"]</value></keyvalue>";
		amountDeceivable = amountDeceivable +  Double.valueOf(s.getServiceCharge());
		xmlStr += "<keyvalue><key>应收合计:</key><value>["+amountDeceivable.toString()+"]</value></keyvalue>";

		xmlStr += xmlStrEnd();
		
		xmlStr += "</doucument>";
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}


	/**
	 * 交接班*
	 */
	public static boolean printShiftingOfDuty(ShiftingOfDuty s){
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>[交接班]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<keyvalue><key>班　次:</key><value>["+s.getClassNext()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>开始时间:</key><value>["+s.getStartTime()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>结束时间:</key><value>["+s.getEndTime()+"]</value></keyvalue>";
        for(Map map:s.getRootInfo()){//基础消费信息
            xmlStr += "<keyvalue><key>"+map.get("name")+":"+"</key><value>["+map.get("value")+"]</value></keyvalue>";
        }
        for(Map map:s.getAreaInfo()){//区域消费
            xmlStr += "<keyvalue><key>"+map.get("typename")+":"+"</key><value>["+map.get("amount")+"]</value></keyvalue>";
        }
        //分隔符
		xmlStr += "<line></line>";
        for(Map map:s.getShouKuangInfo()){//各种支付方式
            xmlStr += "<keyvalue><key>"+map.get("payname")+":"+"</key><value>["+map.get("num")+"]</value></keyvalue>";
        }
        //分隔符
		xmlStr += "<line></line>";
        String foodType="";//菜品种类
        double totalPrice=0.0;//总价
        StringBuffer tmp=new StringBuffer();
        for(Map map:s.getMenuInfo()){//菜品消费信息
            String food_type = map.get("food_type")==null?"":map.get("food_type").toString();
            String food_name = map.get("food_name")==null?"":map.get("food_name").toString();
            String num = map.get("num")==null?"":map.get("num").toString();
            String total_price = map.get("total_price")==null?"":map.get("total_price").toString();
            if(!foodType.equals(food_type)){
                if(tmp.length()>0){//buffer中有数据时
                	//表头
					xmlStr +="<section><texts>";
					xmlStr +="<text>"+foodType+"  "+totalPrice+"</text>";
					xmlStr +="<font>";
					xmlStr +="<fontSize>Small</fontSize>";
					xmlStr +="<bold>false</bold>";
					xmlStr +="<underline>false</underline>";
					xmlStr +="</font></texts>";
					xmlStr +="<textAlign>Center</textAlign>";
					xmlStr +="</section>";
					xmlStr +="<nolineTable>";
					xmlStr +="<cws><cw>22</cw><cw>10</cw><cw>10</cw></cws>";
					xmlStr +="<ars><ar>false</ar><ar>true</ar><ar>true</ar></ars>";
					xmlStr +="<rows>";
					//数据
					xmlStr+=tmp.toString();
					//表尾
					xmlStr+="</rows></nolineTable>";
                }
                foodType=food_type;
                totalPrice=Double.valueOf(total_price);
                tmp.setLength(0);//清空buffer
				//加入数据
				tmp.append("<row><td>"+food_name+"</td><td>"+num+"</td><td>"+total_price+"</td></row>");
            }else{
                totalPrice+=Double.valueOf(total_price);
				tmp.append("<row><td>"+food_name+"</td><td>"+num+"</td><td>"+total_price+"</td></row>");
            }
        }
		xmlStr += "<section><texts>";
		xmlStr += "<text>"+s.getPosition()+"</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Small</fontSize>";
		xmlStr += "<bold>false</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		
		xmlStr += "<section><texts>";
		xmlStr += "<text>"+s.getPhone()+"</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Small</fontSize>";
		xmlStr += "<bold>false</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		
		
		xmlStr += xmlStrEnd();
		
		xmlStr += "</doucument>";
		
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}
	
	/**
	 * 外卖单
	 */
	public static boolean printTakeOutSingle(TakeOutSingle s){
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>[外卖单]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<line></line>";
		xmlStr += "<keyvalue><key>订餐时间:</key><value>["+s.getOrderTime()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>接单时间:</key><value>["+s.getOrderTime()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>平台订单号:</key><value>["+s.getOrderNumber()+"]</value></keyvalue>";
		xmlStr += "<line></line>";
		xmlStr += "<keyvalue><key>备　注:</key><value>["+ifStrNull(s.getRemark())+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>活　动:</key><value>["+ifStrNull(s.getActivity())+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>发　票:</key><value>["+ifStrNull(s.getInvoice())+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>税　号:</key><value>["+ifStrNull(s.getDutyParagraph())+"]</value></keyvalue>";
		xmlStr += "<table>";
		xmlStr += "<cws><cw>20</cw><cw>12</cw><cw>10</cw></cws>";
		xmlStr += "<ars><ar>false</ar><ar>true</ar><ar>true</ar></ars>";
		xmlStr += "<headers><header>品名</header><header>单价</header><header>数量</header></headers>";
		xmlStr += "<rows>";
		
			for(int i=0;i<s.getDishesList().size();i++){
				SettleAccountsDishes sd = s.getDishesList().get(i);
				xmlStr += "<row><td>　"+sd.getDishesName()+"</td>";
				xmlStr +="<td>"+sd.getDishesPrice()+"</td>";
				xmlStr += "<td>　"+sd.getShuLiang()+" "+sd.getUnit()+"</td></row>";
			}
		
		xmlStr += "</rows></table>";
		xmlStr += "<keyvalue><key>配送费:</key><value>["+s.getDeliveryCost()+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += "<keyvalue><key>餐盒费:</key><value>["+s.getMealsFee()+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += "<keyvalue><key>减满优惠:</key><value>["+s.getPreferentialReduction()+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += "<keyvalue><key>新用户优惠:</key><value>["+s.getNewUserUiscounts()+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += "<line></line>";
		xmlStr += "<keyvalue><key>已在线支付:</key><value>["+s.getOnLinePayment()+"]</value></keyvalue>";
		xmlStr += "<line></line>";
		xmlStr += "<keyvalue><key>地址:</key><value>["+s.getAddress()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>电话:</key><value>["+s.getPhone()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>名称:</key><value>["+s.getUserName()+"]</value></keyvalue>";
		
		xmlStr += xmlStrEnd();
		
		xmlStr += "</doucument>"; 
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}
	
	/**
	 * 点菜分单*
	 */
	public static boolean printOrderSubmenu(OrderSubmenu s){
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>["+s.getTitleName()+"]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<keyvalue><key>桌　名:</key><value>["+s.getFlag()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>人　数:</key><value>["+s.getNumber()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>服务员:</key><value>["+ifStrNull(s.getWaiter())+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>下单时间:</key><value>["+s.getOrderTime()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>账单号:</key><value>["+s.getBillMark()+"]</value></keyvalue>";
		
		xmlStr += "<table>";
		xmlStr += "<cws><cw>26</cw><cw>14</cw></cws>";
		xmlStr += "<ars><ar>false</ar><ar>true</ar></ars>";
		xmlStr += "<headers><header>品名</header><header>数量</header></headers>";
		xmlStr += "<rows>";
		
			for(int i=0;i<s.getDishesList().size();i++){
				SettleAccountsDishes sd = s.getDishesList().get(i);
				String u = "";
				//* 套餐类型，0未普通类型，1为套餐类型，2为套餐子类型
				if(sd.getDishesType().equals("0")){
					u = sd.getUnit();
				}else if(sd.getDishesType().equals("1")){
					u = "套餐";
				}
				xmlStr += "<row><td>"+sd.getDishesName()+"</td>";
				xmlStr += "<td>　"+sd.getShuLiang()+" "+ u +"</td></row>";
				if(sd.getDishesType().equals("1")){ //套餐
					for(int j=0;j<sd.getSpsList().size();j++){
						SettleAccountsDishes sd_p = sd.getSpsList().get(j);
						xmlStr += "<row><td>　."+sd_p.getDishesName()+"</td>";
						xmlStr += "<td>"+sd_p.getShuLiang()+" ["+sd_p.getUnit()+"]</td></row>";
					}
				}
			}
		xmlStr += "</rows></table>";
		//xmlStr += "<keyvalue><key>备　注:</key><value>["+ifStrNull(s.getRemark())+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += "<keyvalue><key>整单备注:</key><value>["+ifStrNull(s.getWholeRemark())+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += "<keyvalue><key>送达时间:</key><value>["+ifStrNull(s.getDeliveryTime())+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += xmlStrEnd();
		xmlStr += "</doucument>";
		//boolean bb = PrintUtil.isOnline(s.getPrinterIp(),s.getPrinterPort());
		//System.out.println("args = [" + bb + "]");
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}
	
	/**
	 * 崔菜单*
	 */
	public static boolean printSingleUrge(SingleUrge s){
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>[崔菜单]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<keyvalue><key>桌　名:</key><value>["+s.getSeatName()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>人　数:</key><value>["+s.getNumber()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>服务员:</key><value>["+ifStrNull(s.getWaiter())+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>催菜时间:</key><value>["+s.getUrgeDishesTime()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>账单号:</key><value>["+s.getBillMark()+"]</value></keyvalue>";
		
		xmlStr += "<table>";
		xmlStr += "<cws><cw>26</cw><cw>14</cw></cws>";
		xmlStr += "<ars><ar>false</ar><ar>true</ar></ars>";
		xmlStr += "<headers><header>品名</header><header>数量</header></headers>";
		xmlStr += "<rows>";
		
			for(int i=0;i<s.getDishesList().size();i++){
				SettleAccountsDishes sd = s.getDishesList().get(i);
				String u = "";
				//* 套餐类型，0未普通类型，1为套餐类型，2为套餐子类型
				if(sd.getDishesType().equals("0")){
					u = sd.getUnit();
				}else if(sd.getDishesType().equals("1")){
					u = "套餐";
				}
				xmlStr += "<row><td>"+sd.getDishesName()+"</td><td>"+sd.getShuLiang()+" "+ u +"</td></row>";
				if(sd.getDishesType().equals("1")){ //套餐
					for(int j=0;j<sd.getSpsList().size();j++){
						SettleAccountsDishes sd_p = sd.getSpsList().get(j);
						xmlStr += "<row><td>　."+sd_p.getDishesName()+"</td>";
						xmlStr += "<td>"+sd_p.getShuLiang()+" ["+sd_p.getUnit()+"]</td></row>";
					}
				}
				if(sd.getRemark()!=null){
					xmlStr += "<row><td>备　注:"+sd.getRemark()+"</td><td></td></row>";
				}
			}
			
		xmlStr += "</rows></table>";
		//xmlStr += "<keyvalue><key>备　注:</key><value>["+s.getRemark()+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += "<keyvalue><key>整单备注:</key><value>["+ifStrNull(s.getWholeRemark())+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += xmlStrEnd();
		xmlStr += "</doucument>";
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}
	
	/**
	 * 退菜单*
	 */
	public static boolean printSingleReturnDishes(SingleReturnDishes s){
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>[退菜单]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<keyvalue><key>桌　名:</key><value>["+s.getSeatName()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>人　数:</key><value>["+s.getNumber()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>服务员:</key><value>["+ifStrNull(s.getWaiter())+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>退菜时间:</key><value>["+s.getQuitDishesTime()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>账单号:</key><value>["+s.getBillMark()+"]</value></keyvalue>";
		
		xmlStr += "<table>";
		xmlStr += "<cws><cw>26</cw><cw>14</cw></cws>";
		xmlStr += "<ars><ar>false</ar><ar>true</ar></ars>";
		xmlStr += "<headers><header>品名</header><header>数量</header></headers>";
		xmlStr += "<rows>";
		
			for(int i=0;i<s.getDishesList().size();i++){
				SettleAccountsDishes sd = s.getDishesList().get(i);
				String u = "";
				//* 套餐类型，0未普通类型，1为套餐类型，2为套餐子类型
				if(sd.getDishesType().equals("0")){
					u = sd.getUnit();
				}else if(sd.getDishesType().equals("1")){
					u = "套餐";
				}
				xmlStr += "<row><td>　"+sd.getDishesName()+"</td><td>"+sd.getShuLiang()+" "+ u +"</td></row>";
				//xmlStr += "<row><td>备　注:"+sd.getRemark()+"</td><td></td></row>";
				if(sd.getDishesType().equals("1")){ //套餐
					for(int j=0;j<sd.getSpsList().size();j++){
						SettleAccountsDishes sd_p = sd.getSpsList().get(j);
						xmlStr += "<row><td>　."+sd_p.getDishesName()+"</td>";
						xmlStr += "<td>"+sd_p.getShuLiang()+" ["+sd_p.getUnit()+"]</td></row>";
					}
				}
			}
		
		xmlStr += "</rows></table>";
		//xmlStr += "<keyvalue><key>备　注:</key><value>["+s.getRemark()+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += "<keyvalue><key>退菜原因:</key><value>["+s.getCause()+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += xmlStrEnd();
		xmlStr += "</doucument>";
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}
	
	/**
	 * 换台单#
	 */
	public static boolean printChangeChannel(ChangeChannel s){
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>[换台单]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<keyvalue><key>桌　名:</key><value>["+s.getSeatName()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>人　数:</key><value>["+s.getNumber()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>账单号:</key><value>["+s.getBillMark()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>换台时间:</key><value>["+s.getChangeChannelTime()+"]</value></keyvalue>";
		xmlStr += "<line></line>";
		xmlStr += "<keyvalue><key>原　台:</key><value>["+s.getSeatName()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>目标台:</key><value>["+s.getTargetSeatName()+"]</value></keyvalue>";
		xmlStr += "<line></line>";
		xmlStr += xmlStrEnd();
		xmlStr += "</doucument>";
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}
	
	/**
	 * 并台单#
	 */
	public static boolean printCombineTable(CombineTable s){
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>[并台单]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<keyvalue><key>桌　名:</key><value>["+s.getSeatName()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>人　数:</key><value>["+s.getNumber()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>账单号:</key><value>["+s.getBillMark()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>并台时间:</key><value>["+s.getChangeChannelTime()+"]</value></keyvalue>";
		xmlStr += "<line></line>";
		xmlStr += "<keyvalue><key>主　台:</key><value>["+s.getSeatName()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>目标台:</key><value>["+s.getTargetSeatName()+"]</value></keyvalue>";
		xmlStr += "<line></line>";
		xmlStr += xmlStrEnd();
		xmlStr += "</doucument>";
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}
	
	/**
	 * (作废) 目前没在使用
	 * 叫起整单#
	 */
	public static boolean printCallUpShole(CallUpShole s){
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>[叫起整单]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<keyvalue><key>桌名:</key><value>["+s.getSeatName()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>人数:</key><value>["+s.getNumber()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>账单号:</key><value>["+s.getBillMark()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>叫起时间:</key><value>["+s.getCallUpTime()+"]</value></keyvalue>";
		
		xmlStr += "<table>";
		xmlStr += "<cws><cw>20</cw><cw>12</cw><cw>10</cw></cws>";
		xmlStr += "<ars><ar>false</ar><ar>true</ar><ar>true</ar></ars>";
		xmlStr += "<headers><header>品名</header><header>单价</header><header>数量</header></headers>";
		xmlStr += "<rows>";
		
			for(int i=0;i<s.getDishesList().size();i++){
				SettleAccountsDishes sd = s.getDishesList().get(i);
				//普通的菜
				xmlStr += "<row><td>["+sd.getDishesName()+"]</td>";
				xmlStr += "<td>["+sd.getDishesPrice()+"]</td>";
				xmlStr += "<td>["+sd.getShuLiang()+"] ["+sd.getUnit()+"]</td></row>";
				if(sd.getDishesType().equals("package")){ //套餐
					for(int j=0;j<sd.getSpsList().size();j++){
						SettleAccountsDishes sd_p = sd.getSpsList().get(j);
						xmlStr += "<row><td>　.["+sd_p.getDishesName()+"]</td>";
						xmlStr += "<td></td>";
						xmlStr += "<td>["+sd_p.getShuLiang()+"] ["+sd_p.getUnit()+"]</td></row>";
					}
				}
				xmlStr += "<row><td>备注："+sd.getRemark()+"</td><td></td><td></td></row>";
			}
		
		xmlStr += "</rows></table>";
		xmlStr += "<keyvalue><key>整单备注:</key><value>["+ifStrNull(s.getWholeRemark())+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += "<keyvalue><key>送达时间:</key><value>["+ifStrNull(s.getDeliveryTime())+"]</value><font><fontSize>Small</fontSize><bold>true</bold><underline>false</underline></font></keyvalue>";
		xmlStr += xmlStrEnd();
		xmlStr += "</doucument>";
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}

	/**
	 * (作废) 此单已不使用
	 * 出菜单
	 * @param 
	 * @return
	 */
	public static boolean printFlyoutMenu(FlyoutMenu s){
		String xmlStr="";
		xmlStr += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlStr += "<doucument>";
		xmlStr += "<section><texts>";
		xmlStr += "<text>[出菜单]</text>";
		xmlStr += "<font>";
		xmlStr += "<fontSize>Normal</fontSize>";
		xmlStr += "<bold>true</bold>";
		xmlStr += "<underline>false</underline>";
		xmlStr += "</font></texts>";
		xmlStr += "<textAlign>Center</textAlign>";
		xmlStr += "</section>";
		xmlStr += "<blankRow><lineNumber>1</lineNumber></blankRow>";
		xmlStr += "<keyvalue><key>桌　名:</key><value>["+s.getSeatName()+"]</value></keyvalue>";
		xmlStr += "<keyvalue><key>账单号:</key><value>["+s.getBillMark()+"]</value></keyvalue>";
		
		xmlStr += "<table>";
		xmlStr += "<cws><cw>26</cw><cw>14</cw></cws>";
		xmlStr += "<ars><ar>false</ar><ar>true</ar></ars>";
		xmlStr += "<headers><header>品名</header><header>数量</header></headers>";
		xmlStr += "<rows>";
		
			for(int i=0;i<s.getDishesList().size();i++){
				SettleAccountsDishes sd = s.getDishesList().get(i);
				xmlStr += "<row><td>"+sd.getDishesName()+"</td><td>"+sd.getShuLiang().substring(0,1)+" "+sd.getUnit()+"</td></row>";
				if(sd.getRemark()!=null){
					xmlStr += "<row><td>　备　注:"+ifStrNull(sd.getRemark()) +"</td><td></td></row>";
				}
			}
		
		xmlStr += "</rows></table>";
		xmlStr += "<keyvalue><key>整单备注:</key><value>["+ifStrNull(s.getRemark())+"]</value></keyvalue>";
		xmlStr += xmlStrEnd();
		xmlStr += "</doucument>";
		
		boolean isPrint = PrintUtil.print(xmlStr,s.getPrinterIp(),s.getPrinterPort());
		return isPrint;
	}
	
	public static  SingleUrge convertSingleUrge(FoodOrderParamsDTO foodOrderParamsDTO){
		String remark = foodOrderParamsDTO.getMaroClientServerorderDO().getRemark();
		String seatName = foodOrderParamsDTO.getMaroClientServerorderDO().getSeatName();
		String waiterName = foodOrderParamsDTO.getMaroClientServerorderDO().getWaiterName();
		List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
		Integer personNumber = foodOrderParamsDTO.getMaroClientServerorderDO().getPersonNumber();
		String code = foodOrderParamsDTO.getMaroClientServerorderDO().getCode();
//		JSONArray jsonArray = new JSONArray();
//		for(int i=0;i<maroClientFoodorderDOList.size();i++){
//			jsonArray.add(foodOrderParamsDTO.getMaroClientFoodorderDOList().get(i));
//		}
		
		List<MaroClientFoodorderDO> list_tmp = foodOrderParamsDTO.getMaroClientFoodorderDOList();
		List<SettleAccountsDishes> list = convertBatchSettleAccountsDishes(list_tmp);
		
		SingleUrge s = new SingleUrge();
		s.setBillMark(code);
		s.setDishesList(list);
		s.setNumber(personNumber+"");
		s.setSeatName(seatName);
		s.setRemark(remark);
		s.setUrgeDishesTime(DateUtils.formatTime());
		s.setWaiter(waiterName);
		s.setWholeRemark(remark);
		return s;
	}
	public static SingleReturnDishes  convertSingleReturnDishes(FoodOrderParamsDTO foodOrderParamsDTO){
		String remark = foodOrderParamsDTO.getMaroClientServerorderDO().getRemark();
		String seatName = foodOrderParamsDTO.getMaroClientServerorderDO().getSeatName();
		String waiterName = foodOrderParamsDTO.getMaroClientServerorderDO().getWaiterName();
		List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
		Integer personNumber = foodOrderParamsDTO.getMaroClientServerorderDO().getPersonNumber();
		String code = foodOrderParamsDTO.getMaroClientServerorderDO().getCode();

		
		List<MaroClientFoodorderDO> list_tmp = foodOrderParamsDTO.getMaroClientFoodorderDOList();
		List<SettleAccountsDishes> list = convertBatchSettleAccountsDishes(list_tmp);
		SingleReturnDishes s = new SingleReturnDishes();
		s.setBillMark(code);
		s.setDishesList(list);
		s.setNumber(personNumber+"");
		s.setSeatName(seatName);
//		s.setRemark(remark);
		s.setQuitDishesTime(DateUtils.formatTime());
		s.setWaiter(waiterName);
		s.setCause(list.get(0).getRemark());
		return s;
	}

	public static CombineTable convertCombineTable(List<SeatchangeParamsDTO> seatchangeParamsDTOList){
		SeatchangeParamsDTO leadMergeSeatchangeParamsDTO = seatchangeParamsDTOList.get(0);
		MaroClientServerorderDO maroClientServerorderDO = leadMergeSeatchangeParamsDTO.getMaroClientServerorderDO();
		String seatName = maroClientServerorderDO.getSeatName();
		Integer personNumber = maroClientServerorderDO.getPersonNumber();
		String code = maroClientServerorderDO.getCode();
		StringBuffer buf = new StringBuffer();
		String targetSeatNames = "";
		String srcSeatNames = leadMergeSeatchangeParamsDTO.getMergeMaroShopSeatEntity().getName();
		for(int i=1;i<seatchangeParamsDTOList.size();i++){
			SeatchangeParamsDTO seatchangeParamsDTO = seatchangeParamsDTOList.get(i);
			MaroShopSeatEntity mergeMaroShopSeatEntity = seatchangeParamsDTO.getMergeMaroShopSeatEntity();
			buf.append(","+mergeMaroShopSeatEntity.getName());
		}
		if(buf.length() > 0){
			targetSeatNames = buf.substring(1);
		}

		CombineTable s = new CombineTable();
		s.setBillMark(code);
		s.setNumber(personNumber+"");
		s.setSeatName(seatName);
		s.setTargetSeatName(targetSeatNames);
		s.setChangeChannelTime(DateUtils.formatTime());
		s.setRawsSeatName(srcSeatNames);
		return s;
	}

	public static ChangeChannel convertChangeChannel(SeatchangeParamsDTO seatchangeParamsDTO) {
		MaroClientServerorderDO maroClientServerorderDO = seatchangeParamsDTO.getMaroClientServerorderDO();
		String srcSeatName = seatchangeParamsDTO.getSrcMaroShopSeatEntity().getName();
		String destSeatName = seatchangeParamsDTO.getDestMaroShopSeatEntity().getName();
		String seatName = maroClientServerorderDO.getSeatName();
		Integer personNumber = maroClientServerorderDO.getPersonNumber();
		String code = maroClientServerorderDO.getCode();
		ChangeChannel s =new ChangeChannel();
		s.setBillMark(code);
		s.setChangeChannelTime(DateUtils.formatTime());
		s.setNumber(personNumber+"");
		s.setRawsSeatName(destSeatName);
		s.setTargetSeatName(destSeatName);
		s.setSeatName(seatName);
		return s;
	}

	public static SettleAccounts convertSettleAccounts(PayParamsDTO payParamsDTO, boolean isPre) {
		String shop = payParamsDTO.getMaroClientServerorderDO().getRestaurantName();
		String cashier = payParamsDTO.getMaroClientServerorderDO().getCashierName();
		Integer guests = payParamsDTO.getMaroClientServerorderDO().getPersonNumber() == null ? 0 : payParamsDTO.getMaroClientServerorderDO().getPersonNumber();
		String  orderNum = payParamsDTO.getMaroClientServerorderDO().getCode();
		BigDecimal serviceCharge = payParamsDTO.getMaroClientServerorderDO().getServiceCharge();
		Long beginTime = payParamsDTO.getMaroClientServerorderDO().getBeginTime();
		String table = payParamsDTO.getMaroClientServerorderDO().getSeatNameList();
		if(table != null){
			table = table.substring(1);
			table = filterDuplicate(table);

			
		}
		String waiter = payParamsDTO.getMaroClientServerorderDO().getWaiterName();
		BigDecimal odd = payParamsDTO.getMaroClientServerorderDO().getSmallChange();
		Integer deposit = payParamsDTO.getMaroClientServerorderDO().getPayedDeposit();
		String discount = payParamsDTO.getMaroClientServerorderDO().getDiscount().doubleValue() == 1 ? "" : payParamsDTO.getMaroClientServerorderDO().getDiscount()+"";
		BigDecimal total = payParamsDTO.getMaroClientServerorderDO().getCollectedAmount();
		BigDecimal amount = payParamsDTO.getMaroClientServerorderDO().getAmount();
		String address = payParamsDTO.getMaroShopEntity().getPosition();
		String telphone = payParamsDTO.getMaroShopEntity().getPhone();
		
		String smallChange = payParamsDTO.getMaroClientServerorderDO().getSmallChange() == null ? "0":payParamsDTO.getMaroClientServerorderDO().getSmallChange()+"";
//		JSONArray list = new JSONArray();
//		for(int i=0;i<payParamsDTO.getMaroClientFoodorderDOList().size();i++){
//			JSONObject json = new JSONObject();
//			json.put("name",payParamsDTO.getMaroClientFoodorderDOList().get(i).getFoodName() + payParamsDTO.getMaroClientFoodorderDOList().get(i).getSpecificationsName());
//			json.put("number",payParamsDTO.getMaroClientFoodorderDOList().get(i).getQuantity());
//			json.put("price",payParamsDTO.getMaroClientFoodorderDOList().get(i).getTotalPrice());
//			list.add(json);
//		}
		
		List<MaroClientFoodorderDO> list_tmp = payParamsDTO.getMaroClientFoodorderDOList();
		List<SettleAccountsDishes> list = convertBatchSettleAccountsDishes(list_tmp);
	
		
		String dateTime = "";
		SettleAccounts s = new SettleAccounts();
		if(!isPre){
			Long l = payParamsDTO.getMaroClientPayedDO().getPayTime();
			dateTime = DateUtils.formatDate(new Date(l),DateUtils.datetimeFormat.toPattern());
			s.setTitleName("结账单");
			List<MaroClientPayedDetailVO> objects = PojoUtil.convertBatchDO2VO(payParamsDTO.getMaroClientPayedDetailDOList(),MaroClientPayedDetailVO.class);
			s.setObjects(objects);
		}else{
			s.setTitleName("预结单");
		}
		s.setBeginTime(DateUtils.formatTime(beginTime));
		s.setBillNumber(orderNum);
		s.setCashier(cashier);
		s.setDishesList(list);
		s.setAmountDeceivable(total+"");
//		s.setMember();
//		s.setMemberTotal();
		s.setRenShu(guests);
		s.setSeatName(table);
		s.setServiceCharge(serviceCharge+"");
		s.setWaiter(waiter);
		s.setZongJie(amount+"");
		s.setSettleTime(dateTime);
		s.setSmallChange(smallChange);
		s.setIsPre(isPre);
		
		return s;
	}
	
	public static SettleAccountsDishes convertSettleAccountsDishes(MaroClientFoodorderDO maroClientFoodorderDO){
		SettleAccountsDishes s = new SettleAccountsDishes();
//		s.setClassName(maroClientFoodorderDO.getType());
		s.setDishesName(maroClientFoodorderDO.getFoodName());
		s.setDishesPrice(maroClientFoodorderDO.getPrice()+"");
		s.setDishesType(EnumUtil.getName(FoodTypeEnum.class, maroClientFoodorderDO.getPackageType()));
		s.setRemark(maroClientFoodorderDO.getRemark());
		s.setShuLiang(maroClientFoodorderDO.getQuantity()+"");
//		s.setSpsList(spsList);
		s.setTotalMoney(maroClientFoodorderDO.getTotalPrice()+"");
		s.setUnit(maroClientFoodorderDO.getUnitName());
//		s.setVipPrice(vipPrice);
		s.setIsPresentDishes(EnumUtil.getName(FoodTypeEnum.class, maroClientFoodorderDO.getType()));
		//* 套餐类型，0未普通类型，1为套餐类型，2为套餐子类型
		s.setDishesType(ifStrNull(maroClientFoodorderDO.getPackageType()));
		s.setDishesClassification(maroClientFoodorderDO.getFoodTypeCode());
		if(maroClientFoodorderDO.getPackageType() != null && maroClientFoodorderDO.getPackageType().intValue() == FoodPackageTypeEnum.PACKAGE.getCode()){
			List<MaroClientFoodorderDO> list_tmp = maroClientFoodorderDO.getList();
			List<SettleAccountsDishes> list = convertBatchSettleAccountsDishes(list_tmp);
			s.setSpsList(list);
		}
		return s;
	}
	public static List<SettleAccountsDishes> convertBatchSettleAccountsDishes(List<MaroClientFoodorderDO> maroClientFoodorderDOs){
		List<SettleAccountsDishes> list = new ArrayList<SettleAccountsDishes>();
		if(maroClientFoodorderDOs != null && maroClientFoodorderDOs.size() > 0){
			for( int i=0;i<maroClientFoodorderDOs.size();i++){
				MaroClientFoodorderDO row = maroClientFoodorderDOs.get(i);
				SettleAccountsDishes row_tmp = convertSettleAccountsDishes(row);
				list.add(row_tmp);
			}
		}
		return list;
	}

	public static OrderSubmenu convertOrderSubmenu(FoodOrderParamsDTO foodOrderParamsDTO) {
		OrderSubmenu orderSubmenu = new OrderSubmenu();
		String remark = foodOrderParamsDTO.getMaroClientServerorderDO().getRemark();
		String seatName = foodOrderParamsDTO.getMaroClientServerorderDO().getSeatName();
		String waiterName = foodOrderParamsDTO.getMaroClientServerorderDO().getWaiterName();
		Integer personNumber = foodOrderParamsDTO.getMaroClientServerorderDO().getPersonNumber();
		String code = foodOrderParamsDTO.getMaroClientServerorderDO().getCode();
		String flag = foodOrderParamsDTO.getMaroShopSeatEntity().getName();

		List<MaroClientFoodorderDO> list_tmp = foodOrderParamsDTO.getMaroClientFoodorderDOList();
		List<SettleAccountsDishes> list = convertBatchSettleAccountsDishes(list_tmp);
		SingleReturnDishes s = new SingleReturnDishes();
		orderSubmenu.setBillMark(code);
		orderSubmenu.setDishesList(list);
		orderSubmenu.setNumber(personNumber+"");
//		orderSubmenu.setDeliveryTime();
		orderSubmenu.setOrderTime(DateUtils.formatTime());
		orderSubmenu.setWaiter(waiterName);
		orderSubmenu.setWholeRemark(remark);
		orderSubmenu.setRemark(remark);
		orderSubmenu.setFlag(flag);
		
		return orderSubmenu;
	}
	
	private static String ifStrNull(Object str){
		return str != null ? str.toString() : ""; 
	}

	public static FlyoutMenu convertFlyoutMenu(MaroClientServerorderDO serverorderDO, MaroClientFoodorderDO foodorderDO) {
		FlyoutMenu flyoutMenu = new FlyoutMenu();
		String remark = serverorderDO.getRemark();
		String seatName = serverorderDO.getSeatName();
		String code = serverorderDO.getCode();
		SettleAccountsDishes settleAccountsDishes = convertSettleAccountsDishes(foodorderDO);
		List<SettleAccountsDishes> list = new ArrayList<SettleAccountsDishes>();
		list.add(settleAccountsDishes);
		flyoutMenu.setBillMark(code);
		flyoutMenu.setDishesList(list);
		flyoutMenu.setRemark(remark);
		flyoutMenu.setSeatName(seatName);
		return flyoutMenu;
	}
	
	public static String filterDuplicate(String str){
		 Set<String> mlinkedset = new LinkedHashSet<String>();   
		 String[] strarray = str.split(",");   
		 StringBuffer sb = new StringBuffer();
		 for (int i = 0; i < strarray.length; i++)   
		 {   
		  if (!mlinkedset.contains(strarray[i]))   
		  {   
		   mlinkedset.add(strarray[i]);   
		   sb.append(strarray[i] + " ");   
		  }   
		 }   
		 return sb.toString().substring(0, sb.toString().length() - 1); 
	}
}
