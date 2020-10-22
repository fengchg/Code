package com.maro.manager.dishes.materialclass.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface MaroMaterialClassDao {

	/**
	 * 查询编码是否存在
	 * @param coding
	 * @return
	 */
	@Arguments("coding")
	@Sql("select count(0) from maro_material_class where coding = :coding")
	Integer checkCoding(String coding);
}
