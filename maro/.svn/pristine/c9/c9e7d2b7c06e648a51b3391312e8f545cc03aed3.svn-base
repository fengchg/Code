package com.maro.manager.mq.service;

import java.util.List;

import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.service.CommonService;


public interface MqServiceI extends CommonService{
	/**
	 * 通过MQ传递过来的json数据转化成实体对象进行保存
	 * @param message
	 * @author gongdaohai
	 * @since v1.0,2018年5月25日
	 * @version
	 */
	void saveEntity(Object obj);

	/**
	 * 保存数据
	 * @param message
	 * @author gongdaohai
	 * @since v1.0,2018年5月25日
	 * @version
	 */
	void insertData(String tableName,List<List> data);
	/**
	 * 删除数据
	 * @param message
	 * @author gongdaohai
	 * @since v1.0,2018年5月25日
	 * @version
	 */
	void deleteData(String tableName, List<String> data);
}
