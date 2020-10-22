package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 预定类型的枚举，类型：0普通，1婚庆，2寿庆，3公司活动，4其他
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
 */
@EnumSqlScript(group = "reserveTypeEnum",groupName = "预定类型")
public enum ReserveTypeEnum {

    NORMAL(0, "普通"),
    WEDDING(1, "婚庆"),
    BIRTHDAY(2, "寿庆"),
    COMPANY_EVENT(3, "公司活动"),
    OTHER(4, "其他");


    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    ReserveTypeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

}
