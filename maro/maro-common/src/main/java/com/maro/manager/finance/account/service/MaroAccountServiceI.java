package com.maro.manager.finance.account.service;

import java.io.Serializable;

import com.maro.common.finance.account.pojo.entity.MaroAccountEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroAccountServiceI extends CommonService{
	
 	public void delete(MaroAccountEntity entity) throws Exception;
 	
 	public Serializable save(MaroAccountEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroAccountEntity entity) throws Exception;
 	
}
