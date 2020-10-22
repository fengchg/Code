package com.maro.client.common.constant.enumconstant;

import com.maro.client.common.annotation.EnumSqlScript;

/**
 * 流水订单日志类型的枚举，日志类型：0上桌，1支付，2下桌，3取消上桌，4退款，5作废，6评价，10换桌，11并桌，12拆桌，21点菜，22加菜，23换菜，24退菜
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
 */
@EnumSqlScript(group = "serverOrderLogTypeEnum",groupName = "流水订单日志类型")
public enum ServerOrderLogTypeEnum {

    OPEN(0, "上桌"),
    PAY(1, "结账"),
    CLOSE(2, "下桌"),
    CANCEL_OPEN(3, "取消上桌"),
    REFUND(4, "退款"),
    INVALID(5, "作废"),
    EVALUATE(6, "评价"),
    CHANGE_SEAT(11, "换桌"),
    MERGE_SEAT(12, "并桌"),
    UNPACK_SEAT(13, "拆桌"),
    CANCEL_MERGE_SEAT(14, "取消并桌"),
    ORDER_FOOD(21, "下单"),
    COOK_FOOD(22, "下锅"),
    COOKED_FOOD(23, "出锅"),
    REFUND_FOOD(24, "退菜"),
    GIFT_FOOD(25, "赠菜"),
    FINISH_FOOD(26,"已上"),
    UNFINISH_FOOD(27,"取消已上"),
    URGE_FOOD(28,"催菜"),
    CHANGEFOODLISTTO1_FOOD(29,"菜品转台出去"),
    CHANGEFOODLISTTO2_FOOD(30,"菜品转台接受"),

    UPDATE_SERVERORDERINFO(50,"修改服务订单信息"),
    UPDATE_FOODTEMPPRICE(51,"菜肴临时改价");






    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    ServerOrderLogTypeEnum(Integer code,String name){
        this.code = code;
        this.name = name;
    }
}
