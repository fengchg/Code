package com.maro.manager.discount.service.impl;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.UUIDUtil;
import com.maro.manager.discount.dao.MaroDiscountDao;
import com.maro.manager.discount.entity.MaroDishesDiscountEntity;
import com.maro.manager.discount.service.MaroDishesDiscountServiceI;
import com.maro.manager.discountdetail.entity.MaroDishesDiscountDetailEntity;
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


@Service("maroDishesDiscountService")
@Transactional
public class MaroDishesDiscountServiceImpl extends CommonServiceImpl implements MaroDishesDiscountServiceI {
	@Autowired
	private MaroDiscountDao maroDiscountDao;
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((MaroDishesDiscountEntity)entity);
 	}
	
	public void addMain(MaroDishesDiscountEntity maroDishesDiscount,
	        List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList){
			//保存主信息
			this.save(maroDishesDiscount);
		
			/**保存-详细*/
			for(MaroDishesDiscountDetailEntity maroDishesDiscountDetail:maroDishesDiscountDetailList){
				//外键设置
				maroDishesDiscountDetail.setDiscountId(maroDishesDiscount.getId());
				this.save(maroDishesDiscountDetail);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(maroDishesDiscount);
			//MQ同步
			if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
				//初始化店铺队列
				MaroShopEntity maroShop = this.get(MaroShopEntity.class, maroDishesDiscount.getShopId());
				TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
				try {
					MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "discountAddMain", maroDishesDiscount,maroDishesDiscountDetailList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	
	public void updateMain(MaroDishesDiscountEntity maroDishesDiscount,
	        List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(maroDishesDiscount.getId())){
			try {
				MaroDishesDiscountEntity temp = findUniqueByProperty(MaroDishesDiscountEntity.class, "id", maroDishesDiscount.getId());
				MyBeanUtils.copyBeanNotNull2Bean(maroDishesDiscount, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(maroDishesDiscount);
		}
		//===================================================================================
		//获取参数
		Object id0 = maroDishesDiscount.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-详细
	    String hql0 = "from MaroDishesDiscountDetailEntity where 1 = 1 AND dISCOUNT_ID = ? ";
	    List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-详细
		if(maroDishesDiscountDetailList!=null&&maroDishesDiscountDetailList.size()>0){
		for(MaroDishesDiscountDetailEntity oldE:maroDishesDiscountDetailOldList){
			boolean isUpdate = false;
				for(MaroDishesDiscountDetailEntity sendE:maroDishesDiscountDetailList){
					//需要更新的明细数据-详细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-详细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-详细
			for(MaroDishesDiscountDetailEntity maroDishesDiscountDetail:maroDishesDiscountDetailList){
				if(oConvertUtils.isEmpty(maroDishesDiscountDetail.getId())){
					//设置id
					UUIDUtil.setId(maroDishesDiscountDetail);
					//外键设置
					maroDishesDiscountDetail.setDiscountId(maroDishesDiscount.getId());
					this.save(maroDishesDiscountDetail);
				}else{
					boolean have=false;
					String id=maroDishesDiscountDetail.getId();
					for(MaroDishesDiscountDetailEntity oldE:maroDishesDiscountDetailOldList){
						if(oldE.getId().equals(id)){
							have=true;
							break;
						}
					}
					if(!have){
						//外键设置
						if(maroDishesDiscountDetail.getDiscountId()==null||maroDishesDiscountDetail.getDiscountId().equals("")){
							maroDishesDiscountDetail.setDiscountId(maroDishesDiscount.getId());
						}
						this.save(maroDishesDiscountDetail);
					}
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(maroDishesDiscount);
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, maroDishesDiscount.getShopId());
			TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "discountUpdateMain", maroDishesDiscount,maroDishesDiscountDetailList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public void delMain(MaroDishesDiscountEntity maroDishesDiscount) {
		//删除主表信息
		this.delete(maroDishesDiscount);
		//===================================================================================
		//获取参数
		Object id0 = maroDishesDiscount.getId();
		//===================================================================================
		//删除-详细
	    String hql0 = "from MaroDishesDiscountDetailEntity where 1 = 1 AND dISCOUNT_ID = ? ";
	    List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(maroDishesDiscountDetailOldList);
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			MaroShopEntity maroShop = this.get(MaroShopEntity.class, maroDishesDiscount.getShopId());
			TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "discountDelMain", maroDishesDiscount);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroDishesDiscountEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroDishesDiscountEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroDishesDiscountEntity t){
	 	return true;
 	}

	@Override
	public List<MaroDishesDiscountEntity> getDiscount(String shopId) {
		List<MaroDishesDiscountEntity> MaroDishesDiscountEntityList=null;
 		if(shopId==null||shopId.equals("")){
			String hql0 = "from MaroDishesDiscountEntity where isEnable is null or isEnable='Y'";
			MaroDishesDiscountEntityList = this.findHql(hql0);
		}else{
			String hql0 = "from MaroDishesDiscountEntity where shopId=? and isEnable is null or isEnable='Y'";
			MaroDishesDiscountEntityList = this.findHql(hql0,shopId);
		}
		if(MaroDishesDiscountEntityList==null){
 			return null;
		}
		for(MaroDishesDiscountEntity m:MaroDishesDiscountEntityList){
			String hql0 = "from MaroDishesDiscountDetailEntity where 1 = 1 AND dISCOUNT_ID = ? ";
			List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailOldList = this.findHql(hql0,m.getId());
			m.setDishesDiscountDetails(maroDishesDiscountDetailOldList);
		}
		return MaroDishesDiscountEntityList;
	}

	@Override
	public List<Map> getDiscountDetailByDiscountId(String discountId) {
		return maroDiscountDao.getDiscountDetailByDiscountId(discountId);
	}


	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,MaroDishesDiscountEntity t){
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
 		sql  = sql.replace("#{discount_name}",String.valueOf(t.getDiscountName()));
 		sql  = sql.replace("#{discount_detail}",String.valueOf(t.getDiscountDetail()));
 		sql  = sql.replace("#{discount_way}",String.valueOf(t.getDiscountWay()));
 		sql  = sql.replace("#{discount_type}",String.valueOf(t.getDiscountType()));
 		sql  = sql.replace("#{start_week}",String.valueOf(t.getStartWeek()));
 		sql  = sql.replace("#{end_week}",String.valueOf(t.getEndWeek()));
 		sql  = sql.replace("#{start_time}",String.valueOf(t.getStartTime()));
 		sql  = sql.replace("#{end_time}",String.valueOf(t.getEndTime()));
 		sql  = sql.replace("#{discount_number}",String.valueOf(t.getDiscountNumber()));
 		sql  = sql.replace("#{is_enable}",String.valueOf(t.getIsEnable()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}