package com.maro.manager.store.purchase.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;

import java.util.List;
import java.util.Map;

/**
 * 查询部门信息
 */
@Repository
public interface MaroPurchaseDao {
    @Arguments({"purchaseId","is_in_store"})
    @Sql("SELECT t.material_class_id id, t1.material_name text FROM maro_purchase_detail t, maro_material_class t1 WHERE t.material_class_id = t1.id AND t.purchase_id =:purchaseId AND (t.is_in_store is null or t.is_in_store !=:is_in_store)")
	public List<Map> getNoPutInGoods(String purchaseId,Integer is_in_store);
    
    @Arguments({"purchaseId","goodsId","is_in_store"})
    @Sql("SELECT t.material_class_id id, t1.material_name text FROM maro_purchase_detail t, maro_material_class t1 WHERE t.material_class_id = t1.id AND t.purchase_id =:purchaseId AND (t.is_in_store is null or t.is_in_store !=:is_in_store)")
	public int changeIsInStore(String purchaseId, String goodsId,
			Integer is_in_store);
}
