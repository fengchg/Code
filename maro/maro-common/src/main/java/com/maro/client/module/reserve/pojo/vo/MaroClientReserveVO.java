package com.maro.client.module.reserve.pojo.vo;

import com.maro.client.common.annotation.EnumDescription;
import com.maro.client.common.constant.StringConstant;
import com.maro.client.common.constant.enumconstant.ReservePeriodEnum;
import com.maro.client.common.constant.enumconstant.ReserveStatusEnum;
import com.maro.client.common.constant.enumconstant.ReserveTypeEnum;
import com.maro.client.module.reserve.pojo.entity.MaroClientReserveDO;
import com.maro.platform.core.util.DateUtils;

import java.text.ParseException;

public class MaroClientReserveVO extends MaroClientReserveDO{

    /**
     * 预定时间字符串表示
     */
    private String reserveTimeString;
    /**
     * 订单类型字符串表示
     */
    private String typeString;

    /**
     * 状态字符串表示
     */
    private String statusString;
    /**
     * 时段字符串表示
     */
    private String periodString;

    private Long periodStartTime;

    private Long periodEndTime;

    public Long getPeriodStartTime() {
        return periodStartTime;
    }


    public Long getPeriodEndTime() {
        return periodEndTime;
    }

    public String getReserveTimeString() {
        if(reserveTime != null) {
            reserveTimeString = DateUtils.formatDate(reserveTime);

            String date = DateUtils.formatDate(reserveTime);
            String startTime = "";
            String endTime = "";
            if(period == ReservePeriodEnum.MORNING.getCode()){
                startTime =  date +" "+ "06:00:00";
                endTime =  date +" " + "11:00:00";
            }else if(period == ReservePeriodEnum.NOON.getCode()){
                startTime =  date +" " + "11:00:00";
                endTime =  date +" " + "17:00:00";
            }else if(period == ReservePeriodEnum.NIGHT.getCode()){
                startTime =  date +" " + "17:00:00";
                endTime =  date +" " + "23:59:00";
            }

            try {
                periodStartTime = DateUtils.getMillis(DateUtils.parseDate(startTime, StringConstant.PATTERN_YYYYMMDDHHMMSS));
                periodEndTime = DateUtils.getMillis(DateUtils.parseDate(endTime,StringConstant.PATTERN_YYYYMMDDHHMMSS));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return reserveTimeString;
    }

    public static Integer getNowPeriod(){
        long timeMillis = System.currentTimeMillis();
        Integer nowPeriod = getNowPeriod(timeMillis, "06:00:00", "11:00:00", ReservePeriodEnum.MORNING.getCode());
        if(nowPeriod != null){
            return nowPeriod;
        }
        nowPeriod = getNowPeriod(timeMillis, "11:00:00", "17:00:00", ReservePeriodEnum.NOON.getCode());
        if(nowPeriod != null){
            return nowPeriod;
        }
        nowPeriod = getNowPeriod(timeMillis, "17:00:00", "23:00:00", ReservePeriodEnum.NIGHT.getCode());
//        if(nowPeriod != null){
            return nowPeriod;
//        }

    }

    public static Integer getNowPeriod(long timeMillis, String start, String end, Integer code){
        String nowString = DateUtils.formatDate(timeMillis);
        Long startMillis = Long.valueOf(0);
        Long endMillis = Long.valueOf(0);
        String startTime =  nowString +" "+ start;
        String endTime =  nowString +" " + end;
        try {
            startMillis = DateUtils.getMillis(DateUtils.parseDate(startTime, DateUtils.datetimeFormat.toPattern()));
            endMillis = DateUtils.getMillis(DateUtils.parseDate(endTime, DateUtils.datetimeFormat.toPattern()));
            if(timeMillis >= startMillis && timeMillis<=endMillis){
                return code;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String getTypeString() {
        return typeString;
    }

    public String getStatusString() {
        return statusString;
    }

    public String getPeriodString() {
        return periodString;
    }

    public void setReserveTimeString(String reserveTimeString) {
        this.reserveTimeString = reserveTimeString;
    }

    @EnumDescription(enumFieldName = "type",targetEnum = ReserveTypeEnum.class)
    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    @EnumDescription(enumFieldName = "status",targetEnum = ReserveStatusEnum.class)
    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    @EnumDescription(enumFieldName = "period",targetEnum = ReservePeriodEnum.class)
    public void setPeriodString(String periodString) {
        this.periodString = periodString;
    }

    public void setPeriodStartTime(Long periodStartTime) {
        this.periodStartTime = periodStartTime;
    }

    public void setPeriodEndTime(Long periodEndTime) {
        this.periodEndTime = periodEndTime;
    }
}
