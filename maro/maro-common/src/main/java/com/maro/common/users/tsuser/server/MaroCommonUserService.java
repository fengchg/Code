package com.maro.common.users.tsuser.server;

import com.maro.common.users.tsuser.pojo.vo.UserInfoVO;
import com.maro.platform.core.common.service.CommonService;
import com.maro.platform.web.system.pojo.base.TSUser;

import java.util.List;
import java.util.Map;

public interface MaroCommonUserService extends CommonService{
	/**
	 * 通过用户名、密码进行系统登录
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return 成功返回UserInfoVO信息，失败返回null
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public UserInfoVO clientLogin(String userName,String passWord);
	/**
	 * 根据机构id查找员工
	 * departId 机构id
	 */
	List<TSUser> tsUserList(String departId);

	/**
	 * 根据班次code和用户id获取该用户是否已经登录并还未交班
	 * @param shiftCode 班次code
	 * @param userId 用户id
	 */
	List<Map> getIsLogin(String shiftCode, String userId);

	/**
	 * 玩maro_client_shift表中新增一条记录
	 * @param shiftCode
	 * @param userId
	 */
	void addShift(String shiftCode, String userId);


	/**
	 * 
	 */
}
