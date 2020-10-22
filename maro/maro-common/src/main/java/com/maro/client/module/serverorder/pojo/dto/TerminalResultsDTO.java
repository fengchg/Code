package com.maro.client.module.serverorder.pojo.dto;

import com.maro.common.dishes.dishes.pojo.dto.DishLabelsRusltDTO;

import java.util.List;
import java.util.Map;

public class TerminalResultsDTO {
    private List<Map<String,Object>> maroShopSeatEntities;
    private List<Map<String,Object>> dishesList;
    //private List<Map<String,Object>> maroDishesClassificationEntityList;
    //private List<Map<String,Object>> maroShopSeatEntitieList;
    //private List<Map<String,Object>> maroDishesSpecificationsEntityList;
    private  List<Map<String,Object>> dishesLabelList;

    private List<Map<String,Object>> dishesClassificationList;

    private List<DishLabelsRusltDTO> dishLabelsRusltList;
    private List<Map<String,Object>> markWayList;
    private List<Map<String,Object>> terminalMessageTemplateList;
    private List<Map<String,Object>> dishesRetireReasonList;

    private Map<String,Object> shopMap;

    public Map<String, Object> getShopMap() {
        return shopMap;
    }

    public void setShopMap(Map<String, Object> shopMap) {
        this.shopMap = shopMap;
    }

    public List<Map<String, Object>> getDishesRetireReasonList() {
        return dishesRetireReasonList;
    }

    public void setDishesRetireReasonList(List<Map<String, Object>> dishesRetireReasonList) {
        this.dishesRetireReasonList = dishesRetireReasonList;
    }

    public List<Map<String, Object>> getTerminalMessageTemplateList() {
        return terminalMessageTemplateList;
    }

    public void setTerminalMessageTemplateList(List<Map<String, Object>> terminalMessageTemplateList) {
        this.terminalMessageTemplateList = terminalMessageTemplateList;
    }

    public List<Map<String, Object>> getMarkWayList() {
        return markWayList;
    }

    public void setMarkWayList(List<Map<String, Object>> markWayList) {
        this.markWayList = markWayList;
    }

    public List<DishLabelsRusltDTO> getDishLabelsRusltList() {
        return dishLabelsRusltList;
    }

    public void setDishLabelsRusltList(List<DishLabelsRusltDTO> dishLabelsRusltList) {
        this.dishLabelsRusltList = dishLabelsRusltList;
    }

    public List<Map<String, Object>> getDishesLabelList() {
        return dishesLabelList;
    }

    public void setDishesLabelList(List<Map<String, Object>> dishesLabelList) {
        this.dishesLabelList = dishesLabelList;
    }

    public List<Map<String, Object>> getMaroShopSeatEntities() {
        return maroShopSeatEntities;
    }

    public void setMaroShopSeatEntities(List<Map<String, Object>> maroShopSeatEntities) {
        this.maroShopSeatEntities = maroShopSeatEntities;
    }

    public List<Map<String, Object>> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<Map<String, Object>> dishesList) {
        this.dishesList = dishesList;
    }

   /* public List<Map<String, Object>> getMaroDishesClassificationEntityList() {
        return maroDishesClassificationEntityList;
    }

    public void setMaroDishesClassificationEntityList(List<Map<String, Object>> maroDishesClassificationEntityList) {
        this.maroDishesClassificationEntityList = maroDishesClassificationEntityList;
    }*/

   /* public List<Map<String, Object>> getMaroShopSeatEntitieList() {
        return maroShopSeatEntitieList;
    }

    public void setMaroShopSeatEntitieList(List<Map<String, Object>> maroShopSeatEntitieList) {
        this.maroShopSeatEntitieList = maroShopSeatEntitieList;
    }*/

   /* public List<Map<String, Object>> getMaroDishesSpecificationsEntityList() {
        return maroDishesSpecificationsEntityList;
    }

    public void setMaroDishesSpecificationsEntityList(List<Map<String, Object>> maroDishesSpecificationsEntityList) {
        this.maroDishesSpecificationsEntityList = maroDishesSpecificationsEntityList;
    }*/

    public List<Map<String, Object>> getDishesClassificationList() {
        return dishesClassificationList;
    }

    public void setDishesClassificationList(List<Map<String, Object>> dishesClassificationList) {
        this.dishesClassificationList = dishesClassificationList;
    }
}
