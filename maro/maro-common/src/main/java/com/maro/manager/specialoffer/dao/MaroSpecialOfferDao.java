package com.maro.manager.specialoffer.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MaroSpecialOfferDao {
    List<Map> getOfferDetailAll();

    @Arguments("shopId")
    List<Map> getOfferDetail(String shopId);
}
