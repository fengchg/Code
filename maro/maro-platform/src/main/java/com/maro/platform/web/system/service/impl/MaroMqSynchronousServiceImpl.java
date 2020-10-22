package com.maro.platform.web.system.service.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyClassLoader;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.CgformEnhanceJavaInter;
import com.maro.platform.web.system.dao.MaroMqSynchronousDao;
import com.maro.platform.web.system.pojo.base.MaroMqSynchronousEntity;
import com.maro.platform.web.system.service.MaroMqSynchronousServiceI;

@Service("maroMqSynchronousService")
@Transactional
public class MaroMqSynchronousServiceImpl extends CommonServiceImpl implements MaroMqSynchronousServiceI {

	@Autowired
	MaroMqSynchronousDao maroMqSynchronousDao;
	
 	public void delete(MaroMqSynchronousEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroMqSynchronousEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(MaroMqSynchronousEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroMqSynchronousEntity t) throws Exception{
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
	private void doUpdateBus(MaroMqSynchronousEntity t) throws Exception{
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
	private void doDelBus(MaroMqSynchronousEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroMqSynchronousEntity t){
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
		map.put("depart_id", t.getDepartId());
		map.put("depart_code", t.getDepartCode());
		map.put("operation_type", t.getOperationType());
		map.put("operation_method", t.getOperationMethod());
		map.put("data_table", t.getDataTable());
		map.put("data_table_id", t.getDataTableId());
		map.put("standby_a", t.getStandbyA());
		map.put("standby_b", t.getStandbyB());
		map.put("standby_c", t.getStandbyC());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroMqSynchronousEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{depart_id}",String.valueOf(t.getDepartId()));
 		sql  = sql.replace("#{depart_code}",String.valueOf(t.getDepartCode()));
 		sql  = sql.replace("#{operation_type}",String.valueOf(t.getOperationType()));
 		sql  = sql.replace("#{operation_method}",String.valueOf(t.getOperationMethod()));
 		sql  = sql.replace("#{data_table}",String.valueOf(t.getDataTable()));
 		sql  = sql.replace("#{data_table_id}",String.valueOf(t.getDataTableId()));
 		sql  = sql.replace("#{standby_a}",String.valueOf(t.getStandbyA()));
 		sql  = sql.replace("#{standby_b}",String.valueOf(t.getStandbyB()));
 		sql  = sql.replace("#{standby_c}",String.valueOf(t.getStandbyC()));
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
					javaInter.execute("maro_mq_synchronous",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public Integer ifShopIsExist(String[] departId) {
		Integer n = 0;
		for(String orgId : departId){
			n = maroMqSynchronousDao.ifShopIsExist(orgId);
			if(n != 0){
				return n;
			}
		}
		return n;
	}
}