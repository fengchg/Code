package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 流水订单支付类型的枚举，支付方式：0现金，1微信支付宝，2会员卡，3银联刷卡，4预付费，5其他
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
 */
@EnumSqlScript(group = "serverOrderPayedTypeEnum",groupName = "流水订单支付类型")
public enum ServerOrderPayedTypeEnum {
    CASH(0, "现金"),
    WCHAT(1, "微信"),
    ALIPAY(2, "支付宝"),
    VIPCARD(3, "会员卡"),
    UNIONPAY(4, "银联刷卡"),
    PREPAYMENT(5, "其他"),
    COUPON_MEITUAN(6, "美团优惠券");


    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    ServerOrderPayedTypeEnum(Integer code,String name){
        this.code = code;
        this.name = name;
    }
}
