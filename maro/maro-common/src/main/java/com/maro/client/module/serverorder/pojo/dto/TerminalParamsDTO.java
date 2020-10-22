package com.maro.client.module.serverorder.pojo.dto;
/**
 * 类的描述，包括类的作用，类是干什么用的，类什么场景什么时候使用
 * @author 冯成果
 * @date 2018-6-4
 * @since 版本号（必填）
*/
public class TerminalParamsDTO {
    private String seatCode;
    private Integer personNumber;
    private String waiterCode;
    private String terminalCode;
    private String orderCode;

    private String srcSeatCode;
    private String srcOrderCode;
    private String destSeatCode;
    private String destOrderCode;

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    public String getWaiterCode() {
        return waiterCode;
    }

    public void setWaiterCode(String waiterCode) {
        this.waiterCode = waiterCode;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public String getSrcSeatCode() {
        return srcSeatCode;
    }

    public void setSrcSeatCode(String srcSeatCode) {
        this.srcSeatCode = srcSeatCode;
    }

    public String getSrcOrderCode() {
        return srcOrderCode;
    }

    public void setSrcOrderCode(String srcOrderCode) {
        this.srcOrderCode = srcOrderCode;
    }

    public String getDestSeatCode() {
        return destSeatCode;
    }

    public void setDestSeatCode(String destSeatCode) {
        this.destSeatCode = destSeatCode;
    }

    public String getDestOrderCode() {
        return destOrderCode;
    }

    public void setDestOrderCode(String destOrderCode) {
        this.destOrderCode = destOrderCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
