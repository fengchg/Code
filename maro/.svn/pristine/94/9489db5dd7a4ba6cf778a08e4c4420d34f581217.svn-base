package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 菜品类型的枚举，类型：0普通，1赠品
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
 */
@EnumSqlScript(group = "foodTypeEnum",groupName = "菜品类型")
public enum FoodTypeEnum {

    NORMAL(0, "普通"),
    GIFT(1, "赠品"),
    ACTIVITY_GIFT(2, "活动赠品");


    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    FoodTypeEnum(Integer code,String name){
        this.code = code;
        this.name = name;
    }

}
