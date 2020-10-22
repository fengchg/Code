package com.maro.manager.dishes.dishesclassification.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface MaroDishesClassificationDao {

	/* 查询编码是否存在
	 * @param coding
	 * @return
	 */
	@Arguments("coding")
	@Sql("select count(0) from maro_dishes_classification where classification_code = :coding")
	Integer checkCoding(String coding);
	
}
