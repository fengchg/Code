package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 打厨状态枚举
 * @author 冯成果
 * @date 2018-4-11
 * @since 01.00.0001
*/
@EnumSqlScript(group = "kitChenNotifyStatusEnum",groupName = "打厨状态")
public enum KitChenNotifyStatusEnum {
    NOTIFY(1, "打厨"),
    NOT_NOTIFY(0, "未打厨");

    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    KitChenNotifyStatusEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
}
