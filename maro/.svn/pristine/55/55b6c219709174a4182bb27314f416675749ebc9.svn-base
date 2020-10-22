package com.maro.manager.dishes.specificationsprice.service.impl;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.manager.dishes.specificationsfoodcosts.page.MaroSpecificationsFoodCostsPage;
import com.maro.manager.dishes.specificationsprice.service.MaroSpecificationsPriceServiceI;
import com.maro.manager.dishes.specificationsprice.dao.MaroSpecificationsPriceDao;
import com.maro.manager.dishes.specificationsprice.entity.MaroSpecificationsPriceEntity;
import com.maro.manager.dishes.specificationsprice.entity.SpecatinsPrice;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.ContextHolderUtils;
import com.maro.platform.core.util.MyClassLoader;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.CgformEnhanceJavaInter;
import com.maro.platform.web.system.pojo.base.TSDepart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;

import org.jeecgframework.core.util.ApplicationContextUtil;

@Service("maroSpecificationsPriceService")
@Transactional
public class MaroSpecificationsPriceServiceImpl extends CommonServiceImpl implements MaroSpecificationsPriceServiceI {

	@Autowired
	MaroSpecificationsPriceDao maroSpecificationsPriceDao;
	@Autowired
	private UtilServiceI utilService;
	
 	public void delete(MaroSpecificationsPriceEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroSpecificationsPriceEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(MaroSpecificationsPriceEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroSpecificationsPriceEntity t) throws Exception{
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
	private void doUpdateBus(MaroSpecificationsPriceEntity t) throws Exception{
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
	private void doDelBus(MaroSpecificationsPriceEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroSpecificationsPriceEntity t){
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
		map.put("dpeart_id", t.getDpeartId());
		map.put("shop_id", t.getShopId());
		map.put("specifications_id", t.getSpecificationsId());
		map.put("price", t.getPrice());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroSpecificationsPriceEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{dpeart_id}",String.valueOf(t.getDpeartId()));
 		sql  = sql.replace("#{shop_id}",String.valueOf(t.getShopId()));
 		sql  = sql.replace("#{specifications_id}",String.valueOf(t.getSpecificationsId()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
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
					javaInter.execute("maro_specifications_price",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public List<MaroSpecificationsPriceEntity> entityList(String specificationsId) throws Exception {
		List<MaroSpecificationsPriceEntity> specificationsPriceList = findByProperty(MaroSpecificationsPriceEntity.class,"specificationsId",specificationsId);
		return specificationsPriceList;
	}

	@Override
	public void deleteSpecificationsId(String specificationsId)throws Exception {
		maroSpecificationsPriceDao.deleteSpecificationsId(specificationsId);
	}

	@Override
	public void updatePrice(SpecatinsPrice specatinsPrice) {
		//先根据规格id 删除原先的规格价格在进行保存
		maroSpecificationsPriceDao.deleteSpecificationsId(specatinsPrice.getSpecificationsId());
		
		for(int i=0;i<specatinsPrice.getSpecificationsPriceList().size();i++){
			specatinsPrice.getSpecificationsPriceList().get(i).setSpecificationsId(specatinsPrice.getSpecificationsId());
			super.save(specatinsPrice.getSpecificationsPriceList().get(i));
		}
		
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			
			//先获取菜肴的 sysCompanyCode 
			MaroDishesSpecificationsEntity specificationsEntity = getEntity(MaroDishesSpecificationsEntity.class,specatinsPrice.getSpecificationsId());
			MaroDishesEntity maroDishes = getEntity(MaroDishesEntity.class,specificationsEntity.getMaroDishesId());

			//如果是所有店铺 推所有
			if(maroDishes.getSysCompanyCode().equals("0")){
		        if(Util.ifRoleCode()){
		        	MqUtil.remoteOpt(null,"maroSynchronizationSpecificationsPriceController","doAdd2",specatinsPrice);
		        }else{
		        	String orgCode = utilService.getOrgCode(maroDishes.getSysCompanyCode());
		        	MqUtil.remoteOpt(orgCode,"maroSynchronizationSpecificationsPriceController","doAdd2",specatinsPrice);
		        }
			}else{
				String orgCode = utilService.getOrgCode(maroDishes.getSysCompanyCode());
				MqUtil.remoteOpt(orgCode,"maroSynchronizationSpecificationsPriceController","doAdd2",specatinsPrice);
			}
		}
		
	}
}