package com.maro.client.module.serverorder.pojo.dto;

import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;

import java.util.List;

/**
 * 菜品接口有关的参数数据传输对象
 * @author 冯成果
 * @date 2018-4-15
 * @since 01.00.0001
*/
public class FoodOrderParamsDTO {

    /**
     * 目标服务订单DO
     */
    private MaroClientServerorderDO maroClientServerorderDO;

    /**
     * 目标桌位信息DO
     */
    private MaroShopSeatEntity maroShopSeatEntity;

    /**
     * 源服务订单DO
     */
    private MaroClientServerorderDO srcMaroClientServerorderDO;


    /**
     * 源桌位信息DO
     */
    private MaroShopSeatEntity srcMaroShopSeatEntity;

    /**
     * 点餐记录DO列表
     */
    private List<MaroClientFoodorderDO> maroClientFoodorderDOList;

    /**
     * 点餐记录DO
     */
    private MaroClientFoodorderDO maroClientFoodorderDO;

    private MaroShopEntity maroShopEntity;

    private String terminalCode;

    /**
     * 点菜次数
     */
    private Integer times;


    public MaroClientFoodorderDO getMaroClientFoodorderDO() {
        return maroClientFoodorderDO;
    }

    public void setMaroClientFoodorderDO(MaroClientFoodorderDO maroClientFoodorderDO) {
        this.maroClientFoodorderDO = maroClientFoodorderDO;
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

    public List<MaroClientFoodorderDO> getMaroClientFoodorderDOList() {
        return maroClientFoodorderDOList;
    }

    public void setMaroClientFoodorderDOList(List<MaroClientFoodorderDO> maroClientFoodorderDOList) {
        this.maroClientFoodorderDOList = maroClientFoodorderDOList;
    }

    public MaroClientServerorderDO getSrcMaroClientServerorderDO() {
        return srcMaroClientServerorderDO;
    }

    public void setSrcMaroClientServerorderDO(MaroClientServerorderDO srcMaroClientServerorderDO) {
        this.srcMaroClientServerorderDO = srcMaroClientServerorderDO;
    }

    public MaroShopSeatEntity getSrcMaroShopSeatEntity() {
        return srcMaroShopSeatEntity;
    }

    public void setSrcMaroShopSeatEntity(MaroShopSeatEntity srcMaroShopSeatEntity) {
        this.srcMaroShopSeatEntity = srcMaroShopSeatEntity;
    }

    public MaroShopEntity getMaroShopEntity() {
        return maroShopEntity;
    }

    public void setMaroShopEntity(MaroShopEntity maroShopEntity) {
        this.maroShopEntity = maroShopEntity;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
