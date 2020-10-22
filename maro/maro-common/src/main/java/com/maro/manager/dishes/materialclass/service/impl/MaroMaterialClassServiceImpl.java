package com.maro.manager.dishes.materialclass.service.impl;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.UUIDUtil;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.dishes.materialclass.dao.MaroMaterialClassDao;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.core.util.oConvertUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("maroMaterialClassService")
@Transactional
public class MaroMaterialClassServiceImpl extends CommonServiceImpl implements MaroMaterialClassServiceI {
	
	@Autowired
	MaroMaterialClassDao maroMaterialClassDao;
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((MaroMaterialClassEntity)entity);
 	}
	
	public void addMain(MaroMaterialClassEntity maroMaterialClass,
	        List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList){
			//保存主信息
			this.save(maroMaterialClass);
		
			/**保存-规格成本*/
			for(MaroSpecificationsFoodCostsEntity maroSpecificationsFoodCosts:maroSpecificationsFoodCostsList){
				//外键设置
				if(StringUtil.isNotEmpty(maroSpecificationsFoodCosts.getSpecificationsId())){
					maroSpecificationsFoodCosts.setMaterialclassId(maroMaterialClass.getId());
					this.save(maroSpecificationsFoodCosts);
				}
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(maroMaterialClass);
 			
 			
 			/**=====发送给MQ========*/
 			if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
 				//MqUtil.sendEntity(null,maroMaterialClass,maroSpecificationsFoodCostsList);
 				MqUtil.remoteOpt(null, "maroSynchronizationMaterialClassController", "doAdd", maroMaterialClass,maroSpecificationsFoodCostsList);
 			}
	}

	
	public void updateMain(MaroMaterialClassEntity maroMaterialClass,
	        List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(maroMaterialClass.getId())){
			try {
				MaroMaterialClassEntity temp = findUniqueByProperty(MaroMaterialClassEntity.class, "id", maroMaterialClass.getId());
				MyBeanUtils.copyBeanNotNull2Bean(maroMaterialClass, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(maroMaterialClass);
		}
		//===================================================================================
		//获取参数
		Object id0 = maroMaterialClass.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-规格成本
	    String hql0 = "from MaroSpecificationsFoodCostsEntity where 1 = 1 AND mATERIALCLASS_ID = ? ";
	    List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-规格成本
		if(maroSpecificationsFoodCostsList!=null&&maroSpecificationsFoodCostsList.size()>0){
		for(MaroSpecificationsFoodCostsEntity oldE:maroSpecificationsFoodCostsOldList){
			boolean isUpdate = false;
				for(MaroSpecificationsFoodCostsEntity sendE:maroSpecificationsFoodCostsList){
					//需要更新的明细数据-规格成本
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-规格成本
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-规格成本
			for(MaroSpecificationsFoodCostsEntity maroSpecificationsFoodCosts:maroSpecificationsFoodCostsList){
				if(oConvertUtils.isEmpty(maroSpecificationsFoodCosts.getId())){
					//外键设置
					if(StringUtil.isNotEmpty(maroSpecificationsFoodCosts.getSpecificationsId())){
						UUIDUtil.setId(maroSpecificationsFoodCosts);
						maroSpecificationsFoodCosts.setMaterialclassId(maroMaterialClass.getId());
						this.save(maroSpecificationsFoodCosts);
					}
				}else{
					boolean have=false;
					String id=maroSpecificationsFoodCosts.getId();
					for(MaroSpecificationsFoodCostsEntity oldE:maroSpecificationsFoodCostsOldList){
						if(oldE.getId().equals(id)){
							have=true;
							break;
						}
					}
					if(!have){
						//外键设置
						if( maroSpecificationsFoodCosts.getMaterialclassId()==null|| maroSpecificationsFoodCosts.getMaterialclassId().equals("")){
							maroSpecificationsFoodCosts.setMaterialclassId(maroMaterialClass.getId());
						}
						this.save(maroSpecificationsFoodCosts);
					}
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(maroMaterialClass);
 		
 		
 		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			MqUtil.remoteOpt(null,"maroSynchronizationMaterialClassController","doUpdate",maroMaterialClass,maroSpecificationsFoodCostsList);
		}
	}

	
	public void delMain(MaroMaterialClassEntity maroMaterialClass) {
		//删除主表信息
		this.delete(maroMaterialClass);
		//===================================================================================
		//获取参数
		Object id0 = maroMaterialClass.getId();
		//===================================================================================
		//删除-规格成本
	    String hql0 = "from MaroSpecificationsFoodCostsEntity where 1 = 1 AND mATERIALCLASS_ID = ? ";
	    List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(maroSpecificationsFoodCostsOldList);
		
		//删除规格成本
		String mdsHql0 = "from MaroSpecificationsFoodCostsEntity where 1 = 1 AND materialclassId = ? ";
	    List<MaroSpecificationsFoodCostsEntity> mdsList = this.findHql(mdsHql0,maroMaterialClass.getId());
	    super.deleteAllEntitie(mdsList);
	    
	    if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
	    	MqUtil.remoteOpt(null,"maroSynchronizationMaterialClassController","doDel",maroMaterialClass);
	    }
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroMaterialClassEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroMaterialClassEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroMaterialClassEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,MaroMaterialClassEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{material_name}",String.valueOf(t.getMaterialName()));
 		sql  = sql.replace("#{coding}",String.valueOf(t.getCoding()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{classification_id}",String.valueOf(t.getClassificationId()));
 		sql  = sql.replace("#{denominated_unit}",String.valueOf(t.getDenominatedUnit()));
 		sql  = sql.replace("#{purchasing_price}",String.valueOf(t.getPurchasingPrice()));
 		sql  = sql.replace("#{create_source}",String.valueOf(t.getCreateSource()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}

	@Override
	public Integer checkCoding(String coding) {
		return maroMaterialClassDao.checkCoding(coding);
	}
}