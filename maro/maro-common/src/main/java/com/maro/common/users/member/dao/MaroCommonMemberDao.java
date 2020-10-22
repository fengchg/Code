package com.maro.common.users.member.dao;

import com.maro.common.users.member.pojo.vo.MaroCommonMemberEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaroCommonMemberDao {
	
	@Arguments("phone")
	@Sql("select * from maro_member where phone = :phone or card=:phone")
	MaroCommonMemberEntity getByPohne(String phone);

	@Arguments("code")
	@Sql("select * from maro_member where code = :code")
	MaroCommonMemberEntity getByCode(String code);

	@Arguments("id")
	@Sql("select * from maro_member where id = :id")
	MaroCommonMemberEntity getById(String id);
	
	@Arguments("shopId")
	@Sql("select * from maro_member where shop_id = :shopId")
	List<MaroCommonMemberEntity> memberList(String shopId);
	
}
