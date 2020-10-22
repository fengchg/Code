package com.maro.common.shop.dao;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 店铺查询层
 * @see
 * @since v1.0, 2018年4月10日
 * @author gongdaohai
 *
 */
@Repository
public interface MaroCommonShopDao {
	
	@Arguments("shopId")
	@Sql("SELECT * FROM maro_shop_seat WHERE shop_id=:shopId ORDER BY type,flag")
	List<MaroShopSeatEntity> listShopSeatInfoByShopId(String shopId);
	
	@Arguments("departId")
	@Sql("SELECT t1.* FROM maro_shop t, maro_shop_seat t1 WHERE t.id = t1.shop_id AND t.depart_id=:departId")
	List<MaroShopSeatEntity> listShopSeatInfoByDepartId(String departId);
	
	@Arguments("seatId")
	@Sql("SELECT * from maro_shop_seat WHERE id=:seatId")
	MaroShopSeatEntity getShopSeatInfoBySeatId(String seatId);
	
	@Arguments({"seatId","flag"})
	@Sql("UPDATE maro_shop_seat SET use_flag = :flag WHERE id =:seatId")
	int updateFlag(String seatId, Integer flag);
	
	@Arguments("departId")
	@Sql("SELECT * FROM maro_shop WHERE depart_id = :departId LIMIT 0,1")
	MaroShopEntity getMaroShopByDepartId(String departId);

	@Arguments("shopId")
	@Sql("SELECT flag,name FROM maro_shop_seat WHERE shop_id=:shopId")
    List<Map<String,Object>> listShopSeatInfoBySql(String shopId);
}
