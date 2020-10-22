package com.maro.client.module.reserve.pojo.dto;

import com.maro.client.module.reserve.pojo.entity.MaroClientReserveDO;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;

/**
 * 预定传输参数
 * @author 冯成果
 * @date 2018-4-14
 * @since 版本号（必填）
*/
public class ReserveParamsDTO {
    /**
     * 桌号主键
     */
    private String seatId;
    /**
     * 预定时间
     */
    private Long date;


    /**
     * 用餐人数
     */
    private Integer total;
    /**
     * 预定人手机号码
     */
    private String phone;
    /**
     * 预定人
     */
    private String  name;
    /**
     * 用途
     */
    private Integer purpose;
    /**
     * 定金
     */
    private Integer deposit;
    /**
     * 备注
     */
    private String remarks;

    /**
     * 预定时段
     */
    private Integer period;

    /**
     * 计划到达时间
     */
    protected Long planComeTime;

    /**
     * 预定记录信息
     */
    private MaroClientReserveDO maroClientReserveDO;
    /**
     * 桌位信息
     */
    private  MaroShopSeatEntity maroShopSeatEntity;

    public MaroClientReserveDO getMaroClientReserveDO() {
        return maroClientReserveDO;
    }

    public void setMaroClientReserveDO(MaroClientReserveDO maroClientReserveDO) {
        this.maroClientReserveDO = maroClientReserveDO;
    }

    public MaroShopSeatEntity getMaroShopSeatEntity() {
        return maroShopSeatEntity;
    }

    public void setMaroShopSeatEntity(MaroShopSeatEntity maroShopSeatEntity) {
        this.maroShopSeatEntity = maroShopSeatEntity;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPurpose() {
        return purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Long getPlanComeTime() {
        return planComeTime;
    }

    public void setPlanComeTime(Long planComeTime) {
        this.planComeTime = planComeTime;
    }
}
