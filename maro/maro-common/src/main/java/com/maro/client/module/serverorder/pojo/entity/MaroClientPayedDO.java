package com.maro.client.module.serverorder.pojo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "maro_client_payed", schema = "", catalog = "")
public class MaroClientPayedDO {
    /**
     * 主键
     */
    private String id;
    /**
     * 支付时间
     */
    private Long payTime;
    /**
     * 支付方式
     */
    private Integer payType;
    /**
     * 支付终端
     */
    private Integer payTerminal;
    /**
     * 卡号
     */
    private String cardNumber;

    /**
     * 支付金额
     */
    private BigDecimal amount;
    /**
     * 服务订单主键
     */
    private String serverOrderId;

    /**
     * 抹零金额
     */
    private BigDecimal smallChange;

    /**
     * 开票金额
     */
    private BigDecimal billMoney;
    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pay_time", nullable = true)
    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
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
    @Column(name = "card_number", nullable = true, length = 20)
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
    @Column(name = "server_order_id", nullable = true)
    public String getServerOrderId() {
        return serverOrderId;
    }

    public void setServerOrderId(String serverOrderId) {
        this.serverOrderId = serverOrderId;
    }


    @Basic
    @Column(name = "small_change", nullable = true)
    public BigDecimal getSmallChange() {
        return smallChange;
    }

    public void setSmallChange(BigDecimal smallChange) {
        this.smallChange = smallChange;
    }

    @Basic
    @Column(name = "bill_money", nullable = true)
    public BigDecimal getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(BigDecimal billMoney) {
        this.billMoney = billMoney;
    }
}
