package com.maro.common.shop.service;

import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.platform.core.common.service.CommonService;

import java.util.List;
import java.util.Map;

/**
 * 店铺模块接口
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
public interface MaroCommonShopServiceI extends CommonService {
	/**
	 * 通过店铺id获取对应的该店铺的座位信息
	 * @param shopId 店铺id
	 * @return 成功返回MaroShopSeatEntity数组，失败返回null
	 * @author gongdaohai
	 * @since v1.0,2018年4月11日
	 * @version
	 */
	public List<MaroShopSeatEntity> listShopSeatInfoByShopId(String shopId);
	/**
	 * 通过组织机构id获取对应的该店铺的座位信息
	 * @param departId 组织机构id
	 * @return 成功返回MaroShopSeatEntity数组，失败返回null
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public List<MaroShopSeatEntity> listShopSeatInfoByDepartId(String departId);
	/**
	 * 根据座位id获取座位详细信息
	 * @param seatId 座位id
	 * @return 成功返回MaroShopSeatEntity对象，失败返回null
	 * @author gongdaohai
	 * @since v1.0,2018年4月11日
	 * @version
	 */
	public MaroShopSeatEntity getShopSeatInfoBySeatId(String seatId);
	/**
	 * 通过座位id修改座位的标志
	 * @param seatId 座位id
	 * @param flag 状态标志 1：已使用 2：未使用
	 * @return 成功返回true，失败返回false
	 * @author gongdaohai
	 * @since v1.0,2018年4月10日
	 * @version
	 */
	public Boolean updateFlag(String seatId,Integer flag);

    List<Map<String,Object>> listShopSeatInfoBySql(String shopId);
}
