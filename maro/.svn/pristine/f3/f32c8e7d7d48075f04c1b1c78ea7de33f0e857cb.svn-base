package com.maro.manager.specialoffer.service;

import com.maro.manager.specialoffer.entity.MaroSpecialOfferEntity;
import com.maro.platform.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface MaroSpecialOfferServiceI extends CommonService {
	
 	public void delete(MaroSpecialOfferEntity entity) throws Exception;
 	
 	public Serializable save(MaroSpecialOfferEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroSpecialOfferEntity entity) throws Exception;

	/**
	 * 通过店铺id获取该店铺的活动详情(买几送几)
	 * 当店铺id为null时，查询所有店铺的活动详情
	 * @param shopId
	 * @return
	 */
 	public List<Map> getOfferDetail(String shopId);
}
