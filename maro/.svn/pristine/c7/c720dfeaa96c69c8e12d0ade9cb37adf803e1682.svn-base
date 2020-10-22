package com.maro.manager.dishes.dishes.service;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.platform.core.common.service.CommonService;
import com.maro.platform.web.system.pojo.base.TSDepart;

import java.util.List;
import java.io.Serializable;
import java.util.Map;

public interface MaroDishesServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(MaroDishesEntity maroDishes,
	        List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(MaroDishesEntity maroDishes,
	        List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList);
	public void delMain (MaroDishesEntity maroDishes);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroDishesEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroDishesEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroDishesEntity t);
 	
 	/**
 	 * 菜肴的规格列表
 	 * maroDishesId 菜肴id
 	 */
 	public List<MaroDishesSpecificationsEntity> getSpecificationsList(String maroDishesId);
 	
 	/**
 	 * 查出是店铺的机构
 	 */
 	public List<TSDepart> tsDepartList();
 	
 	/**
	 * 根据原料id获取
	 * @param specificationsId
	 */
 	public String getDenominatedUnit(String materialClassId);
 	
 	/**
 	 * 在原料列表里   规格成本添加菜肴时 获取列表总数
 	 * shopId 店铺id
 	 * maroDishes 菜肴对像
 	 */
 	public Integer dishesSpecificationsCount(String shopId,MaroDishesEntity maroDishes);
 	
 	/**
 	 * 在原料列表里   规格成本添加菜肴时
 	 * shopId 店铺id
 	 * maroDishes 菜肴对像
 	 * page  当前页
 	 * rows  每页显示记录数
 	 */
 	public List<MaroDishesEntity> dishesSpecificationsList(String shopId,MaroDishesEntity maroDishes,int page,int rows);
 	
 	/**
 	 * 检查是是否有此编码
 	 * @param coding
 	 * @return
 	 */
 	public Integer checkCoding(String coding,String sysCompanyCode);

	/**
	 *
	 * 根据 便签code查询规格菜肴
	 * @param code
	 * @return
	 */
	List<Map<String,Object>> getMaroDishesEntityList(String code,String company);
}
