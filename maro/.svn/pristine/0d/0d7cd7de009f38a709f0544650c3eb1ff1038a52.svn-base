package com.maro.manager.maroprint.maroprinter.service.impl;	
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.common.util.MqUtil;
import com.maro.common.util.UUIDUtil;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.manager.maroprint.maroprinter.dao.MaroPrinterDao;
import com.maro.manager.maroprint.maroprinter.entity.MaroPrinterEntity;
import com.maro.manager.maroprint.maroprinter.service.MaroPrinterServiceI;
import com.maro.manager.maroprint.maroprinterclassification.entity.MaroPrinterClassificationEntity;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.oConvertUtils;


@Service("maroPrinterService")
@Transactional
public class MaroPrinterServiceImpl extends CommonServiceImpl implements MaroPrinterServiceI {
	
	@Autowired
	MaroPrinterDao maroPrinterDao;
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((MaroPrinterEntity)entity);
 	}
	
	public void addMain(MaroPrinterEntity maroPrinter,List<MaroPrinterClassificationEntity> maroPrinterClassificationList){
		//保存主信息
		this.save(maroPrinter);
	
		/**保存-菜肴分类打印IP*/
		for(MaroPrinterClassificationEntity maroPrinterClassification:maroPrinterClassificationList){
			//外键设置
			maroPrinterClassification.setPrintrtId(maroPrinter.getId());
			this.save(maroPrinterClassification);
		}
		
		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
			MqUtil.remoteOpt(orgCode,"maroSynchronizationPrinterController","doAdd",maroPrinter,maroPrinterClassificationList);
 		}
		
		
		//执行新增操作配置的sql增强
		this.doAddSql(maroPrinter);
	}

	
	public void updateMain(MaroPrinterEntity maroPrinter,List<MaroPrinterClassificationEntity> maroPrinterClassificationList) {
		//保存主表信息
		this.saveOrUpdate(maroPrinter);
		//===================================================================================
		//获取参数
		Object id0 = maroPrinter.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-菜肴分类打印IP
	    String hql0 = "from MaroPrinterClassificationEntity where 1 = 1 AND pRINTRT_ID = ?";
	    List<MaroPrinterClassificationEntity> maroPrinterClassificationOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-菜肴分类打印IP
		if(maroPrinterClassificationList!=null&&maroPrinterClassificationList.size()>0){
		for(MaroPrinterClassificationEntity oldE:maroPrinterClassificationOldList){
			boolean isUpdate = false;
				for(MaroPrinterClassificationEntity sendE:maroPrinterClassificationList){
					//需要更新的明细数据-菜肴分类打印IP
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-菜肴分类打印IP
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-菜肴分类打印IP
			for(MaroPrinterClassificationEntity maroPrinterClassification:maroPrinterClassificationList){
				if(oConvertUtils.isEmpty(maroPrinterClassification.getId())){
					//外键设置
					UUIDUtil.setId(maroPrinterClassification);
					maroPrinterClassification.setPrintrtId(maroPrinter.getId());
					this.save(maroPrinterClassification);
				}else{
					   boolean have=false;
					   String id=maroPrinterClassification.getId();
					   for(MaroPrinterClassificationEntity oldE:maroPrinterClassificationOldList){
					      if(oldE.getId().equals(id)){
					         have=true;
					         break;
					      }
					   }
					   if(!have){
						   //外键设置
						   //if( maroPrinterClassification.getClassificationId()==null|| maroPrinterClassification.getClassificationId().equals("")){
						   //   maroPrinterClassification.setClassificationId(maroPrinterClassification.getClassificationId());
						   //}
					      this.save(maroPrinterClassification);
					   }
					}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(maroPrinter);
 		
 		/**=====发送给MQ========*/
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
			MqUtil.remoteOpt(orgCode,"maroSynchronizationPrinterController","doUpdate",maroPrinter,maroPrinterClassificationList);
 		}
	}

	
	public void delMain(MaroPrinterEntity maroPrinter) {
		//删除主表信息
		this.delete(maroPrinter);
		//===================================================================================
		//获取参数
		Object id0 = maroPrinter.getId();
		//===================================================================================
		//删除-菜肴分类打印IP
	    String hql0 = "from MaroPrinterClassificationEntity where 1 = 1 AND pRINTRT_ID = ?";
	    List<MaroPrinterClassificationEntity> maroPrinterClassificationOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(maroPrinterClassificationOldList);
		
		
		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
			String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
			MqUtil.remoteOpt(orgCode,"maroSynchronizationPrinterController","doDel",maroPrinter);
 		}
 		
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroPrinterEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroPrinterEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroPrinterEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,MaroPrinterEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{printer_ip}",String.valueOf(t.getPrinterIp()));
 		sql  = sql.replace("#{printer_port}",String.valueOf(t.getPrinterPort()));
 		sql  = sql.replace("#{printer_name}",String.valueOf(t.getPrinterName()));
 		sql  = sql.replace("#{printer_location}",String.valueOf(t.getPrinterLocation()));
 		sql  = sql.replace("#{printer_standby1}",String.valueOf(t.getPrinterStandby1()));
 		sql  = sql.replace("#{printer_standby2}",String.valueOf(t.getPrinterStandby2()));
 		sql  = sql.replace("#{printer_standby3}",String.valueOf(t.getPrinterStandby3()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	
 	@Override
	public Integer examinePrinterIp(String shopId,String ip) {
		return maroPrinterDao.examinePrinterIp(shopId, ip);
	}

	@Override
	public Map examineClassification(String shopId,String classificationId) {
		return maroPrinterDao.examineClassification(shopId,classificationId);
	}
}