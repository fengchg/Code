package com.maro.client.module.reserve.pojo.entity;

import javax.persistence.*;

/**
 * 预定座位记录DO
 * @author 冯成果
 * @date 2018-4-2
 * @since 01.00.0001
*/
@Entity
@Table(name = "maro_client_reserve_seat", schema = "", catalog = "")
public class MaroClientReserveSeatDO {
    /**
     * 主键
     */
    protected String id;
    /**
     * 订单类型
     * @see com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum
     */
    protected Integer type;
    /**
     * 名称
     */
    protected String name;
    /**
     * 发生时间
     */
    protected Long happenTime;
    /**
     * 桌位主键
     */
    protected String destSeatId;
    /**
     * 目标桌位号
     */
    protected String destSeatCode;
    /**
     * 目标桌位名
     */
    protected String destSeatName;
    /**
     * 服务订单主键
     */
    protected String reserveId;

    /**
     * 删除标识

     */
    protected Integer deleteFlag;


    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "name", nullable = true, length = 5)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "happen_time", nullable = true)
    public Long getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Long happenTime) {
        this.happenTime = happenTime;
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
    @Column(name = "dest_seat_code", nullable = true, length = 10)
    public String getDestSeatCode() {
        return destSeatCode;
    }

    public void setDestSeatCode(String destSeatCode) {
        this.destSeatCode = destSeatCode;
    }

    @Basic
    @Column(name = "dest_seat_name", nullable = true, length = 10)
    public String getDestSeatName() {
        return destSeatName;
    }

    public void setDestSeatName(String destSeatName) {
        this.destSeatName = destSeatName;
    }

    @Basic
    @Column(name = "reserve_id", nullable = false)
    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }

    @Basic
    @Column(name = "delete_flag",nullable=false, columnDefinition="int default 0")
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaroClientReserveSeatDO that = (MaroClientReserveSeatDO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (happenTime != null ? !happenTime.equals(that.happenTime) : that.happenTime != null) return false;
        if (destSeatId != null ? !destSeatId.equals(that.destSeatId) : that.destSeatId != null) return false;
        if (destSeatCode != null ? !destSeatCode.equals(that.destSeatCode) : that.destSeatCode != null) return false;
        if (destSeatName != null ? !destSeatName.equals(that.destSeatName) : that.destSeatName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (happenTime != null ? happenTime.hashCode() : 0);
        result = 31 * result + (destSeatId != null ? destSeatId.hashCode() : 0);
        result = 31 * result + (destSeatCode != null ? destSeatCode.hashCode() : 0);
        result = 31 * result + (destSeatName != null ? destSeatName.hashCode() : 0);
        return result;
    }
}
