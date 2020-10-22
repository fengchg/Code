package com.maro.manager.shop.reserve.service.impl;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.manager.shop.reserve.dao.MaroClientReserveDao;
import com.maro.manager.shop.reserve.entity.MaroClientReserveEntity;
import com.maro.manager.shop.reserve.service.MaroClientReserveServiceI;
import com.maro.manager.store.purchase.dao.MaroPurchaseDao;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyClassLoader;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.CgformEnhanceJavaInter;
import com.maro.platform.web.system.pojo.base.TSDepart;

@Service("maroClientReserveService")
@Transactional
public class MaroClientReserveServiceImpl extends CommonServiceImpl implements MaroClientReserveServiceI {

	@Autowired
    private MaroClientReserveDao maroClientReserveDao;
	
 	public void delete(MaroClientReserveEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, entity.getRestaurantId());
			TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "reserveDelete", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 	}
 	
 	public Serializable save(MaroClientReserveEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		//MQ同步
 		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, entity.getRestaurantId());
			TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "reserveSave", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		return t;
 	}
 	
 	public void saveOrUpdate(MaroClientReserveEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 		//MQ同步
 		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, entity.getRestaurantId());
			TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "reserveSaveOrUpdate", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroClientReserveEntity t) throws Exception{
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
	private void doUpdateBus(MaroClientReserveEntity t) throws Exception{
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
	private void doDelBus(MaroClientReserveEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroClientReserveEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("restaurant_id", t.getRestaurantId());
		map.put("restaurant_name", t.getRestaurantName());
		map.put("dest_seat_id", t.getDestSeatId());
		map.put("dest_seat_code", t.getDestSeatCode());
		map.put("dest_seat_name", t.getDestSeatName());
		map.put("customer_name", t.getCustomerName());
		map.put("phone", t.getPhone());
		map.put("person_number", t.getPersonNumber());
		map.put("reserve_time", t.getReserveTime());
		map.put("type", t.getType());
		map.put("deposit", t.getDeposit());
		map.put("content", t.getContent());
		map.put("status", t.getStatus());
		map.put("period", t.getPeriod());
		map.put("plan_come_time", t.getPlanComeTime());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroClientReserveEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{restaurant_id}",String.valueOf(t.getRestaurantId()));
 		sql  = sql.replace("#{restaurant_name}",String.valueOf(t.getRestaurantName()));
 		sql  = sql.replace("#{dest_seat_id}",String.valueOf(t.getDestSeatId()));
 		sql  = sql.replace("#{dest_seat_code}",String.valueOf(t.getDestSeatCode()));
 		sql  = sql.replace("#{dest_seat_name}",String.valueOf(t.getDestSeatName()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{person_number}",String.valueOf(t.getPersonNumber()));
 		sql  = sql.replace("#{reserve_time}",String.valueOf(t.getReserveTime()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{deposit}",String.valueOf(t.getDeposit()));
 		sql  = sql.replace("#{content}",String.valueOf(t.getContent()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{period}",String.valueOf(t.getPeriod()));
 		sql  = sql.replace("#{plan_come_time}",String.valueOf(t.getPlanComeTime()));
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
					javaInter.execute("maro_client_reserve",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public List<Map> listSeat(String shopId, Date reserveTime, String period,Integer personNumber) {
		// TODO Auto-generated method stub
		return maroClientReserveDao.listSeat(shopId,reserveTime.getTime(),period,personNumber);
	}
}