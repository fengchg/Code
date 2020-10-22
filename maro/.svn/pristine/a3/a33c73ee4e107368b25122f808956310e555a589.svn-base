package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 点餐订单状态的枚举，状态：0下单，1下锅、2出菜，3换菜，4退菜
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
 */
@EnumSqlScript(group = "foodOrderStatusEnum",groupName = "点餐订单状态")
public enum FoodOrderStatusEnum {

    ORDER(0, "下单"),
    COOK(1, "下锅"),
    COOKED(2, "出锅"),
    CHANGE(3, "换菜"),
    Urge(4,"催菜"),
    REFUND(5, "退菜"),
    FINISH(6, "已上");




    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
     FoodOrderStatusEnum(Integer code,String name){
        this.code = code;
        this.name = name;
    }
}
