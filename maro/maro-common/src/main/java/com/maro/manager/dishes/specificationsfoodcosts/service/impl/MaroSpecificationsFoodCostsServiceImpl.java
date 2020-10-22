package com.maro.manager.dishes.specificationsfoodcosts.service.impl;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.manager.dishes.specificationsfoodcosts.page.MaroSpecificationsFoodCostsPage;
import com.maro.manager.dishes.specificationsfoodcosts.service.MaroSpecificationsFoodCostsServiceI;
import com.maro.manager.dishes.specificationsfoodcosts.dao.MaroSpecificationsFoodCostsDao;
import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.manager.dishes.specificationsprice.entity.MaroSpecificationsPriceEntity;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.ApplicationContextUtil;
import com.maro.platform.core.util.MyClassLoader;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.CgformEnhanceJavaInter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;


@Service("maroSpecificationsFoodCostsService")
@Transactional
public class MaroSpecificationsFoodCostsServiceImpl extends CommonServiceImpl implements MaroSpecificationsFoodCostsServiceI {

	@Autowired
	MaroSpecificationsFoodCostsDao maroSpecificationsFoodCostsDao;
	@Autowired
	private UtilServiceI utilService;
	
 	public void delete(MaroSpecificationsFoodCostsEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
		
		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//根据规格成本得到规格
			MaroDishesSpecificationsEntity dishesSpecifications = super.getEntity(MaroDishesSpecificationsEntity.class,entity.getSpecificationsId());
			//根据规格得到菜肴id
			MaroDishesEntity dishes = super.getEntity(MaroDishesEntity.class, dishesSpecifications.getMaroDishesId());
			if(dishes.getSysCompanyCode().equals("0")){
				MqUtil.remoteOpt(null,"maroSynchronizationSpecificationsFoodCostsController","doDel",entity);
			}else{
				String orgCode = utilService.getOrgCode(dishes.getSysCompanyCode());
				MqUtil.remoteOpt(orgCode,"maroSynchronizationSpecificationsFoodCostsController","doDel",entity);
			}
	    	
		
		}
 	}
 	
 	public Serializable save(MaroSpecificationsFoodCostsEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(MaroSpecificationsFoodCostsEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
 	 * 添加规格成分
 	 */
 	@Override
 	public void addOrUpate(MaroSpecificationsFoodCostsPage maroSpecificationsFoodCostsPage){
 		//删除规格id成份
 		maroSpecificationsFoodCostsDao.deleteSpecificationsId(maroSpecificationsFoodCostsPage.getSpecificationsId());
		
		//规格成本列表
		List<MaroSpecificationsFoodCostsEntity> foodCosts = maroSpecificationsFoodCostsPage.getFoodCosts();
		if(foodCosts.size()!=0){
			for (int i=0;i<foodCosts.size();i++){
				foodCosts.get(i).setSpecificationsId(maroSpecificationsFoodCostsPage.getSpecificationsId());
				super.save(foodCosts.get(i));
			}
		}
		
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//先获取菜肴的 sysCompanyCode 
			MaroDishesSpecificationsEntity specificationsEntity = getEntity(MaroDishesSpecificationsEntity.class,maroSpecificationsFoodCostsPage.getSpecificationsId());
			MaroDishesEntity maroDishes = getEntity(MaroDishesEntity.class,specificationsEntity.getMaroDishesId());
			
			//如果是所有店铺 推所有
			if(maroDishes.getSysCompanyCode().equals("0")){
		        if(Util.ifRoleCode()){
		        	MqUtil.remoteOpt(null,"maroSynchronizationSpecificationsFoodCostsController","doAdd2",maroSpecificationsFoodCostsPage,maroSpecificationsFoodCostsPage.getFoodCosts());
		        }else{
		        	String orgCode = utilService.getOrgCode(maroDishes.getSysCompanyCode());
		        	MqUtil.remoteOpt(orgCode,"maroSynchronizationSpecificationsFoodCostsController","doAdd2",maroSpecificationsFoodCostsPage);
		        }
			}else{
				String orgCode = utilService.getOrgCode(maroDishes.getSysCompanyCode());
				MqUtil.remoteOpt(orgCode,"maroSynchronizationSpecificationsFoodCostsController","doAdd2",maroSpecificationsFoodCostsPage);
			}
		}
 	}
 	
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroSpecificationsFoodCostsEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(MaroSpecificationsFoodCostsEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(MaroSpecificationsFoodCostsEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroSpecificationsFoodCostsEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("specifications_id", t.getSpecificationsId());
		map.put("material_classification", t.getMaterialClassification());
		map.put("create_source", t.getCreateSource());
		map.put("consumption_quantity", t.getConsumptionQuantity());
		map.put("unit", t.getUnit());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroSpecificationsFoodCostsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{specifications_id}",String.valueOf(t.getSpecificationsId()));
 		sql  = sql.replace("#{material_classification}",String.valueOf(t.getMaterialClassification()));
 		sql  = sql.replace("#{create_source}",String.valueOf(t.getCreateSource()));
 		sql  = sql.replace("#{consumption_quantity}",String.valueOf(t.getConsumptionQuantity()));
 		sql  = sql.replace("#{unit}",String.valueOf(t.getUnit()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("maro_specifications_food_costs",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public List<MaroSpecificationsFoodCostsEntity> getSpecificationsIdList(String specificationsId)throws Exception {
		return findByProperty(MaroSpecificationsFoodCostsEntity.class,"specificationsId",specificationsId);
	}

	@Override
	public void deleteSpecificationsId(String specificationsId)throws Exception {
		maroSpecificationsFoodCostsDao.deleteSpecificationsId(specificationsId);
	}

	/*@Override
	public void addMain(MaroSpecificationsFoodCostsPage maroSpecificationsFoodCostsPage) {
		*//**保存-规格成本*//*
		try {
			List<MaroSpecificationsFoodCostsEntity> list = maroSpecificationsFoodCostsPage.getMaroSpecificationsFoodCostsEntity();
			for(MaroSpecificationsFoodCostsEntity entity:list){
				this.save(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}