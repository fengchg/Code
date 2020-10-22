package com.maro.manager.homepage.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;

import com.maro.manager.homepage.entity.PeiVo;

@MiniDao
public interface MaroHomePageStatementDao {

	/**
	 * 首页营业额
	 * @param specificationsId
	 */
	@Arguments("shopId")
	Map getStatisticalTurnover(String shopId);
	/**
	 * 首页营业额-柱状图
	 * @param specificationsId
	 */
	@Arguments({"tynData","shopId"})
	List<Map> turnoverHistogram(String tynData,String shopId);
	@Arguments({"tynData","shopId"})
	List<Map> monthTurnoverHistogram(String tynData,String shopId);
	@Arguments({"tynData","shopId"})
	List<Map> yearTurnoverHistogram(String tynData,String shopId);
	
	/**
	 * 首页营业额 - 饼图
	 * @param specificationsId
	 */
	@Arguments("shopId")
	List<PeiVo> turnoverPie(String shopId);
	
	
	

}
