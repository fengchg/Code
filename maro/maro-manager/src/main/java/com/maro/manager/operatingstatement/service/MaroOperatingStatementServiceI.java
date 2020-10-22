package com.maro.manager.operatingstatement.service;
import java.io.Serializable;

import com.maro.manager.operatingstatement.entity.MaroOperatingStatementEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroOperatingStatementServiceI extends CommonService{
	
 	public void delete(MaroOperatingStatementEntity entity) throws Exception;
 	
 	public Serializable save(MaroOperatingStatementEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroOperatingStatementEntity entity) throws Exception;
 	
}
