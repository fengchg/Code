package com.maro.platform.web.system.service;

import java.util.List;

import com.maro.platform.web.system.pojo.base.TSAttachment;

import com.maro.platform.core.common.service.CommonService;

/**
 * 
 * @author  张代浩
 *
 */
public interface DeclareService extends CommonService{
	
	public List<TSAttachment> getAttachmentsByCode(String businessKey,String description);
	
}
