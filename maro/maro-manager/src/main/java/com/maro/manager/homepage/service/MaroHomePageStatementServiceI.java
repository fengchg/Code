package com.maro.manager.homepage.service;
import java.util.List;
import java.util.Map;

import com.maro.manager.homepage.entity.PeiVo;
import com.maro.platform.core.common.service.CommonService;

public interface MaroHomePageStatementServiceI extends CommonService{
	
 	
 	
 	/**
 	 * 首页营业额
 	 * @return
 	 * 店铺id
 	 */
 	public Map businessVolume(String shopId);
 	
 	/**
 	 * 首页营业额-柱状图
 	 * @return
 	 * tynData时间
 	 */
 	public List<Map> turnoverHistogram(String tynData,String shopId);
 	public List<Map> monthTurnoverHistogram(String tynData,String shopId);
 	public List<Map> yearTurnoverHistogram(String tynData,String shopId);
 	
 	/**
 	 * 菜品（堂食）  
 	 * 首页营业额 - 饼图
 	 */
 	public List<PeiVo> turnoverPie(String shopId);
 	
}
