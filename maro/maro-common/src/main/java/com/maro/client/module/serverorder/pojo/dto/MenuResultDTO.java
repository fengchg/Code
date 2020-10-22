package com.maro.client.module.serverorder.pojo.dto;

import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientFoodorderVO;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜肴列表返回传输对象
 * @author 冯成果
 * @date 2018-4-14
 * @since 01.00.0001
*/
public class MenuResultDTO {
    private List<MenuItemGroupResultDTO> menuItemGroupResultDTOList;
    private List<MaroClientFoodorderVO> maroClientFoodorderVOList;
    private String serverorderId;
    private MaroClientServerorderDO maroClientServerorderDO;
    private MaroShopSeatEntity maroShopSeatEntity;
    /**
     * 促销活动，买几赠几
     */
    private List<Map> salesPromotionList;

    public MaroClientServerorderDO getMaroClientServerorderDO() {
        return maroClientServerorderDO;
    }

    public void setMaroClientServerorderDO(MaroClientServerorderDO maroClientServerorderDO) {
        this.maroClientServerorderDO = maroClientServerorderDO;
    }

    public MaroShopSeatEntity getMaroShopSeatEntity() {
        return maroShopSeatEntity;
    }

    public void setMaroShopSeatEntity(MaroShopSeatEntity maroShopSeatEntity) {
        this.maroShopSeatEntity = maroShopSeatEntity;
    }

    public List<MenuItemGroupResultDTO> getMenuItemGroupResultDTOList() {
        return menuItemGroupResultDTOList;
    }

    public void setMenuItemGroupResultDTOList(List<MenuItemGroupResultDTO> menuItemGroupResultDTOList) {
        this.menuItemGroupResultDTOList = menuItemGroupResultDTOList;
    }

    public List<MaroClientFoodorderVO> getMaroClientFoodorderVOList() {
        return maroClientFoodorderVOList;
    }

    public void setMaroClientFoodorderVOList(List<MaroClientFoodorderVO> maroClientFoodorderVOList) {
        this.maroClientFoodorderVOList = maroClientFoodorderVOList;
    }

    public String getServerorderId() {
        return serverorderId;
    }

    public void setServerorderId(String serverorderId) {
        this.serverorderId = serverorderId;
    }

    public List<Map> getSalesPromotionList() {
        return salesPromotionList;
    }

    public void setSalesPromotionList(List<Map> salesPromotionList) {
        this.salesPromotionList = salesPromotionList;
    }
}
