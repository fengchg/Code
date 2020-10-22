package com.maro.manager.dishes.specificationsfoodcosts.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

/**
 * Minidao例子
 * 
 */
@MiniDao
public interface MaroSpecificationsFoodCostsDao {
	
	@Arguments("specificationsId")
	@Sql("DELETE from maro_specifications_food_costs where SPECIFICATIONS_ID = :specificationsId")
	void deleteSpecificationsId(String specificationsId);
	
}
