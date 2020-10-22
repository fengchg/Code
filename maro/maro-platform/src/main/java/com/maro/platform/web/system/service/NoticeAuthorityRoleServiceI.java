package com.maro.platform.web.system.service;
import java.io.Serializable;

import com.maro.platform.core.common.service.CommonService;
import com.maro.platform.web.system.pojo.base.TSNoticeAuthorityRole;

public interface NoticeAuthorityRoleServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(TSNoticeAuthorityRole t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(TSNoticeAuthorityRole t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(TSNoticeAuthorityRole t);
 	
 	public boolean checkAuthorityRole(String noticeId, String roleid);
}
