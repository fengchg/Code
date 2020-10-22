package com.maro.manager.homepage.controller;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.manager.homepage.entity.PeiVo;
import com.maro.manager.homepage.entity.StatementVo;
import com.maro.manager.homepage.service.MaroHomePageStatementServiceI;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller
 * @Description: 套餐
 * @author onlineGenerator
 * @date 2018-08-28 15:57:34
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/maroHomePageStatementController")
public class MaroHomePageStatementController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroHomePageStatementController.class);

	@Autowired
	private MaroHomePageStatementServiceI homePageStatementService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	//临时替换
	private String ymd_subscript[];
	private double receivable_amount[];
	private double collected_amount[];
	
	//======================首页营业报表 begin========================================
	
	/**
	 * 获取全部的列表
	 *
	 * @return
	 */
	@RequestMapping(params = "getPeiList")
	@ResponseBody
	public AjaxJson getPeiList(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String org_id = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		MaroShopEntity ms = homePageStatementService.findUniqueByProperty(MaroShopEntity.class,"departId",org_id);
		List<PeiVo> peiList = homePageStatementService.turnoverPie(ms.getId());
		j.setObj(peiList);
		return j;
	}
	
	/**
	 * //柱状图-点击天月年
	 * @param ymd
	 * @return
	 */
	@RequestMapping(params = "getYmdDateHistogram")
	@ResponseBody
	public AjaxJson getYmdDateHistogram(int ymd,String tynData) {
		AjaxJson j = new AjaxJson();
		try{
			StatementVo svo = new StatementVo();
			
			getYmdReceivableCollected(ymd,tynData);
			
			svo.setHour(ymd_subscript);
			svo.setReceivable_amount(receivable_amount);
			svo.setCollected_amount(collected_amount);
			
			j.setObj(svo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return j;
	}
	
	//替换  天月年 柱状图的数据
	public void getYmdReceivableCollected(int ymd,String tynData){
		
		String org_id = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		MaroShopEntity ms = homePageStatementService.findUniqueByProperty(MaroShopEntity.class,"departId",org_id);
		
		List<Map> turnover_Histogram = new ArrayList<Map>();
		
		if(ymd==3){
			tynData += "-01-01";
			turnover_Histogram = homePageStatementService.yearTurnoverHistogram(tynData,ms.getId());
			
			ymd_subscript = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
			receivable_amount = new double[12];
			collected_amount = new double[12];
			
		}else if(ymd==2){
			tynData += "-01";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//Date date = new Date();
			Date date = null;
			try {
				date = sdf.parse(tynData);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int m = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			receivable_amount = new double[m];
			collected_amount = new double[m];
			
			ymd_subscript = new String[m];
			for(int i=1;i<=m;i++){
				if(i<10){
					ymd_subscript[i-1] = "0"+i;
				}else if(i>=10){
					ymd_subscript[i-1] = String.valueOf(i);
				}
			}
			
			turnover_Histogram = homePageStatementService.monthTurnoverHistogram(tynData,ms.getId());

		}else if(ymd==1){
			turnover_Histogram = homePageStatementService.turnoverHistogram(tynData,ms.getId());
			//ymd_subscript = hour;
			//receivable_amount = hour_receivable_amount;
			//collected_amount = hour_collected_amount;
			
			//24小时
			ymd_subscript = new String[]{"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
			//应收金额
			receivable_amount = new double[24];
			//实收金额
			collected_amount = new double[24];
			
		}
		
		for(int h=0;h<ymd_subscript.length;h++){ //先循环时间
			String fhour =ymd_subscript[h];
			//if(turnover_Histogram.size() > 0){
			  th : for (int i = 0; i < turnover_Histogram.size(); i++) { // 在循环数据里得到是时间 
					 Map map = turnover_Histogram.get(i);
					 String hour_time = map.get("hour_time").toString();
					 if(hour_time.equals(fhour)){ // 如果 24小时里的某一时间等于数据库里的小时  
						 receivable_amount[h] = Double.valueOf(map.get("receivable_amount").toString());
						 collected_amount[h] = Double.valueOf(map.get("collected_amount").toString());
						 break th;
					 }
				}
			//}
		}
		
	}
	
	//首页营业报表
	@RequestMapping(params = "getStatisticalTurnover")
	@ResponseBody
	public AjaxJson getStatisticalTurnover(int ymd,String tynData) {
		AjaxJson j = new AjaxJson();
		try{
			StatementVo svo = new StatementVo();

			//================日周月营业额============================
			String org_id = ResourceUtil.getSessionUser().getCurrentDepart().getId();
			MaroShopEntity ms = homePageStatementService.findUniqueByProperty(MaroShopEntity.class,"departId",org_id);
			Map turnover_data = homePageStatementService.businessVolume(ms.getId());
			svo.setShopName(turnover_data.get("shop_name").toString());
			svo.setToday(turnover_data.get("today").toString());
			svo.setThis_month(turnover_data.get("this_month").toString());
			svo.setThis_week(turnover_data.get("this_week").toString());
			
			//===============首页营业额-柱状图=======================
			
			getYmdReceivableCollected(ymd,tynData);
			
			svo.setHour(ymd_subscript);
			svo.setReceivable_amount(receivable_amount);
			svo.setCollected_amount(collected_amount);
			
			//================首页营业额 - 饼图====================
			
			Map<String,Double> peiMap = new HashMap<String, Double>();
			//peiMap.put("鸿鹤鲜锅兔小份", 0.78);
			//peiMap.put("爆款2-3人套餐", 26.8);
			//peiMap.put("鸿鹤鲜锅兔大份", 12.8);
			//peiMap.put("麻辣兔头", 8.5);
			//peiMap.put("香卤兔头", 6.2);
			//peiMap.put("鸿鹤冷吃兔*250g*", 45.7);
			//svo.setPeiCollectedAmount(peiMap);
			
			List<PeiVo> peiList = homePageStatementService.turnoverPie(ms.getId());
			List<PeiVo> x_peiList = new ArrayList<PeiVo>();
			
			//前端显示列表数
			int x_num = 7;
			//--其它 总和 实收占比
			DecimalFormat dFormat =new DecimalFormat("#.00");
			Double qita = 0.0;
			//--其它 总和  消费笔数
			Integer frequency_quantity = 0;
			//--其它 总和 消费总额
			Double frequency_amount = 0.0;
			
			for (int i = 0; i < peiList.size(); i++) {
				if(i<x_num){
					peiMap.put(peiList.get(i).getDishes_name(), peiList.get(i).getPaid_in_proportion());
					x_peiList.add(peiList.get(i));
				}else if(i>=7){
					qita += peiList.get(i).getPaid_in_proportion();
					frequency_quantity += peiList.get(i).getFrequency_quantity();
					frequency_amount += peiList.get(i).getFrequency_amount();
				}
				//System.out.println(peiList.get(i).getDishes_name()+"==="+peiList.get(i).getPaid_in_proportion());
			}
			
			//添加其他
			PeiVo qitaEntity = new PeiVo();
			qitaEntity.setDishes_name("其它");
			qitaEntity.setFrequency_quantity(frequency_quantity);
			qitaEntity.setFrequency_amount(frequency_amount);
			qitaEntity.setPaid_in_proportion(Double.valueOf(dFormat.format((qita))));
			x_peiList.add(qitaEntity);
			
			svo.setPeiList(x_peiList);
			peiMap.put("其他",qita);
			svo.setPeiCollectedAmount(peiMap);
			
			j.setObj(svo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return j;
	}
	
	//======================首页营业报表 end========================================

}
