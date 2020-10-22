package com.maro.client.module.serverorder.pojo.dto;

import com.maro.manager.print.entity.SettleAccounts;
import com.maro.platform.core.util.DateUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
import java.util.Date;

public class PayedPrintResultDTO {
    private String shop;
    /**
     *收银员
     */
    private String cashier;
    /**
     * 结账时间
     */
    private String dateTime;
    /**
     * 来客
     */
    private Integer guests;
    /**
     * 流水号
     */
    private String orderNum;
    /**
     * 桌号
     */
    private String table;
    /**
     * 服务员
     */
    private String waiter;
    /**
     * 支付方式
     */
    private String payment;
    /**
     * 抹零，如果没有写入0即可
     */
    private BigDecimal odd;
    /**
     * /定金，如果没有写入0即可
     */
    private Integer deposit;
    /**
     * 折扣
     */
    private String discount;
    /**
     * 应收价格
     */
    private BigDecimal total;
    private String address;
    private String telphone;
    private String dishes;
    private BigDecimal serviceCharge;
    private String beginTime;

    public PayedPrintResultDTO(PayParamsDTO payParamsDTO, boolean isPre, SettleAccounts s){
        shop = payParamsDTO.getMaroClientServerorderDO().getRestaurantName();
        cashier = payParamsDTO.getMaroClientServerorderDO().getCashierName();
        guests = payParamsDTO.getMaroClientServerorderDO().getPersonNumber() == null ? 0 : payParamsDTO.getMaroClientServerorderDO().getPersonNumber();
        orderNum = payParamsDTO.getMaroClientServerorderDO().getCode();
        serviceCharge = payParamsDTO.getMaroClientServerorderDO().getServiceCharge();
        Long beginTime = payParamsDTO.getMaroClientServerorderDO().getBeginTime();
        table = payParamsDTO.getMaroClientServerorderDO().getSeatNameList();
        if(table != null){
            table = table.substring(1);
        }
        waiter = payParamsDTO.getMaroClientServerorderDO().getWaiterName();
        odd = payParamsDTO.getMaroClientServerorderDO().getSmallChange();
        deposit = payParamsDTO.getMaroClientServerorderDO().getPayedDeposit();
        discount = payParamsDTO.getMaroClientServerorderDO().getDiscount().doubleValue() == 1 ? "" : payParamsDTO.getMaroClientServerorderDO().getDiscount()+"";
        total = payParamsDTO.getMaroClientServerorderDO().getCollectedAmount();
        BigDecimal amount = payParamsDTO.getMaroClientServerorderDO().getAmount();
        address = payParamsDTO.getMaroShopEntity().getPosition();
        telphone = payParamsDTO.getMaroShopEntity().getPhone();
        JSONArray list = new JSONArray();
        for(int i=0;i<payParamsDTO.getMaroClientFoodorderDOList().size();i++){
            JSONObject json = new JSONObject();
            json.put("name",payParamsDTO.getMaroClientFoodorderDOList().get(i).getFoodName() + payParamsDTO.getMaroClientFoodorderDOList().get(i).getSpecificationsName());
            json.put("number",payParamsDTO.getMaroClientFoodorderDOList().get(i).getQuantity());
            json.put("price",payParamsDTO.getMaroClientFoodorderDOList().get(i).getTotalPrice());
            list.add(json);
        }
//        dishes = list.toString();
        //非预打单
		if(!isPre){
//	        StringBuffer tmpPayment = new StringBuffer();
	        Long l = payParamsDTO.getMaroClientPayedDO().getPayTime();
	        dateTime = DateUtils.formatDate(new Date(l),DateUtils.datetimeFormat.toPattern());
//	        for(int i=0;i<payParamsDTO.getMaroClientPayedDetailDOList().size();i++){
//	            MaroClientPayedDetailDO maroClientPayedDetailDO = payParamsDTO.getMaroClientPayedDetailDOList().get(i);
//	            Integer payType = maroClientPayedDetailDO.getPayType();
//	            String payTypeName = EnumUtil.getName(ServerOrderPayedTypeEnum.class, payType);
//	            tmpPayment.append(",").append(payTypeName).append(maroClientPayedDetailDO.getAmount()).append("元");
//	        }
//	        payment = tmpPayment.substring(1);
            s.setTitleName("结账单");
		}else{
            s.setTitleName("预结单");
        }
		s.setBeginTime(DateUtils.formatTime(beginTime));
		s.setBillNumber(orderNum);
		s.setCashier(cashier);
		s.setDishesList(list);
		s.setAmountDeceivable(total+"");
//		s.setMember();
//		s.setMemberTotal();
		s.setRenShu(guests);
		s.setSeatName(table);
		s.setServiceCharge(serviceCharge+"");
		s.setWaiter(waiter);
		s.setZongJie(amount+"");
		s.setSettleTime(dateTime);
    }


    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public BigDecimal getOdd() {
        return odd;
    }

    public void setOdd(BigDecimal odd) {
        this.odd = odd;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }
}
