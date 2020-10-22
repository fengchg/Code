package com.maro.manager.maroprint.printtemplate.service;
import java.io.Serializable;
import java.util.Map;

import com.maro.manager.maroprint.printtemplate.entity.MaroPrintTemplateEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MarpPrintTemplateServiceI extends CommonService{
	
 	public void delete(MaroPrintTemplateEntity entity) throws Exception;
 	
 	public Serializable save(MaroPrintTemplateEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroPrintTemplateEntity entity) throws Exception;
 	
 	//获取打印机的ip port
 	public Map<String,Integer> getPrinterId(String printCode);
 	
}
