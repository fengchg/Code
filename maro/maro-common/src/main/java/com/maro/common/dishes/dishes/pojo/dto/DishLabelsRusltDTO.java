package com.maro.common.dishes.dishes.pojo.dto;

import java.util.List;
import java.util.Map;

public class DishLabelsRusltDTO {
    private String labelCode;
    private String labelName;
    private List<Map<String,Object>> maroDishesEntityList;

    public String getLabelCode() {
        return labelCode;
    }

    public void setLabelCode(String labelCode) {
        this.labelCode = labelCode;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public List<Map<String,Object>> getMaroDishesEntityList() {
        return maroDishesEntityList;
    }

    public void setMaroDishesEntityList(List<Map<String,Object>> maroDishesEntityList) {
        this.maroDishesEntityList = maroDishesEntityList;
    }
}
