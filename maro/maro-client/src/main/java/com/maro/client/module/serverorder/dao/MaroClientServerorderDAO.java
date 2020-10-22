package com.maro.client.module.serverorder.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MaroClientServerorderDAO {
	
	@Arguments({"seatCode_billNumber","shopId","cancelStatus","finishStatus","foodStatus"})
	public Map billQuery(String seatCode_billNumber, String shopId, String cancelStatus, String finishStatus,Integer foodStatus);
	
	@Arguments({"serverOrderId","foodStatus"})
	public List<Map> billQueryDetailsList(String serverOrderId,Integer foodStatus);
	
	@Arguments({"shopId","status"})
	@Sql("select t.customer_name,t1.flag from maro_client_reserve t,maro_shop_seat t1 where t.dest_seat_id=t1.id and t.restaurant_id=:shopId and t.status=:status")
	public List<Map> reserveMessage(String shopId,Integer status);
	
	@Arguments({"seatCode","shopId"})
	public List<Map> reserveMessageSeatCode(String seatCode,String shopId);
}
