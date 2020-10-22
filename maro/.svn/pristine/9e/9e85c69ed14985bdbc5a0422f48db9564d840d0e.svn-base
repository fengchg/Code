package com.maro.client.module.reserve.pojo.entity;

import javax.persistence.*;

@Entity
@Table(name = "maro_client_reserve", schema = "", catalog = "")
public class MaroClientReserveDO {
    /**
     * 主键
     */
    protected String id;
    /**
     * 店铺主键
     */
    protected String restaurantId;
    /**
     * 店铺名称
     */
    protected String restaurantName;
    /**
     * 桌位主键
     */
    protected String destSeatId;
    /**
     * 桌位号
     */
    protected String destSeatCode;
    /**
     * 桌位名
     */
    protected String destSeatName;
    /**
     * 顾客姓名
     */
    protected String customerName;
    /**
     * 手机号码
     */
    protected String phone;
    /**
     * 就餐人数
     */
    protected Integer personNumber;
    /**
     * 预定时间
     */
    protected Long reserveTime;
    /**
     * 订单类型
     */
    protected Integer type;
    /**
     * 订金
     */
    protected Integer deposit;
    /**
     * 内容
     */
    protected String content;
    /**
     * 状态
     */
    protected Integer status;
    /**
     * 时段
     */
    protected Integer period;
    /**
     * 计划到达时间
     */
    protected Long planComeTime;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "restaurant_id", nullable = true, length = 36)
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Basic
    @Column(name = "restaurant_name", nullable = true, length = 20)
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Basic
    @Column(name = "dest_seat_id", nullable = true, length = 36)
    public String getDestSeatId() {
        return destSeatId;
    }

    public void setDestSeatId(String destSeatId) {
        this.destSeatId = destSeatId;
    }

    @Basic
    @Column(name = "dest_seat_code", nullable = true, length = 36)
    public String getDestSeatCode() {
        return destSeatCode;
    }

    public void setDestSeatCode(String destSeatCode) {
        this.destSeatCode = destSeatCode;
    }

    @Basic
    @Column(name = "dest_seat_name", nullable = true, length = 20)
    public String getDestSeatName() {
        return destSeatName;
    }

    public void setDestSeatName(String destSeatName) {
        this.destSeatName = destSeatName;
    }

    @Basic
    @Column(name = "customer_name", nullable = true, length = 20)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "person_number", nullable = true)
    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    @Basic
    @Column(name = "reserve_time", nullable = true)
    public Long getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Long reserveTime) {
        this.reserveTime = reserveTime;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "deposit", nullable = true, precision = 0)
    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 1000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "period", nullable = true)
    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Basic
    @Column(name = "plan_come_time", nullable = true)
    public Long getPlanComeTime() {
        return planComeTime;
    }

    public void setPlanComeTime(Long planComeTime) {
        this.planComeTime = planComeTime;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaroClientReserveDO that = (MaroClientReserveDO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (restaurantId != null ? !restaurantId.equals(that.restaurantId) : that.restaurantId != null) return false;
        if (restaurantName != null ? !restaurantName.equals(that.restaurantName) : that.restaurantName != null)
            return false;
        if (destSeatId != null ? !destSeatId.equals(that.destSeatId) : that.destSeatId != null) return false;
        if (destSeatCode != null ? !destSeatCode.equals(that.destSeatCode) : that.destSeatCode != null) return false;
        if (destSeatName != null ? !destSeatName.equals(that.destSeatName) : that.destSeatName != null) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (personNumber != null ? !personNumber.equals(that.personNumber) : that.personNumber != null) return false;
        if (reserveTime != null ? !reserveTime.equals(that.reserveTime) : that.reserveTime != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (deposit != null ? !deposit.equals(that.deposit) : that.deposit != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (restaurantName != null ? restaurantName.hashCode() : 0);
        result = 31 * result + (destSeatId != null ? destSeatId.hashCode() : 0);
        result = 31 * result + (destSeatCode != null ? destSeatCode.hashCode() : 0);
        result = 31 * result + (destSeatName != null ? destSeatName.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (personNumber != null ? personNumber.hashCode() : 0);
        result = 31 * result + (reserveTime != null ? reserveTime.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (period != null ? period.hashCode() : 0);
        return result;
    }
}
