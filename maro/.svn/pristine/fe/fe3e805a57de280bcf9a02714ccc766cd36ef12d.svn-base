package com.maro.common.dishes.dishes.dao;

import java.util.List;
import java.util.Map;

import com.maro.common.dishes.dishes.pojo.dto.DishLabelsRusltDTO;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.maro.common.dishes.dishes.pojo.entity.MaroDishesClassificationEntity;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.dishes.dishes.pojo.vo.MaroCommonDishesSpecificationsEntity;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.manager.dishes.setmealdishes.entity.MaroSetmealDishesEntity;
import com.maro.manager.dishes.setmealdishes.entity.MaroSetmealDishesSelectEntity;

@Repository
public interface MaroCommonDishesDao {

	/**
	 * 根据店铺id获取菜肴
	 * @param departId
	 * @return
	 */
	@Arguments("departId")
	//@Sql("select * from maro_dishes where sys_company_code = :departId or sys_company_code = '0'")
	@Sql("select md.* from maro_dishes md, maro_dishes_classification mdc where md.dishes_classification = mdc.id and (md.sys_company_code = :departId or md.sys_company_code = '0') ORDER BY mdc.classification_code")
	List<MaroDishesEntity> getDishesList(String departId);
	
	@Arguments("departId")
	@Sql("SELECT md2.* from maro_dishes md2 where md2.type = 'package' and md2.sys_company_code = :departId")
	List<MaroDishesEntity> getSetmealList(String departId);
	
	/**
	 * 根据套餐id获取套餐菜
	 */
	@Arguments("setmealId")
	@Sql("select * from maro_setmeal_dishes where setmeal_id = :setmealId")
	List<MaroSetmealDishesEntity> getBySetmealIdList(String setmealId);
	
	/**
	 * 根据套餐id获取套餐类
	 */
	@Arguments("setmealDishesId")
	@Sql("select * from maro_setmeal_dishes_select where setmeal_dishes_id = :setmealDishesId")
	List<MaroSetmealDishesSelectEntity> getBysetmealDishesIdList(String setmealDishesId);
	
	@Arguments("mdsId")
	@Sql("select * from maro_dishes_specifications where id = :mdsId")
	MaroDishesSpecificationsEntity getBymdsIdEntity(String mdsId);
	
	@Arguments("mdId")
	@Sql("select * from maro_dishes where id = :mdId")
	MaroDishesEntity getBymdIdEntity(String mdId);
	
	
	
	/**
	 * 根据菜肴获取规格
	 * @param dishesId
	 * @return
	 */
	@Arguments("dishesId")
	@Sql("select * from maro_dishes_specifications where maro_dishes_id = :dishesId")
	List<MaroCommonDishesSpecificationsEntity> getSpecificationsList(String dishesId);
	
	/**
	 * 根据菜肴id获取详情
	 * @param id
	 * @return
	 */
	@Arguments("id")
	@Sql("select * from maro_dishes where id = :id")
	MaroDishesEntity getByidDishes(String id);
	
	/**
	 * 获取菜肴分类名称
	 * @param id
	 * @return
	 */
	@Arguments("id")
	@Sql("select classification_name from maro_dishes_classification where id = :id")
	String getByIdName(String id);
	
	/**
	 * 获取规格价格
	 * @param shopId 店铺id
	 * @param specificationsId规格id
	 * @return
	 */
	@Arguments({"shopId","specificationsId"})
	@Sql("select price from maro_specifications_price where shop_id = :shopId and specifications_id = :specificationsId")
	public String getSpecificationsPrice(String shopId,String specificationsId);

	@Arguments("shopId")
	@Sql("SELECT s.ds_code as dsCode,c.classification_code as classificationCode,d.dishes_name as dishesName,t.typename as specificationsName,s.unit_price as unitPrice,t1.typename as unitName,t1.typename as powerUnitName,0 as weight,d.make_way as makeWay,d.pinyin_code as pinYinCode FROM maro_dishes_specifications s,maro_dishes d,maro_dishes_classification c,(SELECT t.typecode,t.typename FROM t_s_type t,t_s_typegroup g WHERE t.typegroupid = g.ID and g.typegroupcode = 'maro_specifications') t,(SELECT t.typecode,t.typename FROM t_s_type t,t_s_typegroup g WHERE t.typegroupid = g.ID and g.typegroupcode = 'maro_unit_name') t1 WHERE s.maro_dishes_id = d.id and s.`name`=t.typecode and d.dishes_classification = c.id and t1.typecode = d.unit and (d.sys_company_code = :shopId or d.sys_company_code = '0')")
	List<Map<String,Object>> listDishesBySql(String shopId);

	@Sql("SELECT classification_code as classificationCode,classification_name as classificationName from maro_dishes_classification order by classification_code asc")
    List<Map<String,Object>> listDishesClassificationBySql();

	@Sql("SELECT t.typecode as code, t.typename as name FROM  t_s_type t, t_s_typegroup g WHERE t.typegroupid = g.ID AND g.typegroupcode = 'maro_the_label'  order by CONVERT(t.typecode,SIGNED) desc")
	List<Map<String,Object>> getDishesListBySql();

	@Arguments("shopId")
	@Sql("SELECT d.coding, ds.id AS specificationsId, 0 AS quantity, t.typename as unitname, ds.unit_price as price, d.the_label AS theLabel FROM maro_dishes d,(SELECT t.typecode,t.typename FROM t_s_typegroup g, t_s_type t WHERE g.id = t.typegroupid AND g.typegroupcode = 'maro_unit_name' ) t, maro_dishes_specifications ds WHERE ds.maro_dishes_id = d.id and t.typecode=d.unit AND d.the_label IS NOT NULL AND d.the_label != '' AND (d.sys_company_code = :shopId OR d.sys_company_code = '0')")
	List<Map<String,Object>> listFoodorderDOBySql(String shopId);

	@Sql("select t.typecode,t.typename,'' as pinYinCode from t_s_typegroup g,t_s_type t where g.id=t.typegroupid and g.typegroupcode='maro_make_way' order by t.typecode asc")
	List<Map<String,Object>> listMarkWayBySql();

	@Sql("select t.typecode,t.typename from t_s_typegroup g,t_s_type t where g.id=t.typegroupid and g.typegroupcode='terminalMessageTemplate' order by typegroupcode asc")
	List<Map<String,Object>> listTerminalMessageTemplateBySql();

	@Arguments("shopId")
	@Sql("select code,reason from maro_dishes_retire_reason where shop_id = :shopId order by code asc")
	List<Map<String,Object>> listDishesRetireReasonBySql(String shopId);
}
