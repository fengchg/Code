package com.maro.manager.store.storegoods.service;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;
import com.maro.manager.store.storegoods.entity.MaroStoreGoodsEntity;
import com.maro.platform.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface MaroStoreGoodsServiceI extends CommonService{
	
 	public void delete(MaroStoreGoodsEntity entity) throws Exception;
 	
 	public Serializable save(MaroStoreGoodsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroStoreGoodsEntity entity) throws Exception;
 	/**
 	 * 将一条采购原料信息增加入库
 	 * @param maroPurchaseDetail 采购原料对象
 	 * @param maroMaterialClassEntity 原料详情对象
 	 * @return 成功true，失败false
 	 * @author gongdaohai
 	 * @since v1.0,2018年5月4日
 	 * @version
 	 */
	public boolean putInStore(MaroPurchaseDetailEntity maroPurchaseDetail, MaroMaterialClassEntity maroMaterialClassEntity);

	/**
	 * 将原料出库
	 * @param maroPurchaseDetail 采购原料对象
	 * @return 成功true，失败false
 	 * @author gongdaohai
 	 * @since v1.0,2018年5月4日
 	 * @version
	 */
	public boolean putOutStore(MaroPurchaseDetailEntity maroPurchaseDetail);

	/**
	 * 通过仓库id和原料id获取唯一信息
	 * @param storeId
	 * @param goodsId
	 * @return
	 */
	MaroStoreGoodsEntity getEntityByStoreIdAndGoodsId(String storeId, String goodsId);

	/**
	 * 通过原料id和仓库id查询该原料存在的其他仓库名称
	 * @param materialClassId
	 * @param storeId
	 * @return
	 */
	List<Map> otherStoreHave(String materialClassId, String storeId);
}
