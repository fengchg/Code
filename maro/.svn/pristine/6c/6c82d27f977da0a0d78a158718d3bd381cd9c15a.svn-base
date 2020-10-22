package com.maro.client.module.serverorder.pojo.vo;

import com.maro.client.common.annotation.EnumDescription;
import com.maro.client.common.annotation.TimeFieldDescription;
import com.maro.client.common.constant.enumconstant.*;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;

/**
 * 针对服务订单DO的显示VO，专门用来在jsp页面上显示数据的载体
 * @author 冯成果
 * @date 2018-3-30
 * @see MaroClientServerorderDO
 * @since 版本号 01.00.0001
*/
public class MaroClientServerorderVO extends  MaroClientServerorderDO{


    private String beginTimeString;
    private String endTimeString;
    private String payTimeString;
    private String statusString;
    private String payTypeString;
    private String payTerminalString;
    private String makeBillTypeString;


    /**
     * 打厨状态
     */
    private String kitchenNotifyString;

    public String getBeginTimeString() {
        return beginTimeString;
    }

    @TimeFieldDescription(timeFieldName = "beginTime",pattern = "yyyy-MM-dd")
    public void setBeginTimeString(String beginTimeString) {
        this.beginTimeString = beginTimeString;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    @TimeFieldDescription(timeFieldName = "endTime",pattern = "yyyy-MM-dd")
    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    public String getPayTimeString() {
        return payTimeString;
    }

    @TimeFieldDescription(timeFieldName = "payTime",pattern = "yyyy-MM-dd")
    public void setPayTimeString(String payTimeString) {
        this.payTimeString = payTimeString;
    }

    public String getStatusString() {
        return statusString;
    }

    @EnumDescription(enumFieldName = "status",targetEnum = ServerOrderStatusEnum.class)
    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public String getPayTypeString() {
        return payTypeString;
    }

    @EnumDescription(enumFieldName = "payType",targetEnum = ServerOrderPayedTypeEnum.class)
    public void setPayTypeString(String payTypeString) {
        this.payTypeString = payTypeString;
    }

    public String getPayTerminalString() {
        return payTerminalString;
    }

    @EnumDescription(enumFieldName = "payTerminal",targetEnum = ServerOrderPayedTerminalTypeEnum.class)
    public void setPayTerminalString(String payTerminalString) {
        this.payTerminalString = payTerminalString;
    }

    public String getMakeBillTypeString() {
        return makeBillTypeString;
    }

    @EnumDescription(enumFieldName = "makeBillType",targetEnum = MakeBillTypeEnum.class)
    public void setMakeBillTypeString(String makeBillTypeString) {
        this.makeBillTypeString = makeBillTypeString;
    }

    public String getKitchenNotifyString() {
        return kitchenNotifyString;
    }

    @EnumDescription(enumFieldName = "kitchenNotifyString",targetEnum = KitChenNotifyStatusEnum.class)
    public void setKitchenNotifyString(String kitchenNotifyString) {
        this.kitchenNotifyString = kitchenNotifyString;
    }
}
