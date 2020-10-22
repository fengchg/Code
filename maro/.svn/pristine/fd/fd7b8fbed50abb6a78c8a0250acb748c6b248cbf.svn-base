package com.maro.manager.groupdiscount.service;

import com.maro.manager.groupdiscount.entity.MaroGroupDiscountEntity;
import com.maro.platform.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface MaroGroupDiscountServiceI extends CommonService {
	
 	public void delete(MaroGroupDiscountEntity entity) throws Exception;
 	
 	public Serializable save(MaroGroupDiscountEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroGroupDiscountEntity entity) throws Exception;

	/**
	 * 通过店铺id获取团购优惠券信息
	 * 当shopId为null时，查询所有店铺的团购优惠券信息
	 * @param shopId
	 * @return
	 */
 	public List<Map> getGroupDiscounts(String shopId);
}
