package com.maro.manager.discount.service;


import com.maro.manager.discount.entity.MaroDishesDiscountEntity;
import com.maro.manager.discountdetail.entity.MaroDishesDiscountDetailEntity;
import com.maro.platform.core.common.service.CommonService;

import java.util.List;
import java.util.Map;

public interface MaroDishesDiscountServiceI extends CommonService {
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(MaroDishesDiscountEntity maroDishesDiscount,
	        List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(MaroDishesDiscountEntity maroDishesDiscount,
	        List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList);
	public void delMain (MaroDishesDiscountEntity maroDishesDiscount);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroDishesDiscountEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroDishesDiscountEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroDishesDiscountEntity t);

	/**
	 * 获取该店铺的打折活动信息
	 * 当店铺id为null时查询所有店铺的信息
	 * @param shopId
	 * @return
	 */
	public List<MaroDishesDiscountEntity> getDiscount(String shopId);

    /**
     * 通过活动id获取活动的详细信息
     * @param discountId
     * @return
     */
	public List<Map> getDiscountDetailByDiscountId(String discountId);
}
