package com.maro.client.module.serverorder.pojo.dto;

import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;

import java.math.BigDecimal;

/**
 * 菜肴项返回传输对象，包括菜品信息，以及对应其点菜数量
 * @author 冯成果
 * @date 2018-4-14
 * @since 01.00.0001
 */
public class MenuItemResultDTO {
    private MaroDishesEntity maroCommonDishesEntity;
    private BigDecimal quantity;

    public MaroDishesEntity getMaroDishesEntity() {
        return maroCommonDishesEntity;
    }

    public void setMaroDishesEntity(MaroDishesEntity maroCommonDishesEntity) {
        this.maroCommonDishesEntity = maroCommonDishesEntity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
