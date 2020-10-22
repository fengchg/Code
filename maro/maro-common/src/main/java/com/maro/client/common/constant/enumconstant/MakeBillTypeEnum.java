package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 开票状态枚举，0代表不开票，1代表开票
 * @author 冯成果
 * @date 2018-4-9
 * @since 01.00.0001
*/
@EnumSqlScript(group = "makeBillTypeEnum",groupName = "开票状态")
public enum MakeBillTypeEnum {
    NO_MAKE(0, "不开票"),
    MAKE(1, "开票");

    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    MakeBillTypeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
}
