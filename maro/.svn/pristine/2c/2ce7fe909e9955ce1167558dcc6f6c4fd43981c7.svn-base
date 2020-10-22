package com.maro.manager.shop.reserve.service;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.maro.manager.shop.reserve.entity.MaroClientReserveEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroClientReserveServiceI extends CommonService{
	
 	public void delete(MaroClientReserveEntity entity) throws Exception;
 	
 	public Serializable save(MaroClientReserveEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroClientReserveEntity entity) throws Exception;
 	/**
	 * 根据预定时间和预定时段获取满足条件的座位信息
	 * @param request
	 * @param shopId 店铺id
	 * @param reserveTime 预定时间
	 * @param period 时段
	 * @param personNumber 就餐人数
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年4月17日
	 * @version
	 */
	public List<Map> listSeat(String shopId, Date reserveTime, String period,Integer personNumber);
 	
}
