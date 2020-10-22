package com.maro.platform.tag.vo.datatable;

import com.maro.platform.core.enums.SysACEIconEnum;
import com.maro.platform.core.util.StringUtil;

/**
* @Description: TODO(排序定义) 
* asc 升序
* @author  张代浩
* desc 降序
*/
public enum SortDirection {
	asc, // 升序
	desc;
	// 降序
	
	public static SortDirection toEnum(String order) {
		if (StringUtil.isEmpty(order)) {
			//默认排序
			return asc;
        }
		for(SortDirection item : SortDirection.values()) {
			if(item.toString().equals(order)) {
				return item;
			}
		}
		//默认排序
		return asc;
	}
}
