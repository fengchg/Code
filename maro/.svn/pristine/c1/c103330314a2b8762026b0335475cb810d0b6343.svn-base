package com.maro.manager.dishes.specificationsprice.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

/**
 * 公共查询层
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
@Repository
public interface MaroSpecificationsPriceDao {
	
	@Arguments("specificationsId")
	@Sql("DELETE FROM maro_specifications_price WHERE specifications_id = :specificationsId")
	void deleteSpecificationsId(String specificationsId);




}
