package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 预定时段的枚举，状态：0早上，1中午，2下午，3晚上
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
*/
@EnumSqlScript(group = "reservePeriodEnum",groupName = "预定时段")
public enum ReservePeriodEnum {
    MORNING(0, "早上"),
    NOON(1, "中午"),
    AFTERNOON(2, "下午"),
    NIGHT(3, "晚上");

    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    ReservePeriodEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
}
