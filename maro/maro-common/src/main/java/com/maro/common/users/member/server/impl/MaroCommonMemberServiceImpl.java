package com.maro.common.users.member.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.common.users.member.dao.MaroCommonMemberDao;
import com.maro.common.users.member.pojo.vo.MaroCommonMemberEntity;
import com.maro.common.users.member.server.MaroCommonMemberServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;


@Service("maroCommonMemberServiceI")
@Transactional
public class MaroCommonMemberServiceImpl extends CommonServiceImpl implements MaroCommonMemberServiceI{

	@Autowired
	MaroCommonMemberDao maroMemberDao;

	@Override
	public MaroCommonMemberEntity getByCode(String code){
		return maroMemberDao.getByCode(code);
	}
	@Override
	public MaroCommonMemberEntity getByPohne(String pohne) {
		return maroMemberDao.getByPohne(pohne);
	}

	@Override
	public MaroCommonMemberEntity getById(String id) {
		return maroMemberDao.getById(id);
	}

	@Override
	public List<MaroCommonMemberEntity> memberList(String shopId) {
		return maroMemberDao.memberList(shopId);
	}
	
}
