package com.maro.manager.specialoffer.service.impl;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.manager.specialoffer.dao.MaroSpecialOfferDao;
import com.maro.manager.specialoffer.entity.MaroSpecialOfferEntity;
import com.maro.manager.specialoffer.service.MaroSpecialOfferServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyClassLoader;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.CgformEnhanceJavaInter;
import com.maro.platform.web.system.pojo.base.TSDepart;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("maroSpecialOfferService")
@Transactional
public class MaroSpecialOfferServiceImpl extends CommonServiceImpl implements MaroSpecialOfferServiceI {
	@Autowired
	private MaroSpecialOfferDao maroSpecialOfferDao;
	
 	public void delete(MaroSpecialOfferEntity entity) throws Exception{
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, entity.getShopId());
			TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "offerDelete", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroSpecialOfferEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);

		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			TSDepart tsDepart =null;
			//初始化店铺队列
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, entity.getShopId());
			tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "offerSave", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

 		return t;
 	}
 	
 	public void saveOrUpdate(MaroSpecialOfferEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			TSDepart tsDepart =null;
			//初始化店铺队列
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, entity.getShopId());
			tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "offerSaveOrUpdate", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 	}

	@Override
	public List<Map> getOfferDetail(String shopId) {
 		if(shopId==null||shopId.equals("")){
			return maroSpecialOfferDao.getOfferDetailAll();
		}else{
			return maroSpecialOfferDao.getOfferDetail(shopId);
		}
	}

	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroSpecialOfferEntity t) throws Exception{
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
	private void doUpdateBus(MaroSpecialOfferEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(MaroSpecialOfferEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroSpecialOfferEntity t){
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
		map.put("shop_id", t.getShopId());
		map.put("name", t.getName());
		map.put("remark", t.getRemark());
		map.put("buy_dishes_id", t.getBuyDishesId());
		map.put("buy_specifications_id", t.getBuySpecificationsId());
		map.put("buy_number", t.getBuyNumber());
		map.put("free_dishes_id", t.getFreeDishesId());
		map.put("free_specifications_id", t.getFreeSpecificationsId());
		map.put("free_number", t.getFreeNumber());
		map.put("is_add", t.getIsAdd());
		map.put("is_enable", t.getIsEnable());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroSpecialOfferEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{shop_id}",String.valueOf(t.getShopId()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{buy_dishes_id}",String.valueOf(t.getBuyDishesId()));
 		sql  = sql.replace("#{buy_specifications_id}",String.valueOf(t.getBuySpecificationsId()));
 		sql  = sql.replace("#{buy_number}",String.valueOf(t.getBuyNumber()));
 		sql  = sql.replace("#{free_dishes_id}",String.valueOf(t.getFreeDishesId()));
 		sql  = sql.replace("#{free_specifications_id}",String.valueOf(t.getFreeSpecificationsId()));
 		sql  = sql.replace("#{free_number}",String.valueOf(t.getFreeNumber()));
 		sql  = sql.replace("#{is_add}",String.valueOf(t.getIsAdd()));
 		sql  = sql.replace("#{is_enable}",String.valueOf(t.getIsEnable()));
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
					javaInter.execute("maro_special_offer",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}