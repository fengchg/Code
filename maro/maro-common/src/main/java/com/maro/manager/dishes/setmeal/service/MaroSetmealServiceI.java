package com.maro.manager.dishes.setmeal.service;
import java.util.List;

import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.manager.dishes.setmeal.entity.MaroSetmealEntity;
import com.maro.manager.dishes.setmealdishes.entity.MaroAddSetmealSelectVO;
import com.maro.manager.dishes.setmealdishes.entity.MaroSetmealDishesEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroSetmealServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(MaroSetmealEntity maroSetmeal,List<MaroSetmealDishesEntity> maroSetmealDishesList) ;
	public void addMain2(MaroDishesEntity maroDishes,List<MaroSetmealDishesEntity> maroSetmealDishesList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(MaroSetmealEntity maroSetmeal,List<MaroSetmealDishesEntity> maroSetmealDishesList);
	public void updateMain2(MaroDishesEntity maroDishes,List<MaroSetmealDishesEntity> maroSetmealDishesList);
	
	public void delMain (MaroSetmealEntity maroSetmeal);
	public void delMain2 (MaroDishesEntity maroDishes);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroSetmealEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroSetmealEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroSetmealEntity t);
 	
 	
 	/**
 	 * 添加套餐菜
 	 */
 	public void doAddDishesSelect(MaroAddSetmealSelectVO setmealSelectVO);
 	
 	/**
 	 * 删除套餐菜
 	 */
 	public void doDelSetmealDishesSelect(String selectId);
 	
}
