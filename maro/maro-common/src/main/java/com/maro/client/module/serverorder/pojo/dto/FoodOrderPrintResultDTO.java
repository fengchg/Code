package com.maro.client.module.serverorder.pojo.dto;

import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;
import com.maro.platform.core.util.DateUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Date;
import java.util.List;

public class FoodOrderPrintResultDTO {
    private String dateTime;
    private Integer guests;
    private String orderNum;
    private String table;
    private String waiter;
    private String remark;
    private String dishes;

    public FoodOrderPrintResultDTO(FoodOrderParamsDTO foodOrderParamsDTO){
        Long l = foodOrderParamsDTO.getMaroClientFoodorderDOList().get(0).getCreateTime();
        dateTime = DateUtils.formatDate(new Date(l),DateUtils.datetimeFormat.toPattern());
        guests = foodOrderParamsDTO.getMaroClientServerorderDO().getPersonNumber();
        orderNum =  foodOrderParamsDTO.getMaroClientServerorderDO().getCode();
        table = foodOrderParamsDTO.getMaroShopSeatEntity().getName();
        waiter = foodOrderParamsDTO.getMaroClientServerorderDO().getWaiterName();
//        StringBuffer tmpRemark = new StringBuffer();
//        for(int i=0;i<foodOrderParamsDTO.getMaroClientFoodorderDOList().size();i++){
//            MaroClientFoodorderDO foodorderDO = foodOrderParamsDTO.getMaroClientFoodorderDOList().get(i);
//            if(foodorderDO.getRemark() != null && !foodorderDO.getRemark().isEmpty()) {
//                tmpRemark.append(",").append(foodorderDO.getFoodName()).append(foodorderDO.getSpecificationsName()).append("(").append(foodorderDO.getRemark()).append(")");
//            }
//        }
//        if(tmpRemark.length() > 0) {
//            remark = tmpRemark.substring(1);
//        }
        remark = foodOrderParamsDTO.getMaroClientServerorderDO().getRemark() == null ? "" : foodOrderParamsDTO.getMaroClientServerorderDO().getRemark();
        List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
        JSONArray list = new JSONArray();
        for(int i=0;i<maroClientFoodorderDOList.size();i++){
            JSONObject json = new JSONObject();
            json.put("name",maroClientFoodorderDOList.get(i).getFoodName() + maroClientFoodorderDOList.get(i).getSpecificationsName());
            json.put("number",maroClientFoodorderDOList.get(i).getQuantity());
            list.add(json);
        }
        dishes = list.toString();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }
}
