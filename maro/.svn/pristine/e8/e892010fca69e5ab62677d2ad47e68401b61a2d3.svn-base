package com.maro.manager.groupdiscount.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MaroGroupDiscountDao {

    List<Map> getAllGroupDiscounts();

    @Arguments("shopId")
    List<Map> getGroupDiscounts(String shopId);
}
