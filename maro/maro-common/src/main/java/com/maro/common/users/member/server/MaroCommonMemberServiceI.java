package com.maro.common.users.member.server;

import java.util.List;

import com.maro.common.users.member.pojo.vo.MaroCommonMemberEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroCommonMemberServiceI extends CommonService {

	/**
	 * 根据手机号码获取会员信息
	 * pohne 手机号码
	 */
	MaroCommonMemberEntity getByPohne(String pohne);
	/*
	*通过卡号查询会员信息
	*/
	MaroCommonMemberEntity getByCode(String code);
	/**
	 * 根据id获取
	 * id 主键
	 */
	MaroCommonMemberEntity getById(String id);
	
	/**
	 * 根据店铺id获取会员列表
	 * shopId 店铺id
	 */
	List<MaroCommonMemberEntity> memberList(String shopId);
}
