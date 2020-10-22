package com.maro.common.finance.operatin.service;

import com.maro.common.finance.operatin.pojo.entity.MaroOperatinEntity;
import com.maro.platform.core.common.service.CommonService;
/**
 * 流水模块接口
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
public interface MaroCommonOperatinServiceI extends CommonService {
	/**
	 * 根据流水id获取流水详细信息
	 * @param operatinId 流水id
	 * @return 成功返回MaroOperatinEntity对象，失败返回null
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public MaroOperatinEntity getMaroOperatinEntityById(String operatinId);
	/**
	 * 更新流水信息
	 * @param maroOperatinEntity 流水对象
	 * @return 成功返回true，失败返回false
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public boolean updateMaroOperatinEntity(MaroOperatinEntity maroOperatinEntity);
	/**
	 * 增加一条流水信息
	 * @param shopId 店铺id
	 * @param serverOrderId 服务单id
	 * @return 成功返回该记录id,失败返回null
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public String addMaroOperatinEntity(String shopId,String serverOrderId);
}
