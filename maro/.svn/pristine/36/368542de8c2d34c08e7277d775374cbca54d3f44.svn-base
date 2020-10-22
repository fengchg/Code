package com.maro.manager.store.storeflow.service.impl;
import com.maro.common.constant.MaterialClassConstant;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.UUIDUtil;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.store.purchase.entity.MaroPurchaseEntity;
import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;
import com.maro.manager.store.storeflow.dao.MaroStoreFlowDao;
import com.maro.manager.store.storeflow.entity.MaroStoreFlowEntity;
import com.maro.manager.store.storeflow.service.MaroStoreFlowServiceI;
import com.maro.manager.store.storegoods.service.MaroStoreGoodsServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyClassLoader;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.CgformEnhanceJavaInter;
import com.maro.platform.web.system.pojo.base.TSDepart;
import com.maro.platform.web.system.service.SystemService;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("maroStoreFlowService")
@Transactional
public class MaroStoreFlowServiceImpl extends CommonServiceImpl implements MaroStoreFlowServiceI {
	@Autowired
	private MaroStoreFlowDao maroStoreFlowDao;
	@Autowired
	private MaroMaterialClassServiceI maroMaterialClassService;
	@Autowired
	private MaroStoreGoodsServiceI maroStoreGoodsService;
	@Autowired
	private SystemService systemService;
 	public void delete(MaroStoreFlowEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroStoreFlowEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(MaroStoreFlowEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroStoreFlowEntity t) throws Exception{
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
	private void doUpdateBus(MaroStoreFlowEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(MaroStoreFlowEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroStoreFlowEntity t){
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
		map.put("purchase_detail_id", t.getPurchaseDetailId());
		map.put("shop_id", t.getShopId());
		map.put("goods_id", t.getGoodsId());
		map.put("number", t.getNumber());
		map.put("price", t.getPrice());
		map.put("total_price", t.getTotalPrice());
		map.put("store_id", t.getStoreId());
		map.put("label_code", t.getLabelCode());
		map.put("type", t.getType());
		map.put("delete_flag", t.getDeleteFlag());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroStoreFlowEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
		sql  = sql.replace("#{purchase_detail_id}",String.valueOf(t.getPurchaseDetailId()));
 		sql  = sql.replace("#{shop_id}",String.valueOf(t.getShopId()));
 		sql  = sql.replace("#{goods_id}",String.valueOf(t.getGoodsId()));
 		sql  = sql.replace("#{number}",String.valueOf(t.getNumber()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{total_price}",String.valueOf(t.getTotalPrice()));
 		sql  = sql.replace("#{store_id}",String.valueOf(t.getStoreId()));
 		sql  = sql.replace("#{label_code}",String.valueOf(t.getLabelCode()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
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
					javaInter.execute("maro_store_flow",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public boolean addFlow(MaroPurchaseDetailEntity maroPurchaseDetail, MaroMaterialClassEntity maroMaterialClassEntity, String shopId, String labelCode, Integer iN_STORE) {
		// TODO Auto-generated method stub
		MaroStoreFlowEntity maroStoreFlowEntity=purchaseDetailToStoreFlow(maroPurchaseDetail, maroMaterialClassEntity,shopId,labelCode,iN_STORE);
		try {
			UUIDUtil.setId(maroStoreFlowEntity);
			this.save(maroStoreFlowEntity);
			//MQ同步
			if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
				TSDepart tsDepart =null;
				//初始化店铺队列
				MaroPurchaseEntity maroPurchaseEntity=this.get(MaroPurchaseEntity.class, maroPurchaseDetail.getPurchaseId());
				MaroShopEntity maroShop = this.get(MaroShopEntity.class, maroPurchaseEntity.getShopId());
				tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
				try {
					MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "purchaseDetailAddFlow", maroStoreFlowEntity);
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

	private MaroStoreFlowEntity purchaseDetailToStoreFlow(
			MaroPurchaseDetailEntity maroPurchaseDetail, MaroMaterialClassEntity maroMaterialClassEntity, String shopId, String labelCode, Integer iN_STORE) {
		// TODO Auto-generated method stub
		MaroStoreFlowEntity maroStoreFlowEntity=new MaroStoreFlowEntity();
		maroStoreFlowEntity.setShopId(shopId);
		maroStoreFlowEntity.setGoodsId(maroPurchaseDetail.getMaterialClassId());
		if(MaterialClassConstant.CHAILIN.equals(maroMaterialClassEntity.getType())&&maroMaterialClassEntity.getScatteredNumber()!=null&&!"".equals(maroMaterialClassEntity.getScatteredNumber())){
			maroStoreFlowEntity.setPrice(String.valueOf(Double.valueOf(maroPurchaseDetail.getPrice())/Double.valueOf(maroMaterialClassEntity.getScatteredNumber())));
			maroStoreFlowEntity.setNumber(String.valueOf(Double.valueOf(maroPurchaseDetail.getNumber())*Double.valueOf(maroMaterialClassEntity.getScatteredNumber())));
		}else{
			maroStoreFlowEntity.setPrice(maroPurchaseDetail.getPrice());
			maroStoreFlowEntity.setNumber(maroPurchaseDetail.getNumber());
		}
		maroStoreFlowEntity.setPurchaseDetailId(maroPurchaseDetail.getId());
		maroStoreFlowEntity.setTotalPrice(maroPurchaseDetail.getTotalPrice());
		maroStoreFlowEntity.setStoreId(maroPurchaseDetail.getStoreId());
		maroStoreFlowEntity.setLabelCode(labelCode);
		maroStoreFlowEntity.setType(iN_STORE);
		return maroStoreFlowEntity;
	}

	@Override
	public List<Map> getMaterialInfo(String labelCode, String shopId) {
		// TODO Auto-generated method stub
		//获取该原料库存数量,若原料位于多个仓库中，则直接返回，前端会告知需要将同一原料归并与一个仓库中
		List<Map> maps=maroStoreFlowDao.getMaterialNumber(labelCode,shopId);
		if(maps!=null&&maps.size()>1){
			return maps;
		}
		if(maps!=null&&maps.size()==1){
			Map map=maps.get(0);
			//获取原料信息
			Map info=maroStoreFlowDao.getMaterialInfo(labelCode,shopId);
			if(info!=null){
				map.putAll(info);
			}
		}





		/*if(maps!=null&&maps.size()>1){
			return maps;
		}
		if(maps!=null&&maps.size()==1){
			Map map=maps.get(0);
			long number=0;
			if(map !=null){
				//获取对应的原料剩余数量
				List<Map> listMap=maroStoreFlowDao.getMaterialNumberList(map.get("goodsid").toString(),shopId);
				for(Map m:listMap){
					number+=Double.valueOf(m.get("number").toString());
				}
				if(number<=0){
					map=null;
				}else{
					map.put("number", number);
				}
			}
		}*/
		return maps;
	}

	@Override
	public void doAdd(String comeFrom, MaroStoreFlowEntity maroStoreFlow) throws Exception {
		//setid
		UUIDUtil.setId(maroStoreFlow);
 		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			MaroShopEntity maroShop = maroStoreGoodsService.get(MaroShopEntity.class, maroStoreFlow.getShopId());
			TSDepart tsDepart = maroStoreGoodsService.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "storeFlowDoAdd", comeFrom,maroStoreFlow);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		if(comeFrom!=null&&"add".equals(comeFrom)){
			//获取原料详情
			MaroMaterialClassEntity maroMaterialClassEntity=maroMaterialClassService.get(MaroMaterialClassEntity.class, maroStoreFlow.getGoodsId());
			MaroPurchaseDetailEntity maroPurchaseDetail=new MaroPurchaseDetailEntity();
			maroPurchaseDetail.setStoreId(maroStoreFlow.getStoreId());
			maroPurchaseDetail.setMaterialClassId(maroStoreFlow.getGoodsId());
			maroPurchaseDetail.setNumber(maroStoreFlow.getNumber());
			//入库操作
			boolean result=maroStoreGoodsService.putInStore(maroPurchaseDetail,maroMaterialClassEntity);
			if(MaterialClassConstant.CHAILIN.equals(maroMaterialClassEntity.getType())&&maroMaterialClassEntity.getScatteredNumber()!=null&&!"".equals(maroMaterialClassEntity.getScatteredNumber())){
				maroStoreFlow.setNumber(String.valueOf(Double.valueOf(maroStoreFlow.getNumber())*Double.valueOf(maroMaterialClassEntity.getScatteredNumber())));
			}
		}
		if(comeFrom!=null&&"out".equals(comeFrom)){
			MaroPurchaseDetailEntity maroPurchaseDetail=new MaroPurchaseDetailEntity();
			maroPurchaseDetail.setStoreId(maroStoreFlow.getStoreId());
			maroPurchaseDetail.setMaterialClassId(maroStoreFlow.getGoodsId());
			maroPurchaseDetail.setNumber(maroStoreFlow.getNumber());
			//入库操作
			boolean result=maroStoreGoodsService.putOutStore(maroPurchaseDetail);
		}
		this.save(maroStoreFlow);
	}
}