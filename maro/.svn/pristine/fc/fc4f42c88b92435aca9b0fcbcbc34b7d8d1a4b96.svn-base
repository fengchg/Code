package com.maro.client.module.serverorder.pojo.dto;

//import com.maro.client.module.evaluate.pojo.entity.MaroClientEvaluateVO;

import com.maro.client.module.reserve.pojo.entity.MaroClientReserveDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;

import java.io.Serializable;

/**
 * 店铺服务订单流水DTO类，聚合了店铺服务订单的主表VO和有关的子表，用来在controller、service、dao层之间进行参数和返回值传递的类
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
*/
public class MaroClientServerorderParamsDTO implements Serializable{

    /**
     * 预定记录
     */
    private MaroClientReserveDO maroClientReserveDO;
    /**
     * 服务订单DO
     */
    private MaroClientServerorderDO maroClientServerorderDO;

    /**
     * 桌位信息
     */
    private MaroShopSeatEntity maroShopSeatEntity;

    private MaroShopEntity maroShopEntity;

    public MaroShopEntity getMaroShopEntity() {
        return maroShopEntity;
    }

    public void setMaroShopEntity(MaroShopEntity maroShopEntity) {
        this.maroShopEntity = maroShopEntity;
    }

    public MaroClientReserveDO getMaroClientReserveDO() {
        return maroClientReserveDO;
    }

    public void setMaroClientReserveDO(MaroClientReserveDO maroClientReserveDO) {
        this.maroClientReserveDO = maroClientReserveDO;
    }

    public MaroClientServerorderDO getMaroClientServerorderDO() {
        return maroClientServerorderDO;
    }

    public void setMaroClientServerorderDO(MaroClientServerorderDO maroClientServerorderDO) {
        this.maroClientServerorderDO = maroClientServerorderDO;
    }

    public MaroShopSeatEntity getMaroShopSeatEntity() {
        return maroShopSeatEntity;
    }

    public void setMaroShopSeatEntity(MaroShopSeatEntity maroShopSeatEntity) {
        this.maroShopSeatEntity = maroShopSeatEntity;
    }
}
