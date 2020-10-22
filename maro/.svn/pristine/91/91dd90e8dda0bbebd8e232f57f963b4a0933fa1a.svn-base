package com.maro.manager.discount.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MaroDiscountDao {

    @Arguments("discountId")
    @Sql("SELECT t1.id,t1.dishes_name from maro_dishes_discount_detail t,maro_dishes t1 WHERE t.dishes_id=t1.id and t.discount_id=:discountId")
    List<Map> getDiscountDetailByDiscountId(String discountId);
}
