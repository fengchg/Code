package com.maro.common.users.tsuser.pojo.vo;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.platform.web.system.pojo.base.TSDepart;
import com.maro.platform.web.system.pojo.base.TSUser;

/**
 * 展示给前端的用户信息
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
public class UserInfoVO extends TSUser implements java.io.Serializable{
	/**
	 * 父级部门
	 */
	private TSDepart parentDepart;
	/**
	 * 归属的店铺
	 */
	private MaroShopEntity maroShopEntity;

	public MaroShopEntity getMaroShopEntity() {
		return maroShopEntity;
	}

	public void setMaroShopEntity(MaroShopEntity maroShopEntity) {
		this.maroShopEntity = maroShopEntity;
	}

	public TSDepart getParentDepart() {
		return parentDepart;
	}

	public void setParentDepart(TSDepart parentDepart) {
		this.parentDepart = parentDepart;
	} 
	
}
