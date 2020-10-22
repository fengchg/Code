package com.maro.manager.dishes.materialclassification.service;

import java.io.Serializable;

import com.maro.manager.dishes.materialclassification.entity.MaroMaterialClassificationEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroMaterialClassificationServiceI extends CommonService{
	
 	public void delete(MaroMaterialClassificationEntity entity) throws Exception;
 	
 	public Serializable save(MaroMaterialClassificationEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroMaterialClassificationEntity entity) throws Exception;
 	
}
