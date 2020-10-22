package com.maro.client.module.serverorder.pojo.dto;

import java.util.List;

public class MenuItemGroupResultDTO {
    private String type;
    private String typeString;
    private List<MenuItemResultDTO> menuItemResultDTOList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public List<MenuItemResultDTO> getMenuItemResultDTOList() {
        return menuItemResultDTOList;
    }

    public void setMenuItemResultDTOList(List<MenuItemResultDTO> menuItemResultDTOList) {
        this.menuItemResultDTOList = menuItemResultDTOList;
    }
}
