package com.maro.manager.report.service.impl;

import com.maro.client.common.constant.enumconstant.ServerOrderStatusEnum;
import com.maro.common.constant.StoreFlowConstant;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.maroprint.printtemplate.service.MarpPrintTemplateServiceI;
import com.maro.manager.print.controller.PrintMain;
import com.maro.manager.print.entity.ShiftingOfDuty;
import com.maro.manager.report.dao.ReportDao;
import com.maro.manager.report.service.ReportServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;

@Service("reportService")
@Transactional
public class ReportServiceImpl extends CommonServiceImpl implements
		ReportServiceI {
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private UtilServiceI utilService;
	@Autowired
	private MarpPrintTemplateServiceI marpPrintTemplateService;
	@Override
	public Map getMaterialHistoryUseInfo(String purchaseId,String shopId) {
		List<Map> list=reportDao.getPurchaseDetail(purchaseId);
		double max=0;
		Map result=new HashMap();
		List ids=new ArrayList();
		List names=new ArrayList();
		List planNumbers=new ArrayList();
		List useNumbers=new ArrayList();
		for(Map m:list){
			ids.add(m.get("classId"));
			names.add(m.get("name"));
			if(m.get("type").toString().equals("0")){
				planNumbers.add(Double.valueOf(m.get("number").toString())*Double.valueOf(m.get("scattered").toString()));
			}else{
				planNumbers.add(m.get("number"));
			}
		}
		List<Map> maps=reportDao.getMonthUseInfo(ids,shopId);
		for(Object id:ids){
			boolean hava=false;
			for(Map m:maps){
				String classid=m.get("classid").toString();
				if(classid.equals(id.toString())){
					useNumbers.add(m.get("avgnum"));
					hava=true;
					break;
				}
			}
			if(!hava){
				useNumbers.add(0);
			}
		}
		//获取最大值
		for(Object o:planNumbers){
			if(Double.valueOf(o.toString())>max){
				max=Double.valueOf(o.toString());
			}
		}
		for(Object o:useNumbers){
			if(Double.valueOf(o.toString())>max){
				max=Double.valueOf(o.toString());
			}
		}
		max= (int) (max*1.5);
		result.put("names",names);
		result.put("planNumbers",planNumbers);
		result.put("useNumbers",useNumbers);
		result.put("max",max);
		return result;
	}

	@Override
	public List<Map> getMaterialUseInfo(String startTime, String endTime,String shopId) {
		//1.查询原料的实际消耗
		List<Map> realMap=reportDao.getMaterialRealUseInfo(startTime,endTime,shopId, StoreFlowConstant.OUTSTORE);
		//2.查询原料的预计消耗
		List<Map> planMap=reportDao.getMaterialPlanUseInfo(startTime,endTime,shopId,ServerOrderStatusEnum.FINISH.getCode());
		//3.map合并
		for(Map plan:planMap){
			boolean have=false;
			String planname = plan.get("name").toString();
			for(Map real:realMap){
				if(planname.equals(real.get("name").toString())){
					have=true;
					plan.put("realnum",real.get("realnum"));
					break;
				}
			}
			if(!have){
				plan.put("realnum",0);
			}
		}
		//4.计算预计和实际消耗是否超过阈值
		for(Map plan:planMap){
			//计划消耗值
			Object plannum = plan.get("plannum");
			//实际消耗值
			Object realnum = plan.get("realnum");
			//设定的阈值
			Object threshold = plan.get("threshold");
			if(threshold!=null){
				if(realnum!=null){
					if(Double.valueOf(realnum.toString())>Double.valueOf(plannum.toString())*Double.valueOf(threshold.toString())){
						plan.put("warning",true);
					}else{
						plan.put("warning",false);
					}
				}else{
					plan.put("warning",false);
				}
			}else{
				plan.put("warning",false);
			}
		}
		return planMap;
	}

	@Override
	public boolean printBusReport(String shiftCode, String name, String userId) {
			//控制台输出对象
			StringBuffer s=new StringBuffer();
			//交班表信息实体
			ShiftingOfDuty shiftingOfDuty=new ShiftingOfDuty();
			//获取店铺名称
			String shopName="";
			//店铺地址
			String address="";
			//店铺电话
			String phone="";
			//通过用户id获取该用户所属店铺信息
			MaroShopEntity maroShop=utilService.getShopInfoByUserId(userId);
			if(maroShop!=null){
				shopName=maroShop.getName()==null?"":maroShop.getName();
				s.append(shopName).append("\r\n");//店铺名称
				shiftingOfDuty.setShopName(shopName);
				address=maroShop.getPosition()==null?"":maroShop.getPosition();
				shiftingOfDuty.setPosition(address);
				phone=maroShop.getPhone()==null?"":maroShop.getPhone();
				shiftingOfDuty.setPhone(phone);
			}
			//获取班次中文名称
			String shiftName = Util.getValueFromTypeByTypeCodeAndKey("maro_shift", shiftCode);
			//获取该收银员的登录时间
			Map loginTime=reportDao.getLoginTime(userId,shiftCode);
			//获取基本消费信息
			List<Map> baseInfo=reportDao.getBaseInfos(shiftCode);
			if(baseInfo==null||baseInfo.size()==0){
				return false;
			}
			//获取菜品销售信息（种类、名称、数量、金额）
			List<Map> menuInfo=reportDao.getMenuInfos(shiftCode);
			//获取分区域消费等信息（1楼、2月消费信息等）
			List<Map> areaInfo=reportDao.getAreaInfo(shiftCode);
			//获取本班收款信息
			List<Map> shouKuangInfo=reportDao.getShouKuangInfo(shiftCode);
			//获取抹零信息
			Map smallInfo=reportDao.getSmallInfo(shiftCode);
			//解析数据获取消费台数、消费人数、人均消费、单均消费、应收、实收
			List<Map> rootInfo=getRootInfo(baseInfo);
			s.append("【交接班】").append("\r\n");
			s.append("班次：\t").append(shiftName).append("\r\n");
			shiftingOfDuty.setClassNext(shiftName);
			s.append("交班人：\t").append(name).append("\r\n");
			shiftingOfDuty.setName(name);
			s.append("开始时间：\t").append(loginTime.get("login_time")).append("\r\n");
			shiftingOfDuty.setStartTime(loginTime.get("login_time").toString());
			s.append("结束时间：\t").append(Util.date2TimeStr(new Date(),"yyyy-MM-dd HH:mm:ss")).append("\r\n");
			shiftingOfDuty.setEndTime(Util.date2TimeStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
			for(Map map:rootInfo){//基础消费信息
				s.append(map.get("name")+"：\t").append(map.get("value")).append("\r\n");
			}
			shiftingOfDuty.setRootInfo(rootInfo);
			for(Map map:areaInfo){//区域消费
				s.append(map.get("typename")+"：\t").append(map.get("amount")).append("\r\n");
			}
			shiftingOfDuty.setAreaInfo(areaInfo);
			s.append("---------------------------").append("\r\n");//分割线
			for(Map map:shouKuangInfo){//各种支付方式
				s.append(map.get("payname")+"：\t").append(map.get("num")+"：\t").append(map.get("amountpart")).append("\r\n");
			}
			shiftingOfDuty.setShouKuangInfo(shouKuangInfo);
			s.append("---------------------------").append("\r\n");//分割线
			String foodType="";//菜品种类
			double totalPrice=0.0;//总价
			StringBuffer tmp=new StringBuffer();
			for(Map map:menuInfo){//菜品消费信息
				String food_type = map.get("food_type")==null?"":map.get("food_type").toString();
				String food_name = map.get("food_name")==null?"":map.get("food_name").toString();
				String num = map.get("num")==null?"":map.get("num").toString();
				String total_price = map.get("total_price")==null?"":map.get("total_price").toString();
				if(!foodType.equals(food_type)){
					if(tmp.length()>0){//buffer中有数据时
						s.append(foodType+"\t").append(totalPrice).append("\r\n");
						s.append(tmp.toString());
						s.append("---------------------------").append("\r\n");//分割线
					}
					foodType=food_type;
					totalPrice=Double.valueOf(total_price);
					tmp.setLength(0);//清空buffer
					tmp.append(food_name+"\t").append(num+"\t").append(total_price).append("\r\n");
				}else{
					totalPrice+=Double.valueOf(total_price);
					tmp.append(food_name+"\t").append(num+"\t").append(total_price).append("\r\n");
				}
			}
			shiftingOfDuty.setMenuInfo(menuInfo);
			s.append("\r\n");
			s.append("\r\n");
			s.append("交班人：").append(name+"\t").append("交班人签字："+"\t").append("\r\n");
			
			//获得打印机的ip port
			Map<String,Integer> map = marpPrintTemplateService.getPrinterId("printShiftingOfDuty");
			for (Entry<String, Integer> vo : map.entrySet()) {
    			//System.out.println(vo.getKey() + "  " + vo.getValue());
				shiftingOfDuty.setPrinterIp(vo.getKey());
				shiftingOfDuty.setPrinterPort(vo.getValue());
    		}
			//交给打印机进行打印
			PrintMain.printShiftingOfDuty(shiftingOfDuty);

			//System.out.println(s.toString());
			//将订单表中的班次检查置位1
			//reportDao.setCheckOfServerOrder(ServerOrderConstant.CHECK,shiftCode);
			//将maro_client_shift表中你的检查置位1
			//reportDao.setCheckClientShift(ClientShiftConstant.CHECK,shiftCode);
			return true;
	}

	@Override
	public Map getShiftInfo(String shiftCode, String name, String userId) {
			Map map=new HashMap();
			//获取班次中文名称
			String shiftName = Util.getValueFromTypeByTypeCodeAndKey("maro_shift", shiftCode);
			//获取该收银员的登录时间
			Map loginTime=reportDao.getLoginTime(userId,shiftCode);
			//获取本班收款情况
			List<Map> shouKuangInfo=reportDao.getShouKuangInfo(shiftCode);
			//获取基本消费信息
			List<Map> baseInfos=reportDao.getBaseInfos(shiftCode);
			//获取本班营业情况
			List<Map> rootInfo=getRootInfo(baseInfos);//解析数据获取消费台数、消费人数、人均消费、单均消费、应收、实收
			//获取应收和实收
			getYsAndSs(baseInfos,map);
			//获取本班会员情况
			//TODO
			map.put("name",name);
			map.put("loginTime",loginTime==null?null:loginTime.get("login_time"));
			map.put("nowTime",new Timestamp(new Date().getTime()));
			map.put("shiftName",shiftName);
			map.put("bbskqk",shouKuangInfo);
			map.put("bbyyqk",rootInfo);
			map.put("bbhyqk",null);
			return map;
	}

	/**
	 * 获取应收和实收
	 * @param baseInfos
	 * @param map
	 */
	private void getYsAndSs(List<Map> baseInfos, Map map) {
		double ysje=0;//应收金额
		double ssje=0;//实收金额
		for(Map m:baseInfos){
			ysje=ysje+Double.valueOf(m.get("amount")==null?"0":m.get("amount").toString());
			ssje=ssje+Double.valueOf(m.get("collected_amount")==null?"0":m.get("collected_amount").toString());
		}
		map.put("ysje",ysje);
		map.put("ssje",ssje);
	}

	/**
	 * 获取消费台数、消费人数、人均消费、单均消费、应收、实收、分区域消费等信息
	 * @param baseInfo
	 * @return
	 */
	private List<Map> getRootInfo(List<Map> baseInfo) {
		List list=new ArrayList();
		int xfts=0;//消费台数
		int xfrs=0;//消费人数
		int rjxf=0;//人均消费
		int djxf=0;//单均消费
		double mlje=0;//抹零金额
		double ysje=0;//应收金额
		double ssje=0;//实收金额
		//解析数据
		for(Map m:baseInfo){
			xfts++;
			xfrs=xfrs+Integer.valueOf(m.get("person_number")==null?"0":m.get("person_number").toString());
			ysje=ysje+Double.valueOf(m.get("amount")==null?"0":m.get("amount").toString());
			//ssje=ssje+Double.valueOf(m.get("collected_amount")==null?"0":m.get("collected_amount").toString());
			mlje=mlje+Double.valueOf(m.get("small_change")==null?"0":m.get("small_change").toString());
			ssje=ysje-mlje;
		}
		if(xfrs!=0){
			rjxf=(int)ysje/xfrs;
		}
		if(xfts!=0){
			djxf=(int)ysje/xfts;
		}
		Map map=new HashMap();
		map.put("name","消费单数");
		map.put("value",xfts);
		Map map2=new HashMap();
		map2.put("name","消费人数");
		map2.put("value",xfrs);
		Map map3=new HashMap();
		map3.put("name","人均消费");
		map3.put("value",rjxf);
		Map map4=new HashMap();
		map4.put("name","单均消费");
		map4.put("value",djxf);
		Map map5=new HashMap();
		map5.put("name","应收金额");
		map5.put("value",ysje);
		Map map6=new HashMap();
		map6.put("name","实收金额");
		map6.put("value",ssje);
		Map map7=new HashMap();
		map7.put("name","抹零金额");
		map7.put("value",mlje);
		list.add(map);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		list.add(map6);
		list.add(map7);
		return list;
	}
}