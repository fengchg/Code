package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 菜品套餐类型的枚举，类型：0普通类型，1套餐类型，2为套餐子菜品类型
 * @author 冯成果
 * @date 2018-10-22
 * @since 01.00.0001
 */
@EnumSqlScript(group = "foodPackageTypeEnum",groupName = "菜品套餐类型")
public enum FoodPackageTypeEnum {

    NORMAL(0, "普通类型"),
    PACKAGE(1, "套餐类型"),
    SUB_NORMAL(2, "套餐子菜品类型");


    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    FoodPackageTypeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

}
