package com.maro.platform.web.system.service;
import java.io.Serializable;

import com.maro.platform.core.common.service.CommonService;
import com.maro.platform.web.system.enums.InterfaceEnum;
import com.maro.platform.web.system.pojo.base.InterfaceRuleDto;
import com.maro.platform.web.system.pojo.base.TSInterfaceEntity;

public interface TSInterfaceServiceI extends CommonService{
	
 	public void delete(TSInterfaceEntity entity) throws Exception;
 	
 	public Serializable save(TSInterfaceEntity entity ) throws Exception;
 	
 	public void saveOrUpdate( TSInterfaceEntity entity) throws Exception;
 	
 	public InterfaceRuleDto getInterfaceRuleByUserNameAndCode(String userName,InterfaceEnum interfaceEnum);
 	
}
