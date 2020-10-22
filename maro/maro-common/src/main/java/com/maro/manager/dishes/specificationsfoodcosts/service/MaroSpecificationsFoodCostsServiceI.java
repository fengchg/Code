package com.maro.manager.dishes.specificationsfoodcosts.service;
import java.io.Serializable;
import java.util.List;

import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.manager.dishes.specificationsfoodcosts.page.MaroSpecificationsFoodCostsPage;
import com.maro.platform.core.common.service.CommonService;

public interface MaroSpecificationsFoodCostsServiceI extends CommonService{
	
 	public void delete(MaroSpecificationsFoodCostsEntity entity) throws Exception;
 	
 	public Serializable save(MaroSpecificationsFoodCostsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroSpecificationsFoodCostsEntity entity) throws Exception;
 	
 	/**
 	 * 根据规格id获取成本列表
 	 */
 	public List<MaroSpecificationsFoodCostsEntity> getSpecificationsIdList(String specificationsId)throws Exception;
 	
 	/**
 	 * 根据规格id删除
 	 */
 	public void deleteSpecificationsId(String specificationsId)throws Exception;
 	
 	/**
	 * 添加一对多
	 * 
	 */
	//public void addMain(MaroSpecificationsFoodCostsPage maroSpecificationsFoodCostsPage) ;
 	
 	/**
 	 * 添加规格成分
 	 */
 	public void addOrUpate(MaroSpecificationsFoodCostsPage maroSpecificationsFoodCostsPage);
 	
}
