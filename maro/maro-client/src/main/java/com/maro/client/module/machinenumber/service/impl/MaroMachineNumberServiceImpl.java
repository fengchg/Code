package com.maro.client.module.machinenumber.service.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.client.module.machinenumber.dao.MaroMachineNumberDao;
import com.maro.client.module.machinenumber.entity.MaroMachineNumberEntity;
import com.maro.client.module.machinenumber.service.MaroMachineNumberServiceI;
import com.maro.platform.core.common.dao.ICommonDao;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyClassLoader;
import com.maro.platform.core.util.PasswordUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.CgformEnhanceJavaInter;
import com.maro.platform.web.system.pojo.base.TSUser;

@Service("maroMachineNumberService")
@Transactional
public class MaroMachineNumberServiceImpl extends CommonServiceImpl implements MaroMachineNumberServiceI {

	@Autowired
	MaroMachineNumberDao maroMachineNumberDao;
	
	@Autowired
	public ICommonDao commonDao;
	
 	public void delete(MaroMachineNumberEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroMachineNumberEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(MaroMachineNumberEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroMachineNumberEntity t) throws Exception{
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
	private void doUpdateBus(MaroMachineNumberEntity t) throws Exception{
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
	private void doDelBus(MaroMachineNumberEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroMachineNumberEntity t){
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
		map.put("userid", t.getUserid());
		map.put("device_number", t.getDeviceNumber());
		map.put("job_number", t.getJobNumber());
		map.put("pwd", t.getPwd());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroMachineNumberEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{userid}",String.valueOf(t.getUserid()));
 		sql  = sql.replace("#{device_number}",String.valueOf(t.getDeviceNumber()));
 		sql  = sql.replace("#{job_number}",String.valueOf(t.getJobNumber()));
 		sql  = sql.replace("#{pwd}",String.valueOf(t.getPwd()));
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
					javaInter.execute("maro_machine_number",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}


 	@Override
	public TSUser getByOrgIdEmpNo(String empNo) {
		TSUser tsUser = maroMachineNumberDao.getByOrgIdEmpNo(empNo);
		return tsUser;
	}

	@Override
	public void updateMachineNumber(String deviceNumber, String userId) {
		maroMachineNumberDao.updateMachineNumber(deviceNumber,userId);
	}

	@Override
	public Integer updateUserPwd(String deviceNumber, String pwd) {
		MaroMachineNumberEntity entity = maroMachineNumberDao.getDeviceNumber(deviceNumber);
		if(entity!=null){
			TSUser user = super.getEntity(TSUser.class,entity.getUserid());
			//通过 用户帐号与明文密码加密
			String pString = PasswordUtil.encrypt(user.getUserName(), pwd, PasswordUtil.getStaticSalt());
			maroMachineNumberDao.updateUserPwd(user.getId(),pString);
			return 1;
		}else{
			return 0;
		}
		
	}

	@Override
	public Integer ifIsOrderMachine(String deviceNumber) {
		return maroMachineNumberDao.ifIsOrderMachine(deviceNumber);
	}

	@Override
	public Integer ifIsOperator(String userid) {
		return maroMachineNumberDao.ifIsOperator(userid);
	}
}