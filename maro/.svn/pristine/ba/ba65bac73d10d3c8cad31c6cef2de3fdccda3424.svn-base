package com.maro.manager.groupdiscount.service.impl;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.manager.groupdiscount.dao.MaroGroupDiscountDao;
import com.maro.manager.groupdiscount.entity.MaroGroupDiscountEntity;
import com.maro.manager.groupdiscount.service.MaroGroupDiscountServiceI;
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

@Service("maroGroupDiscountService")
@Transactional
public class MaroGroupDiscountServiceImpl extends CommonServiceImpl implements MaroGroupDiscountServiceI {
	@Autowired
	private MaroGroupDiscountDao maroGroupDiscountDao;
	
 	public void delete(MaroGroupDiscountEntity entity) throws Exception{
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			TSDepart tsDepart =null;
			//初始化店铺队列
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, entity.getShopId());
			tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "groupDiscountDelete", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroGroupDiscountEntity entity) throws Exception{
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
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "groupDiscountSave", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return t;
 	}
 	
 	public void saveOrUpdate(MaroGroupDiscountEntity entity) throws Exception{
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
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "groupDiscountSaveOrUpdate", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 	}

	@Override
	public List<Map> getGroupDiscounts(String shopId) {
		List<Map> groupDiscounts=null;
		if(shopId==null||shopId.equals("")){
			groupDiscounts=maroGroupDiscountDao.getAllGroupDiscounts();
		}else{
			groupDiscounts=maroGroupDiscountDao.getGroupDiscounts(shopId);
		}
 		return groupDiscounts;
	}

	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroGroupDiscountEntity t) throws Exception{
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
	private void doUpdateBus(MaroGroupDiscountEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(MaroGroupDiscountEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroGroupDiscountEntity t){
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
		map.put("discount_money", t.getDiscountMoney());
		map.put("is_enable", t.getIsEnable());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroGroupDiscountEntity t){
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
 		sql  = sql.replace("#{discount_money}",String.valueOf(t.getDiscountMoney()));
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
					javaInter.execute("maro_group_discount",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}