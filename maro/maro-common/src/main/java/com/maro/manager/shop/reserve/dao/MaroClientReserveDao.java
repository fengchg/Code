package com.maro.manager.shop.reserve.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Arguments;
import org.springframework.stereotype.Repository;

@Repository
public interface MaroClientReserveDao {

	@Arguments({"shopId","time","period","personNumber"})
	List<Map> listSeat(String shopId, long time, String period,Integer personNumber);
}