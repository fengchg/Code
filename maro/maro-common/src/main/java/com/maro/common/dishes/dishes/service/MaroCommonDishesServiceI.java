package com.maro.common.dishes.dishes.service;

import com.maro.common.dishes.dishes.pojo.dto.DishLabelsRusltDTO;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.platform.core.common.service.CommonService;

import java.util.List;
import java.util.Map;

public interface MaroCommonDishesServiceI extends CommonService {
	
	/**
	 * 根据店铺id获取店铺的菜单列表
	 * departId 机构id
	 */
	public List<MaroDishesEntity> getDishesList(String departId);
	
	/**
	 * 根据菜肴id获取详情
	 * id 主键id
	 * shopId 店铺id
	 */
	public MaroDishesEntity getByidDishes(String id,String shopId);

    List<MaroDishesEntity> listDishes(String departId);

	List<MaroDishesSpecificationsEntity> listSpecifications(List<MaroDishesEntity> dishesList);

    List<DishLabelsRusltDTO> listDishLabels(String departId);

	List listDishesBySql(String departId);

	List<Map<String,Object>> listDishesClassificationBySql(String departId);

	List<Map<String,Object>> getDishesListBySql();

	List<Map<String,Object>> listFoodorderDOBySql(String shopId);

	List<Map<String,Object>> listMarkWayBySql();

	List<Map<String,Object>> listTerminalMessageTemplateBySql();

	List<Map<String,Object>> listDishesRetireReasonBySql(String shopId);
}
