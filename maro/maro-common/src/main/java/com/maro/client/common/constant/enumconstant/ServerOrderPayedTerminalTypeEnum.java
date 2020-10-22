package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 流水订单支付终端类型的枚举，支付终端：0收银机，1微信公众号
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
 */
@EnumSqlScript(group = "serverOrderPayedTerminalTypeEnum",groupName = "流水订单支付终端类型")
public enum ServerOrderPayedTerminalTypeEnum {

    CASH(0, "收银机"),
        WCHAT_ALIPAY(1, "微信支付宝");



    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    ServerOrderPayedTerminalTypeEnum(Integer code,String name){
        this.code = code;
        this.name = name;
    }
}
