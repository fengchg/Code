package com.maro.client.module.serverorder.pojo.vo;

import com.maro.client.common.annotation.EnumDescription;
import com.maro.client.common.annotation.TimeFieldDescription;
import com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderlogDO;

public class MaroClientServerorderlogVO extends MaroClientServerorderlogDO{

    private String happenTimeString;
    private String typeString;

    public String getHappenTimeString() {
        return happenTimeString;
    }

    public String getTypeString() {
        return typeString;
    }

    @TimeFieldDescription(timeFieldName = "happenTime",pattern = "yyyy-MM-dd HH:mm:ss")
    public void setHappenTimeString(String happenTimeString) {
        this.happenTimeString = happenTimeString;
    }

    @EnumDescription(enumFieldName = "type",targetEnum = ServerOrderLogTypeEnum.class)
    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }
}
