package com.maro.client.module.serverorder.pojo.dto;

import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientPayedDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientPayedDetailDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;

import java.util.List;

/**
 * 结账参数传输对象
 * @author 冯成果
 * @date 2018-4-14
 * @since 01.00.0001
 */
public class PayParamsDTO {

    /**
     * 服务订单DO
     */
    private MaroClientServerorderDO maroClientServerorderDO;
    /**
     * 支付记录DO
     */
    private MaroClientPayedDO maroClientPayedDO;
    /**
     * 支付记录详情DO
     */
    private List<MaroClientPayedDetailDO> maroClientPayedDetailDOList;

    /**
     * 支付对应点餐记录DO列表
     */
    private List<MaroClientFoodorderDO> maroClientFoodorderDOList;
    /**
     * 桌位信息DO
     */
    private MaroShopSeatEntity maroShopSeatEntity;

    private MaroShopEntity maroShopEntity;

//    private MaroDishesDiscountEntity maroDishesDiscountEntity;

    private Integer ruleFlag;

    private Boolean print = true;

    public MaroClientServerorderDO getMaroClientServerorderDO() {
        return maroClientServerorderDO;
    }

    public void setMaroClientServerorderDO(MaroClientServerorderDO maroClientServerorderDO) {
        this.maroClientServerorderDO = maroClientServerorderDO;
    }

    public MaroClientPayedDO getMaroClientPayedDO() {
        return maroClientPayedDO;
    }

    public void setMaroClientPayedDO(MaroClientPayedDO maroClientPayedDO) {
        this.maroClientPayedDO = maroClientPayedDO;
    }

    public List<MaroClientPayedDetailDO> getMaroClientPayedDetailDOList() {
        return maroClientPayedDetailDOList;
    }

    public void setMaroClientPayedDetailDOList(List<MaroClientPayedDetailDO> maroClientPayedDetailDOList) {
        this.maroClientPayedDetailDOList = maroClientPayedDetailDOList;
    }

    public List<MaroClientFoodorderDO> getMaroClientFoodorderDOList() {
        return maroClientFoodorderDOList;
    }

    public void setMaroClientFoodorderDOList(List<MaroClientFoodorderDO> maroClientFoodorderDOList) {
        this.maroClientFoodorderDOList = maroClientFoodorderDOList;
    }

    public MaroShopSeatEntity getMaroShopSeatEntity() {
        return maroShopSeatEntity;
    }

    public void setMaroShopSeatEntity(MaroShopSeatEntity maroShopSeatEntity) {
        this.maroShopSeatEntity = maroShopSeatEntity;
    }

    public MaroShopEntity getMaroShopEntity() {
        return maroShopEntity;
    }

    public void setMaroShopEntity(MaroShopEntity maroShopEntity) {
        this.maroShopEntity = maroShopEntity;
    }

//    public MaroDishesDiscountEntity getMaroDishesDiscountEntity() {
//        return maroDishesDiscountEntity;
//    }
//
//    public void setMaroDishesDiscountEntity(MaroDishesDiscountEntity maroDishesDiscountEntity) {
//        this.maroDishesDiscountEntity = maroDishesDiscountEntity;
//    }

    public Integer getRuleFlag() {
        return ruleFlag;
    }

    public void setRuleFlag(Integer ruleFlag) {
        this.ruleFlag = ruleFlag;
    }

    public Boolean getPrint() {
        return print;
    }

    public void setPrint(Boolean print) {
        print = print;
    }
}