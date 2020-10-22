package com.maro.manager.store.storeflow.service;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;
import com.maro.manager.store.storeflow.entity.MaroStoreFlowEntity;
import com.maro.platform.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface MaroStoreFlowServiceI extends CommonService{
	
 	public void delete(MaroStoreFlowEntity entity) throws Exception;
 	
 	public Serializable save(MaroStoreFlowEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroStoreFlowEntity entity) throws Exception;
 	/**
 	 * 通过原料采购信息增加一条流水信息
 	 * @param maroPurchaseDetail 原料采购信息对象
 	 * @param maroMaterialClassEntity 原料详细信息
 	 * @param shopId 店铺id
 	 * @param labelCode 标签码
 	 * @param iN_STORE 出入库状态
 	 * @return 成功为true，失败为false
 	 * @author gongdaohai
 	 * @since v1.0,2018年5月4日
 	 * @version
 	 */
	public boolean addFlow(MaroPurchaseDetailEntity maroPurchaseDetail, MaroMaterialClassEntity maroMaterialClassEntity, String shopId, String labelCode, Integer iN_STORE);
	/**
	 * 根据店铺id和标签码获取该标签对应的原料库存信息
	 * @param labelCode 标签码
	 * @param shopId 店铺id
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月9日
	 * @version
	 */
	public List<Map> getMaterialInfo(String labelCode, String shopId);

    void doAdd(String comeFrom, MaroStoreFlowEntity maroStoreFlow) throws Exception;
}
