package com.maro.manager.materialthreshold.service.impl;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.manager.materialthreshold.entity.MaroMaterialThresholdEntity;
import com.maro.manager.materialthreshold.service.MaroMaterialThresholdServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyClassLoader;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.CgformEnhanceJavaInter;
import com.maro.platform.web.system.pojo.base.TSDepart;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("maroMaterialThresholdService")
@Transactional
public class MaroMaterialThresholdServiceImpl extends CommonServiceImpl implements MaroMaterialThresholdServiceI {

	
 	public void delete(MaroMaterialThresholdEntity entity) throws Exception{
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//获取该调记录详情
			if(entity.getShopId()!=null&&!entity.getShopId().equals("")){
				//获取店铺详情
				MaroShopEntity maroShopEntity=this.get(MaroShopEntity.class, entity.getShopId());
				//初始化店铺队列
				TSDepart tsDepart = this.get(TSDepart.class, maroShopEntity.getDepartId());
				try {
					MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "materialThresholdDelete", entity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroMaterialThresholdEntity entity) throws Exception{
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//获取该调记录详情
			if(entity.getShopId()!=null&&!entity.getShopId().equals("")){
				//获取店铺详情
				MaroShopEntity maroShopEntity=this.get(MaroShopEntity.class, entity.getShopId());
				//初始化店铺队列
				TSDepart tsDepart = this.get(TSDepart.class, maroShopEntity.getDepartId());
				try {
					MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "materialThresholdSave", entity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Serializable t = super.save(entity);
		//执行新增操作增强业务
		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(MaroMaterialThresholdEntity entity) throws Exception{
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//获取该调记录详情
			if(entity.getShopId()!=null&&!entity.getShopId().equals("")){
				//获取店铺详情
				MaroShopEntity maroShopEntity=this.get(MaroShopEntity.class, entity.getShopId());
				//初始化店铺队列
				TSDepart tsDepart = this.get(TSDepart.class, maroShopEntity.getDepartId());
				try {
					MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "materialThresholdSaveOrUpdate", entity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroMaterialThresholdEntity t) throws Exception{
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
	private void doUpdateBus(MaroMaterialThresholdEntity t) throws Exception{
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
	private void doDelBus(MaroMaterialThresholdEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroMaterialThresholdEntity t){
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
		map.put("material_class_id", t.getMaterialClassId());
		map.put("value", t.getValue());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroMaterialThresholdEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{material_class_id}",String.valueOf(t.getMaterialClassId()));
 		sql  = sql.replace("#{value}",String.valueOf(t.getValue()));
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
					javaInter.execute("maro_material_threshold",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}