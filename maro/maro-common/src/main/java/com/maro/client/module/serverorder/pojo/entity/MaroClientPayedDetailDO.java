package com.maro.client.module.serverorder.pojo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "maro_client_payed_detail", schema = "", catalog = "")
public class MaroClientPayedDetailDO {
    /**
     * 主键
     */
    private String id;
    /**
     * 支付方式
     */
    private Integer payType;
    /**
     * 支付终端
     */
    private Integer payTerminal;

    /**
     * 支付金额
     */
    private BigDecimal amount;
    /**
     * 服务订单主键
     */
    private String payId;

    private String remark;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @Basic
    @Column(name = "pay_type", nullable = true)
    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "pay_terminal", nullable = true)
    public Integer getPayTerminal() {
        return payTerminal;
    }

    public void setPayTerminal(Integer payTerminal) {
        this.payTerminal = payTerminal;
    }


    @Basic
    @Column(name = "amount", nullable = true, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "pay_id", nullable = true)
    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    @Basic
    @Column(name = "remark", nullable = true)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}