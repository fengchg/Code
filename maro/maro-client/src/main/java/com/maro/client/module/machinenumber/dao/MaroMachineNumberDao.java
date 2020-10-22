package com.maro.client.module.machinenumber.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

import com.maro.client.module.machinenumber.entity.MaroMachineNumberEntity;
import com.maro.platform.web.system.pojo.base.TSUser;

@MiniDao
public interface MaroMachineNumberDao {
	
	/**
	 * 根据部门与工号获得用户实体
	 */
	@Arguments("empNo")
	TSUser getByOrgIdEmpNo(String empNo);
	
	@Arguments({"deviceNumber","userId"})
	@Sql("update maro_machine_number set userid = :userId , UPDATE_NAME = SYSDATE() where device_number = :deviceNumber")
	void updateMachineNumber(String deviceNumber, String userId);
	
	@Arguments({"userId","pwd"})
	@Sql("update t_s_base_user set password = :pwd where id = :userId")
	void updateUserPwd(String userId, String pwd);
	
	@Arguments("deviceNumber")
	@Sql("select COUNT(0) from maro_machine_number where DEVICE_NUMBER = :deviceNumber ")
	Integer ifIsOrderMachine(String deviceNumber);
	
	@Arguments("userid")
	@Sql("select count(0) from t_s_role_user tsru,t_s_role tsr where tsru.roleid = tsr.id and tsr.rolecode = 'maro_operator' and tsru.userid = :userid ")
	Integer ifIsOperator(String userid);
	
	@Arguments("deviceNumber")
	@Sql("select * from maro_machine_number where device_number = :deviceNumber ")
	MaroMachineNumberEntity getDeviceNumber(String deviceNumber);
}
