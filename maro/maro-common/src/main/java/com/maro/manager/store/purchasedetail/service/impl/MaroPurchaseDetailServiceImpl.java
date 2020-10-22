package com.maro.manager.store.purchasedetail.service.impl;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.store.purchase.entity.MaroPurchaseEntity;
import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;
import com.maro.manager.store.purchasedetail.service.MaroPurchaseDetailServiceI;
import com.maro.manager.store.storeflow.service.MaroStoreFlowServiceI;
import com.maro.manager.store.storegoods.service.MaroStoreGoodsServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyBeanUtils;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("maroPurchaseDetailService")
@Transactional
public class MaroPurchaseDetailServiceImpl extends CommonServiceImpl implements MaroPurchaseDetailServiceI {
	@Autowired
	private MaroMaterialClassServiceI maroMaterialClassService;
	@Autowired
	private MaroStoreFlowServiceI maroStoreFlowService;
	@Autowired
	private MaroStoreGoodsServiceI maroStoreGoodsService;
 	public void delete(MaroPurchaseDetailEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroPurchaseDetailEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(MaroPurchaseDetailEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroPurchaseDetailEntity t) throws Exception{
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
	private void doUpdateBus(MaroPurchaseDetailEntity t) throws Exception{
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
	private void doDelBus(MaroPurchaseDetailEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroPurchaseDetailEntity t){
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
		map.put("bpm_status", t.getBpmStatus());
		map.put("purchase_id", t.getPurchaseId());
		map.put("material_class_id", t.getMaterialClassId());
		map.put("plan_price", t.getPlanPrice());
		map.put("plan_number", t.getPlanNumber());
		map.put("plan_total_price", t.getPlanTotalPrice());
		map.put("price", t.getPrice());
		map.put("number", t.getNumber());
		map.put("total_price", t.getTotalPrice());
		map.put("is_in_store", t.getIsInStore());
		map.put("store_id", t.getStoreId());
		map.put("in_store_time", t.getInStoreTime());
		map.put("delete_flag", t.getDeleteFlag());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroPurchaseDetailEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{purchase_id}",String.valueOf(t.getPurchaseId()));
 		sql  = sql.replace("#{material_class_id}",String.valueOf(t.getMaterialClassId()));
 		sql  = sql.replace("#{plan_price}",String.valueOf(t.getPlanPrice()));
 		sql  = sql.replace("#{plan_number}",String.valueOf(t.getPlanNumber()));
 		sql  = sql.replace("#{plan_total_price}",String.valueOf(t.getPlanTotalPrice()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{number}",String.valueOf(t.getNumber()));
 		sql  = sql.replace("#{total_price}",String.valueOf(t.getTotalPrice()));
 		sql  = sql.replace("#{is_in_store}",String.valueOf(t.getIsInStore()));
 		sql  = sql.replace("#{store_id}",String.valueOf(t.getStoreId()));
 		sql  = sql.replace("#{in_store_time}",String.valueOf(t.getInStoreTime()));
 		sql  = sql.replace("#{delete_flag}",String.valueOf(t.getDeleteFlag()));
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
					javaInter.execute("maro_purchase_detail",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public boolean checkIsPutInStore(String id, Integer iN_STORE) {
		// TODO Auto-generated method stub
		MaroPurchaseDetailEntity m=this.get(MaroPurchaseDetailEntity.class, id);
		if(m.getIsInStore()!=null&&(m.getIsInStore().intValue()==iN_STORE.intValue())){
			return false;
		}
		return true;
	}

	@Override
	public void doUpdate(String labelCode, String shopId, Integer IN_STORE, Integer STORE_IN, MaroPurchaseDetailEntity maroPurchaseDetail) throws Exception {
 		MaroPurchaseDetailEntity t = this.get(MaroPurchaseDetailEntity.class, maroPurchaseDetail.getId());
		//获取原料详情
		MaroMaterialClassEntity maroMaterialClassEntity=maroMaterialClassService.get(MaroMaterialClassEntity.class, maroPurchaseDetail.getMaterialClassId());
		//设置已入库状态和入库时间
		maroPurchaseDetail.setIsInStore(IN_STORE);
		maroPurchaseDetail.setInStoreTime(new Date());
		//添加流水信息
		boolean result=maroStoreFlowService.addFlow(maroPurchaseDetail,maroMaterialClassEntity,shopId,labelCode,STORE_IN);
		//入库操作
		result=maroStoreGoodsService.putInStore(maroPurchaseDetail,maroMaterialClassEntity);
		MyBeanUtils.copyBeanNotNull2Bean(maroPurchaseDetail, t);
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			TSDepart tsDepart =null;
			//初始化店铺队列
			MaroPurchaseEntity maroPurchaseEntity=this.get(MaroPurchaseEntity.class, maroPurchaseDetail.getPurchaseId());
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, maroPurchaseEntity.getShopId());
			tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "purchaseDetailSaveOrUpdate", t);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.saveOrUpdate(t);
	}
}