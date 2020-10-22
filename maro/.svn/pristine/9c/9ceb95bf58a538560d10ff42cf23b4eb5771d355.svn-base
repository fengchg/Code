package com.maro.manager.shop.shop.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * 店铺模块信息查询
 */
@Repository
public interface MaroShopDao {
	@Arguments("id")
	public List<Map> getComboTreeAll(String id);
	
    @Arguments({"id","departId"})
	public List<Map> getComboTree(String id,String departId);
    
    @Arguments({"departId","type"})
    @Sql("UPDATE t_s_depart SET or_not_store = :type WHERE id = :departId")
	public int changeStoreTypeByDepart(String departId, String type);


    @Arguments("number")
    @Sql("SELECT count(*) FROM maro_shop t WHERE t.number = :number")
    public int isOnlyShopNumber(String number);

    @Arguments({"shopId","number"})
    @Sql("SELECT count(*) FROM maro_shop_seat t where t.shop_id=:shopId and t.flag=:number")
    public int isOnlySeatFlag(String shopId, String number);

    @Sql("SELECT t.id, t.`name`, t.position, t.phone,t.equipment_number FROM maro_shop t, t_s_depart t1 WHERE t.depart_id = t1.id AND t1.or_not_store = 'Y'")
    List<Map> getAllShop();
}
