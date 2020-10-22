package com.maro.manager.shop.shop.service;
import java.util.List;
import java.util.Map;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.manager.common.entity.ComboTree;
import com.maro.platform.core.common.service.CommonService;

public interface MaroShopServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(MaroShopEntity maroShop,
	        List<MaroShopSeatEntity> maroShopSeatList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(MaroShopEntity maroShop,
	        List<MaroShopSeatEntity> maroShopSeatList);
	public void delMain (MaroShopEntity maroShop);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroShopEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroShopEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroShopEntity t);
 	/**
 	 * 通过部门id获取店铺id
 	 * @param departId
 	 * @return
 	 * @author gongdaohai
 	 * @since v1.0,2018年4月4日
 	 * @version
 	 */
	public String getShopIdByDepartId(String departId);
	/**
	 * 获取增加店铺时店铺的关联组织机构树结构,
	 * 当为admin角色时，展示所有的树结构，否则展示该用户的组织机构树结构
	 * @param departId
	 * @param departId
	 * @param id
	 * @return
 	 * @author gongdaohai
 	 * @since v1.0,2018年4月4日
 	 * @version
	 */
	public List<Map> getComboTree(String id,String departId,boolean admin);
	/**
	 * 通过部门id修改该店铺属性
	 * @param departId 部门id
	 * @param type 类型'Y' or 'N'
	 * @return 成功true，失败false
 	 * @author gongdaohai
 	 * @since v1.0,2018年4月4日
 	 * @version
	 */
	public boolean changeStoreTypeByDepart(String departId,String type);
	/**
	 * 通过部门id获取店铺详情
	 * @param departId
	 * @return
 	 * @author gongdaohai
 	 * @since v1.0,2018年4月4日
 	 * @version
	 */
	public MaroShopEntity getByDepartIdShop(String departId);
	/**
	 * 检查座位编号是否唯一
	 * @param number
	 * @return 唯一true，不唯一false
	 * @author gongdaohai
	 * @since v1.0,2018年5月4日
	 * @version
	 */
	public boolean isOnlySeatFlag(String shopId,String number);

	/**
	 * 检查店铺编号是否唯一
	 * @param number
	 * @return 唯一true，不唯一false
	 * @author gongdaohai
	 * @since v1.0,2018年5月4日
	 * @version
	 */
	boolean isOnlyShopNumber(String number);

	/**
	 * 获取所有的店铺信息
	 * @return
	 */
    List<Map> getAllShop();
}
