package com.maro.manager.store.storeflow.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 查询部门信息
 */
@Repository
public interface MaroStoreFlowDao {
    @Arguments({"labelCode","shopId"})
    @Sql("SELECT t.number,t.store_id storeId,(SELECT m.`name` from maro_shop_store m where m.id=t.store_id) storeName  FROM maro_store_goods t WHERE t.store_id IN ( SELECT c.id FROM maro_shop_store c WHERE c.shop_id = :shopId ) AND t.goods_id = ( SELECT t1.id FROM maro_material_class t1 WHERE t1.coding = :labelCode )")
    List<Map> getMaterialNumber(String labelCode, String shopId);

	@Arguments({"labelCode","shopId"})
	Map getMaterialInfo(String labelCode, String shopId);
}
