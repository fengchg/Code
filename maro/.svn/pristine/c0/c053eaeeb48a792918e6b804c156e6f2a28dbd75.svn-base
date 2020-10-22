package com.maro.client.module.serverorder.pojo.vo;

import com.maro.client.common.annotation.EnumDescription;
import com.maro.client.common.annotation.TimeFieldDescription;
import com.maro.client.common.constant.enumconstant.CommonTypeEnum;
import com.maro.client.common.constant.enumconstant.FoodOrderStatusEnum;
import com.maro.client.common.constant.enumconstant.FoodPackageTypeEnum;
import com.maro.client.common.constant.enumconstant.FoodTypeEnum;
import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;

public class MaroClientFoodorderVO extends MaroClientFoodorderDO{

    private String statusString;
    private String typeString;
    private String createTimeString;
    private Long waitTime;
    private String createTimeMMSSString;
    private String packageTypeString;
    private String isFavourableString;



    @EnumDescription(enumFieldName = "status",targetEnum = FoodOrderStatusEnum.class)
    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    @EnumDescription(enumFieldName = "type",targetEnum = FoodTypeEnum.class)
    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    @TimeFieldDescription(timeFieldName = "createTime",pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreateTimeString(String createTimeString) {
        this.createTimeString = createTimeString;
    }

    public String getCreateTimeString() {
        return createTimeString;
    }

    public String getStatusString() {
        return statusString;
    }

    public String getTypeString() {
        return typeString;
    }

    public Long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Long waitTime) {
        this.waitTime = waitTime;
    }


    @TimeFieldDescription(timeFieldName = "createTime",pattern = "HH:mm")
    public void setCreateTimeMMSSString(String createTimeMMSSString) {
        this.createTimeMMSSString = createTimeMMSSString;
    }

    public String getCreateTimeMMSSString() {
        return createTimeMMSSString;
    }

    @EnumDescription(enumFieldName = "packageType",targetEnum = FoodPackageTypeEnum.class)
    public String getPackageTypeString() {
        return packageTypeString;
    }

    public void setPackageTypeString(String packageTypeString) {
        this.packageTypeString = packageTypeString;
    }

    @EnumDescription(enumFieldName = "isFavourable",targetEnum = CommonTypeEnum.class)
    public String getIsFavourableString() {
        return isFavourableString;
    }

    public void setIsFavourableString(String isFavourableString) {
        this.isFavourableString = isFavourableString;
    }
}
