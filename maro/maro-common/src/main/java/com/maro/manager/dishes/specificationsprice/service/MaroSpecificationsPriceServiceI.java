package com.maro.manager.dishes.specificationsprice.service;
import com.maro.manager.dishes.specificationsfoodcosts.page.MaroSpecificationsFoodCostsPage;
import com.maro.manager.dishes.specificationsprice.entity.MaroSpecificationsPriceEntity;
import com.maro.manager.dishes.specificationsprice.entity.SpecatinsPrice;
import com.maro.platform.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface MaroSpecificationsPriceServiceI extends CommonService{
	
 	public void delete(MaroSpecificationsPriceEntity entity) throws Exception;
 	
 	public Serializable save(MaroSpecificationsPriceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroSpecificationsPriceEntity entity) throws Exception;
 	
 	//根据规格id获取价格
 	public List<MaroSpecificationsPriceEntity> entityList(String specificationsId)throws Exception;
 	
 	//根据规格删除
 	public void deleteSpecificationsId(String specificationsId)throws Exception;
 	
 	/**
 	 * 修改价格
 	 */
 	public void updatePrice(SpecatinsPrice specatinsPrice);
 	
}
