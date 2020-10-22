package com.maro.client.module.machinenumber.service;
import java.io.Serializable;

import com.maro.client.module.machinenumber.entity.MaroMachineNumberEntity;
import com.maro.platform.core.common.service.CommonService;
import com.maro.platform.web.system.pojo.base.TSUser;

public interface MaroMachineNumberServiceI extends CommonService{
	
 	public void delete(MaroMachineNumberEntity entity) throws Exception;
 	
 	public Serializable save(MaroMachineNumberEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroMachineNumberEntity entity) throws Exception;
 	
 	/**
	 * 根据工号获得用户实体
	 */
	TSUser getByOrgIdEmpNo(String empNo);
	
	/**
	 * //把用户与点菜机绑定在一起
	 * deviceNumber  设备号
	 * userId 用户id
	 */
	void updateMachineNumber(String deviceNumber,String userId);
	
	/**
	 * 更新密码
	 */
	Integer updateUserPwd(String deviceNumber,String pwd);
	
	/**
	 * 检查是否有此点菜机
	 * deviceNumber  设备号
	 */
	Integer ifIsOrderMachine(String deviceNumber);
	
	/**
	 * 判断是不是操作员
	 */
	Integer ifIsOperator(String userid);
}

