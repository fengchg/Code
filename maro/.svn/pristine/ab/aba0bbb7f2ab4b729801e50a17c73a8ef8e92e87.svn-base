package com.maro.manager.store.storegoods.service.impl;

import com.maro.common.constant.MaterialClassConstant;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.UUIDUtil;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.store.purchase.entity.MaroPurchaseEntity;
import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;
import com.maro.manager.store.shopstore.entity.MaroShopStoreEntity;
import com.maro.manager.store.storegoods.dao.MaroStoreGoodsDao;
import com.maro.manager.store.storegoods.entity.MaroStoreGoodsEntity;
import com.maro.manager.store.storegoods.service.MaroStoreGoodsServiceI;
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

@Service("maroStoreGoodsService")
@Transactional
public class MaroStoreGoodsServiceImpl extends CommonServiceImpl implements MaroStoreGoodsServiceI {
	@Autowired
	private MaroStoreGoodsDao maroStoreGoodsDao;
	
 	public void delete(MaroStoreGoodsEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroStoreGoodsEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}

	public void saveOrUpdate(MaroStoreGoodsEntity entity,Object obj) throws Exception{
		super.saveOrUpdate(entity);
		//执行更新操作增强业务
		this.doUpdateBus(entity);
	}

 	public void saveOrUpdate(MaroStoreGoodsEntity entity) throws Exception{
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			MaroShopStoreEntity maroShopStoreEntity = super.get(MaroShopStoreEntity.class, entity.getStoreId());
			MaroShopEntity maroShop = super.get(MaroShopEntity.class, maroShopStoreEntity.getShopId());
			TSDepart tsDepart = super.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "storeGoodsSaveOrUpdate", entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		//仓库id
 		String storeId=entity.getStoreId();
 		//原料id
		String goodsId=entity.getGoodsId();
		//获取此原料在该仓库中先前是否有值,有值合并，没有则更新
		MaroStoreGoodsEntity maroStoreGoodsEntity=maroStoreGoodsDao.getStoreGoodsByShopIdAndClassId(storeId,goodsId);
		if(maroStoreGoodsEntity!=null){
			maroStoreGoodsEntity.setNumber(String.valueOf(Double.valueOf(maroStoreGoodsEntity.getNumber())+Double.valueOf(entity.getNumber())));
			super.saveOrUpdate(maroStoreGoodsEntity);
			super.delete(entity);
		}else{
			super.saveOrUpdate(entity);
		}
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroStoreGoodsEntity t) throws Exception{
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
	private void doUpdateBus(MaroStoreGoodsEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param
	 * @return
	 */
	private void doDelBus(MaroStoreGoodsEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroStoreGoodsEntity t){
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
		map.put("store_id", t.getStoreId());
		map.put("goods_id", t.getGoodsId());
		map.put("number", t.getNumber());
		map.put("delete_flag", t.getDeleteFlag());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroStoreGoodsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{store_id}",String.valueOf(t.getStoreId()));
 		sql  = sql.replace("#{goods_id}",String.valueOf(t.getGoodsId()));
 		sql  = sql.replace("#{number}",String.valueOf(t.getNumber()));
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
					javaInter.execute("maro_store_goods",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public boolean putInStore(MaroPurchaseDetailEntity maroPurchaseDetail, MaroMaterialClassEntity maroMaterialClassEntity) {
		// TODO Auto-generated method stub
		try {
			//根据仓库id和原料id获取该仓库的该原料库存信息
			MaroStoreGoodsEntity maroStoreGoodsEntity=maroStoreGoodsDao.getStoreGoodsByShopIdAndClassId(maroPurchaseDetail.getStoreId(),maroPurchaseDetail.getMaterialClassId());
			if(maroStoreGoodsEntity==null){
				maroStoreGoodsEntity=purchaseDetailToStoreGoods(maroPurchaseDetail,maroMaterialClassEntity);
				UUIDUtil.setId(maroStoreGoodsEntity);	
				this.save(maroStoreGoodsEntity);
			}else{
				if(MaterialClassConstant.CHAILIN.equals(maroMaterialClassEntity.getType())&&maroMaterialClassEntity.getScatteredNumber()!=null&&!"".equals(maroMaterialClassEntity.getScatteredNumber())){
					maroStoreGoodsEntity.setNumber(String.valueOf(Double.valueOf(maroStoreGoodsEntity.getNumber())+Double.valueOf(maroPurchaseDetail.getNumber())*Double.valueOf(maroMaterialClassEntity.getScatteredNumber())));
				}else{
					maroStoreGoodsEntity.setNumber(String.valueOf(Double.valueOf(maroStoreGoodsEntity.getNumber())+Double.valueOf(maroPurchaseDetail.getNumber())));
				}
				this.saveOrUpdate(maroStoreGoodsEntity,null);
			}
			//MQ同步
			if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
				TSDepart tsDepart =null;
				//初始化店铺队列
				MaroPurchaseEntity maroPurchaseEntity=this.get(MaroPurchaseEntity.class, maroPurchaseDetail.getPurchaseId());
				MaroShopEntity maroShop = this.get(MaroShopEntity.class, maroPurchaseEntity.getShopId());
				tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
				try {
					MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "purchaseDetailPutInStore", maroStoreGoodsEntity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public boolean putOutStore(MaroPurchaseDetailEntity maroPurchaseDetail) {
		// TODO Auto-generated method stub
		try {
			//根据仓库id和原料id获取该仓库的该原料库存信息
			MaroStoreGoodsEntity maroStoreGoodsEntity=maroStoreGoodsDao.getStoreGoodsByShopIdAndClassId(maroPurchaseDetail.getStoreId(),maroPurchaseDetail.getMaterialClassId());
			if(maroStoreGoodsEntity==null){
				return false;
			}else{
				maroStoreGoodsEntity.setNumber(String.valueOf(Double.valueOf(maroStoreGoodsEntity.getNumber())-Double.valueOf(maroPurchaseDetail.getNumber())));
				this.saveOrUpdate(maroStoreGoodsEntity,null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public MaroStoreGoodsEntity getEntityByStoreIdAndGoodsId(String storeId, String goodsId) {
		return maroStoreGoodsDao.getStoreGoodsByShopIdAndClassId(storeId, goodsId);
	}

	@Override
	public List<Map> otherStoreHave(String goodsId, String storeId) {
		return maroStoreGoodsDao.otherStoreHave(storeId, goodsId);
	}

	private MaroStoreGoodsEntity purchaseDetailToStoreGoods(
			MaroPurchaseDetailEntity maroPurchaseDetail, MaroMaterialClassEntity maroMaterialClassEntity) {
		// TODO Auto-generated method stub
		MaroStoreGoodsEntity maroStoreGoodsEntity=new MaroStoreGoodsEntity();
		maroStoreGoodsEntity.setStoreId(maroPurchaseDetail.getStoreId());
		maroStoreGoodsEntity.setGoodsId(maroPurchaseDetail.getMaterialClassId());
		if(MaterialClassConstant.CHAILIN.equals(maroMaterialClassEntity.getType())&&maroMaterialClassEntity.getScatteredNumber()!=null&&!"".equals(maroMaterialClassEntity.getScatteredNumber())){
			maroStoreGoodsEntity.setNumber(String.valueOf(Double.valueOf(maroPurchaseDetail.getNumber())*Double.valueOf(maroMaterialClassEntity.getScatteredNumber())));
		}else{
			maroStoreGoodsEntity.setNumber(maroPurchaseDetail.getNumber());
		}
		return maroStoreGoodsEntity;
	}

	
}