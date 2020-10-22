package com.maro.platform.web.system.service;
import java.io.Serializable;

import com.maro.platform.core.common.service.CommonService;
import com.maro.platform.web.system.pojo.base.MaroMqSynchronousEntity;

public interface MaroMqSynchronousServiceI extends CommonService{
	
 	public void delete(MaroMqSynchronousEntity entity) throws Exception;
 	
 	public Serializable save(MaroMqSynchronousEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroMqSynchronousEntity entity) throws Exception;
 	
 	/**
 	 * 判断是否有此店铺，用于是否要把消息放入队例，假如没有店铺说明没有 队例的code
 	 */
 	public Integer ifShopIsExist(String[] departId);
 	
}
