package com.maro.common.finance.account.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.maro.common.finance.account.pojo.entity.MaroAccountEntity;

/**
 * 账户查询层
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
@Repository
public interface MaroCommonAccountDao {
	
	@Sql("SELECT * FROM maro_account")
	List<MaroAccountEntity> listAccount();

	@Arguments("shopId")
	@Sql("SELECT * FROM maro_account t where t.shop_id=:shopId")
	MaroAccountEntity getAccount(String shopId);

	@Arguments({"shopId","money"})
	@Sql("UPDATE maro_account SET balance = cast(balance AS DECIMAL(20, 5)) + cast(:money AS DECIMAL(20, 5))")
	int addMoney(String shopId, String money);

	@Arguments({"shopId","money"})
	@Sql("UPDATE maro_account SET balance = cast(balance AS DECIMAL(20, 5)) - cast(:money AS DECIMAL(20, 5))")
	int minusMoney(String shopId, String money);

}
