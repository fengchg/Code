package com.maro.manager.shop.shop.service.impl;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.util.MqUtil;
import com.maro.common.util.UUIDUtil;
import com.maro.manager.shop.shop.dao.MaroShopDao;
import com.maro.manager.shop.shop.service.MaroShopServiceI;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.core.util.oConvertUtils;
import com.maro.platform.web.system.pojo.base.TSDepart;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service("maroShopService")
@Transactional
public class MaroShopServiceImpl extends CommonServiceImpl implements MaroShopServiceI {
	@Autowired
	private MaroShopDao maroShopDao;
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((MaroShopEntity)entity);
 	}
	
	public void addMain(MaroShopEntity maroShop,
	        List<MaroShopSeatEntity> maroShopSeatList){
			//保存主信息
			this.save(maroShop);
		
			/**保存-座位信息*/
			for(MaroShopSeatEntity maroShopSeat:maroShopSeatList){
				//外键设置
				maroShopSeat.setShopId(maroShop.getId());
				this.save(maroShopSeat);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(maroShop);
 			//MQ同步
 			if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
 				//初始化店铺队列
 				TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
 				try {
 					//初始化队列
 					//MqUtil.initClientMq(tsDepart.getOrgCode());
 					//initDB
					//utilService.initDB(tsDepart.getOrgCode(),null);
 				} catch (Exception e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 			}
	}

	
	public void updateMain(MaroShopEntity maroShop,
	        List<MaroShopSeatEntity> maroShopSeatList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(maroShop.getId())){
			try {
//				MaroShopEntity temp = findUniqueByProperty(MaroShopEntity.class, "id", maroShop.getId());
				MaroShopEntity temp = commonDao.getEntity(MaroShopEntity.class,maroShop.getId());
				if(temp == null) {
					temp = maroShop;
				}else {
					MyBeanUtils.copyBeanNotNull2Bean(maroShop, temp);
				}
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(maroShop);
		}
		//===================================================================================
		//获取参数
		Object id0 = maroShop.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-座位信息
	    String hql0 = "from MaroShopSeatEntity where 1 = 1 AND sHOP_ID = ? ";
	    List<MaroShopSeatEntity> maroShopSeatOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-座位信息
		if(maroShopSeatList!=null&&maroShopSeatList.size()>0){
		for(MaroShopSeatEntity oldE:maroShopSeatOldList){
			boolean isUpdate = false;
				for(MaroShopSeatEntity sendE:maroShopSeatList){
					//需要更新的明细数据-座位信息
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-座位信息
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-座位信息
			for(MaroShopSeatEntity maroShopSeat:maroShopSeatList){
				if(oConvertUtils.isEmpty(maroShopSeat.getId())){
					//设置id
					UUIDUtil.setId(maroShopSeat);
					//外键设置
					maroShopSeat.setShopId(maroShop.getId());
					this.save(maroShopSeat);
				}else{
					boolean have=false;
					String id=maroShopSeat.getId();
					for(MaroShopSeatEntity oldE:maroShopSeatOldList){
						if(oldE.getId().equals(id)){
							have=true;
							break;
						}
					}
					if(!have){
						//外键设置
						if(maroShopSeat.getShopId()==null||maroShopSeat.getShopId().equals("")){
							maroShopSeat.setShopId(maroShop.getId());
						}
						this.save(maroShopSeat);
					}
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(maroShop);
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "shopUpdateMain", maroShop,maroShopSeatList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public void delMain(MaroShopEntity maroShop) {
		//删除主表信息
		this.delete(maroShop);
		//===================================================================================
		//获取参数
		Object id0 = maroShop.getId();
		//===================================================================================
		//删除-座位信息
	    String hql0 = "from MaroShopSeatEntity where 1 = 1 AND sHOP_ID = ? ";
	    List<MaroShopSeatEntity> maroShopSeatOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(maroShopSeatOldList);
		//MQ同步
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			//初始化店铺队列
			TSDepart tsDepart = this.get(TSDepart.class, maroShop.getDepartId());
			try {
				MqUtil.remoteOpt(tsDepart.getOrgCode(), "mqController", "shopDelMain", maroShop);
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
 	public boolean doAddSql(MaroShopEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroShopEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroShopEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,MaroShopEntity t){
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
 		sql  = sql.replace("#{depart_id}",String.valueOf(t.getDepartId()));
 		sql  = sql.replace("#{equipment_number}",String.valueOf(t.getEquipmentNumber()));
 		sql  = sql.replace("#{number}",String.valueOf(t.getNumber()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{area}",String.valueOf(t.getArea()));
 		sql  = sql.replace("#{position}",String.valueOf(t.getPosition()));
 		sql  = sql.replace("#{la}",String.valueOf(t.getLa()));
 		sql  = sql.replace("#{lo}",String.valueOf(t.getLo()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{mail}",String.valueOf(t.getMail()));
 		sql  = sql.replace("#{open_time}",String.valueOf(t.getOpenTime()));
 		sql  = sql.replace("#{work_time}",String.valueOf(t.getWorkTime()));
 		sql  = sql.replace("#{introduce}",String.valueOf(t.getIntroduce()));
 		sql  = sql.replace("#{picture}",String.valueOf(t.getPicture()));
 		sql  = sql.replace("#{shop_info}",String.valueOf(t.getShopInfo()));
 		sql  = sql.replace("#{per_consume}",String.valueOf(t.getPerConsume()));
 		sql  = sql.replace("#{delete_flag}",String.valueOf(t.getDeleteFlag()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}

	@Override
	public String getShopIdByDepartId(String departId) {
		// TODO Auto-generated method stub
		Criteria maroShopEntity = this.getSession().createCriteria(MaroShopEntity.class);
		maroShopEntity.add(Restrictions.eq("departId", departId));
		List<MaroShopEntity> maroShopEntitys = maroShopEntity.list();
		if(maroShopEntitys!=null&&maroShopEntitys.size()>0){
			return maroShopEntitys.get(0).getId();
		}
		return null;
	}

	@Override
	public List<Map> getComboTree(
			String id,String departId, boolean admin) {
		// TODO Auto-generated method stub
		if(admin){
			return maroShopDao.getComboTreeAll(id);
		}else{
			return maroShopDao.getComboTree(id,departId);
		}
	}

	@Override
	public boolean changeStoreTypeByDepart(String departId, String type) {
		// TODO Auto-generated method stub
		int num=maroShopDao.changeStoreTypeByDepart(departId,type);
		return num==1?true:false;
	}

	@Override
	public MaroShopEntity getByDepartIdShop(String departId) {
		Criteria maroShopEntity = this.getSession().createCriteria(MaroShopEntity.class);
		maroShopEntity.add(Restrictions.eq("departId", departId));
		List<MaroShopEntity> maroShopEntitys = maroShopEntity.list();
		if(maroShopEntitys!=null&&maroShopEntitys.size()>0){
			return maroShopEntitys.get(0);
		}
		return null;
	}

	@Override
	public boolean isOnlySeatFlag(String shopId,String number) {
		// TODO Auto-generated method stub
		int num=maroShopDao.isOnlySeatFlag(shopId,number);
		return num==0?true:false;
	}

	@Override
	public boolean isOnlyShopNumber(String number) {
		int num=maroShopDao.isOnlyShopNumber(number);
		return num==0?true:false;
	}

	@Override
	public List<Map> getAllShop() {
		return maroShopDao.getAllShop();
	}
}