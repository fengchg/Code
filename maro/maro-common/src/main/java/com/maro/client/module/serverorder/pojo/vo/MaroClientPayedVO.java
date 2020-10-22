package com.maro.client.module.serverorder.pojo.vo;

import com.maro.client.common.annotation.EnumDescription;
import com.maro.client.common.annotation.TimeFieldDescription;
import com.maro.client.common.constant.enumconstant.ServerOrderPayedTerminalTypeEnum;
import com.maro.client.common.constant.enumconstant.ServerOrderPayedTypeEnum;
import com.maro.client.module.serverorder.pojo.entity.MaroClientPayedDO;

public class MaroClientPayedVO extends MaroClientPayedDO{



    private String payTimeString;
    private String payTypeString;
    private String payTerminalString;



    public String getPayTimeString() {
        return payTimeString;
    }

    @TimeFieldDescription(timeFieldName = "payTime",pattern = "yyyy-MM-dd HH:mm:ss")
    public void setPayTimeString(String payTimeString) {
        this.payTimeString = payTimeString;
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
}
