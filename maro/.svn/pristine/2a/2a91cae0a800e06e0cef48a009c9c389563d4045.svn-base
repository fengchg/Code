package com.maro.client.module.queue.pojo.vo;

import com.maro.client.common.annotation.EnumDescription;
import com.maro.client.common.annotation.TimeFieldDescription;
import com.maro.client.common.constant.enumconstant.SeatGroupTypeEnum;
import com.maro.client.common.constant.enumconstant.SeatTypeEnum;

public class QueueItemVO {
    private String phone;
    private Integer seatGroupType;
    private Integer seatType;

    private Long createTime;

    private String seatTypeString;
    private String createTimeString;
    private String seatGroupTypeString;
    private Integer num;
    private Integer foren;


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @EnumDescription(enumFieldName = "seatType",targetEnum = SeatTypeEnum.class)
    public void setSeatTypeString(String seatTypeString) {
        this.seatTypeString = seatTypeString;
    }

    @TimeFieldDescription(timeFieldName="createTime",pattern="yyyy-MM-dd HH:mm:ss")
    public void setCreateTimeString(String createTimeString) {
        this.createTimeString = createTimeString;
    }

    @EnumDescription(enumFieldName = "seatGroupType",targetEnum = SeatGroupTypeEnum.class)
    public void setSeatGroupTypeString(String seatGroupTypeString) {
        this.seatGroupTypeString = seatGroupTypeString;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSeatGroupType() {
        return seatGroupType;
    }

    public void setSeatGroupType(Integer seatGroupType) {
        this.seatGroupType = seatGroupType;
    }

    public Integer getSeatType() {
        return seatType;
    }

    public void setSeatType(Integer seatType) {
        this.seatType = seatType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getSeatTypeString() {
        return seatTypeString;
    }

    public String getCreateTimeString() {
        return createTimeString;
    }

    public String getSeatGroupTypeString() {
        return seatGroupTypeString;
    }
}
