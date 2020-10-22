package com.maro.manager.dishes.dishes.dao;

import java.util.List;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.BeepAction;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;

@MiniDao
public interface MaroDishesDao {

	/**
	 * 根据原料id获取
	 * @param specificationsId
	 */
	@Arguments("materialClassId")
	@Sql("select denominated_unit from maro_material_class where id = :materialClassId")
	String getDenominatedUnit(String materialClassId);
	
	/**
	 * 在原料列表里   规格成本添加菜肴时
	 */
	@Arguments({"shopId","userName","maroDishes"})
	public Integer dishesSpecificationsCount(String shopId,String userName,MaroDishesEntity maroDishes);
	
	/**
 	 * 在原料列表里   规格成本添加菜肴时
 	 */
	@Arguments({"shopId","userName","maroDishes","pageNo","rowsNo"})
 	public List<MaroDishesEntity> dishesSpecificationsList(String shopId,boolean userName,MaroDishesEntity maroDishes,int pageNo,int rowsNo);
	
	/**
	 * 查询编码是否存在
	 * @param coding
	 * @return
	 */
	@Arguments("coding")
	@Sql("select count(0) from maro_dishes where coding = :coding")
	Integer checkCoding(String coding);
	
	/**
	 * 根据店铺 Id 查询编码是否存在
	 * @param coding
	 * @return
	 */
	@Arguments({"coding","sysCompanyCode"})
	@Sql("select count(0) from maro_dishes where coding = :coding and (sys_company_code = :sysCompanyCode or sys_company_code = '0')")
	Integer checkCoding(String coding,String sysCompanyCode);

	@Arguments({"code","company"})
	public List<Map<String,Object>> getMaroDishesEntityList(String code,String company);
}
