package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 预定状态的枚举，状态：0预定，1已开单，2取消预订
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
*/
@EnumSqlScript(group = "reserveStatusEnum",groupName = "预定状态")
public enum ReserveStatusEnum {
    ORDER(0, "预定"),
    OPEN(1, "已开单"),
    CANCEL(2, "取消预订");

    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    ReserveStatusEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
}
