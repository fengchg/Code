package com.maro.manager.users.member.service;
import com.maro.manager.users.member.entity.MaroMemberEntity;
import com.maro.platform.core.common.service.CommonService;

import java.io.Serializable;

public interface MaroMemberServiceI extends CommonService{

 	public void delete(MaroMemberEntity entity) throws Exception;
 	
 	public Serializable save(MaroMemberEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MaroMemberEntity entity) throws Exception;
 	
}
