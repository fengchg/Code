package com.maro.common.finance.account.service;

import java.util.List;

import com.maro.common.finance.account.pojo.entity.MaroAccountEntity;
import com.maro.platform.core.common.service.CommonService;
/**
 * 账户模块接口
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
public interface MaroCommonAccountServiceI extends CommonService {
	/**
	 * 查询所有账户信息
	 * @return 成功返回MaroAccountEntity数组，失败返回null
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public List<MaroAccountEntity> listAccount();
	/**
	 * 通过店铺id查询该店铺账户信息
	 * @param shopId 店铺id
	 * @return 成功返回MaroAccountEntity对象，失败返回null
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public MaroAccountEntity getAccount(String shopId);
	/**
	 * 通过店铺id增加账户余额
	 * @param shopId 店铺id
	 * @param money 金额
	 * @return 成功返回true，失败返回false
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public boolean addMoney(String shopId,String money);
	/**
	 * 通过店铺id减少账户余额
	 * @param shopId 店铺id
	 * @param money 金额
	 * @return 成功返回true，失败返回false
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public boolean minusMoney(String shopId,String money);
	/**
	 * 更新账户余额
	 * @param maroAccountEntity 需更新的账户信息
	 * @return 成功返回true，失败返回false
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public boolean updateMoney(MaroAccountEntity maroAccountEntity);
}
