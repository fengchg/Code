package com.maro.manager.dishes.materialclass.service;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.platform.core.common.service.CommonService;

import java.util.List;
import java.io.Serializable;

public interface MaroMaterialClassServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(MaroMaterialClassEntity maroMaterialClass,
	        List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(MaroMaterialClassEntity maroMaterialClass,
	        List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList);
	public void delMain (MaroMaterialClassEntity maroMaterialClass);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroMaterialClassEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroMaterialClassEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroMaterialClassEntity t);
 	
 	/**
 	 * 检查是是否有此编码
 	 * @param coding
 	 * @return
 	 */
 	public Integer checkCoding(String coding);
}
