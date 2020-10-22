package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 流水订单状态的枚举，状态：0上桌，1点餐，2结账，3下桌，4取消上桌，5退款，6作废
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
*/
@EnumSqlScript(group = "serverOrderStatusEnum",groupName = "流水订单状态")
public enum ServerOrderStatusEnum {
    OPEN(0, "上桌"),
    ORDER(1, "点餐"),
    PAY(2, "结账"),
    CLOSE(3, "下桌"),
    CANCEL_OPEN(4, "取消上桌"),
    REFUND(5, "退款"),
    INVALID(6, "作废"),
    FINISH(7,"完成");

    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    ServerOrderStatusEnum(Integer code,String name){
        this.code = code;
        this.name = name;
    }
}
