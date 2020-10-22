package com.maro.platform.web.system.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

@Repository("maroMqSynchronousDao")
public interface MaroMqSynchronousDao {

	@Arguments("departId")
	@Sql("select count(0) from maro_shop where depart_id = :departId")
	Integer ifShopIsExist(String departId);
	
}
