package com.maro.manager.dishes.dishes.service.impl;

import com.maro.common.constant.DepartConstant;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.dishes.dishes.dao.MaroDishesDao;
import com.maro.manager.dishes.dishes.service.MaroDishesServiceI;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.manager.dishes.specificationsprice.entity.MaroSpecificationsPriceEntity;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.core.util.oConvertUtils;
import com.maro.platform.web.system.pojo.base.TSDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service("maroDishesService")
@Transactional
public class MaroDishesServiceImpl extends CommonServiceImpl implements MaroDishesServiceI {
	
	@Autowired
	MaroDishesDao maroDishesDao;
	@Autowired
	private UtilServiceI utilService;
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((MaroDishesEntity)entity);
 	}
	
	public void addMain(MaroDishesEntity maroDishes,List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList){
		//保存主信息
		this.save(maroDishes);
	
		/**保存-规格*/
		for(MaroDishesSpecificationsEntity maroDishesSpecifications:maroDishesSpecificationsList){
			//外键设置
			maroDishesSpecifications.setMaroDishesId(maroDishes.getId());
			String dsCode = maroDishes.getCoding() + maroDishesSpecifications.getSpecificationsCode();
			maroDishesSpecifications.setDsCode(dsCode);
			this.save(maroDishesSpecifications);
		}
		//执行新增操作配置的sql增强
		this.doAddSql(maroDishes);
		
		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
 			//如果是所有店铺 推所有
			if(maroDishes.getSysCompanyCode().equals("0")){
				//MqUtil.sendEntity(null,maroDishes,maroDishesSpecificationsList);
				MqUtil.remoteOpt(null,"maroSynchronizationDishesController","doAdd",maroDishes,maroDishesSpecificationsList);
			}else{
				String orgCode = utilService.getOrgCode(maroDishes.getSysCompanyCode());
				//MqUtil.sendEntity(orgCode,maroDishes,maroDishesSpecificationsList);
				MqUtil.remoteOpt(orgCode,"maroSynchronizationDishesController","doAdd",maroDishes,maroDishesSpecificationsList);
			}
 		}
	}

	
	public void updateMain(MaroDishesEntity maroDishes,List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(maroDishes.getId())){
			try {
				MaroDishesEntity temp = findUniqueByProperty(MaroDishesEntity.class, "id", maroDishes.getId());
				MyBeanUtils.copyBeanNotNull2Bean(maroDishes, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(maroDishes);
		}
		//===================================================================================
		//获取参数
		Object id0 = maroDishes.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-规格
	    String hql0 = "from MaroDishesSpecificationsEntity where 1 = 1 AND mARO_DISHES_ID = ? ";
	    List<MaroDishesSpecificationsEntity> maroDishesSpecificationsOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-规格
		if(maroDishesSpecificationsList!=null&&maroDishesSpecificationsList.size()>0){
		for(MaroDishesSpecificationsEntity oldE:maroDishesSpecificationsOldList){
			boolean isUpdate = false;
				for(MaroDishesSpecificationsEntity sendE:maroDishesSpecificationsList){
					//需要更新的明细数据-规格
					if(oldE.getId().equals(sendE.getId())){
		    			try {
		    				String dsCode = maroDishes.getCoding() + sendE.getSpecificationsCode();
		    				sendE.setDsCode(dsCode);
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-规格
		    		super.delete(oldE);
		    		//当删除规格后，应当把 规格成本 与 规格价格的记录都删除
		    		//删除规格成本
		    		String mdsHql0 = "from MaroSpecificationsFoodCostsEntity where 1 = 1 AND specificationsId = ? ";
		    	    List<MaroSpecificationsFoodCostsEntity> mdsList = this.findHql(mdsHql0,oldE.getId().toString());
		    	    super.deleteAllEntitie(mdsList);
		    		
		    		//删除规格价格
		    		String mdsHql1 = "from MaroSpecificationsPriceEntity where 1 = 1 AND specificationsId = ? ";
		    		List<MaroSpecificationsPriceEntity> msfcList = this.findHql(mdsHql1,oldE.getId().toString());
		    		super.deleteAllEntitie(msfcList);	    		

	    		}
	    		
			}
			//3.持久化新增的数据-规格
			for(MaroDishesSpecificationsEntity maroDishesSpecifications:maroDishesSpecificationsList){
				if(oConvertUtils.isEmpty(maroDishesSpecifications.getId())){
					//外键设置
					maroDishesSpecifications.setMaroDishesId(maroDishes.getId());
					UUIDUtil.setId(maroDishesSpecifications);
					this.save(maroDishesSpecifications);
				}else{
					   boolean have=false;
					   String id=maroDishesSpecifications.getId();
					   for(MaroDishesSpecificationsEntity oldE:maroDishesSpecificationsOldList){
					      if(oldE.getId().equals(id)){
					         have=true;
					         break;
					      }
					   }
					   if(!have){
						   //外键设置
						   if( maroDishesSpecifications.getMaroDishesId()==null|| maroDishesSpecifications.getMaroDishesId().equals("")){
							   maroDishesSpecifications.setMaroDishesId(maroDishes.getId());
						   }
					      this.save(maroDishesSpecifications);
					   }
					}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(maroDishes);
 		
 		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
	 		//如果是所有店铺 推所有
			if(maroDishes.getSysCompanyCode().equals("0")){
				MqUtil.remoteOpt(null,"maroSynchronizationDishesController","doUpdate",maroDishes,maroDishesSpecificationsList);
			}else{
				String orgCode = utilService.getOrgCode(maroDishes.getSysCompanyCode());
				MqUtil.remoteOpt(orgCode,"maroSynchronizationDishesController","doUpdate",maroDishes,maroDishesSpecificationsList);
			}
		}
 		
	}

	
	public void delMain(MaroDishesEntity maroDishes) {
		
		//删除主表信息
		this.delete(maroDishes);
		//===================================================================================
		//获取参数
		Object id0 = maroDishes.getId();
		//===================================================================================
		//删除-规格
	    String hql0 = "from MaroDishesSpecificationsEntity where 1 = 1 AND mARO_DISHES_ID = ? ";
	    List<MaroDishesSpecificationsEntity> maroDishesSpecificationsOldList = this.findHql(hql0,id0);
	    
	    //先根据菜肴id获取规格
	    List<MaroDishesSpecificationsEntity> dishesSpecificationsList = super.findByProperty(MaroDishesSpecificationsEntity.class,"maroDishesId",maroDishes.getId());
	    
		this.deleteAllEntitie(maroDishesSpecificationsOldList);
		
		/**  当删除菜肴时需要删除 成本卡 与 价格 */
		for(int i=0;i<dishesSpecificationsList.size();i++){
			//根据规格id 删除规格成本
			String mdsHql0 = "from MaroSpecificationsFoodCostsEntity where 1 = 1 AND specificationsId = ? ";
		    List<MaroSpecificationsFoodCostsEntity> mdsList = this.findHql(mdsHql0,dishesSpecificationsList.get(i).getId().toString());
		    super.deleteAllEntitie(mdsList);
		    
		    //根据规格id 删除规格价格
			String mdsHql1 = "from MaroSpecificationsPriceEntity where 1 = 1 AND specificationsId = ? ";
			List<MaroSpecificationsPriceEntity> msfcList = this.findHql(mdsHql1,dishesSpecificationsList.get(i).getId().toString());
			super.deleteAllEntitie(msfcList);	  
		}
		
		
		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
	 		//如果是所有店铺 推所有
			if(maroDishes.getSysCompanyCode().equals("0")){
				MqUtil.remoteOpt(null,"maroSynchronizationDishesController","doDel",maroDishes);
			}else{
				//String orgCode = utilService.getOrgCode(maroDishes.getSysCompanyCode());
				String orgCode = maroDishes.getSysOrgCode();
				MqUtil.remoteOpt(orgCode,"maroSynchronizationDishesController","doDel",maroDishes);
			}
		}
		
	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroDishesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroDishesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroDishesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,MaroDishesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{coding}",String.valueOf(t.getCoding()));
 		sql  = sql.replace("#{dishes_name}",String.valueOf(t.getDishesName()));
 		sql  = sql.replace("#{pinyin_code}",String.valueOf(t.getPinyinCode()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{cost_price}",String.valueOf(t.getCostPrice()));
 		sql  = sql.replace("#{sales_price}",String.valueOf(t.getSalesPrice()));
 		sql  = sql.replace("#{net_sales}",String.valueOf(t.getNetSales()));
 		sql  = sql.replace("#{take_out}",String.valueOf(t.getTakeOut()));
 		sql  = sql.replace("#{booking}",String.valueOf(t.getBooking()));
 		sql  = sql.replace("#{create_source}",String.valueOf(t.getCreateSource()));
 		sql  = sql.replace("#{describes}",String.valueOf(t.getDescribes()));
 		sql  = sql.replace("#{picture}",String.valueOf(t.getPicture()));
 		sql  = sql.replace("#{inventory}",String.valueOf(t.getInventory()));
 		sql  = sql.replace("#{unit}",String.valueOf(t.getUnit()));
 		sql  = sql.replace("#{specifications_id}",String.valueOf(t.getSpecificationsId()));
 		sql  = sql.replace("#{note_id}",String.valueOf(t.getNoteId()));
 		sql  = sql.replace("#{classification_id}",String.valueOf(t.getClassificationId()));
 		sql  = sql.replace("#{dishes_classification}",String.valueOf(t.getDishesClassification()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}

	@Override
	public List<MaroDishesSpecificationsEntity> getSpecificationsList(String maroDishesId) {
		List<MaroDishesSpecificationsEntity> list = findByProperty(MaroDishesSpecificationsEntity.class,"maroDishesId",maroDishesId);
		return list;
	}

	@Override
	public List<TSDepart> tsDepartList() {
		//String sql = "select id,departname from t_s_depart where or_not_store = 'Y'";
		List<TSDepart> tsDepartList = findByProperty(TSDepart.class,"orNotStore",DepartConstant.STORETYPE_YES);
		return tsDepartList;
	}
	
	@Override
	public String getDenominatedUnit(String materialClassId) {
		return maroDishesDao.getDenominatedUnit(materialClassId);
	}
	
	@Override
	public Integer dishesSpecificationsCount(String shopId,MaroDishesEntity maroDishes) {
		String userName = ResourceUtil.getSessionUser().getUserName();
		return maroDishesDao.dishesSpecificationsCount(shopId, userName,maroDishes);
	}

	@Override
	public List<MaroDishesEntity> dishesSpecificationsList(String shopId,MaroDishesEntity maroDishes,int page,int rows) {
		
		int pageNo = 0;
		if(page == 1){
			pageNo = 0;
		}else{
			pageNo = (page - 1) * rows;
		}

        //验证是不是管理员的角色
        boolean maroAdmin = Util.ifRoleCode();
		return maroDishesDao.dishesSpecificationsList(shopId, maroAdmin,maroDishes,pageNo,rows);
		
	}

	@Override
	public Integer checkCoding(String coding,String sysCompanyCode) {
		// TODO Auto-generated method stub0
		
		if(sysCompanyCode.equals("0")){
			return maroDishesDao.checkCoding(coding);
		}else{
			return maroDishesDao.checkCoding(coding, sysCompanyCode);
		}
	}

	@Override
	public List<Map<String,Object>> getMaroDishesEntityList(String code,String company) {
		return maroDishesDao.getMaroDishesEntityList(code,company);
	}


}