package com.maro.platform.web.system.service;

import com.maro.platform.core.common.service.CommonService;
import com.maro.platform.web.system.pojo.base.TSCategoryEntity;

public interface CategoryServiceI extends CommonService{
	/**
	 * 保存分类管理
	 * @param category
	 */
	void saveCategory(TSCategoryEntity category);

}
