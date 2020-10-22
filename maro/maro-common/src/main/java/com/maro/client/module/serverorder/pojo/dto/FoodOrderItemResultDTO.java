package com.maro.client.module.serverorder.pojo.dto;

import java.util.List;

/**
 * 点菜记录项返回传输对象，包括菜品类型、点餐列表记录
 * @author 冯成果
 * @date 2018-4-14
 * @since 01.00.0001
 */
public class FoodOrderItemResultDTO {
    private String type;
    private String typeString;
    private List<FoodOrderItemGroupResultDTO> foodOrderItemGroupResultDTOList;
    private Integer total;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public List<FoodOrderItemGroupResultDTO> getFoodOrderItemGroupResultDTOList() {
        return foodOrderItemGroupResultDTOList;
    }

    public void setFoodOrderItemGroupResultDTOList(List<FoodOrderItemGroupResultDTO> foodOrderItemGroupResultDTOList) {
        this.foodOrderItemGroupResultDTOList = foodOrderItemGroupResultDTOList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
