package com.maro.manager.dishes.setmeal.service.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.UUIDUtil;
import com.maro.manager.dishes.setmeal.dao.MaroSetmealDao;
import com.maro.manager.dishes.setmeal.entity.MaroSetmealEntity;
import com.maro.manager.dishes.setmeal.service.MaroSetmealServiceI;
import com.maro.manager.dishes.setmealdishes.entity.MaroAddSetmealSelectVO;
import com.maro.manager.dishes.setmealdishes.entity.MaroSetmealDishesEntity;
import com.maro.manager.dishes.setmealdishes.entity.MaroSetmealDishesSelectEntity;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.core.util.oConvertUtils;


@Service("maroSetmealService")
@Transactional
public class MaroSetmealServiceImpl extends CommonServiceImpl implements MaroSetmealServiceI {
	
	@Autowired
	MaroSetmealDao maroSetmealDao;
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		//this.doDelSql((MaroSetmealEntity)entity);
 	}
	
	public void addMain(MaroSetmealEntity maroSetmeal,List<MaroSetmealDishesEntity> maroSetmealDishesList){
			//保存主信息
			String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
			String sysCompanyCode = ResourceUtil.getSessionUser().getCurrentDepart().getId();
			maroSetmeal.setSysOrgCode(orgCode);
			maroSetmeal.setSysCompanyCode(sysCompanyCode);
			this.save(maroSetmeal);
		
			/**保存-套餐菜肴*/
			for(MaroSetmealDishesEntity maroSetmealDishes:maroSetmealDishesList){
				//外键设置
				maroSetmealDishes.setSetmealId(maroSetmeal.getId());
				this.save(maroSetmealDishes);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(maroSetmeal);
	}
	
	@Override
	public void addMain2(MaroDishesEntity maroDishes,List<MaroSetmealDishesEntity> maroSetmealDishesList) {
		
		this.save(maroDishes);
		
		/**保存-套餐菜肴*/
		for(MaroSetmealDishesEntity maroSetmealDishes:maroSetmealDishesList){
			//外键设置
			maroSetmealDishes.setSetmealId(maroDishes.getId());
			this.save(maroSetmealDishes);
		}
		
		/**=====发送给MQ========*/
			if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
				MqUtil.remoteOpt(maroDishes.getSysOrgCode(),"maroSynchronizationSetmealController","doAdd",maroDishes,maroSetmealDishesList);
	 		}
	}

	@Override
	public void updateMain(MaroSetmealEntity maroSetmeal,List<MaroSetmealDishesEntity> maroSetmealDishesList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(maroSetmeal.getId())){
			try {
				MaroSetmealEntity temp = findUniqueByProperty(MaroSetmealEntity.class, "id", maroSetmeal.getId());
				MyBeanUtils.copyBeanNotNull2Bean(maroSetmeal, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(maroSetmeal);
		}
		//===================================================================================
		//获取参数
		Object id0 = maroSetmeal.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-套餐菜肴
	    String hql0 = "from MaroSetmealDishesEntity where 1 = 1 AND sETMEAL_ID = ? ";
	    List<MaroSetmealDishesEntity> maroSetmealDishesOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-套餐菜肴
		if(maroSetmealDishesList!=null&&maroSetmealDishesList.size()>0){
		for(MaroSetmealDishesEntity oldE:maroSetmealDishesOldList){
			boolean isUpdate = false;
				for(MaroSetmealDishesEntity sendE:maroSetmealDishesList){
					//需要更新的明细数据-套餐菜肴
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-套餐菜肴
		    		super.delete(oldE);
		    		//获取套餐类中的套餐菜
			    	List<MaroSetmealDishesSelectEntity> setmealDishesSelect = super.findByProperty(MaroSetmealDishesSelectEntity.class,"setmealishesId",oldE.getId());
			    	//删除套餐菜
			    	this.deleteAllEntitie(setmealDishesSelect);
	    		}
	    		
			}
			//3.持久化新增的数据-套餐菜肴
			for(MaroSetmealDishesEntity maroSetmealDishes:maroSetmealDishesList){
				if(oConvertUtils.isEmpty(maroSetmealDishes.getId())){
					//外键设置
					maroSetmealDishes.setSetmealId(maroSetmeal.getId());
					UUIDUtil.setId(maroSetmealDishes);
					this.save(maroSetmealDishes);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(maroSetmeal);
	}

	@Override
	public void updateMain2(MaroDishesEntity maroDishes,List<MaroSetmealDishesEntity> maroSetmealDishesList) {
		//保存主表信息
				if(StringUtil.isNotEmpty(maroDishes.getId())){
					try {
						maroDishes.setPinyinCode(maroDishes.getCoding());
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
				//1.查询出数据库的明细数据-套餐菜肴
			    String hql0 = "from MaroSetmealDishesEntity where 1 = 1 AND sETMEAL_ID = ? ";
			    List<MaroSetmealDishesEntity> maroSetmealDishesOldList = this.findHql(hql0,id0);
				//2.筛选更新明细数据-套餐菜肴
				if(maroSetmealDishesList!=null&&maroSetmealDishesList.size()>0){
				for(MaroSetmealDishesEntity oldE:maroSetmealDishesOldList){
					boolean isUpdate = false;
						for(MaroSetmealDishesEntity sendE:maroSetmealDishesList){
							//需要更新的明细数据-套餐菜肴
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
				    		//如果数据库存在的明细，前台没有传递过来则是删除-套餐菜肴
				    		super.delete(oldE);
				    		//获取套餐类中的套餐菜
					    	List<MaroSetmealDishesSelectEntity> setmealDishesSelect = super.findByProperty(MaroSetmealDishesSelectEntity.class,"setmealishesId",oldE.getId());
					    	//删除套餐菜
					    	this.deleteAllEntitie(setmealDishesSelect);
			    		}
			    		
					}
					//3.持久化新增的数据-套餐菜肴
					for(MaroSetmealDishesEntity maroSetmealDishes:maroSetmealDishesList){
						if(oConvertUtils.isEmpty(maroSetmealDishes.getId())){
							//外键设置
							maroSetmealDishes.setSetmealId(maroDishes.getId());
							UUIDUtil.setId(maroSetmealDishes);
							this.save(maroSetmealDishes);
						}
					}
				}
				
				/**=====发送给MQ========*/
				if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
					String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
					MqUtil.remoteOpt(orgCode,"maroSynchronizationSetmealController","doUpdate",maroDishes,maroSetmealDishesList);
		 		}
		
	}
	
	@Override
	public void delMain(MaroSetmealEntity maroSetmeal) {
		//删除主表信息
		this.delete(maroSetmeal);
		//===================================================================================
		//获取参数
		Object id0 = maroSetmeal.getId();
		//===================================================================================
		//删除-套餐菜肴
	    String hql0 = "from MaroSetmealDishesEntity where 1 = 1 AND sETMEAL_ID = ? ";
	    List<MaroSetmealDishesEntity> maroSetmealDishesOldList = this.findHql(hql0,id0);
	    
	    //当删除套餐时 把套餐类与套餐菜也删除
	    for (MaroSetmealDishesEntity maroSetmealDishesEntity : maroSetmealDishesOldList) {
	    	//获取套餐类中的套餐菜
	    	List<MaroSetmealDishesSelectEntity> setmealDishesSelect = super.findByProperty(MaroSetmealDishesSelectEntity.class,"setmealishesId",maroSetmealDishesEntity.getId());
	    	//删除套餐菜
	    	this.deleteAllEntitie(setmealDishesSelect);
	    }

	    //删除-套餐菜肴
		this.deleteAllEntitie(maroSetmealDishesOldList);
		
	}
	
	@Override
	public void delMain2(MaroDishesEntity maroDishes) {
		//删除主表信息
		this.delete(maroDishes);
		//===================================================================================
		//获取参数
		Object id0 = maroDishes.getId();
		//===================================================================================
		//删除-套餐菜肴
		String hql0 = "from MaroSetmealDishesEntity where 1 = 1 AND sETMEAL_ID = ? ";
		List<MaroSetmealDishesEntity> maroSetmealDishesOldList = this.findHql(hql0,id0);
		
		//当删除套餐时 把套餐类与套餐菜也删除
		for (MaroSetmealDishesEntity maroSetmealDishesEntity : maroSetmealDishesOldList) {
			//获取套餐类中的套餐菜
			List<MaroSetmealDishesSelectEntity> setmealDishesSelect = super.findByProperty(MaroSetmealDishesSelectEntity.class,"setmealishesId",maroSetmealDishesEntity.getId());
			//删除套餐菜
			this.deleteAllEntitie(setmealDishesSelect);
		}
		
		//删除-套餐菜肴
		this.deleteAllEntitie(maroSetmealDishesOldList);
		
		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
			MqUtil.remoteOpt(orgCode,"maroSynchronizationSetmealController","doDel",maroDishes);
		}
		
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroSetmealEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroSetmealEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroSetmealEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,MaroSetmealEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{setmeal_name}",String.valueOf(t.getSetmealName()));
 		sql  = sql.replace("#{swift_code}",String.valueOf(t.getSwiftCode()));
 		sql  = sql.replace("#{setmeal_type}",String.valueOf(t.getSetmealType()));
 		sql  = sql.replace("#{package_price}",String.valueOf(t.getPackagePrice()));
 		sql  = sql.replace("#{member_price}",String.valueOf(t.getMemberPrice()));
 		sql  = sql.replace("#{setmeal_picture}",String.valueOf(t.getSetmealPicture()));
 		sql  = sql.replace("#{market_type}",String.valueOf(t.getMarketType()));
 		sql  = sql.replace("#{synopsis}",String.valueOf(t.getSynopsis()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}

	@Override
	public void doAddDishesSelect(MaroAddSetmealSelectVO setmealSelectVO) {
		
		//添加之前删除原有的
		maroSetmealDao.deleteSetmealSelect(setmealSelectVO.getSetmealDishesId());
		
		//更新套餐的几选几
		MaroSetmealDishesEntity s = super.getEntity(MaroSetmealDishesEntity.class,setmealSelectVO.getSetmealDishesId());
		s.setBeginNum(setmealSelectVO.getBeginNum());
		s.setSelectNum(setmealSelectVO.getSelectNum());
		super.saveOrUpdate(s);
		
		//添加套餐菜
		if(setmealSelectVO.getSetmealDishesSelect().size()!=0){
			for (int i = 0; i < setmealSelectVO.getSetmealDishesSelect().size(); i++) {
				MaroSetmealDishesSelectEntity entity = setmealSelectVO.getSetmealDishesSelect().get(i);
				entity.setSetmealishesId(setmealSelectVO.getSetmealDishesId());
				//UUIDUtil.setId(entity);
				super.save(entity);
			}
		}
		
		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
			MqUtil.remoteOpt(orgCode,"maroSynchronizationSetmealController","doAddDishesSelect",setmealSelectVO);
 		}
		
	}

	@Override
	public void doDelSetmealDishesSelect(String selectId) {
		MaroSetmealDishesSelectEntity ds = new MaroSetmealDishesSelectEntity();
		ds.setId(selectId);
		super.delete(ds);
		
		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
			MqUtil.remoteOpt(orgCode,"maroSynchronizationSetmealController","doDelSetmealDishesSelect",selectId);
 		}
	}
	
}