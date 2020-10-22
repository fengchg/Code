package com.maro.client.module.serverorder.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ServerOrderApplyDao {
    @Arguments("shopId")
    List<Map> getFreeSeat(String shopId);

    @Arguments({"shopId","seatTypeCode"})
    List<Map> getFreeSeatBySeatType(String shopId, String seatTypeCode);

    @Arguments({"shopId","seatCode"})
    List<Map> getFreeSeatBySeatCode(String shopId, String seatCode);

    @Arguments({"shopId","seatCode","period"})
    List<Map> getReserveFreeSeatBySeatCode(String shopId, String seatCode, Integer period);

    @Arguments({"shopId","seatTypeCode","period"})
    List<Map> getReserveFreeSeatBySeatType(String shopId, String seatTypeCode, Integer period);
}
