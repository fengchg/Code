package com.maro.client.module.serverorder.pojo.dto;

//import com.maro.client.module.evaluate.pojo.entity.MaroClientEvaluateVO;
import com.maro.client.module.serverorder.pojo.entity.*;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺服务订单流水DTO类，聚合了店铺服务订单的主表VO和有关的子表，用来在controller、service、dao层之间进行参数和返回值传递的类
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
 */
public class ServerorderDTO implements Serializable{
    /**
     * 服务订单VO
     */
    private MaroClientServerorderDO maroClientServerorderDO;
    /**
     * 点餐记录VO
     */
    private List<MaroClientFoodorderDO> maroClientFoodOrderDOs;
    /**
     * 桌位变更VO
     */
    private List<MaroClientSeatchangeDO> maroClientSeatchangeDOs;
    /**
     * 服务订单流水日志VO
     */
    private List<MaroClientServerorderlogDO> maroClientServerorderlogDOs;
    /**
     * 服务订单支付记录VO
     */
    private List<MaroClientPayedDO> maroClientPayedDOs;
    /**
     * 服务订单评价记录VO
     */
//    private List<MaroClientEvaluateVO> maroClientEvaluateVOs;


    public MaroClientServerorderDO getMaroClientServerorderDO() {
        return maroClientServerorderDO;
    }

    public void setMaroClientServerorderDO(MaroClientServerorderDO maroClientServerorderDO) {
        this.maroClientServerorderDO = maroClientServerorderDO;
    }

    public List<MaroClientFoodorderDO> getMaroClientFoodOrderDOs() {
        return maroClientFoodOrderDOs;
    }

    public void setMaroClientFoodOrderDOs(List<MaroClientFoodorderDO> maroClientFoodOrderDOs) {
        this.maroClientFoodOrderDOs = maroClientFoodOrderDOs;
    }

    public List<MaroClientSeatchangeDO> getMaroClientSeatchangeDOs() {
        return maroClientSeatchangeDOs;
    }

    public void setMaroClientSeatchangeDOs(List<MaroClientSeatchangeDO> maroClientSeatchangeDOs) {
        this.maroClientSeatchangeDOs = maroClientSeatchangeDOs;
    }

    public List<MaroClientServerorderlogDO> getMaroClientServerorderlogDOs() {
        return maroClientServerorderlogDOs;
    }

    public void setMaroClientServerorderlogDOs(List<MaroClientServerorderlogDO> maroClientServerorderlogDOs) {
        this.maroClientServerorderlogDOs = maroClientServerorderlogDOs;
    }

    public List<MaroClientPayedDO> getMaroClientPayedDOs() {
        return maroClientPayedDOs;
    }

    public void setMaroClientPayedDOs(List<MaroClientPayedDO> maroClientPayedDOs) {
        this.maroClientPayedDOs = maroClientPayedDOs;
    }
}
