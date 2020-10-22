package com.maro.client.module.serverorder.pojo.entity;

import javax.persistence.*;

/**
 * 座位调整记录DO
 * @author 冯成果
 * @date 2018-4-2
 * @since 01.00.0001
*/
@Entity
@Table(name = "maro_client_seatchange", schema = "", catalog = "")
public class MaroClientSeatchangeDO {
    /**
     * 主键
     */
    private String id;
    /**
     * 订单类型
     * @see com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum
     */
    private Integer type;
    /**
     * 名称
     */
    private String name;
    /**
     * 发生时间
     */
    private Long happenTime;
    /**
     * 源桌位主键
     */
    private String srcSeatId;
    /**
     * 桌位号
     */
    private String srcSeatCode;
    /**
     * 桌位名
     */
    private String srcSeatName;
    /**
     * 桌位主键
     */
    private String destSeatId;
    /**
     * 目标桌位号
     */
    private String destSeatCode;
    /**
     * 目标桌位名
     */
    private String destSeatName;
    /**
     * 服务订单主键
     */
    private String serverOrderId;

    /**
     * 删除标识

     */
    private Integer deleteFlag;


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
    @Column(name = "src_seat_id", nullable = true, length = 36)
    public String getSrcSeatId() {
        return srcSeatId;
    }

    public void setSrcSeatId(String srcSeatId) {
        this.srcSeatId = srcSeatId;
    }

    @Basic
    @Column(name = "src_seat_code", nullable = true, length = 5)
    public String getSrcSeatCode() {
        return srcSeatCode;
    }

    public void setSrcSeatCode(String srcSeatCode) {
        this.srcSeatCode = srcSeatCode;
    }

    @Basic
    @Column(name = "src_seat_name", nullable = true, length = 20)
    public String getSrcSeatName() {
        return srcSeatName;
    }

    public void setSrcSeatName(String srcSeatName) {
        this.srcSeatName = srcSeatName;
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
    @Column(name = "server_order_id", nullable = true)
    public String getServerOrderId() {
        return serverOrderId;
    }

    public void setServerOrderId(String serverOrderId) {
        this.serverOrderId = serverOrderId;
    }

    @Basic
    @Column(name = "delete_flag",nullable=false, columnDefinition="int default 0")
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }


}
