package com.maro.client.module.serverorder.pojo.dto;

import com.maro.client.module.serverorder.pojo.vo.MaroClientFoodorderVO;
import com.maro.common.util.MapUtilWare;

import java.util.List;

/**
 * 点菜记录项返回传输对象，包括菜品类型、点餐列表记录
 * @author 冯成果
 * @date 2018-4-14
 * @since 01.00.0001
 */
public class FoodOrderItemGroupResultDTO implements MapUtilWare {
    private MaroClientFoodorderVO maroClientFoodorderVO;
    private List<MaroClientFoodorderVO> maroClientFoodorderVOList;
//    private String foodName;
    private Integer total;


    public List<MaroClientFoodorderVO> getMaroClientFoodorderVOList() {
        return maroClientFoodorderVOList;
    }

    public void setMaroClientFoodorderVOList(List<MaroClientFoodorderVO> maroClientFoodorderVOList) {
        this.maroClientFoodorderVOList = maroClientFoodorderVOList;
    }

    public MaroClientFoodorderVO getMaroClientFoodorderVO() {
        return maroClientFoodorderVO;
    }

    public void setMaroClientFoodorderVO(MaroClientFoodorderVO maroClientFoodorderVO) {
        this.maroClientFoodorderVO = maroClientFoodorderVO;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }


    @Override
    public void setValue(String key, Object value) {
        maroClientFoodorderVO = new MaroClientFoodorderVO();
        maroClientFoodorderVO.setFoodName(key);
        maroClientFoodorderVOList = (List<MaroClientFoodorderVO>) value;
    }
}
