package com.maro.client.module.serverorder.pojo.vo;

import java.util.List;

public class SeatListVO {

    private List<MaroShopSeatVO> list;
    private String typeString;
    private Integer type;


    public List<MaroShopSeatVO> getList() {
        return list;
    }

    public void setList(List<MaroShopSeatVO> list) {
        this.list = list;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
