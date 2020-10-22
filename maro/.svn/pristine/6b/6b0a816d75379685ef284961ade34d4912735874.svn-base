package com.maro.manager.store.storegoods.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.maro.manager.store.storegoods.entity.MaroStoreGoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 查询部门信息
 */
@Repository
public interface MaroStoreGoodsDao {
	@Arguments({"storeId","materialClassId"})
    @Sql("SELECT * FROM maro_store_goods t WHERE t.store_id = :storeId AND t.goods_id = :materialClassId")
	MaroStoreGoodsEntity getStoreGoodsByShopIdAndClassId(String storeId,
			String materialClassId);

	@Arguments({"storeId","goodsId"})
	List<Map> otherStoreHave(String storeId, String goodsId);
}
