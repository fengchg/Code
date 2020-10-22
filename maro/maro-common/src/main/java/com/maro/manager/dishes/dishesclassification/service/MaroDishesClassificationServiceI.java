package com.maro.manager.dishes.dishesclassification.service;

import java.io.Serializable;

import com.maro.common.dishes.dishes.pojo.entity.MaroDishesClassificationEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroDishesClassificationServiceI extends CommonService{
	
 	public void delete(MaroDishesClassificationEntity entity) throws Exception;
 	
 	public Serializable save(MaroDishesClassificationEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroDishesClassificationEntity entity) throws Exception;
 	
 	/**
 	 * 检查是是否有此编码
 	 * @param coding
 	 * @return
 	 */
 	public Integer checkCoding(String coding);
 	
}
