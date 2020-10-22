package com.maro.manager.store.purchasedetail.service;
import java.io.Serializable;

import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroPurchaseDetailServiceI extends CommonService{
	
 	public void delete(MaroPurchaseDetailEntity entity) throws Exception;
 	
 	public Serializable save(MaroPurchaseDetailEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroPurchaseDetailEntity entity) throws Exception;
 	/**
 	 * 通过采购详情id获取该采购信息是否已经入库
 	 * @param id
 	 * @param iN_STORE 已入库
 	 * @return 符合为true，不符合false
 	 * @author gongdaohai
 	 * @since v1.0,2018年5月4日
 	 * @version
 	 */
	public boolean checkIsPutInStore(String id, Integer iN_STORE);

    void doUpdate(String labelCode, String shopId, Integer inStore, Integer storeIn, MaroPurchaseDetailEntity maroPurchaseDetail) throws Exception;
}
