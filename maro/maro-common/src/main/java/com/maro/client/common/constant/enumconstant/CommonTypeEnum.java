package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 常用的类型枚举
 * @author 冯成果
 * @date 2018-4-11
 * @since 01.00.0001
*/
@EnumSqlScript(group = "commonTypeEnum",groupName = "常用的类型")
public enum CommonTypeEnum {
    DELETE_FLAG_NO(0, "不删除"),
    DELETE_FLAG_YES(1, "删除"),
    SEND_FLAG_NO(100, "未发送"),
    SEND_FLAG_YES(101, "已发送"),

    COMMON_NO(200,"否"),
    COMMON_YES(201,"是");

    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    CommonTypeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
}
