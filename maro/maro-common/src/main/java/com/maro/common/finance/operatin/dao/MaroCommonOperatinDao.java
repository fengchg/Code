package com.maro.common.finance.operatin.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
/**
 * 公共查询层
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
@Repository
public interface MaroCommonOperatinDao {
	
	@Arguments("departId")
	@Sql("SELECT * FROM maro_shop WHERE depart_id = :departId LIMIT 0,1")
	MaroShopEntity getMaroShopByDepartId(String departId);

}
